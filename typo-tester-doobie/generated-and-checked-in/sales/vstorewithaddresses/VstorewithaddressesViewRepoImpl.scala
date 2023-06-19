/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithaddresses

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object VstorewithaddressesViewRepoImpl extends VstorewithaddressesViewRepo {
  override def selectAll: Stream[ConnectionIO, VstorewithaddressesViewRow] = {
    sql"""select businessentityid, "name", addresstype, addressline1, addressline2, city, stateprovincename, postalcode, countryregionname from sales.vstorewithaddresses""".query[VstorewithaddressesViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[VstorewithaddressesViewFieldOrIdValue[_]]): Stream[ConnectionIO, VstorewithaddressesViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case VstorewithaddressesViewFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case VstorewithaddressesViewFieldValue.name(value) => fr""""name" = $value"""
        case VstorewithaddressesViewFieldValue.addresstype(value) => fr"addresstype = $value"
        case VstorewithaddressesViewFieldValue.addressline1(value) => fr"addressline1 = $value"
        case VstorewithaddressesViewFieldValue.addressline2(value) => fr"addressline2 = $value"
        case VstorewithaddressesViewFieldValue.city(value) => fr"city = $value"
        case VstorewithaddressesViewFieldValue.stateprovincename(value) => fr"stateprovincename = $value"
        case VstorewithaddressesViewFieldValue.postalcode(value) => fr"postalcode = $value"
        case VstorewithaddressesViewFieldValue.countryregionname(value) => fr"countryregionname = $value"
      } :_*
    )
    sql"select * from sales.vstorewithaddresses $where".query[VstorewithaddressesViewRow].stream
  
  }
}
