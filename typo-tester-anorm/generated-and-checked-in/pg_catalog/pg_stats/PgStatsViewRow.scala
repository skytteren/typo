/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_stats

import adventureworks.TypoAnyArray
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
import scala.util.Try

case class PgStatsViewRow(
  schemaname: Option[String],
  tablename: Option[String],
  attname: Option[String],
  inherited: Option[Boolean],
  nullFrac: Option[Float],
  avgWidth: Option[Int],
  nDistinct: Option[Float],
  mostCommonVals: Option[TypoAnyArray],
  mostCommonFreqs: Option[Array[Float]],
  histogramBounds: Option[TypoAnyArray],
  correlation: Option[Float],
  mostCommonElems: Option[TypoAnyArray],
  mostCommonElemFreqs: Option[Array[Float]],
  elemCountHistogram: Option[Array[Float]]
)

object PgStatsViewRow {
  implicit val reads: Reads[PgStatsViewRow] = Reads[PgStatsViewRow](json => JsResult.fromTry(
      Try(
        PgStatsViewRow(
          schemaname = json.\("schemaname").toOption.map(_.as[String]),
          tablename = json.\("tablename").toOption.map(_.as[String]),
          attname = json.\("attname").toOption.map(_.as[String]),
          inherited = json.\("inherited").toOption.map(_.as[Boolean]),
          nullFrac = json.\("null_frac").toOption.map(_.as[Float]),
          avgWidth = json.\("avg_width").toOption.map(_.as[Int]),
          nDistinct = json.\("n_distinct").toOption.map(_.as[Float]),
          mostCommonVals = json.\("most_common_vals").toOption.map(_.as[TypoAnyArray]),
          mostCommonFreqs = json.\("most_common_freqs").toOption.map(_.as[Array[Float]]),
          histogramBounds = json.\("histogram_bounds").toOption.map(_.as[TypoAnyArray]),
          correlation = json.\("correlation").toOption.map(_.as[Float]),
          mostCommonElems = json.\("most_common_elems").toOption.map(_.as[TypoAnyArray]),
          mostCommonElemFreqs = json.\("most_common_elem_freqs").toOption.map(_.as[Array[Float]]),
          elemCountHistogram = json.\("elem_count_histogram").toOption.map(_.as[Array[Float]])
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[PgStatsViewRow] = RowParser[PgStatsViewRow] { row =>
    Success(
      PgStatsViewRow(
        schemaname = row[Option[String]](idx + 0),
        tablename = row[Option[String]](idx + 1),
        attname = row[Option[String]](idx + 2),
        inherited = row[Option[Boolean]](idx + 3),
        nullFrac = row[Option[Float]](idx + 4),
        avgWidth = row[Option[Int]](idx + 5),
        nDistinct = row[Option[Float]](idx + 6),
        mostCommonVals = row[Option[TypoAnyArray]](idx + 7),
        mostCommonFreqs = row[Option[Array[Float]]](idx + 8),
        histogramBounds = row[Option[TypoAnyArray]](idx + 9),
        correlation = row[Option[Float]](idx + 10),
        mostCommonElems = row[Option[TypoAnyArray]](idx + 11),
        mostCommonElemFreqs = row[Option[Array[Float]]](idx + 12),
        elemCountHistogram = row[Option[Array[Float]]](idx + 13)
      )
    )
  }
  implicit val writes: OWrites[PgStatsViewRow] = OWrites[PgStatsViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "schemaname" -> Json.toJson(o.schemaname),
      "tablename" -> Json.toJson(o.tablename),
      "attname" -> Json.toJson(o.attname),
      "inherited" -> Json.toJson(o.inherited),
      "null_frac" -> Json.toJson(o.nullFrac),
      "avg_width" -> Json.toJson(o.avgWidth),
      "n_distinct" -> Json.toJson(o.nDistinct),
      "most_common_vals" -> Json.toJson(o.mostCommonVals),
      "most_common_freqs" -> Json.toJson(o.mostCommonFreqs),
      "histogram_bounds" -> Json.toJson(o.histogramBounds),
      "correlation" -> Json.toJson(o.correlation),
      "most_common_elems" -> Json.toJson(o.mostCommonElems),
      "most_common_elem_freqs" -> Json.toJson(o.mostCommonElemFreqs),
      "elem_count_histogram" -> Json.toJson(o.elemCountHistogram)
    ))
  )
}
