/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package customtypes

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import java.time.Instant
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatterBuilder
import java.time.temporal.ChronoField
import java.time.temporal.ChronoUnit
import org.postgresql.jdbc.PgArray
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.generated.Text

/** This is `java.time.TypoInstant`, but with microsecond precision and transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */
case class TypoInstant(value: Instant)

object TypoInstant {
  val parser: DateTimeFormatter = new DateTimeFormatterBuilder().appendPattern("yyyy-MM-dd HH:mm:ss").appendFraction(ChronoField.MICRO_OF_SECOND, 0, 6, true).appendPattern("X").toFormatter
  def apply(value: Instant): TypoInstant = new TypoInstant(value.truncatedTo(ChronoUnit.MICROS))
  def apply(str: String): TypoInstant = apply(OffsetDateTime.parse(str, parser).toInstant)
  def now = TypoInstant(Instant.now)
  implicit lazy val arrayColumn: Column[Array[TypoInstant]] = Column.nonNull[Array[TypoInstant]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoInstant(v.asInstanceOf[String])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoInstant, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoInstant]] = ToStatement[Array[TypoInstant]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("timestamptz", v.map(v => v.value.toString))))
  implicit lazy val column: Column[TypoInstant] = Column.nonNull[TypoInstant]((v1: Any, _) =>
    v1 match {
      case v: String => Right(TypoInstant(v))
      case other => Left(TypeDoesNotMatch(s"Expected instance of java.lang.String, got ${other.getClass.getName}"))
    }
  )
  implicit def ordering(implicit O0: Ordering[Instant]): Ordering[TypoInstant] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoInstant] = new ParameterMetaData[TypoInstant] {
    override def sqlType: String = "timestamptz"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoInstant] = Reads.DefaultInstantReads.map(TypoInstant.apply)
  implicit lazy val text: Text[TypoInstant] = new Text[TypoInstant] {
    override def unsafeEncode(v: TypoInstant, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.toString, sb)
    override def unsafeArrayEncode(v: TypoInstant, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.toString, sb)
  }
  implicit lazy val toStatement: ToStatement[TypoInstant] = ToStatement[TypoInstant]((s, index, v) => s.setObject(index, v.value.toString))
  implicit lazy val writes: Writes[TypoInstant] = Writes.DefaultInstantWrites.contramap(_.value)
}
