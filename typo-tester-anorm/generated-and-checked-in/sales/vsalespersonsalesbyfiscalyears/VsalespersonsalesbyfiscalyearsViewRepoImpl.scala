/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalespersonsalesbyfiscalyears

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object VsalespersonsalesbyfiscalyearsViewRepoImpl extends VsalespersonsalesbyfiscalyearsViewRepo {
  override def selectAll(implicit c: Connection): List[VsalespersonsalesbyfiscalyearsViewRow] = {
    SQL"""select SalesPersonID, FullName, JobTitle, SalesTerritory, 2012, 2013, 2014
          from sales.vsalespersonsalesbyfiscalyears
       """.as(VsalespersonsalesbyfiscalyearsViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[VsalespersonsalesbyfiscalyearsViewFieldOrIdValue[_]])(implicit c: Connection): List[VsalespersonsalesbyfiscalyearsViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VsalespersonsalesbyfiscalyearsViewFieldValue.SalesPersonID(value) => NamedParameter("SalesPersonID", ParameterValue.from(value))
          case VsalespersonsalesbyfiscalyearsViewFieldValue.FullName(value) => NamedParameter("FullName", ParameterValue.from(value))
          case VsalespersonsalesbyfiscalyearsViewFieldValue.JobTitle(value) => NamedParameter("JobTitle", ParameterValue.from(value))
          case VsalespersonsalesbyfiscalyearsViewFieldValue.SalesTerritory(value) => NamedParameter("SalesTerritory", ParameterValue.from(value))
          case VsalespersonsalesbyfiscalyearsViewFieldValue.`2012`(value) => NamedParameter("2012", ParameterValue.from(value))
          case VsalespersonsalesbyfiscalyearsViewFieldValue.`2013`(value) => NamedParameter("2013", ParameterValue.from(value))
          case VsalespersonsalesbyfiscalyearsViewFieldValue.`2014`(value) => NamedParameter("2014", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select SalesPersonID, FullName, JobTitle, SalesTerritory, 2012, 2013, 2014
                    from sales.vsalespersonsalesbyfiscalyears
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(VsalespersonsalesbyfiscalyearsViewRow.rowParser(1).*)
    }
  
  }
}
