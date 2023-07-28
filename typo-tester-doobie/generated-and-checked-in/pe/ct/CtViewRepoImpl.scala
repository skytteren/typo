/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package ct

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object CtViewRepoImpl extends CtViewRepo {
  override def selectAll: Stream[ConnectionIO, CtViewRow] = {
    sql"""select "id", contacttypeid, "name", modifieddate::text from pe.ct""".query(CtViewRow.read).stream
  }
}
