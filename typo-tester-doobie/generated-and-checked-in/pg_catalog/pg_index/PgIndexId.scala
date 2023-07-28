/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_index

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_index` */
case class PgIndexId(value: /* oid */ Long) extends AnyVal
object PgIndexId {
  implicit val arrayGet: Get[Array[PgIndexId]] = Get[Array[/* oid */ Long]].map(_.map(PgIndexId.apply))
  implicit val arrayPut: Put[Array[PgIndexId]] = Put[Array[/* oid */ Long]].contramap(_.map(_.value))
  implicit val decoder: Decoder[PgIndexId] = Decoder[/* oid */ Long].map(PgIndexId.apply)
  implicit val encoder: Encoder[PgIndexId] = Encoder[/* oid */ Long].contramap(_.value)
  implicit val get: Get[PgIndexId] = Get[/* oid */ Long].map(PgIndexId.apply)
  implicit val ordering: Ordering[PgIndexId] = Ordering.by(_.value)
  implicit val put: Put[PgIndexId] = Put[/* oid */ Long].contramap(_.value)
}
