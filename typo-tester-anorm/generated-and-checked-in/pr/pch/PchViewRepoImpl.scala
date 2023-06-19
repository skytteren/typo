/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pch

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object PchViewRepoImpl extends PchViewRepo {
  override def selectAll(implicit c: Connection): List[PchViewRow] = {
    SQL"""select "id", productid, startdate, enddate, standardcost, modifieddate
          from pr.pch
       """.as(PchViewRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PchViewFieldOrIdValue[_]])(implicit c: Connection): List[PchViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PchViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PchViewFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case PchViewFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case PchViewFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case PchViewFieldValue.standardcost(value) => NamedParameter("standardcost", ParameterValue.from(value))
          case PchViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", productid, startdate, enddate, standardcost, modifieddate
                    from pr.pch
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PchViewRow.rowParser.*)
    }
  
  }
}
