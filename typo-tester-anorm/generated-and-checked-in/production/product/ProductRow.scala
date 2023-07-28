/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import adventureworks.TypoLocalDateTime
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.production.productsubcategory.ProductsubcategoryId
import adventureworks.production.unitmeasure.UnitmeasureId
import adventureworks.public.Flag
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

case class ProductRow(
  /** Primary key for Product records. */
  productid: ProductId,
  /** Name of the product. */
  name: Name,
  /** Unique product identification number. */
  productnumber: /* max 25 chars */ String,
  /** 0 = Product is purchased, 1 = Product is manufactured in-house. */
  makeflag: Flag,
  /** 0 = Product is not a salable item. 1 = Product is salable. */
  finishedgoodsflag: Flag,
  /** Product color. */
  color: Option[/* max 15 chars */ String],
  /** Minimum inventory quantity. */
  safetystocklevel: Int,
  /** Inventory level that triggers a purchase order or work order. */
  reorderpoint: Int,
  /** Standard cost of the product. */
  standardcost: BigDecimal,
  /** Selling price. */
  listprice: BigDecimal,
  /** Product size. */
  size: Option[/* max 5 chars */ String],
  /** Unit of measure for Size column.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  sizeunitmeasurecode: Option[UnitmeasureId],
  /** Unit of measure for Weight column.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]] */
  weightunitmeasurecode: Option[UnitmeasureId],
  /** Product weight. */
  weight: Option[BigDecimal],
  /** Number of days required to manufacture the product. */
  daystomanufacture: Int,
  /** R = Road, M = Mountain, T = Touring, S = Standard */
  productline: Option[/* bpchar */ String],
  /** H = High, M = Medium, L = Low */
  `class`: Option[/* bpchar */ String],
  /** W = Womens, M = Mens, U = Universal */
  style: Option[/* bpchar */ String],
  /** Product is a member of this product subcategory. Foreign key to ProductSubCategory.ProductSubCategoryID.
      Points to [[productsubcategory.ProductsubcategoryRow.productsubcategoryid]] */
  productsubcategoryid: Option[ProductsubcategoryId],
  /** Product is a member of this product model. Foreign key to ProductModel.ProductModelID.
      Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: Option[ProductmodelId],
  /** Date the product was available for sale. */
  sellstartdate: TypoLocalDateTime,
  /** Date the product was no longer available for sale. */
  sellenddate: Option[TypoLocalDateTime],
  /** Date the product was discontinued. */
  discontinueddate: Option[TypoLocalDateTime],
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object ProductRow {
  implicit val reads: Reads[ProductRow] = Reads[ProductRow](json => JsResult.fromTry(
      Try(
        ProductRow(
          productid = json.\("productid").as[ProductId],
          name = json.\("name").as[Name],
          productnumber = json.\("productnumber").as[/* max 25 chars */ String],
          makeflag = json.\("makeflag").as[Flag],
          finishedgoodsflag = json.\("finishedgoodsflag").as[Flag],
          color = json.\("color").toOption.map(_.as[/* max 15 chars */ String]),
          safetystocklevel = json.\("safetystocklevel").as[Int],
          reorderpoint = json.\("reorderpoint").as[Int],
          standardcost = json.\("standardcost").as[BigDecimal],
          listprice = json.\("listprice").as[BigDecimal],
          size = json.\("size").toOption.map(_.as[/* max 5 chars */ String]),
          sizeunitmeasurecode = json.\("sizeunitmeasurecode").toOption.map(_.as[UnitmeasureId]),
          weightunitmeasurecode = json.\("weightunitmeasurecode").toOption.map(_.as[UnitmeasureId]),
          weight = json.\("weight").toOption.map(_.as[BigDecimal]),
          daystomanufacture = json.\("daystomanufacture").as[Int],
          productline = json.\("productline").toOption.map(_.as[/* bpchar */ String]),
          `class` = json.\("class").toOption.map(_.as[/* bpchar */ String]),
          style = json.\("style").toOption.map(_.as[/* bpchar */ String]),
          productsubcategoryid = json.\("productsubcategoryid").toOption.map(_.as[ProductsubcategoryId]),
          productmodelid = json.\("productmodelid").toOption.map(_.as[ProductmodelId]),
          sellstartdate = json.\("sellstartdate").as[TypoLocalDateTime],
          sellenddate = json.\("sellenddate").toOption.map(_.as[TypoLocalDateTime]),
          discontinueddate = json.\("discontinueddate").toOption.map(_.as[TypoLocalDateTime]),
          rowguid = json.\("rowguid").as[UUID],
          modifieddate = json.\("modifieddate").as[TypoLocalDateTime]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[ProductRow] = RowParser[ProductRow] { row =>
    Success(
      ProductRow(
        productid = row[ProductId](idx + 0),
        name = row[Name](idx + 1),
        productnumber = row[/* max 25 chars */ String](idx + 2),
        makeflag = row[Flag](idx + 3),
        finishedgoodsflag = row[Flag](idx + 4),
        color = row[Option[/* max 15 chars */ String]](idx + 5),
        safetystocklevel = row[Int](idx + 6),
        reorderpoint = row[Int](idx + 7),
        standardcost = row[BigDecimal](idx + 8),
        listprice = row[BigDecimal](idx + 9),
        size = row[Option[/* max 5 chars */ String]](idx + 10),
        sizeunitmeasurecode = row[Option[UnitmeasureId]](idx + 11),
        weightunitmeasurecode = row[Option[UnitmeasureId]](idx + 12),
        weight = row[Option[BigDecimal]](idx + 13),
        daystomanufacture = row[Int](idx + 14),
        productline = row[Option[/* bpchar */ String]](idx + 15),
        `class` = row[Option[/* bpchar */ String]](idx + 16),
        style = row[Option[/* bpchar */ String]](idx + 17),
        productsubcategoryid = row[Option[ProductsubcategoryId]](idx + 18),
        productmodelid = row[Option[ProductmodelId]](idx + 19),
        sellstartdate = row[TypoLocalDateTime](idx + 20),
        sellenddate = row[Option[TypoLocalDateTime]](idx + 21),
        discontinueddate = row[Option[TypoLocalDateTime]](idx + 22),
        rowguid = row[UUID](idx + 23),
        modifieddate = row[TypoLocalDateTime](idx + 24)
      )
    )
  }
  implicit val writes: OWrites[ProductRow] = OWrites[ProductRow](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> Json.toJson(o.productid),
      "name" -> Json.toJson(o.name),
      "productnumber" -> Json.toJson(o.productnumber),
      "makeflag" -> Json.toJson(o.makeflag),
      "finishedgoodsflag" -> Json.toJson(o.finishedgoodsflag),
      "color" -> Json.toJson(o.color),
      "safetystocklevel" -> Json.toJson(o.safetystocklevel),
      "reorderpoint" -> Json.toJson(o.reorderpoint),
      "standardcost" -> Json.toJson(o.standardcost),
      "listprice" -> Json.toJson(o.listprice),
      "size" -> Json.toJson(o.size),
      "sizeunitmeasurecode" -> Json.toJson(o.sizeunitmeasurecode),
      "weightunitmeasurecode" -> Json.toJson(o.weightunitmeasurecode),
      "weight" -> Json.toJson(o.weight),
      "daystomanufacture" -> Json.toJson(o.daystomanufacture),
      "productline" -> Json.toJson(o.productline),
      "class" -> Json.toJson(o.`class`),
      "style" -> Json.toJson(o.style),
      "productsubcategoryid" -> Json.toJson(o.productsubcategoryid),
      "productmodelid" -> Json.toJson(o.productmodelid),
      "sellstartdate" -> Json.toJson(o.sellstartdate),
      "sellenddate" -> Json.toJson(o.sellenddate),
      "discontinueddate" -> Json.toJson(o.discontinueddate),
      "rowguid" -> Json.toJson(o.rowguid),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
