/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employee

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID

/** This class corresponds to a row in table `humanresources.employee` which has not been persisted yet */
case class EmployeeRowUnsaved(
  /** Primary key for Employee records.  Foreign key to BusinessEntity.BusinessEntityID.
      Points to [[person.person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Unique national identification number such as a social security number. */
  nationalidnumber: /* max 15 chars */ String,
  /** Network login. */
  loginid: /* max 256 chars */ String,
  /** Work title such as Buyer or Sales Representative. */
  jobtitle: /* max 50 chars */ String,
  /** Date of birth. */
  birthdate: LocalDate,
  /** M = Married, S = Single */
  maritalstatus: /* bpchar */ String,
  /** M = Male, F = Female */
  gender: /* bpchar */ String,
  /** Employee hired on this date. */
  hiredate: LocalDate,
  /** Default: true
      Job classification. 0 = Hourly, not exempt from collective bargaining. 1 = Salaried, exempt from collective bargaining. */
  salariedflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: 0
      Number of available vacation hours. */
  vacationhours: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: 0
      Number of available sick leave hours. */
  sickleavehours: Defaulted[Int] = Defaulted.UseDefault,
  /** Default: true
      0 = Inactive, 1 = Active */
  currentflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault,
  /** Default: '/'::character varying
      Where the employee is located in corporate hierarchy. */
  organizationnode: Defaulted[Option[String]] = Defaulted.UseDefault
) {
  def toRow(salariedflagDefault: => Flag, vacationhoursDefault: => Int, sickleavehoursDefault: => Int, currentflagDefault: => Flag, rowguidDefault: => UUID, modifieddateDefault: => LocalDateTime, organizationnodeDefault: => Option[String]): EmployeeRow =
    EmployeeRow(
      businessentityid = businessentityid,
      nationalidnumber = nationalidnumber,
      loginid = loginid,
      jobtitle = jobtitle,
      birthdate = birthdate,
      maritalstatus = maritalstatus,
      gender = gender,
      hiredate = hiredate,
      salariedflag = salariedflag match {
                       case Defaulted.UseDefault => salariedflagDefault
                       case Defaulted.Provided(value) => value
                     },
      vacationhours = vacationhours match {
                        case Defaulted.UseDefault => vacationhoursDefault
                        case Defaulted.Provided(value) => value
                      },
      sickleavehours = sickleavehours match {
                         case Defaulted.UseDefault => sickleavehoursDefault
                         case Defaulted.Provided(value) => value
                       },
      currentflag = currentflag match {
                      case Defaulted.UseDefault => currentflagDefault
                      case Defaulted.Provided(value) => value
                    },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     },
      organizationnode = organizationnode match {
                           case Defaulted.UseDefault => organizationnodeDefault
                           case Defaulted.Provided(value) => value
                         }
    )
}
object EmployeeRowUnsaved {
  implicit val decoder: Decoder[EmployeeRowUnsaved] =
    (c: HCursor) =>
      for {
        businessentityid <- c.downField("businessentityid").as[BusinessentityId]
        nationalidnumber <- c.downField("nationalidnumber").as[/* max 15 chars */ String]
        loginid <- c.downField("loginid").as[/* max 256 chars */ String]
        jobtitle <- c.downField("jobtitle").as[/* max 50 chars */ String]
        birthdate <- c.downField("birthdate").as[LocalDate]
        maritalstatus <- c.downField("maritalstatus").as[/* bpchar */ String]
        gender <- c.downField("gender").as[/* bpchar */ String]
        hiredate <- c.downField("hiredate").as[LocalDate]
        salariedflag <- c.downField("salariedflag").as[Defaulted[Flag]]
        vacationhours <- c.downField("vacationhours").as[Defaulted[Int]]
        sickleavehours <- c.downField("sickleavehours").as[Defaulted[Int]]
        currentflag <- c.downField("currentflag").as[Defaulted[Flag]]
        rowguid <- c.downField("rowguid").as[Defaulted[UUID]]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
        organizationnode <- c.downField("organizationnode").as[Defaulted[Option[String]]]
      } yield EmployeeRowUnsaved(businessentityid, nationalidnumber, loginid, jobtitle, birthdate, maritalstatus, gender, hiredate, salariedflag, vacationhours, sickleavehours, currentflag, rowguid, modifieddate, organizationnode)
  implicit val encoder: Encoder[EmployeeRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "businessentityid" := row.businessentityid,
        "nationalidnumber" := row.nationalidnumber,
        "loginid" := row.loginid,
        "jobtitle" := row.jobtitle,
        "birthdate" := row.birthdate,
        "maritalstatus" := row.maritalstatus,
        "gender" := row.gender,
        "hiredate" := row.hiredate,
        "salariedflag" := row.salariedflag,
        "vacationhours" := row.vacationhours,
        "sickleavehours" := row.sickleavehours,
        "currentflag" := row.currentflag,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate,
        "organizationnode" := row.organizationnode
      )}
}