/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package c

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object CViewRepoImpl extends CViewRepo {
  override def selectAll(implicit c: Connection): List[CViewRow] = {
    SQL"""select "id", cultureid, "name", modifieddate
          from pr."c"
       """.as(CViewRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CViewFieldOrIdValue[_]])(implicit c: Connection): List[CViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case CViewFieldValue.cultureid(value) => NamedParameter("cultureid", ParameterValue.from(value))
          case CViewFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case CViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", cultureid, "name", modifieddate
                    from pr."c"
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(CViewRow.rowParser.*)
    }
  
  }
}
