/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import adventureworks.TypoLocalDateTime
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

case class ProductphotoRow(
  /** Primary key for ProductPhoto records. */
  productphotoid: ProductphotoId,
  /** Small image of the product. */
  thumbnailphoto: Option[Array[Byte]],
  /** Small image file name. */
  thumbnailphotofilename: Option[/* max 50 chars */ String],
  /** Large image of the product. */
  largephoto: Option[Array[Byte]],
  /** Large image file name. */
  largephotofilename: Option[/* max 50 chars */ String],
  modifieddate: TypoLocalDateTime
)

object ProductphotoRow {
  implicit val decoder: Decoder[ProductphotoRow] = Decoder.forProduct6[ProductphotoRow, ProductphotoId, Option[Array[Byte]], Option[/* max 50 chars */ String], Option[Array[Byte]], Option[/* max 50 chars */ String], TypoLocalDateTime]("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate")(ProductphotoRow.apply)
  implicit val encoder: Encoder[ProductphotoRow] = Encoder.forProduct6[ProductphotoRow, ProductphotoId, Option[Array[Byte]], Option[/* max 50 chars */ String], Option[Array[Byte]], Option[/* max 50 chars */ String], TypoLocalDateTime]("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate")(x => (x.productphotoid, x.thumbnailphoto, x.thumbnailphotofilename, x.largephoto, x.largephotofilename, x.modifieddate))
  implicit val read: Read[ProductphotoRow] = new Read[ProductphotoRow](
    gets = List(
      (Get[ProductphotoId], Nullability.NoNulls),
      (Get[Array[Byte]], Nullability.Nullable),
      (Get[/* max 50 chars */ String], Nullability.Nullable),
      (Get[Array[Byte]], Nullability.Nullable),
      (Get[/* max 50 chars */ String], Nullability.Nullable),
      (Get[TypoLocalDateTime], Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => ProductphotoRow(
      productphotoid = Get[ProductphotoId].unsafeGetNonNullable(rs, i + 0),
      thumbnailphoto = Get[Array[Byte]].unsafeGetNullable(rs, i + 1),
      thumbnailphotofilename = Get[/* max 50 chars */ String].unsafeGetNullable(rs, i + 2),
      largephoto = Get[Array[Byte]].unsafeGetNullable(rs, i + 3),
      largephotofilename = Get[/* max 50 chars */ String].unsafeGetNullable(rs, i + 4),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 5)
    )
  )
}
