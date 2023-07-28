/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package sm

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object SmViewRepoImpl extends SmViewRepo {
  override def selectAll: Stream[ConnectionIO, SmViewRow] = {
    sql"""select "id", shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate from pu.sm""".query[SmViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SmViewFieldOrIdValue[_]]): Stream[ConnectionIO, SmViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SmViewFieldValue.id(value) => fr""""id" = $value"""
        case SmViewFieldValue.shipmethodid(value) => fr"shipmethodid = $value"
        case SmViewFieldValue.name(value) => fr""""name" = $value"""
        case SmViewFieldValue.shipbase(value) => fr"shipbase = $value"
        case SmViewFieldValue.shiprate(value) => fr"shiprate = $value"
        case SmViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case SmViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pu.sm $where".query[SmViewRow].stream
  
  }
}