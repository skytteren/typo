/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package w

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object WViewRepoImpl extends WViewRepo {
  override def selectAll: Stream[ConnectionIO, WViewRow] = {
    sql"""select "id", workorderid, productid, orderqty, scrappedqty, startdate::text, enddate::text, duedate::text, scrapreasonid, modifieddate::text from pr.w""".query[WViewRow].stream
  }
}
