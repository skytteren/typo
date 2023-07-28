/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pc

import adventureworks.TypoLocalDateTime
import adventureworks.production.productcategory.ProductcategoryId
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class PcViewRow(
  id: Option[Int],
  /** Points to [[production.productcategory.ProductcategoryRow.productcategoryid]] */
  productcategoryid: Option[ProductcategoryId],
  /** Points to [[production.productcategory.ProductcategoryRow.name]] */
  name: Option[Name],
  /** Points to [[production.productcategory.ProductcategoryRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[production.productcategory.ProductcategoryRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object PcViewRow {
  implicit val reads: Reads[PcViewRow] = Reads[PcViewRow](json => JsResult.fromTry(
      Try(
        PcViewRow(
          id = json.\("id").toOption.map(_.as[Int]),
          productcategoryid = json.\("productcategoryid").toOption.map(_.as[ProductcategoryId]),
          name = json.\("name").toOption.map(_.as[Name]),
          rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
          modifieddate = json.\("modifieddate").toOption.map(_.as[TypoLocalDateTime])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PcViewRow] = RowParser[PcViewRow] { row =>
    Success(
      PcViewRow(
        id = row[Option[Int]](idx + 0),
        productcategoryid = row[Option[ProductcategoryId]](idx + 1),
        name = row[Option[Name]](idx + 2),
        rowguid = row[Option[UUID]](idx + 3),
        modifieddate = row[Option[TypoLocalDateTime]](idx + 4)
      )
    )
  }
  implicit val writes: OWrites[PcViewRow] = OWrites[PcViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "id" -> Json.toJson(o.id),
      "productcategoryid" -> Json.toJson(o.productcategoryid),
      "name" -> Json.toJson(o.name),
      "rowguid" -> Json.toJson(o.rowguid),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
