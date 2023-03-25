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
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgReplicationOriginRow(
  roident: PgReplicationOriginId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_origin","column_name":"roident","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  roname: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_replication_origin","column_name":"roname","ordinal_position":2,"is_nullable":"NO","data_type":"text","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgReplicationOriginRow {
  implicit val rowParser: RowParser[PgReplicationOriginRow] = { row =>
    Success(
      PgReplicationOriginRow(
        roident = row[PgReplicationOriginId]("roident"),
        roname = row[String]("roname")
      )
    )
  }

  implicit val oFormat: OFormat[PgReplicationOriginRow] = new OFormat[PgReplicationOriginRow]{
    override def writes(o: PgReplicationOriginRow): JsObject =
      Json.obj(
        "roident" -> o.roident,
      "roname" -> o.roname
      )

    override def reads(json: JsValue): JsResult[PgReplicationOriginRow] = {
      JsResult.fromTry(
        Try(
          PgReplicationOriginRow(
            roident = json.\("roident").as[PgReplicationOriginId],
            roname = json.\("roname").as[String]
          )
        )
      )
    }
  }
}