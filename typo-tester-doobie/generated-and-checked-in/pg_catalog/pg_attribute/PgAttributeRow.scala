/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_attribute

import adventureworks.TypoAclItem
import adventureworks.TypoAnyArray
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import scala.util.Try

case class PgAttributeRow(
  attrelid: /* oid */ Long,
  attname: String,
  atttypid: /* oid */ Long,
  attstattarget: Int,
  attlen: Int,
  attnum: Int,
  attndims: Int,
  attcacheoff: Int,
  atttypmod: Int,
  attbyval: Boolean,
  attalign: String,
  attstorage: String,
  attcompression: String,
  attnotnull: Boolean,
  atthasdef: Boolean,
  atthasmissing: Boolean,
  attidentity: String,
  attgenerated: String,
  attisdropped: Boolean,
  attislocal: Boolean,
  attinhcount: Int,
  attcollation: /* oid */ Long,
  attacl: Option[Array[TypoAclItem]],
  attoptions: Option[Array[String]],
  attfdwoptions: Option[Array[String]],
  attmissingval: Option[TypoAnyArray]
){
   val compositeId: PgAttributeId = PgAttributeId(attrelid, attnum)
 }

object PgAttributeRow {
  implicit val decoder: Decoder[PgAttributeRow] = Decoder.instanceTry[PgAttributeRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      PgAttributeRow(
        attrelid = orThrow(c.get("attrelid")(Decoder[/* oid */ Long])),
        attname = orThrow(c.get("attname")(Decoder[String])),
        atttypid = orThrow(c.get("atttypid")(Decoder[/* oid */ Long])),
        attstattarget = orThrow(c.get("attstattarget")(Decoder[Int])),
        attlen = orThrow(c.get("attlen")(Decoder[Int])),
        attnum = orThrow(c.get("attnum")(Decoder[Int])),
        attndims = orThrow(c.get("attndims")(Decoder[Int])),
        attcacheoff = orThrow(c.get("attcacheoff")(Decoder[Int])),
        atttypmod = orThrow(c.get("atttypmod")(Decoder[Int])),
        attbyval = orThrow(c.get("attbyval")(Decoder[Boolean])),
        attalign = orThrow(c.get("attalign")(Decoder[String])),
        attstorage = orThrow(c.get("attstorage")(Decoder[String])),
        attcompression = orThrow(c.get("attcompression")(Decoder[String])),
        attnotnull = orThrow(c.get("attnotnull")(Decoder[Boolean])),
        atthasdef = orThrow(c.get("atthasdef")(Decoder[Boolean])),
        atthasmissing = orThrow(c.get("atthasmissing")(Decoder[Boolean])),
        attidentity = orThrow(c.get("attidentity")(Decoder[String])),
        attgenerated = orThrow(c.get("attgenerated")(Decoder[String])),
        attisdropped = orThrow(c.get("attisdropped")(Decoder[Boolean])),
        attislocal = orThrow(c.get("attislocal")(Decoder[Boolean])),
        attinhcount = orThrow(c.get("attinhcount")(Decoder[Int])),
        attcollation = orThrow(c.get("attcollation")(Decoder[/* oid */ Long])),
        attacl = orThrow(c.get("attacl")(Decoder[Option[Array[TypoAclItem]]])),
        attoptions = orThrow(c.get("attoptions")(Decoder[Option[Array[String]]])),
        attfdwoptions = orThrow(c.get("attfdwoptions")(Decoder[Option[Array[String]]])),
        attmissingval = orThrow(c.get("attmissingval")(Decoder[Option[TypoAnyArray]]))
      )
    }
  )
  implicit val encoder: Encoder[PgAttributeRow] = Encoder[PgAttributeRow](row =>
    Json.obj(
      "attrelid" -> Encoder[/* oid */ Long].apply(row.attrelid),
      "attname" -> Encoder[String].apply(row.attname),
      "atttypid" -> Encoder[/* oid */ Long].apply(row.atttypid),
      "attstattarget" -> Encoder[Int].apply(row.attstattarget),
      "attlen" -> Encoder[Int].apply(row.attlen),
      "attnum" -> Encoder[Int].apply(row.attnum),
      "attndims" -> Encoder[Int].apply(row.attndims),
      "attcacheoff" -> Encoder[Int].apply(row.attcacheoff),
      "atttypmod" -> Encoder[Int].apply(row.atttypmod),
      "attbyval" -> Encoder[Boolean].apply(row.attbyval),
      "attalign" -> Encoder[String].apply(row.attalign),
      "attstorage" -> Encoder[String].apply(row.attstorage),
      "attcompression" -> Encoder[String].apply(row.attcompression),
      "attnotnull" -> Encoder[Boolean].apply(row.attnotnull),
      "atthasdef" -> Encoder[Boolean].apply(row.atthasdef),
      "atthasmissing" -> Encoder[Boolean].apply(row.atthasmissing),
      "attidentity" -> Encoder[String].apply(row.attidentity),
      "attgenerated" -> Encoder[String].apply(row.attgenerated),
      "attisdropped" -> Encoder[Boolean].apply(row.attisdropped),
      "attislocal" -> Encoder[Boolean].apply(row.attislocal),
      "attinhcount" -> Encoder[Int].apply(row.attinhcount),
      "attcollation" -> Encoder[/* oid */ Long].apply(row.attcollation),
      "attacl" -> Encoder[Option[Array[TypoAclItem]]].apply(row.attacl),
      "attoptions" -> Encoder[Option[Array[String]]].apply(row.attoptions),
      "attfdwoptions" -> Encoder[Option[Array[String]]].apply(row.attfdwoptions),
      "attmissingval" -> Encoder[Option[TypoAnyArray]].apply(row.attmissingval)
    )
  )
  implicit val read: Read[PgAttributeRow] = new Read[PgAttributeRow](
    gets = List(
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[String], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Boolean], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[/* oid */ Long], Nullability.NoNulls),
      (Get[Array[TypoAclItem]], Nullability.Nullable),
      (Get[Array[String]], Nullability.Nullable),
      (Get[Array[String]], Nullability.Nullable),
      (Get[TypoAnyArray], Nullability.Nullable)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => PgAttributeRow(
      attrelid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 0),
      attname = Get[String].unsafeGetNonNullable(rs, i + 1),
      atttypid = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 2),
      attstattarget = Get[Int].unsafeGetNonNullable(rs, i + 3),
      attlen = Get[Int].unsafeGetNonNullable(rs, i + 4),
      attnum = Get[Int].unsafeGetNonNullable(rs, i + 5),
      attndims = Get[Int].unsafeGetNonNullable(rs, i + 6),
      attcacheoff = Get[Int].unsafeGetNonNullable(rs, i + 7),
      atttypmod = Get[Int].unsafeGetNonNullable(rs, i + 8),
      attbyval = Get[Boolean].unsafeGetNonNullable(rs, i + 9),
      attalign = Get[String].unsafeGetNonNullable(rs, i + 10),
      attstorage = Get[String].unsafeGetNonNullable(rs, i + 11),
      attcompression = Get[String].unsafeGetNonNullable(rs, i + 12),
      attnotnull = Get[Boolean].unsafeGetNonNullable(rs, i + 13),
      atthasdef = Get[Boolean].unsafeGetNonNullable(rs, i + 14),
      atthasmissing = Get[Boolean].unsafeGetNonNullable(rs, i + 15),
      attidentity = Get[String].unsafeGetNonNullable(rs, i + 16),
      attgenerated = Get[String].unsafeGetNonNullable(rs, i + 17),
      attisdropped = Get[Boolean].unsafeGetNonNullable(rs, i + 18),
      attislocal = Get[Boolean].unsafeGetNonNullable(rs, i + 19),
      attinhcount = Get[Int].unsafeGetNonNullable(rs, i + 20),
      attcollation = Get[/* oid */ Long].unsafeGetNonNullable(rs, i + 21),
      attacl = Get[Array[TypoAclItem]].unsafeGetNullable(rs, i + 22),
      attoptions = Get[Array[String]].unsafeGetNullable(rs, i + 23),
      attfdwoptions = Get[Array[String]].unsafeGetNullable(rs, i + 24),
      attmissingval = Get[TypoAnyArray].unsafeGetNullable(rs, i + 25)
    )
  )
}
