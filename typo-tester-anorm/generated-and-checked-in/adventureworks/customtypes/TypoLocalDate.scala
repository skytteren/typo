/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import adventureworks.Text
import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import java.time.LocalDate
import org.postgresql.jdbc.PgArray
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** This is `java.time.LocalDate`, but transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */
case class TypoLocalDate(value: LocalDate)

object TypoLocalDate {
  def now = TypoLocalDate(LocalDate.now)
  def apply(str: String): TypoLocalDate = TypoLocalDate(LocalDate.parse(str))
  implicit lazy val arrayColumn: Column[Array[TypoLocalDate]] = Column.nonNull[Array[TypoLocalDate]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoLocalDate(LocalDate.parse(v.asInstanceOf[String]))))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoLocalDate, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoLocalDate]] = ToStatement[Array[TypoLocalDate]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("date", v.map(v => v.value.toString))))
  implicit lazy val bijection: Bijection[TypoLocalDate, LocalDate] = Bijection[TypoLocalDate, LocalDate](_.value)(TypoLocalDate.apply)
  implicit lazy val column: Column[TypoLocalDate] = Column.nonNull[TypoLocalDate]((v1: Any, _) =>
    v1 match {
      case v: String => Right(TypoLocalDate(LocalDate.parse(v)))
      case other => Left(TypeDoesNotMatch(s"Expected instance of java.lang.String, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val ordering: Ordering[TypoLocalDate] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoLocalDate] = new ParameterMetaData[TypoLocalDate] {
    override def sqlType: String = "date"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoLocalDate] = Reads.DefaultLocalDateReads.map(TypoLocalDate.apply)
  implicit lazy val text: Text[TypoLocalDate] = new Text[TypoLocalDate] {
    override def unsafeEncode(v: TypoLocalDate, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.toString, sb)
    override def unsafeArrayEncode(v: TypoLocalDate, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.toString, sb)
  }
  implicit lazy val toStatement: ToStatement[TypoLocalDate] = ToStatement[TypoLocalDate]((s, index, v) => s.setObject(index, v.value.toString))
  implicit lazy val writes: Writes[TypoLocalDate] = Writes.DefaultLocalDateWrites.contramap(_.value)
}
