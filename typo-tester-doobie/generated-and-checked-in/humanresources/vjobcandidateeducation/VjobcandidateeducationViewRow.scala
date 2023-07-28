/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateeducation

import adventureworks.humanresources.jobcandidate.JobcandidateId
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.time.LocalDate

case class VjobcandidateeducationViewRow(
  /** Points to [[jobcandidate.JobcandidateRow.jobcandidateid]] */
  jobcandidateid: Option[JobcandidateId],
  `Edu.Level`: Option[/* max 50 chars */ String],
  `Edu.StartDate`: Option[LocalDate],
  `Edu.EndDate`: Option[LocalDate],
  `Edu.Degree`: Option[/* max 50 chars */ String],
  `Edu.Major`: Option[/* max 50 chars */ String],
  `Edu.Minor`: Option[/* max 50 chars */ String],
  `Edu.GPA`: Option[/* max 5 chars */ String],
  `Edu.GPAScale`: Option[/* max 5 chars */ String],
  `Edu.School`: Option[/* max 100 chars */ String],
  `Edu.Loc.CountryRegion`: Option[/* max 100 chars */ String],
  `Edu.Loc.State`: Option[/* max 100 chars */ String],
  `Edu.Loc.City`: Option[/* max 100 chars */ String]
)

object VjobcandidateeducationViewRow {
  implicit val decoder: Decoder[VjobcandidateeducationViewRow] =
    (c: HCursor) =>
      for {
        jobcandidateid <- c.downField("jobcandidateid").as[Option[JobcandidateId]]
        `Edu.Level` <- c.downField("Edu.Level").as[Option[/* max 50 chars */ String]]
        `Edu.StartDate` <- c.downField("Edu.StartDate").as[Option[LocalDate]]
        `Edu.EndDate` <- c.downField("Edu.EndDate").as[Option[LocalDate]]
        `Edu.Degree` <- c.downField("Edu.Degree").as[Option[/* max 50 chars */ String]]
        `Edu.Major` <- c.downField("Edu.Major").as[Option[/* max 50 chars */ String]]
        `Edu.Minor` <- c.downField("Edu.Minor").as[Option[/* max 50 chars */ String]]
        `Edu.GPA` <- c.downField("Edu.GPA").as[Option[/* max 5 chars */ String]]
        `Edu.GPAScale` <- c.downField("Edu.GPAScale").as[Option[/* max 5 chars */ String]]
        `Edu.School` <- c.downField("Edu.School").as[Option[/* max 100 chars */ String]]
        `Edu.Loc.CountryRegion` <- c.downField("Edu.Loc.CountryRegion").as[Option[/* max 100 chars */ String]]
        `Edu.Loc.State` <- c.downField("Edu.Loc.State").as[Option[/* max 100 chars */ String]]
        `Edu.Loc.City` <- c.downField("Edu.Loc.City").as[Option[/* max 100 chars */ String]]
      } yield VjobcandidateeducationViewRow(jobcandidateid, `Edu.Level`, `Edu.StartDate`, `Edu.EndDate`, `Edu.Degree`, `Edu.Major`, `Edu.Minor`, `Edu.GPA`, `Edu.GPAScale`, `Edu.School`, `Edu.Loc.CountryRegion`, `Edu.Loc.State`, `Edu.Loc.City`)
  implicit val encoder: Encoder[VjobcandidateeducationViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "jobcandidateid" := row.jobcandidateid,
        "Edu.Level" := row.`Edu.Level`,
        "Edu.StartDate" := row.`Edu.StartDate`,
        "Edu.EndDate" := row.`Edu.EndDate`,
        "Edu.Degree" := row.`Edu.Degree`,
        "Edu.Major" := row.`Edu.Major`,
        "Edu.Minor" := row.`Edu.Minor`,
        "Edu.GPA" := row.`Edu.GPA`,
        "Edu.GPAScale" := row.`Edu.GPAScale`,
        "Edu.School" := row.`Edu.School`,
        "Edu.Loc.CountryRegion" := row.`Edu.Loc.CountryRegion`,
        "Edu.Loc.State" := row.`Edu.Loc.State`,
        "Edu.Loc.City" := row.`Edu.Loc.City`
      )}
  implicit val read: Read[VjobcandidateeducationViewRow] =
    new Read[VjobcandidateeducationViewRow](
      gets = List(
        (Get[JobcandidateId], Nullability.Nullable),
        (Get[/* max 50 chars */ String], Nullability.Nullable),
        (Get[LocalDate], Nullability.Nullable),
        (Get[LocalDate], Nullability.Nullable),
        (Get[/* max 50 chars */ String], Nullability.Nullable),
        (Get[/* max 50 chars */ String], Nullability.Nullable),
        (Get[/* max 50 chars */ String], Nullability.Nullable),
        (Get[/* max 5 chars */ String], Nullability.Nullable),
        (Get[/* max 5 chars */ String], Nullability.Nullable),
        (Get[/* max 100 chars */ String], Nullability.Nullable),
        (Get[/* max 100 chars */ String], Nullability.Nullable),
        (Get[/* max 100 chars */ String], Nullability.Nullable),
        (Get[/* max 100 chars */ String], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => VjobcandidateeducationViewRow(
        jobcandidateid = Get[JobcandidateId].unsafeGetNullable(rs, i + 0),
        `Edu.Level` = Get[/* max 50 chars */ String].unsafeGetNullable(rs, i + 1),
        `Edu.StartDate` = Get[LocalDate].unsafeGetNullable(rs, i + 2),
        `Edu.EndDate` = Get[LocalDate].unsafeGetNullable(rs, i + 3),
        `Edu.Degree` = Get[/* max 50 chars */ String].unsafeGetNullable(rs, i + 4),
        `Edu.Major` = Get[/* max 50 chars */ String].unsafeGetNullable(rs, i + 5),
        `Edu.Minor` = Get[/* max 50 chars */ String].unsafeGetNullable(rs, i + 6),
        `Edu.GPA` = Get[/* max 5 chars */ String].unsafeGetNullable(rs, i + 7),
        `Edu.GPAScale` = Get[/* max 5 chars */ String].unsafeGetNullable(rs, i + 8),
        `Edu.School` = Get[/* max 100 chars */ String].unsafeGetNullable(rs, i + 9),
        `Edu.Loc.CountryRegion` = Get[/* max 100 chars */ String].unsafeGetNullable(rs, i + 10),
        `Edu.Loc.State` = Get[/* max 100 chars */ String].unsafeGetNullable(rs, i + 11),
        `Edu.Loc.City` = Get[/* max 100 chars */ String].unsafeGetNullable(rs, i + 12)
      )
    )
  

}