/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package plph

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object PlphViewRepoImpl extends PlphViewRepo {
  override def selectAll(implicit c: Connection): List[PlphViewRow] = {
    SQL"""select "id", productid, startdate, enddate, listprice, modifieddate
          from pr.plph
       """.as(PlphViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[PlphViewFieldOrIdValue[_]])(implicit c: Connection): List[PlphViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PlphViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PlphViewFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case PlphViewFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case PlphViewFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case PlphViewFieldValue.listprice(value) => NamedParameter("listprice", ParameterValue.from(value))
          case PlphViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", productid, startdate, enddate, listprice, modifieddate
                    from pr.plph
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PlphViewRow.rowParser(1).*)
    }
  
  }
}
