/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package cr

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object CrViewRepoImpl extends CrViewRepo {
  override def selectAll: Stream[ConnectionIO, CrViewRow] = {
    sql"""select countryregioncode, "name", modifieddate from pe.cr""".query[CrViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[CrViewFieldOrIdValue[_]]): Stream[ConnectionIO, CrViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case CrViewFieldValue.countryregioncode(value) => fr"countryregioncode = $value"
        case CrViewFieldValue.name(value) => fr""""name" = $value"""
        case CrViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pe.cr $where".query[CrViewRow].stream
  
  }
}