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

case class PgDefaultAclId(value: /* oid */ Long) extends AnyVal
object PgDefaultAclId {
  implicit val ordering: Ordering[PgDefaultAclId] = Ordering.by(_.value)
  implicit val format: Format[PgDefaultAclId] = implicitly[Format[/* oid */ Long]].bimap(PgDefaultAclId.apply, _.value)
  implicit val toStatement: ToStatement[PgDefaultAclId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgDefaultAclId] = implicitly[Column[/* oid */ Long]].map(PgDefaultAclId.apply)
  def rowParser(prefix: String): RowParser[PgDefaultAclId] = SqlParser.get[PgDefaultAclId](prefix + "oid")
  implicit val parameterMetadata: ParameterMetaData[PgDefaultAclId] = new ParameterMetaData[PgDefaultAclId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }

}
