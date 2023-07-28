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

/** jsonb (via PGObject) */
case class TypoJsonb(value: String)

object TypoJsonb {
  implicit val arrayColumn: Column[Array[TypoJsonb]] = Column.nonNull[Array[TypoJsonb]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoJsonb(v.asInstanceOf[String])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoJsonb, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit val arrayParameterMetaData: ParameterMetaData[Array[TypoJsonb]] = new ParameterMetaData[Array[TypoJsonb]] {
    override def sqlType: String = "_jsonb"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit val arrayToStatement: ToStatement[Array[TypoJsonb]] = ToStatement[Array[TypoJsonb]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("jsonb", v.map(v => {
                                                                                                                       val obj = new PGobject
                                                                                                                       obj.setType("jsonb")
                                                                                                                       obj.setValue(v.value)
                                                                                                                       obj
                                                                                                                     }))))
  implicit val column: Column[TypoJsonb] = Column.nonNull[TypoJsonb]((v1: Any, _) =>
    v1 match {
      case v: PGobject => Right(TypoJsonb(v.getValue))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.util.PGobject, got ${other.getClass.getName}"))
    }
  )
  implicit val parameterMetadata: ParameterMetaData[TypoJsonb] = new ParameterMetaData[TypoJsonb] {
    override def sqlType: String = "jsonb"
    override def jdbcType: Int = Types.OTHER
  }
  implicit val reads: Reads[TypoJsonb] = Reads[TypoJsonb](json => JsResult.fromTry(
      Try(
        TypoJsonb(
          value = json.\("value").as[String]
        )
      )
    ),
  )
  implicit val toStatement: ToStatement[TypoJsonb] = ToStatement[TypoJsonb]((s, index, v) => s.setObject(index, {
                                                               val obj = new PGobject
                                                               obj.setType("jsonb")
                                                               obj.setValue(v.value)
                                                               obj
                                                             }))
  implicit val writes: OWrites[TypoJsonb] = OWrites[TypoJsonb](o =>
    new JsObject(ListMap[String, JsValue](
      "value" -> Json.toJson(o.value)
    ))
  )
}
