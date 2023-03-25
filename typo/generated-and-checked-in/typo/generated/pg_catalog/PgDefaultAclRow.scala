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

case class PgDefaultAclRow(
  oid: PgDefaultAclId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_default_acl","column_name":"oid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  defaclrole: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_default_acl","column_name":"defaclrole","ordinal_position":2,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  defaclnamespace: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_default_acl","column_name":"defaclnamespace","ordinal_position":3,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  defaclobjtype: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_default_acl","column_name":"defaclobjtype","ordinal_position":4,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  defaclacl: Array[PGobject] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_default_acl","column_name":"defaclacl","ordinal_position":5,"is_nullable":"NO","data_type":"ARRAY","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_aclitem","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgDefaultAclRow {
  implicit val rowParser: RowParser[PgDefaultAclRow] = { row =>
    Success(
      PgDefaultAclRow(
        oid = row[PgDefaultAclId]("oid"),
        defaclrole = row[Long]("defaclrole"),
        defaclnamespace = row[Long]("defaclnamespace"),
        defaclobjtype = row[String]("defaclobjtype"),
        defaclacl = row[Array[PGobject]]("defaclacl")
      )
    )
  }

  implicit val oFormat: OFormat[PgDefaultAclRow] = new OFormat[PgDefaultAclRow]{
    override def writes(o: PgDefaultAclRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "defaclrole" -> o.defaclrole,
      "defaclnamespace" -> o.defaclnamespace,
      "defaclobjtype" -> o.defaclobjtype,
      "defaclacl" -> o.defaclacl
      )

    override def reads(json: JsValue): JsResult[PgDefaultAclRow] = {
      JsResult.fromTry(
        Try(
          PgDefaultAclRow(
            oid = json.\("oid").as[PgDefaultAclId],
            defaclrole = json.\("defaclrole").as[Long],
            defaclnamespace = json.\("defaclnamespace").as[Long],
            defaclobjtype = json.\("defaclobjtype").as[String],
            defaclacl = json.\("defaclacl").as[Array[PGobject]]
          )
        )
      )
    }
  }
}