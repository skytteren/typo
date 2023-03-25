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

case class PgDbRoleSettingRow(
  setdatabase: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_db_role_setting","column_name":"setdatabase","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  setrole: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_db_role_setting","column_name":"setrole","ordinal_position":2,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  setconfig: Option[Array[String]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_db_role_setting","column_name":"setconfig","ordinal_position":3,"is_nullable":"YES","data_type":"ARRAY","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_text","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
){
  val compositeId: PgDbRoleSettingId = PgDbRoleSettingId(setdatabase, setrole)
}

object PgDbRoleSettingRow {
  implicit val rowParser: RowParser[PgDbRoleSettingRow] = { row =>
    Success(
      PgDbRoleSettingRow(
        setdatabase = row[Long]("setdatabase"),
        setrole = row[Long]("setrole"),
        setconfig = row[Option[Array[String]]]("setconfig")
      )
    )
  }

  implicit val oFormat: OFormat[PgDbRoleSettingRow] = new OFormat[PgDbRoleSettingRow]{
    override def writes(o: PgDbRoleSettingRow): JsObject =
      Json.obj(
        "setdatabase" -> o.setdatabase,
      "setrole" -> o.setrole,
      "setconfig" -> o.setconfig
      )

    override def reads(json: JsValue): JsResult[PgDbRoleSettingRow] = {
      JsResult.fromTry(
        Try(
          PgDbRoleSettingRow(
            setdatabase = json.\("setdatabase").as[Long],
            setrole = json.\("setrole").as[Long],
            setconfig = json.\("setconfig").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}