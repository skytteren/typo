/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID

/** This class corresponds to a row in table `person.password` which has not been persisted yet */
case class PasswordRowUnsaved(
  /** Points to [[person.PersonRow.businessentityid]] */
  businessentityid: BusinessentityId,
  /** Password for the e-mail account. */
  passwordhash: /* max 128 chars */ String,
  /** Random value concatenated with the password string before the password is hashed. */
  passwordsalt: /* max 10 chars */ String,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[UUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[LocalDateTime] = Defaulted.UseDefault
) {
  def toRow(rowguidDefault: => UUID, modifieddateDefault: => LocalDateTime): PasswordRow =
    PasswordRow(
      businessentityid = businessentityid,
      passwordhash = passwordhash,
      passwordsalt = passwordsalt,
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object PasswordRowUnsaved {
  implicit val decoder: Decoder[PasswordRowUnsaved] =
    (c: HCursor) =>
      for {
        businessentityid <- c.downField("businessentityid").as[BusinessentityId]
        passwordhash <- c.downField("passwordhash").as[/* max 128 chars */ String]
        passwordsalt <- c.downField("passwordsalt").as[/* max 10 chars */ String]
        rowguid <- c.downField("rowguid").as[Defaulted[UUID]]
        modifieddate <- c.downField("modifieddate").as[Defaulted[LocalDateTime]]
      } yield PasswordRowUnsaved(businessentityid, passwordhash, passwordsalt, rowguid, modifieddate)
  implicit val encoder: Encoder[PasswordRowUnsaved] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "businessentityid" := row.businessentityid,
        "passwordhash" := row.passwordhash,
        "passwordsalt" := row.passwordsalt,
        "rowguid" := row.rowguid,
        "modifieddate" := row.modifieddate
      )}
}