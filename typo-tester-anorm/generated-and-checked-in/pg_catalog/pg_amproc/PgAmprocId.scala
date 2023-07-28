/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_amproc

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `pg_catalog.pg_amproc` */
case class PgAmprocId(value: /* oid */ Long) extends AnyVal
object PgAmprocId {
  implicit val arrayToStatement: ToStatement[Array[PgAmprocId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val column: Column[PgAmprocId] = implicitly[Column[/* oid */ Long]].map(PgAmprocId.apply)
  implicit val ordering: Ordering[PgAmprocId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgAmprocId] = new ParameterMetaData[PgAmprocId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgAmprocId] = implicitly[Reads[/* oid */ Long]].map(PgAmprocId.apply)
  implicit val toStatement: ToStatement[PgAmprocId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgAmprocId] = implicitly[Writes[/* oid */ Long]].contramap(_.value)
}
