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
import org.postgresql.geometric.PGpath
import org.postgresql.geometric.PGpoint
import org.postgresql.jdbc.PgArray
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This implements a path (a multiple segmented line, which may be closed) */
case class TypoPath(open: Boolean, points: List[TypoPoint])

object TypoPath {
  implicit val arrayColumn: Column[Array[TypoPath]] = Column.nonNull[Array[TypoPath]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoPath(v.asInstanceOf[PGpath].isOpen, v.asInstanceOf[PGpath].points.map(p => TypoPoint(p.x, p.y)).toList)))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoPath, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit val arrayParameterMetaData: ParameterMetaData[Array[TypoPath]] = new ParameterMetaData[Array[TypoPath]] {
    override def sqlType: String = "_path"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit val arrayToStatement: ToStatement[Array[TypoPath]] = ToStatement[Array[TypoPath]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("path", v.map(v => new PGpath(v.points.map(p => new PGpoint(p.x, p.y)).toArray, v.open)))))
  implicit val column: Column[TypoPath] = Column.nonNull[TypoPath]((v1: Any, _) =>
    v1 match {
      case v: PGpath => Right(TypoPath(v.isOpen, v.points.map(p => TypoPoint(p.x, p.y)).toList))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.geometric.PGpath, got ${other.getClass.getName}"))
    }
  )
  implicit def ordering(implicit O0: Ordering[List[TypoPoint]]): Ordering[TypoPath] = Ordering.by(x => (x.open, x.points))
  implicit val parameterMetadata: ParameterMetaData[TypoPath] = new ParameterMetaData[TypoPath] {
    override def sqlType: String = "path"
    override def jdbcType: Int = Types.OTHER
  }
  implicit val reads: Reads[TypoPath] = Reads[TypoPath](json => JsResult.fromTry(
      Try(
        TypoPath(
          open = json.\("open").as(Reads.BooleanReads),
          points = json.\("points").as(implicitly[Reads[List[TypoPoint]]])
        )
      )
    ),
  )
  implicit val toStatement: ToStatement[TypoPath] = ToStatement[TypoPath]((s, index, v) => s.setObject(index, new PGpath(v.points.map(p => new PGpoint(p.x, p.y)).toArray, v.open)))
  implicit val writes: OWrites[TypoPath] = OWrites[TypoPath](o =>
    new JsObject(ListMap[String, JsValue](
      "open" -> Writes.BooleanWrites.writes(o.open),
      "points" -> implicitly[Writes[List[TypoPoint]]].writes(o.points)
    ))
  )
}
