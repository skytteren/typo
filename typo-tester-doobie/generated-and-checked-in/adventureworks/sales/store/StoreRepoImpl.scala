/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package store

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
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

class StoreRepoImpl extends StoreRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"""delete from sales.store where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[StoreFields, StoreRow] = {
    DeleteBuilder("sales.store", StoreFields)
  }
  override def insert(unsaved: StoreRow): ConnectionIO[StoreRow] = {
    sql"""insert into sales.store("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4, ${fromWrite(unsaved.demographics)(Write.fromPutOption(TypoXml.put))}::xml, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text
       """.query(StoreRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, StoreRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.store("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(StoreRow.text)
  }
  override def insert(unsaved: StoreRowUnsaved): ConnectionIO[StoreRow] = {
    val fs = List(
      Some((Fragment.const(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      Some((Fragment.const(s""""salespersonid""""), fr"${fromWrite(unsaved.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""demographics""""), fr"${fromWrite(unsaved.demographics)(Write.fromPutOption(TypoXml.put))}::xml")),
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
      sql"""insert into sales.store default values
            returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into sales.store(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text
         """
    }
    q.query(StoreRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, StoreRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.store("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(StoreRowUnsaved.text)
  }
  override def select: SelectBuilder[StoreFields, StoreRow] = {
    SelectBuilderSql("sales.store", StoreFields, StoreRow.read)
  }
  override def selectAll: Stream[ConnectionIO, StoreRow] = {
    sql"""select "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text from sales.store""".query(StoreRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[StoreRow]] = {
    sql"""select "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text from sales.store where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".query(StoreRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, StoreRow] = {
    sql"""select "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text from sales.store where "businessentityid" = ANY(${businessentityids})""".query(StoreRow.read).stream
  }
  override def update(row: StoreRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update sales.store
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "salespersonid" = ${fromWrite(row.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4,
              "demographics" = ${fromWrite(row.demographics)(Write.fromPutOption(TypoXml.put))}::xml,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[StoreFields, StoreRow] = {
    UpdateBuilder("sales.store", StoreFields, StoreRow.read)
  }
  override def upsert(unsaved: StoreRow): ConnectionIO[StoreRow] = {
    sql"""insert into sales.store("businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.salespersonid)(Write.fromPutOption(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.demographics)(Write.fromPutOption(TypoXml.put))}::xml,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "name" = EXCLUDED."name",
            "salespersonid" = EXCLUDED."salespersonid",
            "demographics" = EXCLUDED."demographics",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "name", "salespersonid", "demographics", "rowguid", "modifieddate"::text
       """.query(StoreRow.read).unique
  }
}
