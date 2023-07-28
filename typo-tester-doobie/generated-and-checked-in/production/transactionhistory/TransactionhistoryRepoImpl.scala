/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream

object TransactionhistoryRepoImpl extends TransactionhistoryRepo {
  override def delete(transactionid: TransactionhistoryId): ConnectionIO[Boolean] = {
    sql"delete from production.transactionhistory where transactionid = ${transactionid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: TransactionhistoryRow): ConnectionIO[TransactionhistoryRow] = {
    sql"""insert into production.transactionhistory(transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate)
          values (${unsaved.transactionid}::int4, ${unsaved.productid}::int4, ${unsaved.referenceorderid}::int4, ${unsaved.referenceorderlineid}::int4, ${unsaved.transactiondate}::timestamp, ${unsaved.transactiontype}::bpchar, ${unsaved.quantity}::int4, ${unsaved.actualcost}::numeric, ${unsaved.modifieddate}::timestamp)
          returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate::text, transactiontype, quantity, actualcost, modifieddate::text
       """.query[TransactionhistoryRow].unique
  }
  override def insert(unsaved: TransactionhistoryRowUnsaved): ConnectionIO[TransactionhistoryRow] = {
    val fs = List(
      Some((Fragment.const(s"productid"), fr"${unsaved.productid}::int4")),
      Some((Fragment.const(s"referenceorderid"), fr"${unsaved.referenceorderid}::int4")),
      Some((Fragment.const(s"transactiontype"), fr"${unsaved.transactiontype}::bpchar")),
      Some((Fragment.const(s"quantity"), fr"${unsaved.quantity}::int4")),
      Some((Fragment.const(s"actualcost"), fr"${unsaved.actualcost}::numeric")),
      unsaved.transactionid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"transactionid"), fr"${value: TransactionhistoryId}::int4"))
      },
      unsaved.referenceorderlineid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"referenceorderlineid"), fr"${value: Int}::int4"))
      },
      unsaved.transactiondate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"transactiondate"), fr"${value: TypoLocalDateTime}::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: TypoLocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.transactionhistory default values
            returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate::text, transactiontype, quantity, actualcost, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.transactionhistory(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate::text, transactiontype, quantity, actualcost, modifieddate::text
         """
    }
    q.query[TransactionhistoryRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, TransactionhistoryRow] = {
    sql"select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate::text, transactiontype, quantity, actualcost, modifieddate::text from production.transactionhistory".query[TransactionhistoryRow].stream
  }
  override def selectById(transactionid: TransactionhistoryId): ConnectionIO[Option[TransactionhistoryRow]] = {
    sql"select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate::text, transactiontype, quantity, actualcost, modifieddate::text from production.transactionhistory where transactionid = ${transactionid}".query[TransactionhistoryRow].option
  }
  override def selectByIds(transactionids: Array[TransactionhistoryId]): Stream[ConnectionIO, TransactionhistoryRow] = {
    sql"select transactionid, productid, referenceorderid, referenceorderlineid, transactiondate::text, transactiontype, quantity, actualcost, modifieddate::text from production.transactionhistory where transactionid = ANY(${transactionids})".query[TransactionhistoryRow].stream
  }
  override def update(row: TransactionhistoryRow): ConnectionIO[Boolean] = {
    val transactionid = row.transactionid
    sql"""update production.transactionhistory
          set productid = ${row.productid}::int4,
              referenceorderid = ${row.referenceorderid}::int4,
              referenceorderlineid = ${row.referenceorderlineid}::int4,
              transactiondate = ${row.transactiondate}::timestamp,
              transactiontype = ${row.transactiontype}::bpchar,
              quantity = ${row.quantity}::int4,
              actualcost = ${row.actualcost}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where transactionid = ${transactionid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: TransactionhistoryRow): ConnectionIO[TransactionhistoryRow] = {
    sql"""insert into production.transactionhistory(transactionid, productid, referenceorderid, referenceorderlineid, transactiondate, transactiontype, quantity, actualcost, modifieddate)
          values (
            ${unsaved.transactionid}::int4,
            ${unsaved.productid}::int4,
            ${unsaved.referenceorderid}::int4,
            ${unsaved.referenceorderlineid}::int4,
            ${unsaved.transactiondate}::timestamp,
            ${unsaved.transactiontype}::bpchar,
            ${unsaved.quantity}::int4,
            ${unsaved.actualcost}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (transactionid)
          do update set
            productid = EXCLUDED.productid,
            referenceorderid = EXCLUDED.referenceorderid,
            referenceorderlineid = EXCLUDED.referenceorderlineid,
            transactiondate = EXCLUDED.transactiondate,
            transactiontype = EXCLUDED.transactiontype,
            quantity = EXCLUDED.quantity,
            actualcost = EXCLUDED.actualcost,
            modifieddate = EXCLUDED.modifieddate
          returning transactionid, productid, referenceorderid, referenceorderlineid, transactiondate::text, transactiontype, quantity, actualcost, modifieddate::text
       """.query[TransactionhistoryRow].unique
  }
}
