/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdepend

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgShdependRow(
  dbid: /* oid */ Long,
  classid: /* oid */ Long,
  objid: /* oid */ Long,
  objsubid: Int,
  refclassid: /* oid */ Long,
  refobjid: /* oid */ Long,
  deptype: String
)

object PgShdependRow {
  implicit val reads: Reads[PgShdependRow] = Reads[PgShdependRow](json => JsResult.fromTry(
      Try(
        PgShdependRow(
          dbid = json.\("dbid").as[/* oid */ Long],
          classid = json.\("classid").as[/* oid */ Long],
          objid = json.\("objid").as[/* oid */ Long],
          objsubid = json.\("objsubid").as[Int],
          refclassid = json.\("refclassid").as[/* oid */ Long],
          refobjid = json.\("refobjid").as[/* oid */ Long],
          deptype = json.\("deptype").as[String]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgShdependRow] = RowParser[PgShdependRow] { row =>
    Success(
      PgShdependRow(
        dbid = row[/* oid */ Long](idx + 0),
        classid = row[/* oid */ Long](idx + 1),
        objid = row[/* oid */ Long](idx + 2),
        objsubid = row[Int](idx + 3),
        refclassid = row[/* oid */ Long](idx + 4),
        refobjid = row[/* oid */ Long](idx + 5),
        deptype = row[String](idx + 6)
      )
    )
  }
  implicit val writes: OWrites[PgShdependRow] = OWrites[PgShdependRow](o =>
    new JsObject(ListMap[String, JsValue](
      "dbid" -> Json.toJson(o.dbid),
      "classid" -> Json.toJson(o.classid),
      "objid" -> Json.toJson(o.objid),
      "objsubid" -> Json.toJson(o.objsubid),
      "refclassid" -> Json.toJson(o.refclassid),
      "refobjid" -> Json.toJson(o.refobjid),
      "deptype" -> Json.toJson(o.deptype)
    ))
  )
}
