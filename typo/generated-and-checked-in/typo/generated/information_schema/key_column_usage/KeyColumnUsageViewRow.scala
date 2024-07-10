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
package key_column_usage

import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/**
 *View: information_schema.key_column_usage */
case class KeyColumnUsageViewRow(
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"constraint_catalog","originalName":"constraint_catalog"},"columnName":"constraint_catalog","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  constraintCatalog: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"constraint_schema","originalName":"constraint_schema"},"columnName":"constraint_schema","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  constraintSchema: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"constraint_name","originalName":"constraint_name"},"columnName":"constraint_name","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  constraintName: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"table_catalog","originalName":"table_catalog"},"columnName":"table_catalog","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  tableCatalog: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"table_schema","originalName":"table_schema"},"columnName":"table_schema","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  tableSchema: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"table_name","originalName":"table_name"},"columnName":"table_name","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  tableName: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.String","columnDisplaySize":2147483647,"parsedColumnName":{"name":"column_name","originalName":"column_name"},"columnName":"column_name","columnType":"VarChar","columnTypeName":"name","format":0,"isAutoIncrement":false,"isCaseSensitive":true,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":false,"isWritable":true,"precision":2147483647,"scale":0} */
  columnName: /* nullability unknown */ Option[String],
  /** debug: {"columnClassName":"java.lang.Integer","columnDisplaySize":11,"parsedColumnName":{"name":"ordinal_position","originalName":"ordinal_position"},"columnName":"ordinal_position","columnType":"Integer","columnTypeName":"int4","format":0,"isAutoIncrement":false,"isCaseSensitive":false,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":true,"isWritable":true,"precision":10,"scale":0} */
  ordinalPosition: /* nullability unknown */ Option[Int],
  /** debug: {"columnClassName":"java.lang.Integer","columnDisplaySize":11,"parsedColumnName":{"name":"position_in_unique_constraint","originalName":"position_in_unique_constraint"},"columnName":"position_in_unique_constraint","columnType":"Integer","columnTypeName":"int4","format":0,"isAutoIncrement":false,"isCaseSensitive":false,"isCurrency":false,"isDefinitelyWritable":false,"isNullable":"NullableUnknown","isReadOnly":false,"isSearchable":true,"isSigned":true,"isWritable":true,"precision":10,"scale":0} */
  positionInUniqueConstraint: /* nullability unknown */ Option[Int]
)

object KeyColumnUsageViewRow {
  implicit lazy val reads: Reads[KeyColumnUsageViewRow] = Reads[KeyColumnUsageViewRow](json => JsResult.fromTry(
      Try(
        KeyColumnUsageViewRow(
          constraintCatalog = json.\("constraint_catalog").toOption.map(_.as(Reads.StringReads)),
          constraintSchema = json.\("constraint_schema").toOption.map(_.as(Reads.StringReads)),
          constraintName = json.\("constraint_name").toOption.map(_.as(Reads.StringReads)),
          tableCatalog = json.\("table_catalog").toOption.map(_.as(Reads.StringReads)),
          tableSchema = json.\("table_schema").toOption.map(_.as(Reads.StringReads)),
          tableName = json.\("table_name").toOption.map(_.as(Reads.StringReads)),
          columnName = json.\("column_name").toOption.map(_.as(Reads.StringReads)),
          ordinalPosition = json.\("ordinal_position").toOption.map(_.as(Reads.IntReads)),
          positionInUniqueConstraint = json.\("position_in_unique_constraint").toOption.map(_.as(Reads.IntReads))
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[KeyColumnUsageViewRow] = RowParser[KeyColumnUsageViewRow] { row =>
    Success(
      KeyColumnUsageViewRow(
        constraintCatalog = row(idx + 0)(Column.columnToOption(Column.columnToString)),
        constraintSchema = row(idx + 1)(Column.columnToOption(Column.columnToString)),
        constraintName = row(idx + 2)(Column.columnToOption(Column.columnToString)),
        tableCatalog = row(idx + 3)(Column.columnToOption(Column.columnToString)),
        tableSchema = row(idx + 4)(Column.columnToOption(Column.columnToString)),
        tableName = row(idx + 5)(Column.columnToOption(Column.columnToString)),
        columnName = row(idx + 6)(Column.columnToOption(Column.columnToString)),
        ordinalPosition = row(idx + 7)(Column.columnToOption(Column.columnToInt)),
        positionInUniqueConstraint = row(idx + 8)(Column.columnToOption(Column.columnToInt))
      )
    )
  }
  implicit lazy val writes: OWrites[KeyColumnUsageViewRow] = OWrites[KeyColumnUsageViewRow](o =>
    new JsObject(ListMap[String, JsValue](
      "constraint_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintCatalog),
      "constraint_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintSchema),
      "constraint_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.constraintName),
      "table_catalog" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableCatalog),
      "table_schema" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableSchema),
      "table_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.tableName),
      "column_name" -> Writes.OptionWrites(Writes.StringWrites).writes(o.columnName),
      "ordinal_position" -> Writes.OptionWrites(Writes.IntWrites).writes(o.ordinalPosition),
      "position_in_unique_constraint" -> Writes.OptionWrites(Writes.IntWrites).writes(o.positionInUniqueConstraint)
    ))
  )
}
