/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_trigger

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `pg_catalog.pg_trigger` */
case class PgTriggerId(value: /* oid */ Long) extends AnyVal
object PgTriggerId {
  implicit val arrayToStatement: ToStatement[Array[PgTriggerId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val column: Column[PgTriggerId] = implicitly[Column[/* oid */ Long]].map(PgTriggerId.apply)
  implicit val ordering: Ordering[PgTriggerId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgTriggerId] = new ParameterMetaData[PgTriggerId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgTriggerId] = implicitly[Reads[/* oid */ Long]].map(PgTriggerId.apply)
  implicit val toStatement: ToStatement[PgTriggerId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgTriggerId] = implicitly[Writes[/* oid */ Long]].contramap(_.value)
}
