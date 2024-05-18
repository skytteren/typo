/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
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

class TransactionhistoryarchiveRepoImpl extends TransactionhistoryarchiveRepo {
  override def delete: DeleteBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    DeleteBuilder("production.transactionhistoryarchive", TransactionhistoryarchiveFields.structure)
  }
  override def deleteById(transactionid: TransactionhistoryarchiveId): ConnectionIO[Boolean] = {
    sql"""delete from production.transactionhistoryarchive where "transactionid" = ${fromWrite(transactionid)(Write.fromPut(TransactionhistoryarchiveId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(transactionids: Array[TransactionhistoryarchiveId]): ConnectionIO[Int] = {
    sql"""delete from production.transactionhistoryarchive where "transactionid" = ANY(${transactionids})""".update.run
  }
  override def insert(unsaved: TransactionhistoryarchiveRow): ConnectionIO[TransactionhistoryarchiveRow] = {
    sql"""insert into production.transactionhistoryarchive("transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")
          values (${fromWrite(unsaved.transactionid)(Write.fromPut(TransactionhistoryarchiveId.put))}::int4, ${fromWrite(unsaved.productid)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.referenceorderid)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.referenceorderlineid)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.transactiondate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.transactiontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.quantity)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.actualcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text
       """.query(using TransactionhistoryarchiveRow.read).unique
  }
  override def insert(unsaved: TransactionhistoryarchiveRowUnsaved): ConnectionIO[TransactionhistoryarchiveRow] = {
    val fs = List(
      Some((Fragment.const0(s""""transactionid""""), fr"${fromWrite(unsaved.transactionid)(Write.fromPut(TransactionhistoryarchiveId.put))}::int4")),
      Some((Fragment.const0(s""""productid""""), fr"${fromWrite(unsaved.productid)(Write.fromPut(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const0(s""""referenceorderid""""), fr"${fromWrite(unsaved.referenceorderid)(Write.fromPut(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const0(s""""transactiontype""""), fr"${fromWrite(unsaved.transactiontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const0(s""""quantity""""), fr"${fromWrite(unsaved.quantity)(Write.fromPut(Meta.IntMeta.put))}::int4")),
      Some((Fragment.const0(s""""actualcost""""), fr"${fromWrite(unsaved.actualcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      unsaved.referenceorderlineid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""referenceorderlineid""""), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int4"))
      },
      unsaved.transactiondate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""transactiondate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.transactionhistoryarchive default values
            returning "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.transactionhistoryarchive(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text
         """
    }
    q.query(using TransactionhistoryarchiveRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, TransactionhistoryarchiveRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.transactionhistoryarchive("transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using TransactionhistoryarchiveRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, TransactionhistoryarchiveRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.transactionhistoryarchive("transactionid", "productid", "referenceorderid", "transactiontype", "quantity", "actualcost", "referenceorderlineid", "transactiondate", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using TransactionhistoryarchiveRowUnsaved.text)
  }
  override def select: SelectBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    SelectBuilderSql("production.transactionhistoryarchive", TransactionhistoryarchiveFields.structure, TransactionhistoryarchiveRow.read)
  }
  override def selectAll: Stream[ConnectionIO, TransactionhistoryarchiveRow] = {
    sql"""select "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text from production.transactionhistoryarchive""".query(using TransactionhistoryarchiveRow.read).stream
  }
  override def selectById(transactionid: TransactionhistoryarchiveId): ConnectionIO[Option[TransactionhistoryarchiveRow]] = {
    sql"""select "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text from production.transactionhistoryarchive where "transactionid" = ${fromWrite(transactionid)(Write.fromPut(TransactionhistoryarchiveId.put))}""".query(using TransactionhistoryarchiveRow.read).option
  }
  override def selectByIds(transactionids: Array[TransactionhistoryarchiveId]): Stream[ConnectionIO, TransactionhistoryarchiveRow] = {
    sql"""select "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text from production.transactionhistoryarchive where "transactionid" = ANY(${transactionids})""".query(using TransactionhistoryarchiveRow.read).stream
  }
  override def selectByIdsTracked(transactionids: Array[TransactionhistoryarchiveId]): ConnectionIO[Map[TransactionhistoryarchiveId, TransactionhistoryarchiveRow]] = {
    selectByIds(transactionids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.transactionid, x)).toMap
      transactionids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[TransactionhistoryarchiveFields, TransactionhistoryarchiveRow] = {
    UpdateBuilder("production.transactionhistoryarchive", TransactionhistoryarchiveFields.structure, TransactionhistoryarchiveRow.read)
  }
  override def update(row: TransactionhistoryarchiveRow): ConnectionIO[Boolean] = {
    val transactionid = row.transactionid
    sql"""update production.transactionhistoryarchive
          set "productid" = ${fromWrite(row.productid)(Write.fromPut(Meta.IntMeta.put))}::int4,
              "referenceorderid" = ${fromWrite(row.referenceorderid)(Write.fromPut(Meta.IntMeta.put))}::int4,
              "referenceorderlineid" = ${fromWrite(row.referenceorderlineid)(Write.fromPut(Meta.IntMeta.put))}::int4,
              "transactiondate" = ${fromWrite(row.transactiondate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "transactiontype" = ${fromWrite(row.transactiontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
              "quantity" = ${fromWrite(row.quantity)(Write.fromPut(Meta.IntMeta.put))}::int4,
              "actualcost" = ${fromWrite(row.actualcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "transactionid" = ${fromWrite(transactionid)(Write.fromPut(TransactionhistoryarchiveId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: TransactionhistoryarchiveRow): ConnectionIO[TransactionhistoryarchiveRow] = {
    sql"""insert into production.transactionhistoryarchive("transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate", "transactiontype", "quantity", "actualcost", "modifieddate")
          values (
            ${fromWrite(unsaved.transactionid)(Write.fromPut(TransactionhistoryarchiveId.put))}::int4,
            ${fromWrite(unsaved.productid)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.referenceorderid)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.referenceorderlineid)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.transactiondate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.transactiontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.quantity)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.actualcost)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("transactionid")
          do update set
            "productid" = EXCLUDED."productid",
            "referenceorderid" = EXCLUDED."referenceorderid",
            "referenceorderlineid" = EXCLUDED."referenceorderlineid",
            "transactiondate" = EXCLUDED."transactiondate",
            "transactiontype" = EXCLUDED."transactiontype",
            "quantity" = EXCLUDED."quantity",
            "actualcost" = EXCLUDED."actualcost",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "transactionid", "productid", "referenceorderid", "referenceorderlineid", "transactiondate"::text, "transactiontype", "quantity", "actualcost", "modifieddate"::text
       """.query(using TransactionhistoryarchiveRow.read).unique
  }
}
