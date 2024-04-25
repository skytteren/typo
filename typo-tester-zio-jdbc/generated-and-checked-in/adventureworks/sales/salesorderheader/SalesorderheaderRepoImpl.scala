/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.address.AddressId
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.OrderNumber
import adventureworks.purchasing.shipmethod.ShipmethodId
import adventureworks.sales.currencyrate.CurrencyrateId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesterritory.SalesterritoryId
import adventureworks.streamingInsert
import adventureworks.userdefined.CustomCreditcardId
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

class SalesorderheaderRepoImpl extends SalesorderheaderRepo {
  override def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    DeleteBuilder("sales.salesorderheader", SalesorderheaderFields.structure)
  }
  override def deleteById(salesorderid: SalesorderheaderId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.salesorderheader where "salesorderid" = ${Segment.paramSegment(salesorderid)(SalesorderheaderId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(salesorderids: Array[SalesorderheaderId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from sales.salesorderheader where "salesorderid" = ANY(${salesorderids})""".delete
  }
  override def insert(unsaved: SalesorderheaderRow): ZIO[ZConnection, Throwable, SalesorderheaderRow] = {
    sql"""insert into sales.salesorderheader("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.salesorderid)(SalesorderheaderId.setter)}::int4, ${Segment.paramSegment(unsaved.revisionnumber)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.orderdate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.duedate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.shipdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp, ${Segment.paramSegment(unsaved.status)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.onlineorderflag)(Flag.setter)}::bool, ${Segment.paramSegment(unsaved.purchaseordernumber)(Setter.optionParamSetter(OrderNumber.setter))}::varchar, ${Segment.paramSegment(unsaved.accountnumber)(Setter.optionParamSetter(AccountNumber.setter))}::varchar, ${Segment.paramSegment(unsaved.customerid)(CustomerId.setter)}::int4, ${Segment.paramSegment(unsaved.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4, ${Segment.paramSegment(unsaved.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4, ${Segment.paramSegment(unsaved.billtoaddressid)(AddressId.setter)}::int4, ${Segment.paramSegment(unsaved.shiptoaddressid)(AddressId.setter)}::int4, ${Segment.paramSegment(unsaved.shipmethodid)(ShipmethodId.setter)}::int4, ${Segment.paramSegment(unsaved.creditcardid)(Setter.optionParamSetter(CustomCreditcardId.setter))}::int4, ${Segment.paramSegment(unsaved.creditcardapprovalcode)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.currencyrateid)(Setter.optionParamSetter(CurrencyrateId.setter))}::int4, ${Segment.paramSegment(unsaved.subtotal)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.taxamt)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.freight)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.totaldue)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric, ${Segment.paramSegment(unsaved.comment)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
       """.insertReturning(using SalesorderheaderRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: SalesorderheaderRowUnsaved): ZIO[ZConnection, Throwable, SalesorderheaderRow] = {
    val fs = List(
      Some((sql""""duedate"""", sql"${Segment.paramSegment(unsaved.duedate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""shipdate"""", sql"${Segment.paramSegment(unsaved.shipdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp")),
      Some((sql""""purchaseordernumber"""", sql"${Segment.paramSegment(unsaved.purchaseordernumber)(Setter.optionParamSetter(OrderNumber.setter))}::varchar")),
      Some((sql""""accountnumber"""", sql"${Segment.paramSegment(unsaved.accountnumber)(Setter.optionParamSetter(AccountNumber.setter))}::varchar")),
      Some((sql""""customerid"""", sql"${Segment.paramSegment(unsaved.customerid)(CustomerId.setter)}::int4")),
      Some((sql""""salespersonid"""", sql"${Segment.paramSegment(unsaved.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4")),
      Some((sql""""territoryid"""", sql"${Segment.paramSegment(unsaved.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4")),
      Some((sql""""billtoaddressid"""", sql"${Segment.paramSegment(unsaved.billtoaddressid)(AddressId.setter)}::int4")),
      Some((sql""""shiptoaddressid"""", sql"${Segment.paramSegment(unsaved.shiptoaddressid)(AddressId.setter)}::int4")),
      Some((sql""""shipmethodid"""", sql"${Segment.paramSegment(unsaved.shipmethodid)(ShipmethodId.setter)}::int4")),
      Some((sql""""creditcardid"""", sql"${Segment.paramSegment(unsaved.creditcardid)(Setter.optionParamSetter(CustomCreditcardId.setter))}::int4")),
      Some((sql""""creditcardapprovalcode"""", sql"${Segment.paramSegment(unsaved.creditcardapprovalcode)(Setter.optionParamSetter(Setter.stringSetter))}")),
      Some((sql""""currencyrateid"""", sql"${Segment.paramSegment(unsaved.currencyrateid)(Setter.optionParamSetter(CurrencyrateId.setter))}::int4")),
      Some((sql""""totaldue"""", sql"${Segment.paramSegment(unsaved.totaldue)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric")),
      Some((sql""""comment"""", sql"${Segment.paramSegment(unsaved.comment)(Setter.optionParamSetter(Setter.stringSetter))}")),
      unsaved.salesorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""salesorderid"""", sql"${Segment.paramSegment(value: SalesorderheaderId)(SalesorderheaderId.setter)}::int4"))
      },
      unsaved.revisionnumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""revisionnumber"""", sql"${Segment.paramSegment(value: TypoShort)(TypoShort.setter)}::int2"))
      },
      unsaved.orderdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""orderdate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      },
      unsaved.status match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""status"""", sql"${Segment.paramSegment(value: TypoShort)(TypoShort.setter)}::int2"))
      },
      unsaved.onlineorderflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""onlineorderflag"""", sql"${Segment.paramSegment(value: Flag)(Flag.setter)}::bool"))
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
      sql"""insert into sales.salesorderheader default values
            returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.salesorderheader($names) values ($values) returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using SalesorderheaderRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderheaderRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salesorderheader("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SalesorderheaderRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalesorderheaderRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salesorderheader("duedate", "shipdate", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "totaldue", "comment", "salesorderid", "revisionnumber", "orderdate", "status", "onlineorderflag", "subtotal", "taxamt", "freight", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SalesorderheaderRowUnsaved.text)
  }
  override def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    SelectBuilderSql("sales.salesorderheader", SalesorderheaderFields.structure, SalesorderheaderRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SalesorderheaderRow] = {
    sql"""select "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text from sales.salesorderheader""".query(using SalesorderheaderRow.jdbcDecoder).selectStream()
  }
  override def selectById(salesorderid: SalesorderheaderId): ZIO[ZConnection, Throwable, Option[SalesorderheaderRow]] = {
    sql"""select "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text from sales.salesorderheader where "salesorderid" = ${Segment.paramSegment(salesorderid)(SalesorderheaderId.setter)}""".query(using SalesorderheaderRow.jdbcDecoder).selectOne
  }
  override def selectByIds(salesorderids: Array[SalesorderheaderId]): ZStream[ZConnection, Throwable, SalesorderheaderRow] = {
    sql"""select "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text from sales.salesorderheader where "salesorderid" = ANY(${Segment.paramSegment(salesorderids)(SalesorderheaderId.arraySetter)})""".query(using SalesorderheaderRow.jdbcDecoder).selectStream()
  }
  override def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    UpdateBuilder("sales.salesorderheader", SalesorderheaderFields.structure, SalesorderheaderRow.jdbcDecoder)
  }
  override def update(row: SalesorderheaderRow): ZIO[ZConnection, Throwable, Boolean] = {
    val salesorderid = row.salesorderid
    sql"""update sales.salesorderheader
          set "revisionnumber" = ${Segment.paramSegment(row.revisionnumber)(TypoShort.setter)}::int2,
              "orderdate" = ${Segment.paramSegment(row.orderdate)(TypoLocalDateTime.setter)}::timestamp,
              "duedate" = ${Segment.paramSegment(row.duedate)(TypoLocalDateTime.setter)}::timestamp,
              "shipdate" = ${Segment.paramSegment(row.shipdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
              "status" = ${Segment.paramSegment(row.status)(TypoShort.setter)}::int2,
              "onlineorderflag" = ${Segment.paramSegment(row.onlineorderflag)(Flag.setter)}::bool,
              "purchaseordernumber" = ${Segment.paramSegment(row.purchaseordernumber)(Setter.optionParamSetter(OrderNumber.setter))}::varchar,
              "accountnumber" = ${Segment.paramSegment(row.accountnumber)(Setter.optionParamSetter(AccountNumber.setter))}::varchar,
              "customerid" = ${Segment.paramSegment(row.customerid)(CustomerId.setter)}::int4,
              "salespersonid" = ${Segment.paramSegment(row.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
              "territoryid" = ${Segment.paramSegment(row.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4,
              "billtoaddressid" = ${Segment.paramSegment(row.billtoaddressid)(AddressId.setter)}::int4,
              "shiptoaddressid" = ${Segment.paramSegment(row.shiptoaddressid)(AddressId.setter)}::int4,
              "shipmethodid" = ${Segment.paramSegment(row.shipmethodid)(ShipmethodId.setter)}::int4,
              "creditcardid" = ${Segment.paramSegment(row.creditcardid)(Setter.optionParamSetter(CustomCreditcardId.setter))}::int4,
              "creditcardapprovalcode" = ${Segment.paramSegment(row.creditcardapprovalcode)(Setter.optionParamSetter(Setter.stringSetter))},
              "currencyrateid" = ${Segment.paramSegment(row.currencyrateid)(Setter.optionParamSetter(CurrencyrateId.setter))}::int4,
              "subtotal" = ${Segment.paramSegment(row.subtotal)(Setter.bigDecimalScalaSetter)}::numeric,
              "taxamt" = ${Segment.paramSegment(row.taxamt)(Setter.bigDecimalScalaSetter)}::numeric,
              "freight" = ${Segment.paramSegment(row.freight)(Setter.bigDecimalScalaSetter)}::numeric,
              "totaldue" = ${Segment.paramSegment(row.totaldue)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
              "comment" = ${Segment.paramSegment(row.comment)(Setter.optionParamSetter(Setter.stringSetter))},
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "salesorderid" = ${Segment.paramSegment(salesorderid)(SalesorderheaderId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: SalesorderheaderRow): ZIO[ZConnection, Throwable, UpdateResult[SalesorderheaderRow]] = {
    sql"""insert into sales.salesorderheader("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.salesorderid)(SalesorderheaderId.setter)}::int4,
            ${Segment.paramSegment(unsaved.revisionnumber)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.orderdate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.duedate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.shipdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
            ${Segment.paramSegment(unsaved.status)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.onlineorderflag)(Flag.setter)}::bool,
            ${Segment.paramSegment(unsaved.purchaseordernumber)(Setter.optionParamSetter(OrderNumber.setter))}::varchar,
            ${Segment.paramSegment(unsaved.accountnumber)(Setter.optionParamSetter(AccountNumber.setter))}::varchar,
            ${Segment.paramSegment(unsaved.customerid)(CustomerId.setter)}::int4,
            ${Segment.paramSegment(unsaved.salespersonid)(Setter.optionParamSetter(BusinessentityId.setter))}::int4,
            ${Segment.paramSegment(unsaved.territoryid)(Setter.optionParamSetter(SalesterritoryId.setter))}::int4,
            ${Segment.paramSegment(unsaved.billtoaddressid)(AddressId.setter)}::int4,
            ${Segment.paramSegment(unsaved.shiptoaddressid)(AddressId.setter)}::int4,
            ${Segment.paramSegment(unsaved.shipmethodid)(ShipmethodId.setter)}::int4,
            ${Segment.paramSegment(unsaved.creditcardid)(Setter.optionParamSetter(CustomCreditcardId.setter))}::int4,
            ${Segment.paramSegment(unsaved.creditcardapprovalcode)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.currencyrateid)(Setter.optionParamSetter(CurrencyrateId.setter))}::int4,
            ${Segment.paramSegment(unsaved.subtotal)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.taxamt)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.freight)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.totaldue)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
            ${Segment.paramSegment(unsaved.comment)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("salesorderid")
          do update set
            "revisionnumber" = EXCLUDED."revisionnumber",
            "orderdate" = EXCLUDED."orderdate",
            "duedate" = EXCLUDED."duedate",
            "shipdate" = EXCLUDED."shipdate",
            "status" = EXCLUDED."status",
            "onlineorderflag" = EXCLUDED."onlineorderflag",
            "purchaseordernumber" = EXCLUDED."purchaseordernumber",
            "accountnumber" = EXCLUDED."accountnumber",
            "customerid" = EXCLUDED."customerid",
            "salespersonid" = EXCLUDED."salespersonid",
            "territoryid" = EXCLUDED."territoryid",
            "billtoaddressid" = EXCLUDED."billtoaddressid",
            "shiptoaddressid" = EXCLUDED."shiptoaddressid",
            "shipmethodid" = EXCLUDED."shipmethodid",
            "creditcardid" = EXCLUDED."creditcardid",
            "creditcardapprovalcode" = EXCLUDED."creditcardapprovalcode",
            "currencyrateid" = EXCLUDED."currencyrateid",
            "subtotal" = EXCLUDED."subtotal",
            "taxamt" = EXCLUDED."taxamt",
            "freight" = EXCLUDED."freight",
            "totaldue" = EXCLUDED."totaldue",
            "comment" = EXCLUDED."comment",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text""".insertReturning(using SalesorderheaderRow.jdbcDecoder)
  }
}
