/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sth

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object SthViewRepoImpl extends SthViewRepo {
  override def selectAll: Stream[ConnectionIO, SthViewRow] = {
    sql"""select "id", businessentityid, territoryid, startdate, enddate, rowguid, modifieddate from sa.sth""".query[SthViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SthViewFieldOrIdValue[_]]): Stream[ConnectionIO, SthViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SthViewFieldValue.id(value) => fr""""id" = $value"""
        case SthViewFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case SthViewFieldValue.territoryid(value) => fr"territoryid = $value"
        case SthViewFieldValue.startdate(value) => fr"startdate = $value"
        case SthViewFieldValue.enddate(value) => fr"enddate = $value"
        case SthViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case SthViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sa.sth $where".query[SthViewRow].stream
  
  }
}
