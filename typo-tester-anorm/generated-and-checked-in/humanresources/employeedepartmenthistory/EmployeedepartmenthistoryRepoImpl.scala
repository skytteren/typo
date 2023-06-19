/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeedepartmenthistory

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.time.LocalDateTime

object EmployeedepartmenthistoryRepoImpl extends EmployeedepartmenthistoryRepo {
  override def delete(compositeId: EmployeedepartmenthistoryId)(implicit c: Connection): Boolean = {
    SQL"delete from humanresources.employeedepartmenthistory where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND departmentid = ${compositeId.departmentid} AND shiftid = ${compositeId.shiftid}".executeUpdate() > 0
  }
  override def insert(unsaved: EmployeedepartmenthistoryRow)(implicit c: Connection): EmployeedepartmenthistoryRow = {
    SQL"""insert into humanresources.employeedepartmenthistory(businessentityid, departmentid, shiftid, startdate, enddate, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.departmentid}::int2, ${unsaved.shiftid}::int2, ${unsaved.startdate}::date, ${unsaved.enddate}::date, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, departmentid, shiftid, startdate, enddate, modifieddate
       """
      .executeInsert(EmployeedepartmenthistoryRow.rowParser.single)
  
  }
  override def insert(unsaved: EmployeedepartmenthistoryRowUnsaved)(implicit c: Connection): EmployeedepartmenthistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("departmentid", ParameterValue.from(unsaved.departmentid)), "::int2")),
      Some((NamedParameter("shiftid", ParameterValue.from(unsaved.shiftid)), "::int2")),
      Some((NamedParameter("startdate", ParameterValue.from(unsaved.startdate)), "::date")),
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::date")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into humanresources.employeedepartmenthistory default values
            returning businessentityid, departmentid, shiftid, startdate, enddate, modifieddate
         """
        .executeInsert(EmployeedepartmenthistoryRow.rowParser.single)
    } else {
      val q = s"""insert into humanresources.employeedepartmenthistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, departmentid, shiftid, startdate, enddate, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(EmployeedepartmenthistoryRow.rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[EmployeedepartmenthistoryRow] = {
    SQL"""select businessentityid, departmentid, shiftid, startdate, enddate, modifieddate
          from humanresources.employeedepartmenthistory
       """.as(EmployeedepartmenthistoryRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[EmployeedepartmenthistoryFieldOrIdValue[_]])(implicit c: Connection): List[EmployeedepartmenthistoryRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case EmployeedepartmenthistoryFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case EmployeedepartmenthistoryFieldValue.departmentid(value) => NamedParameter("departmentid", ParameterValue.from(value))
          case EmployeedepartmenthistoryFieldValue.shiftid(value) => NamedParameter("shiftid", ParameterValue.from(value))
          case EmployeedepartmenthistoryFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case EmployeedepartmenthistoryFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case EmployeedepartmenthistoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select businessentityid, departmentid, shiftid, startdate, enddate, modifieddate
                    from humanresources.employeedepartmenthistory
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(EmployeedepartmenthistoryRow.rowParser.*)
    }
  
  }
  override def selectById(compositeId: EmployeedepartmenthistoryId)(implicit c: Connection): Option[EmployeedepartmenthistoryRow] = {
    SQL"""select businessentityid, departmentid, shiftid, startdate, enddate, modifieddate
          from humanresources.employeedepartmenthistory
          where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND departmentid = ${compositeId.departmentid} AND shiftid = ${compositeId.shiftid}
       """.as(EmployeedepartmenthistoryRow.rowParser.singleOpt)
  }
  override def update(row: EmployeedepartmenthistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update humanresources.employeedepartmenthistory
          set enddate = ${row.enddate}::date,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND startdate = ${compositeId.startdate} AND departmentid = ${compositeId.departmentid} AND shiftid = ${compositeId.shiftid}
       """.executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: EmployeedepartmenthistoryId, fieldValues: List[EmployeedepartmenthistoryFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case EmployeedepartmenthistoryFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case EmployeedepartmenthistoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update humanresources.employeedepartmenthistory
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where businessentityid = {businessentityid} AND startdate = {startdate} AND departmentid = {departmentid} AND shiftid = {shiftid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("businessentityid", ParameterValue.from(compositeId.businessentityid)), NamedParameter("startdate", ParameterValue.from(compositeId.startdate)), NamedParameter("departmentid", ParameterValue.from(compositeId.departmentid)), NamedParameter("shiftid", ParameterValue.from(compositeId.shiftid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: EmployeedepartmenthistoryRow)(implicit c: Connection): EmployeedepartmenthistoryRow = {
    SQL"""insert into humanresources.employeedepartmenthistory(businessentityid, departmentid, shiftid, startdate, enddate, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.departmentid}::int2,
            ${unsaved.shiftid}::int2,
            ${unsaved.startdate}::date,
            ${unsaved.enddate}::date,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, startdate, departmentid, shiftid)
          do update set
            enddate = EXCLUDED.enddate,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, departmentid, shiftid, startdate, enddate, modifieddate
       """
      .executeInsert(EmployeedepartmenthistoryRow.rowParser.single)
  
  }
}
