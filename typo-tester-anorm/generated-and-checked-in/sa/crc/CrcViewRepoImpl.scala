/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package crc

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object CrcViewRepoImpl extends CrcViewRepo {
  override def selectAll(implicit c: Connection): List[CrcViewRow] = {
    SQL"""select countryregioncode, currencycode, modifieddate
          from sa.crc
       """.as(CrcViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[CrcViewFieldOrIdValue[_]])(implicit c: Connection): List[CrcViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CrcViewFieldValue.countryregioncode(value) => NamedParameter("countryregioncode", ParameterValue.from(value))
          case CrcViewFieldValue.currencycode(value) => NamedParameter("currencycode", ParameterValue.from(value))
          case CrcViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select countryregioncode, currencycode, modifieddate
                    from sa.crc
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(CrcViewRow.rowParser(1).*)
    }
  
  }
}