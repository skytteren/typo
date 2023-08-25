/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pnt

import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Name
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class PntViewStructure[Row](val prefix: Option[String], val extract: Row => PntViewRow, val merge: (Row, PntViewRow) => Row)
  extends Relation[PntViewFields, PntViewRow, Row]
    with PntViewFields[Row] { outer =>

  override val id = new OptField[Int, Row](prefix, "id", None, Some("int4"))(x => extract(x).id, (row, value) => merge(row, extract(row).copy(id = value)))
  override val phonenumbertypeid = new OptField[PhonenumbertypeId, Row](prefix, "phonenumbertypeid", None, Some("int4"))(x => extract(x).phonenumbertypeid, (row, value) => merge(row, extract(row).copy(phonenumbertypeid = value)))
  override val name = new OptField[Name, Row](prefix, "name", None, Some(""""public"."Name""""))(x => extract(x).name, (row, value) => merge(row, extract(row).copy(name = value)))
  override val modifieddate = new OptField[TypoLocalDateTime, Row](prefix, "modifieddate", Some("text"), Some("timestamp"))(x => extract(x).modifieddate, (row, value) => merge(row, extract(row).copy(modifieddate = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](id, phonenumbertypeid, name, modifieddate)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => PntViewRow, merge: (NewRow, PntViewRow) => NewRow): PntViewStructure[NewRow] =
    new PntViewStructure(prefix, extract, merge)
}