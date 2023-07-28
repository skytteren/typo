/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema

import doobie.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Domain `information_schema.sql_identifier`
  * No constraint
  */
case class SqlIdentifier(value: String) extends AnyVal
object SqlIdentifier {
  implicit def ordering(implicit ev: Ordering[String]): Ordering[SqlIdentifier] = Ordering.by(_.value)
  implicit val encoder: Encoder[SqlIdentifier] =
    Encoder[String].contramap(_.value)
  implicit val decoder: Decoder[SqlIdentifier] =
    Decoder[String].map(SqlIdentifier(_))
  implicit val meta: Meta[SqlIdentifier] = Meta[String].imap(SqlIdentifier.apply)(_.value)
  implicit val metaArray: Meta[Array[SqlIdentifier]] = Meta[Array[String]].imap(_.map(SqlIdentifier.apply))(_.map(_.value))
}