/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialofferproduct

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class SpecialofferproductRepoImpl extends SpecialofferproductRepo {
  override def delete: DeleteBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    DeleteBuilder("sales.specialofferproduct", SpecialofferproductFields.structure)
  }
  override def deleteById(compositeId: SpecialofferproductId): ConnectionIO[Boolean] = {
    sql"""delete from sales.specialofferproduct where "specialofferid" = ${fromWrite(compositeId.specialofferid)(Write.fromPut(SpecialofferId.put))} AND "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[SpecialofferproductId]): ConnectionIO[Int] = {
    val specialofferid = compositeIds.map(_.specialofferid)
    val productid = compositeIds.map(_.productid)
    sql"""delete
          from sales.specialofferproduct
          where ("specialofferid", "productid")
          in (select unnest(${specialofferid}), unnest(${productid}))
       """.update.run
    
  }
  override def insert(unsaved: SpecialofferproductRow): ConnectionIO[SpecialofferproductRow] = {
    sql"""insert into sales.specialofferproduct("specialofferid", "productid", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.specialofferid)(Write.fromPut(SpecialofferId.put))}::int4, ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "specialofferid", "productid", "rowguid", "modifieddate"::text
       """.query(using SpecialofferproductRow.read).unique
  }
  override def insert(unsaved: SpecialofferproductRowUnsaved): ConnectionIO[SpecialofferproductRow] = {
    val fs = List(
      Some((Fragment.const(s""""specialofferid""""), fr"${fromWrite(unsaved.specialofferid)(Write.fromPut(SpecialofferId.put))}::int4")),
      Some((Fragment.const(s""""productid""""), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.specialofferproduct default values
            returning "specialofferid", "productid", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into sales.specialofferproduct(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "specialofferid", "productid", "rowguid", "modifieddate"::text
         """
    }
    q.query(using SpecialofferproductRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SpecialofferproductRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.specialofferproduct("specialofferid", "productid", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using SpecialofferproductRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SpecialofferproductRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.specialofferproduct("specialofferid", "productid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using SpecialofferproductRowUnsaved.text)
  }
  override def select: SelectBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    SelectBuilderSql("sales.specialofferproduct", SpecialofferproductFields.structure, SpecialofferproductRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SpecialofferproductRow] = {
    sql"""select "specialofferid", "productid", "rowguid", "modifieddate"::text from sales.specialofferproduct""".query(using SpecialofferproductRow.read).stream
  }
  override def selectById(compositeId: SpecialofferproductId): ConnectionIO[Option[SpecialofferproductRow]] = {
    sql"""select "specialofferid", "productid", "rowguid", "modifieddate"::text from sales.specialofferproduct where "specialofferid" = ${fromWrite(compositeId.specialofferid)(Write.fromPut(SpecialofferId.put))} AND "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))}""".query(using SpecialofferproductRow.read).option
  }
  override def selectByIds(compositeIds: Array[SpecialofferproductId]): Stream[ConnectionIO, SpecialofferproductRow] = {
    val specialofferid = compositeIds.map(_.specialofferid)
    val productid = compositeIds.map(_.productid)
    sql"""select "specialofferid", "productid", "rowguid", "modifieddate"::text
          from sales.specialofferproduct
          where ("specialofferid", "productid") 
          in (select unnest(${specialofferid}), unnest(${productid}))
       """.query(using SpecialofferproductRow.read).stream
    
  }
  override def selectByIdsTracked(compositeIds: Array[SpecialofferproductId]): ConnectionIO[Map[SpecialofferproductId, Option[SpecialofferproductRow]]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    UpdateBuilder("sales.specialofferproduct", SpecialofferproductFields.structure, SpecialofferproductRow.read)
  }
  override def update(row: SpecialofferproductRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update sales.specialofferproduct
          set "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "specialofferid" = ${fromWrite(compositeId.specialofferid)(Write.fromPut(SpecialofferId.put))} AND "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: SpecialofferproductRow): ConnectionIO[SpecialofferproductRow] = {
    sql"""insert into sales.specialofferproduct("specialofferid", "productid", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.specialofferid)(Write.fromPut(SpecialofferId.put))}::int4,
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("specialofferid", "productid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "specialofferid", "productid", "rowguid", "modifieddate"::text
       """.query(using SpecialofferproductRow.read).unique
  }
}
