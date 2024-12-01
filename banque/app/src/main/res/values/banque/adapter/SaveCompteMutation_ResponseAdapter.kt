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
import com.apollographql.apollo3.api.nullable
import com.apollographql.apollo3.api.obj
import kotlin.Double
import kotlin.String
import kotlin.Unit
import kotlin.collections.List
import ma.ensa.banque.SaveCompteMutation
import ma.ensa.banque.type.TypeCompte
import ma.ensa.banque.type.adapter.TypeCompte_ResponseAdapter

public object SaveCompteMutation_ResponseAdapter {
  public object Data : Adapter<SaveCompteMutation.Data> {
    public val RESPONSE_NAMES: List<String> = listOf("saveCompte")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        SaveCompteMutation.Data {
      var _saveCompte: SaveCompteMutation.SaveCompte? = null

      while(true) {
        when (reader.selectName(RESPONSE_NAMES)) {
          0 -> _saveCompte = SaveCompte.obj().nullable().fromJson(reader, customScalarAdapters)
          else -> break
        }
      }

      return SaveCompteMutation.Data(
        saveCompte = _saveCompte
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: SaveCompteMutation.Data,
    ): Unit {
      writer.name("saveCompte")
      SaveCompte.obj().nullable().toJson(writer, customScalarAdapters, value.saveCompte)
    }
  }

  public object SaveCompte : Adapter<SaveCompteMutation.SaveCompte> {
    public val RESPONSE_NAMES: List<String> = listOf("id", "solde", "dateCreation", "type")

    public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
        SaveCompteMutation.SaveCompte {
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

      return SaveCompteMutation.SaveCompte(
        id = _id,
        solde = _solde,
        dateCreation = _dateCreation,
        type = _type
      )
    }

    public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: SaveCompteMutation.SaveCompte,
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