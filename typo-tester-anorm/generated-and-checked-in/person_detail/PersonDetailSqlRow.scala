/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person_detail

import adventureworks.customtype.FirstName
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
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

case class PersonDetailSqlRow(
  /** Points to [[sales.salesperson.SalespersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Points to [[person.person.PersonRow.title]] */
  title: Option[/* max 8 chars */ String],
  /** Points to [[person.person.PersonRow.firstname]] */
  firstname: /* user-picked */ FirstName,
  /** Points to [[person.person.PersonRow.middlename]] */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.namestyle]] */
  namestyle: NameStyle,
  /** Points to [[humanresources.employee.EmployeeRow.jobtitle]] */
  jobtitle: /* max 50 chars */ String,
  /** Points to [[person.address.AddressRow.addressline1]] */
  addressline1: Option[/* max 60 chars */ String],
  /** Points to [[person.address.AddressRow.city]] */
  city: Option[/* max 30 chars */ String],
  /** Points to [[person.address.AddressRow.postalcode]] */
  postalcode: Option[/* max 15 chars */ String]
)

object PersonDetailSqlRow {
  implicit lazy val reads: Reads[PersonDetailSqlRow] = Reads[PersonDetailSqlRow](json => JsResult.fromTry(
      Try(
        PersonDetailSqlRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          title = json.\("title").toOption.map(_.as(Reads.StringReads)),
          firstname = json.\("firstname").as(FirstName.reads),
          middlename = json.\("middlename").toOption.map(_.as(Name.reads)),
          namestyle = json.\("namestyle").as(NameStyle.reads),
          jobtitle = json.\("jobtitle").as(Reads.StringReads),
          addressline1 = json.\("addressline1").toOption.map(_.as(Reads.StringReads)),
          city = json.\("city").toOption.map(_.as(Reads.StringReads)),
          postalcode = json.\("postalcode").toOption.map(_.as(Reads.StringReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PersonDetailSqlRow] = RowParser[PersonDetailSqlRow] { row =>
    Success(
      PersonDetailSqlRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        title = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        firstname = row(idx + 2)(/* user-picked */ FirstName.column),
        middlename = row(idx + 3)(Column.columnToOption(Name.column)),
        namestyle = row(idx + 4)(NameStyle.column),
        jobtitle = row(idx + 5)(Column.columnToString),
        addressline1 = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        city = row(idx + 7)(Column.columnToOption(Column.columnToString)),
        postalcode = row(idx + 8)(Column.columnToOption(Column.columnToString))
      )
    )
  }
  implicit lazy val writes: OWrites[PersonDetailSqlRow] = OWrites[PersonDetailSqlRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "title" -> Writes.OptionWrites(Writes.StringWrites).writes(o.title),
      "firstname" -> FirstName.writes.writes(o.firstname),
      "middlename" -> Writes.OptionWrites(Name.writes).writes(o.middlename),
      "namestyle" -> NameStyle.writes.writes(o.namestyle),
      "jobtitle" -> Writes.StringWrites.writes(o.jobtitle),
      "addressline1" -> Writes.OptionWrites(Writes.StringWrites).writes(o.addressline1),
      "city" -> Writes.OptionWrites(Writes.StringWrites).writes(o.city),
      "postalcode" -> Writes.OptionWrites(Writes.StringWrites).writes(o.postalcode)
    ))
  )
}
