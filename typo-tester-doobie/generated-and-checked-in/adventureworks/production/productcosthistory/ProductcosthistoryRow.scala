/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: production.productcosthistory
    Changes in the cost of a product over time.
    Composite primary key: productid, startdate */
case class ProductcosthistoryRow(
  /** Product identification number. Foreign key to Product.ProductID
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Product cost start date.
      Constraint CK_ProductCostHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  startdate: TypoLocalDateTime,
  /** Product cost end date.
      Constraint CK_ProductCostHistory_EndDate affecting columns enddate, startdate: (((enddate >= startdate) OR (enddate IS NULL))) */
  enddate: Option[TypoLocalDateTime],
  /** Standard cost of the product.
      Constraint CK_ProductCostHistory_StandardCost affecting columns standardcost: ((standardcost >= 0.00)) */
  standardcost: BigDecimal,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val compositeId: ProductcosthistoryId = ProductcosthistoryId(productid, startdate)
   val id = compositeId
   def toUnsavedRow(modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): ProductcosthistoryRowUnsaved =
     ProductcosthistoryRowUnsaved(productid, startdate, enddate, standardcost, modifieddate)
 }

object ProductcosthistoryRow {
  def apply(compositeId: ProductcosthistoryId, enddate: Option[TypoLocalDateTime], standardcost: BigDecimal, modifieddate: TypoLocalDateTime) =
    new ProductcosthistoryRow(compositeId.productid, compositeId.startdate, enddate, standardcost, modifieddate)
  implicit lazy val decoder: Decoder[ProductcosthistoryRow] = Decoder.forProduct5[ProductcosthistoryRow, ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, TypoLocalDateTime]("productid", "startdate", "enddate", "standardcost", "modifieddate")(ProductcosthistoryRow.apply)(ProductId.decoder, TypoLocalDateTime.decoder, Decoder.decodeOption(TypoLocalDateTime.decoder), Decoder.decodeBigDecimal, TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[ProductcosthistoryRow] = Encoder.forProduct5[ProductcosthistoryRow, ProductId, TypoLocalDateTime, Option[TypoLocalDateTime], BigDecimal, TypoLocalDateTime]("productid", "startdate", "enddate", "standardcost", "modifieddate")(x => (x.productid, x.startdate, x.enddate, x.standardcost, x.modifieddate))(ProductId.encoder, TypoLocalDateTime.encoder, Encoder.encodeOption(TypoLocalDateTime.encoder), Encoder.encodeBigDecimal, TypoLocalDateTime.encoder)
  implicit lazy val read: Read[ProductcosthistoryRow] = new Read[ProductcosthistoryRow](
    gets = List(
      (ProductId.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductcosthistoryRow(
      productid = ProductId.get.unsafeGetNonNullable(rs, i + 0),
      startdate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 1),
      enddate = TypoLocalDateTime.get.unsafeGetNullable(rs, i + 2),
      standardcost = Meta.ScalaBigDecimalMeta.get.unsafeGetNonNullable(rs, i + 3),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 4)
    )
  )
  implicit lazy val text: Text[ProductcosthistoryRow] = Text.instance[ProductcosthistoryRow]{ (row, sb) =>
    ProductId.text.unsafeEncode(row.productid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.startdate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.enddate, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.standardcost, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
}
