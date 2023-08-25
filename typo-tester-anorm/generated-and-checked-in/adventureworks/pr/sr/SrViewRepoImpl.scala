/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package sr

import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql

object SrViewRepoImpl extends SrViewRepo {
  override def select: SelectBuilder[SrViewFields, SrViewRow] = {
    SelectBuilderSql("pr.sr", SrViewFields, SrViewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SrViewRow] = {
    SQL"""select "id", scrapreasonid, "name", modifieddate::text
          from pr.sr
       """.as(SrViewRow.rowParser(1).*)
  }
}