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

case class PgTsConfigMapRow(
  mapcfg: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_ts_config_map","column_name":"mapcfg","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  maptokentype: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_ts_config_map","column_name":"maptokentype","ordinal_position":2,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  mapseqno: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_ts_config_map","column_name":"mapseqno","ordinal_position":3,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  mapdict: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_ts_config_map","column_name":"mapdict","ordinal_position":4,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
){
  val compositeId: PgTsConfigMapId = PgTsConfigMapId(mapcfg, maptokentype, mapseqno)
}

object PgTsConfigMapRow {
  implicit val rowParser: RowParser[PgTsConfigMapRow] = { row =>
    Success(
      PgTsConfigMapRow(
        mapcfg = row[Long]("mapcfg"),
        maptokentype = row[Int]("maptokentype"),
        mapseqno = row[Int]("mapseqno"),
        mapdict = row[Long]("mapdict")
      )
    )
  }

  implicit val oFormat: OFormat[PgTsConfigMapRow] = new OFormat[PgTsConfigMapRow]{
    override def writes(o: PgTsConfigMapRow): JsObject =
      Json.obj(
        "mapcfg" -> o.mapcfg,
      "maptokentype" -> o.maptokentype,
      "mapseqno" -> o.mapseqno,
      "mapdict" -> o.mapdict
      )

    override def reads(json: JsValue): JsResult[PgTsConfigMapRow] = {
      JsResult.fromTry(
        Try(
          PgTsConfigMapRow(
            mapcfg = json.\("mapcfg").as[Long],
            maptokentype = json.\("maptokentype").as[Int],
            mapseqno = json.\("mapseqno").as[Int],
            mapdict = json.\("mapdict").as[Long]
          )
        )
      )
    }
  }
}