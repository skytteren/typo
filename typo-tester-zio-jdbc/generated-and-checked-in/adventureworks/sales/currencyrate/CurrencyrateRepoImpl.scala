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
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class CurrencyrateRepoImpl extends CurrencyrateRepo {
  override def delete: DeleteBuilder[CurrencyrateFields, CurrencyrateRow] = {
    DeleteBuilder("sales.currencyrate", CurrencyrateFields.structure)
  }
  override def deleteById(currencyrateid: CurrencyrateId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.currencyrate where "currencyrateid" = ${Segment.paramSegment(currencyrateid)(CurrencyrateId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(currencyrateids: Array[CurrencyrateId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from sales.currencyrate where "currencyrateid" = ANY(${currencyrateids})""".delete
  }
  override def insert(unsaved: CurrencyrateRow): ZIO[ZConnection, Throwable, CurrencyrateRow] = {
    sql"""insert into sales.currencyrate("currencyrateid", "currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate")
          values (${Segment.paramSegment(unsaved.currencyrateid)(CurrencyrateId.setter)}::int4, ${Segment.paramSegment(unsaved.currencyratedate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.fromcurrencycode)(CurrencyId.setter)}::bpchar, ${Segment.paramSegment(unsaved.tocurrencycode)(CurrencyId.setter)}::bpchar, ${Segment.paramSegment(unsaved.averagerate)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.endofdayrate)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text
       """.insertReturning(using CurrencyrateRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: CurrencyrateRowUnsaved): ZIO[ZConnection, Throwable, CurrencyrateRow] = {
    val fs = List(
      Some((sql""""currencyratedate"""", sql"${Segment.paramSegment(unsaved.currencyratedate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""fromcurrencycode"""", sql"${Segment.paramSegment(unsaved.fromcurrencycode)(CurrencyId.setter)}::bpchar")),
      Some((sql""""tocurrencycode"""", sql"${Segment.paramSegment(unsaved.tocurrencycode)(CurrencyId.setter)}::bpchar")),
      Some((sql""""averagerate"""", sql"${Segment.paramSegment(unsaved.averagerate)(Setter.bigDecimalScalaSetter)}::numeric")),
      Some((sql""""endofdayrate"""", sql"${Segment.paramSegment(unsaved.endofdayrate)(Setter.bigDecimalScalaSetter)}::numeric")),
      unsaved.currencyrateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""currencyrateid"""", sql"${Segment.paramSegment(value: CurrencyrateId)(CurrencyrateId.setter)}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.currencyrate default values
            returning "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.currencyrate($names) values ($values) returning "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text"""
    }
    q.insertReturning(using CurrencyrateRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CurrencyrateRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.currencyrate("currencyrateid", "currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate") FROM STDIN""", batchSize, unsaved)(CurrencyrateRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CurrencyrateRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.currencyrate("currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "currencyrateid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(CurrencyrateRowUnsaved.text)
  }
  override def select: SelectBuilder[CurrencyrateFields, CurrencyrateRow] = {
    SelectBuilderSql("sales.currencyrate", CurrencyrateFields.structure, CurrencyrateRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CurrencyrateRow] = {
    sql"""select "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text from sales.currencyrate""".query(using CurrencyrateRow.jdbcDecoder).selectStream()
  }
  override def selectById(currencyrateid: CurrencyrateId): ZIO[ZConnection, Throwable, Option[CurrencyrateRow]] = {
    sql"""select "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text from sales.currencyrate where "currencyrateid" = ${Segment.paramSegment(currencyrateid)(CurrencyrateId.setter)}""".query(using CurrencyrateRow.jdbcDecoder).selectOne
  }
  override def selectByIds(currencyrateids: Array[CurrencyrateId]): ZStream[ZConnection, Throwable, CurrencyrateRow] = {
    sql"""select "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text from sales.currencyrate where "currencyrateid" = ANY(${Segment.paramSegment(currencyrateids)(CurrencyrateId.arraySetter)})""".query(using CurrencyrateRow.jdbcDecoder).selectStream()
  }
  override def update: UpdateBuilder[CurrencyrateFields, CurrencyrateRow] = {
    UpdateBuilder("sales.currencyrate", CurrencyrateFields.structure, CurrencyrateRow.jdbcDecoder)
  }
  override def update(row: CurrencyrateRow): ZIO[ZConnection, Throwable, Boolean] = {
    val currencyrateid = row.currencyrateid
    sql"""update sales.currencyrate
          set "currencyratedate" = ${Segment.paramSegment(row.currencyratedate)(TypoLocalDateTime.setter)}::timestamp,
              "fromcurrencycode" = ${Segment.paramSegment(row.fromcurrencycode)(CurrencyId.setter)}::bpchar,
              "tocurrencycode" = ${Segment.paramSegment(row.tocurrencycode)(CurrencyId.setter)}::bpchar,
              "averagerate" = ${Segment.paramSegment(row.averagerate)(Setter.bigDecimalScalaSetter)}::numeric,
              "endofdayrate" = ${Segment.paramSegment(row.endofdayrate)(Setter.bigDecimalScalaSetter)}::numeric,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "currencyrateid" = ${Segment.paramSegment(currencyrateid)(CurrencyrateId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: CurrencyrateRow): ZIO[ZConnection, Throwable, UpdateResult[CurrencyrateRow]] = {
    sql"""insert into sales.currencyrate("currencyrateid", "currencyratedate", "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.currencyrateid)(CurrencyrateId.setter)}::int4,
            ${Segment.paramSegment(unsaved.currencyratedate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.fromcurrencycode)(CurrencyId.setter)}::bpchar,
            ${Segment.paramSegment(unsaved.tocurrencycode)(CurrencyId.setter)}::bpchar,
            ${Segment.paramSegment(unsaved.averagerate)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.endofdayrate)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("currencyrateid")
          do update set
            "currencyratedate" = EXCLUDED."currencyratedate",
            "fromcurrencycode" = EXCLUDED."fromcurrencycode",
            "tocurrencycode" = EXCLUDED."tocurrencycode",
            "averagerate" = EXCLUDED."averagerate",
            "endofdayrate" = EXCLUDED."endofdayrate",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "currencyrateid", "currencyratedate"::text, "fromcurrencycode", "tocurrencycode", "averagerate", "endofdayrate", "modifieddate"::text""".insertReturning(using CurrencyrateRow.jdbcDecoder)
  }
}
