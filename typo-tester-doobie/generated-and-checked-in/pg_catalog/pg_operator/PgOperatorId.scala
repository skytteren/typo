/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_operator

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_operator` */
case class PgOperatorId(value: /* oid */ Long) extends AnyVal
object PgOperatorId {
  implicit val arrayGet: Get[Array[PgOperatorId]] = Get[Array[/* oid */ Long]].map(_.map(PgOperatorId.apply))
  implicit val arrayPut: Put[Array[PgOperatorId]] = Put[Array[/* oid */ Long]].contramap(_.map(_.value))
  implicit val decoder: Decoder[PgOperatorId] = Decoder[/* oid */ Long].map(PgOperatorId.apply)
  implicit val encoder: Encoder[PgOperatorId] = Encoder[/* oid */ Long].contramap(_.value)
  implicit val get: Get[PgOperatorId] = Get[/* oid */ Long].map(PgOperatorId.apply)
  implicit val ordering: Ordering[PgOperatorId] = Ordering.by(_.value)
  implicit val put: Put[PgOperatorId] = Put[/* oid */ Long].contramap(_.value)
}
