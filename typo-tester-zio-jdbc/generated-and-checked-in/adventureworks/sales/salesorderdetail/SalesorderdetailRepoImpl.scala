/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderdetail

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.production.product.ProductId
import adventureworks.sales.salesorderheader.SalesorderheaderId
import adventureworks.sales.specialoffer.SpecialofferId
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

class SalesorderdetailRepoImpl extends SalesorderdetailRepo {
  override def delete: DeleteBuilder[SalesorderdetailFields, SalesorderdetailRow] = {
    DeleteBuilder("sales.salesorderdetail", SalesorderdetailFields.structure)
  }
  override def deleteById(compositeId: SalesorderdetailId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.salesorderdetail where "salesorderid" = ${Segment.paramSegment(compositeId.salesorderid)(SalesorderheaderId.setter)} AND "salesorderdetailid" = ${Segment.paramSegment(compositeId.salesorderdetailid)(Setter.intSetter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[SalesorderdetailId]): ZIO[ZConnection, Throwable, Long] = {
    val salesorderid = compositeIds.map(_.salesorderid)
    val salesorderdetailid = compositeIds.map(_.salesorderdetailid)
    sql"""delete
          from sales.salesorderdetail
          where ("salesorderid", "salesorderdetailid")
          in (select unnest(${salesorderid}), unnest(${salesorderdetailid}))
       """.delete
    
  }
  override def insert(unsaved: SalesorderdetailRow): ZIO[ZConnection, Throwable, SalesorderdetailRow] = {
    sql"""insert into sales.salesorderdetail("salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.salesorderid)(SalesorderheaderId.setter)}::int4, ${Segment.paramSegment(unsaved.salesorderdetailid)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.carriertrackingnumber)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.orderqty)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4, ${Segment.paramSegment(unsaved.specialofferid)(SpecialofferId.setter)}::int4, ${Segment.paramSegment(unsaved.unitprice)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.unitpricediscount)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text
       """.insertReturning(using SalesorderdetailRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: SalesorderdetailRowUnsaved): ZIO[ZConnection, Throwable, SalesorderdetailRow] = {
    val fs = List(
      Some((sql""""salesorderid"""", sql"${Segment.paramSegment(unsaved.salesorderid)(SalesorderheaderId.setter)}::int4")),
      Some((sql""""carriertrackingnumber"""", sql"${Segment.paramSegment(unsaved.carriertrackingnumber)(Setter.optionParamSetter(Setter.stringSetter))}")),
      Some((sql""""orderqty"""", sql"${Segment.paramSegment(unsaved.orderqty)(TypoShort.setter)}::int2")),
      Some((sql""""productid"""", sql"${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4")),
      Some((sql""""specialofferid"""", sql"${Segment.paramSegment(unsaved.specialofferid)(SpecialofferId.setter)}::int4")),
      Some((sql""""unitprice"""", sql"${Segment.paramSegment(unsaved.unitprice)(Setter.bigDecimalScalaSetter)}::numeric")),
      unsaved.salesorderdetailid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""salesorderdetailid"""", sql"${Segment.paramSegment(value: Int)(Setter.intSetter)}::int4"))
      },
      unsaved.unitpricediscount match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""unitpricediscount"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.salesorderdetail default values
            returning "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.salesorderdetail($names) values ($values) returning "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using SalesorderdetailRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderdetailRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salesorderdetail("salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SalesorderdetailRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderdetailRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salesorderdetail("salesorderid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "salesorderdetailid", "unitpricediscount", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SalesorderdetailRowUnsaved.text)
  }
  override def select: SelectBuilder[SalesorderdetailFields, SalesorderdetailRow] = {
    SelectBuilderSql("sales.salesorderdetail", SalesorderdetailFields.structure, SalesorderdetailRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SalesorderdetailRow] = {
    sql"""select "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text from sales.salesorderdetail""".query(using SalesorderdetailRow.jdbcDecoder).selectStream()
  }
  override def selectById(compositeId: SalesorderdetailId): ZIO[ZConnection, Throwable, Option[SalesorderdetailRow]] = {
    sql"""select "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text from sales.salesorderdetail where "salesorderid" = ${Segment.paramSegment(compositeId.salesorderid)(SalesorderheaderId.setter)} AND "salesorderdetailid" = ${Segment.paramSegment(compositeId.salesorderdetailid)(Setter.intSetter)}""".query(using SalesorderdetailRow.jdbcDecoder).selectOne
  }
  override def selectByIds(compositeIds: Array[SalesorderdetailId]): ZStream[ZConnection, Throwable, SalesorderdetailRow] = {
    val salesorderid = compositeIds.map(_.salesorderid)
    val salesorderdetailid = compositeIds.map(_.salesorderdetailid)
    sql"""select "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text
          from sales.salesorderdetail
          where ("salesorderid", "salesorderdetailid")
          in (select unnest(${salesorderid}), unnest(${salesorderdetailid}))
       """.query(using SalesorderdetailRow.jdbcDecoder).selectStream()
    
  }
  override def selectByIdsTracked(compositeIds: Array[SalesorderdetailId]): ZIO[ZConnection, Throwable, Map[SalesorderdetailId, SalesorderdetailRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[SalesorderdetailFields, SalesorderdetailRow] = {
    UpdateBuilder("sales.salesorderdetail", SalesorderdetailFields.structure, SalesorderdetailRow.jdbcDecoder)
  }
  override def update(row: SalesorderdetailRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update sales.salesorderdetail
          set "carriertrackingnumber" = ${Segment.paramSegment(row.carriertrackingnumber)(Setter.optionParamSetter(Setter.stringSetter))},
              "orderqty" = ${Segment.paramSegment(row.orderqty)(TypoShort.setter)}::int2,
              "productid" = ${Segment.paramSegment(row.productid)(ProductId.setter)}::int4,
              "specialofferid" = ${Segment.paramSegment(row.specialofferid)(SpecialofferId.setter)}::int4,
              "unitprice" = ${Segment.paramSegment(row.unitprice)(Setter.bigDecimalScalaSetter)}::numeric,
              "unitpricediscount" = ${Segment.paramSegment(row.unitpricediscount)(Setter.bigDecimalScalaSetter)}::numeric,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "salesorderid" = ${Segment.paramSegment(compositeId.salesorderid)(SalesorderheaderId.setter)} AND "salesorderdetailid" = ${Segment.paramSegment(compositeId.salesorderdetailid)(Setter.intSetter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: SalesorderdetailRow): ZIO[ZConnection, Throwable, UpdateResult[SalesorderdetailRow]] = {
    sql"""insert into sales.salesorderdetail("salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.salesorderid)(SalesorderheaderId.setter)}::int4,
            ${Segment.paramSegment(unsaved.salesorderdetailid)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.carriertrackingnumber)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.orderqty)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.productid)(ProductId.setter)}::int4,
            ${Segment.paramSegment(unsaved.specialofferid)(SpecialofferId.setter)}::int4,
            ${Segment.paramSegment(unsaved.unitprice)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.unitpricediscount)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("salesorderid", "salesorderdetailid")
          do update set
            "carriertrackingnumber" = EXCLUDED."carriertrackingnumber",
            "orderqty" = EXCLUDED."orderqty",
            "productid" = EXCLUDED."productid",
            "specialofferid" = EXCLUDED."specialofferid",
            "unitprice" = EXCLUDED."unitprice",
            "unitpricediscount" = EXCLUDED."unitpricediscount",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate"::text""".insertReturning(using SalesorderdetailRow.jdbcDecoder)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderdetailRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table salesorderdetail_TEMP (like sales.salesorderdetail) on commit drop".execute
    val copied = streamingInsert(s"""copy salesorderdetail_TEMP("salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(SalesorderdetailRow.text)
    val merged = sql"""insert into sales.salesorderdetail("salesorderid", "salesorderdetailid", "carriertrackingnumber", "orderqty", "productid", "specialofferid", "unitprice", "unitpricediscount", "rowguid", "modifieddate")
                       select * from salesorderdetail_TEMP
                       on conflict ("salesorderid", "salesorderdetailid")
                       do update set
                         "carriertrackingnumber" = EXCLUDED."carriertrackingnumber",
                         "orderqty" = EXCLUDED."orderqty",
                         "productid" = EXCLUDED."productid",
                         "specialofferid" = EXCLUDED."specialofferid",
                         "unitprice" = EXCLUDED."unitprice",
                         "unitpricediscount" = EXCLUDED."unitpricediscount",
                         "rowguid" = EXCLUDED."rowguid",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table salesorderdetail_TEMP;""".update
    created *> copied *> merged
  }
}
