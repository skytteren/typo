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

case class PgAggregateRow(
  aggfnoid: PgAggregateId /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggfnoid","ordinal_position":1,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggkind: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggkind","ordinal_position":2,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggnumdirectargs: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggnumdirectargs","ordinal_position":3,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggtransfn: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggtransfn","ordinal_position":4,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggfinalfn: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggfinalfn","ordinal_position":5,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggcombinefn: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggcombinefn","ordinal_position":6,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggserialfn: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggserialfn","ordinal_position":7,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggdeserialfn: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggdeserialfn","ordinal_position":8,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggmtransfn: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggmtransfn","ordinal_position":9,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggminvtransfn: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggminvtransfn","ordinal_position":10,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggmfinalfn: PGobject /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggmfinalfn","ordinal_position":11,"is_nullable":"NO","data_type":"regproc","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"regproc","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggfinalextra: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggfinalextra","ordinal_position":12,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggmfinalextra: Boolean /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggmfinalextra","ordinal_position":13,"is_nullable":"NO","data_type":"boolean","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"bool","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggfinalmodify: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggfinalmodify","ordinal_position":14,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggmfinalmodify: String /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggmfinalmodify","ordinal_position":15,"is_nullable":"NO","data_type":"\"char\"","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"char","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggsortop: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggsortop","ordinal_position":16,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggtranstype: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggtranstype","ordinal_position":17,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"17","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggtransspace: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggtransspace","ordinal_position":18,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"18","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggmtranstype: Long /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggmtranstype","ordinal_position":19,"is_nullable":"NO","data_type":"oid","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"oid","dtd_identifier":"19","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggmtransspace: Int /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggmtransspace","ordinal_position":20,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"20","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  agginitval: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"agginitval","ordinal_position":21,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"21","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */,
  aggminitval: Option[String] /* {"table_catalog":"postgres","table_schema":"pg_catalog","table_name":"pg_aggregate","column_name":"aggminitval","ordinal_position":22,"is_nullable":"YES","data_type":"text","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"text","dtd_identifier":"22","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
)

object PgAggregateRow {
  implicit val rowParser: RowParser[PgAggregateRow] = { row =>
    Success(
      PgAggregateRow(
        aggfnoid = row[PgAggregateId]("aggfnoid"),
        aggkind = row[String]("aggkind"),
        aggnumdirectargs = row[Int]("aggnumdirectargs"),
        aggtransfn = row[PGobject]("aggtransfn"),
        aggfinalfn = row[PGobject]("aggfinalfn"),
        aggcombinefn = row[PGobject]("aggcombinefn"),
        aggserialfn = row[PGobject]("aggserialfn"),
        aggdeserialfn = row[PGobject]("aggdeserialfn"),
        aggmtransfn = row[PGobject]("aggmtransfn"),
        aggminvtransfn = row[PGobject]("aggminvtransfn"),
        aggmfinalfn = row[PGobject]("aggmfinalfn"),
        aggfinalextra = row[Boolean]("aggfinalextra"),
        aggmfinalextra = row[Boolean]("aggmfinalextra"),
        aggfinalmodify = row[String]("aggfinalmodify"),
        aggmfinalmodify = row[String]("aggmfinalmodify"),
        aggsortop = row[Long]("aggsortop"),
        aggtranstype = row[Long]("aggtranstype"),
        aggtransspace = row[Int]("aggtransspace"),
        aggmtranstype = row[Long]("aggmtranstype"),
        aggmtransspace = row[Int]("aggmtransspace"),
        agginitval = row[Option[String]]("agginitval"),
        aggminitval = row[Option[String]]("aggminitval")
      )
    )
  }

  implicit val oFormat: OFormat[PgAggregateRow] = new OFormat[PgAggregateRow]{
    override def writes(o: PgAggregateRow): JsObject =
      Json.obj(
        "aggfnoid" -> o.aggfnoid,
      "aggkind" -> o.aggkind,
      "aggnumdirectargs" -> o.aggnumdirectargs,
      "aggtransfn" -> o.aggtransfn,
      "aggfinalfn" -> o.aggfinalfn,
      "aggcombinefn" -> o.aggcombinefn,
      "aggserialfn" -> o.aggserialfn,
      "aggdeserialfn" -> o.aggdeserialfn,
      "aggmtransfn" -> o.aggmtransfn,
      "aggminvtransfn" -> o.aggminvtransfn,
      "aggmfinalfn" -> o.aggmfinalfn,
      "aggfinalextra" -> o.aggfinalextra,
      "aggmfinalextra" -> o.aggmfinalextra,
      "aggfinalmodify" -> o.aggfinalmodify,
      "aggmfinalmodify" -> o.aggmfinalmodify,
      "aggsortop" -> o.aggsortop,
      "aggtranstype" -> o.aggtranstype,
      "aggtransspace" -> o.aggtransspace,
      "aggmtranstype" -> o.aggmtranstype,
      "aggmtransspace" -> o.aggmtransspace,
      "agginitval" -> o.agginitval,
      "aggminitval" -> o.aggminitval
      )

    override def reads(json: JsValue): JsResult[PgAggregateRow] = {
      JsResult.fromTry(
        Try(
          PgAggregateRow(
            aggfnoid = json.\("aggfnoid").as[PgAggregateId],
            aggkind = json.\("aggkind").as[String],
            aggnumdirectargs = json.\("aggnumdirectargs").as[Int],
            aggtransfn = json.\("aggtransfn").as[PGobject],
            aggfinalfn = json.\("aggfinalfn").as[PGobject],
            aggcombinefn = json.\("aggcombinefn").as[PGobject],
            aggserialfn = json.\("aggserialfn").as[PGobject],
            aggdeserialfn = json.\("aggdeserialfn").as[PGobject],
            aggmtransfn = json.\("aggmtransfn").as[PGobject],
            aggminvtransfn = json.\("aggminvtransfn").as[PGobject],
            aggmfinalfn = json.\("aggmfinalfn").as[PGobject],
            aggfinalextra = json.\("aggfinalextra").as[Boolean],
            aggmfinalextra = json.\("aggmfinalextra").as[Boolean],
            aggfinalmodify = json.\("aggfinalmodify").as[String],
            aggmfinalmodify = json.\("aggmfinalmodify").as[String],
            aggsortop = json.\("aggsortop").as[Long],
            aggtranstype = json.\("aggtranstype").as[Long],
            aggtransspace = json.\("aggtransspace").as[Int],
            aggmtranstype = json.\("aggmtranstype").as[Long],
            aggmtransspace = json.\("aggmtransspace").as[Int],
            agginitval = json.\("agginitval").toOption.map(_.as[String]),
            aggminitval = json.\("aggminitval").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}