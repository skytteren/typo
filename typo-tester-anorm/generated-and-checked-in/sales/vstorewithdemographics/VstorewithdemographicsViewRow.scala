/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vstorewithdemographics

import adventureworks.TypoMoney
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VstorewithdemographicsViewRow(
  /** Points to [[store.StoreRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[store.StoreRow.name]] */
  name: Option[Name],
  AnnualSales: Option[TypoMoney],
  AnnualRevenue: Option[TypoMoney],
  BankName: Option[/* max 50 chars */ String],
  BusinessType: Option[/* max 5 chars */ String],
  YearOpened: Option[Int],
  Specialty: Option[/* max 50 chars */ String],
  SquareFeet: Option[Int],
  Brands: Option[/* max 30 chars */ String],
  Internet: Option[/* max 30 chars */ String],
  NumberEmployees: Option[Int]
)

object VstorewithdemographicsViewRow {
  val rowParser: RowParser[VstorewithdemographicsViewRow] =
    RowParser[VstorewithdemographicsViewRow] { row =>
      Success(
        VstorewithdemographicsViewRow(
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          name = row[Option[Name]]("name"),
          AnnualSales = row[Option[TypoMoney]]("AnnualSales"),
          AnnualRevenue = row[Option[TypoMoney]]("AnnualRevenue"),
          BankName = row[Option[/* max 50 chars */ String]]("BankName"),
          BusinessType = row[Option[/* max 5 chars */ String]]("BusinessType"),
          YearOpened = row[Option[Int]]("YearOpened"),
          Specialty = row[Option[/* max 50 chars */ String]]("Specialty"),
          SquareFeet = row[Option[Int]]("SquareFeet"),
          Brands = row[Option[/* max 30 chars */ String]]("Brands"),
          Internet = row[Option[/* max 30 chars */ String]]("Internet"),
          NumberEmployees = row[Option[Int]]("NumberEmployees")
        )
      )
    }
  implicit val oFormat: OFormat[VstorewithdemographicsViewRow] = new OFormat[VstorewithdemographicsViewRow]{
    override def writes(o: VstorewithdemographicsViewRow): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "name" -> o.name,
        "AnnualSales" -> o.AnnualSales,
        "AnnualRevenue" -> o.AnnualRevenue,
        "BankName" -> o.BankName,
        "BusinessType" -> o.BusinessType,
        "YearOpened" -> o.YearOpened,
        "Specialty" -> o.Specialty,
        "SquareFeet" -> o.SquareFeet,
        "Brands" -> o.Brands,
        "Internet" -> o.Internet,
        "NumberEmployees" -> o.NumberEmployees
      )
  
    override def reads(json: JsValue): JsResult[VstorewithdemographicsViewRow] = {
      JsResult.fromTry(
        Try(
          VstorewithdemographicsViewRow(
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            name = json.\("name").toOption.map(_.as[Name]),
            AnnualSales = json.\("AnnualSales").toOption.map(_.as[TypoMoney]),
            AnnualRevenue = json.\("AnnualRevenue").toOption.map(_.as[TypoMoney]),
            BankName = json.\("BankName").toOption.map(_.as[/* max 50 chars */ String]),
            BusinessType = json.\("BusinessType").toOption.map(_.as[/* max 5 chars */ String]),
            YearOpened = json.\("YearOpened").toOption.map(_.as[Int]),
            Specialty = json.\("Specialty").toOption.map(_.as[/* max 50 chars */ String]),
            SquareFeet = json.\("SquareFeet").toOption.map(_.as[Int]),
            Brands = json.\("Brands").toOption.map(_.as[/* max 30 chars */ String]),
            Internet = json.\("Internet").toOption.map(_.as[/* max 30 chars */ String]),
            NumberEmployees = json.\("NumberEmployees").toOption.map(_.as[Int])
          )
        )
      )
    }
  }
}
