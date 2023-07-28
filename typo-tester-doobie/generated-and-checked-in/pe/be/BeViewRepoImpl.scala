/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package be

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object BeViewRepoImpl extends BeViewRepo {
  override def selectAll: Stream[ConnectionIO, BeViewRow] = {
    sql"""select "id", businessentityid, rowguid, modifieddate from pe.be""".query[BeViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[BeViewFieldOrIdValue[_]]): Stream[ConnectionIO, BeViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case BeViewFieldValue.id(value) => fr""""id" = $value"""
        case BeViewFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case BeViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case BeViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pe.be $where".query[BeViewRow].stream
  
  }
}