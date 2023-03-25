/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgLargeobjectMetadataRowUnsaved(
  lomowner: Long,
  lomacl: Option[Array[PGobject]]
)
object PgLargeobjectMetadataRowUnsaved {
  implicit val oFormat: OFormat[PgLargeobjectMetadataRowUnsaved] = new OFormat[PgLargeobjectMetadataRowUnsaved]{
    override def writes(o: PgLargeobjectMetadataRowUnsaved): JsObject =
      Json.obj(
        "lomowner" -> o.lomowner,
      "lomacl" -> o.lomacl
      )

    override def reads(json: JsValue): JsResult[PgLargeobjectMetadataRowUnsaved] = {
      JsResult.fromTry(
        Try(
          PgLargeobjectMetadataRowUnsaved(
            lomowner = json.\("lomowner").as[Long],
            lomacl = json.\("lomacl").toOption.map(_.as[Array[PGobject]])
          )
        )
      )
    }
  }
}