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
import org.postgresql.jdbc.PgArray
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** This is a type typo does not know how to handle yet. This falls back to casting to string and crossing fingers. Time to file an issue! :] */
case class TypoUnknownCitext(value: String)

object TypoUnknownCitext {
  implicit lazy val arrayColumn: Column[Array[TypoUnknownCitext]] = Column.nonNull[Array[TypoUnknownCitext]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoUnknownCitext(v.asInstanceOf[String])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoUnknownCitext, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoUnknownCitext]] = ToStatement[Array[TypoUnknownCitext]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("citext", v.map(v => v.value))))
  implicit lazy val bijection: Bijection[TypoUnknownCitext, String] = Bijection[TypoUnknownCitext, String](_.value)(TypoUnknownCitext.apply)
  implicit lazy val column: Column[TypoUnknownCitext] = Column.nonNull[TypoUnknownCitext]((v1: Any, _) =>
    v1 match {
      case v: String => Right(TypoUnknownCitext(v))
      case other => Left(TypeDoesNotMatch(s"Expected instance of java.lang.String, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val ordering: Ordering[TypoUnknownCitext] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoUnknownCitext] = new ParameterMetaData[TypoUnknownCitext] {
    override def sqlType: String = "citext"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoUnknownCitext] = Reads.StringReads.map(TypoUnknownCitext.apply)
  implicit lazy val toStatement: ToStatement[TypoUnknownCitext] = ToStatement[TypoUnknownCitext]((s, index, v) => s.setObject(index, v.value))
  implicit lazy val writes: Writes[TypoUnknownCitext] = Writes.StringWrites.contramap(_.value)
}