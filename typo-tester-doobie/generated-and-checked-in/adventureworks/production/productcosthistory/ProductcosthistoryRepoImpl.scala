/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

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

class ProductcosthistoryRepoImpl extends ProductcosthistoryRepo {
  override def delete(compositeId: ProductcosthistoryId): ConnectionIO[Boolean] = {
    sql"""delete from production.productcosthistory where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "startdate" = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDateTime.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    DeleteBuilder("production.productcosthistory", ProductcosthistoryFields)
  }
  override def insert(unsaved: ProductcosthistoryRow): ConnectionIO[ProductcosthistoryRow] = {
    sql"""insert into production.productcosthistory("productid", "startdate", "enddate", "standardcost", "modifieddate")
          values (${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
       """.query(ProductcosthistoryRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductcosthistoryRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productcosthistory("productid", "startdate", "enddate", "standardcost", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(ProductcosthistoryRow.text)
  }
  override def insert(unsaved: ProductcosthistoryRowUnsaved): ConnectionIO[ProductcosthistoryRow] = {
    val fs = List(
      Some((Fragment.const(s""""productid""""), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      Some((Fragment.const(s""""startdate""""), fr"${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""enddate""""), fr"${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""standardcost""""), fr"${fromWrite(unsaved.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productcosthistory default values
            returning "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productcosthistory(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
         """
    }
    q.query(ProductcosthistoryRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductcosthistoryRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productcosthistory("productid", "startdate", "enddate", "standardcost", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(ProductcosthistoryRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    SelectBuilderSql("production.productcosthistory", ProductcosthistoryFields, ProductcosthistoryRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductcosthistoryRow] = {
    sql"""select "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text from production.productcosthistory""".query(ProductcosthistoryRow.read).stream
  }
  override def selectById(compositeId: ProductcosthistoryId): ConnectionIO[Option[ProductcosthistoryRow]] = {
    sql"""select "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text from production.productcosthistory where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "startdate" = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDateTime.put))}""".query(ProductcosthistoryRow.read).option
  }
  override def update(row: ProductcosthistoryRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productcosthistory
          set "enddate" = ${fromWrite(row.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              "standardcost" = ${fromWrite(row.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "startdate" = ${fromWrite(compositeId.startdate)(Write.fromPut(TypoLocalDateTime.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    UpdateBuilder("production.productcosthistory", ProductcosthistoryFields, ProductcosthistoryRow.read)
  }
  override def upsert(unsaved: ProductcosthistoryRow): ConnectionIO[ProductcosthistoryRow] = {
    sql"""insert into production.productcosthistory("productid", "startdate", "enddate", "standardcost", "modifieddate")
          values (
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.standardcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productid", "startdate")
          do update set
            "enddate" = EXCLUDED."enddate",
            "standardcost" = EXCLUDED."standardcost",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
       """.query(ProductcosthistoryRow.read).unique
  }
}
