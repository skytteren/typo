/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package bec

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet
import java.util.UUID

case class BecViewRow(
  id: Option[Int],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.businessentityid]] */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.personid]] */
  personid: Option[BusinessentityId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.contacttypeid]] */
  contacttypeid: Option[ContacttypeId],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.rowguid]] */
  rowguid: Option[UUID],
  /** Points to [[person.businessentitycontact.BusinessentitycontactRow.modifieddate]] */
  modifieddate: Option[TypoLocalDateTime]
)

object BecViewRow {
  implicit val decoder: Decoder[BecViewRow] = Decoder.forProduct6[BecViewRow, Option[Int], Option[BusinessentityId], Option[BusinessentityId], Option[ContacttypeId], Option[UUID], Option[TypoLocalDateTime]]("id", "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")(BecViewRow.apply)
  implicit val encoder: Encoder[BecViewRow] = Encoder.forProduct6[BecViewRow, Option[Int], Option[BusinessentityId], Option[BusinessentityId], Option[ContacttypeId], Option[UUID], Option[TypoLocalDateTime]]("id", "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")(x => (x.id, x.businessentityid, x.personid, x.contacttypeid, x.rowguid, x.modifieddate))
  implicit val read: Read[BecViewRow] = new Read[BecViewRow](
    gets = List(
      (Get[Int], Nullability.Nullable),
      (Get[BusinessentityId], Nullability.Nullable),
      (Get[BusinessentityId], Nullability.Nullable),
      (Get[ContacttypeId], Nullability.Nullable),
      (Get[UUID], Nullability.Nullable),
      (Get[TypoLocalDateTime], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => BecViewRow(
      id = Get[Int].unsafeGetNullable(rs, i + 0),
      businessentityid = Get[BusinessentityId].unsafeGetNullable(rs, i + 1),
      personid = Get[BusinessentityId].unsafeGetNullable(rs, i + 2),
      contacttypeid = Get[ContacttypeId].unsafeGetNullable(rs, i + 3),
      rowguid = Get[UUID].unsafeGetNullable(rs, i + 4),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNullable(rs, i + 5)
    )
  )
}
