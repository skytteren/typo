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
package key_column_usage

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try
import typo.generated.information_schema.CardinalNumber
import typo.generated.information_schema.SqlIdentifier

case class KeyColumnUsageViewRow(
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"key_column_usage","column_name":"constraint_catalog","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  constraintCatalog: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"key_column_usage","column_name":"constraint_schema","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  constraintSchema: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"key_column_usage","column_name":"constraint_name","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  constraintName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"key_column_usage","column_name":"table_catalog","ordinal_position":4,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  tableCatalog: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"key_column_usage","column_name":"table_schema","ordinal_position":5,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  tableSchema: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"key_column_usage","column_name":"table_name","ordinal_position":6,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  tableName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"key_column_usage","column_name":"column_name","ordinal_position":7,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  columnName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"key_column_usage","column_name":"ordinal_position","ordinal_position":8,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  ordinalPosition: Option[CardinalNumber],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"key_column_usage","column_name":"position_in_unique_constraint","ordinal_position":9,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  positionInUniqueConstraint: Option[CardinalNumber]
)

object KeyColumnUsageViewRow {
  val rowParser: RowParser[KeyColumnUsageViewRow] =
    RowParser[KeyColumnUsageViewRow] { row =>
      Success(
        KeyColumnUsageViewRow(
          constraintCatalog = row[Option[SqlIdentifier]]("constraint_catalog"),
          constraintSchema = row[Option[SqlIdentifier]]("constraint_schema"),
          constraintName = row[Option[SqlIdentifier]]("constraint_name"),
          tableCatalog = row[Option[SqlIdentifier]]("table_catalog"),
          tableSchema = row[Option[SqlIdentifier]]("table_schema"),
          tableName = row[Option[SqlIdentifier]]("table_name"),
          columnName = row[Option[SqlIdentifier]]("column_name"),
          ordinalPosition = row[Option[CardinalNumber]]("ordinal_position"),
          positionInUniqueConstraint = row[Option[CardinalNumber]]("position_in_unique_constraint")
        )
      )
    }
  implicit val oFormat: OFormat[KeyColumnUsageViewRow] = new OFormat[KeyColumnUsageViewRow]{
    override def writes(o: KeyColumnUsageViewRow): JsObject =
      Json.obj(
        "constraint_catalog" -> o.constraintCatalog,
        "constraint_schema" -> o.constraintSchema,
        "constraint_name" -> o.constraintName,
        "table_catalog" -> o.tableCatalog,
        "table_schema" -> o.tableSchema,
        "table_name" -> o.tableName,
        "column_name" -> o.columnName,
        "ordinal_position" -> o.ordinalPosition,
        "position_in_unique_constraint" -> o.positionInUniqueConstraint
      )
  
    override def reads(json: JsValue): JsResult[KeyColumnUsageViewRow] = {
      JsResult.fromTry(
        Try(
          KeyColumnUsageViewRow(
            constraintCatalog = json.\("constraint_catalog").toOption.map(_.as[SqlIdentifier]),
            constraintSchema = json.\("constraint_schema").toOption.map(_.as[SqlIdentifier]),
            constraintName = json.\("constraint_name").toOption.map(_.as[SqlIdentifier]),
            tableCatalog = json.\("table_catalog").toOption.map(_.as[SqlIdentifier]),
            tableSchema = json.\("table_schema").toOption.map(_.as[SqlIdentifier]),
            tableName = json.\("table_name").toOption.map(_.as[SqlIdentifier]),
            columnName = json.\("column_name").toOption.map(_.as[SqlIdentifier]),
            ordinalPosition = json.\("ordinal_position").toOption.map(_.as[CardinalNumber]),
            positionInUniqueConstraint = json.\("position_in_unique_constraint").toOption.map(_.as[CardinalNumber])
          )
        )
      )
    }
  }
}
