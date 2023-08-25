/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import java.time.OffsetTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit
import org.postgresql.jdbc.PgArray
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** This is `java.time.OffsetTime`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */
case class TypoOffsetTime(value: OffsetTime)

object TypoOffsetTime {
  val parser: DateTimeFormatter =
    new DateTimeFormatterBuilder().appendPattern("HH:mm:ss").appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true).appendPattern("X").toFormatter
  def apply(value: OffsetTime): TypoOffsetTime = new TypoOffsetTime(value.truncatedTo(ChronoUnit.MICROS))
  def now = TypoOffsetTime(OffsetTime.now)
  implicit lazy val arrayColumn: Column[Array[TypoOffsetTime]] = Column.nonNull[Array[TypoOffsetTime]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoOffsetTime(OffsetTime.parse(v.asInstanceOf[String], parser))))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoOffsetTime, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoOffsetTime]] = ToStatement[Array[TypoOffsetTime]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("timetz", v.map(v => v.value.toString))))
  implicit lazy val bijection: Bijection[TypoOffsetTime, OffsetTime] = Bijection[TypoOffsetTime, OffsetTime](_.value)(TypoOffsetTime.apply)
  implicit lazy val column: Column[TypoOffsetTime] = Column.nonNull[TypoOffsetTime]((v1: Any, _) =>
    v1 match {
      case v: String => Right(TypoOffsetTime(OffsetTime.parse(v, parser)))
      case other => Left(TypeDoesNotMatch(s"Expected instance of java.lang.String, got ${other.getClass.getName}"))
    }
  )
  implicit def ordering(implicit O0: Ordering[OffsetTime]): Ordering[TypoOffsetTime] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoOffsetTime] = new ParameterMetaData[TypoOffsetTime] {
    override def sqlType: String = "timetz"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoOffsetTime] = adventureworks.OffsetTimeReads.map(TypoOffsetTime.apply)
  implicit lazy val toStatement: ToStatement[TypoOffsetTime] = ToStatement[TypoOffsetTime]((s, index, v) => s.setObject(index, v.value.toString))
  implicit lazy val writes: Writes[TypoOffsetTime] = adventureworks.OffsetTimeWrites.contramap(_.value)
}