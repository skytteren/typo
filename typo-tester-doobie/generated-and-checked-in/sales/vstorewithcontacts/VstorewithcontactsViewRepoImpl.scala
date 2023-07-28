/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithcontacts

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object VstorewithcontactsViewRepoImpl extends VstorewithcontactsViewRepo {
  override def selectAll: Stream[ConnectionIO, VstorewithcontactsViewRow] = {
    sql"""select businessentityid, "name", contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion from sales.vstorewithcontacts""".query(VstorewithcontactsViewRow.read).stream
  }
}
