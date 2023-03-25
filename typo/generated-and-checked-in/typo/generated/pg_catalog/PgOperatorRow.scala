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

case class PgOperatorRow(
  oid: PgOperatorId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprname: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprname","ordinal_position":2,"is_nullable":"NO","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprnamespace: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprnamespace","ordinal_position":3,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprowner: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprowner","ordinal_position":4,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprkind: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprkind","ordinal_position":5,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprcanmerge: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprcanmerge","ordinal_position":6,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprcanhash: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprcanhash","ordinal_position":7,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprleft: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprleft","ordinal_position":8,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprright: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprright","ordinal_position":9,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprresult: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprresult","ordinal_position":10,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprcom: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprcom","ordinal_position":11,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprnegate: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprnegate","ordinal_position":12,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprcode: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprcode","ordinal_position":13,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprrest: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprrest","ordinal_position":14,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  oprjoin: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_operator","column_name":"oprjoin","ordinal_position":15,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgOperatorRow {
  implicit val rowParser: RowParser[PgOperatorRow] = { row =>
    Success(
      PgOperatorRow(
        oid = row[PgOperatorId]("oid"),
        oprname = row[String]("oprname"),
        oprnamespace = row[Long]("oprnamespace"),
        oprowner = row[Long]("oprowner"),
        oprkind = row[String]("oprkind"),
        oprcanmerge = row[Boolean]("oprcanmerge"),
        oprcanhash = row[Boolean]("oprcanhash"),
        oprleft = row[Long]("oprleft"),
        oprright = row[Long]("oprright"),
        oprresult = row[Long]("oprresult"),
        oprcom = row[Long]("oprcom"),
        oprnegate = row[Long]("oprnegate"),
        oprcode = row[PGobject]("oprcode"),
        oprrest = row[PGobject]("oprrest"),
        oprjoin = row[PGobject]("oprjoin")
      )
    )
  }

  implicit val oFormat: OFormat[PgOperatorRow] = new OFormat[PgOperatorRow]{
    override def writes(o: PgOperatorRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "oprname" -> o.oprname,
      "oprnamespace" -> o.oprnamespace,
      "oprowner" -> o.oprowner,
      "oprkind" -> o.oprkind,
      "oprcanmerge" -> o.oprcanmerge,
      "oprcanhash" -> o.oprcanhash,
      "oprleft" -> o.oprleft,
      "oprright" -> o.oprright,
      "oprresult" -> o.oprresult,
      "oprcom" -> o.oprcom,
      "oprnegate" -> o.oprnegate,
      "oprcode" -> o.oprcode,
      "oprrest" -> o.oprrest,
      "oprjoin" -> o.oprjoin
      )

    override def reads(json: JsValue): JsResult[PgOperatorRow] = {
      JsResult.fromTry(
        Try(
          PgOperatorRow(
            oid = json.\("oid").as[PgOperatorId],
            oprname = json.\("oprname").as[String],
            oprnamespace = json.\("oprnamespace").as[Long],
            oprowner = json.\("oprowner").as[Long],
            oprkind = json.\("oprkind").as[String],
            oprcanmerge = json.\("oprcanmerge").as[Boolean],
            oprcanhash = json.\("oprcanhash").as[Boolean],
            oprleft = json.\("oprleft").as[Long],
            oprright = json.\("oprright").as[Long],
            oprresult = json.\("oprresult").as[Long],
            oprcom = json.\("oprcom").as[Long],
            oprnegate = json.\("oprnegate").as[Long],
            oprcode = json.\("oprcode").as[PGobject],
            oprrest = json.\("oprrest").as[PGobject],
            oprjoin = json.\("oprjoin").as[PGobject]
          )
        )
      )
    }
  }
}