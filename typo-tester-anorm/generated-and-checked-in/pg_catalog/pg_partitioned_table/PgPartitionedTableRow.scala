/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_partitioned_table

import adventureworks.TypoInt2Vector
import adventureworks.TypoOidVector
import adventureworks.TypoPgNodeTree
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgPartitionedTableRow(
  partrelid: PgPartitionedTableId,
  partstrat: String,
  partnatts: Int,
  partdefid: /* oid */ Long,
  partattrs: TypoInt2Vector,
  partclass: TypoOidVector,
  partcollation: TypoOidVector,
  partexprs: Option[TypoPgNodeTree]
)

object PgPartitionedTableRow {
  def rowParser(idx: Int): RowParser[PgPartitionedTableRow] =
    RowParser[PgPartitionedTableRow] { row =>
      Success(
        PgPartitionedTableRow(
          partrelid = row[PgPartitionedTableId](idx + 0),
          partstrat = row[String](idx + 1),
          partnatts = row[Int](idx + 2),
          partdefid = row[/* oid */ Long](idx + 3),
          partattrs = row[TypoInt2Vector](idx + 4),
          partclass = row[TypoOidVector](idx + 5),
          partcollation = row[TypoOidVector](idx + 6),
          partexprs = row[Option[TypoPgNodeTree]](idx + 7)
        )
      )
    }
  implicit val oFormat: OFormat[PgPartitionedTableRow] = new OFormat[PgPartitionedTableRow]{
    override def writes(o: PgPartitionedTableRow): JsObject =
      Json.obj(
        "partrelid" -> o.partrelid,
        "partstrat" -> o.partstrat,
        "partnatts" -> o.partnatts,
        "partdefid" -> o.partdefid,
        "partattrs" -> o.partattrs,
        "partclass" -> o.partclass,
        "partcollation" -> o.partcollation,
        "partexprs" -> o.partexprs
      )
  
    override def reads(json: JsValue): JsResult[PgPartitionedTableRow] = {
      JsResult.fromTry(
        Try(
          PgPartitionedTableRow(
            partrelid = json.\("partrelid").as[PgPartitionedTableId],
            partstrat = json.\("partstrat").as[String],
            partnatts = json.\("partnatts").as[Int],
            partdefid = json.\("partdefid").as[/* oid */ Long],
            partattrs = json.\("partattrs").as[TypoInt2Vector],
            partclass = json.\("partclass").as[TypoOidVector],
            partcollation = json.\("partcollation").as[TypoOidVector],
            partexprs = json.\("partexprs").toOption.map(_.as[TypoPgNodeTree])
          )
        )
      )
    }
  }
}