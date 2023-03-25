/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgAmprocRowUnsaved(
  amprocfamily: Long,
  amproclefttype: Long,
  amprocrighttype: Long,
  amprocnum: Int,
  amproc: PGobject
)
object PgAmprocRowUnsaved {
  implicit val oFormat: OFormat[PgAmprocRowUnsaved] = new OFormat[PgAmprocRowUnsaved]{
    override def writes(o: PgAmprocRowUnsaved): JsObject =
      Json.obj(
        "amprocfamily" -> o.amprocfamily,
      "amproclefttype" -> o.amproclefttype,
      "amprocrighttype" -> o.amprocrighttype,
      "amprocnum" -> o.amprocnum,
      "amproc" -> o.amproc
      )

    override def reads(json: JsValue): JsResult[PgAmprocRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgAmprocRowUnsaved(
            amprocfamily = json.\("amprocfamily").as[Long],
            amproclefttype = json.\("amproclefttype").as[Long],
            amprocrighttype = json.\("amprocrighttype").as[Long],
            amprocnum = json.\("amprocnum").as[Int],
            amproc = json.\("amproc").as[PGobject]
          )
        )
      )
    }
  }
}