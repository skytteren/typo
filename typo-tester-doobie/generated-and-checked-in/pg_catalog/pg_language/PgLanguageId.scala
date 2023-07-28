/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_language

import doobie.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Type for the primary key of table `pg_catalog.pg_language` */
case class PgLanguageId(value: /* oid */ Long) extends AnyVal
object PgLanguageId {
  implicit val ordering: Ordering[PgLanguageId] = Ordering.by(_.value)
  implicit val encoder: Encoder[PgLanguageId] =
    Encoder[/* oid */ Long].contramap(_.value)
  implicit val decoder: Decoder[PgLanguageId] =
    Decoder[/* oid */ Long].map(PgLanguageId(_))
  implicit val meta: Meta[PgLanguageId] = Meta[/* oid */ Long].imap(PgLanguageId.apply)(_.value)
  implicit val metaArray: Meta[Array[PgLanguageId]] = Meta[Array[/* oid */ Long]].imap(_.map(PgLanguageId.apply))(_.map(_.value))
}