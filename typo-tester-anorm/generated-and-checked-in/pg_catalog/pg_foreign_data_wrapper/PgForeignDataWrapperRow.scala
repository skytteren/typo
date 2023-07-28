/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_data_wrapper

import adventureworks.TypoAclItem
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgForeignDataWrapperRow(
  oid: PgForeignDataWrapperId,
  fdwname: String,
  fdwowner: /* oid */ Long,
  fdwhandler: /* oid */ Long,
  fdwvalidator: /* oid */ Long,
  fdwacl: Option[Array[TypoAclItem]],
  fdwoptions: Option[Array[String]]
)

object PgForeignDataWrapperRow {
  def rowParser(idx: Int): RowParser[PgForeignDataWrapperRow] =
    RowParser[PgForeignDataWrapperRow] { row =>
      Success(
        PgForeignDataWrapperRow(
          oid = row[PgForeignDataWrapperId](idx + 0),
          fdwname = row[String](idx + 1),
          fdwowner = row[/* oid */ Long](idx + 2),
          fdwhandler = row[/* oid */ Long](idx + 3),
          fdwvalidator = row[/* oid */ Long](idx + 4),
          fdwacl = row[Option[Array[TypoAclItem]]](idx + 5),
          fdwoptions = row[Option[Array[String]]](idx + 6)
        )
      )
    }
  implicit val oFormat: OFormat[PgForeignDataWrapperRow] = new OFormat[PgForeignDataWrapperRow]{
    override def writes(o: PgForeignDataWrapperRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
        "fdwname" -> o.fdwname,
        "fdwowner" -> o.fdwowner,
        "fdwhandler" -> o.fdwhandler,
        "fdwvalidator" -> o.fdwvalidator,
        "fdwacl" -> o.fdwacl,
        "fdwoptions" -> o.fdwoptions
      )
  
    override def reads(json: JsValue): JsResult[PgForeignDataWrapperRow] = {
      JsResult.fromTry(
        Try(
          PgForeignDataWrapperRow(
            oid = json.\("oid").as[PgForeignDataWrapperId],
            fdwname = json.\("fdwname").as[String],
            fdwowner = json.\("fdwowner").as[/* oid */ Long],
            fdwhandler = json.\("fdwhandler").as[/* oid */ Long],
            fdwvalidator = json.\("fdwvalidator").as[/* oid */ Long],
            fdwacl = json.\("fdwacl").toOption.map(_.as[Array[TypoAclItem]]),
            fdwoptions = json.\("fdwoptions").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}