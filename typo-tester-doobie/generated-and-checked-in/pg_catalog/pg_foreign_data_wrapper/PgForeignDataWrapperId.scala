/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_data_wrapper

import doobie.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_foreign_data_wrapper` */
case class PgForeignDataWrapperId(value: /* oid */ Long) extends AnyVal
object PgForeignDataWrapperId {
  implicit val ordering: Ordering[PgForeignDataWrapperId] = Ordering.by(_.value)
  implicit val encoder: Encoder[PgForeignDataWrapperId] =
    Encoder[/* oid */ Long].contramap(_.value)
  implicit val decoder: Decoder[PgForeignDataWrapperId] =
    Decoder[/* oid */ Long].map(PgForeignDataWrapperId(_))
  implicit val meta: Meta[PgForeignDataWrapperId] = Meta[/* oid */ Long].imap(PgForeignDataWrapperId.apply)(_.value)
  implicit val metaArray: Meta[Array[PgForeignDataWrapperId]] = Meta[Array[/* oid */ Long]].imap(_.map(PgForeignDataWrapperId.apply))(_.map(_.value))
}