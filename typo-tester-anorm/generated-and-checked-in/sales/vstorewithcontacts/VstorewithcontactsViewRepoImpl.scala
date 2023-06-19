/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithcontacts

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object VstorewithcontactsViewRepoImpl extends VstorewithcontactsViewRepo {
  override def selectAll(implicit c: Connection): List[VstorewithcontactsViewRow] = {
    SQL"""select businessentityid, "name", contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion
          from sales.vstorewithcontacts
       """.as(VstorewithcontactsViewRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[VstorewithcontactsViewFieldOrIdValue[_]])(implicit c: Connection): List[VstorewithcontactsViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VstorewithcontactsViewFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.contacttype(value) => NamedParameter("contacttype", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.title(value) => NamedParameter("title", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.firstname(value) => NamedParameter("firstname", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.middlename(value) => NamedParameter("middlename", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.lastname(value) => NamedParameter("lastname", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.suffix(value) => NamedParameter("suffix", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.phonenumber(value) => NamedParameter("phonenumber", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.phonenumbertype(value) => NamedParameter("phonenumbertype", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.emailaddress(value) => NamedParameter("emailaddress", ParameterValue.from(value))
          case VstorewithcontactsViewFieldValue.emailpromotion(value) => NamedParameter("emailpromotion", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select businessentityid, "name", contacttype, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion
                    from sales.vstorewithcontacts
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(VstorewithcontactsViewRow.rowParser.*)
    }
  
  }
}
