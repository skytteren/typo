/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salestaxrate

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.stateprovince.StateprovinceId
import adventureworks.public.Name
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

class SalestaxrateRepoImpl extends SalestaxrateRepo {
  override def delete: DeleteBuilder[SalestaxrateFields, SalestaxrateRow] = {
    DeleteBuilder("sales.salestaxrate", SalestaxrateFields.structure)
  }
  override def deleteById(salestaxrateid: SalestaxrateId): ConnectionIO[Boolean] = {
    sql"""delete from sales.salestaxrate where "salestaxrateid" = ${fromWrite(salestaxrateid)(Write.fromPut(SalestaxrateId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(salestaxrateids: Array[SalestaxrateId]): ConnectionIO[Int] = {
    sql"""delete from sales.salestaxrate where "salestaxrateid" = ANY(${salestaxrateids})""".update.run
  }
  override def insert(unsaved: SalestaxrateRow): ConnectionIO[SalestaxrateRow] = {
    sql"""insert into sales.salestaxrate("salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.salestaxrateid)(Write.fromPut(SalestaxrateId.put))}::int4, ${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4, ${fromWrite(unsaved.taxtype)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.taxrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
       """.query(using SalestaxrateRow.read).unique
  }
  override def insert(unsaved: SalestaxrateRowUnsaved): ConnectionIO[SalestaxrateRow] = {
    val fs = List(
      Some((Fragment.const(s""""stateprovinceid""""), fr"${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4")),
      Some((Fragment.const(s""""taxtype""""), fr"${fromWrite(unsaved.taxtype)(Write.fromPut(TypoShort.put))}::int2")),
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      unsaved.salestaxrateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""salestaxrateid""""), fr"${fromWrite(value: SalestaxrateId)(Write.fromPut(SalestaxrateId.put))}::int4"))
      },
      unsaved.taxrate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""taxrate""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
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
      sql"""insert into sales.salestaxrate default values
            returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into sales.salestaxrate(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
         """
    }
    q.query(using SalestaxrateRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SalestaxrateRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.salestaxrate("salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using SalestaxrateRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalestaxrateRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.salestaxrate("stateprovinceid", "taxtype", "name", "salestaxrateid", "taxrate", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using SalestaxrateRowUnsaved.text)
  }
  override def select: SelectBuilder[SalestaxrateFields, SalestaxrateRow] = {
    SelectBuilderSql("sales.salestaxrate", SalestaxrateFields.structure, SalestaxrateRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SalestaxrateRow] = {
    sql"""select "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text from sales.salestaxrate""".query(using SalestaxrateRow.read).stream
  }
  override def selectById(salestaxrateid: SalestaxrateId): ConnectionIO[Option[SalestaxrateRow]] = {
    sql"""select "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text from sales.salestaxrate where "salestaxrateid" = ${fromWrite(salestaxrateid)(Write.fromPut(SalestaxrateId.put))}""".query(using SalestaxrateRow.read).option
  }
  override def selectByIds(salestaxrateids: Array[SalestaxrateId]): Stream[ConnectionIO, SalestaxrateRow] = {
    sql"""select "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text from sales.salestaxrate where "salestaxrateid" = ANY(${salestaxrateids})""".query(using SalestaxrateRow.read).stream
  }
  override def update: UpdateBuilder[SalestaxrateFields, SalestaxrateRow] = {
    UpdateBuilder("sales.salestaxrate", SalestaxrateFields.structure, SalestaxrateRow.read)
  }
  override def update(row: SalestaxrateRow): ConnectionIO[Boolean] = {
    val salestaxrateid = row.salestaxrateid
    sql"""update sales.salestaxrate
          set "stateprovinceid" = ${fromWrite(row.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4,
              "taxtype" = ${fromWrite(row.taxtype)(Write.fromPut(TypoShort.put))}::int2,
              "taxrate" = ${fromWrite(row.taxrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "salestaxrateid" = ${fromWrite(salestaxrateid)(Write.fromPut(SalestaxrateId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: SalestaxrateRow): ConnectionIO[SalestaxrateRow] = {
    sql"""insert into sales.salestaxrate("salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.salestaxrateid)(Write.fromPut(SalestaxrateId.put))}::int4,
            ${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4,
            ${fromWrite(unsaved.taxtype)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.taxrate)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("salestaxrateid")
          do update set
            "stateprovinceid" = EXCLUDED."stateprovinceid",
            "taxtype" = EXCLUDED."taxtype",
            "taxrate" = EXCLUDED."taxrate",
            "name" = EXCLUDED."name",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "salestaxrateid", "stateprovinceid", "taxtype", "taxrate", "name", "rowguid", "modifieddate"::text
       """.query(using SalestaxrateRow.read).unique
  }
}
