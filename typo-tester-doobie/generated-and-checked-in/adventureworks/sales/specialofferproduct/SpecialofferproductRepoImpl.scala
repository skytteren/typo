/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialofferproduct

import adventureworks.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.sales.specialoffer.SpecialofferId
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object SpecialofferproductRepoImpl extends SpecialofferproductRepo {
  override def delete(compositeId: SpecialofferproductId): ConnectionIO[Boolean] = {
    sql"delete from sales.specialofferproduct where specialofferid = ${fromWrite(compositeId.specialofferid)(Write.fromPut(SpecialofferId.put))} AND productid = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    DeleteBuilder("sales.specialofferproduct", SpecialofferproductFields)
  }
  override def insert(unsaved: SpecialofferproductRow): ConnectionIO[SpecialofferproductRow] = {
    sql"""insert into sales.specialofferproduct(specialofferid, productid, rowguid, modifieddate)
          values (${fromWrite(unsaved.specialofferid)(Write.fromPut(SpecialofferId.put))}::int4, ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning specialofferid, productid, rowguid, modifieddate::text
       """.query(SpecialofferproductRow.read).unique
  }
  override def insert(unsaved: SpecialofferproductRowUnsaved): ConnectionIO[SpecialofferproductRow] = {
    val fs = List(
      Some((Fragment.const(s"specialofferid"), fr"${fromWrite(unsaved.specialofferid)(Write.fromPut(SpecialofferId.put))}::int4")),
      Some((Fragment.const(s"productid"), fr"${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.specialofferproduct default values
            returning specialofferid, productid, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.specialofferproduct(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning specialofferid, productid, rowguid, modifieddate::text
         """
    }
    q.query(SpecialofferproductRow.read).unique
    
  }
  override def select: SelectBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    SelectBuilderSql("sales.specialofferproduct", SpecialofferproductFields, SpecialofferproductRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SpecialofferproductRow] = {
    sql"select specialofferid, productid, rowguid, modifieddate::text from sales.specialofferproduct".query(SpecialofferproductRow.read).stream
  }
  override def selectById(compositeId: SpecialofferproductId): ConnectionIO[Option[SpecialofferproductRow]] = {
    sql"select specialofferid, productid, rowguid, modifieddate::text from sales.specialofferproduct where specialofferid = ${fromWrite(compositeId.specialofferid)(Write.fromPut(SpecialofferId.put))} AND productid = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))}".query(SpecialofferproductRow.read).option
  }
  override def update(row: SpecialofferproductRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update sales.specialofferproduct
          set rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where specialofferid = ${fromWrite(compositeId.specialofferid)(Write.fromPut(SpecialofferId.put))} AND productid = ${fromWrite(compositeId.productid)(Write.fromPut(ProductId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[SpecialofferproductFields, SpecialofferproductRow] = {
    UpdateBuilder("sales.specialofferproduct", SpecialofferproductFields, SpecialofferproductRow.read)
  }
  override def upsert(unsaved: SpecialofferproductRow): ConnectionIO[SpecialofferproductRow] = {
    sql"""insert into sales.specialofferproduct(specialofferid, productid, rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.specialofferid)(Write.fromPut(SpecialofferId.put))}::int4,
            ${fromWrite(unsaved.productid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict (specialofferid, productid)
          do update set
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning specialofferid, productid, rowguid, modifieddate::text
       """.query(SpecialofferproductRow.read).unique
  }
}