package testdb
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgStatsExtRow(
  /** Points to [[testdb.pg_catalog.PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[testdb.pg_catalog.PgClassRow.relname]] */
  tablename: String,
  /** Points to [[testdb.pg_catalog.PgNamespaceRow.nspname]] */
  statisticsSchemaname: String,
  /** Points to [[testdb.pg_catalog.PgStatisticExtRow.stxname]] */
  statisticsName: String,
  statisticsOwner: /* unknown nullability */ Option[String],
  attnames: /* unknown nullability */ Option[Array[String]],
  exprs: /* unknown nullability */ Option[Array[String]],
  /** Points to [[testdb.pg_catalog.PgStatisticExtRow.stxkind]] */
  kinds: Array[String],
  /** Points to [[testdb.pg_catalog.PgStatisticExtDataRow.stxdndistinct]] */
  nDistinct: Option[/* pg_ndistinct */ String],
  /** Points to [[testdb.pg_catalog.PgStatisticExtDataRow.stxddependencies]] */
  dependencies: Option[/* pg_dependencies */ String],
  mostCommonVals: /* unknown nullability */ Option[Array[String]],
  mostCommonValNulls: /* unknown nullability */ Option[Array[Boolean]],
  mostCommonFreqs: /* unknown nullability */ Option[Array[Double]],
  mostCommonBaseFreqs: /* unknown nullability */ Option[Array[Double]]
)

object PgStatsExtRow {
  implicit val rowParser: RowParser[PgStatsExtRow] = { row =>
    Success(
      PgStatsExtRow(
        schemaname = row[String]("schemaname"),
        tablename = row[String]("tablename"),
        statisticsSchemaname = row[String]("statistics_schemaname"),
        statisticsName = row[String]("statistics_name"),
        statisticsOwner = row[/* unknown nullability */ Option[String]]("statistics_owner"),
        attnames = row[/* unknown nullability */ Option[Array[String]]]("attnames"),
        exprs = row[/* unknown nullability */ Option[Array[String]]]("exprs"),
        kinds = row[Array[String]]("kinds"),
        nDistinct = row[Option[/* pg_ndistinct */ String]]("n_distinct"),
        dependencies = row[Option[/* pg_dependencies */ String]]("dependencies"),
        mostCommonVals = row[/* unknown nullability */ Option[Array[String]]]("most_common_vals"),
        mostCommonValNulls = row[/* unknown nullability */ Option[Array[Boolean]]]("most_common_val_nulls"),
        mostCommonFreqs = row[/* unknown nullability */ Option[Array[Double]]]("most_common_freqs"),
        mostCommonBaseFreqs = row[/* unknown nullability */ Option[Array[Double]]]("most_common_base_freqs")
      )
    )
  }

  implicit val oFormat: OFormat[PgStatsExtRow] = new OFormat[PgStatsExtRow]{
    override def writes(o: PgStatsExtRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
      "tablename" -> o.tablename,
      "statistics_schemaname" -> o.statisticsSchemaname,
      "statistics_name" -> o.statisticsName,
      "statistics_owner" -> o.statisticsOwner,
      "attnames" -> o.attnames,
      "exprs" -> o.exprs,
      "kinds" -> o.kinds,
      "n_distinct" -> o.nDistinct,
      "dependencies" -> o.dependencies,
      "most_common_vals" -> o.mostCommonVals,
      "most_common_val_nulls" -> o.mostCommonValNulls,
      "most_common_freqs" -> o.mostCommonFreqs,
      "most_common_base_freqs" -> o.mostCommonBaseFreqs
      )

    override def reads(json: JsValue): JsResult[PgStatsExtRow] = {
      JsResult.fromTry(
        Try(
          PgStatsExtRow(
            schemaname = json.\("schemaname").as[String],
            tablename = json.\("tablename").as[String],
            statisticsSchemaname = json.\("statistics_schemaname").as[String],
            statisticsName = json.\("statistics_name").as[String],
            statisticsOwner = json.\("statistics_owner").toOption.map(_.as[String]),
            attnames = json.\("attnames").toOption.map(_.as[Array[String]]),
            exprs = json.\("exprs").toOption.map(_.as[Array[String]]),
            kinds = json.\("kinds").as[Array[String]],
            nDistinct = json.\("n_distinct").toOption.map(_.as[/* pg_ndistinct */ String]),
            dependencies = json.\("dependencies").toOption.map(_.as[/* pg_dependencies */ String]),
            mostCommonVals = json.\("most_common_vals").toOption.map(_.as[Array[String]]),
            mostCommonValNulls = json.\("most_common_val_nulls").toOption.map(_.as[Array[Boolean]]),
            mostCommonFreqs = json.\("most_common_freqs").toOption.map(_.as[Array[Double]]),
            mostCommonBaseFreqs = json.\("most_common_base_freqs").toOption.map(_.as[Array[Double]])
          )
        )
      )
    }
  }
}
