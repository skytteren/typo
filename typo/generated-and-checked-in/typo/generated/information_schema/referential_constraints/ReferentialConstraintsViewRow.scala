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
package referential_constraints

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try
import typo.generated.information_schema.CharacterData
import typo.generated.information_schema.SqlIdentifier

case class ReferentialConstraintsViewRow(
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"constraint_catalog","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  constraintCatalog: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"constraint_schema","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  constraintSchema: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"constraint_name","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  constraintName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"unique_constraint_catalog","ordinal_position":4,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  uniqueConstraintCatalog: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"unique_constraint_schema","ordinal_position":5,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  uniqueConstraintSchema: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"unique_constraint_name","ordinal_position":6,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  uniqueConstraintName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"match_option","ordinal_position":7,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  matchOption: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"update_rule","ordinal_position":8,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  updateRule: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"referential_constraints","column_name":"delete_rule","ordinal_position":9,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  deleteRule: Option[CharacterData]
)

object ReferentialConstraintsViewRow {
  def rowParser(idx: Int): RowParser[ReferentialConstraintsViewRow] =
    RowParser[ReferentialConstraintsViewRow] { row =>
      Success(
        ReferentialConstraintsViewRow(
          constraintCatalog = row[Option[SqlIdentifier]](idx + 0),
          constraintSchema = row[Option[SqlIdentifier]](idx + 1),
          constraintName = row[Option[SqlIdentifier]](idx + 2),
          uniqueConstraintCatalog = row[Option[SqlIdentifier]](idx + 3),
          uniqueConstraintSchema = row[Option[SqlIdentifier]](idx + 4),
          uniqueConstraintName = row[Option[SqlIdentifier]](idx + 5),
          matchOption = row[Option[CharacterData]](idx + 6),
          updateRule = row[Option[CharacterData]](idx + 7),
          deleteRule = row[Option[CharacterData]](idx + 8)
        )
      )
    }
  implicit val oFormat: OFormat[ReferentialConstraintsViewRow] = new OFormat[ReferentialConstraintsViewRow]{
    override def writes(o: ReferentialConstraintsViewRow): JsObject =
      Json.obj(
        "constraint_catalog" -> o.constraintCatalog,
        "constraint_schema" -> o.constraintSchema,
        "constraint_name" -> o.constraintName,
        "unique_constraint_catalog" -> o.uniqueConstraintCatalog,
        "unique_constraint_schema" -> o.uniqueConstraintSchema,
        "unique_constraint_name" -> o.uniqueConstraintName,
        "match_option" -> o.matchOption,
        "update_rule" -> o.updateRule,
        "delete_rule" -> o.deleteRule
      )
  
    override def reads(json: JsValue): JsResult[ReferentialConstraintsViewRow] = {
      JsResult.fromTry(
        Try(
          ReferentialConstraintsViewRow(
            constraintCatalog = json.\("constraint_catalog").toOption.map(_.as[SqlIdentifier]),
            constraintSchema = json.\("constraint_schema").toOption.map(_.as[SqlIdentifier]),
            constraintName = json.\("constraint_name").toOption.map(_.as[SqlIdentifier]),
            uniqueConstraintCatalog = json.\("unique_constraint_catalog").toOption.map(_.as[SqlIdentifier]),
            uniqueConstraintSchema = json.\("unique_constraint_schema").toOption.map(_.as[SqlIdentifier]),
            uniqueConstraintName = json.\("unique_constraint_name").toOption.map(_.as[SqlIdentifier]),
            matchOption = json.\("match_option").toOption.map(_.as[CharacterData]),
            updateRule = json.\("update_rule").toOption.map(_.as[CharacterData]),
            deleteRule = json.\("delete_rule").toOption.map(_.as[CharacterData])
          )
        )
      )
    }
  }
}
