/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success
import org.postgresql.util.PGobject
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgLargeobjectMetadataRow(
  oid: PgLargeobjectMetadataId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_largeobject_metadata","column_name":"oid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  lomowner: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_largeobject_metadata","column_name":"lomowner","ordinal_position":2,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  lomacl: Option[Array[PGobject]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_largeobject_metadata","column_name":"lomacl","ordinal_position":3,"is_nullable":"YES","data_type":"ARRAY","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_aclitem","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgLargeobjectMetadataRow {
  implicit val rowParser: RowParser[PgLargeobjectMetadataRow] = { row =>
    Success(
      PgLargeobjectMetadataRow(
        oid = row[PgLargeobjectMetadataId]("oid"),
        lomowner = row[Long]("lomowner"),
        lomacl = row[Option[Array[PGobject]]]("lomacl")
      )
    )
  }

  implicit val oFormat: OFormat[PgLargeobjectMetadataRow] = new OFormat[PgLargeobjectMetadataRow]{
    override def writes(o: PgLargeobjectMetadataRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "lomowner" -> o.lomowner,
      "lomacl" -> o.lomacl
      )

    override def reads(json: JsValue): JsResult[PgLargeobjectMetadataRow] = {
      JsResult.fromTry(
        Try(
          PgLargeobjectMetadataRow(
            oid = json.\("oid").as[PgLargeobjectMetadataId],
            lomowner = json.\("lomowner").as[Long],
            lomacl = json.\("lomacl").toOption.map(_.as[Array[PGobject]])
          )
        )
      )
    }
  }
}