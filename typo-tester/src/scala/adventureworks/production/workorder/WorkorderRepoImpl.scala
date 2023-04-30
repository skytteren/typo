/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import adventureworks.production.scrapreason.ScrapreasonId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object WorkorderRepoImpl extends WorkorderRepo {
  override def delete(workorderid: WorkorderId)(implicit c: Connection): Boolean = {
    SQL"delete from production.workorder where workorderid = $workorderid".executeUpdate() > 0
  }
  override def insert(unsaved: WorkorderRow)(implicit c: Connection): WorkorderRow = {
    SQL"""insert into production.workorder(workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate)
          values (${unsaved.workorderid}::int4, ${unsaved.productid}::int4, ${unsaved.orderqty}::int4, ${unsaved.scrappedqty}::int2, ${unsaved.startdate}::timestamp, ${unsaved.enddate}::timestamp, ${unsaved.duedate}::timestamp, ${unsaved.scrapreasonid}::int2, ${unsaved.modifieddate}::timestamp)
          returning workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  override def insert(unsaved: WorkorderRowUnsaved)(implicit c: Connection): WorkorderRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue.from(unsaved.productid)), "::int4")),
      Some((NamedParameter("orderqty", ParameterValue.from(unsaved.orderqty)), "::int4")),
      Some((NamedParameter("scrappedqty", ParameterValue.from(unsaved.scrappedqty)), "::int2")),
      Some((NamedParameter("startdate", ParameterValue.from(unsaved.startdate)), "::timestamp")),
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::timestamp")),
      Some((NamedParameter("duedate", ParameterValue.from(unsaved.duedate)), "::timestamp")),
      Some((NamedParameter("scrapreasonid", ParameterValue.from(unsaved.scrapreasonid)), "::int2")),
      unsaved.workorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("workorderid", ParameterValue.from[WorkorderId](value)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.workorder default values
            returning workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into production.workorder(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[WorkorderRow] = {
    SQL"""select workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate
          from production.workorder
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[WorkorderFieldOrIdValue[_]])(implicit c: Connection): List[WorkorderRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case WorkorderFieldValue.workorderid(value) => NamedParameter("workorderid", ParameterValue.from(value))
          case WorkorderFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case WorkorderFieldValue.orderqty(value) => NamedParameter("orderqty", ParameterValue.from(value))
          case WorkorderFieldValue.scrappedqty(value) => NamedParameter("scrappedqty", ParameterValue.from(value))
          case WorkorderFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case WorkorderFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case WorkorderFieldValue.duedate(value) => NamedParameter("duedate", ParameterValue.from(value))
          case WorkorderFieldValue.scrapreasonid(value) => NamedParameter("scrapreasonid", ParameterValue.from(value))
          case WorkorderFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate
                    from production.workorder
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(workorderid: WorkorderId)(implicit c: Connection): Option[WorkorderRow] = {
    SQL"""select workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate
          from production.workorder
          where workorderid = $workorderid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(workorderids: Array[WorkorderId])(implicit c: Connection): List[WorkorderRow] = {
    implicit val toStatement: ToStatement[Array[WorkorderId]] =
      (s: PreparedStatement, index: Int, v: Array[WorkorderId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select workorderid, productid, orderqty, scrappedqty, startdate, enddate, duedate, scrapreasonid, modifieddate
          from production.workorder
          where workorderid = ANY($workorderids)
       """.as(rowParser.*)
  
  }
  override def update(row: WorkorderRow)(implicit c: Connection): Boolean = {
    val workorderid = row.workorderid
    SQL"""update production.workorder
          set productid = ${row.productid}::int4,
              orderqty = ${row.orderqty}::int4,
              scrappedqty = ${row.scrappedqty}::int2,
              startdate = ${row.startdate}::timestamp,
              enddate = ${row.enddate}::timestamp,
              duedate = ${row.duedate}::timestamp,
              scrapreasonid = ${row.scrapreasonid}::int2,
              modifieddate = ${row.modifieddate}::timestamp
          where workorderid = $workorderid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(workorderid: WorkorderId, fieldValues: List[WorkorderFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case WorkorderFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case WorkorderFieldValue.orderqty(value) => NamedParameter("orderqty", ParameterValue.from(value))
          case WorkorderFieldValue.scrappedqty(value) => NamedParameter("scrappedqty", ParameterValue.from(value))
          case WorkorderFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case WorkorderFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case WorkorderFieldValue.duedate(value) => NamedParameter("duedate", ParameterValue.from(value))
          case WorkorderFieldValue.scrapreasonid(value) => NamedParameter("scrapreasonid", ParameterValue.from(value))
          case WorkorderFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update production.workorder
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where workorderid = {workorderid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("workorderid", ParameterValue.from(workorderid)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[WorkorderRow] =
    RowParser[WorkorderRow] { row =>
      Success(
        WorkorderRow(
          workorderid = row[WorkorderId]("workorderid"),
          productid = row[ProductId]("productid"),
          orderqty = row[Int]("orderqty"),
          scrappedqty = row[Int]("scrappedqty"),
          startdate = row[LocalDateTime]("startdate"),
          enddate = row[Option[LocalDateTime]]("enddate"),
          duedate = row[LocalDateTime]("duedate"),
          scrapreasonid = row[Option[ScrapreasonId]]("scrapreasonid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}