/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package i

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object IViewRepoImpl extends IViewRepo {
  override def selectAll(implicit c: Connection): List[IViewRow] = {
    SQL"""select "id", illustrationid, diagram, modifieddate
          from pr.i
       """.as(IViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[IViewFieldOrIdValue[_]])(implicit c: Connection): List[IViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case IViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case IViewFieldValue.illustrationid(value) => NamedParameter("illustrationid", ParameterValue.from(value))
          case IViewFieldValue.diagram(value) => NamedParameter("diagram", ParameterValue.from(value))
          case IViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", illustrationid, diagram, modifieddate
                    from pr.i
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(IViewRow.rowParser(1).*)
    }
  
  }
}