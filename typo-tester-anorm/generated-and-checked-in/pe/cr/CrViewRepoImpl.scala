/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package cr

import anorm.SqlStringInterpolation
import java.sql.Connection

object CrViewRepoImpl extends CrViewRepo {
  override def selectAll(implicit c: Connection): List[CrViewRow] = {
    SQL"""select countryregioncode, "name", modifieddate::text
          from pe.cr
       """.as(CrViewRow.rowParser(1).*)
  }
}
