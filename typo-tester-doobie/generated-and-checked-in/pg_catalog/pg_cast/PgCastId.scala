/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_cast

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_cast` */
case class PgCastId(value: /* oid */ Long) extends AnyVal
object PgCastId {
  implicit val arrayGet: Get[Array[PgCastId]] = Get[Array[/* oid */ Long]].map(_.map(PgCastId.apply))
  implicit val arrayPut: Put[Array[PgCastId]] = Put[Array[/* oid */ Long]].contramap(_.map(_.value))
  implicit val decoder: Decoder[PgCastId] = Decoder[/* oid */ Long].map(PgCastId.apply)
  implicit val encoder: Encoder[PgCastId] = Encoder[/* oid */ Long].contramap(_.value)
  implicit val get: Get[PgCastId] = Get[/* oid */ Long].map(PgCastId.apply)
  implicit val ordering: Ordering[PgCastId] = Ordering.by(_.value)
  implicit val put: Put[PgCastId] = Put[/* oid */ Long].contramap(_.value)
}
