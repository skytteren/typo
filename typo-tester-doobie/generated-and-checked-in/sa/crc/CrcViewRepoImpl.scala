/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package crc

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object CrcViewRepoImpl extends CrcViewRepo {
  override def selectAll: Stream[ConnectionIO, CrcViewRow] = {
    sql"select countryregioncode, currencycode, modifieddate from sa.crc".query[CrcViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[CrcViewFieldOrIdValue[_]]): Stream[ConnectionIO, CrcViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case CrcViewFieldValue.countryregioncode(value) => fr"countryregioncode = $value"
        case CrcViewFieldValue.currencycode(value) => fr"currencycode = $value"
        case CrcViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sa.crc $where".query[CrcViewRow].stream
  
  }
}
