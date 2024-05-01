/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import adventureworks.Text
import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

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
   def toUnsavedRow(jobcandidateid: Defaulted[JobcandidateId], modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): JobcandidateRowUnsaved =
     JobcandidateRowUnsaved(businessentityid, resume, jobcandidateid, modifieddate)
 }

object JobcandidateRow {
  implicit lazy val reads: Reads[JobcandidateRow] = Reads[JobcandidateRow](json => JsResult.fromTry(
      Try(
        JobcandidateRow(
          jobcandidateid = json.\("jobcandidateid").as(JobcandidateId.reads),
          businessentityid = json.\("businessentityid").toOption.map(_.as(BusinessentityId.reads)),
          resume = json.\("resume").toOption.map(_.as(TypoXml.reads)),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[JobcandidateRow] = RowParser[JobcandidateRow] { row =>
    Success(
      JobcandidateRow(
        jobcandidateid = row(idx + 0)(JobcandidateId.column),
        businessentityid = row(idx + 1)(Column.columnToOption(BusinessentityId.column)),
        resume = row(idx + 2)(Column.columnToOption(TypoXml.column)),
        modifieddate = row(idx + 3)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[JobcandidateRow] = Text.instance[JobcandidateRow]{ (row, sb) =>
    JobcandidateId.text.unsafeEncode(row.jobcandidateid, sb)
    sb.append(Text.DELIMETER)
    Text.option(BusinessentityId.text).unsafeEncode(row.businessentityid, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoXml.text).unsafeEncode(row.resume, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[JobcandidateRow] = OWrites[JobcandidateRow](o =>
    new JsObject(ListMap[String, JsValue](
      "jobcandidateid" -> JobcandidateId.writes.writes(o.jobcandidateid),
      "businessentityid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.businessentityid),
      "resume" -> Writes.OptionWrites(TypoXml.writes).writes(o.resume),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
