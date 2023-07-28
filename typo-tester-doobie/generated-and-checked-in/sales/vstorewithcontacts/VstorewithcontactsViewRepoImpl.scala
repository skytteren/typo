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
import doobie.util.fragments
import fs2.Stream

object VstorewithcontactsViewRepoImpl extends VstorewithcontactsViewRepo {
  override def selectAll: Stream[ConnectionIO, VstorewithcontactsViewRow] = {
    sql"""select businessentityid, "name", contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion from sales.vstorewithcontacts""".query[VstorewithcontactsViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[VstorewithcontactsViewFieldOrIdValue[_]]): Stream[ConnectionIO, VstorewithcontactsViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case VstorewithcontactsViewFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case VstorewithcontactsViewFieldValue.name(value) => fr""""name" = $value"""
        case VstorewithcontactsViewFieldValue.contacttype(value) => fr"contacttype = $value"
        case VstorewithcontactsViewFieldValue.title(value) => fr"title = $value"
        case VstorewithcontactsViewFieldValue.firstname(value) => fr"firstname = $value"
        case VstorewithcontactsViewFieldValue.middlename(value) => fr"middlename = $value"
        case VstorewithcontactsViewFieldValue.lastname(value) => fr"lastname = $value"
        case VstorewithcontactsViewFieldValue.suffix(value) => fr"suffix = $value"
        case VstorewithcontactsViewFieldValue.phonenumber(value) => fr"phonenumber = $value"
        case VstorewithcontactsViewFieldValue.phonenumbertype(value) => fr"phonenumbertype = $value"
        case VstorewithcontactsViewFieldValue.emailaddress(value) => fr"emailaddress = $value"
        case VstorewithcontactsViewFieldValue.emailpromotion(value) => fr"emailpromotion = $value"
      } :_*
    )
    sql"select * from sales.vstorewithcontacts $where".query[VstorewithcontactsViewRow].stream
  
  }
}