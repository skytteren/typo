/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.Column
import anorm.ParameterMetaData
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgClassId(value: /* oid */ Long) extends AnyVal
object PgClassId {
  implicit val ordering: Ordering[PgClassId] = Ordering.by(_.value)
  implicit val format: Format[PgClassId] = implicitly[Format[/* oid */ Long]].bimap(PgClassId.apply, _.value)
  implicit val toStatement: ToStatement[PgClassId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgClassId] = implicitly[Column[/* oid */ Long]].map(PgClassId.apply)
  def rowParser(prefix: String): RowParser[PgClassId] = SqlParser.get[PgClassId](prefix + "oid")
  implicit val parameterMetadata: ParameterMetaData[PgClassId] = new ParameterMetaData[PgClassId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }

}
