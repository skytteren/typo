/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package ct

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object CtViewRepoImpl extends CtViewRepo {
  override def selectAll(implicit c: Connection): List[CtViewRow] = {
    SQL"""select "id", contacttypeid, "name", modifieddate
          from pe.ct
       """.as(CtViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[CtViewFieldOrIdValue[_]])(implicit c: Connection): List[CtViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CtViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case CtViewFieldValue.contacttypeid(value) => NamedParameter("contacttypeid", ParameterValue.from(value))
          case CtViewFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case CtViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", contacttypeid, "name", modifieddate
                    from pe.ct
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(CtViewRow.rowParser(1).*)
    }
  
  }
}
