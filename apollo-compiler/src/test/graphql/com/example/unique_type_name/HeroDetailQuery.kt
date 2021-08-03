// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.unique_type_name

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.OperationRequestBodyComposer
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import com.example.unique_type_name.fragment.HeroDetails
import com.example.unique_type_name.type.Episode
import kotlin.Array
import kotlin.Boolean
import kotlin.Double
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
class HeroDetailQuery : Query<HeroDetailQuery.Data, HeroDetailQuery.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = parse(Buffer().write(byteString), scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  @Throws(IOException::class)
  override fun parse(byteString: ByteString): Response<Data> = parse(byteString, DEFAULT)

  override fun composeRequestBody(scalarTypeAdapters: ScalarTypeAdapters): ByteString =
      OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = scalarTypeAdapters
  )

  override fun composeRequestBody(): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = false,
    withQueryDocument = true,
    scalarTypeAdapters = DEFAULT
  )

  override fun composeRequestBody(
    autoPersistQueries: Boolean,
    withQueryDocument: Boolean,
    scalarTypeAdapters: ScalarTypeAdapters
  ): ByteString = OperationRequestBodyComposer.compose(
    operation = this,
    autoPersistQueries = autoPersistQueries,
    withQueryDocument = withQueryDocument,
    scalarTypeAdapters = scalarTypeAdapters
  )

  interface HeroDetailQueryCharacter {
    fun marshaller(): ResponseFieldMarshaller
  }

  /**
   * A character from the Star Wars universe
   */
  data class Friend1(
    val __typename: String = "Character",
    val fragments: Fragments
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Friend1.__typename)
      this@Friend1.fragments.marshaller().marshal(writer)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("__typename", "__typename", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Friend1 = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val fragments = Fragments(reader)
        Friend1(
          __typename = __typename,
          fragments = fragments
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Friend1> = ResponseFieldMapper { invoke(it) }
    }

    data class Fragments(
      val heroDetails: HeroDetails
    ) {
      fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
        writer.writeFragment(this@Fragments.heroDetails.marshaller())
      }

      companion object {
        private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
            ResponseField.forFragment("__typename", "__typename", null)
            )

        operator fun invoke(reader: ResponseReader): Fragments = reader.run {
          val heroDetails = readFragment<HeroDetails>(RESPONSE_FIELDS[0]) { reader ->
            HeroDetails(reader)
          }!!
          Fragments(
            heroDetails = heroDetails
          )
        }

        @Suppress("FunctionName")
        fun Mapper(): ResponseFieldMapper<Fragments> = ResponseFieldMapper { invoke(it) }
      }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  data class Friend(
    val __typename: String = "Character",
    /**
     * The name of the character
     */
    val name: String,
    /**
     * The movies this character appears in
     */
    val appearsIn: List<Episode?>,
    /**
     * The friends of the character, or an empty list if they have none
     */
    val friends: List<Friend1?>?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Friend.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@Friend.name)
      writer.writeList(RESPONSE_FIELDS[2], this@Friend.appearsIn) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeString(value?.rawValue)}
      }
      writer.writeList(RESPONSE_FIELDS[3], this@Friend.friends) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
    }

    fun appearsInFilterNotNull(): List<Episode> = appearsIn.filterNotNull()

    fun friendsFilterNotNull(): List<Friend1>? = friends?.filterNotNull()

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forList("appearsIn", "appearsIn", null, false, null),
          ResponseField.forList("friends", "friends", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Friend = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        val appearsIn = readList<Episode>(RESPONSE_FIELDS[2]) { reader ->
          Episode.safeValueOf(reader.readString())
        }!!
        val friends = readList<Friend1>(RESPONSE_FIELDS[3]) { reader ->
          reader.readObject<Friend1> { reader ->
            Friend1(reader)
          }
        }
        Friend(
          __typename = __typename,
          name = name,
          appearsIn = appearsIn,
          friends = friends
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Friend> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A humanoid creature from the Star Wars universe
   */
  data class AsHuman(
    val __typename: String = "Human",
    /**
     * What this human calls themselves
     */
    val name: String,
    /**
     * This human's friends, or an empty list if they have none
     */
    val friends: List<Friend?>?,
    /**
     * Height in the preferred unit, default is meters
     */
    val height: Double?
  ) : HeroDetailQueryCharacter {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@AsHuman.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@AsHuman.name)
      writer.writeList(RESPONSE_FIELDS[2], this@AsHuman.friends) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
      writer.writeDouble(RESPONSE_FIELDS[3], this@AsHuman.height)
    }

    fun friendsFilterNotNull(): List<Friend>? = friends?.filterNotNull()

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forList("friends", "friends", null, true, null),
          ResponseField.forDouble("height", "height", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): AsHuman = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        val friends = readList<Friend>(RESPONSE_FIELDS[2]) { reader ->
          reader.readObject<Friend> { reader ->
            Friend(reader)
          }
        }
        val height = readDouble(RESPONSE_FIELDS[3])
        AsHuman(
          __typename = __typename,
          name = name,
          friends = friends,
          height = height
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<AsHuman> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  data class Friend2(
    val __typename: String = "Character",
    /**
     * The name of the character
     */
    val name: String
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Friend2.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@Friend2.name)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Friend2 = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        Friend2(
          __typename = __typename,
          name = name
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Friend2> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  data class HeroDetailQuery(
    val __typename: String = "Character",
    /**
     * The name of the character
     */
    val name: String,
    /**
     * The friends of the character, or an empty list if they have none
     */
    val friends: List<Friend2?>?,
    val asHuman: AsHuman?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@HeroDetailQuery.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@HeroDetailQuery.name)
      writer.writeList(RESPONSE_FIELDS[2], this@HeroDetailQuery.friends) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
      writer.writeFragment(this@HeroDetailQuery.asHuman?.marshaller())
    }

    fun friendsFilterNotNull(): List<Friend2>? = friends?.filterNotNull()

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forList("friends", "friends", null, true, null),
          ResponseField.forFragment("__typename", "__typename", listOf(
            ResponseField.Condition.typeCondition(arrayOf("Human"))
          ))
          )

      operator fun invoke(reader: ResponseReader): HeroDetailQuery = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        val friends = readList<Friend2>(RESPONSE_FIELDS[2]) { reader ->
          reader.readObject<Friend2> { reader ->
            Friend2(reader)
          }
        }
        val asHuman = readFragment<AsHuman>(RESPONSE_FIELDS[3]) { reader ->
          AsHuman(reader)
        }
        HeroDetailQuery(
          __typename = __typename,
          name = name,
          friends = friends,
          asHuman = asHuman
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<HeroDetailQuery> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * Data from the response after executing this GraphQL operation
   */
  data class Data(
    val heroDetailQuery: HeroDetailQuery?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.heroDetailQuery?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("heroDetailQuery", "heroDetailQuery", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val heroDetailQuery = readObject<HeroDetailQuery>(RESPONSE_FIELDS[0]) { reader ->
          HeroDetailQuery(reader)
        }
        Data(
          heroDetailQuery = heroDetailQuery
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "11473383397766137d7923128dd8cd6f27fcab32df9d9c091f08cf12a893a556"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query HeroDetailQuery {
          |  heroDetailQuery {
          |    __typename
          |    name
          |    friends {
          |      __typename
          |      name
          |    }
          |    ... on Human {
          |      height
          |      friends {
          |        __typename
          |        appearsIn
          |        friends {
          |          __typename
          |          ...HeroDetails
          |        }
          |      }
          |    }
          |  }
          |}
          |fragment HeroDetails on Character {
          |  __typename
          |  name
          |  friendsConnection {
          |    __typename
          |    totalCount
          |    edges {
          |      __typename
          |      node {
          |        __typename
          |        name
          |      }
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "HeroDetailQuery"
    }
  }
}