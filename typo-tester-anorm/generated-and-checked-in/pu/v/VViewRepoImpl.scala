/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package v

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object VViewRepoImpl extends VViewRepo {
  override def selectAll(implicit c: Connection): List[VViewRow] = {
    SQL"""select "id", businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate
          from pu.v
       """.as(VViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[VViewFieldOrIdValue[_]])(implicit c: Connection): List[VViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case VViewFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VViewFieldValue.accountnumber(value) => NamedParameter("accountnumber", ParameterValue.from(value))
          case VViewFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case VViewFieldValue.creditrating(value) => NamedParameter("creditrating", ParameterValue.from(value))
          case VViewFieldValue.preferredvendorstatus(value) => NamedParameter("preferredvendorstatus", ParameterValue.from(value))
          case VViewFieldValue.activeflag(value) => NamedParameter("activeflag", ParameterValue.from(value))
          case VViewFieldValue.purchasingwebserviceurl(value) => NamedParameter("purchasingwebserviceurl", ParameterValue.from(value))
          case VViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate
                    from pu.v
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(VViewRow.rowParser(1).*)
    }
  
  }
}