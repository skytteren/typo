/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pp

import adventureworks.production.productphoto.ProductphotoId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime

case class PpViewRow(
  id: Option[Int],
  /** Points to [[production.productphoto.ProductphotoRow.productphotoid]] */
  productphotoid: Option[ProductphotoId],
  /** Points to [[production.productphoto.ProductphotoRow.thumbnailphoto]] */
  thumbnailphoto: Option[Byte],
  /** Points to [[production.productphoto.ProductphotoRow.thumbnailphotofilename]] */
  thumbnailphotofilename: Option[/* max 50 chars */ String],
  /** Points to [[production.productphoto.ProductphotoRow.largephoto]] */
  largephoto: Option[Byte],
  /** Points to [[production.productphoto.ProductphotoRow.largephotofilename]] */
  largephotofilename: Option[/* max 50 chars */ String],
  /** Points to [[production.productphoto.ProductphotoRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PpViewRow {
  implicit val decoder: Decoder[PpViewRow] =
    (c: HCursor) =>
      for {
        id <- c.downField("id").as[Option[Int]]
        productphotoid <- c.downField("productphotoid").as[Option[ProductphotoId]]
        thumbnailphoto <- c.downField("thumbnailphoto").as[Option[Byte]]
        thumbnailphotofilename <- c.downField("thumbnailphotofilename").as[Option[/* max 50 chars */ String]]
        largephoto <- c.downField("largephoto").as[Option[Byte]]
        largephotofilename <- c.downField("largephotofilename").as[Option[/* max 50 chars */ String]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield PpViewRow(id, productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate)
  implicit val encoder: Encoder[PpViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "id" := row.id,
        "productphotoid" := row.productphotoid,
        "thumbnailphoto" := row.thumbnailphoto,
        "thumbnailphotofilename" := row.thumbnailphotofilename,
        "largephoto" := row.largephoto,
        "largephotofilename" := row.largephotofilename,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[PpViewRow] =
    new Read[PpViewRow](
      gets = List(
        (Get[Int], Nullability.Nullable),
        (Get[ProductphotoId], Nullability.Nullable),
        (Get[Byte], Nullability.Nullable),
        (Get[/* max 50 chars */ String], Nullability.Nullable),
        (Get[Byte], Nullability.Nullable),
        (Get[/* max 50 chars */ String], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => PpViewRow(
        id = Get[Int].unsafeGetNullable(rs, i + 0),
        productphotoid = Get[ProductphotoId].unsafeGetNullable(rs, i + 1),
        thumbnailphoto = Get[Byte].unsafeGetNullable(rs, i + 2),
        thumbnailphotofilename = Get[/* max 50 chars */ String].unsafeGetNullable(rs, i + 3),
        largephoto = Get[Byte].unsafeGetNullable(rs, i + 4),
        largephotofilename = Get[/* max 50 chars */ String].unsafeGetNullable(rs, i + 5),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 6)
      )
    )
  

}
