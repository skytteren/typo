/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package tr

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object TrViewRepoImpl extends TrViewRepo {
  override def selectAll: Stream[ConnectionIO, TrViewRow] = {
    sql"""select "id", salestaxrateid, stateprovinceid, taxtype, taxrate, "name", rowguid, modifieddate from sa.tr""".query[TrViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[TrViewFieldOrIdValue[_]]): Stream[ConnectionIO, TrViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case TrViewFieldValue.id(value) => fr""""id" = $value"""
        case TrViewFieldValue.salestaxrateid(value) => fr"salestaxrateid = $value"
        case TrViewFieldValue.stateprovinceid(value) => fr"stateprovinceid = $value"
        case TrViewFieldValue.taxtype(value) => fr"taxtype = $value"
        case TrViewFieldValue.taxrate(value) => fr"taxrate = $value"
        case TrViewFieldValue.name(value) => fr""""name" = $value"""
        case TrViewFieldValue.rowguid(value) => fr"rowguid = $value"
        case TrViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sa.tr $where".query[TrViewRow].stream
  
  }
}
