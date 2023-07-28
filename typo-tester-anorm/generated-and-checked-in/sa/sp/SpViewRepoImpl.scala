/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sp

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object SpViewRepoImpl extends SpViewRepo {
  override def selectAll(implicit c: Connection): List[SpViewRow] = {
    SQL"""select "id", businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate
          from sa.sp
       """.as(SpViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[SpViewFieldOrIdValue[_]])(implicit c: Connection): List[SpViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SpViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case SpViewFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case SpViewFieldValue.territoryid(value) => NamedParameter("territoryid", ParameterValue.from(value))
          case SpViewFieldValue.salesquota(value) => NamedParameter("salesquota", ParameterValue.from(value))
          case SpViewFieldValue.bonus(value) => NamedParameter("bonus", ParameterValue.from(value))
          case SpViewFieldValue.commissionpct(value) => NamedParameter("commissionpct", ParameterValue.from(value))
          case SpViewFieldValue.salesytd(value) => NamedParameter("salesytd", ParameterValue.from(value))
          case SpViewFieldValue.saleslastyear(value) => NamedParameter("saleslastyear", ParameterValue.from(value))
          case SpViewFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SpViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", businessentityid, territoryid, salesquota, bonus, commissionpct, salesytd, saleslastyear, rowguid, modifieddate
                    from sa.sp
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(SpViewRow.rowParser(1).*)
    }
  
  }
}
