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

case class PgClassRow(
  oid: PgClassId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"oid","ordinal_position":1,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relname: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relname","ordinal_position":2,"is_nullable":"NO","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relnamespace: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relnamespace","ordinal_position":3,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  reltype: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"reltype","ordinal_position":4,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  reloftype: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"reloftype","ordinal_position":5,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relowner: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relowner","ordinal_position":6,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relam: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relam","ordinal_position":7,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relfilenode: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relfilenode","ordinal_position":8,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  reltablespace: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"reltablespace","ordinal_position":9,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relpages: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relpages","ordinal_position":10,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  reltuples: Float /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"reltuples","ordinal_position":11,"is_nullable":"NO","data_type":"real","numeric_precision":24,"numeric_precision_radix":2,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"float4","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relallvisible: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relallvisible","ordinal_position":12,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  reltoastrelid: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"reltoastrelid","ordinal_position":13,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relhasindex: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relhasindex","ordinal_position":14,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relisshared: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relisshared","ordinal_position":15,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relpersistence: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relpersistence","ordinal_position":16,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relkind: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relkind","ordinal_position":17,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"17","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relnatts: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relnatts","ordinal_position":18,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"18","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relchecks: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relchecks","ordinal_position":19,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"19","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relhasrules: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relhasrules","ordinal_position":20,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"20","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relhastriggers: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relhastriggers","ordinal_position":21,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"21","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relhassubclass: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relhassubclass","ordinal_position":22,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"22","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relrowsecurity: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relrowsecurity","ordinal_position":23,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"23","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relforcerowsecurity: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relforcerowsecurity","ordinal_position":24,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"24","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relispopulated: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relispopulated","ordinal_position":25,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"25","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relreplident: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relreplident","ordinal_position":26,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"26","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relispartition: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relispartition","ordinal_position":27,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"27","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relrewrite: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relrewrite","ordinal_position":28,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"28","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relfrozenxid: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relfrozenxid","ordinal_position":29,"is_nullable":"NO","data_type":"xid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"xid","dtd_identifier":"29","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relminmxid: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relminmxid","ordinal_position":30,"is_nullable":"NO","data_type":"xid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"xid","dtd_identifier":"30","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relacl: Option[Array[PGobject]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relacl","ordinal_position":31,"is_nullable":"YES","data_type":"ARRAY","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_aclitem","dtd_identifier":"31","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  reloptions: Option[Array[String]] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"reloptions","ordinal_position":32,"is_nullable":"YES","data_type":"ARRAY","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"_text","dtd_identifier":"32","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  relpartbound: Option[PGobject] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_class","column_name":"relpartbound","ordinal_position":33,"is_nullable":"YES","data_type":"pg_node_tree","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"pg_node_tree","dtd_identifier":"33","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgClassRow {
  implicit val rowParser: RowParser[PgClassRow] = { row =>
    Success(
      PgClassRow(
        oid = row[PgClassId]("oid"),
        relname = row[String]("relname"),
        relnamespace = row[Long]("relnamespace"),
        reltype = row[Long]("reltype"),
        reloftype = row[Long]("reloftype"),
        relowner = row[Long]("relowner"),
        relam = row[Long]("relam"),
        relfilenode = row[Long]("relfilenode"),
        reltablespace = row[Long]("reltablespace"),
        relpages = row[Int]("relpages"),
        reltuples = row[Float]("reltuples"),
        relallvisible = row[Int]("relallvisible"),
        reltoastrelid = row[Long]("reltoastrelid"),
        relhasindex = row[Boolean]("relhasindex"),
        relisshared = row[Boolean]("relisshared"),
        relpersistence = row[String]("relpersistence"),
        relkind = row[String]("relkind"),
        relnatts = row[Int]("relnatts"),
        relchecks = row[Int]("relchecks"),
        relhasrules = row[Boolean]("relhasrules"),
        relhastriggers = row[Boolean]("relhastriggers"),
        relhassubclass = row[Boolean]("relhassubclass"),
        relrowsecurity = row[Boolean]("relrowsecurity"),
        relforcerowsecurity = row[Boolean]("relforcerowsecurity"),
        relispopulated = row[Boolean]("relispopulated"),
        relreplident = row[String]("relreplident"),
        relispartition = row[Boolean]("relispartition"),
        relrewrite = row[Long]("relrewrite"),
        relfrozenxid = row[PGobject]("relfrozenxid"),
        relminmxid = row[PGobject]("relminmxid"),
        relacl = row[Option[Array[PGobject]]]("relacl"),
        reloptions = row[Option[Array[String]]]("reloptions"),
        relpartbound = row[Option[PGobject]]("relpartbound")
      )
    )
  }

  implicit val oFormat: OFormat[PgClassRow] = new OFormat[PgClassRow]{
    override def writes(o: PgClassRow): JsObject =
      Json.obj(
        "oid" -> o.oid,
      "relname" -> o.relname,
      "relnamespace" -> o.relnamespace,
      "reltype" -> o.reltype,
      "reloftype" -> o.reloftype,
      "relowner" -> o.relowner,
      "relam" -> o.relam,
      "relfilenode" -> o.relfilenode,
      "reltablespace" -> o.reltablespace,
      "relpages" -> o.relpages,
      "reltuples" -> o.reltuples,
      "relallvisible" -> o.relallvisible,
      "reltoastrelid" -> o.reltoastrelid,
      "relhasindex" -> o.relhasindex,
      "relisshared" -> o.relisshared,
      "relpersistence" -> o.relpersistence,
      "relkind" -> o.relkind,
      "relnatts" -> o.relnatts,
      "relchecks" -> o.relchecks,
      "relhasrules" -> o.relhasrules,
      "relhastriggers" -> o.relhastriggers,
      "relhassubclass" -> o.relhassubclass,
      "relrowsecurity" -> o.relrowsecurity,
      "relforcerowsecurity" -> o.relforcerowsecurity,
      "relispopulated" -> o.relispopulated,
      "relreplident" -> o.relreplident,
      "relispartition" -> o.relispartition,
      "relrewrite" -> o.relrewrite,
      "relfrozenxid" -> o.relfrozenxid,
      "relminmxid" -> o.relminmxid,
      "relacl" -> o.relacl,
      "reloptions" -> o.reloptions,
      "relpartbound" -> o.relpartbound
      )

    override def reads(json: JsValue): JsResult[PgClassRow] = {
      JsResult.fromTry(
        Try(
          PgClassRow(
            oid = json.\("oid").as[PgClassId],
            relname = json.\("relname").as[String],
            relnamespace = json.\("relnamespace").as[Long],
            reltype = json.\("reltype").as[Long],
            reloftype = json.\("reloftype").as[Long],
            relowner = json.\("relowner").as[Long],
            relam = json.\("relam").as[Long],
            relfilenode = json.\("relfilenode").as[Long],
            reltablespace = json.\("reltablespace").as[Long],
            relpages = json.\("relpages").as[Int],
            reltuples = json.\("reltuples").as[Float],
            relallvisible = json.\("relallvisible").as[Int],
            reltoastrelid = json.\("reltoastrelid").as[Long],
            relhasindex = json.\("relhasindex").as[Boolean],
            relisshared = json.\("relisshared").as[Boolean],
            relpersistence = json.\("relpersistence").as[String],
            relkind = json.\("relkind").as[String],
            relnatts = json.\("relnatts").as[Int],
            relchecks = json.\("relchecks").as[Int],
            relhasrules = json.\("relhasrules").as[Boolean],
            relhastriggers = json.\("relhastriggers").as[Boolean],
            relhassubclass = json.\("relhassubclass").as[Boolean],
            relrowsecurity = json.\("relrowsecurity").as[Boolean],
            relforcerowsecurity = json.\("relforcerowsecurity").as[Boolean],
            relispopulated = json.\("relispopulated").as[Boolean],
            relreplident = json.\("relreplident").as[String],
            relispartition = json.\("relispartition").as[Boolean],
            relrewrite = json.\("relrewrite").as[Long],
            relfrozenxid = json.\("relfrozenxid").as[PGobject],
            relminmxid = json.\("relminmxid").as[PGobject],
            relacl = json.\("relacl").toOption.map(_.as[Array[PGobject]]),
            reloptions = json.\("reloptions").toOption.map(_.as[Array[String]]),
            relpartbound = json.\("relpartbound").toOption.map(_.as[PGobject])
          )
        )
      )
    }
  }
}