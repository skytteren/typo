package testdb
package pg_catalog



sealed abstract class PgStatsExtFieldValue[T](val name: String, val value: T)

object PgStatsExtFieldValue {
  case class schemaname(override val value: String) extends PgStatsExtFieldValue("schemaname", value)
  case class tablename(override val value: String) extends PgStatsExtFieldValue("tablename", value)
  case class statisticsSchemaname(override val value: String) extends PgStatsExtFieldValue("statistics_schemaname", value)
  case class statisticsName(override val value: String) extends PgStatsExtFieldValue("statistics_name", value)
  case class statisticsOwner(override val value: /* unknown nullability */ Option[String]) extends PgStatsExtFieldValue("statistics_owner", value)
  case class attnames(override val value: /* unknown nullability */ Option[Array[String]]) extends PgStatsExtFieldValue("attnames", value)
  case class exprs(override val value: /* unknown nullability */ Option[Array[String]]) extends PgStatsExtFieldValue("exprs", value)
  case class kinds(override val value: Array[String]) extends PgStatsExtFieldValue("kinds", value)
  case class nDistinct(override val value: Option[/* pg_ndistinct */ String]) extends PgStatsExtFieldValue("n_distinct", value)
  case class dependencies(override val value: Option[/* pg_dependencies */ String]) extends PgStatsExtFieldValue("dependencies", value)
  case class mostCommonVals(override val value: /* unknown nullability */ Option[Array[String]]) extends PgStatsExtFieldValue("most_common_vals", value)
  case class mostCommonValNulls(override val value: /* unknown nullability */ Option[Array[Boolean]]) extends PgStatsExtFieldValue("most_common_val_nulls", value)
  case class mostCommonFreqs(override val value: /* unknown nullability */ Option[Array[Double]]) extends PgStatsExtFieldValue("most_common_freqs", value)
  case class mostCommonBaseFreqs(override val value: /* unknown nullability */ Option[Array[Double]]) extends PgStatsExtFieldValue("most_common_base_freqs", value)
}
