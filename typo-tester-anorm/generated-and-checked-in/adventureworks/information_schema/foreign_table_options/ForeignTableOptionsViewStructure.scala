/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_table_options

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class ForeignTableOptionsViewStructure[Row](val prefix: Option[String], val extract: Row => ForeignTableOptionsViewRow, val merge: (Row, ForeignTableOptionsViewRow) => Row)
  extends Relation[ForeignTableOptionsViewFields, ForeignTableOptionsViewRow, Row]
    with ForeignTableOptionsViewFields[Row] { outer =>

  override val foreignTableCatalog = new OptField[SqlIdentifier, Row](prefix, "foreign_table_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).foreignTableCatalog, (row, value) => merge(row, extract(row).copy(foreignTableCatalog = value)))
  override val foreignTableSchema = new OptField[SqlIdentifier, Row](prefix, "foreign_table_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).foreignTableSchema, (row, value) => merge(row, extract(row).copy(foreignTableSchema = value)))
  override val foreignTableName = new OptField[SqlIdentifier, Row](prefix, "foreign_table_name", None, Some("information_schema.sql_identifier"))(x => extract(x).foreignTableName, (row, value) => merge(row, extract(row).copy(foreignTableName = value)))
  override val optionName = new OptField[SqlIdentifier, Row](prefix, "option_name", None, Some("information_schema.sql_identifier"))(x => extract(x).optionName, (row, value) => merge(row, extract(row).copy(optionName = value)))
  override val optionValue = new OptField[CharacterData, Row](prefix, "option_value", None, Some("information_schema.character_data"))(x => extract(x).optionValue, (row, value) => merge(row, extract(row).copy(optionValue = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](foreignTableCatalog, foreignTableSchema, foreignTableName, optionName, optionValue)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ForeignTableOptionsViewRow, merge: (NewRow, ForeignTableOptionsViewRow) => NewRow): ForeignTableOptionsViewStructure[NewRow] =
    new ForeignTableOptionsViewStructure(prefix, extract, merge)
}