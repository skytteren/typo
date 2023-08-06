/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_user

import adventureworks.TypoOffsetDateTime
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PgUserViewStructure[Row](val prefix: Option[String], val extract: Row => PgUserViewRow, val merge: (Row, PgUserViewRow) => Row)
  extends Relation[PgUserViewFields, PgUserViewRow, Row]
    with PgUserViewFields[Row] { outer =>

  override val usename = new OptField[String, Row](prefix, "usename", None, Some("name"))(x => extract(x).usename, (row, value) => merge(row, extract(row).copy(usename = value)))
  override val usesysid = new OptField[/* oid */ Long, Row](prefix, "usesysid", None, Some("oid"))(x => extract(x).usesysid, (row, value) => merge(row, extract(row).copy(usesysid = value)))
  override val usecreatedb = new OptField[Boolean, Row](prefix, "usecreatedb", None, None)(x => extract(x).usecreatedb, (row, value) => merge(row, extract(row).copy(usecreatedb = value)))
  override val usesuper = new OptField[Boolean, Row](prefix, "usesuper", None, None)(x => extract(x).usesuper, (row, value) => merge(row, extract(row).copy(usesuper = value)))
  override val userepl = new OptField[Boolean, Row](prefix, "userepl", None, None)(x => extract(x).userepl, (row, value) => merge(row, extract(row).copy(userepl = value)))
  override val usebypassrls = new OptField[Boolean, Row](prefix, "usebypassrls", None, None)(x => extract(x).usebypassrls, (row, value) => merge(row, extract(row).copy(usebypassrls = value)))
  override val passwd = new OptField[String, Row](prefix, "passwd", None, None)(x => extract(x).passwd, (row, value) => merge(row, extract(row).copy(passwd = value)))
  override val valuntil = new OptField[TypoOffsetDateTime, Row](prefix, "valuntil", Some("text"), Some("timestamptz"))(x => extract(x).valuntil, (row, value) => merge(row, extract(row).copy(valuntil = value)))
  override val useconfig = new OptField[Array[String], Row](prefix, "useconfig", None, Some("_text"))(x => extract(x).useconfig, (row, value) => merge(row, extract(row).copy(useconfig = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](usename, usesysid, usecreatedb, usesuper, userepl, usebypassrls, passwd, valuntil, useconfig)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PgUserViewRow, merge: (NewRow, PgUserViewRow) => NewRow): PgUserViewStructure[NewRow] =
    new PgUserViewStructure(prefix, extract, merge)
}