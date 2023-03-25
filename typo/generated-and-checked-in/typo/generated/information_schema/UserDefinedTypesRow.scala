/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class UserDefinedTypesRow(
  userDefinedTypeCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"user_defined_type_catalog","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  userDefinedTypeSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"user_defined_type_schema","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  userDefinedTypeName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"user_defined_type_name","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  userDefinedTypeCategory: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"user_defined_type_category","ordinal_position":4,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  isInstantiable: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"is_instantiable","ordinal_position":5,"is_nullable":"YES","data_type":"character varying","character_maximum_length":3,"character_octet_length":12,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"yes_or_no","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  isFinal: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"is_final","ordinal_position":6,"is_nullable":"YES","data_type":"character varying","character_maximum_length":3,"character_octet_length":12,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"yes_or_no","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  orderingForm: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"ordering_form","ordinal_position":7,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  orderingCategory: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"ordering_category","ordinal_position":8,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  orderingRoutineCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"ordering_routine_catalog","ordinal_position":9,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  orderingRoutineSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"ordering_routine_schema","ordinal_position":10,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  orderingRoutineName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"ordering_routine_name","ordinal_position":11,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  referenceType: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"reference_type","ordinal_position":12,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  dataType: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"data_type","ordinal_position":13,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterMaximumLength: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"character_maximum_length","ordinal_position":14,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterOctetLength: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"character_octet_length","ordinal_position":15,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterSetCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"character_set_catalog","ordinal_position":16,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterSetSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"character_set_schema","ordinal_position":17,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"17","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  characterSetName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"character_set_name","ordinal_position":18,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"18","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  collationCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"collation_catalog","ordinal_position":19,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"19","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  collationSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"collation_schema","ordinal_position":20,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"20","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  collationName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"collation_name","ordinal_position":21,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"21","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  numericPrecision: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"numeric_precision","ordinal_position":22,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"22","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  numericPrecisionRadix: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"numeric_precision_radix","ordinal_position":23,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"23","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  numericScale: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"numeric_scale","ordinal_position":24,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"24","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  datetimePrecision: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"datetime_precision","ordinal_position":25,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"25","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  intervalType: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"interval_type","ordinal_position":26,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"26","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  intervalPrecision: Option[Int] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"interval_precision","ordinal_position":27,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"27","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  sourceDtdIdentifier: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"source_dtd_identifier","ordinal_position":28,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"28","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  refDtdIdentifier: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"user_defined_types","column_name":"ref_dtd_identifier","ordinal_position":29,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"29","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object UserDefinedTypesRow {
  implicit val rowParser: RowParser[UserDefinedTypesRow] = { row =>
    Success(
      UserDefinedTypesRow(
        userDefinedTypeCatalog = row[Option[String]]("user_defined_type_catalog"),
        userDefinedTypeSchema = row[Option[String]]("user_defined_type_schema"),
        userDefinedTypeName = row[Option[String]]("user_defined_type_name"),
        userDefinedTypeCategory = row[Option[String]]("user_defined_type_category"),
        isInstantiable = row[Option[String]]("is_instantiable"),
        isFinal = row[Option[String]]("is_final"),
        orderingForm = row[Option[String]]("ordering_form"),
        orderingCategory = row[Option[String]]("ordering_category"),
        orderingRoutineCatalog = row[Option[String]]("ordering_routine_catalog"),
        orderingRoutineSchema = row[Option[String]]("ordering_routine_schema"),
        orderingRoutineName = row[Option[String]]("ordering_routine_name"),
        referenceType = row[Option[String]]("reference_type"),
        dataType = row[Option[String]]("data_type"),
        characterMaximumLength = row[Option[Int]]("character_maximum_length"),
        characterOctetLength = row[Option[Int]]("character_octet_length"),
        characterSetCatalog = row[Option[String]]("character_set_catalog"),
        characterSetSchema = row[Option[String]]("character_set_schema"),
        characterSetName = row[Option[String]]("character_set_name"),
        collationCatalog = row[Option[String]]("collation_catalog"),
        collationSchema = row[Option[String]]("collation_schema"),
        collationName = row[Option[String]]("collation_name"),
        numericPrecision = row[Option[Int]]("numeric_precision"),
        numericPrecisionRadix = row[Option[Int]]("numeric_precision_radix"),
        numericScale = row[Option[Int]]("numeric_scale"),
        datetimePrecision = row[Option[Int]]("datetime_precision"),
        intervalType = row[Option[String]]("interval_type"),
        intervalPrecision = row[Option[Int]]("interval_precision"),
        sourceDtdIdentifier = row[Option[String]]("source_dtd_identifier"),
        refDtdIdentifier = row[Option[String]]("ref_dtd_identifier")
      )
    )
  }

  implicit val oFormat: OFormat[UserDefinedTypesRow] = new OFormat[UserDefinedTypesRow]{
    override def writes(o: UserDefinedTypesRow): JsObject =
      Json.obj(
        "user_defined_type_catalog" -> o.userDefinedTypeCatalog,
      "user_defined_type_schema" -> o.userDefinedTypeSchema,
      "user_defined_type_name" -> o.userDefinedTypeName,
      "user_defined_type_category" -> o.userDefinedTypeCategory,
      "is_instantiable" -> o.isInstantiable,
      "is_final" -> o.isFinal,
      "ordering_form" -> o.orderingForm,
      "ordering_category" -> o.orderingCategory,
      "ordering_routine_catalog" -> o.orderingRoutineCatalog,
      "ordering_routine_schema" -> o.orderingRoutineSchema,
      "ordering_routine_name" -> o.orderingRoutineName,
      "reference_type" -> o.referenceType,
      "data_type" -> o.dataType,
      "character_maximum_length" -> o.characterMaximumLength,
      "character_octet_length" -> o.characterOctetLength,
      "character_set_catalog" -> o.characterSetCatalog,
      "character_set_schema" -> o.characterSetSchema,
      "character_set_name" -> o.characterSetName,
      "collation_catalog" -> o.collationCatalog,
      "collation_schema" -> o.collationSchema,
      "collation_name" -> o.collationName,
      "numeric_precision" -> o.numericPrecision,
      "numeric_precision_radix" -> o.numericPrecisionRadix,
      "numeric_scale" -> o.numericScale,
      "datetime_precision" -> o.datetimePrecision,
      "interval_type" -> o.intervalType,
      "interval_precision" -> o.intervalPrecision,
      "source_dtd_identifier" -> o.sourceDtdIdentifier,
      "ref_dtd_identifier" -> o.refDtdIdentifier
      )

    override def reads(json: JsValue): JsResult[UserDefinedTypesRow] = {
      JsResult.fromTry(
        Try(
          UserDefinedTypesRow(
            userDefinedTypeCatalog = json.\("user_defined_type_catalog").toOption.map(_.as[String]),
            userDefinedTypeSchema = json.\("user_defined_type_schema").toOption.map(_.as[String]),
            userDefinedTypeName = json.\("user_defined_type_name").toOption.map(_.as[String]),
            userDefinedTypeCategory = json.\("user_defined_type_category").toOption.map(_.as[String]),
            isInstantiable = json.\("is_instantiable").toOption.map(_.as[String]),
            isFinal = json.\("is_final").toOption.map(_.as[String]),
            orderingForm = json.\("ordering_form").toOption.map(_.as[String]),
            orderingCategory = json.\("ordering_category").toOption.map(_.as[String]),
            orderingRoutineCatalog = json.\("ordering_routine_catalog").toOption.map(_.as[String]),
            orderingRoutineSchema = json.\("ordering_routine_schema").toOption.map(_.as[String]),
            orderingRoutineName = json.\("ordering_routine_name").toOption.map(_.as[String]),
            referenceType = json.\("reference_type").toOption.map(_.as[String]),
            dataType = json.\("data_type").toOption.map(_.as[String]),
            characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as[Int]),
            characterOctetLength = json.\("character_octet_length").toOption.map(_.as[Int]),
            characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[String]),
            characterSetSchema = json.\("character_set_schema").toOption.map(_.as[String]),
            characterSetName = json.\("character_set_name").toOption.map(_.as[String]),
            collationCatalog = json.\("collation_catalog").toOption.map(_.as[String]),
            collationSchema = json.\("collation_schema").toOption.map(_.as[String]),
            collationName = json.\("collation_name").toOption.map(_.as[String]),
            numericPrecision = json.\("numeric_precision").toOption.map(_.as[Int]),
            numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as[Int]),
            numericScale = json.\("numeric_scale").toOption.map(_.as[Int]),
            datetimePrecision = json.\("datetime_precision").toOption.map(_.as[Int]),
            intervalType = json.\("interval_type").toOption.map(_.as[String]),
            intervalPrecision = json.\("interval_precision").toOption.map(_.as[Int]),
            sourceDtdIdentifier = json.\("source_dtd_identifier").toOption.map(_.as[String]),
            refDtdIdentifier = json.\("ref_dtd_identifier").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}