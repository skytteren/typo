/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.countryregion.CountryregionId
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

class SalesterritoryRepoImpl extends SalesterritoryRepo {
  override def delete: DeleteBuilder[SalesterritoryFields, SalesterritoryRow] = {
    DeleteBuilder("sales.salesterritory", SalesterritoryFields.structure)
  }
  override def deleteById(territoryid: SalesterritoryId): ConnectionIO[Boolean] = {
    sql"""delete from sales.salesterritory where "territoryid" = ${fromWrite(territoryid)(Write.fromPut(SalesterritoryId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(territoryids: Array[SalesterritoryId]): ConnectionIO[Int] = {
    sql"""delete from sales.salesterritory where "territoryid" = ANY(${territoryids})""".update.run
  }
  override def insert(unsaved: SalesterritoryRow): ConnectionIO[SalesterritoryRow] = {
    sql"""insert into sales.salesterritory("territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.territoryid)(Write.fromPut(SalesterritoryId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))}, ${fromWrite(unsaved.group)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.salesytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.saleslastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.costytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.costlastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text
       """.query(using SalesterritoryRow.read).unique
  }
  override def insert(unsaved: SalesterritoryRowUnsaved): ConnectionIO[SalesterritoryRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      Some((Fragment.const(s""""countryregioncode""""), fr"${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))}")),
      Some((Fragment.const(s""""group""""), fr"${fromWrite(unsaved.group)(Write.fromPut(Meta.StringMeta.put))}")),
      unsaved.territoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""territoryid""""), fr"${fromWrite(value: SalesterritoryId)(Write.fromPut(SalesterritoryId.put))}::int4"))
      },
      unsaved.salesytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""salesytd""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.saleslastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""saleslastyear""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.costytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""costytd""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.costlastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""costlastyear""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
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
      sql"""insert into sales.salesterritory default values
            returning "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into sales.salesterritory(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text
         """
    }
    q.query(using SalesterritoryRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, SalesterritoryRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.salesterritory("territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using SalesterritoryRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, SalesterritoryRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.salesterritory("name", "countryregioncode", "group", "territoryid", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using SalesterritoryRowUnsaved.text)
  }
  override def select: SelectBuilder[SalesterritoryFields, SalesterritoryRow] = {
    SelectBuilderSql("sales.salesterritory", SalesterritoryFields.structure, SalesterritoryRow.read)
  }
  override def selectAll: Stream[ConnectionIO, SalesterritoryRow] = {
    sql"""select "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text from sales.salesterritory""".query(using SalesterritoryRow.read).stream
  }
  override def selectById(territoryid: SalesterritoryId): ConnectionIO[Option[SalesterritoryRow]] = {
    sql"""select "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text from sales.salesterritory where "territoryid" = ${fromWrite(territoryid)(Write.fromPut(SalesterritoryId.put))}""".query(using SalesterritoryRow.read).option
  }
  override def selectByIds(territoryids: Array[SalesterritoryId]): Stream[ConnectionIO, SalesterritoryRow] = {
    sql"""select "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text from sales.salesterritory where "territoryid" = ANY(${territoryids})""".query(using SalesterritoryRow.read).stream
  }
  override def update: UpdateBuilder[SalesterritoryFields, SalesterritoryRow] = {
    UpdateBuilder("sales.salesterritory", SalesterritoryFields.structure, SalesterritoryRow.read)
  }
  override def update(row: SalesterritoryRow): ConnectionIO[Boolean] = {
    val territoryid = row.territoryid
    sql"""update sales.salesterritory
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "countryregioncode" = ${fromWrite(row.countryregioncode)(Write.fromPut(CountryregionId.put))},
              "group" = ${fromWrite(row.group)(Write.fromPut(Meta.StringMeta.put))},
              "salesytd" = ${fromWrite(row.salesytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "saleslastyear" = ${fromWrite(row.saleslastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "costytd" = ${fromWrite(row.costytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "costlastyear" = ${fromWrite(row.costlastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "territoryid" = ${fromWrite(territoryid)(Write.fromPut(SalesterritoryId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: SalesterritoryRow): ConnectionIO[SalesterritoryRow] = {
    sql"""insert into sales.salesterritory("territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.territoryid)(Write.fromPut(SalesterritoryId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))},
            ${fromWrite(unsaved.group)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.salesytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.saleslastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.costytd)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.costlastyear)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("territoryid")
          do update set
            "name" = EXCLUDED."name",
            "countryregioncode" = EXCLUDED."countryregioncode",
            "group" = EXCLUDED."group",
            "salesytd" = EXCLUDED."salesytd",
            "saleslastyear" = EXCLUDED."saleslastyear",
            "costytd" = EXCLUDED."costytd",
            "costlastyear" = EXCLUDED."costlastyear",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "territoryid", "name", "countryregioncode", "group", "salesytd", "saleslastyear", "costytd", "costlastyear", "rowguid", "modifieddate"::text
       """.query(using SalesterritoryRow.read).unique
  }
}
