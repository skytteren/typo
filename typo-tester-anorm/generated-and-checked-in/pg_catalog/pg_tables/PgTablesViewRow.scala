/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_tables

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTablesViewRow(
  schemaname: Option[String],
  tablename: Option[String],
  tableowner: Option[String],
  tablespace: Option[String],
  hasindexes: Option[Boolean],
  hasrules: Option[Boolean],
  hastriggers: Option[Boolean],
  rowsecurity: Option[Boolean]
)

object PgTablesViewRow {
  def rowParser(idx: Int): RowParser[PgTablesViewRow] =
    RowParser[PgTablesViewRow] { row =>
      Success(
        PgTablesViewRow(
          schemaname = row[Option[String]](idx + 0),
          tablename = row[Option[String]](idx + 1),
          tableowner = row[Option[String]](idx + 2),
          tablespace = row[Option[String]](idx + 3),
          hasindexes = row[Option[Boolean]](idx + 4),
          hasrules = row[Option[Boolean]](idx + 5),
          hastriggers = row[Option[Boolean]](idx + 6),
          rowsecurity = row[Option[Boolean]](idx + 7)
        )
      )
    }
  implicit val oFormat: OFormat[PgTablesViewRow] = new OFormat[PgTablesViewRow]{
    override def writes(o: PgTablesViewRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
        "tablename" -> o.tablename,
        "tableowner" -> o.tableowner,
        "tablespace" -> o.tablespace,
        "hasindexes" -> o.hasindexes,
        "hasrules" -> o.hasrules,
        "hastriggers" -> o.hastriggers,
        "rowsecurity" -> o.rowsecurity
      )
  
    override def reads(json: JsValue): JsResult[PgTablesViewRow] = {
      JsResult.fromTry(
        Try(
          PgTablesViewRow(
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            tablename = json.\("tablename").toOption.map(_.as[String]),
            tableowner = json.\("tableowner").toOption.map(_.as[String]),
            tablespace = json.\("tablespace").toOption.map(_.as[String]),
            hasindexes = json.\("hasindexes").toOption.map(_.as[Boolean]),
            hasrules = json.\("hasrules").toOption.map(_.as[Boolean]),
            hastriggers = json.\("hastriggers").toOption.map(_.as[Boolean]),
            rowsecurity = json.\("rowsecurity").toOption.map(_.as[Boolean])
          )
        )
      )
    }
  }
}