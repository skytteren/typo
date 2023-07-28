/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_server

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `pg_catalog.pg_foreign_server` */
case class PgForeignServerId(value: /* oid */ Long) extends AnyVal
object PgForeignServerId {
  implicit val arrayToStatement: ToStatement[Array[PgForeignServerId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val column: Column[PgForeignServerId] = implicitly[Column[/* oid */ Long]].map(PgForeignServerId.apply)
  implicit val ordering: Ordering[PgForeignServerId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[PgForeignServerId] = new ParameterMetaData[PgForeignServerId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }
  implicit val reads: Reads[PgForeignServerId] = implicitly[Reads[/* oid */ Long]].map(PgForeignServerId.apply)
  implicit val toStatement: ToStatement[PgForeignServerId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val writes: Writes[PgForeignServerId] = implicitly[Writes[/* oid */ Long]].contramap(_.value)
}
