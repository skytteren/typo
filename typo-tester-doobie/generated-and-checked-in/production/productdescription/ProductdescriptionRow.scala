/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import adventureworks.TypoLocalDateTime
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class ProductdescriptionRow(
  /** Primary key for ProductDescription records. */
  productdescriptionid: ProductdescriptionId,
  /** Description of the product. */
  description: /* max 400 chars */ String,
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object ProductdescriptionRow {
  implicit val decoder: Decoder[ProductdescriptionRow] = Decoder.forProduct4[ProductdescriptionRow, ProductdescriptionId, /* max 400 chars */ String, UUID, TypoLocalDateTime]("productdescriptionid", "description", "rowguid", "modifieddate")(ProductdescriptionRow.apply)
  implicit val encoder: Encoder[ProductdescriptionRow] = Encoder.forProduct4[ProductdescriptionRow, ProductdescriptionId, /* max 400 chars */ String, UUID, TypoLocalDateTime]("productdescriptionid", "description", "rowguid", "modifieddate")(x => (x.productdescriptionid, x.description, x.rowguid, x.modifieddate))
  implicit val read: Read[ProductdescriptionRow] = new Read[ProductdescriptionRow](
    gets = List(
      (Get[ProductdescriptionId], Nullability.NoNulls),
      (Get[/* max 400 chars */ String], Nullability.NoNulls),
      (Get[UUID], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductdescriptionRow(
      productdescriptionid = Get[ProductdescriptionId].unsafeGetNonNullable(rs, i + 0),
      description = Get[/* max 400 chars */ String].unsafeGetNonNullable(rs, i + 1),
      rowguid = Get[UUID].unsafeGetNonNullable(rs, i + 2),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 3)
    )
  )
}
