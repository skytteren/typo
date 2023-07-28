/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sth

import anorm.SqlStringInterpolation
import java.sql.Connection

object SthViewRepoImpl extends SthViewRepo {
  override def selectAll(implicit c: Connection): List[SthViewRow] = {
    SQL"""select "id", businessentityid, territoryid, startdate::text, enddate::text, rowguid, modifieddate::text
          from sa.sth
       """.as(SthViewRow.rowParser(1).*)
  }
}
