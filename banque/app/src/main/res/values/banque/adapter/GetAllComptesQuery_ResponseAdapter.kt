//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package values.banque.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.NullableDoubleAdapter
import com.apollographql.apollo3.api.NullableStringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import com.apollographql.apollo3.api.list
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import ma.ensa.banque.GetAllComptesQuery
import ma.ensa.banque.type.TypeCompte
import ma.ensa.banque.type.adapter.TypeCompte_ResponseAdapter

public object GetAllComptesQuery_ResponseAdapter {
  public object Data : Adapter<GetAllComptesQuery.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("allComptes")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetAllComptesQuery.Data {
      var _allComptes: List<GetAllComptesQuery.AllCompte?>? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _allComptes = AllCompte.obj().nullable().list().nullable().fromJson(reader,
              customScalarAdapters)
          else -> break
        }
      }

      return GetAllComptesQuery.Data(
        allComptes = _allComptes
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetAllComptesQuery.Data,
    ): Unit {
      writer.name("allComptes")
      AllCompte.obj().nullable().list().nullable().toJson(writer, customScalarAdapters,
          value.allComptes)
    }
  }

  public object AllCompte : Adapter<GetAllComptesQuery.AllCompte> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "solde", "dateCreation", "type")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        GetAllComptesQuery.AllCompte {
      var _id: String? = null
      var _solde: Double? = null
      var _dateCreation: String? = null
      var _type: TypeCompte? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _id = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          1 -> _solde = NullableDoubleAdapter.fromJson(reader, customScalarAdapters)
          2 -> _dateCreation = NullableStringAdapter.fromJson(reader, customScalarAdapters)
          3 -> _type = TypeCompte_ResponseAdapter.nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return GetAllComptesQuery.AllCompte(
        id = _id,
        solde = _solde,
        dateCreation = _dateCreation,
        type = _type
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: GetAllComptesQuery.AllCompte,
    ): Unit {
      writer.name("id")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.id)

      writer.name("solde")
      NullableDoubleAdapter.toJson(writer, customScalarAdapters, value.solde)

      writer.name("dateCreation")
      NullableStringAdapter.toJson(writer, customScalarAdapters, value.dateCreation)

      writer.name("type")
      TypeCompte_ResponseAdapter.nullable().toJson(writer, customScalarAdapters, value.type)
    }
  }
}
