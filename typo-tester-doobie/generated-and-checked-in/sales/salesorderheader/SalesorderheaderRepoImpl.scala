/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import adventureworks.Defaulted
import adventureworks.public.Flag
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime
import java.util.UUID

object SalesorderheaderRepoImpl extends SalesorderheaderRepo {
  override def delete(salesorderid: SalesorderheaderId): ConnectionIO[Boolean] = {
    sql"delete from sales.salesorderheader where salesorderid = $salesorderid".update.run.map(_ > 0)
  }
  override def insert(unsaved: SalesorderheaderRow): ConnectionIO[SalesorderheaderRow] = {
    sql"""insert into sales.salesorderheader(salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate)
          values (${unsaved.salesorderid}::int4, ${unsaved.revisionnumber}::int2, ${unsaved.orderdate}::timestamp, ${unsaved.duedate}::timestamp, ${unsaved.shipdate}::timestamp, ${unsaved.status}::int2, ${unsaved.onlineorderflag}::"public"."Flag", ${unsaved.purchaseordernumber}::"public".OrderNumber, ${unsaved.accountnumber}::"public".AccountNumber, ${unsaved.customerid}::int4, ${unsaved.salespersonid}::int4, ${unsaved.territoryid}::int4, ${unsaved.billtoaddressid}::int4, ${unsaved.shiptoaddressid}::int4, ${unsaved.shipmethodid}::int4, ${unsaved.creditcardid}::int4, ${unsaved.creditcardapprovalcode}, ${unsaved.currencyrateid}::int4, ${unsaved.subtotal}::numeric, ${unsaved.taxamt}::numeric, ${unsaved.freight}::numeric, ${unsaved.totaldue}::numeric, ${unsaved.comment}, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate
       """.query[SalesorderheaderRow].unique
  }
  override def insert(unsaved: SalesorderheaderRowUnsaved): ConnectionIO[SalesorderheaderRow] = {
    val fs = List(
      Some((Fragment.const(s"duedate"), fr"${unsaved.duedate}::timestamp")),
      Some((Fragment.const(s"shipdate"), fr"${unsaved.shipdate}::timestamp")),
      Some((Fragment.const(s"purchaseordernumber"), fr"""${unsaved.purchaseordernumber}::"public".OrderNumber""")),
      Some((Fragment.const(s"accountnumber"), fr"""${unsaved.accountnumber}::"public".AccountNumber""")),
      Some((Fragment.const(s"customerid"), fr"${unsaved.customerid}::int4")),
      Some((Fragment.const(s"salespersonid"), fr"${unsaved.salespersonid}::int4")),
      Some((Fragment.const(s"territoryid"), fr"${unsaved.territoryid}::int4")),
      Some((Fragment.const(s"billtoaddressid"), fr"${unsaved.billtoaddressid}::int4")),
      Some((Fragment.const(s"shiptoaddressid"), fr"${unsaved.shiptoaddressid}::int4")),
      Some((Fragment.const(s"shipmethodid"), fr"${unsaved.shipmethodid}::int4")),
      Some((Fragment.const(s"creditcardid"), fr"${unsaved.creditcardid}::int4")),
      Some((Fragment.const(s"creditcardapprovalcode"), fr"${unsaved.creditcardapprovalcode}")),
      Some((Fragment.const(s"currencyrateid"), fr"${unsaved.currencyrateid}::int4")),
      Some((Fragment.const(s"totaldue"), fr"${unsaved.totaldue}::numeric")),
      Some((Fragment.const(s""""comment""""), fr"${unsaved.comment}")),
      unsaved.salesorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"salesorderid"), fr"${value: SalesorderheaderId}::int4"))
      },
      unsaved.revisionnumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"revisionnumber"), fr"${value: Int}::int2"))
      },
      unsaved.orderdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"orderdate"), fr"${value: LocalDateTime}::timestamp"))
      },
      unsaved.status match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"status"), fr"${value: Int}::int2"))
      },
      unsaved.onlineorderflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"onlineorderflag"), fr"""${value: Flag}::"public"."Flag""""))
      },
      unsaved.subtotal match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"subtotal"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.taxamt match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"taxamt"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.freight match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"freight"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${value: UUID}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.salesorderheader default values
            returning salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.salesorderheader(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate
         """
    }
    q.query[SalesorderheaderRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, SalesorderheaderRow] = {
    sql"""select salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate from sales.salesorderheader""".query[SalesorderheaderRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SalesorderheaderFieldOrIdValue[_]]): Stream[ConnectionIO, SalesorderheaderRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SalesorderheaderFieldValue.salesorderid(value) => fr"salesorderid = $value"
        case SalesorderheaderFieldValue.revisionnumber(value) => fr"revisionnumber = $value"
        case SalesorderheaderFieldValue.orderdate(value) => fr"orderdate = $value"
        case SalesorderheaderFieldValue.duedate(value) => fr"duedate = $value"
        case SalesorderheaderFieldValue.shipdate(value) => fr"shipdate = $value"
        case SalesorderheaderFieldValue.status(value) => fr"status = $value"
        case SalesorderheaderFieldValue.onlineorderflag(value) => fr"onlineorderflag = $value"
        case SalesorderheaderFieldValue.purchaseordernumber(value) => fr"purchaseordernumber = $value"
        case SalesorderheaderFieldValue.accountnumber(value) => fr"accountnumber = $value"
        case SalesorderheaderFieldValue.customerid(value) => fr"customerid = $value"
        case SalesorderheaderFieldValue.salespersonid(value) => fr"salespersonid = $value"
        case SalesorderheaderFieldValue.territoryid(value) => fr"territoryid = $value"
        case SalesorderheaderFieldValue.billtoaddressid(value) => fr"billtoaddressid = $value"
        case SalesorderheaderFieldValue.shiptoaddressid(value) => fr"shiptoaddressid = $value"
        case SalesorderheaderFieldValue.shipmethodid(value) => fr"shipmethodid = $value"
        case SalesorderheaderFieldValue.creditcardid(value) => fr"creditcardid = $value"
        case SalesorderheaderFieldValue.creditcardapprovalcode(value) => fr"creditcardapprovalcode = $value"
        case SalesorderheaderFieldValue.currencyrateid(value) => fr"currencyrateid = $value"
        case SalesorderheaderFieldValue.subtotal(value) => fr"subtotal = $value"
        case SalesorderheaderFieldValue.taxamt(value) => fr"taxamt = $value"
        case SalesorderheaderFieldValue.freight(value) => fr"freight = $value"
        case SalesorderheaderFieldValue.totaldue(value) => fr"totaldue = $value"
        case SalesorderheaderFieldValue.comment(value) => fr""""comment" = $value"""
        case SalesorderheaderFieldValue.rowguid(value) => fr"rowguid = $value"
        case SalesorderheaderFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sales.salesorderheader $where".query[SalesorderheaderRow].stream
  
  }
  override def selectById(salesorderid: SalesorderheaderId): ConnectionIO[Option[SalesorderheaderRow]] = {
    sql"""select salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate from sales.salesorderheader where salesorderid = $salesorderid""".query[SalesorderheaderRow].option
  }
  override def selectByIds(salesorderids: Array[SalesorderheaderId]): Stream[ConnectionIO, SalesorderheaderRow] = {
    sql"""select salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate from sales.salesorderheader where salesorderid = ANY($salesorderids)""".query[SalesorderheaderRow].stream
  }
  override def update(row: SalesorderheaderRow): ConnectionIO[Boolean] = {
    val salesorderid = row.salesorderid
    sql"""update sales.salesorderheader
          set revisionnumber = ${row.revisionnumber}::int2,
              orderdate = ${row.orderdate}::timestamp,
              duedate = ${row.duedate}::timestamp,
              shipdate = ${row.shipdate}::timestamp,
              status = ${row.status}::int2,
              onlineorderflag = ${row.onlineorderflag}::"public"."Flag",
              purchaseordernumber = ${row.purchaseordernumber}::"public".OrderNumber,
              accountnumber = ${row.accountnumber}::"public".AccountNumber,
              customerid = ${row.customerid}::int4,
              salespersonid = ${row.salespersonid}::int4,
              territoryid = ${row.territoryid}::int4,
              billtoaddressid = ${row.billtoaddressid}::int4,
              shiptoaddressid = ${row.shiptoaddressid}::int4,
              shipmethodid = ${row.shipmethodid}::int4,
              creditcardid = ${row.creditcardid}::int4,
              creditcardapprovalcode = ${row.creditcardapprovalcode},
              currencyrateid = ${row.currencyrateid}::int4,
              subtotal = ${row.subtotal}::numeric,
              taxamt = ${row.taxamt}::numeric,
              freight = ${row.freight}::numeric,
              totaldue = ${row.totaldue}::numeric,
              "comment" = ${row.comment},
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where salesorderid = $salesorderid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(salesorderid: SalesorderheaderId, fieldValues: List[SalesorderheaderFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case SalesorderheaderFieldValue.revisionnumber(value) => fr"revisionnumber = $value"
            case SalesorderheaderFieldValue.orderdate(value) => fr"orderdate = $value"
            case SalesorderheaderFieldValue.duedate(value) => fr"duedate = $value"
            case SalesorderheaderFieldValue.shipdate(value) => fr"shipdate = $value"
            case SalesorderheaderFieldValue.status(value) => fr"status = $value"
            case SalesorderheaderFieldValue.onlineorderflag(value) => fr"onlineorderflag = $value"
            case SalesorderheaderFieldValue.purchaseordernumber(value) => fr"purchaseordernumber = $value"
            case SalesorderheaderFieldValue.accountnumber(value) => fr"accountnumber = $value"
            case SalesorderheaderFieldValue.customerid(value) => fr"customerid = $value"
            case SalesorderheaderFieldValue.salespersonid(value) => fr"salespersonid = $value"
            case SalesorderheaderFieldValue.territoryid(value) => fr"territoryid = $value"
            case SalesorderheaderFieldValue.billtoaddressid(value) => fr"billtoaddressid = $value"
            case SalesorderheaderFieldValue.shiptoaddressid(value) => fr"shiptoaddressid = $value"
            case SalesorderheaderFieldValue.shipmethodid(value) => fr"shipmethodid = $value"
            case SalesorderheaderFieldValue.creditcardid(value) => fr"creditcardid = $value"
            case SalesorderheaderFieldValue.creditcardapprovalcode(value) => fr"creditcardapprovalcode = $value"
            case SalesorderheaderFieldValue.currencyrateid(value) => fr"currencyrateid = $value"
            case SalesorderheaderFieldValue.subtotal(value) => fr"subtotal = $value"
            case SalesorderheaderFieldValue.taxamt(value) => fr"taxamt = $value"
            case SalesorderheaderFieldValue.freight(value) => fr"freight = $value"
            case SalesorderheaderFieldValue.totaldue(value) => fr"totaldue = $value"
            case SalesorderheaderFieldValue.comment(value) => fr""""comment" = $value"""
            case SalesorderheaderFieldValue.rowguid(value) => fr"rowguid = $value"
            case SalesorderheaderFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update sales.salesorderheader
              $updates
              where salesorderid = $salesorderid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: SalesorderheaderRow): ConnectionIO[SalesorderheaderRow] = {
    sql"""insert into sales.salesorderheader(salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate)
          values (
            ${unsaved.salesorderid}::int4,
            ${unsaved.revisionnumber}::int2,
            ${unsaved.orderdate}::timestamp,
            ${unsaved.duedate}::timestamp,
            ${unsaved.shipdate}::timestamp,
            ${unsaved.status}::int2,
            ${unsaved.onlineorderflag}::"public"."Flag",
            ${unsaved.purchaseordernumber}::"public".OrderNumber,
            ${unsaved.accountnumber}::"public".AccountNumber,
            ${unsaved.customerid}::int4,
            ${unsaved.salespersonid}::int4,
            ${unsaved.territoryid}::int4,
            ${unsaved.billtoaddressid}::int4,
            ${unsaved.shiptoaddressid}::int4,
            ${unsaved.shipmethodid}::int4,
            ${unsaved.creditcardid}::int4,
            ${unsaved.creditcardapprovalcode},
            ${unsaved.currencyrateid}::int4,
            ${unsaved.subtotal}::numeric,
            ${unsaved.taxamt}::numeric,
            ${unsaved.freight}::numeric,
            ${unsaved.totaldue}::numeric,
            ${unsaved.comment},
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (salesorderid)
          do update set
            revisionnumber = EXCLUDED.revisionnumber,
            orderdate = EXCLUDED.orderdate,
            duedate = EXCLUDED.duedate,
            shipdate = EXCLUDED.shipdate,
            status = EXCLUDED.status,
            onlineorderflag = EXCLUDED.onlineorderflag,
            purchaseordernumber = EXCLUDED.purchaseordernumber,
            accountnumber = EXCLUDED.accountnumber,
            customerid = EXCLUDED.customerid,
            salespersonid = EXCLUDED.salespersonid,
            territoryid = EXCLUDED.territoryid,
            billtoaddressid = EXCLUDED.billtoaddressid,
            shiptoaddressid = EXCLUDED.shiptoaddressid,
            shipmethodid = EXCLUDED.shipmethodid,
            creditcardid = EXCLUDED.creditcardid,
            creditcardapprovalcode = EXCLUDED.creditcardapprovalcode,
            currencyrateid = EXCLUDED.currencyrateid,
            subtotal = EXCLUDED.subtotal,
            taxamt = EXCLUDED.taxamt,
            freight = EXCLUDED.freight,
            totaldue = EXCLUDED.totaldue,
            "comment" = EXCLUDED."comment",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning salesorderid, revisionnumber, orderdate, duedate, shipdate, status, onlineorderflag, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, subtotal, taxamt, freight, totaldue, "comment", rowguid, modifieddate
       """.query[SalesorderheaderRow].unique
  }
}
