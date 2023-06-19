/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sod

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object SodViewRepoImpl extends SodViewRepo {
  override def selectAll: Stream[ConnectionIO, SodViewRow] = {
    sql"""select "id", salesorderid, salesorderdetailid, carriertrackingnumber, orderqty, productid, specialofferid, unitprice, unitpricediscount, rowguid, modifieddate from sa.sod""".query[SodViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SodViewFieldOrIdValue[_]]): Stream[ConnectionIO, SodViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SodViewFieldValue.id(value) => fr""""id" = $value"""
        case SodViewFieldValue.salesorderid(value) => fr"salesorderid = $value"
        case SodViewFieldValue.salesorderdetailid(value) => fr"salesorderdetailid = $value"
        case SodViewFieldValue.carriertrackingnumber(value) => fr"carriertrackingnumber = $value"
        case SodViewFieldValue.orderqty(value) => fr"orderqty = $value"
        case SodViewFieldValue.productid(value) => fr"productid = $value"
        case SodViewFieldValue.specialofferid(value) => fr"specialofferid = $value"
        case SodViewFieldValue.unitprice(value) => fr"unitprice = $value"
        case SodViewFieldValue.unitpricediscount(value) => fr"unitpricediscount = $value"
        case SodViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case SodViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sa.sod $where".query[SodViewRow].stream
  
  }
}
