/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import adventureworks.Text
import java.sql.ResultSet
import java.sql.Types
import java.time.Instant
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** This is `java.time.TypoInstant`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */
case class TypoInstant(value: Instant)

object TypoInstant {
  val parser: DateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss").appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true).appendPattern("X").toFormatter
  def apply(value: Instant): TypoInstant = new TypoInstant(value.truncatedTo(ChronoUnit.MICROS))
  def apply(str: String): TypoInstant = apply(OffsetDateTime.parse(str, parser).toInstant)
  def now = TypoInstant(Instant.now)
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoInstant]] = JdbcDecoder[Array[TypoInstant]]((rs: ResultSet) => (i: Int) =>
    rs.getArray(i) match {
      case null => null
      case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoInstant(x.asInstanceOf[String]))
    },
    "Array[java.lang.String]"
  )
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoInstant]] = JdbcEncoder.singleParamEncoder(using arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoInstant]] = Setter.forSqlType((ps, i, v) =>
    ps.setArray(
      i,
      ps.getConnection.createArrayOf(
        "timestamptz",
        v.map { vv =>
          vv.value.toString
        }
      )
    ),
    Types.ARRAY
  )
  implicit lazy val bijection: Bijection[TypoInstant, Instant] = Bijection[TypoInstant, Instant](_.value)(TypoInstant.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoInstant] = JdbcDecoder[TypoInstant](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoInstant(v.asInstanceOf[String])
    },
    "java.lang.String"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoInstant] = JdbcEncoder.singleParamEncoder(using setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoInstant] = JsonDecoder.instant.map(TypoInstant.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoInstant] = JsonEncoder.instant.contramap(_.value)
  implicit lazy val ordering: Ordering[TypoInstant] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoInstant] = ParameterMetaData.instance[TypoInstant]("timestamptz", Types.OTHER)
  implicit lazy val setter: Setter[TypoInstant] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        v.value.toString
      )
    },
    "timestamptz"
  )
  implicit lazy val text: Text[TypoInstant] = new Text[TypoInstant] {
    override def unsafeEncode(v: TypoInstant, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.toString, sb)
    override def unsafeArrayEncode(v: TypoInstant, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.toString, sb)
  }
}
