/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_proc

import doobie.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_proc` */
case class PgProcId(value: /* oid */ Long) extends AnyVal
object PgProcId {
  implicit val ordering: Ordering[PgProcId] = Ordering.by(_.value)
  implicit val encoder: Encoder[PgProcId] =
    Encoder[/* oid */ Long].contramap(_.value)
  implicit val decoder: Decoder[PgProcId] =
    Decoder[/* oid */ Long].map(PgProcId(_))
  implicit val meta: Meta[PgProcId] = Meta[/* oid */ Long].imap(PgProcId.apply)(_.value)
  implicit val metaArray: Meta[Array[PgProcId]] = Meta[Array[/* oid */ Long]].imap(_.map(PgProcId.apply))(_.map(_.value))
}