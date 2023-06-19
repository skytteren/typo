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
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDateTime

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
  implicit val decoder: Decoder[JobcandidateRow] =
    (c: HCursor) =>
      for {
        jobcandidateid <- c.downField("jobcandidateid").as[JobcandidateId]
        businessentityid <- c.downField("businessentityid").as[Option[BusinessentityId]]
        resume <- c.downField("resume").as[Option[TypoXml]]
        modifieddate <- c.downField("modifieddate").as[LocalDateTime]
      } yield JobcandidateRow(jobcandidateid, businessentityid, resume, modifieddate)
  implicit val encoder: Encoder[JobcandidateRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "jobcandidateid" := row.jobcandidateid,
        "businessentityid" := row.businessentityid,
        "resume" := row.resume,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[JobcandidateRow] =
    new Read[JobcandidateRow](
      gets = List(
        (Get[JobcandidateId], Nullability.NoNulls),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[TypoXml], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.NoNulls)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => JobcandidateRow(
        jobcandidateid = Get[JobcandidateId].unsafeGetNonNullable(rs, i + 0),
        businessentityid = Get[BusinessentityId].unsafeGetNullable(rs, i + 1),
        resume = Get[TypoXml].unsafeGetNullable(rs, i + 2),
        modifieddate = Get[LocalDateTime].unsafeGetNonNullable(rs, i + 3)
      )
    )
  

}
