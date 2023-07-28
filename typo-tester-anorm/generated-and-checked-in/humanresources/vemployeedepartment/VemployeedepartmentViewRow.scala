/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartment

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import java.time.LocalDate
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VemployeedepartmentViewRow(
  /** Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: Option[Name],
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Option[Name],
  /** Points to [[person.person.PersonRow.suffix]] */
  suffix: Option[/* max 10 chars */ String],
  /** Points to [[employee.EmployeeRow.jobtitle]] */
  jobtitle: Option[/* max 50 chars */ String],
  department: Option[Name],
  /** Points to [[department.DepartmentRow.groupname]] */
  groupname: Option[Name],
  /** Points to [[employeedepartmenthistory.EmployeedepartmenthistoryRow.startdate]] */
  startdate: Option[LocalDate]
)

object VemployeedepartmentViewRow {
  def rowParser(idx: Int): RowParser[VemployeedepartmentViewRow] =
    RowParser[VemployeedepartmentViewRow] { row =>
      Success(
        VemployeedepartmentViewRow(
          businessentityid = row[Option[BusinessentityId]](idx + 0),
          title = row[Option[/* max 8 chars */ String]](idx + 1),
          firstname = row[Option[Name]](idx + 2),
          middlename = row[Option[Name]](idx + 3),
          lastname = row[Option[Name]](idx + 4),
          suffix = row[Option[/* max 10 chars */ String]](idx + 5),
          jobtitle = row[Option[/* max 50 chars */ String]](idx + 6),
          department = row[Option[Name]](idx + 7),
          groupname = row[Option[Name]](idx + 8),
          startdate = row[Option[LocalDate]](idx + 9)
        )
      )
    }
  implicit val oFormat: OFormat[VemployeedepartmentViewRow] = new OFormat[VemployeedepartmentViewRow]{
    override def writes(o: VemployeedepartmentViewRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "title" -> o.title,
        "firstname" -> o.firstname,
        "middlename" -> o.middlename,
        "lastname" -> o.lastname,
        "suffix" -> o.suffix,
        "jobtitle" -> o.jobtitle,
        "department" -> o.department,
        "groupname" -> o.groupname,
        "startdate" -> o.startdate
      )
  
    override def reads(json: JsValue): JsResult[VemployeedepartmentViewRow] = {
      JsResult.fromTry(
        Try(
          VemployeedepartmentViewRow(
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            title = json.\("title").toOption.map(_.as[/* max 8 chars */ String]),
            firstname = json.\("firstname").toOption.map(_.as[Name]),
            middlename = json.\("middlename").toOption.map(_.as[Name]),
            lastname = json.\("lastname").toOption.map(_.as[Name]),
            suffix = json.\("suffix").toOption.map(_.as[/* max 10 chars */ String]),
            jobtitle = json.\("jobtitle").toOption.map(_.as[/* max 50 chars */ String]),
            department = json.\("department").toOption.map(_.as[Name]),
            groupname = json.\("groupname").toOption.map(_.as[Name]),
            startdate = json.\("startdate").toOption.map(_.as[LocalDate])
          )
        )
      )
    }
  }
}