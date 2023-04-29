/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cr

import adventureworks.sales.currency.CurrencyId
import adventureworks.sales.currencyrate.CurrencyrateId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object CrRepoImpl extends CrRepo {
  override def selectAll(implicit c: Connection): List[CrRow] = {
    SQL"""select currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
          from sa.cr
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CrFieldOrIdValue[_]])(implicit c: Connection): List[CrRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CrFieldValue.currencyrateid(value) => NamedParameter("currencyrateid", ParameterValue.from(value))
          case CrFieldValue.currencyratedate(value) => NamedParameter("currencyratedate", ParameterValue.from(value))
          case CrFieldValue.fromcurrencycode(value) => NamedParameter("fromcurrencycode", ParameterValue.from(value))
          case CrFieldValue.tocurrencycode(value) => NamedParameter("tocurrencycode", ParameterValue.from(value))
          case CrFieldValue.averagerate(value) => NamedParameter("averagerate", ParameterValue.from(value))
          case CrFieldValue.endofdayrate(value) => NamedParameter("endofdayrate", ParameterValue.from(value))
          case CrFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
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
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[CrRow] =
    RowParser[CrRow] { row =>
      Success(
        CrRow(
          currencyrateid = row[Option[CurrencyrateId]]("currencyrateid"),
          currencyratedate = row[Option[LocalDateTime]]("currencyratedate"),
          fromcurrencycode = row[Option[CurrencyId]]("fromcurrencycode"),
          tocurrencycode = row[Option[CurrencyId]]("tocurrencycode"),
          averagerate = row[Option[BigDecimal]]("averagerate"),
          endofdayrate = row[Option[BigDecimal]]("endofdayrate"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}
