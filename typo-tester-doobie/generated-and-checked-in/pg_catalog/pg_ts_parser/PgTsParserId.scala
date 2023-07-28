/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_parser

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_ts_parser` */
case class PgTsParserId(value: /* oid */ Long) extends AnyVal
object PgTsParserId {
  implicit val arrayGet: Get[Array[PgTsParserId]] = Get[Array[/* oid */ Long]].map(_.map(PgTsParserId.apply))
  implicit val arrayPut: Put[Array[PgTsParserId]] = Put[Array[/* oid */ Long]].contramap(_.map(_.value))
  implicit val decoder: Decoder[PgTsParserId] = Decoder[/* oid */ Long].map(PgTsParserId.apply)
  implicit val encoder: Encoder[PgTsParserId] = Encoder[/* oid */ Long].contramap(_.value)
  implicit val get: Get[PgTsParserId] = Get[/* oid */ Long].map(PgTsParserId.apply)
  implicit val ordering: Ordering[PgTsParserId] = Ordering.by(_.value)
  implicit val put: Put[PgTsParserId] = Put[/* oid */ Long].contramap(_.value)
}
