/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_database

import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_database` */
case class PgDatabaseId(value: /* oid */ Long) extends AnyVal
object PgDatabaseId {
  implicit val arrayGet: Get[Array[PgDatabaseId]] = Get[Array[/* oid */ Long]].map(_.map(PgDatabaseId.apply))
  implicit val arrayPut: Put[Array[PgDatabaseId]] = Put[Array[/* oid */ Long]].contramap(_.map(_.value))
  implicit val decoder: Decoder[PgDatabaseId] = Decoder[/* oid */ Long].map(PgDatabaseId.apply)
  implicit val encoder: Encoder[PgDatabaseId] = Encoder[/* oid */ Long].contramap(_.value)
  implicit val get: Get[PgDatabaseId] = Get[/* oid */ Long].map(PgDatabaseId.apply)
  implicit val ordering: Ordering[PgDatabaseId] = Ordering.by(_.value)
  implicit val put: Put[PgDatabaseId] = Put[/* oid */ Long].contramap(_.value)
}
