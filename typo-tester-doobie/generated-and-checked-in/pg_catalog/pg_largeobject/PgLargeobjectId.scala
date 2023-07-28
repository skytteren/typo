/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_largeobject

import io.circe.Decoder
import io.circe.Encoder

/** Type for the composite primary key of table `pg_catalog.pg_largeobject` */
case class PgLargeobjectId(loid: /* oid */ Long, pageno: Int)
object PgLargeobjectId {
  implicit val decoder: Decoder[PgLargeobjectId] = Decoder.forProduct2[PgLargeobjectId, /* oid */ Long, Int]("loid", "pageno")(PgLargeobjectId.apply)
  implicit val encoder: Encoder[PgLargeobjectId] = Encoder.forProduct2[PgLargeobjectId, /* oid */ Long, Int]("loid", "pageno")(x => (x.loid, x.pageno))
  implicit val ordering: Ordering[PgLargeobjectId] = Ordering.by(x => (x.loid, x.pageno))
}
