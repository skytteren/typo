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

case class PgPublicationId(value: /* oid */ Long) extends AnyVal
object PgPublicationId {
  implicit val ordering: Ordering[PgPublicationId] = Ordering.by(_.value)
  implicit val format: Format[PgPublicationId] = implicitly[Format[/* oid */ Long]].bimap(PgPublicationId.apply, _.value)
  implicit val toStatement: ToStatement[PgPublicationId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgPublicationId] = implicitly[Column[/* oid */ Long]].map(PgPublicationId.apply)
  def rowParser(prefix: String): RowParser[PgPublicationId] = SqlParser.get[PgPublicationId](prefix + "oid")
  implicit val parameterMetadata: ParameterMetaData[PgPublicationId] = new ParameterMetaData[PgPublicationId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }

}
