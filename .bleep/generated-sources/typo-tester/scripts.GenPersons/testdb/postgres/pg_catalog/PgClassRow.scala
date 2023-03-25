/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
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
  oid: PgClassId,
  relname: String,
  relnamespace: Long,
  reltype: Long,
  reloftype: Long,
  relowner: Long,
  relam: Long,
  relfilenode: Long,
  reltablespace: Long,
  relpages: Int,
  reltuples: Float,
  relallvisible: Int,
  reltoastrelid: Long,
  relhasindex: Boolean,
  relisshared: Boolean,
  relpersistence: String,
  relkind: String,
  relnatts: Int,
  relchecks: Int,
  relhasrules: Boolean,
  relhastriggers: Boolean,
  relhassubclass: Boolean,
  relrowsecurity: Boolean,
  relforcerowsecurity: Boolean,
  relispopulated: Boolean,
  relreplident: String,
  relispartition: Boolean,
  relrewrite: Long,
  relfrozenxid: PGobject,
  relminmxid: PGobject,
  relacl: Option[Array[PGobject]],
  reloptions: Option[Array[String]],
  relpartbound: Option[PGobject]
)

object PgClassRow {
  def rowParser(prefix: String): RowParser[PgClassRow] = { row =>
    Success(
      PgClassRow(
        oid = row[PgClassId](prefix + "oid"),
        relname = row[String](prefix + "relname"),
        relnamespace = row[Long](prefix + "relnamespace"),
        reltype = row[Long](prefix + "reltype"),
        reloftype = row[Long](prefix + "reloftype"),
        relowner = row[Long](prefix + "relowner"),
        relam = row[Long](prefix + "relam"),
        relfilenode = row[Long](prefix + "relfilenode"),
        reltablespace = row[Long](prefix + "reltablespace"),
        relpages = row[Int](prefix + "relpages"),
        reltuples = row[Float](prefix + "reltuples"),
        relallvisible = row[Int](prefix + "relallvisible"),
        reltoastrelid = row[Long](prefix + "reltoastrelid"),
        relhasindex = row[Boolean](prefix + "relhasindex"),
        relisshared = row[Boolean](prefix + "relisshared"),
        relpersistence = row[String](prefix + "relpersistence"),
        relkind = row[String](prefix + "relkind"),
        relnatts = row[Int](prefix + "relnatts"),
        relchecks = row[Int](prefix + "relchecks"),
        relhasrules = row[Boolean](prefix + "relhasrules"),
        relhastriggers = row[Boolean](prefix + "relhastriggers"),
        relhassubclass = row[Boolean](prefix + "relhassubclass"),
        relrowsecurity = row[Boolean](prefix + "relrowsecurity"),
        relforcerowsecurity = row[Boolean](prefix + "relforcerowsecurity"),
        relispopulated = row[Boolean](prefix + "relispopulated"),
        relreplident = row[String](prefix + "relreplident"),
        relispartition = row[Boolean](prefix + "relispartition"),
        relrewrite = row[Long](prefix + "relrewrite"),
        relfrozenxid = row[PGobject](prefix + "relfrozenxid"),
        relminmxid = row[PGobject](prefix + "relminmxid"),
        relacl = row[Option[Array[PGobject]]](prefix + "relacl"),
        reloptions = row[Option[Array[String]]](prefix + "reloptions"),
        relpartbound = row[Option[PGobject]](prefix + "relpartbound")
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