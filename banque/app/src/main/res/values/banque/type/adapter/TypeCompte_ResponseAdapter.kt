//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package values.banque.type.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import kotlin.Unit
import ma.ensa.banque.type.TypeCompte

public object TypeCompte_ResponseAdapter : Adapter<TypeCompte> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
      TypeCompte {
    val rawValue = reader.nextString()!!
    return TypeCompte.safeValueOf(rawValue)
  }

  public override fun toJson(
    writer: JsonWriter,
    customScalarAdapters: CustomScalarAdapters,
    `value`: TypeCompte,
  ): Unit {
    writer.value(value.rawValue)
  }
}
