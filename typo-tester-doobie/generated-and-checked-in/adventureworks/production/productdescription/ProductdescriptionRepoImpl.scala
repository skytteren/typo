/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productdescription

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
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

class ProductdescriptionRepoImpl extends ProductdescriptionRepo {
  override def delete: DeleteBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    DeleteBuilder("production.productdescription", ProductdescriptionFields.structure)
  }
  override def deleteById(productdescriptionid: ProductdescriptionId): ConnectionIO[Boolean] = {
    sql"""delete from production.productdescription where "productdescriptionid" = ${fromWrite(productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(productdescriptionids: Array[ProductdescriptionId]): ConnectionIO[Int] = {
    sql"""delete from production.productdescription where "productdescriptionid" = ANY(${productdescriptionids})""".update.run
  }
  override def insert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow] = {
    sql"""insert into production.productdescription("productdescriptionid", "description", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}::int4, ${fromWrite(unsaved.description)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productdescriptionid", "description", "rowguid", "modifieddate"::text
       """.query(using ProductdescriptionRow.read).unique
  }
  override def insert(unsaved: ProductdescriptionRowUnsaved): ConnectionIO[ProductdescriptionRow] = {
    val fs = List(
      Some((Fragment.const(s""""description""""), fr"${fromWrite(unsaved.description)(Write.fromPut(Meta.StringMeta.put))}")),
      unsaved.productdescriptionid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""productdescriptionid""""), fr"${fromWrite(value: ProductdescriptionId)(Write.fromPut(ProductdescriptionId.put))}::int4"))
      },
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
      sql"""insert into production.productdescription default values
            returning "productdescriptionid", "description", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productdescription(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "productdescriptionid", "description", "rowguid", "modifieddate"::text
         """
    }
    q.query(using ProductdescriptionRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductdescriptionRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productdescription("productdescriptionid", "description", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductdescriptionRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductdescriptionRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productdescription("description", "productdescriptionid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductdescriptionRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    SelectBuilderSql("production.productdescription", ProductdescriptionFields.structure, ProductdescriptionRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductdescriptionRow] = {
    sql"""select "productdescriptionid", "description", "rowguid", "modifieddate"::text from production.productdescription""".query(using ProductdescriptionRow.read).stream
  }
  override def selectById(productdescriptionid: ProductdescriptionId): ConnectionIO[Option[ProductdescriptionRow]] = {
    sql"""select "productdescriptionid", "description", "rowguid", "modifieddate"::text from production.productdescription where "productdescriptionid" = ${fromWrite(productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}""".query(using ProductdescriptionRow.read).option
  }
  override def selectByIds(productdescriptionids: Array[ProductdescriptionId]): Stream[ConnectionIO, ProductdescriptionRow] = {
    sql"""select "productdescriptionid", "description", "rowguid", "modifieddate"::text from production.productdescription where "productdescriptionid" = ANY(${productdescriptionids})""".query(using ProductdescriptionRow.read).stream
  }
  override def selectByIdsTracked(productdescriptionids: Array[ProductdescriptionId]): ConnectionIO[Map[ProductdescriptionId, Option[ProductdescriptionRow]]] = {
    selectByIds(productdescriptionids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.productdescriptionid, x)).toMap
      productdescriptionids.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[ProductdescriptionFields, ProductdescriptionRow] = {
    UpdateBuilder("production.productdescription", ProductdescriptionFields.structure, ProductdescriptionRow.read)
  }
  override def update(row: ProductdescriptionRow): ConnectionIO[Boolean] = {
    val productdescriptionid = row.productdescriptionid
    sql"""update production.productdescription
          set "description" = ${fromWrite(row.description)(Write.fromPut(Meta.StringMeta.put))},
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productdescriptionid" = ${fromWrite(productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductdescriptionRow): ConnectionIO[ProductdescriptionRow] = {
    sql"""insert into production.productdescription("productdescriptionid", "description", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.productdescriptionid)(Write.fromPut(ProductdescriptionId.put))}::int4,
            ${fromWrite(unsaved.description)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productdescriptionid")
          do update set
            "description" = EXCLUDED."description",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productdescriptionid", "description", "rowguid", "modifieddate"::text
       """.query(using ProductdescriptionRow.read).unique
  }
}
