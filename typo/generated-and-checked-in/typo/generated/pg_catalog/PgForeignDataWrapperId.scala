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
import anorm.RowParser
import anorm.SqlParser
import anorm.ToStatement
import play.api.libs.json.Format

case class PgForeignDataWrapperId(value: Long) extends AnyVal
object PgForeignDataWrapperId {
  implicit val ordering: Ordering[PgForeignDataWrapperId] = Ordering.by(_.value)
  implicit val format: Format[PgForeignDataWrapperId] = implicitly[Format[Long]].bimap(PgForeignDataWrapperId.apply, _.value)
  implicit val toStatement: ToStatement[PgForeignDataWrapperId] = implicitly[ToStatement[Long]].contramap(_.value)
  implicit val column: Column[PgForeignDataWrapperId] = implicitly[Column[Long]].map(PgForeignDataWrapperId.apply)
  implicit val rowParser: RowParser[PgForeignDataWrapperId] = SqlParser.get[PgForeignDataWrapperId]("oid")
}