package com.apollographql.apollo3.gradle.internal

import com.apollographql.apollo3.compiler.ApolloCompiler
import com.apollographql.apollo3.compiler.toCodegenSchema
import com.apollographql.apollo3.compiler.toIrOperations
import com.apollographql.apollo3.compiler.toIrOptions
import com.apollographql.apollo3.compiler.writeTo
import com.apollographql.apollo3.gradle.internal.ApolloGenerateSourcesFromIrTask.Companion.findCodegenSchemaFile
import org.gradle.api.DefaultTask
import org.gradle.api.file.ConfigurableFileCollection
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.tasks.Classpath
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.InputFiles
import org.gradle.api.tasks.OutputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.workers.WorkAction
import org.gradle.workers.WorkParameters
import org.gradle.workers.WorkerExecutor
import java.io.File
import javax.inject.Inject

abstract class ApolloGenerateIrOperationsTask: DefaultTask() {
  @get:InputFiles
  @get:PathSensitive(PathSensitivity.RELATIVE)
  abstract val codegenSchemaFiles: ConfigurableFileCollection

  @get:InputFiles
  @get:PathSensitive(PathSensitivity.RELATIVE)
  abstract val graphqlFiles: ConfigurableFileCollection

  @get:InputFiles
  @get:PathSensitive(PathSensitivity.RELATIVE)
  abstract val upstreamIrFiles: ConfigurableFileCollection

  @get:InputFile
  @get:PathSensitive(PathSensitivity.RELATIVE)
  abstract val irOptionsFile: RegularFileProperty

  @get:OutputFile
  abstract val irOperationsFile: RegularFileProperty

  @get:Classpath
  abstract val classpath: ConfigurableFileCollection

  @Inject
  abstract fun getWorkerExecutor(): WorkerExecutor

  @TaskAction
  fun taskAction() {

    val workQueue = getWorkerExecutor().classLoaderIsolation { workerSpec ->
      workerSpec.classpath.from(classpath)
    }

    workQueue.submit(GenerateIrOperations::class.java) {
      it.codegenSchemaFiles = codegenSchemaFiles.isolate()
      it.graphqlFiles = graphqlFiles.isolate()
      it.upstreamIrFiles = upstreamIrFiles.isolate()
      it.irOptionsFile.set(irOptionsFile)
      it.irOperationsFile.set(irOperationsFile)
    }
  }
}

private abstract class GenerateIrOperations : WorkAction<GenerateIrOperationsParameters> {
  override fun execute() {
    with(parameters) {
      val upstreamIrOperations = upstreamIrFiles.toInputFiles().map { it.file.toIrOperations() }
      val plugin = apolloCompilerPlugin()

      ApolloCompiler.buildIrOperations(
          executableFiles = graphqlFiles.toInputFiles(),
          codegenSchema = codegenSchemaFiles.toInputFiles().map { it.file }.findCodegenSchemaFile().toCodegenSchema(),
          upstreamCodegenModels = upstreamIrOperations.map { it.codegenModels },
          upstreamFragmentDefinitions = upstreamIrOperations.flatMap { it.fragmentDefinitions },
          documentTransform = plugin?.documentTransform(),
          options = irOptionsFile.get().asFile.toIrOptions(),
          logger = logger(),
      ).writeTo(irOperationsFile.get().asFile)
    }
  }
}
private interface GenerateIrOperationsParameters : WorkParameters {
  var codegenSchemaFiles: List<Pair<String, File>>
  var graphqlFiles: List<Pair<String, File>>
  var upstreamIrFiles: List<Pair<String, File>>
  val irOptionsFile: RegularFileProperty
  val irOperationsFile: RegularFileProperty
}
