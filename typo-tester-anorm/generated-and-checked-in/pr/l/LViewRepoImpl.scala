/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package l

import anorm.SqlStringInterpolation
import java.sql.Connection

object LViewRepoImpl extends LViewRepo {
  override def selectAll(implicit c: Connection): List[LViewRow] = {
    SQL"""select "id", locationid, "name", costrate, availability, modifieddate::text
          from pr.l
       """.as(LViewRow.rowParser(1).*)
  }
}
