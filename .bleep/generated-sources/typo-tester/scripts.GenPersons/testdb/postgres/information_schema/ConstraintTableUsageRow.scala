/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ConstraintTableUsageRow(
  tableCatalog: Option[String],
  tableSchema: Option[String],
  tableName: Option[String],
  constraintCatalog: Option[String],
  constraintSchema: Option[String],
  constraintName: Option[String]
)

object ConstraintTableUsageRow {
  def rowParser(prefix: String): RowParser[ConstraintTableUsageRow] = { row =>
    Success(
      ConstraintTableUsageRow(
        tableCatalog = row[Option[String]](prefix + "table_catalog"),
        tableSchema = row[Option[String]](prefix + "table_schema"),
        tableName = row[Option[String]](prefix + "table_name"),
        constraintCatalog = row[Option[String]](prefix + "constraint_catalog"),
        constraintSchema = row[Option[String]](prefix + "constraint_schema"),
        constraintName = row[Option[String]](prefix + "constraint_name")
      )
    )
  }

  implicit val oFormat: OFormat[ConstraintTableUsageRow] = new OFormat[ConstraintTableUsageRow]{
    override def writes(o: ConstraintTableUsageRow): JsObject =
      Json.obj(
        "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "constraint_catalog" -> o.constraintCatalog,
      "constraint_schema" -> o.constraintSchema,
      "constraint_name" -> o.constraintName
      )

    override def reads(json: JsValue): JsResult[ConstraintTableUsageRow] = {
      JsResult.fromTry(
        Try(
          ConstraintTableUsageRow(
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            constraintCatalog = json.\("constraint_catalog").toOption.map(_.as[String]),
            constraintSchema = json.\("constraint_schema").toOption.map(_.as[String]),
            constraintName = json.\("constraint_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}