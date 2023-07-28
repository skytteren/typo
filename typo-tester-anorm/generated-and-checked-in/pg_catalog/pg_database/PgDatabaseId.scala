/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_database

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `pg_catalog.pg_database` */
case class PgDatabaseId(value: /* oid */ Long) extends AnyVal
object PgDatabaseId {
  implicit val arrayToStatement: ToStatement[Array[PgDatabaseId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val column: Column[PgDatabaseId] = implicitly[Column[/* oid */ Long]].map(PgDatabaseId.apply)
  implicit val ordering: Ordering[PgDatabaseId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgDatabaseId] = new ParameterMetaData[PgDatabaseId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgDatabaseId] = implicitly[Reads[/* oid */ Long]].map(PgDatabaseId.apply)
  implicit val toStatement: ToStatement[PgDatabaseId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgDatabaseId] = implicitly[Writes[/* oid */ Long]].contramap(_.value)
}
