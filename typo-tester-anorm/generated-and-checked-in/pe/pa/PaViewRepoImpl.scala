/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import anorm.SqlStringInterpolation
import java.sql.Connection

object PaViewRepoImpl extends PaViewRepo {
  override def selectAll(implicit c: Connection): List[PaViewRow] = {
    SQL"""select "id", businessentityid, passwordhash, passwordsalt, rowguid, modifieddate::text
          from pe.pa
       """.as(PaViewRow.rowParser(1).*)
  }
}
