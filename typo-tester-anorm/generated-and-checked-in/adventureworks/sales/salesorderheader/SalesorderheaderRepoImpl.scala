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
import anorm.NamedParameter
import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class SalesorderheaderRepoImpl extends SalesorderheaderRepo {
  override def delete(salesorderid: SalesorderheaderId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.salesorderheader where "salesorderid" = ${ParameterValue(salesorderid, null, SalesorderheaderId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(salesorderids: Array[SalesorderheaderId])(implicit c: Connection): Int = {
    SQL"""delete
          from sales.salesorderheader
          where "salesorderid" = ANY(${salesorderids})
       """.executeUpdate()
    
  }
  override def delete: DeleteBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    DeleteBuilder("sales.salesorderheader", SalesorderheaderFields.structure)
  }
  override def insert(unsaved: SalesorderheaderRow)(implicit c: Connection): SalesorderheaderRow = {
    SQL"""insert into sales.salesorderheader("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.salesorderid, null, SalesorderheaderId.toStatement)}::int4, ${ParameterValue(unsaved.revisionnumber, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.orderdate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.duedate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.shipdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.status, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.onlineorderflag, null, Flag.toStatement)}::bool, ${ParameterValue(unsaved.purchaseordernumber, null, ToStatement.optionToStatement(OrderNumber.toStatement, OrderNumber.parameterMetadata))}::varchar, ${ParameterValue(unsaved.accountnumber, null, ToStatement.optionToStatement(AccountNumber.toStatement, AccountNumber.parameterMetadata))}::varchar, ${ParameterValue(unsaved.customerid, null, CustomerId.toStatement)}::int4, ${ParameterValue(unsaved.salespersonid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))}::int4, ${ParameterValue(unsaved.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))}::int4, ${ParameterValue(unsaved.billtoaddressid, null, AddressId.toStatement)}::int4, ${ParameterValue(unsaved.shiptoaddressid, null, AddressId.toStatement)}::int4, ${ParameterValue(unsaved.shipmethodid, null, ShipmethodId.toStatement)}::int4, ${ParameterValue(unsaved.creditcardid, null, ToStatement.optionToStatement(CustomCreditcardId.toStatement, CustomCreditcardId.parameterMetadata))}::int4, ${ParameterValue(unsaved.creditcardapprovalcode, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.currencyrateid, null, ToStatement.optionToStatement(CurrencyrateId.toStatement, CurrencyrateId.parameterMetadata))}::int4, ${ParameterValue(unsaved.subtotal, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.taxamt, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.freight, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.totaldue, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric, ${ParameterValue(unsaved.comment, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalesorderheaderRow.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[SalesorderheaderRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.salesorderheader("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(SalesorderheaderRow.text, c)
  }
  override def insert(unsaved: SalesorderheaderRowUnsaved)(implicit c: Connection): SalesorderheaderRow = {
    val namedParameters = List(
      Some((NamedParameter("duedate", ParameterValue(unsaved.duedate, null, TypoLocalDateTime.toStatement)), "::timestamp")),
      Some((NamedParameter("shipdate", ParameterValue(unsaved.shipdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))), "::timestamp")),
      Some((NamedParameter("purchaseordernumber", ParameterValue(unsaved.purchaseordernumber, null, ToStatement.optionToStatement(OrderNumber.toStatement, OrderNumber.parameterMetadata))), "::varchar")),
      Some((NamedParameter("accountnumber", ParameterValue(unsaved.accountnumber, null, ToStatement.optionToStatement(AccountNumber.toStatement, AccountNumber.parameterMetadata))), "::varchar")),
      Some((NamedParameter("customerid", ParameterValue(unsaved.customerid, null, CustomerId.toStatement)), "::int4")),
      Some((NamedParameter("salespersonid", ParameterValue(unsaved.salespersonid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))), "::int4")),
      Some((NamedParameter("territoryid", ParameterValue(unsaved.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))), "::int4")),
      Some((NamedParameter("billtoaddressid", ParameterValue(unsaved.billtoaddressid, null, AddressId.toStatement)), "::int4")),
      Some((NamedParameter("shiptoaddressid", ParameterValue(unsaved.shiptoaddressid, null, AddressId.toStatement)), "::int4")),
      Some((NamedParameter("shipmethodid", ParameterValue(unsaved.shipmethodid, null, ShipmethodId.toStatement)), "::int4")),
      Some((NamedParameter("creditcardid", ParameterValue(unsaved.creditcardid, null, ToStatement.optionToStatement(CustomCreditcardId.toStatement, CustomCreditcardId.parameterMetadata))), "::int4")),
      Some((NamedParameter("creditcardapprovalcode", ParameterValue(unsaved.creditcardapprovalcode, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      Some((NamedParameter("currencyrateid", ParameterValue(unsaved.currencyrateid, null, ToStatement.optionToStatement(CurrencyrateId.toStatement, CurrencyrateId.parameterMetadata))), "::int4")),
      Some((NamedParameter("totaldue", ParameterValue(unsaved.totaldue, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))), "::numeric")),
      Some((NamedParameter("comment", ParameterValue(unsaved.comment, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      unsaved.salesorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("salesorderid", ParameterValue(value, null, SalesorderheaderId.toStatement)), "::int4"))
      },
      unsaved.revisionnumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("revisionnumber", ParameterValue(value, null, TypoShort.toStatement)), "::int2"))
      },
      unsaved.orderdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("orderdate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      },
      unsaved.status match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("status", ParameterValue(value, null, TypoShort.toStatement)), "::int2"))
      },
      unsaved.onlineorderflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("onlineorderflag", ParameterValue(value, null, Flag.toStatement)), "::bool"))
      },
      unsaved.subtotal match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("subtotal", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.taxamt match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("taxamt", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.freight match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("freight", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, TypoUUID.toStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.salesorderheader default values
            returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
         """
        .executeInsert(SalesorderheaderRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.salesorderheader(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(SalesorderheaderRow.rowParser(1).single)
    }
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[SalesorderheaderRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.salesorderheader("duedate", "shipdate", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "totaldue", "comment", "salesorderid", "revisionnumber", "orderdate", "status", "onlineorderflag", "subtotal", "taxamt", "freight", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SalesorderheaderRowUnsaved.text, c)
  }
  override def select: SelectBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    SelectBuilderSql("sales.salesorderheader", SalesorderheaderFields.structure, SalesorderheaderRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[SalesorderheaderRow] = {
    SQL"""select "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
          from sales.salesorderheader
       """.as(SalesorderheaderRow.rowParser(1).*)
  }
  override def selectById(salesorderid: SalesorderheaderId)(implicit c: Connection): Option[SalesorderheaderRow] = {
    SQL"""select "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
          from sales.salesorderheader
          where "salesorderid" = ${ParameterValue(salesorderid, null, SalesorderheaderId.toStatement)}
       """.as(SalesorderheaderRow.rowParser(1).singleOpt)
  }
  override def selectByIds(salesorderids: Array[SalesorderheaderId])(implicit c: Connection): List[SalesorderheaderRow] = {
    SQL"""select "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
          from sales.salesorderheader
          where "salesorderid" = ANY(${salesorderids})
       """.as(SalesorderheaderRow.rowParser(1).*)
    
  }
  override def update(row: SalesorderheaderRow)(implicit c: Connection): Boolean = {
    val salesorderid = row.salesorderid
    SQL"""update sales.salesorderheader
          set "revisionnumber" = ${ParameterValue(row.revisionnumber, null, TypoShort.toStatement)}::int2,
              "orderdate" = ${ParameterValue(row.orderdate, null, TypoLocalDateTime.toStatement)}::timestamp,
              "duedate" = ${ParameterValue(row.duedate, null, TypoLocalDateTime.toStatement)}::timestamp,
              "shipdate" = ${ParameterValue(row.shipdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
              "status" = ${ParameterValue(row.status, null, TypoShort.toStatement)}::int2,
              "onlineorderflag" = ${ParameterValue(row.onlineorderflag, null, Flag.toStatement)}::bool,
              "purchaseordernumber" = ${ParameterValue(row.purchaseordernumber, null, ToStatement.optionToStatement(OrderNumber.toStatement, OrderNumber.parameterMetadata))}::varchar,
              "accountnumber" = ${ParameterValue(row.accountnumber, null, ToStatement.optionToStatement(AccountNumber.toStatement, AccountNumber.parameterMetadata))}::varchar,
              "customerid" = ${ParameterValue(row.customerid, null, CustomerId.toStatement)}::int4,
              "salespersonid" = ${ParameterValue(row.salespersonid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))}::int4,
              "territoryid" = ${ParameterValue(row.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))}::int4,
              "billtoaddressid" = ${ParameterValue(row.billtoaddressid, null, AddressId.toStatement)}::int4,
              "shiptoaddressid" = ${ParameterValue(row.shiptoaddressid, null, AddressId.toStatement)}::int4,
              "shipmethodid" = ${ParameterValue(row.shipmethodid, null, ShipmethodId.toStatement)}::int4,
              "creditcardid" = ${ParameterValue(row.creditcardid, null, ToStatement.optionToStatement(CustomCreditcardId.toStatement, CustomCreditcardId.parameterMetadata))}::int4,
              "creditcardapprovalcode" = ${ParameterValue(row.creditcardapprovalcode, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "currencyrateid" = ${ParameterValue(row.currencyrateid, null, ToStatement.optionToStatement(CurrencyrateId.toStatement, CurrencyrateId.parameterMetadata))}::int4,
              "subtotal" = ${ParameterValue(row.subtotal, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "taxamt" = ${ParameterValue(row.taxamt, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "freight" = ${ParameterValue(row.freight, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "totaldue" = ${ParameterValue(row.totaldue, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
              "comment" = ${ParameterValue(row.comment, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "salesorderid" = ${ParameterValue(salesorderid, null, SalesorderheaderId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[SalesorderheaderFields, SalesorderheaderRow] = {
    UpdateBuilder("sales.salesorderheader", SalesorderheaderFields.structure, SalesorderheaderRow.rowParser)
  }
  override def upsert(unsaved: SalesorderheaderRow)(implicit c: Connection): SalesorderheaderRow = {
    SQL"""insert into sales.salesorderheader("salesorderid", "revisionnumber", "orderdate", "duedate", "shipdate", "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.salesorderid, null, SalesorderheaderId.toStatement)}::int4,
            ${ParameterValue(unsaved.revisionnumber, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.orderdate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.duedate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.shipdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
            ${ParameterValue(unsaved.status, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.onlineorderflag, null, Flag.toStatement)}::bool,
            ${ParameterValue(unsaved.purchaseordernumber, null, ToStatement.optionToStatement(OrderNumber.toStatement, OrderNumber.parameterMetadata))}::varchar,
            ${ParameterValue(unsaved.accountnumber, null, ToStatement.optionToStatement(AccountNumber.toStatement, AccountNumber.parameterMetadata))}::varchar,
            ${ParameterValue(unsaved.customerid, null, CustomerId.toStatement)}::int4,
            ${ParameterValue(unsaved.salespersonid, null, ToStatement.optionToStatement(BusinessentityId.toStatement, BusinessentityId.parameterMetadata))}::int4,
            ${ParameterValue(unsaved.territoryid, null, ToStatement.optionToStatement(SalesterritoryId.toStatement, SalesterritoryId.parameterMetadata))}::int4,
            ${ParameterValue(unsaved.billtoaddressid, null, AddressId.toStatement)}::int4,
            ${ParameterValue(unsaved.shiptoaddressid, null, AddressId.toStatement)}::int4,
            ${ParameterValue(unsaved.shipmethodid, null, ShipmethodId.toStatement)}::int4,
            ${ParameterValue(unsaved.creditcardid, null, ToStatement.optionToStatement(CustomCreditcardId.toStatement, CustomCreditcardId.parameterMetadata))}::int4,
            ${ParameterValue(unsaved.creditcardapprovalcode, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.currencyrateid, null, ToStatement.optionToStatement(CurrencyrateId.toStatement, CurrencyrateId.parameterMetadata))}::int4,
            ${ParameterValue(unsaved.subtotal, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.taxamt, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.freight, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.totaldue, null, ToStatement.optionToStatement(ToStatement.scalaBigDecimalToStatement, ParameterMetaData.BigDecimalParameterMetaData))}::numeric,
            ${ParameterValue(unsaved.comment, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
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
          returning "salesorderid", "revisionnumber", "orderdate"::text, "duedate"::text, "shipdate"::text, "status", "onlineorderflag", "purchaseordernumber", "accountnumber", "customerid", "salespersonid", "territoryid", "billtoaddressid", "shiptoaddressid", "shipmethodid", "creditcardid", "creditcardapprovalcode", "currencyrateid", "subtotal", "taxamt", "freight", "totaldue", "comment", "rowguid", "modifieddate"::text
       """
      .executeInsert(SalesorderheaderRow.rowParser(1).single)
    
  }
}
