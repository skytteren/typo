/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import doobie.postgres.Text
import io.circe.Decoder
import io.circe.Encoder

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
      Product quantity ordered.
      Constraint CK_ShoppingCartItem_Quantity affecting columns quantity:  ((quantity >= 1)) */
  quantity: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: now()
      Date the time the record was created. */
  datecreated: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(shoppingcartitemidDefault: => ShoppingcartitemId, quantityDefault: => Int, datecreatedDefault: => TypoLocalDateTime, modifieddateDefault: => TypoLocalDateTime): ShoppingcartitemRow =
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
  implicit lazy val decoder: Decoder[ShoppingcartitemRowUnsaved] = Decoder.forProduct6[ShoppingcartitemRowUnsaved, /* max 50 chars */ String, ProductId, Defaulted[ShoppingcartitemId], Defaulted[Int], Defaulted[TypoLocalDateTime], Defaulted[TypoLocalDateTime]]("shoppingcartid", "productid", "shoppingcartitemid", "quantity", "datecreated", "modifieddate")(ShoppingcartitemRowUnsaved.apply)(Decoder.decodeString, ProductId.decoder, Defaulted.decoder(ShoppingcartitemId.decoder), Defaulted.decoder(Decoder.decodeInt), Defaulted.decoder(TypoLocalDateTime.decoder), Defaulted.decoder(TypoLocalDateTime.decoder))
  implicit lazy val encoder: Encoder[ShoppingcartitemRowUnsaved] = Encoder.forProduct6[ShoppingcartitemRowUnsaved, /* max 50 chars */ String, ProductId, Defaulted[ShoppingcartitemId], Defaulted[Int], Defaulted[TypoLocalDateTime], Defaulted[TypoLocalDateTime]]("shoppingcartid", "productid", "shoppingcartitemid", "quantity", "datecreated", "modifieddate")(x => (x.shoppingcartid, x.productid, x.shoppingcartitemid, x.quantity, x.datecreated, x.modifieddate))(Encoder.encodeString, ProductId.encoder, Defaulted.encoder(ShoppingcartitemId.encoder), Defaulted.encoder(Encoder.encodeInt), Defaulted.encoder(TypoLocalDateTime.encoder), Defaulted.encoder(TypoLocalDateTime.encoder))
  implicit lazy val text: Text[ShoppingcartitemRowUnsaved] = Text.instance[ShoppingcartitemRowUnsaved]{ (row, sb) =>
    Text.stringInstance.unsafeEncode(row.shoppingcartid, sb)
    sb.append(Text.DELIMETER)
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(ShoppingcartitemId.text).unsafeEncode(row.shoppingcartitemid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.intInstance).unsafeEncode(row.quantity, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.datecreated, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
