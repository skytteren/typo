/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_db_role_setting

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `pg_catalog.pg_db_role_setting` */
case class PgDbRoleSettingId(setdatabase: /* oid */ Long, setrole: /* oid */ Long)
object PgDbRoleSettingId {
  implicit val ordering: Ordering[PgDbRoleSettingId] = Ordering.by(x => (x.setdatabase, x.setrole))
  implicit val reads: Reads[PgDbRoleSettingId] = Reads[PgDbRoleSettingId](json => JsResult.fromTry(
      Try(
        PgDbRoleSettingId(
          setdatabase = json.\("setdatabase").as[/* oid */ Long],
          setrole = json.\("setrole").as[/* oid */ Long]
        )
      )
    ),
  )
  implicit val writes: OWrites[PgDbRoleSettingId] = OWrites[PgDbRoleSettingId](o =>
    new JsObject(ListMap[String, JsValue](
      "setdatabase" -> Json.toJson(o.setdatabase),
      "setrole" -> Json.toJson(o.setrole)
    ))
  )
}
