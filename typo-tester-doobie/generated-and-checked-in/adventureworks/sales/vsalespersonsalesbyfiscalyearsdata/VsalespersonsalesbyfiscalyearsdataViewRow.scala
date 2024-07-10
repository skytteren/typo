/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalespersonsalesbyfiscalyearsdata

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/**
 *View: sales.vsalespersonsalesbyfiscalyearsdata */
case class VsalespersonsalesbyfiscalyearsdataViewRow(
  /** Points to [[salesorderheader.SalesorderheaderRow.salespersonid]] */
  salespersonid: Option[BusinessentityId],
  fullname: /* nullability unknown */ Option[String],
  /** Points to [[humanresources.employee.EmployeeRow.jobtitle]] */
  jobtitle: /* max 50 chars */ String,
  /** Points to [[salesterritory.SalesterritoryRow.name]] */
  salesterritory: Name,
  salestotal: /* nullability unknown */ Option[BigDecimal],
  fiscalyear: /* nullability unknown */ Option[BigDecimal]
)

object VsalespersonsalesbyfiscalyearsdataViewRow {
  implicit lazy val decoder: Decoder[VsalespersonsalesbyfiscalyearsdataViewRow] = Decoder.forProduct6[VsalespersonsalesbyfiscalyearsdataViewRow, Option[BusinessentityId], /* nullability unknown */ Option[String], /* max 50 chars */ String, Name, /* nullability unknown */ Option[BigDecimal], /* nullability unknown */ Option[BigDecimal]]("salespersonid", "fullname", "jobtitle", "salesterritory", "salestotal", "fiscalyear")(VsalespersonsalesbyfiscalyearsdataViewRow.apply)(Decoder.decodeOption(BusinessentityId.decoder), Decoder.decodeOption(Decoder.decodeString), Decoder.decodeString, Name.decoder, Decoder.decodeOption(Decoder.decodeBigDecimal), Decoder.decodeOption(Decoder.decodeBigDecimal))
  implicit lazy val encoder: Encoder[VsalespersonsalesbyfiscalyearsdataViewRow] = Encoder.forProduct6[VsalespersonsalesbyfiscalyearsdataViewRow, Option[BusinessentityId], /* nullability unknown */ Option[String], /* max 50 chars */ String, Name, /* nullability unknown */ Option[BigDecimal], /* nullability unknown */ Option[BigDecimal]]("salespersonid", "fullname", "jobtitle", "salesterritory", "salestotal", "fiscalyear")(x => (x.salespersonid, x.fullname, x.jobtitle, x.salesterritory, x.salestotal, x.fiscalyear))(Encoder.encodeOption(BusinessentityId.encoder), Encoder.encodeOption(Encoder.encodeString), Encoder.encodeString, Name.encoder, Encoder.encodeOption(Encoder.encodeBigDecimal), Encoder.encodeOption(Encoder.encodeBigDecimal))
  implicit lazy val read: Read[VsalespersonsalesbyfiscalyearsdataViewRow] = new Read[VsalespersonsalesbyfiscalyearsdataViewRow](
    gets = List(
      (BusinessentityId.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable),
      (Meta.ScalaBigDecimalMeta.get, Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VsalespersonsalesbyfiscalyearsdataViewRow(
      salespersonid = BusinessentityId.get.unsafeGetNullable(rs, i + 0),
      fullname = Meta.StringMeta.get.unsafeGetNullable(rs, i + 1),
      jobtitle = Meta.StringMeta.get.unsafeGetNonNullable(rs, i + 2),
      salesterritory = Name.get.unsafeGetNonNullable(rs, i + 3),
      salestotal = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 4),
      fiscalyear = Meta.ScalaBigDecimalMeta.get.unsafeGetNullable(rs, i + 5)
    )
  )
}
