/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import java.sql.Types
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Domain `information_schema.sql_identifier`
  * No constraint
  */
case class SqlIdentifier(value: String)
object SqlIdentifier {
  implicit lazy val arrayColumn: Column[Array[SqlIdentifier]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[SqlIdentifier]] = ToStatement.arrayToParameter(ParameterMetaData.StringParameterMetaData).contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[SqlIdentifier, String] = Bijection[SqlIdentifier, String](_.value)(SqlIdentifier.apply)
  implicit lazy val column: Column[SqlIdentifier] = Column.columnToString.map(SqlIdentifier.apply)
  implicit lazy val ordering: Ordering[SqlIdentifier] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[SqlIdentifier] = new ParameterMetaData[SqlIdentifier] {
    override def sqlType: String = """"information_schema"."sql_identifier""""
    override def jdbcType: Int = Types.OTHER
  }
  implicit lazy val reads: Reads[SqlIdentifier] = Reads.StringReads.map(SqlIdentifier.apply)
  implicit lazy val text: Text[SqlIdentifier] = new Text[SqlIdentifier] {
    override def unsafeEncode(v: SqlIdentifier, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: SqlIdentifier, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val toStatement: ToStatement[SqlIdentifier] = ToStatement.stringToStatement.contramap(_.value)
  implicit lazy val writes: Writes[SqlIdentifier] = Writes.StringWrites.contramap(_.value)
}