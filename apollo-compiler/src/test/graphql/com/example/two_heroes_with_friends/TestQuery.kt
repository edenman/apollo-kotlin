// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.two_heroes_with_friends

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
import com.example.two_heroes_with_friends.type.CustomType
import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import okio.Buffer
import okio.BufferedSource
import okio.ByteString
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
class TestQuery : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
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

  /**
   * A character from the Star Wars universe
   */
  data class Node(
    val __typename: String = "Character",
    /**
     * The name of the character
     */
    val name: String
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Node.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@Node.name)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Node = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        Node(
          __typename = __typename,
          name = name
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Node> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * An edge object for a character's friends
   */
  data class Edge(
    val __typename: String = "FriendsEdge",
    /**
     * The character represented by this friendship edge
     */
    val node: Node?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Edge.__typename)
      writer.writeObject(RESPONSE_FIELDS[1], this@Edge.node?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forObject("node", "node", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Edge = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val node = readObject<Node>(RESPONSE_FIELDS[1]) { reader ->
          Node(reader)
        }
        Edge(
          __typename = __typename,
          node = node
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Edge> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A connection object for a character's friends
   */
  data class FriendsConnection(
    val __typename: String = "FriendsConnection",
    /**
     * The total number of friends
     */
    val totalCount: Int?,
    /**
     * The edges for each of the character's friends.
     */
    val edges: List<Edge?>?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@FriendsConnection.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], this@FriendsConnection.totalCount)
      writer.writeList(RESPONSE_FIELDS[2], this@FriendsConnection.edges) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
    }

    fun edgesFilterNotNull(): List<Edge>? = edges?.filterNotNull()

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forInt("totalCount", "totalCount", null, true, null),
          ResponseField.forList("edges", "edges", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): FriendsConnection = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val totalCount = readInt(RESPONSE_FIELDS[1])
        val edges = readList<Edge>(RESPONSE_FIELDS[2]) { reader ->
          reader.readObject<Edge> { reader ->
            Edge(reader)
          }
        }
        FriendsConnection(
          __typename = __typename,
          totalCount = totalCount,
          edges = edges
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<FriendsConnection> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  data class R2(
    val __typename: String = "Character",
    /**
     * The name of the character
     */
    val name: String,
    /**
     * The friends of the character exposed as a connection with edges
     */
    val friendsConnection: FriendsConnection
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@R2.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@R2.name)
      writer.writeObject(RESPONSE_FIELDS[2], this@R2.friendsConnection.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forObject("friendsConnection", "friendsConnection", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): R2 = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        val friendsConnection = readObject<FriendsConnection>(RESPONSE_FIELDS[2]) { reader ->
          FriendsConnection(reader)
        }!!
        R2(
          __typename = __typename,
          name = name,
          friendsConnection = friendsConnection
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<R2> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  data class Node1(
    val __typename: String = "Character",
    /**
     * The name of the character
     */
    val name: String
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Node1.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@Node1.name)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Node1 = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])!!
        Node1(
          __typename = __typename,
          name = name
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Node1> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * An edge object for a character's friends
   */
  data class Edge1(
    val __typename: String = "FriendsEdge",
    /**
     * The character represented by this friendship edge
     */
    val node: Node1?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Edge1.__typename)
      writer.writeObject(RESPONSE_FIELDS[1], this@Edge1.node?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forObject("node", "node", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Edge1 = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val node = readObject<Node1>(RESPONSE_FIELDS[1]) { reader ->
          Node1(reader)
        }
        Edge1(
          __typename = __typename,
          node = node
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Edge1> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A connection object for a character's friends
   */
  data class FriendsConnection1(
    val __typename: String = "FriendsConnection",
    /**
     * The total number of friends
     */
    val totalCount: Int?,
    /**
     * The edges for each of the character's friends.
     */
    val edges: List<Edge1?>?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@FriendsConnection1.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], this@FriendsConnection1.totalCount)
      writer.writeList(RESPONSE_FIELDS[2], this@FriendsConnection1.edges) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
    }

    fun edgesFilterNotNull(): List<Edge1>? = edges?.filterNotNull()

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forInt("totalCount", "totalCount", null, true, null),
          ResponseField.forList("edges", "edges", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): FriendsConnection1 = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val totalCount = readInt(RESPONSE_FIELDS[1])
        val edges = readList<Edge1>(RESPONSE_FIELDS[2]) { reader ->
          reader.readObject<Edge1> { reader ->
            Edge1(reader)
          }
        }
        FriendsConnection1(
          __typename = __typename,
          totalCount = totalCount,
          edges = edges
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<FriendsConnection1> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  data class Luke(
    val __typename: String = "Character",
    /**
     * The ID of the character
     */
    val id: String,
    /**
     * The name of the character
     */
    val name: String,
    /**
     * The friends of the character exposed as a connection with edges
     */
    val friendsConnection: FriendsConnection1
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Luke.__typename)
      writer.writeCustom(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField, this@Luke.id)
      writer.writeString(RESPONSE_FIELDS[2], this@Luke.name)
      writer.writeObject(RESPONSE_FIELDS[3], this@Luke.friendsConnection.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forCustomType("id", "id", null, false, CustomType.ID, null),
          ResponseField.forString("name", "name", null, false, null),
          ResponseField.forObject("friendsConnection", "friendsConnection", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): Luke = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val id = readCustomType<String>(RESPONSE_FIELDS[1] as ResponseField.CustomTypeField)!!
        val name = readString(RESPONSE_FIELDS[2])!!
        val friendsConnection = readObject<FriendsConnection1>(RESPONSE_FIELDS[3]) { reader ->
          FriendsConnection1(reader)
        }!!
        Luke(
          __typename = __typename,
          id = id,
          name = name,
          friendsConnection = friendsConnection
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Luke> = ResponseFieldMapper { invoke(it) }
    }
  }

  /**
   * Data from the response after executing this GraphQL operation
   */
  data class Data(
    val r2: R2?,
    val luke: Luke?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.r2?.marshaller())
      writer.writeObject(RESPONSE_FIELDS[1], this@Data.luke?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("r2", "hero", null, true, null),
          ResponseField.forObject("luke", "hero", mapOf<String, Any?>(
            "episode" to "EMPIRE"), true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val r2 = readObject<R2>(RESPONSE_FIELDS[0]) { reader ->
          R2(reader)
        }
        val luke = readObject<Luke>(RESPONSE_FIELDS[1]) { reader ->
          Luke(reader)
        }
        Data(
          r2 = r2,
          luke = luke
        )
      }

      @Suppress("FunctionName")
      fun Mapper(): ResponseFieldMapper<Data> = ResponseFieldMapper { invoke(it) }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "21133941aec3d5db7db82cc2688faa410a90b34e7cb283efa038fe67526b6b4b"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  r2: hero {
          |    __typename
          |    name
          |    friendsConnection {
          |      __typename
          |      totalCount
          |      edges {
          |        __typename
          |        node {
          |          __typename
          |          name
          |        }
          |      }
          |    }
          |  }
          |  luke: hero(episode: EMPIRE) {
          |    __typename
          |    id
          |    name
          |    friendsConnection {
          |      __typename
          |      totalCount
          |      edges {
          |        __typename
          |        node {
          |          __typename
          |          name
          |        }
          |      }
          |    }
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestQuery"
    }
  }
}