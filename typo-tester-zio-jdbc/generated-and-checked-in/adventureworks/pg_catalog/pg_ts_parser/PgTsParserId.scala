/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_parser

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_ts_parser` */
case class PgTsParserId(value: /* oid */ Long) extends AnyVal
object PgTsParserId {
  implicit lazy val arraySetter: Setter[Array[PgTsParserId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgTsParserId, /* oid */ Long] = Bijection[PgTsParserId, /* oid */ Long](_.value)(PgTsParserId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgTsParserId] = JdbcDecoder.longDecoder.map(PgTsParserId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgTsParserId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgTsParserId] = JsonDecoder.long.map(PgTsParserId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgTsParserId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgTsParserId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgTsParserId] = ParameterMetaData.instance[PgTsParserId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgTsParserId] = Setter.longSetter.contramap(_.value)
}