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

case class RoutineTableUsageRow(
  specificCatalog: Option[String],
  specificSchema: Option[String],
  specificName: Option[String],
  routineCatalog: Option[String],
  routineSchema: Option[String],
  routineName: Option[String],
  tableCatalog: Option[String],
  tableSchema: Option[String],
  tableName: Option[String]
)

object RoutineTableUsageRow {
  def rowParser(prefix: String): RowParser[RoutineTableUsageRow] = { row =>
    Success(
      RoutineTableUsageRow(
        specificCatalog = row[Option[String]](prefix + "specific_catalog"),
        specificSchema = row[Option[String]](prefix + "specific_schema"),
        specificName = row[Option[String]](prefix + "specific_name"),
        routineCatalog = row[Option[String]](prefix + "routine_catalog"),
        routineSchema = row[Option[String]](prefix + "routine_schema"),
        routineName = row[Option[String]](prefix + "routine_name"),
        tableCatalog = row[Option[String]](prefix + "table_catalog"),
        tableSchema = row[Option[String]](prefix + "table_schema"),
        tableName = row[Option[String]](prefix + "table_name")
      )
    )
  }

  implicit val oFormat: OFormat[RoutineTableUsageRow] = new OFormat[RoutineTableUsageRow]{
    override def writes(o: RoutineTableUsageRow): JsObject =
      Json.obj(
        "specific_catalog" -> o.specificCatalog,
      "specific_schema" -> o.specificSchema,
      "specific_name" -> o.specificName,
      "routine_catalog" -> o.routineCatalog,
      "routine_schema" -> o.routineSchema,
      "routine_name" -> o.routineName,
      "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName
      )

    override def reads(json: JsValue): JsResult[RoutineTableUsageRow] = {
      JsResult.fromTry(
        Try(
          RoutineTableUsageRow(
            specificCatalog = json.\("specific_catalog").toOption.map(_.as[String]),
            specificSchema = json.\("specific_schema").toOption.map(_.as[String]),
            specificName = json.\("specific_name").toOption.map(_.as[String]),
            routineCatalog = json.\("routine_catalog").toOption.map(_.as[String]),
            routineSchema = json.\("routine_schema").toOption.map(_.as[String]),
            routineName = json.\("routine_name").toOption.map(_.as[String]),
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}