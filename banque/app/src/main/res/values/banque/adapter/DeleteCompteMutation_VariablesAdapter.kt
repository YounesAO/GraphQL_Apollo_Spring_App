//
// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL version '3.8.2'.
//
package values.banque.adapter

import com.apollographql.apollo3.api.Adapter
import com.apollographql.apollo3.api.CustomScalarAdapters
import com.apollographql.apollo3.api.StringAdapter
import com.apollographql.apollo3.api.json.JsonReader
import com.apollographql.apollo3.api.json.JsonWriter
import kotlin.IllegalStateException
import kotlin.Unit
import values.banque.DeleteCompteMutation

public object DeleteCompteMutation_VariablesAdapter : Adapter<_root_ide_package_.values.banque.DeleteCompteMutation> {
  public override fun fromJson(reader: JsonReader, customScalarAdapters: CustomScalarAdapters):
          _root_ide_package_.values.banque.DeleteCompteMutation = throw IllegalStateException("Input type used in output position")

  public override fun toJson(
      writer: JsonWriter,
      customScalarAdapters: CustomScalarAdapters,
      `value`: _root_ide_package_.values.banque.DeleteCompteMutation,
  ): Unit {
    writer.name("id")
    StringAdapter.toJson(writer, customScalarAdapters, value.id)
  }
}
