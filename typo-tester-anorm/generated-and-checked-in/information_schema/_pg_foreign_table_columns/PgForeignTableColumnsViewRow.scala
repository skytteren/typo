/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package `_pg_foreign_table_columns`

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgForeignTableColumnsViewRow(
  nspname: Option[String],
  relname: Option[String],
  attname: Option[String],
  attfdwoptions: Option[Array[String]]
)

object PgForeignTableColumnsViewRow {
  def rowParser(idx: Int): RowParser[PgForeignTableColumnsViewRow] =
    RowParser[PgForeignTableColumnsViewRow] { row =>
      Success(
        PgForeignTableColumnsViewRow(
          nspname = row[Option[String]](idx + 0),
          relname = row[Option[String]](idx + 1),
          attname = row[Option[String]](idx + 2),
          attfdwoptions = row[Option[Array[String]]](idx + 3)
        )
      )
    }
  implicit val oFormat: OFormat[PgForeignTableColumnsViewRow] = new OFormat[PgForeignTableColumnsViewRow]{
    override def writes(o: PgForeignTableColumnsViewRow): JsObject =
      Json.obj(
        "nspname" -> o.nspname,
        "relname" -> o.relname,
        "attname" -> o.attname,
        "attfdwoptions" -> o.attfdwoptions
      )
  
    override def reads(json: JsValue): JsResult[PgForeignTableColumnsViewRow] = {
      JsResult.fromTry(
        Try(
          PgForeignTableColumnsViewRow(
            nspname = json.\("nspname").toOption.map(_.as[String]),
            relname = json.\("relname").toOption.map(_.as[String]),
            attname = json.\("attname").toOption.map(_.as[String]),
            attfdwoptions = json.\("attfdwoptions").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}