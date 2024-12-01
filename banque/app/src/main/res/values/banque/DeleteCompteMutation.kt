//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package values.banque

import com.apollographql.apollo3.annotations.ApolloAdaptableWith
import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.Mutation
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.obj
import kotlin.String
import kotlin.Unit
import ma.ensa.banque.adapter.DeleteCompteMutation_ResponseAdapter
import ma.ensa.banque.adapter.DeleteCompteMutation_VariablesAdapter
import ma.ensa.banque.selections.DeleteCompteMutationSelections

public data class DeleteCompteMutation(
  public val id: String,
) : Mutation<values.banque.DeleteCompteMutation.Data> {
  public override fun id(): String =
      _root_ide_package_.values.banque.DeleteCompteMutation.Companion.OPERATION_ID

  public override fun document(): String =
      _root_ide_package_.values.banque.DeleteCompteMutation.Companion.OPERATION_DOCUMENT

  public override fun name(): String =
      _root_ide_package_.values.banque.DeleteCompteMutation.Companion.OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    DeleteCompteMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<_root_ide_package_.values.banque.DeleteCompteMutation.Data> = DeleteCompteMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = ma.ensa.banque.type.Mutation.type
  )
  .selections(selections = DeleteCompteMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(DeleteCompteMutation_ResponseAdapter.Data::class)
  public data class Data(
      public val deleteCompte: _root_ide_package_.values.banque.DeleteCompteMutation.DeleteCompte?,
  ) : Mutation.Data

  public data class DeleteCompte(
    public val id: String?,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "67933c679e241e1b7d2f18f31425cc828afb29f89cc7c6f8658933984037daad"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation DeleteCompte($id: ID!) {
     *   deleteCompte(id: $id) {
     *     id
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() = "mutation DeleteCompte(${'$'}id: ID!) { deleteCompte(id: ${'$'}id) { id } }"

    public const val OPERATION_NAME: String = "DeleteCompte"
  }
}
