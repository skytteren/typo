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

case class PgIndexId(value: Long) extends AnyVal
object PgIndexId {
  implicit val ordering: Ordering[PgIndexId] = Ordering.by(_.value)
  implicit val format: Format[PgIndexId] = implicitly[Format[Long]].bimap(PgIndexId.apply, _.value)
  implicit val toStatement: ToStatement[PgIndexId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgIndexId] = implicitly[Column[Long]].map(PgIndexId.apply)
  def rowParser(prefix: String): RowParser[PgIndexId] = SqlParser.get[PgIndexId](prefix + "indexrelid")
}