/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package bom

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object BomViewRepoImpl extends BomViewRepo {
  override def selectAll(implicit c: Connection): List[BomViewRow] = {
    SQL"""select "id", billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
          from pr."bom"
       """.as(BomViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[BomViewFieldOrIdValue[_]])(implicit c: Connection): List[BomViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case BomViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case BomViewFieldValue.billofmaterialsid(value) => NamedParameter("billofmaterialsid", ParameterValue.from(value))
          case BomViewFieldValue.productassemblyid(value) => NamedParameter("productassemblyid", ParameterValue.from(value))
          case BomViewFieldValue.componentid(value) => NamedParameter("componentid", ParameterValue.from(value))
          case BomViewFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case BomViewFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case BomViewFieldValue.unitmeasurecode(value) => NamedParameter("unitmeasurecode", ParameterValue.from(value))
          case BomViewFieldValue.bomlevel(value) => NamedParameter("bomlevel", ParameterValue.from(value))
          case BomViewFieldValue.perassemblyqty(value) => NamedParameter("perassemblyqty", ParameterValue.from(value))
          case BomViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
                    from pr."bom"
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(BomViewRow.rowParser(1).*)
    }
  
  }
}