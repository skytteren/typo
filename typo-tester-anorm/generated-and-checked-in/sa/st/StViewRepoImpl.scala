/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package st

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object StViewRepoImpl extends StViewRepo {
  override def selectAll(implicit c: Connection): List[StViewRow] = {
    SQL"""select "id", territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate
          from sa.st
       """.as(StViewRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[StViewFieldOrIdValue[_]])(implicit c: Connection): List[StViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case StViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case StViewFieldValue.territoryid(value) => NamedParameter("territoryid", ParameterValue.from(value))
          case StViewFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case StViewFieldValue.countryregioncode(value) => NamedParameter("countryregioncode", ParameterValue.from(value))
          case StViewFieldValue.group(value) => NamedParameter("group", ParameterValue.from(value))
          case StViewFieldValue.salesytd(value) => NamedParameter("salesytd", ParameterValue.from(value))
          case StViewFieldValue.saleslastyear(value) => NamedParameter("saleslastyear", ParameterValue.from(value))
          case StViewFieldValue.costytd(value) => NamedParameter("costytd", ParameterValue.from(value))
          case StViewFieldValue.costlastyear(value) => NamedParameter("costlastyear", ParameterValue.from(value))
          case StViewFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case StViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate
                    from sa.st
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(StViewRow.rowParser.*)
    }
  
  }
}
