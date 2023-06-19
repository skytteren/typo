/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithdemographics

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object VstorewithdemographicsViewRepoImpl extends VstorewithdemographicsViewRepo {
  override def selectAll(implicit c: Connection): List[VstorewithdemographicsViewRow] = {
    SQL"""select businessentityid, "name", AnnualSales::numeric, AnnualRevenue::numeric, BankName, BusinessType, YearOpened, Specialty, SquareFeet, Brands, Internet, NumberEmployees
          from sales.vstorewithdemographics
       """.as(VstorewithdemographicsViewRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[VstorewithdemographicsViewFieldOrIdValue[_]])(implicit c: Connection): List[VstorewithdemographicsViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VstorewithdemographicsViewFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VstorewithdemographicsViewFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case VstorewithdemographicsViewFieldValue.AnnualSales(value) => NamedParameter("AnnualSales", ParameterValue.from(value))
          case VstorewithdemographicsViewFieldValue.AnnualRevenue(value) => NamedParameter("AnnualRevenue", ParameterValue.from(value))
          case VstorewithdemographicsViewFieldValue.BankName(value) => NamedParameter("BankName", ParameterValue.from(value))
          case VstorewithdemographicsViewFieldValue.BusinessType(value) => NamedParameter("BusinessType", ParameterValue.from(value))
          case VstorewithdemographicsViewFieldValue.YearOpened(value) => NamedParameter("YearOpened", ParameterValue.from(value))
          case VstorewithdemographicsViewFieldValue.Specialty(value) => NamedParameter("Specialty", ParameterValue.from(value))
          case VstorewithdemographicsViewFieldValue.SquareFeet(value) => NamedParameter("SquareFeet", ParameterValue.from(value))
          case VstorewithdemographicsViewFieldValue.Brands(value) => NamedParameter("Brands", ParameterValue.from(value))
          case VstorewithdemographicsViewFieldValue.Internet(value) => NamedParameter("Internet", ParameterValue.from(value))
          case VstorewithdemographicsViewFieldValue.NumberEmployees(value) => NamedParameter("NumberEmployees", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select businessentityid, "name", AnnualSales::numeric, AnnualRevenue::numeric, BankName, BusinessType, YearOpened, Specialty, SquareFeet, Brands, Internet, NumberEmployees
                    from sales.vstorewithdemographics
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(VstorewithdemographicsViewRow.rowParser.*)
    }
  
  }
}
