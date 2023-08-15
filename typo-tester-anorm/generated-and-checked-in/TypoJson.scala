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
import org.postgresql.jdbc.PgArray
import org.postgresql.util.PGobject
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** json (via PGObject) */
case class TypoJson(value: String)

object TypoJson {
  implicit lazy val arrayColumn: Column[Array[TypoJson]] = Column.nonNull[Array[TypoJson]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoJson(v.asInstanceOf[String])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoJson, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoJson]] = ToStatement[Array[TypoJson]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("json", v.map(v => {
                                                                                                                     val obj = new PGobject
                                                                                                                     obj.setType("json")
                                                                                                                     obj.setValue(v.value)
                                                                                                                     obj
                                                                                                                   }))))
  implicit lazy val bijection: Bijection[TypoJson, String] = Bijection[TypoJson, String](_.value)(TypoJson.apply)
  implicit lazy val column: Column[TypoJson] = Column.nonNull[TypoJson]((v1: Any, _) =>
    v1 match {
      case v: PGobject => Right(TypoJson(v.getValue))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.util.PGobject, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val ordering: Ordering[TypoJson] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoJson] = new ParameterMetaData[TypoJson] {
    override def sqlType: String = "json"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoJson] = Reads.StringReads.map(TypoJson.apply)
  implicit lazy val toStatement: ToStatement[TypoJson] = ToStatement[TypoJson]((s, index, v) => s.setObject(index, {
                                                              val obj = new PGobject
                                                              obj.setType("json")
                                                              obj.setValue(v.value)
                                                              obj
                                                            }))
  implicit lazy val writes: Writes[TypoJson] = Writes.StringWrites.contramap(_.value)
}
