//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package values.banque.selections

import com.apollographql.apollo3.api.CompiledField
import com.apollographql.apollo3.api.CompiledSelection
import com.apollographql.apollo3.api.list
import kotlin.collections.List
import ma.ensa.banque.type.Compte
import ma.ensa.banque.type.GraphQLFloat
import ma.ensa.banque.type.GraphQLID
import ma.ensa.banque.type.GraphQLString
import ma.ensa.banque.type.TypeCompte

public object GetAllComptesQuerySelections {
  private val __allComptes: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "id",
          type = GraphQLID.type
        ).build(),
        CompiledField.Builder(
          name = "solde",
          type = GraphQLFloat.type
        ).build(),
        CompiledField.Builder(
          name = "dateCreation",
          type = GraphQLString.type
        ).build(),
        CompiledField.Builder(
          name = "type",
          type = TypeCompte.type
        ).build()
      )

  public val __root: List<CompiledSelection> = listOf(
        CompiledField.Builder(
          name = "allComptes",
          type = Compte.type.list()
        ).selections(__allComptes)
        .build()
      )
}
