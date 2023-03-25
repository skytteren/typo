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

case class PgForeignTableRow(
  ftrelid: PgForeignTableId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_foreign_table","column_name":"ftrelid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  ftserver: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_foreign_table","column_name":"ftserver","ordinal_position":2,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  ftoptions: Option[Array[String]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_foreign_table","column_name":"ftoptions","ordinal_position":3,"is_nullable":"YES","data_type":"ARRAY","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_text","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgForeignTableRow {
  implicit val rowParser: RowParser[PgForeignTableRow] = { row =>
    Success(
      PgForeignTableRow(
        ftrelid = row[PgForeignTableId]("ftrelid"),
        ftserver = row[Long]("ftserver"),
        ftoptions = row[Option[Array[String]]]("ftoptions")
      )
    )
  }

  implicit val oFormat: OFormat[PgForeignTableRow] = new OFormat[PgForeignTableRow]{
    override def writes(o: PgForeignTableRow): JsObject =
      Json.obj(
        "ftrelid" -> o.ftrelid,
      "ftserver" -> o.ftserver,
      "ftoptions" -> o.ftoptions
      )

    override def reads(json: JsValue): JsResult[PgForeignTableRow] = {
      JsResult.fromTry(
        Try(
          PgForeignTableRow(
            ftrelid = json.\("ftrelid").as[PgForeignTableId],
            ftserver = json.\("ftserver").as[Long],
            ftoptions = json.\("ftoptions").toOption.map(_.as[Array[String]])
          )
        )
      )
    }
  }
}