/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class DomainUdtUsageRow(
  udtCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"domain_udt_usage","column_name":"udt_catalog","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  udtSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"domain_udt_usage","column_name":"udt_schema","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  udtName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"domain_udt_usage","column_name":"udt_name","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  domainCatalog: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"domain_udt_usage","column_name":"domain_catalog","ordinal_position":4,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  domainSchema: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"domain_udt_usage","column_name":"domain_schema","ordinal_position":5,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */,
  domainName: Option[String] /* {"table_catalog":"postgres","table_schema":"information_schema","table_name":"domain_udt_usage","column_name":"domain_name","ordinal_position":6,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
)

object DomainUdtUsageRow {
  implicit val rowParser: RowParser[DomainUdtUsageRow] = { row =>
    Success(
      DomainUdtUsageRow(
        udtCatalog = row[Option[String]]("udt_catalog"),
        udtSchema = row[Option[String]]("udt_schema"),
        udtName = row[Option[String]]("udt_name"),
        domainCatalog = row[Option[String]]("domain_catalog"),
        domainSchema = row[Option[String]]("domain_schema"),
        domainName = row[Option[String]]("domain_name")
      )
    )
  }

  implicit val oFormat: OFormat[DomainUdtUsageRow] = new OFormat[DomainUdtUsageRow]{
    override def writes(o: DomainUdtUsageRow): JsObject =
      Json.obj(
        "udt_catalog" -> o.udtCatalog,
      "udt_schema" -> o.udtSchema,
      "udt_name" -> o.udtName,
      "domain_catalog" -> o.domainCatalog,
      "domain_schema" -> o.domainSchema,
      "domain_name" -> o.domainName
      )

    override def reads(json: JsValue): JsResult[DomainUdtUsageRow] = {
      JsResult.fromTry(
        Try(
          DomainUdtUsageRow(
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[String]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[String]),
            udtName = json.\("udt_name").toOption.map(_.as[String]),
            domainCatalog = json.\("domain_catalog").toOption.map(_.as[String]),
            domainSchema = json.\("domain_schema").toOption.map(_.as[String]),
            domainName = json.\("domain_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}