/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currencyrate

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.sales.currency.CurrencyId
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

class CurrencyrateRepoImpl extends CurrencyrateRepo {
  override def delete: DeleteBuilder[CurrencyrateFields, CurrencyrateRow] = {
    DeleteBuilder("sales.currencyrate", CurrencyrateFields.structure)
  }
  override def deleteById(currencyrateid: CurrencyrateId): ConnectionIO[Boolean] = {
    sql"""delete from sales.currencyrate where "currencyrateid" = ${fromWrite(currencyrateid)(Write.fromPut(CurrencyrateId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(currencyrateids: Array[CurrencyrateId]): ConnectionIO[Int] = {
    sql"""delete from sales.currencyrate where "currencyrateid" = ANY(${currencyrateids})""".update.run
  }
  override def insert(unsaved: CurrencyrateRow): ConnectionIO[CurrencyrateRow] = {
    sql"""insert into sales.currencyrate("currencyrateid", "currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate")
          values (${fromWrite(unsaved.currencyrateid)(Write.fromPut(CurrencyrateId.put))}::int4, ${fromWrite(unsaved.currencyratedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.fromcurrencycode)(Write.fromPut(CurrencyId.put))}::bpchar, ${fromWrite(unsaved.tocurrencycode)(Write.fromPut(CurrencyId.put))}::bpchar, ${fromWrite(unsaved.averagerate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.endofdayrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text
       """.query(using CurrencyrateRow.read).unique
  }
  override def insert(unsaved: CurrencyrateRowUnsaved): ConnectionIO[CurrencyrateRow] = {
    val fs = List(
      Some((Fragment.const(s""""currencyratedate""""), fr"${fromWrite(unsaved.currencyratedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""fromcurrencycode""""), fr"${fromWrite(unsaved.fromcurrencycode)(Write.fromPut(CurrencyId.put))}::bpchar")),
      Some((Fragment.const(s""""tocurrencycode""""), fr"${fromWrite(unsaved.tocurrencycode)(Write.fromPut(CurrencyId.put))}::bpchar")),
      Some((Fragment.const(s""""averagerate""""), fr"${fromWrite(unsaved.averagerate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const(s""""endofdayrate""""), fr"${fromWrite(unsaved.endofdayrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      unsaved.currencyrateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""currencyrateid""""), fr"${fromWrite(value: CurrencyrateId)(Write.fromPut(CurrencyrateId.put))}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.currencyrate default values
            returning "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into sales.currencyrate(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text
         """
    }
    q.query(using CurrencyrateRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, CurrencyrateRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.currencyrate("currencyrateid", "currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using CurrencyrateRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CurrencyrateRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.currencyrate("currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "currencyrateid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using CurrencyrateRowUnsaved.text)
  }
  override def select: SelectBuilder[CurrencyrateFields, CurrencyrateRow] = {
    SelectBuilderSql("sales.currencyrate", CurrencyrateFields.structure, CurrencyrateRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CurrencyrateRow] = {
    sql"""select "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text from sales.currencyrate""".query(using CurrencyrateRow.read).stream
  }
  override def selectById(currencyrateid: CurrencyrateId): ConnectionIO[Option[CurrencyrateRow]] = {
    sql"""select "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text from sales.currencyrate where "currencyrateid" = ${fromWrite(currencyrateid)(Write.fromPut(CurrencyrateId.put))}""".query(using CurrencyrateRow.read).option
  }
  override def selectByIds(currencyrateids: Array[CurrencyrateId]): Stream[ConnectionIO, CurrencyrateRow] = {
    sql"""select "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text from sales.currencyrate where "currencyrateid" = ANY(${currencyrateids})""".query(using CurrencyrateRow.read).stream
  }
  override def selectByIdsTracked(currencyrateids: Array[CurrencyrateId]): ConnectionIO[Map[CurrencyrateId, Option[CurrencyrateRow]]] = {
    selectByIds(currencyrateids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.currencyrateid, x)).toMap
      currencyrateids.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[CurrencyrateFields, CurrencyrateRow] = {
    UpdateBuilder("sales.currencyrate", CurrencyrateFields.structure, CurrencyrateRow.read)
  }
  override def update(row: CurrencyrateRow): ConnectionIO[Boolean] = {
    val currencyrateid = row.currencyrateid
    sql"""update sales.currencyrate
          set "currencyratedate" = ${fromWrite(row.currencyratedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "fromcurrencycode" = ${fromWrite(row.fromcurrencycode)(Write.fromPut(CurrencyId.put))}::bpchar,
              "tocurrencycode" = ${fromWrite(row.tocurrencycode)(Write.fromPut(CurrencyId.put))}::bpchar,
              "averagerate" = ${fromWrite(row.averagerate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "endofdayrate" = ${fromWrite(row.endofdayrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "currencyrateid" = ${fromWrite(currencyrateid)(Write.fromPut(CurrencyrateId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: CurrencyrateRow): ConnectionIO[CurrencyrateRow] = {
    sql"""insert into sales.currencyrate("currencyrateid", "currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate")
          values (
            ${fromWrite(unsaved.currencyrateid)(Write.fromPut(CurrencyrateId.put))}::int4,
            ${fromWrite(unsaved.currencyratedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.fromcurrencycode)(Write.fromPut(CurrencyId.put))}::bpchar,
            ${fromWrite(unsaved.tocurrencycode)(Write.fromPut(CurrencyId.put))}::bpchar,
            ${fromWrite(unsaved.averagerate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.endofdayrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("currencyrateid")
          do update set
            "currencyratedate" = EXCLUDED."currencyratedate",
            "fromcurrencycode" = EXCLUDED."fromcurrencycode",
            "tocurrencycode" = EXCLUDED."tocurrencycode",
            "averagerate" = EXCLUDED."averagerate",
            "endofdayrate" = EXCLUDED."endofdayrate",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text
       """.query(using CurrencyrateRow.read).unique
  }
}
