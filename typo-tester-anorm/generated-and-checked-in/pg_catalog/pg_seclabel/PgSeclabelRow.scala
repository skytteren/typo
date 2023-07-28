/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_seclabel

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

case class PgSeclabelRow(
  objoid: /* oid */ Long,
  classoid: /* oid */ Long,
  objsubid: Int,
  provider: String,
  label: String
){
   val compositeId: PgSeclabelId = PgSeclabelId(objoid, classoid, objsubid, provider)
 }

object PgSeclabelRow {
  implicit val reads: Reads[PgSeclabelRow] = Reads[PgSeclabelRow](json => JsResult.fromTry(
      Try(
        PgSeclabelRow(
          objoid = json.\("objoid").as[/* oid */ Long],
          classoid = json.\("classoid").as[/* oid */ Long],
          objsubid = json.\("objsubid").as[Int],
          provider = json.\("provider").as[String],
          label = json.\("label").as[String]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgSeclabelRow] = RowParser[PgSeclabelRow] { row =>
    Success(
      PgSeclabelRow(
        objoid = row[/* oid */ Long](idx + 0),
        classoid = row[/* oid */ Long](idx + 1),
        objsubid = row[Int](idx + 2),
        provider = row[String](idx + 3),
        label = row[String](idx + 4)
      )
    )
  }
  implicit val writes: OWrites[PgSeclabelRow] = OWrites[PgSeclabelRow](o =>
    new JsObject(ListMap[String, JsValue](
      "objoid" -> Json.toJson(o.objoid),
      "classoid" -> Json.toJson(o.classoid),
      "objsubid" -> Json.toJson(o.objsubid),
      "provider" -> Json.toJson(o.provider),
      "label" -> Json.toJson(o.label)
    ))
  )
}
