/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import anorm.Column
import anorm.MetaDataItem
import anorm.ParameterMetaData
import anorm.SqlRequestError
import anorm.ToStatement
import anorm.TypeDoesNotMatch
import java.sql.PreparedStatement
import java.sql.Types
import org.postgresql.geometric.PGpoint
import org.postgresql.geometric.PGpolygon
import org.postgresql.jdbc.PgArray
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** Polygon datatype in PostgreSQL */
case class TypoPolygon(points: List[TypoPoint])
object TypoPolygon {
  implicit val oFormat: OFormat[TypoPolygon] = new OFormat[TypoPolygon]{
    override def writes(o: TypoPolygon): JsObject =
      Json.obj(
        "points" -> o.points
      )
  
    override def reads(json: JsValue): JsResult[TypoPolygon] = {
      JsResult.fromTry(
        Try(
          TypoPolygon(
            points = json.\("points").as[List[TypoPoint]]
          )
        )
      )
    }
  }
  implicit val TypoPolygonDb: ToStatement[TypoPolygon] with ParameterMetaData[TypoPolygon] with Column[TypoPolygon] = new ToStatement[TypoPolygon] with ParameterMetaData[TypoPolygon] with Column[TypoPolygon] {
    override def sqlType: String = "polygon"
    override def jdbcType: Int = Types.OTHER
    override def set(s: PreparedStatement, index: Int, v: TypoPolygon): Unit =
      s.setObject(index, new PGpolygon(v.points.map(p => new PGpoint(p.x, p.y)).toArray))
    override def apply(v: Any, v2: MetaDataItem): Either[SqlRequestError, TypoPolygon] =
      v match {
        case v: PGpolygon => Right(TypoPolygon(v.points.map(p => TypoPoint(p.x, p.y)).toList))
        case other => Left(TypeDoesNotMatch(s"Expected instance of PGpolygon from JDBC to produce a TypoPolygon, got ${other.getClass.getName}"))
      }
  }
  
  implicit val TypoPolygonDbArray: ToStatement[Array[TypoPolygon]] with ParameterMetaData[Array[TypoPolygon]] with Column[Array[TypoPolygon]] = new ToStatement[Array[TypoPolygon]] with ParameterMetaData[Array[TypoPolygon]] with Column[Array[TypoPolygon]] {
    override def sqlType: String = "_polygon"
    override def jdbcType: Int = Types.ARRAY
    override def set(s: PreparedStatement, index: Int, v: Array[TypoPolygon]): Unit =
      s.setArray(index, s.getConnection.createArrayOf("polygon", v.map(v => new PGpolygon(v.points.map(p => new PGpoint(p.x, p.y)).toArray))))
    override def apply(v: Any, v2: MetaDataItem): Either[SqlRequestError, Array[TypoPolygon]] =
      v match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[_] =>
             Right(v.map(v => TypoPolygon(v.asInstanceOf[PGpolygon].points.map(p => TypoPoint(p.x, p.y)).toList)))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoPolygon, got ${other.getClass.getName}"))
         }
        case other => Left(TypeDoesNotMatch(s"Expected PgArray from JDBC to produce an array of TypoPolygon, got ${other.getClass.getName}"))
      }
  }

}