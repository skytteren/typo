/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream

object ProductlistpricehistoryRepoImpl extends ProductlistpricehistoryRepo {
  override def delete(compositeId: ProductlistpricehistoryId): ConnectionIO[Boolean] = {
    sql"delete from production.productlistpricehistory where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ProductlistpricehistoryRow): ConnectionIO[ProductlistpricehistoryRow] = {
    sql"""insert into production.productlistpricehistory(productid, startdate, enddate, listprice, modifieddate)
          values (${unsaved.productid}::int4, ${unsaved.startdate}::timestamp, ${unsaved.enddate}::timestamp, ${unsaved.listprice}::numeric, ${unsaved.modifieddate}::timestamp)
          returning productid, startdate::text, enddate::text, listprice, modifieddate::text
       """.query(ProductlistpricehistoryRow.read).unique
  }
  override def insert(unsaved: ProductlistpricehistoryRowUnsaved): ConnectionIO[ProductlistpricehistoryRow] = {
    val fs = List(
      Some((Fragment.const(s"productid"), fr"${unsaved.productid}::int4")),
      Some((Fragment.const(s"startdate"), fr"${unsaved.startdate}::timestamp")),
      Some((Fragment.const(s"enddate"), fr"${unsaved.enddate}::timestamp")),
      Some((Fragment.const(s"listprice"), fr"${unsaved.listprice}::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: TypoLocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productlistpricehistory default values
            returning productid, startdate::text, enddate::text, listprice, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productlistpricehistory(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productid, startdate::text, enddate::text, listprice, modifieddate::text
         """
    }
    q.query(ProductlistpricehistoryRow.read).unique
  
  }
  override def selectAll: Stream[ConnectionIO, ProductlistpricehistoryRow] = {
    sql"select productid, startdate::text, enddate::text, listprice, modifieddate::text from production.productlistpricehistory".query(ProductlistpricehistoryRow.read).stream
  }
  override def selectById(compositeId: ProductlistpricehistoryId): ConnectionIO[Option[ProductlistpricehistoryRow]] = {
    sql"select productid, startdate::text, enddate::text, listprice, modifieddate::text from production.productlistpricehistory where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}".query(ProductlistpricehistoryRow.read).option
  }
  override def update(row: ProductlistpricehistoryRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productlistpricehistory
          set enddate = ${row.enddate}::timestamp,
              listprice = ${row.listprice}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where productid = ${compositeId.productid} AND startdate = ${compositeId.startdate}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductlistpricehistoryRow): ConnectionIO[ProductlistpricehistoryRow] = {
    sql"""insert into production.productlistpricehistory(productid, startdate, enddate, listprice, modifieddate)
          values (
            ${unsaved.productid}::int4,
            ${unsaved.startdate}::timestamp,
            ${unsaved.enddate}::timestamp,
            ${unsaved.listprice}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productid, startdate)
          do update set
            enddate = EXCLUDED.enddate,
            listprice = EXCLUDED.listprice,
            modifieddate = EXCLUDED.modifieddate
          returning productid, startdate::text, enddate::text, listprice, modifieddate::text
       """.query(ProductlistpricehistoryRow.read).unique
  }
}
