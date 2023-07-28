/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pnt

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object PntViewRepoImpl extends PntViewRepo {
  override def selectAll(implicit c: Connection): List[PntViewRow] = {
    SQL"""select "id", phonenumbertypeid, "name", modifieddate
          from pe.pnt
       """.as(PntViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[PntViewFieldOrIdValue[_]])(implicit c: Connection): List[PntViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PntViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PntViewFieldValue.phonenumbertypeid(value) => NamedParameter("phonenumbertypeid", ParameterValue.from(value))
          case PntViewFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case PntViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", phonenumbertypeid, "name", modifieddate
                    from pe.pnt
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PntViewRow.rowParser(1).*)
    }
  
  }
}