/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package character_sets

import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class CharacterSetsViewStructure[Row](val prefix: Option[String], val extract: Row => CharacterSetsViewRow, val merge: (Row, CharacterSetsViewRow) => Row)
  extends Relation[CharacterSetsViewFields, CharacterSetsViewRow, Row]
    with CharacterSetsViewFields[Row] { outer =>

  override val characterSetCatalog = new OptField[SqlIdentifier, Row](prefix, "character_set_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).characterSetCatalog, (row, value) => merge(row, extract(row).copy(characterSetCatalog = value)))
  override val characterSetSchema = new OptField[SqlIdentifier, Row](prefix, "character_set_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).characterSetSchema, (row, value) => merge(row, extract(row).copy(characterSetSchema = value)))
  override val characterSetName = new OptField[SqlIdentifier, Row](prefix, "character_set_name", None, Some("information_schema.sql_identifier"))(x => extract(x).characterSetName, (row, value) => merge(row, extract(row).copy(characterSetName = value)))
  override val characterRepertoire = new OptField[SqlIdentifier, Row](prefix, "character_repertoire", None, Some("information_schema.sql_identifier"))(x => extract(x).characterRepertoire, (row, value) => merge(row, extract(row).copy(characterRepertoire = value)))
  override val formOfUse = new OptField[SqlIdentifier, Row](prefix, "form_of_use", None, Some("information_schema.sql_identifier"))(x => extract(x).formOfUse, (row, value) => merge(row, extract(row).copy(formOfUse = value)))
  override val defaultCollateCatalog = new OptField[SqlIdentifier, Row](prefix, "default_collate_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).defaultCollateCatalog, (row, value) => merge(row, extract(row).copy(defaultCollateCatalog = value)))
  override val defaultCollateSchema = new OptField[SqlIdentifier, Row](prefix, "default_collate_schema", None, Some("information_schema.sql_identifier"))(x => extract(x).defaultCollateSchema, (row, value) => merge(row, extract(row).copy(defaultCollateSchema = value)))
  override val defaultCollateName = new OptField[SqlIdentifier, Row](prefix, "default_collate_name", None, Some("information_schema.sql_identifier"))(x => extract(x).defaultCollateName, (row, value) => merge(row, extract(row).copy(defaultCollateName = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](characterSetCatalog, characterSetSchema, characterSetName, characterRepertoire, formOfUse, defaultCollateCatalog, defaultCollateSchema, defaultCollateName)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => CharacterSetsViewRow, merge: (NewRow, CharacterSetsViewRow) => NewRow): CharacterSetsViewStructure[NewRow] =
    new CharacterSetsViewStructure(prefix, extract, merge)
}