/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
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

class BillofmaterialsRepoImpl extends BillofmaterialsRepo {
  override def delete(billofmaterialsid: BillofmaterialsId): ConnectionIO[Boolean] = {
    sql"""delete from production.billofmaterials where "billofmaterialsid" = ${fromWrite(billofmaterialsid)(Write.fromPut(BillofmaterialsId.put))}""".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    DeleteBuilder("production.billofmaterials", BillofmaterialsFields)
  }
  override def insert(unsaved: BillofmaterialsRow): ConnectionIO[BillofmaterialsRow] = {
    sql"""insert into production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")
          values (${fromWrite(unsaved.billofmaterialsid)(Write.fromPut(BillofmaterialsId.put))}::int4, ${fromWrite(unsaved.productassemblyid)(Write.fromPutOption(ProductId.put))}::int4, ${fromWrite(unsaved.componentid)(Write.fromPut(ProductId.put))}::int4, ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar, ${fromWrite(unsaved.bomlevel)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.perassemblyqty)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
       """.query(BillofmaterialsRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, BillofmaterialsRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(BillofmaterialsRow.text)
  }
  override def insert(unsaved: BillofmaterialsRowUnsaved): ConnectionIO[BillofmaterialsRow] = {
    val fs = List(
      Some((Fragment.const(s""""productassemblyid""""), fr"${fromWrite(unsaved.productassemblyid)(Write.fromPutOption(ProductId.put))}::int4")),
      Some((Fragment.const(s""""componentid""""), fr"${fromWrite(unsaved.componentid)(Write.fromPut(ProductId.put))}::int4")),
      Some((Fragment.const(s""""enddate""""), fr"${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp")),
      Some((Fragment.const(s""""unitmeasurecode""""), fr"${fromWrite(unsaved.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar")),
      Some((Fragment.const(s""""bomlevel""""), fr"${fromWrite(unsaved.bomlevel)(Write.fromPut(TypoShort.put))}::int2")),
      unsaved.billofmaterialsid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""billofmaterialsid""""), fr"${fromWrite(value: BillofmaterialsId)(Write.fromPut(BillofmaterialsId.put))}::int4"))
      },
      unsaved.startdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""startdate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      },
      unsaved.perassemblyqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""perassemblyqty""""), fr"${fromWrite(value: BigDecimal)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.billofmaterials default values
            returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.billofmaterials(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
         """
    }
    q.query(BillofmaterialsRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, BillofmaterialsRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.billofmaterials("productassemblyid", "componentid", "enddate", "unitmeasurecode", "bomlevel", "billofmaterialsid", "startdate", "perassemblyqty", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(BillofmaterialsRowUnsaved.text)
  }
  override def select: SelectBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    SelectBuilderSql("production.billofmaterials", BillofmaterialsFields, BillofmaterialsRow.read)
  }
  override def selectAll: Stream[ConnectionIO, BillofmaterialsRow] = {
    sql"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text from production.billofmaterials""".query(BillofmaterialsRow.read).stream
  }
  override def selectById(billofmaterialsid: BillofmaterialsId): ConnectionIO[Option[BillofmaterialsRow]] = {
    sql"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text from production.billofmaterials where "billofmaterialsid" = ${fromWrite(billofmaterialsid)(Write.fromPut(BillofmaterialsId.put))}""".query(BillofmaterialsRow.read).option
  }
  override def selectByIds(billofmaterialsids: Array[BillofmaterialsId]): Stream[ConnectionIO, BillofmaterialsRow] = {
    sql"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text from production.billofmaterials where "billofmaterialsid" = ANY(${billofmaterialsids})""".query(BillofmaterialsRow.read).stream
  }
  override def update(row: BillofmaterialsRow): ConnectionIO[Boolean] = {
    val billofmaterialsid = row.billofmaterialsid
    sql"""update production.billofmaterials
          set "productassemblyid" = ${fromWrite(row.productassemblyid)(Write.fromPutOption(ProductId.put))}::int4,
              "componentid" = ${fromWrite(row.componentid)(Write.fromPut(ProductId.put))}::int4,
              "startdate" = ${fromWrite(row.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
              "enddate" = ${fromWrite(row.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
              "unitmeasurecode" = ${fromWrite(row.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar,
              "bomlevel" = ${fromWrite(row.bomlevel)(Write.fromPut(TypoShort.put))}::int2,
              "perassemblyqty" = ${fromWrite(row.perassemblyqty)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "billofmaterialsid" = ${fromWrite(billofmaterialsid)(Write.fromPut(BillofmaterialsId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    UpdateBuilder("production.billofmaterials", BillofmaterialsFields, BillofmaterialsRow.read)
  }
  override def upsert(unsaved: BillofmaterialsRow): ConnectionIO[BillofmaterialsRow] = {
    sql"""insert into production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")
          values (
            ${fromWrite(unsaved.billofmaterialsid)(Write.fromPut(BillofmaterialsId.put))}::int4,
            ${fromWrite(unsaved.productassemblyid)(Write.fromPutOption(ProductId.put))}::int4,
            ${fromWrite(unsaved.componentid)(Write.fromPut(ProductId.put))}::int4,
            ${fromWrite(unsaved.startdate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.enddate)(Write.fromPutOption(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.unitmeasurecode)(Write.fromPut(UnitmeasureId.put))}::bpchar,
            ${fromWrite(unsaved.bomlevel)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.perassemblyqty)(Write.fromPut(Meta.ScalaBigDecimalMeta.put))}::numeric,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("billofmaterialsid")
          do update set
            "productassemblyid" = EXCLUDED."productassemblyid",
            "componentid" = EXCLUDED."componentid",
            "startdate" = EXCLUDED."startdate",
            "enddate" = EXCLUDED."enddate",
            "unitmeasurecode" = EXCLUDED."unitmeasurecode",
            "bomlevel" = EXCLUDED."bomlevel",
            "perassemblyqty" = EXCLUDED."perassemblyqty",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
       """.query(BillofmaterialsRow.read).unique
  }
}
