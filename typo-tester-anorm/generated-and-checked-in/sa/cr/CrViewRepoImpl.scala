/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cr

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object CrViewRepoImpl extends CrViewRepo {
  override def selectAll(implicit c: Connection): List[CrViewRow] = {
    SQL"""select currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
          from sa.cr
       """.as(CrViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[CrViewFieldOrIdValue[_]])(implicit c: Connection): List[CrViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CrViewFieldValue.currencyrateid(value) => NamedParameter("currencyrateid", ParameterValue.from(value))
          case CrViewFieldValue.currencyratedate(value) => NamedParameter("currencyratedate", ParameterValue.from(value))
          case CrViewFieldValue.fromcurrencycode(value) => NamedParameter("fromcurrencycode", ParameterValue.from(value))
          case CrViewFieldValue.tocurrencycode(value) => NamedParameter("tocurrencycode", ParameterValue.from(value))
          case CrViewFieldValue.averagerate(value) => NamedParameter("averagerate", ParameterValue.from(value))
          case CrViewFieldValue.endofdayrate(value) => NamedParameter("endofdayrate", ParameterValue.from(value))
          case CrViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
                    from sa.cr
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(CrViewRow.rowParser(1).*)
    }
  
  }
}