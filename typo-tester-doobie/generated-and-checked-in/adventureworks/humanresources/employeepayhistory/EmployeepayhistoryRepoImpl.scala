/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
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

class EmployeepayhistoryRepoImpl extends EmployeepayhistoryRepo {
  override def delete: DeleteBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    DeleteBuilder("humanresources.employeepayhistory", EmployeepayhistoryFields.structure)
  }
  override def deleteById(compositeId: EmployeepayhistoryId): ConnectionIO[Boolean] = {
    sql"""delete from humanresources.employeepayhistory where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "ratechangedate" = ${fromWrite(compositeId.ratechangedate)(Write.fromPut(TypoLocalDateTime.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[EmployeepayhistoryId]): ConnectionIO[Int] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val ratechangedate = compositeIds.map(_.ratechangedate)
    sql"""delete
          from humanresources.employeepayhistory
          where ("businessentityid", "ratechangedate")
          in (select unnest(${businessentityid}), unnest(${ratechangedate}))
       """.update.run
    
  }
  override def insert(unsaved: EmployeepayhistoryRow): ConnectionIO[EmployeepayhistoryRow] = {
    sql"""insert into humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.ratechangedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.rate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.payfrequency)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
       """.query(using EmployeepayhistoryRow.read).unique
  }
  override def insert(unsaved: EmployeepayhistoryRowUnsaved): ConnectionIO[EmployeepayhistoryRow] = {
    val fs = List(
      Some((Fragment.const(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""ratechangedate""""), fr"${fromWrite(unsaved.ratechangedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""rate""""), fr"${fromWrite(unsaved.rate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric")),
      Some((Fragment.const(s""""payfrequency""""), fr"${fromWrite(unsaved.payfrequency)(Write.fromPut(TypoShort.put))}::int2")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.employeepayhistory default values
            returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into humanresources.employeepayhistory(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
         """
    }
    q.query(using EmployeepayhistoryRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, EmployeepayhistoryRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using EmployeepayhistoryRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, EmployeepayhistoryRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using EmployeepayhistoryRowUnsaved.text)
  }
  override def select: SelectBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    SelectBuilderSql("humanresources.employeepayhistory", EmployeepayhistoryFields.structure, EmployeepayhistoryRow.read)
  }
  override def selectAll: Stream[ConnectionIO, EmployeepayhistoryRow] = {
    sql"""select "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text from humanresources.employeepayhistory""".query(using EmployeepayhistoryRow.read).stream
  }
  override def selectById(compositeId: EmployeepayhistoryId): ConnectionIO[Option[EmployeepayhistoryRow]] = {
    sql"""select "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text from humanresources.employeepayhistory where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "ratechangedate" = ${fromWrite(compositeId.ratechangedate)(Write.fromPut(TypoLocalDateTime.put))}""".query(using EmployeepayhistoryRow.read).option
  }
  override def selectByIds(compositeIds: Array[EmployeepayhistoryId]): Stream[ConnectionIO, EmployeepayhistoryRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val ratechangedate = compositeIds.map(_.ratechangedate)
    sql"""select "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
          from humanresources.employeepayhistory
          where ("businessentityid", "ratechangedate") 
          in (select unnest(${businessentityid}), unnest(${ratechangedate}))
       """.query(using EmployeepayhistoryRow.read).stream
    
  }
  override def update: UpdateBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    UpdateBuilder("humanresources.employeepayhistory", EmployeepayhistoryFields.structure, EmployeepayhistoryRow.read)
  }
  override def update(row: EmployeepayhistoryRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update humanresources.employeepayhistory
          set "rate" = ${fromWrite(row.rate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "payfrequency" = ${fromWrite(row.payfrequency)(Write.fromPut(TypoShort.put))}::int2,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "ratechangedate" = ${fromWrite(compositeId.ratechangedate)(Write.fromPut(TypoLocalDateTime.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: EmployeepayhistoryRow): ConnectionIO[EmployeepayhistoryRow] = {
    sql"""insert into humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.ratechangedate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.rate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.payfrequency)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid", "ratechangedate")
          do update set
            "rate" = EXCLUDED."rate",
            "payfrequency" = EXCLUDED."payfrequency",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
       """.query(using EmployeepayhistoryRow.read).unique
  }
}
