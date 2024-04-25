/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.shipmethod.ShipmethodId
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

class PurchaseorderheaderRepoImpl extends PurchaseorderheaderRepo {
  override def delete: DeleteBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    DeleteBuilder("purchasing.purchaseorderheader", PurchaseorderheaderFields.structure)
  }
  override def deleteById(purchaseorderid: PurchaseorderheaderId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from purchasing.purchaseorderheader where "purchaseorderid" = ${Segment.paramSegment(purchaseorderid)(PurchaseorderheaderId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(purchaseorderids: Array[PurchaseorderheaderId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from purchasing.purchaseorderheader where "purchaseorderid" = ANY(${purchaseorderids})""".delete
  }
  override def insert(unsaved: PurchaseorderheaderRow): ZIO[ZConnection, Throwable, PurchaseorderheaderRow] = {
    sql"""insert into purchasing.purchaseorderheader("purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")
          values (${Segment.paramSegment(unsaved.purchaseorderid)(PurchaseorderheaderId.setter)}::int4, ${Segment.paramSegment(unsaved.revisionnumber)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.status)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.employeeid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.vendorid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.shipmethodid)(ShipmethodId.setter)}::int4, ${Segment.paramSegment(unsaved.orderdate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.shipdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp, ${Segment.paramSegment(unsaved.subtotal)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.taxamt)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.freight)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
       """.insertReturning(using PurchaseorderheaderRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: PurchaseorderheaderRowUnsaved): ZIO[ZConnection, Throwable, PurchaseorderheaderRow] = {
    val fs = List(
      Some((sql""""employeeid"""", sql"${Segment.paramSegment(unsaved.employeeid)(BusinessentityId.setter)}::int4")),
      Some((sql""""vendorid"""", sql"${Segment.paramSegment(unsaved.vendorid)(BusinessentityId.setter)}::int4")),
      Some((sql""""shipmethodid"""", sql"${Segment.paramSegment(unsaved.shipmethodid)(ShipmethodId.setter)}::int4")),
      Some((sql""""shipdate"""", sql"${Segment.paramSegment(unsaved.shipdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp")),
      unsaved.purchaseorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""purchaseorderid"""", sql"${Segment.paramSegment(value: PurchaseorderheaderId)(PurchaseorderheaderId.setter)}::int4"))
      },
      unsaved.revisionnumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""revisionnumber"""", sql"${Segment.paramSegment(value: TypoShort)(TypoShort.setter)}::int2"))
      },
      unsaved.status match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""status"""", sql"${Segment.paramSegment(value: TypoShort)(TypoShort.setter)}::int2"))
      },
      unsaved.orderdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""orderdate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      },
      unsaved.subtotal match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""subtotal"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
      unsaved.taxamt match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""taxamt"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
      unsaved.freight match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""freight"""", sql"${Segment.paramSegment(value: BigDecimal)(Setter.bigDecimalScalaSetter)}::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into purchasing.purchaseorderheader default values
            returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into purchasing.purchaseorderheader($names) values ($values) returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text"""
    }
    q.insertReturning(using PurchaseorderheaderRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PurchaseorderheaderRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY purchasing.purchaseorderheader("purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate") FROM STDIN""", batchSize, unsaved)(PurchaseorderheaderRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PurchaseorderheaderRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY purchasing.purchaseorderheader("employeeid", "vendorid", "shipmethodid", "shipdate", "purchaseorderid", "revisionnumber", "status", "orderdate", "subtotal", "taxamt", "freight", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PurchaseorderheaderRowUnsaved.text)
  }
  override def select: SelectBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    SelectBuilderSql("purchasing.purchaseorderheader", PurchaseorderheaderFields.structure, PurchaseorderheaderRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PurchaseorderheaderRow] = {
    sql"""select "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text from purchasing.purchaseorderheader""".query(using PurchaseorderheaderRow.jdbcDecoder).selectStream()
  }
  override def selectById(purchaseorderid: PurchaseorderheaderId): ZIO[ZConnection, Throwable, Option[PurchaseorderheaderRow]] = {
    sql"""select "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text from purchasing.purchaseorderheader where "purchaseorderid" = ${Segment.paramSegment(purchaseorderid)(PurchaseorderheaderId.setter)}""".query(using PurchaseorderheaderRow.jdbcDecoder).selectOne
  }
  override def selectByIds(purchaseorderids: Array[PurchaseorderheaderId]): ZStream[ZConnection, Throwable, PurchaseorderheaderRow] = {
    sql"""select "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text from purchasing.purchaseorderheader where "purchaseorderid" = ANY(${Segment.paramSegment(purchaseorderids)(PurchaseorderheaderId.arraySetter)})""".query(using PurchaseorderheaderRow.jdbcDecoder).selectStream()
  }
  override def update: UpdateBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    UpdateBuilder("purchasing.purchaseorderheader", PurchaseorderheaderFields.structure, PurchaseorderheaderRow.jdbcDecoder)
  }
  override def update(row: PurchaseorderheaderRow): ZIO[ZConnection, Throwable, Boolean] = {
    val purchaseorderid = row.purchaseorderid
    sql"""update purchasing.purchaseorderheader
          set "revisionnumber" = ${Segment.paramSegment(row.revisionnumber)(TypoShort.setter)}::int2,
              "status" = ${Segment.paramSegment(row.status)(TypoShort.setter)}::int2,
              "employeeid" = ${Segment.paramSegment(row.employeeid)(BusinessentityId.setter)}::int4,
              "vendorid" = ${Segment.paramSegment(row.vendorid)(BusinessentityId.setter)}::int4,
              "shipmethodid" = ${Segment.paramSegment(row.shipmethodid)(ShipmethodId.setter)}::int4,
              "orderdate" = ${Segment.paramSegment(row.orderdate)(TypoLocalDateTime.setter)}::timestamp,
              "shipdate" = ${Segment.paramSegment(row.shipdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
              "subtotal" = ${Segment.paramSegment(row.subtotal)(Setter.bigDecimalScalaSetter)}::numeric,
              "taxamt" = ${Segment.paramSegment(row.taxamt)(Setter.bigDecimalScalaSetter)}::numeric,
              "freight" = ${Segment.paramSegment(row.freight)(Setter.bigDecimalScalaSetter)}::numeric,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "purchaseorderid" = ${Segment.paramSegment(purchaseorderid)(PurchaseorderheaderId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: PurchaseorderheaderRow): ZIO[ZConnection, Throwable, UpdateResult[PurchaseorderheaderRow]] = {
    sql"""insert into purchasing.purchaseorderheader("purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.purchaseorderid)(PurchaseorderheaderId.setter)}::int4,
            ${Segment.paramSegment(unsaved.revisionnumber)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.status)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.employeeid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.vendorid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.shipmethodid)(ShipmethodId.setter)}::int4,
            ${Segment.paramSegment(unsaved.orderdate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.shipdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
            ${Segment.paramSegment(unsaved.subtotal)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.taxamt)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.freight)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("purchaseorderid")
          do update set
            "revisionnumber" = EXCLUDED."revisionnumber",
            "status" = EXCLUDED."status",
            "employeeid" = EXCLUDED."employeeid",
            "vendorid" = EXCLUDED."vendorid",
            "shipmethodid" = EXCLUDED."shipmethodid",
            "orderdate" = EXCLUDED."orderdate",
            "shipdate" = EXCLUDED."shipdate",
            "subtotal" = EXCLUDED."subtotal",
            "taxamt" = EXCLUDED."taxamt",
            "freight" = EXCLUDED."freight",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text""".insertReturning(using PurchaseorderheaderRow.jdbcDecoder)
  }
}
