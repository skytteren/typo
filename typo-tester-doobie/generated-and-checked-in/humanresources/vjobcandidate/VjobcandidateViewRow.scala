/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidate

import adventureworks.humanresources.jobcandidate.JobcandidateId
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

case class VjobcandidateViewRow(
  /** Points to [[jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: Option[JobcandidateId],
  /** Points to [[jobcandidate.JobcandidateRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  `Name.Prefix`: Option[/* max 30 chars */ String],
  `Name.First`: Option[/* max 30 chars */ String],
  `Name.Middle`: Option[/* max 30 chars */ String],
  `Name.Last`: Option[/* max 30 chars */ String],
  `Name.Suffix`: Option[/* max 30 chars */ String],
  Skills: Option[String],
  `Addr.Type`: Option[/* max 30 chars */ String],
  `Addr.Loc.CountryRegion`: Option[/* max 100 chars */ String],
  `Addr.Loc.State`: Option[/* max 100 chars */ String],
  `Addr.Loc.City`: Option[/* max 100 chars */ String],
  `Addr.PostalCode`: Option[/* max 20 chars */ String],
  EMail: Option[String],
  WebSite: Option[String],
  /** Points to [[jobcandidate.JobcandidateRow.modifieddate]] */
  modifieddate: Option[LocalDateTime]
)

object VjobcandidateViewRow {
  implicit val decoder: Decoder[VjobcandidateViewRow] =
    (c: HCursor) =>
      for {
        jobcandidateid <- c.downField("jobcandidateid").as[Option[JobcandidateId]]
        businessentityid <- c.downField("businessentityid").as[Option[BusinessentityId]]
        `Name.Prefix` <- c.downField("Name.Prefix").as[Option[/* max 30 chars */ String]]
        `Name.First` <- c.downField("Name.First").as[Option[/* max 30 chars */ String]]
        `Name.Middle` <- c.downField("Name.Middle").as[Option[/* max 30 chars */ String]]
        `Name.Last` <- c.downField("Name.Last").as[Option[/* max 30 chars */ String]]
        `Name.Suffix` <- c.downField("Name.Suffix").as[Option[/* max 30 chars */ String]]
        Skills <- c.downField("Skills").as[Option[String]]
        `Addr.Type` <- c.downField("Addr.Type").as[Option[/* max 30 chars */ String]]
        `Addr.Loc.CountryRegion` <- c.downField("Addr.Loc.CountryRegion").as[Option[/* max 100 chars */ String]]
        `Addr.Loc.State` <- c.downField("Addr.Loc.State").as[Option[/* max 100 chars */ String]]
        `Addr.Loc.City` <- c.downField("Addr.Loc.City").as[Option[/* max 100 chars */ String]]
        `Addr.PostalCode` <- c.downField("Addr.PostalCode").as[Option[/* max 20 chars */ String]]
        EMail <- c.downField("EMail").as[Option[String]]
        WebSite <- c.downField("WebSite").as[Option[String]]
        modifieddate <- c.downField("modifieddate").as[Option[LocalDateTime]]
      } yield VjobcandidateViewRow(jobcandidateid, businessentityid, `Name.Prefix`, `Name.First`, `Name.Middle`, `Name.Last`, `Name.Suffix`, Skills, `Addr.Type`, `Addr.Loc.CountryRegion`, `Addr.Loc.State`, `Addr.Loc.City`, `Addr.PostalCode`, EMail, WebSite, modifieddate)
  implicit val encoder: Encoder[VjobcandidateViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "jobcandidateid" := row.jobcandidateid,
        "businessentityid" := row.businessentityid,
        "Name.Prefix" := row.`Name.Prefix`,
        "Name.First" := row.`Name.First`,
        "Name.Middle" := row.`Name.Middle`,
        "Name.Last" := row.`Name.Last`,
        "Name.Suffix" := row.`Name.Suffix`,
        "Skills" := row.Skills,
        "Addr.Type" := row.`Addr.Type`,
        "Addr.Loc.CountryRegion" := row.`Addr.Loc.CountryRegion`,
        "Addr.Loc.State" := row.`Addr.Loc.State`,
        "Addr.Loc.City" := row.`Addr.Loc.City`,
        "Addr.PostalCode" := row.`Addr.PostalCode`,
        "EMail" := row.EMail,
        "WebSite" := row.WebSite,
        "modifieddate" := row.modifieddate
      )}
  implicit val read: Read[VjobcandidateViewRow] =
    new Read[VjobcandidateViewRow](
      gets = List(
        (Get[JobcandidateId], Nullability.Nullable),
        (Get[BusinessentityId], Nullability.Nullable),
        (Get[/* max 30 chars */ String], Nullability.Nullable),
        (Get[/* max 30 chars */ String], Nullability.Nullable),
        (Get[/* max 30 chars */ String], Nullability.Nullable),
        (Get[/* max 30 chars */ String], Nullability.Nullable),
        (Get[/* max 30 chars */ String], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[/* max 30 chars */ String], Nullability.Nullable),
        (Get[/* max 100 chars */ String], Nullability.Nullable),
        (Get[/* max 100 chars */ String], Nullability.Nullable),
        (Get[/* max 100 chars */ String], Nullability.Nullable),
        (Get[/* max 20 chars */ String], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[String], Nullability.Nullable),
        (Get[LocalDateTime], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => VjobcandidateViewRow(
        jobcandidateid = Get[JobcandidateId].unsafeGetNullable(rs, i + 0),
        businessentityid = Get[BusinessentityId].unsafeGetNullable(rs, i + 1),
        `Name.Prefix` = Get[/* max 30 chars */ String].unsafeGetNullable(rs, i + 2),
        `Name.First` = Get[/* max 30 chars */ String].unsafeGetNullable(rs, i + 3),
        `Name.Middle` = Get[/* max 30 chars */ String].unsafeGetNullable(rs, i + 4),
        `Name.Last` = Get[/* max 30 chars */ String].unsafeGetNullable(rs, i + 5),
        `Name.Suffix` = Get[/* max 30 chars */ String].unsafeGetNullable(rs, i + 6),
        Skills = Get[String].unsafeGetNullable(rs, i + 7),
        `Addr.Type` = Get[/* max 30 chars */ String].unsafeGetNullable(rs, i + 8),
        `Addr.Loc.CountryRegion` = Get[/* max 100 chars */ String].unsafeGetNullable(rs, i + 9),
        `Addr.Loc.State` = Get[/* max 100 chars */ String].unsafeGetNullable(rs, i + 10),
        `Addr.Loc.City` = Get[/* max 100 chars */ String].unsafeGetNullable(rs, i + 11),
        `Addr.PostalCode` = Get[/* max 20 chars */ String].unsafeGetNullable(rs, i + 12),
        EMail = Get[String].unsafeGetNullable(rs, i + 13),
        WebSite = Get[String].unsafeGetNullable(rs, i + 14),
        modifieddate = Get[LocalDateTime].unsafeGetNullable(rs, i + 15)
      )
    )
  

}
