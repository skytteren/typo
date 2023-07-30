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

/** int2vector (via PGObject) */
case class TypoInt2Vector(value: String)

object TypoInt2Vector {
  implicit val arrayColumn: Column[Array[TypoInt2Vector]] = Column.nonNull[Array[TypoInt2Vector]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoInt2Vector(v.asInstanceOf[String])))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoInt2Vector, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit val arrayParameterMetaData: ParameterMetaData[Array[TypoInt2Vector]] = new ParameterMetaData[Array[TypoInt2Vector]] {
    override def sqlType: String = "_int2vector"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit val arrayToStatement: ToStatement[Array[TypoInt2Vector]] = ToStatement[Array[TypoInt2Vector]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("int2vector", v.map(v => {
                                                                                                                                 val obj = new PGobject
                                                                                                                                 obj.setType("int2vector")
                                                                                                                                 obj.setValue(v.value)
                                                                                                                                 obj
                                                                                                                               }))))
  implicit val column: Column[TypoInt2Vector] = Column.nonNull[TypoInt2Vector]((v1: Any, _) =>
    v1 match {
      case v: PGobject => Right(TypoInt2Vector(v.getValue))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.util.PGobject, got ${other.getClass.getName}"))
    }
  )
  implicit val ordering: Ordering[TypoInt2Vector] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[TypoInt2Vector] = new ParameterMetaData[TypoInt2Vector] {
    override def sqlType: String = "int2vector"
    override def jdbcType: Int = Types.OTHER
  }
  implicit val reads: Reads[TypoInt2Vector] = Reads.StringReads.map(TypoInt2Vector.apply)
  implicit val toStatement: ToStatement[TypoInt2Vector] = ToStatement[TypoInt2Vector]((s, index, v) => s.setObject(index, {
                                                                    val obj = new PGobject
                                                                    obj.setType("int2vector")
                                                                    obj.setValue(v.value)
                                                                    obj
                                                                  }))
  implicit val writes: Writes[TypoInt2Vector] = Writes.StringWrites.contramap(_.value)
}
