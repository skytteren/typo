/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import adventureworks.TypoXml
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

case class JobcandidateRow(
  /** Primary key for JobCandidate records. */
  jobcandidateid: JobcandidateId,
  /** Employee identification number if applicant was hired. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** RÃ©sumÃ© in XML format. */
  resume: Option[TypoXml],
  modifieddate: LocalDateTime
)

object JobcandidateRow {
  def rowParser(idx: Int): RowParser[JobcandidateRow] =
    RowParser[JobcandidateRow] { row =>
      Success(
        JobcandidateRow(
          jobcandidateid = row[JobcandidateId](idx + 0),
          businessentityid = row[Option[BusinessentityId]](idx + 1),
          resume = row[Option[TypoXml]](idx + 2),
          modifieddate = row[LocalDateTime](idx + 3)
        )
      )
    }
  implicit val oFormat: OFormat[JobcandidateRow] = new OFormat[JobcandidateRow]{
    override def writes(o: JobcandidateRow): JsObject =
      Json.obj(
        "jobcandidateid" -> o.jobcandidateid,
        "businessentityid" -> o.businessentityid,
        "resume" -> o.resume,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[JobcandidateRow] = {
      JsResult.fromTry(
        Try(
          JobcandidateRow(
            jobcandidateid = json.\("jobcandidateid").as[JobcandidateId],
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            resume = json.\("resume").toOption.map(_.as[TypoXml]),
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
