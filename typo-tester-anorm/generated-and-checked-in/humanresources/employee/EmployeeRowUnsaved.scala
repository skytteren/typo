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
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

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
  implicit val oFormat: OFormat[EmployeeRowUnsaved] = new OFormat[EmployeeRowUnsaved]{
    override def writes(o: EmployeeRowUnsaved): JsObject =
      Json.obj(
        "businessentityid" -> o.businessentityid,
        "nationalidnumber" -> o.nationalidnumber,
        "loginid" -> o.loginid,
        "jobtitle" -> o.jobtitle,
        "birthdate" -> o.birthdate,
        "maritalstatus" -> o.maritalstatus,
        "gender" -> o.gender,
        "hiredate" -> o.hiredate,
        "salariedflag" -> o.salariedflag,
        "vacationhours" -> o.vacationhours,
        "sickleavehours" -> o.sickleavehours,
        "currentflag" -> o.currentflag,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate,
        "organizationnode" -> o.organizationnode
      )
  
    override def reads(json: JsValue): JsResult[EmployeeRowUnsaved] = {
      JsResult.fromTry(
        Try(
          EmployeeRowUnsaved(
            businessentityid = json.\("businessentityid").as[BusinessentityId],
            nationalidnumber = json.\("nationalidnumber").as[/* max 15 chars */ String],
            loginid = json.\("loginid").as[/* max 256 chars */ String],
            jobtitle = json.\("jobtitle").as[/* max 50 chars */ String],
            birthdate = json.\("birthdate").as[LocalDate],
            maritalstatus = json.\("maritalstatus").as[/* bpchar */ String],
            gender = json.\("gender").as[/* bpchar */ String],
            hiredate = json.\("hiredate").as[LocalDate],
            salariedflag = json.\("salariedflag").as[Defaulted[Flag]],
            vacationhours = json.\("vacationhours").as[Defaulted[Int]],
            sickleavehours = json.\("sickleavehours").as[Defaulted[Int]],
            currentflag = json.\("currentflag").as[Defaulted[Flag]],
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]],
            organizationnode = json.\("organizationnode").as[Defaulted[Option[String]]]
          )
        )
      )
    }
  }
}