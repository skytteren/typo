/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cc

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object CcViewRepoImpl extends CcViewRepo {
  override def selectAll(implicit c: Connection): List[CcViewRow] = {
    SQL"""select "id", creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate
          from sa.cc
       """.as(CcViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[CcViewFieldOrIdValue[_]])(implicit c: Connection): List[CcViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CcViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case CcViewFieldValue.creditcardid(value) => NamedParameter("creditcardid", ParameterValue.from(value))
          case CcViewFieldValue.cardtype(value) => NamedParameter("cardtype", ParameterValue.from(value))
          case CcViewFieldValue.cardnumber(value) => NamedParameter("cardnumber", ParameterValue.from(value))
          case CcViewFieldValue.expmonth(value) => NamedParameter("expmonth", ParameterValue.from(value))
          case CcViewFieldValue.expyear(value) => NamedParameter("expyear", ParameterValue.from(value))
          case CcViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", creditcardid, cardtype, cardnumber, expmonth, expyear, modifieddate
                    from sa.cc
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(CcViewRow.rowParser(1).*)
    }
  
  }
}