/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package jc

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object JcViewRepoImpl extends JcViewRepo {
  override def selectAll(implicit c: Connection): List[JcViewRow] = {
    SQL"""select "id", jobcandidateid, businessentityid, resume, modifieddate
          from hr.jc
       """.as(JcViewRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[JcViewFieldOrIdValue[_]])(implicit c: Connection): List[JcViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case JcViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case JcViewFieldValue.jobcandidateid(value) => NamedParameter("jobcandidateid", ParameterValue.from(value))
          case JcViewFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case JcViewFieldValue.resume(value) => NamedParameter("resume", ParameterValue.from(value))
          case JcViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", jobcandidateid, businessentityid, resume, modifieddate
                    from hr.jc
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(JcViewRow.rowParser.*)
    }
  
  }
}
