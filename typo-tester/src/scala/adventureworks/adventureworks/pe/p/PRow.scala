/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package p

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PRow(
  /** debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"id","ordinal_position":1,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  id: Option[Int],
  /** Points to [[person.person.PersonRow.businessentityid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"businessentityid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  businessentityid: Option[BusinessentityId],
  /** Points to [[person.person.PersonRow.persontype]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"persontype","ordinal_position":3,"is_nullable":"YES","data_type":"character","character_maximum_length":2,"character_octet_length":8,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  persontype: Option[/* bpchar */ String],
  /** Points to [[person.person.PersonRow.namestyle]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"namestyle","ordinal_position":4,"is_nullable":"NO","data_type":"boolean","domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"NameStyle","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  namestyle: NameStyle,
  /** Points to [[person.person.PersonRow.title]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"title","ordinal_position":5,"is_nullable":"YES","data_type":"character varying","character_maximum_length":8,"character_octet_length":32,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  title: Option[String],
  /** Points to [[person.person.PersonRow.firstname]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"firstname","ordinal_position":6,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  firstname: Option[Name],
  /** Points to [[person.person.PersonRow.middlename]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"middlename","ordinal_position":7,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  middlename: Option[Name],
  /** Points to [[person.person.PersonRow.lastname]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"lastname","ordinal_position":8,"is_nullable":"YES","data_type":"character varying","character_maximum_length":50,"character_octet_length":200,"domain_catalog":"Adventureworks","domain_schema":"public","domain_name":"Name","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  lastname: Option[Name],
  /** Points to [[person.person.PersonRow.suffix]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"suffix","ordinal_position":9,"is_nullable":"YES","data_type":"character varying","character_maximum_length":10,"character_octet_length":40,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  suffix: Option[String],
  /** Points to [[person.person.PersonRow.emailpromotion]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"emailpromotion","ordinal_position":10,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  emailpromotion: Option[Int],
  /** Points to [[person.person.PersonRow.additionalcontactinfo]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"additionalcontactinfo","ordinal_position":11,"is_nullable":"YES","data_type":"xml","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"xml","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  additionalcontactinfo: Option[/* xml */ String],
  /** Points to [[person.person.PersonRow.demographics]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"demographics","ordinal_position":12,"is_nullable":"YES","data_type":"xml","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"xml","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  demographics: Option[/* xml */ String],
  /** Points to [[person.person.PersonRow.rowguid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"rowguid","ordinal_position":13,"is_nullable":"YES","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: Option[UUID],
  /** Points to [[person.person.PersonRow.modifieddate]]
      debug: {"table_catalog":"Adventureworks","table_schema":"pe","table_name":"p","column_name":"modifieddate","ordinal_position":14,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Option[LocalDateTime]
)

object PRow {
  implicit val oFormat: OFormat[PRow] = new OFormat[PRow]{
    override def writes(o: PRow): JsObject =
      Json.obj(
        "id" -> o.id,
        "businessentityid" -> o.businessentityid,
        "persontype" -> o.persontype,
        "namestyle" -> o.namestyle,
        "title" -> o.title,
        "firstname" -> o.firstname,
        "middlename" -> o.middlename,
        "lastname" -> o.lastname,
        "suffix" -> o.suffix,
        "emailpromotion" -> o.emailpromotion,
        "additionalcontactinfo" -> o.additionalcontactinfo,
        "demographics" -> o.demographics,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[PRow] = {
      JsResult.fromTry(
        Try(
          PRow(
            id = json.\("id").toOption.map(_.as[Int]),
            businessentityid = json.\("businessentityid").toOption.map(_.as[BusinessentityId]),
            persontype = json.\("persontype").toOption.map(_.as[/* bpchar */ String]),
            namestyle = json.\("namestyle").as[NameStyle],
            title = json.\("title").toOption.map(_.as[String]),
            firstname = json.\("firstname").toOption.map(_.as[Name]),
            middlename = json.\("middlename").toOption.map(_.as[Name]),
            lastname = json.\("lastname").toOption.map(_.as[Name]),
            suffix = json.\("suffix").toOption.map(_.as[String]),
            emailpromotion = json.\("emailpromotion").toOption.map(_.as[Int]),
            additionalcontactinfo = json.\("additionalcontactinfo").toOption.map(_.as[/* xml */ String]),
            demographics = json.\("demographics").toOption.map(_.as[/* xml */ String]),
            rowguid = json.\("rowguid").toOption.map(_.as[UUID]),
            modifieddate = json.\("modifieddate").toOption.map(_.as[LocalDateTime])
          )
        )
      )
    }
  }
}