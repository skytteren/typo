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

/** json (via PGObject) */
case class TypoJson(value: String)

object TypoJson {
  implicit val arrayColumn: Column[Array[TypoJson]] = Column.nonNull[Array[TypoJson]]((v1: Any, _) =>
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
  implicit val arrayParameterMetaData: ParameterMetaData[Array[TypoJson]] = new ParameterMetaData[Array[TypoJson]] {
    override def sqlType: String = "_json"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit val arrayToStatement: ToStatement[Array[TypoJson]] = ToStatement[Array[TypoJson]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("json", v.map(v => {
                                                                                                                     val obj = new PGobject
                                                                                                                     obj.setType("json")
                                                                                                                     obj.setValue(v.value)
                                                                                                                     obj
                                                                                                                   }))))
  implicit val column: Column[TypoJson] = Column.nonNull[TypoJson]((v1: Any, _) =>
    v1 match {
      case v: PGobject => Right(TypoJson(v.getValue))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.util.PGobject, got ${other.getClass.getName}"))
    }
  )
  implicit val ordering: Ordering[TypoJson] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[TypoJson] = new ParameterMetaData[TypoJson] {
    override def sqlType: String = "json"
    override def jdbcType: Int = Types.OTHER
  }
  implicit val reads: Reads[TypoJson] = Reads.StringReads.map(TypoJson.apply)
  implicit val toStatement: ToStatement[TypoJson] = ToStatement[TypoJson]((s, index, v) => s.setObject(index, {
                                                              val obj = new PGobject
                                                              obj.setType("json")
                                                              obj.setValue(v.value)
                                                              obj
                                                            }))
  implicit val writes: Writes[TypoJson] = Writes.StringWrites.contramap(_.value)
}
