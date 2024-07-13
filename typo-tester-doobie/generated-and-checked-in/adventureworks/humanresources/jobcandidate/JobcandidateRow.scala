/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.Write
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: humanresources.jobcandidate
    RÃ©sumÃ©s submitted to Human Resources by job applicants.
    Primary key: jobcandidateid */
case class JobcandidateRow(
  /** Primary key for JobCandidate records.
      Default: nextval('humanresources.jobcandidate_jobcandidateid_seq'::regclass) */
  jobcandidateid: JobcandidateId,
  /** Employee identification number if applicant was hired. Foreign key to Employee.BusinessEntityID.
      Points to [[employee.EmployeeRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** RÃ©sumÃ© in XML format. */
  resume: Option[TypoXml],
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   val id = jobcandidateid
   def toUnsavedRow(jobcandidateid: Defaulted[JobcandidateId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): JobcandidateRowUnsaved =
     JobcandidateRowUnsaved(businessentityid, resume, jobcandidateid, modifieddate)
 }

object JobcandidateRow {
  implicit lazy val decoder: Decoder[JobcandidateRow] = Decoder.forProduct4[JobcandidateRow, JobcandidateId, Option[BusinessentityId], Option[TypoXml], TypoLocalDateTime]("jobcandidateid", "businessentityid", "resume", "modifieddate")(JobcandidateRow.apply)(JobcandidateId.decoder, Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(TypoXml.decoder), TypoLocalDateTime.decoder)
  implicit lazy val encoder: Encoder[JobcandidateRow] = Encoder.forProduct4[JobcandidateRow, JobcandidateId, Option[BusinessentityId], Option[TypoXml], TypoLocalDateTime]("jobcandidateid", "businessentityid", "resume", "modifieddate")(x => (x.jobcandidateid, x.businessentityid, x.resume, x.modifieddate))(JobcandidateId.encoder, Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(TypoXml.encoder), TypoLocalDateTime.encoder)
  implicit lazy val read: Read[JobcandidateRow] = new Read[JobcandidateRow](
    gets = List(
      (JobcandidateId.get, Nullability.NoNulls),
      (BusinessentityId.get, Nullability.Nullable),
      (TypoXml.get, Nullability.Nullable),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => JobcandidateRow(
      jobcandidateid = JobcandidateId.get.unsafeGetNonNullable(rs, i + 0),
      businessentityid = BusinessentityId.get.unsafeGetNullable(rs, i + 1),
      resume = TypoXml.get.unsafeGetNullable(rs, i + 2),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 3)
    )
  )
  implicit lazy val text: Text[JobcandidateRow] = Text.instance[JobcandidateRow]{ (row, sb) =>
    JobcandidateId.text.unsafeEncode(row.jobcandidateid, sb)
    sb.append(Text.DELIMETER)
    Text.option(BusinessentityId.text).unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.resume, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val write: Write[JobcandidateRow] = new Write[JobcandidateRow](
    puts = List((JobcandidateId.put, Nullability.NoNulls),
                (BusinessentityId.put, Nullability.Nullable),
                (TypoXml.put, Nullability.Nullable),
                (TypoLocalDateTime.put, Nullability.NoNulls)),
    toList = x => List(x.jobcandidateid, x.businessentityid, x.resume, x.modifieddate),
    unsafeSet = (rs, i, a) => {
                  JobcandidateId.put.unsafeSetNonNullable(rs, i + 0, a.jobcandidateid)
                  BusinessentityId.put.unsafeSetNullable(rs, i + 1, a.businessentityid)
                  TypoXml.put.unsafeSetNullable(rs, i + 2, a.resume)
                  TypoLocalDateTime.put.unsafeSetNonNullable(rs, i + 3, a.modifieddate)
                },
    unsafeUpdate = (ps, i, a) => {
                     JobcandidateId.put.unsafeUpdateNonNullable(ps, i + 0, a.jobcandidateid)
                     BusinessentityId.put.unsafeUpdateNullable(ps, i + 1, a.businessentityid)
                     TypoXml.put.unsafeUpdateNullable(ps, i + 2, a.resume)
                     TypoLocalDateTime.put.unsafeUpdateNonNullable(ps, i + 3, a.modifieddate)
                   }
  )
}
