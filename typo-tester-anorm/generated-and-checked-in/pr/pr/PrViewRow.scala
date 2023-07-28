/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pr

import adventureworks.production.product.ProductId
import adventureworks.production.productreview.ProductreviewId
import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PrViewRow(
  id: Option[Int],
  /** Points to [[production.productreview.ProductreviewRow.productreviewid]] */
  productreviewid: Option[ProductreviewId],
  /** Points to [[production.productreview.ProductreviewRow.productid]] */
  productid: Option[ProductId],
  /** Points to [[production.productreview.ProductreviewRow.reviewername]] */
  reviewername: Option[Name],
  /** Points to [[production.productreview.ProductreviewRow.reviewdate]] */
  reviewdate: Option[LocalDateTime],
  /** Points to [[production.productreview.ProductreviewRow.emailaddress]] */
  emailaddress: Option[/* max 50 chars */ String],
  /** Points to [[production.productreview.ProductreviewRow.rating]] */
  rating: Option[Int],
  /** Points to [[production.productreview.ProductreviewRow.comments]] */
  comments: Option[/* max 3850 chars */ String],
  /** Points to [[production.productreview.ProductreviewRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object PrViewRow {
  def rowParser(idx: Int): RowParser[PrViewRow] =
    RowParser[PrViewRow] { row =>
      Success(
        PrViewRow(
          id = row[Option[Int]](idx + 0),
          productreviewid = row[Option[ProductreviewId]](idx + 1),
          productid = row[Option[ProductId]](idx + 2),
          reviewername = row[Option[Name]](idx + 3),
          reviewdate = row[Option[LocalDateTime]](idx + 4),
          emailaddress = row[Option[/* max 50 chars */ String]](idx + 5),
          rating = row[Option[Int]](idx + 6),
          comments = row[Option[/* max 3850 chars */ String]](idx + 7),
          modifieddate = row[Option[LocalDateTime]](idx + 8)
        )
      )
    }
  implicit val oFormat: OFormat[PrViewRow] = new OFormat[PrViewRow]{
    override def writes(o: PrViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "productreviewid" -> o.productreviewid,
        "productid" -> o.productid,
        "reviewername" -> o.reviewername,
        "reviewdate" -> o.reviewdate,
        "emailaddress" -> o.emailaddress,
        "rating" -> o.rating,
        "comments" -> o.comments,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PrViewRow] = {
      JsResult.fromTry(
        Try(
          PrViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            productreviewid = json.\("productreviewid").toOption.map(_.as[ProductreviewId]),
            productid = json.\("productid").toOption.map(_.as[ProductId]),
            reviewername = json.\("reviewername").toOption.map(_.as[Name]),
            reviewdate = json.\("reviewdate").toOption.map(_.as[LocalDateTime]),
            emailaddress = json.\("emailaddress").toOption.map(_.as[/* max 50 chars */ String]),
            rating = json.\("rating").toOption.map(_.as[Int]),
            comments = json.\("comments").toOption.map(_.as[/* max 3850 chars */ String]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
