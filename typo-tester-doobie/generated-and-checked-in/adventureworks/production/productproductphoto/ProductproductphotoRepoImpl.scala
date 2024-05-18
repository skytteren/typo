/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productproductphoto

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.production.productphoto.ProductphotoId
import adventureworks.public.Flag
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

class ProductproductphotoRepoImpl extends ProductproductphotoRepo {
  override def delete: DeleteBuilder[ProductproductphotoFields, ProductproductphotoRow] = {
    DeleteBuilder("production.productproductphoto", ProductproductphotoFields.structure)
  }
  override def deleteById(compositeId: ProductproductphotoId): ConnectionIO[Boolean] = {
    sql"""delete from production.productproductphoto where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "productphotoid" = ${fromWrite(compositeId.productphotoid)(Write.fromPut(ProductphotoId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[ProductproductphotoId]): ConnectionIO[Int] = {
    val productid = compositeIds.map(_.productid)
    val productphotoid = compositeIds.map(_.productphotoid)
    sql"""delete
          from production.productproductphoto
          where ("productid", "productphotoid")
          in (select unnest(${productid}), unnest(${productphotoid}))
       """.update.run
    
  }
  override def insert(unsaved: ProductproductphotoRow): ConnectionIO[ProductproductphotoRow] = {
    sql"""insert into production.productproductphoto("productid", "productphotoid", "primary", "modifieddate")
          values (${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.productphotoid)(Write.fromPut(ProductphotoId.put))}::int4, ${fromWrite(unsaved.primary)(Write.fromPut(Flag.put))}::bool, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productid", "productphotoid", "primary", "modifieddate"::text
       """.query(using ProductproductphotoRow.read).unique
  }
  override def insert(unsaved: ProductproductphotoRowUnsaved): ConnectionIO[ProductproductphotoRow] = {
    val fs = List(
      Some((Fragment.const0(s""""productid""""), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      Some((Fragment.const0(s""""productphotoid""""), fr"${fromWrite(unsaved.productphotoid)(Write.fromPut(ProductphotoId.put))}::int4")),
      unsaved.primary match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""primary""""), fr"${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::bool"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productproductphoto default values
            returning "productid", "productphotoid", "primary", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productproductphoto(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "productid", "productphotoid", "primary", "modifieddate"::text
         """
    }
    q.query(using ProductproductphotoRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductproductphotoRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productproductphoto("productid", "productphotoid", "primary", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductproductphotoRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductproductphotoRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productproductphoto("productid", "productphotoid", "primary", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductproductphotoRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductproductphotoFields, ProductproductphotoRow] = {
    SelectBuilderSql("production.productproductphoto", ProductproductphotoFields.structure, ProductproductphotoRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductproductphotoRow] = {
    sql"""select "productid", "productphotoid", "primary", "modifieddate"::text from production.productproductphoto""".query(using ProductproductphotoRow.read).stream
  }
  override def selectById(compositeId: ProductproductphotoId): ConnectionIO[Option[ProductproductphotoRow]] = {
    sql"""select "productid", "productphotoid", "primary", "modifieddate"::text from production.productproductphoto where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "productphotoid" = ${fromWrite(compositeId.productphotoid)(Write.fromPut(ProductphotoId.put))}""".query(using ProductproductphotoRow.read).option
  }
  override def selectByIds(compositeIds: Array[ProductproductphotoId]): Stream[ConnectionIO, ProductproductphotoRow] = {
    val productid = compositeIds.map(_.productid)
    val productphotoid = compositeIds.map(_.productphotoid)
    sql"""select "productid", "productphotoid", "primary", "modifieddate"::text
          from production.productproductphoto
          where ("productid", "productphotoid") 
          in (select unnest(${productid}), unnest(${productphotoid}))
       """.query(using ProductproductphotoRow.read).stream
    
  }
  override def selectByIdsTracked(compositeIds: Array[ProductproductphotoId]): ConnectionIO[Map[ProductproductphotoId, ProductproductphotoRow]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductproductphotoFields, ProductproductphotoRow] = {
    UpdateBuilder("production.productproductphoto", ProductproductphotoFields.structure, ProductproductphotoRow.read)
  }
  override def update(row: ProductproductphotoRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productproductphoto
          set "primary" = ${fromWrite(row.primary)(Write.fromPut(Flag.put))}::bool,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productid" = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))} AND "productphotoid" = ${fromWrite(compositeId.productphotoid)(Write.fromPut(ProductphotoId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductproductphotoRow): ConnectionIO[ProductproductphotoRow] = {
    sql"""insert into production.productproductphoto("productid", "productphotoid", "primary", "modifieddate")
          values (
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.productphotoid)(Write.fromPut(ProductphotoId.put))}::int4,
            ${fromWrite(unsaved.primary)(Write.fromPut(Flag.put))}::bool,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productid", "productphotoid")
          do update set
            "primary" = EXCLUDED."primary",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "productphotoid", "primary", "modifieddate"::text
       """.query(using ProductproductphotoRow.read).unique
  }
}
