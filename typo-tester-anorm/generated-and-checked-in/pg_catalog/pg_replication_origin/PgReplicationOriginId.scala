/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_origin

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Format

/** Type for the primary key of table `pg_catalog.pg_replication_origin` */
case class PgReplicationOriginId(value: /* oid */ Long) extends AnyVal
object PgReplicationOriginId {
  implicit val ordering: Ordering[PgReplicationOriginId] = Ordering.by(_.value)
  implicit val format: Format[PgReplicationOriginId] = implicitly[Format[/* oid */ Long]].bimap(PgReplicationOriginId.apply, _.value)
  implicit val toStatement: ToStatement[PgReplicationOriginId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val toStatementArray: ToStatement[Array[PgReplicationOriginId]] = implicitly[ToStatement[Array[/* oid */ Long]]].contramap(_.map(_.value))
  implicit val column: Column[PgReplicationOriginId] = implicitly[Column[/* oid */ Long]].map(PgReplicationOriginId.apply)
  implicit val parameterMetadata: ParameterMetaData[PgReplicationOriginId] = new ParameterMetaData[PgReplicationOriginId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }

}