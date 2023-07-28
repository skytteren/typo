/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `sales.shoppingcartitem` which has not been persisted yet */
case class ShoppingcartitemRowUnsaved(
  /** Shopping cart identification number. */
  shoppingcartid: /* max 50 chars */ String,
  /** Product ordered. Foreign key to Product.ProductID.
      Points to [[production.product.ProductRow.productid]] */
  productid: ProductId,
  /** Default: nextval('sales.shoppingcartitem_shoppingcartitemid_seq'::regclass)
      Primary key for ShoppingCartItem records. */
  shoppingcartitemid: Defaulted[ShoppingcartitemId] = Defaulted.UseDefault,
  /** Default: 1
      Product quantity ordered. */
  quantity: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now()
      Date the time the record was created. */
  datecreated: Defaulted[LocalDateTime] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(shoppingcartitemidDefault: => ShoppingcartitemId, quantityDefault: => Int, datecreatedDefault: => LocalDateTime, modifieddateDefault: => LocalDateTime): ShoppingcartitemRow =
    ShoppingcartitemRow(
      shoppingcartid = shoppingcartid,
      productid = productid,
      shoppingcartitemid = shoppingcartitemid match {
                             case Defaulted.UseDefault => shoppingcartitemidDefault
                             case Defaulted.Provided(value) => value
                           },
      quantity = quantity match {
                   case Defaulted.UseDefault => quantityDefault
                   case Defaulted.Provided(value) => value
                 },
      datecreated = datecreated match {
                      case Defaulted.UseDefault => datecreatedDefault
                      case Defaulted.Provided(value) => value
                    },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ShoppingcartitemRowUnsaved {
  implicit val oFormat: OFormat[ShoppingcartitemRowUnsaved] = new OFormat[ShoppingcartitemRowUnsaved]{
    override def writes(o: ShoppingcartitemRowUnsaved): JsObject =
      Json.obj(
        "shoppingcartid" -> o.shoppingcartid,
        "productid" -> o.productid,
        "shoppingcartitemid" -> o.shoppingcartitemid,
        "quantity" -> o.quantity,
        "datecreated" -> o.datecreated,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ShoppingcartitemRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ShoppingcartitemRowUnsaved(
            shoppingcartid = json.\("shoppingcartid").as[/* max 50 chars */ String],
            productid = json.\("productid").as[ProductId],
            shoppingcartitemid = json.\("shoppingcartitemid").as[Defaulted[ShoppingcartitemId]],
            quantity = json.\("quantity").as[Defaulted[Int]],
            datecreated = json.\("datecreated").as[Defaulted[LocalDateTime]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}