/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgTriggerRow(
  oid: PgTriggerId,
  tgrelid: Long,
  tgparentid: Long,
  tgname: String,
  tgfoid: Long,
  tgtype: Int,
  tgenabled: String,
  tgisinternal: Boolean,
  tgconstrrelid: Long,
  tgconstrindid: Long,
  tgconstraint: Long,
  tgdeferrable: Boolean,
  tginitdeferred: Boolean,
  tgnargs: Int,
  tgattr: PGobject,
  tgargs: Array[Byte],
  tgqual: Option[PGobject],
  tgoldtable: Option[String],
  tgnewtable: Option[String]
)

object PgTriggerRow {
  def rowParser(prefix: String): RowParser[PgTriggerRow] = { row =>
    Success(
      PgTriggerRow(
        oid = row[PgTriggerId](prefix + "oid"),
        tgrelid = row[Long](prefix + "tgrelid"),
        tgparentid = row[Long](prefix + "tgparentid"),
        tgname = row[String](prefix + "tgname"),
        tgfoid = row[Long](prefix + "tgfoid"),
        tgtype = row[Int](prefix + "tgtype"),
        tgenabled = row[String](prefix + "tgenabled"),
        tgisinternal = row[Boolean](prefix + "tgisinternal"),
        tgconstrrelid = row[Long](prefix + "tgconstrrelid"),
        tgconstrindid = row[Long](prefix + "tgconstrindid"),
        tgconstraint = row[Long](prefix + "tgconstraint"),
        tgdeferrable = row[Boolean](prefix + "tgdeferrable"),
        tginitdeferred = row[Boolean](prefix + "tginitdeferred"),
        tgnargs = row[Int](prefix + "tgnargs"),
        tgattr = row[PGobject](prefix + "tgattr"),
        tgargs = row[Array[Byte]](prefix + "tgargs"),
        tgqual = row[Option[PGobject]](prefix + "tgqual"),
        tgoldtable = row[Option[String]](prefix + "tgoldtable"),
        tgnewtable = row[Option[String]](prefix + "tgnewtable")
      )
    )
  }

  implicit val oFormat: OFormat[PgTriggerRow] = new OFormat[PgTriggerRow]{
    override def writes(o: PgTriggerRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "tgrelid" -> o.tgrelid,
      "tgparentid" -> o.tgparentid,
      "tgname" -> o.tgname,
      "tgfoid" -> o.tgfoid,
      "tgtype" -> o.tgtype,
      "tgenabled" -> o.tgenabled,
      "tgisinternal" -> o.tgisinternal,
      "tgconstrrelid" -> o.tgconstrrelid,
      "tgconstrindid" -> o.tgconstrindid,
      "tgconstraint" -> o.tgconstraint,
      "tgdeferrable" -> o.tgdeferrable,
      "tginitdeferred" -> o.tginitdeferred,
      "tgnargs" -> o.tgnargs,
      "tgattr" -> o.tgattr,
      "tgargs" -> o.tgargs,
      "tgqual" -> o.tgqual,
      "tgoldtable" -> o.tgoldtable,
      "tgnewtable" -> o.tgnewtable
      )

    override def reads(json: JsValue): JsResult[PgTriggerRow] = {
      JsResult.fromTry(
        Try(
          PgTriggerRow(
            oid = json.\("oid").as[PgTriggerId],
            tgrelid = json.\("tgrelid").as[Long],
            tgparentid = json.\("tgparentid").as[Long],
            tgname = json.\("tgname").as[String],
            tgfoid = json.\("tgfoid").as[Long],
            tgtype = json.\("tgtype").as[Int],
            tgenabled = json.\("tgenabled").as[String],
            tgisinternal = json.\("tgisinternal").as[Boolean],
            tgconstrrelid = json.\("tgconstrrelid").as[Long],
            tgconstrindid = json.\("tgconstrindid").as[Long],
            tgconstraint = json.\("tgconstraint").as[Long],
            tgdeferrable = json.\("tgdeferrable").as[Boolean],
            tginitdeferred = json.\("tginitdeferred").as[Boolean],
            tgnargs = json.\("tgnargs").as[Int],
            tgattr = json.\("tgattr").as[PGobject],
            tgargs = json.\("tgargs").as[Array[Byte]],
            tgqual = json.\("tgqual").toOption.map(_.as[PGobject]),
            tgoldtable = json.\("tgoldtable").toOption.map(_.as[String]),
            tgnewtable = json.\("tgnewtable").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}