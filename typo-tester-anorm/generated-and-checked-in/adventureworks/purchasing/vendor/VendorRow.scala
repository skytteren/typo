/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
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

case class VendorRow(
  /** Primary key for Vendor records.  Foreign key to BusinessEntity.BusinessEntityID
      Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Vendor account (identification) number. */
  accountnumber: AccountNumber,
  /** Company name. */
  name: Name,
  /** 1 = Superior, 2 = Excellent, 3 = Above average, 4 = Average, 5 = Below average */
  creditrating: Int,
  /** 0 = Do not use if another vendor is available. 1 = Preferred over other vendors supplying the same product. */
  preferredvendorstatus: Flag,
  /** 0 = Vendor no longer used. 1 = Vendor is actively used. */
  activeflag: Flag,
  /** Vendor URL. */
  purchasingwebserviceurl: Option[/* max 1024 chars */ String],
  modifieddate: TypoLocalDateTime
)

object VendorRow {
  implicit lazy val reads: Reads[VendorRow] = Reads[VendorRow](json => JsResult.fromTry(
      Try(
        VendorRow(
          businessentityid = json.\("businessentityid").as(BusinessentityId.reads),
          accountnumber = json.\("accountnumber").as(AccountNumber.reads),
          name = json.\("name").as(Name.reads),
          creditrating = json.\("creditrating").as(Reads.IntReads),
          preferredvendorstatus = json.\("preferredvendorstatus").as(Flag.reads),
          activeflag = json.\("activeflag").as(Flag.reads),
          purchasingwebserviceurl = json.\("purchasingwebserviceurl").toOption.map(_.as(Reads.StringReads)),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[VendorRow] = RowParser[VendorRow] { row =>
    Success(
      VendorRow(
        businessentityid = row(idx + 0)(BusinessentityId.column),
        accountnumber = row(idx + 1)(AccountNumber.column),
        name = row(idx + 2)(Name.column),
        creditrating = row(idx + 3)(Column.columnToInt),
        preferredvendorstatus = row(idx + 4)(Flag.column),
        activeflag = row(idx + 5)(Flag.column),
        purchasingwebserviceurl = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        modifieddate = row(idx + 7)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val writes: OWrites[VendorRow] = OWrites[VendorRow](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> BusinessentityId.writes.writes(o.businessentityid),
      "accountnumber" -> AccountNumber.writes.writes(o.accountnumber),
      "name" -> Name.writes.writes(o.name),
      "creditrating" -> Writes.IntWrites.writes(o.creditrating),
      "preferredvendorstatus" -> Flag.writes.writes(o.preferredvendorstatus),
      "activeflag" -> Flag.writes.writes(o.activeflag),
      "purchasingwebserviceurl" -> Writes.OptionWrites(Writes.StringWrites).writes(o.purchasingwebserviceurl),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}