/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmi

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object PmiViewRepoImpl extends PmiViewRepo {
  override def selectAll(implicit c: Connection): List[PmiViewRow] = {
    SQL"""select productmodelid, illustrationid, modifieddate
          from pr.pmi
       """.as(PmiViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[PmiViewFieldOrIdValue[_]])(implicit c: Connection): List[PmiViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PmiViewFieldValue.productmodelid(value) => NamedParameter("productmodelid", ParameterValue.from(value))
          case PmiViewFieldValue.illustrationid(value) => NamedParameter("illustrationid", ParameterValue.from(value))
          case PmiViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select productmodelid, illustrationid, modifieddate
                    from pr.pmi
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PmiViewRow.rowParser(1).*)
    }
  
  }
}