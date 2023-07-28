/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_subscription_rel

import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** Type for the composite primary key of table `pg_catalog.pg_subscription_rel` */
case class PgSubscriptionRelId(srrelid: /* oid */ Long, srsubid: /* oid */ Long)
object PgSubscriptionRelId {
  implicit val ordering: Ordering[PgSubscriptionRelId] = Ordering.by(x => (x.srrelid, x.srsubid))
  implicit val reads: Reads[PgSubscriptionRelId] = Reads[PgSubscriptionRelId](json => JsResult.fromTry(
      Try(
        PgSubscriptionRelId(
          srrelid = json.\("srrelid").as[/* oid */ Long],
          srsubid = json.\("srsubid").as[/* oid */ Long]
        )
      )
    ),
  )
  implicit val writes: OWrites[PgSubscriptionRelId] = OWrites[PgSubscriptionRelId](o =>
    new JsObject(ListMap[String, JsValue](
      "srrelid" -> Json.toJson(o.srrelid),
      "srsubid" -> Json.toJson(o.srsubid)
    ))
  )
}
