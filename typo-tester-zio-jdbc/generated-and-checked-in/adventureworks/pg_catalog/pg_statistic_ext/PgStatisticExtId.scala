/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_statistic_ext` */
case class PgStatisticExtId(value: /* oid */ Long) extends AnyVal
object PgStatisticExtId {
  implicit lazy val arraySetter: Setter[Array[PgStatisticExtId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgStatisticExtId, /* oid */ Long] = Bijection[PgStatisticExtId, /* oid */ Long](_.value)(PgStatisticExtId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgStatisticExtId] = JdbcDecoder.longDecoder.map(PgStatisticExtId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgStatisticExtId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgStatisticExtId] = JsonDecoder.long.map(PgStatisticExtId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgStatisticExtId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgStatisticExtId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgStatisticExtId] = ParameterMetaData.instance[PgStatisticExtId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgStatisticExtId] = Setter.longSetter.contramap(_.value)
}