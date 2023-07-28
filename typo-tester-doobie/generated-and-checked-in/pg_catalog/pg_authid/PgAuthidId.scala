/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_authid

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_authid` */
case class PgAuthidId(value: /* oid */ Long) extends AnyVal
object PgAuthidId {
  implicit val arrayGet: Get[Array[PgAuthidId]] = Get[Array[/* oid */ Long]].map(_.map(PgAuthidId.apply))
  implicit val arrayPut: Put[Array[PgAuthidId]] = Put[Array[/* oid */ Long]].contramap(_.map(_.value))
  implicit val decoder: Decoder[PgAuthidId] = Decoder[/* oid */ Long].map(PgAuthidId.apply)
  implicit val encoder: Encoder[PgAuthidId] = Encoder[/* oid */ Long].contramap(_.value)
  implicit val get: Get[PgAuthidId] = Get[/* oid */ Long].map(PgAuthidId.apply)
  implicit val ordering: Ordering[PgAuthidId] = Ordering.by(_.value)
  implicit val put: Put[PgAuthidId] = Put[/* oid */ Long].contramap(_.value)
}
