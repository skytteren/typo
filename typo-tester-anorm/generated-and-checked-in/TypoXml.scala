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
import org.postgresql.jdbc.PgSQLXML
import org.postgresql.util.PGobject
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** XML */
case class TypoXml(value: String)

object TypoXml {
  implicit val arrayColumn: Column[Array[TypoXml]] = Column.nonNull[Array[TypoXml]]((v1: Any, _) =>
    v1 match {
        case v: PgArray =>
         v.getArray match {
           case v: Array[?] =>
             Right(v.map(v => TypoXml(v.asInstanceOf[PGobject].getValue)))
           case other => Left(TypeDoesNotMatch(s"Expected one-dimensional array from JDBC to produce an array of TypoXml, got ${other.getClass.getName}"))
         }
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgArray, got ${other.getClass.getName}"))
    }
  )
  implicit val arrayParameterMetaData: ParameterMetaData[Array[TypoXml]] = new ParameterMetaData[Array[TypoXml]] {
    override def sqlType: String = "_xml"
    override def jdbcType: Int = Types.ARRAY
  }
  implicit val arrayToStatement: ToStatement[Array[TypoXml]] = ToStatement[Array[TypoXml]]((s, index, v) => s.setArray(index, s.getConnection.createArrayOf("xml", v.map(v => {
                                                                                                                   val obj = new PGobject
                                                                                                                   obj.setType("xml")
                                                                                                                   obj.setValue(v.value)
                                                                                                                   obj
                                                                                                                 }))))
  implicit val column: Column[TypoXml] = Column.nonNull[TypoXml]((v1: Any, _) =>
    v1 match {
      case v: PgSQLXML => Right(TypoXml(v.getString))
      case other => Left(TypeDoesNotMatch(s"Expected instance of org.postgresql.jdbc.PgSQLXML, got ${other.getClass.getName}"))
    }
  )
  implicit val ordering: Ordering[TypoXml] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[TypoXml] = new ParameterMetaData[TypoXml] {
    override def sqlType: String = "xml"
    override def jdbcType: Int = Types.OTHER
  }
  implicit val reads: Reads[TypoXml] = Reads.StringReads.map(TypoXml.apply)
  implicit val toStatement: ToStatement[TypoXml] = ToStatement[TypoXml]((s, index, v) => s.setObject(index, v.value))
  implicit val writes: Writes[TypoXml] = Writes.StringWrites.contramap(_.value)
}
