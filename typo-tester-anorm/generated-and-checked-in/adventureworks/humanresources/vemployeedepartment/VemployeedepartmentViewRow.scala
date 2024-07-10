/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vemployeedepartment

import adventureworks.customtypes.TypoLocalDate
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.userdefined.FirstName
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/**
 *View: humanresources.vemployeedepartment */
case class VemployeedepartmentViewRow(
  /** Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: /* user-picked */ FirstName,
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]] */
  lastname: Name,
  /** Points to [[person.person.PersonRow.suffix]] */
  suffix: Option[/* max 10 chars */ String],
  /** Points to [[employee.EmployeeRow.jobtitle]] */
  jobtitle: /* max 50 chars */ String,
  /** Points to [[department.DepartmentRow.name]] */
  department: Name,
  /** Points to [[department.DepartmentRow.groupname]] */
  groupname: Name,
  /** Points to [[employeedepartmenthistory.EmployeedepartmenthistoryRow.startdate]] */
  startdate: TypoLocalDate
)

object VemployeedepartmentViewRow {
  implicit lazy val reads: Reads[VemployeedepartmentViewRow] = Reads[VemployeedepartmentViewRow](json => JsResult.fromTry(
      Try(
        VemployeedepartmentViewRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          title = json.\("title").toOption.map(_.as(Reads.StringReads)),
          firstname = json.\("firstname").as(FirstName.reads),
          middlename = json.\("middlename").toOption.map(_.as(Name.reads)),
          lastname = json.\("lastname").as(Name.reads),
          suffix = json.\("suffix").toOption.map(_.as(Reads.StringReads)),
          jobtitle = json.\("jobtitle").as(Reads.StringReads),
          department = json.\("department").as(Name.reads),
          groupname = json.\("groupname").as(Name.reads),
          startdate = json.\("startdate").as(TypoLocalDate.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VemployeedepartmentViewRow] = RowParser[VemployeedepartmentViewRow] { row =>
    Success(
      VemployeedepartmentViewRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        title = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        firstname = row(idx + 2)(/* user-picked */ FirstName.column),
        middlename = row(idx + 3)(Column.columnToOption(Name.column)),
        lastname = row(idx + 4)(Name.column),
        suffix = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        jobtitle = row(idx + 6)(Column.columnToString),
        department = row(idx + 7)(Name.column),
        groupname = row(idx + 8)(Name.column),
        startdate = row(idx + 9)(TypoLocalDate.column)
      )
    )
  }
  implicit lazy val writes: OWrites[VemployeedepartmentViewRow] = OWrites[VemployeedepartmentViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "title" -> Writes.OptionWrites(Writes.StringWrites).writes(o.title),
      "firstname" -> FirstName.writes.writes(o.firstname),
      "middlename" -> Writes.OptionWrites(Name.writes).writes(o.middlename),
      "lastname" -> Name.writes.writes(o.lastname),
      "suffix" -> Writes.OptionWrites(Writes.StringWrites).writes(o.suffix),
      "jobtitle" -> Writes.StringWrites.writes(o.jobtitle),
      "department" -> Name.writes.writes(o.department),
      "groupname" -> Name.writes.writes(o.groupname),
      "startdate" -> TypoLocalDate.writes.writes(o.startdate)
    ))
  )
}
