/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package be

import anorm.SqlStringInterpolation
import java.sql.Connection

object BeViewRepoImpl extends BeViewRepo {
  override def selectAll(implicit c: Connection): List[BeViewRow] = {
    SQL"""select "id", businessentityid, rowguid, modifieddate::text
          from pe.be
       """.as(BeViewRow.rowParser(1).*)
  }
}
