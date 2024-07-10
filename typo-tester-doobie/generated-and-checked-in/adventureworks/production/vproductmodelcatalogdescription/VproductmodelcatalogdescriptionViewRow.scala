/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelcatalogdescription

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.productmodel.ProductmodelId
import adventureworks.public.Name
import doobie.enumerated.Nullability
import doobie.util.Read
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import scala.util.Try

/**
 *View: production.vproductmodelcatalogdescription */
case class VproductmodelcatalogdescriptionViewRow(
  /** Points to [[productmodel.ProductmodelRow.productmodelid]] */
  productmodelid: ProductmodelId,
  /** Points to [[productmodel.ProductmodelRow.name]] */
  name: Name,
  summary: /* nullability unknown */ Option[String],
  manufacturer: /* nullability unknown */ Option[String],
  copyright: /* nullability unknown */ Option[/* max 30 chars */ String],
  producturl: /* nullability unknown */ Option[/* max 256 chars */ String],
  warrantyperiod: /* nullability unknown */ Option[/* max 256 chars */ String],
  warrantydescription: /* nullability unknown */ Option[/* max 256 chars */ String],
  noofyears: /* nullability unknown */ Option[/* max 256 chars */ String],
  maintenancedescription: /* nullability unknown */ Option[/* max 256 chars */ String],
  wheel: /* nullability unknown */ Option[/* max 256 chars */ String],
  saddle: /* nullability unknown */ Option[/* max 256 chars */ String],
  pedal: /* nullability unknown */ Option[/* max 256 chars */ String],
  bikeframe: /* nullability unknown */ Option[String],
  crankset: /* nullability unknown */ Option[/* max 256 chars */ String],
  pictureangle: /* nullability unknown */ Option[/* max 256 chars */ String],
  picturesize: /* nullability unknown */ Option[/* max 256 chars */ String],
  productphotoid: /* nullability unknown */ Option[/* max 256 chars */ String],
  material: /* nullability unknown */ Option[/* max 256 chars */ String],
  color: /* nullability unknown */ Option[/* max 256 chars */ String],
  productline: /* nullability unknown */ Option[/* max 256 chars */ String],
  style: /* nullability unknown */ Option[/* max 256 chars */ String],
  riderexperience: /* nullability unknown */ Option[/* max 1024 chars */ String],
  /** Points to [[productmodel.ProductmodelRow.rowguid]] */
  rowguid: TypoUUID,
  /** Points to [[productmodel.ProductmodelRow.modifieddate]] */
  modifieddate: TypoLocalDateTime
)

