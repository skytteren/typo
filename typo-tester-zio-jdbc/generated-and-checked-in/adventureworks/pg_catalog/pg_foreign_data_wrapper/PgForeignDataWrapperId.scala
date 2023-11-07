/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_data_wrapper

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_foreign_data_wrapper` */
case class PgForeignDataWrapperId(value: /* oid */ Long) extends AnyVal
object PgForeignDataWrapperId {
  implicit lazy val arraySetter: Setter[Array[PgForeignDataWrapperId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgForeignDataWrapperId, /* oid */ Long] = Bijection[PgForeignDataWrapperId, /* oid */ Long](_.value)(PgForeignDataWrapperId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgForeignDataWrapperId] = JdbcDecoder.longDecoder.map(PgForeignDataWrapperId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgForeignDataWrapperId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgForeignDataWrapperId] = JsonDecoder.long.map(PgForeignDataWrapperId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgForeignDataWrapperId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgForeignDataWrapperId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgForeignDataWrapperId] = ParameterMetaData.instance[PgForeignDataWrapperId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgForeignDataWrapperId] = Setter.longSetter.contramap(_.value)
}