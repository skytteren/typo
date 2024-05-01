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

class BillofmaterialsRepoImpl extends BillofmaterialsRepo {
  override def delete: DeleteBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    DeleteBuilder("production.billofmaterials", BillofmaterialsFields.structure)
  }
  override def deleteById(billofmaterialsid: Int): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.billofmaterials where "billofmaterialsid" = ${Segment.paramSegment(billofmaterialsid)(Setter.intSetter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(billofmaterialsids: Array[Int]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from production.billofmaterials where "billofmaterialsid" = ANY(${billofmaterialsids})""".delete
  }
  override def insert(unsaved: BillofmaterialsRow): ZIO[ZConnection, Throwable, BillofmaterialsRow] = {
    sql"""insert into production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")
          values (${Segment.paramSegment(unsaved.billofmaterialsid)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.productassemblyid)(Setter.optionParamSetter(ProductId.setter))}::int4, ${Segment.paramSegment(unsaved.componentid)(ProductId.setter)}::int4, ${Segment.paramSegment(unsaved.startdate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp, ${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar, ${Segment.paramSegment(unsaved.bomlevel)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.perassemblyqty)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
       """.insertReturning(using BillofmaterialsRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: BillofmaterialsRowUnsaved): ZIO[ZConnection, Throwable, BillofmaterialsRow] = {
    val fs = List(
      Some((sql""""productassemblyid"""", sql"${Segment.paramSegment(unsaved.productassemblyid)(Setter.optionParamSetter(ProductId.setter))}::int4")),
      Some((sql""""componentid"""", sql"${Segment.paramSegment(unsaved.componentid)(ProductId.setter)}::int4")),
      Some((sql""""enddate"""", sql"${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp")),
      Some((sql""""unitmeasurecode"""", sql"${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar")),
      Some((sql""""bomlevel"""", sql"${Segment.paramSegment(unsaved.bomlevel)(TypoShort.setter)}::int2")),
      unsaved.billofmaterialsid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""billofmaterialsid"""", sql"${Segment.paramSegment(value: Int)(Setter.intSetter)}::int4"))
      },
      unsaved.startdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""startdate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      },
      unsaved.perassemblyqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""perassemblyqty"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.billofmaterials default values
            returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.billofmaterials($names) values ($values) returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text"""
    }
    q.insertReturning(using BillofmaterialsRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, BillofmaterialsRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate") FROM STDIN""", batchSize, unsaved)(BillofmaterialsRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, BillofmaterialsRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.billofmaterials("productassemblyid", "componentid", "enddate", "unitmeasurecode", "bomlevel", "billofmaterialsid", "startdate", "perassemblyqty", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(BillofmaterialsRowUnsaved.text)
  }
  override def select: SelectBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    SelectBuilderSql("production.billofmaterials", BillofmaterialsFields.structure, BillofmaterialsRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, BillofmaterialsRow] = {
    sql"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text from production.billofmaterials""".query(using BillofmaterialsRow.jdbcDecoder).selectStream()
  }
  override def selectById(billofmaterialsid: Int): ZIO[ZConnection, Throwable, Option[BillofmaterialsRow]] = {
    sql"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text from production.billofmaterials where "billofmaterialsid" = ${Segment.paramSegment(billofmaterialsid)(Setter.intSetter)}""".query(using BillofmaterialsRow.jdbcDecoder).selectOne
  }
  override def selectByIds(billofmaterialsids: Array[Int]): ZStream[ZConnection, Throwable, BillofmaterialsRow] = {
    sql"""select "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text from production.billofmaterials where "billofmaterialsid" = ANY(${Segment.paramSegment(billofmaterialsids)(adventureworks.IntArraySetter)})""".query(using BillofmaterialsRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(billofmaterialsids: Array[Int]): ZIO[ZConnection, Throwable, Map[Int, Option[BillofmaterialsRow]]] = {
    selectByIds(billofmaterialsids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.billofmaterialsid, x)).toMap
      billofmaterialsids.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[BillofmaterialsFields, BillofmaterialsRow] = {
    UpdateBuilder("production.billofmaterials", BillofmaterialsFields.structure, BillofmaterialsRow.jdbcDecoder)
  }
  override def update(row: BillofmaterialsRow): ZIO[ZConnection, Throwable, Boolean] = {
    val billofmaterialsid = row.billofmaterialsid
    sql"""update production.billofmaterials
          set "productassemblyid" = ${Segment.paramSegment(row.productassemblyid)(Setter.optionParamSetter(ProductId.setter))}::int4,
              "componentid" = ${Segment.paramSegment(row.componentid)(ProductId.setter)}::int4,
              "startdate" = ${Segment.paramSegment(row.startdate)(TypoLocalDateTime.setter)}::timestamp,
              "enddate" = ${Segment.paramSegment(row.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
              "unitmeasurecode" = ${Segment.paramSegment(row.unitmeasurecode)(UnitmeasureId.setter)}::bpchar,
              "bomlevel" = ${Segment.paramSegment(row.bomlevel)(TypoShort.setter)}::int2,
              "perassemblyqty" = ${Segment.paramSegment(row.perassemblyqty)(Setter.bigDecimalScalaSetter)}::numeric,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "billofmaterialsid" = ${Segment.paramSegment(billofmaterialsid)(Setter.intSetter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: BillofmaterialsRow): ZIO[ZConnection, Throwable, UpdateResult[BillofmaterialsRow]] = {
    sql"""insert into production.billofmaterials("billofmaterialsid", "productassemblyid", "componentid", "startdate", "enddate", "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.billofmaterialsid)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.productassemblyid)(Setter.optionParamSetter(ProductId.setter))}::int4,
            ${Segment.paramSegment(unsaved.componentid)(ProductId.setter)}::int4,
            ${Segment.paramSegment(unsaved.startdate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.enddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
            ${Segment.paramSegment(unsaved.unitmeasurecode)(UnitmeasureId.setter)}::bpchar,
            ${Segment.paramSegment(unsaved.bomlevel)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.perassemblyqty)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
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
          returning "billofmaterialsid", "productassemblyid", "componentid", "startdate"::text, "enddate"::text, "unitmeasurecode", "bomlevel", "perassemblyqty", "modifieddate"::text""".insertReturning(using BillofmaterialsRow.jdbcDecoder)
  }
}
