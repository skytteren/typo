/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package jc

import adventureworks.TypoXml
import adventureworks.humanresources.jobcandidate.JobcandidateId
import adventureworks.person.businessentity.BusinessentityId
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class JcViewRow(
  id: Option[Int],
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: Option[JobcandidateId],
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.resume]] */
  resume: Option[TypoXml],
  /** Points to [[humanresources.jobcandidate.JobcandidateRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object JcViewRow {
  val rowParser: RowParser[JcViewRow] =
    RowParser[JcViewRow] { row =>
      Success(
        JcViewRow(
          id = row[Option[Int]]("id"),
          jobcandidateid = row[Option[JobcandidateId]]("jobcandidateid"),
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          resume = row[Option[TypoXml]]("resume"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
  implicit val oFormat: OFormat[JcViewRow] = new OFormat[JcViewRow]{
    override def writes(o: JcViewRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "jobcandidateid" -> o.jobcandidateid,
        "businessentityid" -> o.businessentityid,
        "resume" -> o.resume,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[JcViewRow] = {
      JsResult.fromTry(
        Try(
          JcViewRow(
            id = json.\("id").toOption.map(_.as[Int]),
            jobcandidateid = json.\("jobcandidateid").toOption.map(_.as[JobcandidateId]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            resume = json.\("resume").toOption.map(_.as[TypoXml]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}
