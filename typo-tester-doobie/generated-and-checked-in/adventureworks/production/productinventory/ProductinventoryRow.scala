/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.Write
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: production.productinventory
    Product inventory information.
    Composite primary key: productid, locationid */
case class ProductinventoryRow(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Inventory location identification number. Foreign key to Location.LocationID.
      Points to [[location.LocationRow.locationid]] */
  locationid: LocationId,
  /** Storage compartment within an inventory location. */
  shelf: /* max 10 chars */ String,
  /** Storage container on a shelf in an inventory location.
      Constraint CK_ProductInventory_Bin affecting columns bin: (((bin >= 0) AND (bin <= 100))) */
  bin: TypoShort,
  /** Quantity of products in the inventory location.
      Default: 0 */
  quantity: TypoShort,
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductinventoryId = ProductinventoryId(productid, locationid)
   val id = compositeId
   def toUnsavedRow(quantity: Defaulted[TypoShort] = Defaulted.Provided(this.quantity), rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductinventoryRowUnsaved =
     ProductinventoryRowUnsaved(productid, locationid, shelf, bin, quantity, rowguid, modifieddate)
 }

object ProductinventoryRow {
  def apply(compositeId: ProductinventoryId, shelf: /* max 10 chars */ String, bin: TypoShort, quantity: TypoShort, rowguid: TypoUUID, modifieddate: TypoLocalDateTime) =
    new ProductinventoryRow(compositeId.productid, compositeId.locationid, shelf, bin, quantity, rowguid, modifieddate)
  implicit lazy val decoder: Decoder[ProductinventoryRow] = Decoder.forProduct7[ProductinventoryRow, ProductId, LocationId, /* max 10 chars */ String, TypoShort, TypoShort, TypoUUID, TypoLocalDateTime]("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")(ProductinventoryRow.apply)(ProductId.decoder, LocationId.decoder, Decoder.decodeString, TypoShort.decoder, TypoShort.decoder, TypoUUID.decoder, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ProductinventoryRow] = Encoder.forProduct7[ProductinventoryRow, ProductId, LocationId, /* max 10 chars */ String, TypoShort, TypoShort, TypoUUID, TypoLocalDateTime]("productid", "locationid", "shelf", "bin", "quantity", "rowguid", "modifieddate")(x => (x.productid, x.locationid, x.shelf, x.bin, x.quantity, x.rowguid, x.modifieddate))(ProductId.encoder, LocationId.encoder, Encoder.encodeString, TypoShort.encoder, TypoShort.encoder, TypoUUID.encoder, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[ProductinventoryRow] = new Read[ProductinventoryRow](
    gets = List(
      (ProductId.get, Nullability.NoNulls),
      (LocationId.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (TypoShort.get, Nullability.NoNulls),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductinventoryRow(
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 0),
      locationid = LocationId.get.unsafeGetNonNullable(rs, i + 1),
      shelf = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      bin = TypoShort.get.unsafeGetNonNullable(rs, i + 3),
      quantity = TypoShort.get.unsafeGetNonNullable(rs, i + 4),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 5),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 6)
    )
  )
  implicit lazy val text: Text[ProductinventoryRow] = Text.instance[ProductinventoryRow]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    LocationId.text.unsafeEncode(row.locationid, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.shelf, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.bin, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.quantity, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val write: Write[ProductinventoryRow] = new Write[ProductinventoryRow](
    puts = List((ProductId.put, Nullability.NoNulls),
                (LocationId.put, Nullability.NoNulls),
                (Meta.StringMeta.put, Nullability.NoNulls),
                (TypoShort.put, Nullability.NoNulls),
                (TypoShort.put, Nullability.NoNulls),
                (TypoUUID.put, Nullability.NoNulls),
                (TypoLocalDateTime.put, Nullability.NoNulls)),
    toList = x => List(x.productid, x.locationid, x.shelf, x.bin, x.quantity, x.rowguid, x.modifieddate),
    unsafeSet = (rs, i, a) => {
                  ProductId.put.unsafeSetNonNullable(rs, i + 0, a.productid)
                  LocationId.put.unsafeSetNonNullable(rs, i + 1, a.locationid)
                  Meta.StringMeta.put.unsafeSetNonNullable(rs, i + 2, a.shelf)
                  TypoShort.put.unsafeSetNonNullable(rs, i + 3, a.bin)
                  TypoShort.put.unsafeSetNonNullable(rs, i + 4, a.quantity)
                  TypoUUID.put.unsafeSetNonNullable(rs, i + 5, a.rowguid)
                  TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 6, a.modifieddate)
                },
    unsafeUpdate = (ps, i, a) => {
                     ProductId.put.unsafeUpdateNonNullable(ps, i + 0, a.productid)
                     LocationId.put.unsafeUpdateNonNullable(ps, i + 1, a.locationid)
                     Meta.StringMeta.put.unsafeUpdateNonNullable(ps, i + 2, a.shelf)
                     TypoShort.put.unsafeUpdateNonNullable(ps, i + 3, a.bin)
                     TypoShort.put.unsafeUpdateNonNullable(ps, i + 4, a.quantity)
                     TypoUUID.put.unsafeUpdateNonNullable(ps, i + 5, a.rowguid)
                     TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 6, a.modifieddate)
                   }
  )
}
