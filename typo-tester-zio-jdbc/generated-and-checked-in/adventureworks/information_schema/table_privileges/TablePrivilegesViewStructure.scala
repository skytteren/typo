/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package table_privileges

import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class TablePrivilegesViewStructure[Row](val prefix: Option[String], val extract: Row => TablePrivilegesViewRow, val merge: (Row, TablePrivilegesViewRow) => Row)
  extends Relation[TablePrivilegesViewFields, TablePrivilegesViewRow, Row]
    with TablePrivilegesViewFields[Row] { outer =>

  override val grantor = new OptField[String, Row](prefix, "grantor", None, None)(x => extract(x).grantor, (row, value) => merge(row, extract(row).copy(grantor = value)))
  override val grantee = new OptField[String, Row](prefix, "grantee", None, None)(x => extract(x).grantee, (row, value) => merge(row, extract(row).copy(grantee = value)))
  override val tableCatalog = new OptField[String, Row](prefix, "table_catalog", None, None)(x => extract(x).tableCatalog, (row, value) => merge(row, extract(row).copy(tableCatalog = value)))
  override val tableSchema = new OptField[String, Row](prefix, "table_schema", None, None)(x => extract(x).tableSchema, (row, value) => merge(row, extract(row).copy(tableSchema = value)))
  override val tableName = new OptField[String, Row](prefix, "table_name", None, None)(x => extract(x).tableName, (row, value) => merge(row, extract(row).copy(tableName = value)))
  override val privilegeType = new OptField[String, Row](prefix, "privilege_type", None, None)(x => extract(x).privilegeType, (row, value) => merge(row, extract(row).copy(privilegeType = value)))
  override val isGrantable = new OptField[/* max 3 chars */ String, Row](prefix, "is_grantable", None, None)(x => extract(x).isGrantable, (row, value) => merge(row, extract(row).copy(isGrantable = value)))
  override val withHierarchy = new OptField[/* max 3 chars */ String, Row](prefix, "with_hierarchy", None, None)(x => extract(x).withHierarchy, (row, value) => merge(row, extract(row).copy(withHierarchy = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](grantor, grantee, tableCatalog, tableSchema, tableName, privilegeType, isGrantable, withHierarchy)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => TablePrivilegesViewRow, merge: (NewRow, TablePrivilegesViewRow) => NewRow): TablePrivilegesViewStructure[NewRow] =
    new TablePrivilegesViewStructure(prefix, extract, merge)
}