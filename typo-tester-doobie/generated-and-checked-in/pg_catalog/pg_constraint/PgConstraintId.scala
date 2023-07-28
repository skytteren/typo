/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_constraint

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_constraint` */
case class PgConstraintId(value: /* oid */ Long) extends AnyVal
object PgConstraintId {
  implicit val arrayGet: Get[Array[PgConstraintId]] = Get[Array[/* oid */ Long]].map(_.map(PgConstraintId.apply))
  implicit val arrayPut: Put[Array[PgConstraintId]] = Put[Array[/* oid */ Long]].contramap(_.map(_.value))
  implicit val decoder: Decoder[PgConstraintId] = Decoder[/* oid */ Long].map(PgConstraintId.apply)
  implicit val encoder: Encoder[PgConstraintId] = Encoder[/* oid */ Long].contramap(_.value)
  implicit val get: Get[PgConstraintId] = Get[/* oid */ Long].map(PgConstraintId.apply)
  implicit val ordering: Ordering[PgConstraintId] = Ordering.by(_.value)
  implicit val put: Put[PgConstraintId] = Put[/* oid */ Long].contramap(_.value)
}
