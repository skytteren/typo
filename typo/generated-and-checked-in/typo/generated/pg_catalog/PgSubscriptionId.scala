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

case class PgSubscriptionId(value: /* oid */ Long) extends AnyVal
object PgSubscriptionId {
  implicit val ordering: Ordering[PgSubscriptionId] = Ordering.by(_.value)
  implicit val format: Format[PgSubscriptionId] = implicitly[Format[/* oid */ Long]].bimap(PgSubscriptionId.apply, _.value)
  implicit val toStatement: ToStatement[PgSubscriptionId] = implicitly[ToStatement[/* oid */ Long]].contramap(_.value)
  implicit val column: Column[PgSubscriptionId] = implicitly[Column[/* oid */ Long]].map(PgSubscriptionId.apply)
  def rowParser(prefix: String): RowParser[PgSubscriptionId] = SqlParser.get[PgSubscriptionId](prefix + "oid")
  implicit val parameterMetadata: ParameterMetaData[PgSubscriptionId] = new ParameterMetaData[PgSubscriptionId] {
    override def sqlType: String = implicitly[ParameterMetaData[/* oid */ Long]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[/* oid */ Long]].jdbcType
  }

}
