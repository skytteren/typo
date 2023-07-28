/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package a

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object AViewRepoImpl extends AViewRepo {
  override def selectAll(implicit c: Connection): List[AViewRow] = {
    SQL"""select "id", addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
          from pe."a"
       """.as(AViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[AViewFieldOrIdValue[_]])(implicit c: Connection): List[AViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case AViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case AViewFieldValue.addressid(value) => NamedParameter("addressid", ParameterValue.from(value))
          case AViewFieldValue.addressline1(value) => NamedParameter("addressline1", ParameterValue.from(value))
          case AViewFieldValue.addressline2(value) => NamedParameter("addressline2", ParameterValue.from(value))
          case AViewFieldValue.city(value) => NamedParameter("city", ParameterValue.from(value))
          case AViewFieldValue.stateprovinceid(value) => NamedParameter("stateprovinceid", ParameterValue.from(value))
          case AViewFieldValue.postalcode(value) => NamedParameter("postalcode", ParameterValue.from(value))
          case AViewFieldValue.spatiallocation(value) => NamedParameter("spatiallocation", ParameterValue.from(value))
          case AViewFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case AViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
                    from pe."a"
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(AViewRow.rowParser(1).*)
    }
  
  }
}
