/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package edh

import anorm.SqlStringInterpolation
import java.sql.Connection

object EdhViewRepoImpl extends EdhViewRepo {
  override def selectAll(implicit c: Connection): List[EdhViewRow] = {
    SQL"""select "id", businessentityid, departmentid, shiftid, startdate::text, enddate::text, modifieddate::text
          from hr.edh
       """.as(EdhViewRow.rowParser(1).*)
  }
}
