/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package s

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object SViewRepoImpl extends SViewRepo {
  override def selectAll: Stream[ConnectionIO, SViewRow] = {
    sql"""select "id", shiftid, "name", starttime, endtime, modifieddate from hr.s""".query[SViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SViewFieldOrIdValue[_]]): Stream[ConnectionIO, SViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SViewFieldValue.id(value) => fr""""id" = $value"""
        case SViewFieldValue.shiftid(value) => fr"shiftid = $value"
        case SViewFieldValue.name(value) => fr""""name" = $value"""
        case SViewFieldValue.starttime(value) => fr"starttime = $value"
        case SViewFieldValue.endtime(value) => fr"endtime = $value"
        case SViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from hr.s $where".query[SViewRow].stream
  
  }
}
