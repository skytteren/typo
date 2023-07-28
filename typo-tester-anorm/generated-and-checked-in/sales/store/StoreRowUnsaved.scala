/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package store

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `sales.store` which has not been persisted yet */
case class StoreRowUnsaved(
  /** Primary key. Foreign key to Customer.BusinessEntityID.
      Points to [[person.businessentity.BusinessentityRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Name of the store. */
  name: Name,
  /** ID of the sales person assigned to the customer. Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]] */
  salespersonid: Option[BusinessentityId],
  /** Demographic informationg about the store such as the number of employees, annual sales and store type. */
  demographics: Option[TypoXml],
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(rowguidDefault: => UUID, modifieddateDefault: => TypoLocalDateTime): StoreRow =
    StoreRow(
      businessentityid = businessentityid,
      name = name,
      salespersonid = salespersonid,
      demographics = demographics,
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object StoreRowUnsaved {
  implicit val reads: Reads[StoreRowUnsaved] = Reads[StoreRowUnsaved](json => JsResult.fromTry(
      Try(
        StoreRowUnsaved(
          businessentityid = json.\("businessentityid").as[BusinessentityId],
          name = json.\("name").as[Name],
          salespersonid = json.\("salespersonid").toOption.map(_.as[BusinessentityId]),
          demographics = json.\("demographics").toOption.map(_.as[TypoXml]),
          rowguid = json.\("rowguid").as[Defaulted[UUID]],
          modifieddate = json.\("modifieddate").as[Defaulted[TypoLocalDateTime]]
        )
      )
    ),
  )
  implicit val writes: OWrites[StoreRowUnsaved] = OWrites[StoreRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "businessentityid" -> Json.toJson(o.businessentityid),
      "name" -> Json.toJson(o.name),
      "salespersonid" -> Json.toJson(o.salespersonid),
      "demographics" -> Json.toJson(o.demographics),
      "rowguid" -> Json.toJson(o.rowguid),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
