/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package c

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object CViewRepoImpl extends CViewRepo {
  override def selectAll(implicit c: Connection): List[CViewRow] = {
    SQL"""select "id", customerid, personid, storeid, territoryid, rowguid, modifieddate
          from sa."c"
       """.as(CViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[CViewFieldOrIdValue[_]])(implicit c: Connection): List[CViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case CViewFieldValue.customerid(value) => NamedParameter("customerid", ParameterValue.from(value))
          case CViewFieldValue.personid(value) => NamedParameter("personid", ParameterValue.from(value))
          case CViewFieldValue.storeid(value) => NamedParameter("storeid", ParameterValue.from(value))
          case CViewFieldValue.territoryid(value) => NamedParameter("territoryid", ParameterValue.from(value))
          case CViewFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case CViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", customerid, personid, storeid, territoryid, rowguid, modifieddate
                    from sa."c"
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(CViewRow.rowParser(1).*)
    }
  
  }
}