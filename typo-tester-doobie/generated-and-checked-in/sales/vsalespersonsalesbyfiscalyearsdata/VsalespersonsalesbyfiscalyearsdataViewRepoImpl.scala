/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalespersonsalesbyfiscalyearsdata

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object VsalespersonsalesbyfiscalyearsdataViewRepoImpl extends VsalespersonsalesbyfiscalyearsdataViewRepo {
  override def selectAll: Stream[ConnectionIO, VsalespersonsalesbyfiscalyearsdataViewRow] = {
    sql"select salespersonid, fullname, jobtitle, salesterritory, salestotal, fiscalyear from sales.vsalespersonsalesbyfiscalyearsdata".query[VsalespersonsalesbyfiscalyearsdataViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[VsalespersonsalesbyfiscalyearsdataViewFieldOrIdValue[_]]): Stream[ConnectionIO, VsalespersonsalesbyfiscalyearsdataViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case VsalespersonsalesbyfiscalyearsdataViewFieldValue.salespersonid(value) => fr"salespersonid = $value"
        case VsalespersonsalesbyfiscalyearsdataViewFieldValue.fullname(value) => fr"fullname = $value"
        case VsalespersonsalesbyfiscalyearsdataViewFieldValue.jobtitle(value) => fr"jobtitle = $value"
        case VsalespersonsalesbyfiscalyearsdataViewFieldValue.salesterritory(value) => fr"salesterritory = $value"
        case VsalespersonsalesbyfiscalyearsdataViewFieldValue.salestotal(value) => fr"salestotal = $value"
        case VsalespersonsalesbyfiscalyearsdataViewFieldValue.fiscalyear(value) => fr"fiscalyear = $value"
      } :_*
    )
    sql"select * from sales.vsalespersonsalesbyfiscalyearsdata $where".query[VsalespersonsalesbyfiscalyearsdataViewRow].stream
  
  }
}
