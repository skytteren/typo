/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.Types
import java.time.LocalDate
import org.postgresql.jdbc.PgArray
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** This is `java.time.LocalDate`, but transferred to and from postgres as strings. The reason is that postgres driver and db libs are broken */
case class TypoLocalDate(value: LocalDate)

object TypoLocalDate {
  def now = TypoLocalDate(LocalDate.now)
  implicit val arrayColumn: Column[Array[TypoLocalDate]] = Column.nonNull[Array[TypoLocalDate]]((v1: Any, _) =>
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
  implicit val arrayParameterMetaData: ParameterMetaData[Array[TypoLocalDate]] = new ParameterMetaData[Array[TypoLocalDate]] {
    override def sqlType: String = "_text"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit val arrayToStatement: ToStatement[Array[TypoLocalDate]] = ToStatement[Array[TypoLocalDate]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("text", v.map(v => v.value.toString))))
  implicit val column: Column[TypoLocalDate] = Column.nonNull[TypoLocalDate]((v1: Any, _) =>
    v1 match {
      case v: String => Right(TypoLocalDate(LocalDate.parse(v)))
      case other => Left(TypeDoesNotMatch(s"Expected instance of java.lang.String, got ${other.getClass.getName}"))
    }
  )
  implicit def ordering(implicit O0: Ordering[LocalDate]): Ordering[TypoLocalDate] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[TypoLocalDate] = new ParameterMetaData[TypoLocalDate] {
    override def sqlType: String = "text"
    override def jdbcType: Int = Types.OTHER
  }
  implicit val reads: Reads[TypoLocalDate] = Reads.DefaultLocalDateReads.map(TypoLocalDate.apply)
  implicit val toStatement: ToStatement[TypoLocalDate] = ToStatement[TypoLocalDate]((s, index, v) => s.setObject(index, v.value.toString))
  implicit val writes: Writes[TypoLocalDate] = Writes.DefaultLocalDateWrites.contramap(_.value)
}
