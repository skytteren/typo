/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sql_implementation_info

import adventureworks.information_schema.CardinalNumber
import adventureworks.information_schema.CharacterData
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class SqlImplementationInfoStructure[Row](val prefix: Option[String], val extract: Row => SqlImplementationInfoRow, val merge: (Row, SqlImplementationInfoRow) => Row)
  extends Relation[SqlImplementationInfoFields, SqlImplementationInfoRow, Row]
    with SqlImplementationInfoFields[Row] { outer =>

  override val implementationInfoId = new OptField[CharacterData, Row](prefix, "implementation_info_id", None, Some("varchar"))(x => extract(x).implementationInfoId, (row, value) => merge(row, extract(row).copy(implementationInfoId = value)))
  override val implementationInfoName = new OptField[CharacterData, Row](prefix, "implementation_info_name", None, Some("varchar"))(x => extract(x).implementationInfoName, (row, value) => merge(row, extract(row).copy(implementationInfoName = value)))
  override val integerValue = new OptField[CardinalNumber, Row](prefix, "integer_value", None, Some("int4"))(x => extract(x).integerValue, (row, value) => merge(row, extract(row).copy(integerValue = value)))
  override val characterValue = new OptField[CharacterData, Row](prefix, "character_value", None, Some("varchar"))(x => extract(x).characterValue, (row, value) => merge(row, extract(row).copy(characterValue = value)))
  override val comments = new OptField[CharacterData, Row](prefix, "comments", None, Some("varchar"))(x => extract(x).comments, (row, value) => merge(row, extract(row).copy(comments = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](implementationInfoId, implementationInfoName, integerValue, characterValue, comments)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => SqlImplementationInfoRow, merge: (NewRow, SqlImplementationInfoRow) => NewRow): SqlImplementationInfoStructure[NewRow] =
    new SqlImplementationInfoStructure(prefix, extract, merge)
}