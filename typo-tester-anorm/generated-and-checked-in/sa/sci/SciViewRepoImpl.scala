/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sci

import anorm.SqlStringInterpolation
import java.sql.Connection

object SciViewRepoImpl extends SciViewRepo {
  override def selectAll(implicit c: Connection): List[SciViewRow] = {
    SQL"""select "id", shoppingcartitemid, shoppingcartid, quantity, productid, datecreated::text, modifieddate::text
          from sa.sci
       """.as(SciViewRow.rowParser(1).*)
  }
}
