/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.Defaulted
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object WorkorderroutingRepoImpl extends WorkorderroutingRepo {
  override def delete(compositeId: WorkorderroutingId)(implicit c: Connection): Boolean = {
    SQL"delete from production.workorderrouting where workorderid = ${compositeId.workorderid}, productid = ${compositeId.productid}, operationsequence = ${compositeId.operationsequence}".executeUpdate() > 0
  }
  override def insert(compositeId: WorkorderroutingId, unsaved: WorkorderroutingRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("locationid", ParameterValue.from(unsaved.locationid))),
      Some(NamedParameter("scheduledstartdate", ParameterValue.from(unsaved.scheduledstartdate))),
      Some(NamedParameter("scheduledenddate", ParameterValue.from(unsaved.scheduledenddate))),
      Some(NamedParameter("actualstartdate", ParameterValue.from(unsaved.actualstartdate))),
      Some(NamedParameter("actualenddate", ParameterValue.from(unsaved.actualenddate))),
      Some(NamedParameter("actualresourcehrs", ParameterValue.from(unsaved.actualresourcehrs))),
      Some(NamedParameter("plannedcost", ParameterValue.from(unsaved.plannedcost))),
      Some(NamedParameter("actualcost", ParameterValue.from(unsaved.actualcost))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.workorderrouting(workorderid, productid, operationsequence, ${namedParameters.map(_.name).mkString(", ")})
          values (${compositeId.workorderid}, ${compositeId.productid}, ${compositeId.operationsequence}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
    """
      .on(namedParameters :_*)
      .execute()
  
  }
  override def selectAll(implicit c: Connection): List[WorkorderroutingRow] = {
    SQL"select workorderid, productid, operationsequence, locationid, scheduledstartdate, scheduledenddate, actualstartdate, actualenddate, actualresourcehrs, plannedcost, actualcost, modifieddate from production.workorderrouting".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[WorkorderroutingFieldOrIdValue[_]])(implicit c: Connection): List[WorkorderroutingRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case WorkorderroutingFieldValue.workorderid(value) => NamedParameter("workorderid", ParameterValue.from(value))
          case WorkorderroutingFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case WorkorderroutingFieldValue.operationsequence(value) => NamedParameter("operationsequence", ParameterValue.from(value))
          case WorkorderroutingFieldValue.locationid(value) => NamedParameter("locationid", ParameterValue.from(value))
          case WorkorderroutingFieldValue.scheduledstartdate(value) => NamedParameter("scheduledstartdate", ParameterValue.from(value))
          case WorkorderroutingFieldValue.scheduledenddate(value) => NamedParameter("scheduledenddate", ParameterValue.from(value))
          case WorkorderroutingFieldValue.actualstartdate(value) => NamedParameter("actualstartdate", ParameterValue.from(value))
          case WorkorderroutingFieldValue.actualenddate(value) => NamedParameter("actualenddate", ParameterValue.from(value))
          case WorkorderroutingFieldValue.actualresourcehrs(value) => NamedParameter("actualresourcehrs", ParameterValue.from(value))
          case WorkorderroutingFieldValue.plannedcost(value) => NamedParameter("plannedcost", ParameterValue.from(value))
          case WorkorderroutingFieldValue.actualcost(value) => NamedParameter("actualcost", ParameterValue.from(value))
          case WorkorderroutingFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from production.workorderrouting where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: WorkorderroutingId)(implicit c: Connection): Option[WorkorderroutingRow] = {
    SQL"select workorderid, productid, operationsequence, locationid, scheduledstartdate, scheduledenddate, actualstartdate, actualenddate, actualresourcehrs, plannedcost, actualcost, modifieddate from production.workorderrouting where workorderid = ${compositeId.workorderid}, productid = ${compositeId.productid}, operationsequence = ${compositeId.operationsequence}".as(rowParser.singleOpt)
  }
  override def update(row: WorkorderroutingRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.workorderrouting
          set locationid = ${row.locationid},
              scheduledstartdate = ${row.scheduledstartdate},
              scheduledenddate = ${row.scheduledenddate},
              actualstartdate = ${row.actualstartdate},
              actualenddate = ${row.actualenddate},
              actualresourcehrs = ${row.actualresourcehrs},
              plannedcost = ${row.plannedcost},
              actualcost = ${row.actualcost},
              modifieddate = ${row.modifieddate}
          where workorderid = ${compositeId.workorderid}, productid = ${compositeId.productid}, operationsequence = ${compositeId.operationsequence}""".executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: WorkorderroutingId, fieldValues: List[WorkorderroutingFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case WorkorderroutingFieldValue.locationid(value) => NamedParameter("locationid", ParameterValue.from(value))
          case WorkorderroutingFieldValue.scheduledstartdate(value) => NamedParameter("scheduledstartdate", ParameterValue.from(value))
          case WorkorderroutingFieldValue.scheduledenddate(value) => NamedParameter("scheduledenddate", ParameterValue.from(value))
          case WorkorderroutingFieldValue.actualstartdate(value) => NamedParameter("actualstartdate", ParameterValue.from(value))
          case WorkorderroutingFieldValue.actualenddate(value) => NamedParameter("actualenddate", ParameterValue.from(value))
          case WorkorderroutingFieldValue.actualresourcehrs(value) => NamedParameter("actualresourcehrs", ParameterValue.from(value))
          case WorkorderroutingFieldValue.plannedcost(value) => NamedParameter("plannedcost", ParameterValue.from(value))
          case WorkorderroutingFieldValue.actualcost(value) => NamedParameter("actualcost", ParameterValue.from(value))
          case WorkorderroutingFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.workorderrouting
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where workorderid = ${compositeId.workorderid}, productid = ${compositeId.productid}, operationsequence = ${compositeId.operationsequence}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[WorkorderroutingRow] =
    RowParser[WorkorderroutingRow] { row =>
      Success(
        WorkorderroutingRow(
          workorderid = row[WorkorderId]("workorderid"),
          productid = row[Int]("productid"),
          operationsequence = row[Int]("operationsequence"),
          locationid = row[LocationId]("locationid"),
          scheduledstartdate = row[LocalDateTime]("scheduledstartdate"),
          scheduledenddate = row[LocalDateTime]("scheduledenddate"),
          actualstartdate = row[Option[LocalDateTime]]("actualstartdate"),
          actualenddate = row[Option[LocalDateTime]]("actualenddate"),
          actualresourcehrs = row[Option[BigDecimal]]("actualresourcehrs"),
          plannedcost = row[BigDecimal]("plannedcost"),
          actualcost = row[Option[BigDecimal]]("actualcost"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[WorkorderroutingId] =
    RowParser[WorkorderroutingId] { row =>
      Success(
        WorkorderroutingId(
          workorderid = row[WorkorderId]("workorderid"),
          productid = row[Int]("productid"),
          operationsequence = row[Int]("operationsequence")
        )
      )
    }
}
