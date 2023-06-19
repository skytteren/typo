/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package psc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object PscViewRepoImpl extends PscViewRepo {
  override def selectAll: Stream[ConnectionIO, PscViewRow] = {
    sql"""select "id", productsubcategoryid, productcategoryid, "name", rowguid, modifieddate from pr.psc""".query[PscViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[PscViewFieldOrIdValue[_]]): Stream[ConnectionIO, PscViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case PscViewFieldValue.id(value) => fr""""id" = $value"""
        case PscViewFieldValue.productsubcategoryid(value) => fr"productsubcategoryid = $value"
        case PscViewFieldValue.productcategoryid(value) => fr"productcategoryid = $value"
        case PscViewFieldValue.name(value) => fr""""name" = $value"""
        case PscViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case PscViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pr.psc $where".query[PscViewRow].stream
  
  }
}
