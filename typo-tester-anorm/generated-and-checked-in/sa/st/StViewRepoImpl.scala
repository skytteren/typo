/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package st

import anorm.SqlStringInterpolation
import java.sql.Connection

object StViewRepoImpl extends StViewRepo {
  override def selectAll(implicit c: Connection): List[StViewRow] = {
    SQL"""select "id", territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate::text
          from sa.st
       """.as(StViewRow.rowParser(1).*)
  }
}
