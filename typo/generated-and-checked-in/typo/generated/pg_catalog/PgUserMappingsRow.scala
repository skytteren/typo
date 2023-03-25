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

case class PgUserMappingsRow(
  umid: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user_mappings","column_name":"umid","ordinal_position":1,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  srvid: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user_mappings","column_name":"srvid","ordinal_position":2,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  srvname: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user_mappings","column_name":"srvname","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  umuser: Option[Long] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user_mappings","column_name":"umuser","ordinal_position":4,"is_nullable":"YES","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  usename: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user_mappings","column_name":"usename","ordinal_position":5,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  umoptions: Option[Array[String]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_user_mappings","column_name":"umoptions","ordinal_position":6,"is_nullable":"YES","data_type":"ARRAY","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_text","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object PgUserMappingsRow {
  implicit val rowParser: RowParser[PgUserMappingsRow] = { row =>
    Success(
      PgUserMappingsRow(
        umid = row[Option[Long]]("umid"),
        srvid = row[Option[Long]]("srvid"),
        srvname = row[Option[String]]("srvname"),
        umuser = row[Option[Long]]("umuser"),
        usename = row[Option[String]]("usename"),
        umoptions = row[Option[Array[String]]]("umoptions")
      )
    )
  }

  implicit val oFormat: OFormat[PgUserMappingsRow] = new OFormat[PgUserMappingsRow]{
    override def writes(o: PgUserMappingsRow): JsObject =
      Json.obj(
        "umid" -> o.umid,
      "srvid" -> o.srvid,
      "srvname" -> o.srvname,
      "umuser" -> o.umuser,
      "usename" -> o.usename,
      "umoptions" -> o.umoptions
      )

    override def reads(json: JsValue): JsResult[PgUserMappingsRow] = {
      JsResult.fromTry(
        Try(
          PgUserMappingsRow(
            umid = json.\("umid").toOption.map(_.as[Long]),
            srvid = json.\("srvid").toOption.map(_.as[Long]),
            srvname = json.\("srvname").toOption.map(_.as[String]),
            umuser = json.\("umuser").toOption.map(_.as[Long]),
            usename = json.\("usename").toOption.map(_.as[String]),
            umoptions = json.\("umoptions").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}