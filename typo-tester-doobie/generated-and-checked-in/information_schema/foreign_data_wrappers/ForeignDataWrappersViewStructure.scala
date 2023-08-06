/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_data_wrappers

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class ForeignDataWrappersViewStructure[Row](val prefix: Option[String], val extract: Row => ForeignDataWrappersViewRow, val merge: (Row, ForeignDataWrappersViewRow) => Row)
  extends Relation[ForeignDataWrappersViewFields, ForeignDataWrappersViewRow, Row]
    with ForeignDataWrappersViewFields[Row] { outer =>

  override val foreignDataWrapperCatalog = new OptField[SqlIdentifier, Row](prefix, "foreign_data_wrapper_catalog", None, Some("information_schema.sql_identifier"))(x => extract(x).foreignDataWrapperCatalog, (row, value) => merge(row, extract(row).copy(foreignDataWrapperCatalog = value)))
  override val foreignDataWrapperName = new OptField[SqlIdentifier, Row](prefix, "foreign_data_wrapper_name", None, Some("information_schema.sql_identifier"))(x => extract(x).foreignDataWrapperName, (row, value) => merge(row, extract(row).copy(foreignDataWrapperName = value)))
  override val authorizationIdentifier = new OptField[SqlIdentifier, Row](prefix, "authorization_identifier", None, Some("information_schema.sql_identifier"))(x => extract(x).authorizationIdentifier, (row, value) => merge(row, extract(row).copy(authorizationIdentifier = value)))
  override val libraryName = new OptField[CharacterData, Row](prefix, "library_name", None, Some("information_schema.character_data"))(x => extract(x).libraryName, (row, value) => merge(row, extract(row).copy(libraryName = value)))
  override val foreignDataWrapperLanguage = new OptField[CharacterData, Row](prefix, "foreign_data_wrapper_language", None, Some("information_schema.character_data"))(x => extract(x).foreignDataWrapperLanguage, (row, value) => merge(row, extract(row).copy(foreignDataWrapperLanguage = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](foreignDataWrapperCatalog, foreignDataWrapperName, authorizationIdentifier, libraryName, foreignDataWrapperLanguage)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => ForeignDataWrappersViewRow, merge: (NewRow, ForeignDataWrappersViewRow) => NewRow): ForeignDataWrappersViewStructure[NewRow] =
    new ForeignDataWrappersViewStructure(prefix, extract, merge)
}