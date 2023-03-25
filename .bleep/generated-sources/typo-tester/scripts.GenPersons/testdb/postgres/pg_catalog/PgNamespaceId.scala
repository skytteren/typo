/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgNamespaceId(value: Long) extends AnyVal
object PgNamespaceId {
  implicit val ordering: Ordering[PgNamespaceId] = Ordering.by(_.value)
  implicit val format: Format[PgNamespaceId] = implicitly[Format[Long]].bimap(PgNamespaceId.apply, _.value)
  implicit val toStatement: ToStatement[PgNamespaceId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgNamespaceId] = implicitly[Column[Long]].map(PgNamespaceId.apply)
  def rowParser(prefix: String): RowParser[PgNamespaceId] = SqlParser.get[PgNamespaceId](prefix + "oid")
}