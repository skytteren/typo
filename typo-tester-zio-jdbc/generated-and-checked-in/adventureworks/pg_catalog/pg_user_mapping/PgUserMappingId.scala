/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user_mapping

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `pg_catalog.pg_user_mapping` */
case class PgUserMappingId(value: /* oid */ Long) extends AnyVal
object PgUserMappingId {
  implicit lazy val arraySetter: Setter[Array[PgUserMappingId]] = adventureworks.LongArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[PgUserMappingId, /* oid */ Long] = Bijection[PgUserMappingId, /* oid */ Long](_.value)(PgUserMappingId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[PgUserMappingId] = JdbcDecoder.longDecoder.map(PgUserMappingId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[PgUserMappingId] = JdbcEncoder.longEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[PgUserMappingId] = JsonDecoder.long.map(PgUserMappingId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[PgUserMappingId] = JsonEncoder.long.contramap(_.value)
  implicit lazy val ordering: Ordering[PgUserMappingId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[PgUserMappingId] = ParameterMetaData.instance[PgUserMappingId](ParameterMetaData.LongParameterMetaData.sqlType, ParameterMetaData.LongParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[PgUserMappingId] = Setter.longSetter.contramap(_.value)
}