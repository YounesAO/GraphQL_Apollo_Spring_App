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
import kotlin.Double
import kotlin.String
import kotlin.Unit
import ma.ensa.banque.adapter.SaveCompteMutation_ResponseAdapter
import ma.ensa.banque.adapter.SaveCompteMutation_VariablesAdapter
import ma.ensa.banque.selections.SaveCompteMutationSelections
import ma.ensa.banque.type.CompteRequest
import ma.ensa.banque.type.TypeCompte

public data class SaveCompteMutation(
  public val compte: CompteRequest,
) : Mutation<SaveCompteMutation.Data> {
  public override fun id(): String = OPERATION_ID

  public override fun document(): String = OPERATION_DOCUMENT

  public override fun name(): String = OPERATION_NAME

  public override fun serializeVariables(writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters): Unit {
    SaveCompteMutation_VariablesAdapter.toJson(writer, customScalarAdapters, this)
  }

  public override fun adapter(): Adapter<Data> = SaveCompteMutation_ResponseAdapter.Data.obj()

  public override fun rootField(): CompiledField = CompiledField.Builder(
    name = "data",
    type = ma.ensa.banque.type.Mutation.type
  )
  .selections(selections = SaveCompteMutationSelections.__root)
  .build()

  @ApolloAdaptableWith(SaveCompteMutation_ResponseAdapter.Data::class)
  public data class Data(
    public val saveCompte: SaveCompte?,
  ) : Mutation.Data

  public data class SaveCompte(
    public val id: String?,
    public val solde: Double?,
    public val dateCreation: String?,
    public val type: TypeCompte?,
  )

  public companion object {
    public const val OPERATION_ID: String =
        "1efbdaee03b3be13311ce19c87747721644954f6ebc8f6ec146e7030797304d8"

    /**
     * The minimized GraphQL document being sent to the server to save a few bytes.
     * The un-minimized version is:
     *
     * mutation SaveCompte($compte: CompteRequest!) {
     *   saveCompte(compte: $compte) {
     *     id
     *     solde
     *     dateCreation
     *     type
     *   }
     * }
     */
    public val OPERATION_DOCUMENT: String
      get() =
          "mutation SaveCompte(${'$'}compte: CompteRequest!) { saveCompte(compte: ${'$'}compte) { id solde dateCreation type } }"

    public const val OPERATION_NAME: String = "SaveCompte"
  }
}