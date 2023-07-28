/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vvendorwithcontacts

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object VvendorwithcontactsViewRepoImpl extends VvendorwithcontactsViewRepo {
  override def selectAll: Stream[ConnectionIO, VvendorwithcontactsViewRow] = {
    sql"""select businessentityid, "name", contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion from purchasing.vvendorwithcontacts""".query[VvendorwithcontactsViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[VvendorwithcontactsViewFieldOrIdValue[_]]): Stream[ConnectionIO, VvendorwithcontactsViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case VvendorwithcontactsViewFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case VvendorwithcontactsViewFieldValue.name(value) => fr""""name" = $value"""
        case VvendorwithcontactsViewFieldValue.contacttype(value) => fr"contacttype = $value"
        case VvendorwithcontactsViewFieldValue.title(value) => fr"title = $value"
        case VvendorwithcontactsViewFieldValue.firstname(value) => fr"firstname = $value"
        case VvendorwithcontactsViewFieldValue.middlename(value) => fr"middlename = $value"
        case VvendorwithcontactsViewFieldValue.lastname(value) => fr"lastname = $value"
        case VvendorwithcontactsViewFieldValue.suffix(value) => fr"suffix = $value"
        case VvendorwithcontactsViewFieldValue.phonenumber(value) => fr"phonenumber = $value"
        case VvendorwithcontactsViewFieldValue.phonenumbertype(value) => fr"phonenumbertype = $value"
        case VvendorwithcontactsViewFieldValue.emailaddress(value) => fr"emailaddress = $value"
        case VvendorwithcontactsViewFieldValue.emailpromotion(value) => fr"emailpromotion = $value"
      } :_*
    )
    sql"select * from purchasing.vvendorwithcontacts $where".query[VvendorwithcontactsViewRow].stream
  
  }
}