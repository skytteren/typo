/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.public.Name
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

/** This class corresponds to a row in table `production.productreview` which has not been persisted yet */
case class ProductreviewRowUnsaved(
  /** Product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]] */
  productid: ProductId,
  /** Name of the reviewer. */
  reviewername: Name,
  /** Reviewer's e-mail address. */
  emailaddress: /* max 50 chars */ String,
  /** Product rating given by the reviewer. Scale is 1 to 5 with 5 as the highest rating. */
  rating: Int,
  /** Reviewer's comments */
  comments: Option[/* max 3850 chars */ String],
  /** Default: nextval('production.productreview_productreviewid_seq'::regclass)
      Primary key for ProductReview records. */
  productreviewid: Defaulted[ProductreviewId] = Defaulted.UseDefault,
  /** Default: now()
      Date review was submitted. */
  reviewdate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(productreviewidDefault: => ProductreviewId, reviewdateDefault: => TypoLocalDateTime, modifieddateDefault: => TypoLocalDateTime): ProductreviewRow =
    ProductreviewRow(
      productid = productid,
      reviewername = reviewername,
      emailaddress = emailaddress,
      rating = rating,
      comments = comments,
      productreviewid = productreviewid match {
                          case Defaulted.UseDefault => productreviewidDefault
                          case Defaulted.Provided(value) => value
                        },
      reviewdate = reviewdate match {
                     case Defaulted.UseDefault => reviewdateDefault
                     case Defaulted.Provided(value) => value
                   },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductreviewRowUnsaved {
  implicit val reads: Reads[ProductreviewRowUnsaved] = Reads[ProductreviewRowUnsaved](json => JsResult.fromTry(
      Try(
        ProductreviewRowUnsaved(
          productid = json.\("productid").as[ProductId],
          reviewername = json.\("reviewername").as[Name],
          emailaddress = json.\("emailaddress").as[/* max 50 chars */ String],
          rating = json.\("rating").as[Int],
          comments = json.\("comments").toOption.map(_.as[/* max 3850 chars */ String]),
          productreviewid = json.\("productreviewid").as[Defaulted[ProductreviewId]],
          reviewdate = json.\("reviewdate").as[Defaulted[TypoLocalDateTime]],
          modifieddate = json.\("modifieddate").as[Defaulted[TypoLocalDateTime]]
        )
      )
    ),
  )
  implicit val writes: OWrites[ProductreviewRowUnsaved] = OWrites[ProductreviewRowUnsaved](o =>
    new JsObject(ListMap[String, JsValue](
      "productid" -> Json.toJson(o.productid),
      "reviewername" -> Json.toJson(o.reviewername),
      "emailaddress" -> Json.toJson(o.emailaddress),
      "rating" -> Json.toJson(o.rating),
      "comments" -> Json.toJson(o.comments),
      "productreviewid" -> Json.toJson(o.productreviewid),
      "reviewdate" -> Json.toJson(o.reviewdate),
      "modifieddate" -> Json.toJson(o.modifieddate)
    ))
  )
}
