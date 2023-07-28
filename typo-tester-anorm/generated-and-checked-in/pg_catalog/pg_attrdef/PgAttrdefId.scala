/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attrdef

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

/** Type for the primary key of table `pg_catalog.pg_attrdef` */
case class PgAttrdefId(value: /* oid */ Long) extends AnyVal
object PgAttrdefId {
  implicit val ordering: Ordering[PgAttrdefId] = Ordering.by(_.value)
  implicit val format: Format[PgAttrdefId] = implicitly[Format[/* oid */ Long]].bimap(PgAttrdefId.apply, _.value)
  implicit val toStatement: ToStatement[PgAttrdefId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val toStatementArray: ToStatement[Array[PgAttrdefId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val column: Column[PgAttrdefId] = implicitly[Column[/* oid */ Long]].map(PgAttrdefId.apply)
  implicit val parameterMetadata: ParameterMetaData[PgAttrdefId] = new ParameterMetaData[PgAttrdefId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }

}