/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package at

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object AtViewRepoImpl extends AtViewRepo {
  override def selectAll: Stream[ConnectionIO, AtViewRow] = {
    sql"""select "id", addresstypeid, "name", rowguid, modifieddate from pe."at"""".query[AtViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[AtViewFieldOrIdValue[_]]): Stream[ConnectionIO, AtViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case AtViewFieldValue.id(value) => fr""""id" = $value"""
        case AtViewFieldValue.addresstypeid(value) => fr"addresstypeid = $value"
        case AtViewFieldValue.name(value) => fr""""name" = $value"""
        case AtViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case AtViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"""select * from pe."at" $where""".query[AtViewRow].stream
  
  }
}
