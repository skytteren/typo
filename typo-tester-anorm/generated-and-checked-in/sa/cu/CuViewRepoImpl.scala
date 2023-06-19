/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cu

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object CuViewRepoImpl extends CuViewRepo {
  override def selectAll(implicit c: Connection): List[CuViewRow] = {
    SQL"""select "id", currencycode, "name", modifieddate
          from sa.cu
       """.as(CuViewRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CuViewFieldOrIdValue[_]])(implicit c: Connection): List[CuViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CuViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case CuViewFieldValue.currencycode(value) => NamedParameter("currencycode", ParameterValue.from(value))
          case CuViewFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case CuViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", currencycode, "name", modifieddate
                    from sa.cu
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(CuViewRow.rowParser.*)
    }
  
  }
}
