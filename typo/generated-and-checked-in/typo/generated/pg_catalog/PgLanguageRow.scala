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

case class PgLanguageRow(
  oid: PgLanguageId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_language","column_name":"oid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  lanname: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_language","column_name":"lanname","ordinal_position":2,"is_nullable":"NO","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  lanowner: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_language","column_name":"lanowner","ordinal_position":3,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  lanispl: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_language","column_name":"lanispl","ordinal_position":4,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  lanpltrusted: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_language","column_name":"lanpltrusted","ordinal_position":5,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  lanplcallfoid: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_language","column_name":"lanplcallfoid","ordinal_position":6,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  laninline: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_language","column_name":"laninline","ordinal_position":7,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  lanvalidator: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_language","column_name":"lanvalidator","ordinal_position":8,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  lanacl: Option[Array[PGobject]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_language","column_name":"lanacl","ordinal_position":9,"is_nullable":"YES","data_type":"ARRAY","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_aclitem","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgLanguageRow {
  implicit val rowParser: RowParser[PgLanguageRow] = { row =>
    Success(
      PgLanguageRow(
        oid = row[PgLanguageId]("oid"),
        lanname = row[String]("lanname"),
        lanowner = row[Long]("lanowner"),
        lanispl = row[Boolean]("lanispl"),
        lanpltrusted = row[Boolean]("lanpltrusted"),
        lanplcallfoid = row[Long]("lanplcallfoid"),
        laninline = row[Long]("laninline"),
        lanvalidator = row[Long]("lanvalidator"),
        lanacl = row[Option[Array[PGobject]]]("lanacl")
      )
    )
  }

  implicit val oFormat: OFormat[PgLanguageRow] = new OFormat[PgLanguageRow]{
    override def writes(o: PgLanguageRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "lanname" -> o.lanname,
      "lanowner" -> o.lanowner,
      "lanispl" -> o.lanispl,
      "lanpltrusted" -> o.lanpltrusted,
      "lanplcallfoid" -> o.lanplcallfoid,
      "laninline" -> o.laninline,
      "lanvalidator" -> o.lanvalidator,
      "lanacl" -> o.lanacl
      )

    override def reads(json: JsValue): JsResult[PgLanguageRow] = {
      JsResult.fromTry(
        Try(
          PgLanguageRow(
            oid = json.\("oid").as[PgLanguageId],
            lanname = json.\("lanname").as[String],
            lanowner = json.\("lanowner").as[Long],
            lanispl = json.\("lanispl").as[Boolean],
            lanpltrusted = json.\("lanpltrusted").as[Boolean],
            lanplcallfoid = json.\("lanplcallfoid").as[Long],
            laninline = json.\("laninline").as[Long],
            lanvalidator = json.\("lanvalidator").as[Long],
            lanacl = json.\("lanacl").toOption.map(_.as[Array[PGobject]])
          )
        )
      )
    }
  }
}