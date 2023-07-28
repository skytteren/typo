/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object PcViewRepoImpl extends PcViewRepo {
  override def selectAll: Stream[ConnectionIO, PcViewRow] = {
    sql"""select "id", productcategoryid, "name", rowguid, modifieddate from pr.pc""".query[PcViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[PcViewFieldOrIdValue[_]]): Stream[ConnectionIO, PcViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case PcViewFieldValue.id(value) => fr""""id" = $value"""
        case PcViewFieldValue.productcategoryid(value) => fr"productcategoryid = $value"
        case PcViewFieldValue.name(value) => fr""""name" = $value"""
        case PcViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case PcViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pr.pc $where".query[PcViewRow].stream
  
  }
}