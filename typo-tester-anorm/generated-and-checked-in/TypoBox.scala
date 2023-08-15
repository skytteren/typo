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
import org.postgresql.geometric.PGbox
import org.postgresql.jdbc.PgArray
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** This represents the box datatype in PostgreSQL */
case class TypoBox(x1: Double, y1: Double, x2: Double, y2: Double)

object TypoBox {
  implicit lazy val arrayColumn: Column[Array[TypoBox]] = Column.nonNull[Array[TypoBox]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoBox(v.asInstanceOf[PGbox].point(0).x, v.asInstanceOf[PGbox].point(0).y, v.asInstanceOf[PGbox].point(1).x, v.asInstanceOf[PGbox].point(1).y)))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoBox, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val arrayToStatement: ToStatement[Array[TypoBox]] = ToStatement[Array[TypoBox]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("box", v.map(v => new PGbox(v.x1, v.y1, v.x2, v.y2)))))
  implicit lazy val column: Column[TypoBox] = Column.nonNull[TypoBox]((v1: Any, _) =>
    v1 match {
      case v: PGbox => Right(TypoBox(v.point(0).x, v.point(0).y, v.point(1).x, v.point(1).y))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.geometric.PGbox, got ${other.getClass.getName}"))
    }
  )
  implicit lazy val ordering: Ordering[TypoBox] = Ordering.by(x => (x.x1, x.y1, x.x2, x.y2))
  implicit lazy val parameterMetadata: ParameterMetaData[TypoBox] = new ParameterMetaData[TypoBox] {
    override def sqlType: String = "box"
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[TypoBox] = Reads[TypoBox](json => JsResult.fromTry(
      Try(
        TypoBox(
          x1 = json.\("x1").as(Reads.DoubleReads),
          y1 = json.\("y1").as(Reads.DoubleReads),
          x2 = json.\("x2").as(Reads.DoubleReads),
          y2 = json.\("y2").as(Reads.DoubleReads)
        )
      )
    ),
  )
  implicit lazy val toStatement: ToStatement[TypoBox] = ToStatement[TypoBox]((s, index, v) => s.setObject(index, new PGbox(v.x1, v.y1, v.x2, v.y2)))
  implicit lazy val writes: OWrites[TypoBox] = OWrites[TypoBox](o =>
    new JsObject(ListMap[String, JsValue](
      "x1" -> Writes.DoubleWrites.writes(o.x1),
      "y1" -> Writes.DoubleWrites.writes(o.y1),
      "x2" -> Writes.DoubleWrites.writes(o.x2),
      "y2" -> Writes.DoubleWrites.writes(o.y2)
    ))
  )
}
