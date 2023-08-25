/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidateemployment

import adventureworks.customtypes.TypoLocalDate
import adventureworks.humanresources.jobcandidate.JobcandidateId
import typo.dsl.SqlExpr.FieldLikeNoHkt
import typo.dsl.SqlExpr.OptField
import typo.dsl.Structure.Relation

class VjobcandidateemploymentViewStructure[Row](val prefix: Option[String], val extract: Row => VjobcandidateemploymentViewRow, val merge: (Row, VjobcandidateemploymentViewRow) => Row)
  extends Relation[VjobcandidateemploymentViewFields, VjobcandidateemploymentViewRow, Row]
    with VjobcandidateemploymentViewFields[Row] { outer =>

  override val jobcandidateid = new OptField[JobcandidateId, Row](prefix, "jobcandidateid", None, Some("int4"))(x => extract(x).jobcandidateid, (row, value) => merge(row, extract(row).copy(jobcandidateid = value)))
  override val `Emp.StartDate` = new OptField[TypoLocalDate, Row](prefix, "Emp.StartDate", Some("text"), Some("date"))(x => extract(x).`Emp.StartDate`, (row, value) => merge(row, extract(row).copy(`Emp.StartDate` = value)))
  override val `Emp.EndDate` = new OptField[TypoLocalDate, Row](prefix, "Emp.EndDate", Some("text"), Some("date"))(x => extract(x).`Emp.EndDate`, (row, value) => merge(row, extract(row).copy(`Emp.EndDate` = value)))
  override val `Emp.OrgName` = new OptField[/* max 100 chars */ String, Row](prefix, "Emp.OrgName", None, None)(x => extract(x).`Emp.OrgName`, (row, value) => merge(row, extract(row).copy(`Emp.OrgName` = value)))
  override val `Emp.JobTitle` = new OptField[/* max 100 chars */ String, Row](prefix, "Emp.JobTitle", None, None)(x => extract(x).`Emp.JobTitle`, (row, value) => merge(row, extract(row).copy(`Emp.JobTitle` = value)))
  override val `Emp.Responsibility` = new OptField[String, Row](prefix, "Emp.Responsibility", None, None)(x => extract(x).`Emp.Responsibility`, (row, value) => merge(row, extract(row).copy(`Emp.Responsibility` = value)))
  override val `Emp.FunctionCategory` = new OptField[String, Row](prefix, "Emp.FunctionCategory", None, None)(x => extract(x).`Emp.FunctionCategory`, (row, value) => merge(row, extract(row).copy(`Emp.FunctionCategory` = value)))
  override val `Emp.IndustryCategory` = new OptField[String, Row](prefix, "Emp.IndustryCategory", None, None)(x => extract(x).`Emp.IndustryCategory`, (row, value) => merge(row, extract(row).copy(`Emp.IndustryCategory` = value)))
  override val `Emp.Loc.CountryRegion` = new OptField[String, Row](prefix, "Emp.Loc.CountryRegion", None, None)(x => extract(x).`Emp.Loc.CountryRegion`, (row, value) => merge(row, extract(row).copy(`Emp.Loc.CountryRegion` = value)))
  override val `Emp.Loc.State` = new OptField[String, Row](prefix, "Emp.Loc.State", None, None)(x => extract(x).`Emp.Loc.State`, (row, value) => merge(row, extract(row).copy(`Emp.Loc.State` = value)))
  override val `Emp.Loc.City` = new OptField[String, Row](prefix, "Emp.Loc.City", None, None)(x => extract(x).`Emp.Loc.City`, (row, value) => merge(row, extract(row).copy(`Emp.Loc.City` = value)))

  override val columns: List[FieldLikeNoHkt[?, Row]] =
    List[FieldLikeNoHkt[?, Row]](jobcandidateid, `Emp.StartDate`, `Emp.EndDate`, `Emp.OrgName`, `Emp.JobTitle`, `Emp.Responsibility`, `Emp.FunctionCategory`, `Emp.IndustryCategory`, `Emp.Loc.CountryRegion`, `Emp.Loc.State`, `Emp.Loc.City`)

  override def copy[NewRow](prefix: Option[String], extract: NewRow => VjobcandidateemploymentViewRow, merge: (NewRow, VjobcandidateemploymentViewRow) => NewRow): VjobcandidateemploymentViewStructure[NewRow] =
    new VjobcandidateemploymentViewStructure(prefix, extract, merge)
}