/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderdetail

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime

object PurchaseorderdetailRepoImpl extends PurchaseorderdetailRepo {
  override def delete(compositeId: PurchaseorderdetailId): ConnectionIO[Boolean] = {
    sql"delete from purchasing.purchaseorderdetail where purchaseorderid = ${compositeId.purchaseorderid} AND purchaseorderdetailid = ${compositeId.purchaseorderdetailid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PurchaseorderdetailRow): ConnectionIO[PurchaseorderdetailRow] = {
    sql"""insert into purchasing.purchaseorderdetail(purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate)
          values (${unsaved.purchaseorderid}::int4, ${unsaved.purchaseorderdetailid}::int4, ${unsaved.duedate}::timestamp, ${unsaved.orderqty}::int2, ${unsaved.productid}::int4, ${unsaved.unitprice}::numeric, ${unsaved.receivedqty}::numeric, ${unsaved.rejectedqty}::numeric, ${unsaved.modifieddate}::timestamp)
          returning purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate
       """.query[PurchaseorderdetailRow].unique
  }
  override def insert(unsaved: PurchaseorderdetailRowUnsaved): ConnectionIO[PurchaseorderdetailRow] = {
    val fs = List(
      Some((Fragment.const(s"purchaseorderid"), fr"${unsaved.purchaseorderid}::int4")),
      Some((Fragment.const(s"duedate"), fr"${unsaved.duedate}::timestamp")),
      Some((Fragment.const(s"orderqty"), fr"${unsaved.orderqty}::int2")),
      Some((Fragment.const(s"productid"), fr"${unsaved.productid}::int4")),
      Some((Fragment.const(s"unitprice"), fr"${unsaved.unitprice}::numeric")),
      Some((Fragment.const(s"receivedqty"), fr"${unsaved.receivedqty}::numeric")),
      Some((Fragment.const(s"rejectedqty"), fr"${unsaved.rejectedqty}::numeric")),
      unsaved.purchaseorderdetailid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"purchaseorderdetailid"), fr"${value: Int}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into purchasing.purchaseorderdetail default values
            returning purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into purchasing.purchaseorderdetail(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate
         """
    }
    q.query[PurchaseorderdetailRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, PurchaseorderdetailRow] = {
    sql"select purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate from purchasing.purchaseorderdetail".query[PurchaseorderdetailRow].stream
  }
  override def selectByFieldValues(fieldValues: List[PurchaseorderdetailFieldOrIdValue[_]]): Stream[ConnectionIO, PurchaseorderdetailRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case PurchaseorderdetailFieldValue.purchaseorderid(value) => fr"purchaseorderid = $value"
        case PurchaseorderdetailFieldValue.purchaseorderdetailid(value) => fr"purchaseorderdetailid = $value"
        case PurchaseorderdetailFieldValue.duedate(value) => fr"duedate = $value"
        case PurchaseorderdetailFieldValue.orderqty(value) => fr"orderqty = $value"
        case PurchaseorderdetailFieldValue.productid(value) => fr"productid = $value"
        case PurchaseorderdetailFieldValue.unitprice(value) => fr"unitprice = $value"
        case PurchaseorderdetailFieldValue.receivedqty(value) => fr"receivedqty = $value"
        case PurchaseorderdetailFieldValue.rejectedqty(value) => fr"rejectedqty = $value"
        case PurchaseorderdetailFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from purchasing.purchaseorderdetail $where".query[PurchaseorderdetailRow].stream
  
  }
  override def selectById(compositeId: PurchaseorderdetailId): ConnectionIO[Option[PurchaseorderdetailRow]] = {
    sql"select purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate from purchasing.purchaseorderdetail where purchaseorderid = ${compositeId.purchaseorderid} AND purchaseorderdetailid = ${compositeId.purchaseorderdetailid}".query[PurchaseorderdetailRow].option
  }
  override def update(row: PurchaseorderdetailRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update purchasing.purchaseorderdetail
          set duedate = ${row.duedate}::timestamp,
              orderqty = ${row.orderqty}::int2,
              productid = ${row.productid}::int4,
              unitprice = ${row.unitprice}::numeric,
              receivedqty = ${row.receivedqty}::numeric,
              rejectedqty = ${row.rejectedqty}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where purchaseorderid = ${compositeId.purchaseorderid} AND purchaseorderdetailid = ${compositeId.purchaseorderdetailid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(compositeId: PurchaseorderdetailId, fieldValues: List[PurchaseorderdetailFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case PurchaseorderdetailFieldValue.duedate(value) => fr"duedate = $value"
            case PurchaseorderdetailFieldValue.orderqty(value) => fr"orderqty = $value"
            case PurchaseorderdetailFieldValue.productid(value) => fr"productid = $value"
            case PurchaseorderdetailFieldValue.unitprice(value) => fr"unitprice = $value"
            case PurchaseorderdetailFieldValue.receivedqty(value) => fr"receivedqty = $value"
            case PurchaseorderdetailFieldValue.rejectedqty(value) => fr"rejectedqty = $value"
            case PurchaseorderdetailFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update purchasing.purchaseorderdetail
              $updates
              where purchaseorderid = ${compositeId.purchaseorderid} AND purchaseorderdetailid = ${compositeId.purchaseorderdetailid}
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: PurchaseorderdetailRow): ConnectionIO[PurchaseorderdetailRow] = {
    sql"""insert into purchasing.purchaseorderdetail(purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate)
          values (
            ${unsaved.purchaseorderid}::int4,
            ${unsaved.purchaseorderdetailid}::int4,
            ${unsaved.duedate}::timestamp,
            ${unsaved.orderqty}::int2,
            ${unsaved.productid}::int4,
            ${unsaved.unitprice}::numeric,
            ${unsaved.receivedqty}::numeric,
            ${unsaved.rejectedqty}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (purchaseorderid, purchaseorderdetailid)
          do update set
            duedate = EXCLUDED.duedate,
            orderqty = EXCLUDED.orderqty,
            productid = EXCLUDED.productid,
            unitprice = EXCLUDED.unitprice,
            receivedqty = EXCLUDED.receivedqty,
            rejectedqty = EXCLUDED.rejectedqty,
            modifieddate = EXCLUDED.modifieddate
          returning purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate
       """.query[PurchaseorderdetailRow].unique
  }
}
