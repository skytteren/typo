/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package psc

import anorm.SqlStringInterpolation
import java.sql.Connection

object PscViewRepoImpl extends PscViewRepo {
  override def selectAll(implicit c: Connection): List[PscViewRow] = {
    SQL"""select "id", productsubcategoryid, productcategoryid, "name", rowguid, modifieddate::text
          from pr.psc
       """.as(PscViewRow.rowParser(1).*)
  }
}
