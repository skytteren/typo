/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.Column
import anorm.ParameterMetaData
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgTriggerId(value: /* oid */ Long) extends AnyVal
object PgTriggerId {
  implicit val ordering: Ordering[PgTriggerId] = Ordering.by(_.value)
  implicit val format: Format[PgTriggerId] = implicitly[Format[/* oid */ Long]].bimap(PgTriggerId.apply, _.value)
  implicit val toStatement: ToStatement[PgTriggerId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgTriggerId] = implicitly[Column[/* oid */ Long]].map(PgTriggerId.apply)
  def rowParser(prefix: String): RowParser[PgTriggerId] = SqlParser.get[PgTriggerId](prefix + "oid")
  implicit val parameterMetadata: ParameterMetaData[PgTriggerId] = new ParameterMetaData[PgTriggerId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }

}
