/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vpersondemographics

import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoMoney
import adventureworks.person.businessentity.BusinessentityId
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class VpersondemographicsViewStructure[Row](val prefix: Option[String], val extract: Row => VpersondemographicsViewRow, val merge: (Row, VpersondemographicsViewRow) => Row)
  extends Relation[VpersondemographicsViewFields, VpersondemographicsViewRow, Row]
    with VpersondemographicsViewFields[Row] { outer =>

  override val businessentityid = new OptField[BusinessentityId, Row](prefix, "businessentityid", None, Some("int4"))(x => extract(x).businessentityid, (row, value) => merge(row, extract(row).copy(businessentityid = value)))
  override val totalpurchaseytd = new OptField[TypoMoney, Row](prefix, "totalpurchaseytd", Some("numeric"), Some("money"))(x => extract(x).totalpurchaseytd, (row, value) => merge(row, extract(row).copy(totalpurchaseytd = value)))
  override val datefirstpurchase = new OptField[TypoLocalDate, Row](prefix, "datefirstpurchase", Some("text"), Some("date"))(x => extract(x).datefirstpurchase, (row, value) => merge(row, extract(row).copy(datefirstpurchase = value)))
  override val birthdate = new OptField[TypoLocalDate, Row](prefix, "birthdate", Some("text"), Some("date"))(x => extract(x).birthdate, (row, value) => merge(row, extract(row).copy(birthdate = value)))
  override val maritalstatus = new OptField[/* max 1 chars */ String, Row](prefix, "maritalstatus", None, None)(x => extract(x).maritalstatus, (row, value) => merge(row, extract(row).copy(maritalstatus = value)))
  override val yearlyincome = new OptField[/* max 30 chars */ String, Row](prefix, "yearlyincome", None, None)(x => extract(x).yearlyincome, (row, value) => merge(row, extract(row).copy(yearlyincome = value)))
  override val gender = new OptField[/* max 1 chars */ String, Row](prefix, "gender", None, None)(x => extract(x).gender, (row, value) => merge(row, extract(row).copy(gender = value)))
  override val totalchildren = new OptField[Int, Row](prefix, "totalchildren", None, Some("int4"))(x => extract(x).totalchildren, (row, value) => merge(row, extract(row).copy(totalchildren = value)))
  override val numberchildrenathome = new OptField[Int, Row](prefix, "numberchildrenathome", None, Some("int4"))(x => extract(x).numberchildrenathome, (row, value) => merge(row, extract(row).copy(numberchildrenathome = value)))
  override val education = new OptField[/* max 30 chars */ String, Row](prefix, "education", None, None)(x => extract(x).education, (row, value) => merge(row, extract(row).copy(education = value)))
  override val occupation = new OptField[/* max 30 chars */ String, Row](prefix, "occupation", None, None)(x => extract(x).occupation, (row, value) => merge(row, extract(row).copy(occupation = value)))
  override val homeownerflag = new OptField[Boolean, Row](prefix, "homeownerflag", None, None)(x => extract(x).homeownerflag, (row, value) => merge(row, extract(row).copy(homeownerflag = value)))
  override val numbercarsowned = new OptField[Int, Row](prefix, "numbercarsowned", None, Some("int4"))(x => extract(x).numbercarsowned, (row, value) => merge(row, extract(row).copy(numbercarsowned = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](businessentityid, totalpurchaseytd, datefirstpurchase, birthdate, maritalstatus, yearlyincome, gender, totalchildren, numberchildrenathome, education, occupation, homeownerflag, numbercarsowned)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => VpersondemographicsViewRow, merge: (NewRow, VpersondemographicsViewRow) => NewRow): VpersondemographicsViewStructure[NewRow] =
    new VpersondemographicsViewStructure(prefix, extract, merge)
}