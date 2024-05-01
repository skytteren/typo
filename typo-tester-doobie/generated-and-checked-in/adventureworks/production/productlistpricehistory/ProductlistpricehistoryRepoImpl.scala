/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ProductlistpricehistoryRepoImpl extends ProductlistpricehistoryRepo {
  override def delete: DeleteBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = {
    DeleteBuilder("production.productlistpricehistory", ProductlistpricehistoryFields.structure)
  }
  override def deleteById(compositeId: ProductlistpricehistoryId): ConnectionIO[Boolean] = {
    sql"""delete from production.productlistpricehistory where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "startdate" = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDateTime.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[ProductlistpricehistoryId]): ConnectionIO[Int] = {
    val productid = compositeIds.map(_.productid)
    val startdate = compositeIds.map(_.startdate)
    sql"""delete
          from production.productlistpricehistory
          where ("productid", "startdate")
          in (select unnest(${productid}), unnest(${startdate}))
       """.update.run
    
  }
  override def insert(unsaved: ProductlistpricehistoryRow): ConnectionIO[ProductlistpricehistoryRow] = {
    sql"""insert into production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate")
          values (${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
       """.query(using ProductlistpricehistoryRow.read).unique
  }
  override def insert(unsaved: ProductlistpricehistoryRowUnsaved): ConnectionIO[ProductlistpricehistoryRow] = {
    val fs = List(
      Some((Fragment.const(s""""productid""""), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      Some((Fragment.const(s""""startdate""""), fr"${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""enddate""""), fr"${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""listprice""""), fr"${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productlistpricehistory default values
            returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productlistpricehistory(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
         """
    }
    q.query(using ProductlistpricehistoryRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductlistpricehistoryRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductlistpricehistoryRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductlistpricehistoryRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductlistpricehistoryRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = {
    SelectBuilderSql("production.productlistpricehistory", ProductlistpricehistoryFields.structure, ProductlistpricehistoryRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductlistpricehistoryRow] = {
    sql"""select "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text from production.productlistpricehistory""".query(using ProductlistpricehistoryRow.read).stream
  }
  override def selectById(compositeId: ProductlistpricehistoryId): ConnectionIO[Option[ProductlistpricehistoryRow]] = {
    sql"""select "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text from production.productlistpricehistory where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "startdate" = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDateTime.put))}""".query(using ProductlistpricehistoryRow.read).option
  }
  override def selectByIds(compositeIds: Array[ProductlistpricehistoryId]): Stream[ConnectionIO, ProductlistpricehistoryRow] = {
    val productid = compositeIds.map(_.productid)
    val startdate = compositeIds.map(_.startdate)
    sql"""select "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
          from production.productlistpricehistory
          where ("productid", "startdate") 
          in (select unnest(${productid}), unnest(${startdate}))
       """.query(using ProductlistpricehistoryRow.read).stream
    
  }
  override def selectByIdsTracked(compositeIds: Array[ProductlistpricehistoryId]): ConnectionIO[Map[ProductlistpricehistoryId, Option[ProductlistpricehistoryRow]]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = {
    UpdateBuilder("production.productlistpricehistory", ProductlistpricehistoryFields.structure, ProductlistpricehistoryRow.read)
  }
  override def update(row: ProductlistpricehistoryRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productlistpricehistory
          set "enddate" = ${fromWrite(row.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              "listprice" = ${fromWrite(row.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "startdate" = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDateTime.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductlistpricehistoryRow): ConnectionIO[ProductlistpricehistoryRow] = {
    sql"""insert into production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate")
          values (
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.listprice)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productid", "startdate")
          do update set
            "enddate" = EXCLUDED."enddate",
            "listprice" = EXCLUDED."listprice",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
       """.query(using ProductlistpricehistoryRow.read).unique
  }
}