object VproductmodelcatalogdescriptionViewRow {
  implicit lazy val decoder: Decoder[VproductmodelcatalogdescriptionViewRow] = Decoder.instanceTry[VproductmodelcatalogdescriptionViewRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      VproductmodelcatalogdescriptionViewRow(
        productmodelid = orThrow(c.get("productmodelid")(ProductmodelId.decoder)),
        name = orThrow(c.get("name")(Name.decoder)),
        summary = orThrow(c.get("Summary")(Decoder.decodeOption(Decoder.decodeString))),
        manufacturer = orThrow(c.get("manufacturer")(Decoder.decodeOption(Decoder.decodeString))),
        copyright = orThrow(c.get("copyright")(Decoder.decodeOption(Decoder.decodeString))),
        producturl = orThrow(c.get("producturl")(Decoder.decodeOption(Decoder.decodeString))),
        warrantyperiod = orThrow(c.get("warrantyperiod")(Decoder.decodeOption(Decoder.decodeString))),
        warrantydescription = orThrow(c.get("warrantydescription")(Decoder.decodeOption(Decoder.decodeString))),
        noofyears = orThrow(c.get("noofyears")(Decoder.decodeOption(Decoder.decodeString))),
        maintenancedescription = orThrow(c.get("maintenancedescription")(Decoder.decodeOption(Decoder.decodeString))),
        wheel = orThrow(c.get("wheel")(Decoder.decodeOption(Decoder.decodeString))),
        saddle = orThrow(c.get("saddle")(Decoder.decodeOption(Decoder.decodeString))),
        pedal = orThrow(c.get("pedal")(Decoder.decodeOption(Decoder.decodeString))),
        bikeframe = orThrow(c.get("bikeframe")(Decoder.decodeOption(Decoder.decodeString))),
        crankset = orThrow(c.get("crankset")(Decoder.decodeOption(Decoder.decodeString))),
        pictureangle = orThrow(c.get("pictureangle")(Decoder.decodeOption(Decoder.decodeString))),
        picturesize = orThrow(c.get("picturesize")(Decoder.decodeOption(Decoder.decodeString))),
        productphotoid = orThrow(c.get("productphotoid")(Decoder.decodeOption(Decoder.decodeString))),
        material = orThrow(c.get("material")(Decoder.decodeOption(Decoder.decodeString))),
        color = orThrow(c.get("color")(Decoder.decodeOption(Decoder.decodeString))),
        productline = orThrow(c.get("productline")(Decoder.decodeOption(Decoder.decodeString))),
        style = orThrow(c.get("style")(Decoder.decodeOption(Decoder.decodeString))),
        riderexperience = orThrow(c.get("riderexperience")(Decoder.decodeOption(Decoder.decodeString))),
        rowguid = orThrow(c.get("rowguid")(TypoUUID.decoder)),
        modifieddate = orThrow(c.get("modifieddate")(TypoLocalDateTime.decoder))
      )
    }
  )
  implicit lazy val encoder: Encoder[VproductmodelcatalogdescriptionViewRow] = Encoder[VproductmodelcatalogdescriptionViewRow](row =>
    Json.obj(
      "productmodelid" -> ProductmodelId.encoder.apply(row.productmodelid),
      "name" -> Name.encoder.apply(row.name),
      "Summary" -> Encoder.encodeOption(Encoder.encodeString).apply(row.summary),
      "manufacturer" -> Encoder.encodeOption(Encoder.encodeString).apply(row.manufacturer),
      "copyright" -> Encoder.encodeOption(Encoder.encodeString).apply(row.copyright),
      "producturl" -> Encoder.encodeOption(Encoder.encodeString).apply(row.producturl),
      "warrantyperiod" -> Encoder.encodeOption(Encoder.encodeString).apply(row.warrantyperiod),
      "warrantydescription" -> Encoder.encodeOption(Encoder.encodeString).apply(row.warrantydescription),
      "noofyears" -> Encoder.encodeOption(Encoder.encodeString).apply(row.noofyears),
      "maintenancedescription" -> Encoder.encodeOption(Encoder.encodeString).apply(row.maintenancedescription),
      "wheel" -> Encoder.encodeOption(Encoder.encodeString).apply(row.wheel),
      "saddle" -> Encoder.encodeOption(Encoder.encodeString).apply(row.saddle),
      "pedal" -> Encoder.encodeOption(Encoder.encodeString).apply(row.pedal),
      "bikeframe" -> Encoder.encodeOption(Encoder.encodeString).apply(row.bikeframe),
      "crankset" -> Encoder.encodeOption(Encoder.encodeString).apply(row.crankset),
      "pictureangle" -> Encoder.encodeOption(Encoder.encodeString).apply(row.pictureangle),
      "picturesize" -> Encoder.encodeOption(Encoder.encodeString).apply(row.picturesize),
      "productphotoid" -> Encoder.encodeOption(Encoder.encodeString).apply(row.productphotoid),
      "material" -> Encoder.encodeOption(Encoder.encodeString).apply(row.material),
      "color" -> Encoder.encodeOption(Encoder.encodeString).apply(row.color),
      "productline" -> Encoder.encodeOption(Encoder.encodeString).apply(row.productline),
      "style" -> Encoder.encodeOption(Encoder.encodeString).apply(row.style),
      "riderexperience" -> Encoder.encodeOption(Encoder.encodeString).apply(row.riderexperience),
      "rowguid" -> TypoUUID.encoder.apply(row.rowguid),
      "modifieddate" -> TypoLocalDateTime.encoder.apply(row.modifieddate)
    )
  )
  implicit lazy val read: Read[VproductmodelcatalogdescriptionViewRow] = new Read[VproductmodelcatalogdescriptionViewRow](
    gets = List(
      (ProductmodelId.get, Nullability.NoNulls),
      (Name.get, Nullability.NoNulls),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (Meta.StringMeta.get, Nullability.Nullable),
      (TypoUUID.get, Nullability.NoNulls),
      (TypoLocalDateTime.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => VproductmodelcatalogdescriptionViewRow(
      productmodelid = ProductmodelId.get.unsafeGetNonNullable(rs, i + 0),
      name = Name.get.unsafeGetNonNullable(rs, i + 1),
      summary = Meta.StringMeta.get.unsafeGetNullable(rs, i + 2),
      manufacturer = Meta.StringMeta.get.unsafeGetNullable(rs, i + 3),
      copyright = Meta.StringMeta.get.unsafeGetNullable(rs, i + 4),
      producturl = Meta.StringMeta.get.unsafeGetNullable(rs, i + 5),
      warrantyperiod = Meta.StringMeta.get.unsafeGetNullable(rs, i + 6),
      warrantydescription = Meta.StringMeta.get.unsafeGetNullable(rs, i + 7),
      noofyears = Meta.StringMeta.get.unsafeGetNullable(rs, i + 8),
      maintenancedescription = Meta.StringMeta.get.unsafeGetNullable(rs, i + 9),
      wheel = Meta.StringMeta.get.unsafeGetNullable(rs, i + 10),
      saddle = Meta.StringMeta.get.unsafeGetNullable(rs, i + 11),
      pedal = Meta.StringMeta.get.unsafeGetNullable(rs, i + 12),
      bikeframe = Meta.StringMeta.get.unsafeGetNullable(rs, i + 13),
      crankset = Meta.StringMeta.get.unsafeGetNullable(rs, i + 14),
      pictureangle = Meta.StringMeta.get.unsafeGetNullable(rs, i + 15),
      picturesize = Meta.StringMeta.get.unsafeGetNullable(rs, i + 16),
      productphotoid = Meta.StringMeta.get.unsafeGetNullable(rs, i + 17),
      material = Meta.StringMeta.get.unsafeGetNullable(rs, i + 18),
      color = Meta.StringMeta.get.unsafeGetNullable(rs, i + 19),
      productline = Meta.StringMeta.get.unsafeGetNullable(rs, i + 20),
      style = Meta.StringMeta.get.unsafeGetNullable(rs, i + 21),
      riderexperience = Meta.StringMeta.get.unsafeGetNullable(rs, i + 22),
      rowguid = TypoUUID.get.unsafeGetNonNullable(rs, i + 23),
      modifieddate = TypoLocalDateTime.get.unsafeGetNonNullable(rs, i + 24)
    )
  )
}
