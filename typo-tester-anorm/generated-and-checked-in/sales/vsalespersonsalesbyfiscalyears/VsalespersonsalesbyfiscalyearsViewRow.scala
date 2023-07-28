/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalespersonsalesbyfiscalyears

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class VsalespersonsalesbyfiscalyearsViewRow(
  SalesPersonID: Option[Int],
  FullName: Option[String],
  JobTitle: Option[String],
  SalesTerritory: Option[String],
  `2012`: Option[BigDecimal],
  `2013`: Option[BigDecimal],
  `2014`: Option[BigDecimal]
)

object VsalespersonsalesbyfiscalyearsViewRow {
  def rowParser(idx: Int): RowParser[VsalespersonsalesbyfiscalyearsViewRow] =
    RowParser[VsalespersonsalesbyfiscalyearsViewRow] { row =>
      Success(
        VsalespersonsalesbyfiscalyearsViewRow(
          SalesPersonID = row[Option[Int]](idx + 0),
          FullName = row[Option[String]](idx + 1),
          JobTitle = row[Option[String]](idx + 2),
          SalesTerritory = row[Option[String]](idx + 3),
          `2012` = row[Option[BigDecimal]](idx + 4),
          `2013` = row[Option[BigDecimal]](idx + 5),
          `2014` = row[Option[BigDecimal]](idx + 6)
        )
      )
    }
  implicit val oFormat: OFormat[VsalespersonsalesbyfiscalyearsViewRow] = new OFormat[VsalespersonsalesbyfiscalyearsViewRow]{
    override def writes(o: VsalespersonsalesbyfiscalyearsViewRow): JsObject =
      Json.obj(
        "SalesPersonID" -> o.SalesPersonID,
        "FullName" -> o.FullName,
        "JobTitle" -> o.JobTitle,
        "SalesTerritory" -> o.SalesTerritory,
        "2012" -> o.`2012`,
        "2013" -> o.`2013`,
        "2014" -> o.`2014`
      )
  
    override def reads(json: JsValue): JsResult[VsalespersonsalesbyfiscalyearsViewRow] = {
      JsResult.fromTry(
        Try(
          VsalespersonsalesbyfiscalyearsViewRow(
            SalesPersonID = json.\("SalesPersonID").toOption.map(_.as[Int]),
            FullName = json.\("FullName").toOption.map(_.as[String]),
            JobTitle = json.\("JobTitle").toOption.map(_.as[String]),
            SalesTerritory = json.\("SalesTerritory").toOption.map(_.as[String]),
            `2012` = json.\("2012").toOption.map(_.as[BigDecimal]),
            `2013` = json.\("2013").toOption.map(_.as[BigDecimal]),
            `2014` = json.\("2014").toOption.map(_.as[BigDecimal])
          )
        )
      )
    }
  }
}