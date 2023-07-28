/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package a

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object AViewRepoImpl extends AViewRepo {
  override def selectAll: Stream[ConnectionIO, AViewRow] = {
    sql"""select "id", addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate from pe."a"""".query[AViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[AViewFieldOrIdValue[_]]): Stream[ConnectionIO, AViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case AViewFieldValue.id(value) => fr""""id" = $value"""
        case AViewFieldValue.addressid(value) => fr"addressid = $value"
        case AViewFieldValue.addressline1(value) => fr"addressline1 = $value"
        case AViewFieldValue.addressline2(value) => fr"addressline2 = $value"
        case AViewFieldValue.city(value) => fr"city = $value"
        case AViewFieldValue.stateprovinceid(value) => fr"stateprovinceid = $value"
        case AViewFieldValue.postalcode(value) => fr"postalcode = $value"
        case AViewFieldValue.spatiallocation(value) => fr"spatiallocation = $value"
        case AViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case AViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"""select * from pe."a" $where""".query[AViewRow].stream
  
  }
}