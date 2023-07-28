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
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** oidvector (via PGObject) */
case class TypoOidVector(value: String)

object TypoOidVector {
  implicit val arrayColumn: Column[Array[TypoOidVector]] = Column.nonNull[Array[TypoOidVector]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoOidVector(v.asInstanceOf[String])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoOidVector, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit val arrayParameterMetaData: ParameterMetaData[Array[TypoOidVector]] = new ParameterMetaData[Array[TypoOidVector]] {
    override def sqlType: String = "_oidvector"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit val arrayToStatement: ToStatement[Array[TypoOidVector]] = ToStatement[Array[TypoOidVector]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("oidvector", v.map(v => {
                                                                                                                               val obj = new PGobject
                                                                                                                               obj.setType("oidvector")
                                                                                                                               obj.setValue(v.value)
                                                                                                                               obj
                                                                                                                             }))))
  implicit val column: Column[TypoOidVector] = Column.nonNull[TypoOidVector]((v1: Any, _) =>
    v1 match {
      case v: PGobject => Right(TypoOidVector(v.getValue))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.util.PGobject, got ${other.getClass.getName}"))
    }
  )
  implicit val parameterMetadata: ParameterMetaData[TypoOidVector] = new ParameterMetaData[TypoOidVector] {
    override def sqlType: String = "oidvector"
    override def jdbcType: Int = Types.OTHER
  }
  implicit val reads: Reads[TypoOidVector] = Reads[TypoOidVector](json => JsResult.fromTry(
      Try(
        TypoOidVector(
          value = json.\("value").as[String]
        )
      )
    ),
  )
  implicit val toStatement: ToStatement[TypoOidVector] = ToStatement[TypoOidVector]((s, index, v) => s.setObject(index, {
                                                                   val obj = new PGobject
                                                                   obj.setType("oidvector")
                                                                   obj.setValue(v.value)
                                                                   obj
                                                                 }))
  implicit val writes: OWrites[TypoOidVector] = OWrites[TypoOidVector](o =>
    new JsObject(ListMap[String, JsValue](
      "value" -> Json.toJson(o.value)
    ))
  )
}
