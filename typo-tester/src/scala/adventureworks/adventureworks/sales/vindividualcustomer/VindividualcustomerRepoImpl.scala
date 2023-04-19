/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vindividualcustomer

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection

object VindividualcustomerRepoImpl extends VindividualcustomerRepo {
  override def selectAll(implicit c: Connection): List[VindividualcustomerRow] = {
    SQL"select businessentityid, title, firstname, middlename, lastname, suffix, phonenumber, phonenumbertype, emailaddress, emailpromotion, addresstype, addressline1, addressline2, city, stateprovincename, postalcode, countryregionname, demographics from sales.vindividualcustomer".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[VindividualcustomerFieldOrIdValue[_]])(implicit c: Connection): List[VindividualcustomerRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VindividualcustomerFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VindividualcustomerFieldValue.title(value) => NamedParameter("title", ParameterValue.from(value))
          case VindividualcustomerFieldValue.firstname(value) => NamedParameter("firstname", ParameterValue.from(value))
          case VindividualcustomerFieldValue.middlename(value) => NamedParameter("middlename", ParameterValue.from(value))
          case VindividualcustomerFieldValue.lastname(value) => NamedParameter("lastname", ParameterValue.from(value))
          case VindividualcustomerFieldValue.suffix(value) => NamedParameter("suffix", ParameterValue.from(value))
          case VindividualcustomerFieldValue.phonenumber(value) => NamedParameter("phonenumber", ParameterValue.from(value))
          case VindividualcustomerFieldValue.phonenumbertype(value) => NamedParameter("phonenumbertype", ParameterValue.from(value))
          case VindividualcustomerFieldValue.emailaddress(value) => NamedParameter("emailaddress", ParameterValue.from(value))
          case VindividualcustomerFieldValue.emailpromotion(value) => NamedParameter("emailpromotion", ParameterValue.from(value))
          case VindividualcustomerFieldValue.addresstype(value) => NamedParameter("addresstype", ParameterValue.from(value))
          case VindividualcustomerFieldValue.addressline1(value) => NamedParameter("addressline1", ParameterValue.from(value))
          case VindividualcustomerFieldValue.addressline2(value) => NamedParameter("addressline2", ParameterValue.from(value))
          case VindividualcustomerFieldValue.city(value) => NamedParameter("city", ParameterValue.from(value))
          case VindividualcustomerFieldValue.stateprovincename(value) => NamedParameter("stateprovincename", ParameterValue.from(value))
          case VindividualcustomerFieldValue.postalcode(value) => NamedParameter("postalcode", ParameterValue.from(value))
          case VindividualcustomerFieldValue.countryregionname(value) => NamedParameter("countryregionname", ParameterValue.from(value))
          case VindividualcustomerFieldValue.demographics(value) => NamedParameter("demographics", ParameterValue.from(value))
        }
        val q = s"""select * from sales.vindividualcustomer where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[VindividualcustomerRow] =
    RowParser[VindividualcustomerRow] { row =>
      Success(
        VindividualcustomerRow(
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          title = row[Option[String]]("title"),
          firstname = row[Option[Name]]("firstname"),
          middlename = row[Option[Name]]("middlename"),
          lastname = row[Option[Name]]("lastname"),
          suffix = row[Option[String]]("suffix"),
          phonenumber = row[Option[Phone]]("phonenumber"),
          phonenumbertype = row[Option[Name]]("phonenumbertype"),
          emailaddress = row[Option[String]]("emailaddress"),
          emailpromotion = row[Option[Int]]("emailpromotion"),
          addresstype = row[Option[Name]]("addresstype"),
          addressline1 = row[Option[String]]("addressline1"),
          addressline2 = row[Option[String]]("addressline2"),
          city = row[Option[String]]("city"),
          stateprovincename = row[Option[Name]]("stateprovincename"),
          postalcode = row[Option[String]]("postalcode"),
          countryregionname = row[Option[Name]]("countryregionname"),
          demographics = row[Option[/* xml */ String]]("demographics")
        )
      )
    }
}
