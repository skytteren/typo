/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import adventureworks.Text
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
import adventureworks.userdefined.CustomCreditcardId
import anorm.Column
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import scala.collection.immutable.ListMap
import scala.util.Try

/** Table: sales.salesorderheader
    General sales order information.
    Primary key: salesorderid */
case class SalesorderheaderRow(
  /** Primary key.
      Default: nextval('sales.salesorderheader_salesorderid_seq'::regclass) */
  salesorderid: SalesorderheaderId,
  /** Incremental number to track changes to the sales order over time.
      Default: 0 */
  revisionnumber: TypoShort,
  /** Dates the sales order was created.
      Default: now()
      Constraint CK_SalesOrderHeader_DueDate affecting columns duedate, orderdate: ((duedate >= orderdate))
      Constraint CK_SalesOrderHeader_ShipDate affecting columns orderdate, shipdate: (((shipdate >= orderdate) OR (shipdate IS NULL))) */
  orderdate: TypoLocalDateTime,
  /** Date the order is due to the customer.
      Constraint CK_SalesOrderHeader_DueDate affecting columns duedate, orderdate: ((duedate >= orderdate)) */
  duedate: TypoLocalDateTime,
  /** Date the order was shipped to the customer.
      Constraint CK_SalesOrderHeader_ShipDate affecting columns orderdate, shipdate: (((shipdate >= orderdate) OR (shipdate IS NULL))) */
  shipdate: Option[TypoLocalDateTime],
  /** Order current status. 1 = In process; 2 = Approved; 3 = Backordered; 4 = Rejected; 5 = Shipped; 6 = Cancelled
      Default: 1
      Constraint CK_SalesOrderHeader_Status affecting columns status: (((status >= 0) AND (status <= 8))) */
  status: TypoShort,
  /** 0 = Order placed by sales person. 1 = Order placed online by customer.
      Default: true */
  onlineorderflag: Flag,
  /** Customer purchase order number reference. */
  purchaseordernumber: Option[OrderNumber],
  /** Financial accounting number reference. */
  accountnumber: Option[AccountNumber],
  /** Customer identification number. Foreign key to Customer.BusinessEntityID.
      Points to [[customer.CustomerRow.customerid]] */
  customerid: CustomerId,
  /** Sales person who created the sales order. Foreign key to SalesPerson.BusinessEntityID.
      Points to [[salesperson.SalespersonRow.businessentityid]] */
  salespersonid: Option[BusinessentityId],
  /** Territory in which the sale was made. Foreign key to SalesTerritory.SalesTerritoryID.
      Points to [[salesterritory.SalesterritoryRow.territoryid]] */
  territoryid: Option[SalesterritoryId],
  /** Customer billing address. Foreign key to Address.AddressID.
      Points to [[person.address.AddressRow.addressid]] */
  billtoaddressid: AddressId,
  /** Customer shipping address. Foreign key to Address.AddressID.
      Points to [[person.address.AddressRow.addressid]] */
  shiptoaddressid: AddressId,
  /** Shipping method. Foreign key to ShipMethod.ShipMethodID.
      Points to [[purchasing.shipmethod.ShipmethodRow.shipmethodid]] */
  shipmethodid: ShipmethodId,
  /** Credit card identification number. Foreign key to CreditCard.CreditCardID.
      Points to [[creditcard.CreditcardRow.creditcardid]] */
  creditcardid: Option[/* user-picked */ CustomCreditcardId],
  /** Approval code provided by the credit card company. */
  creditcardapprovalcode: Option[/* max 15 chars */ String],
  /** Currency exchange rate used. Foreign key to CurrencyRate.CurrencyRateID.
      Points to [[currencyrate.CurrencyrateRow.currencyrateid]] */
  currencyrateid: Option[CurrencyrateId],
  /** Sales subtotal. Computed as SUM(SalesOrderDetail.LineTotal)for the appropriate SalesOrderID.
      Default: 0.00
      Constraint CK_SalesOrderHeader_SubTotal affecting columns subtotal: ((subtotal >= 0.00)) */
  subtotal: BigDecimal,
  /** Tax amount.
      Default: 0.00
      Constraint CK_SalesOrderHeader_TaxAmt affecting columns taxamt: ((taxamt >= 0.00)) */
  taxamt: BigDecimal,
  /** Shipping cost.
      Default: 0.00
      Constraint CK_SalesOrderHeader_Freight affecting columns freight: ((freight >= 0.00)) */
  freight: BigDecimal,
  /** Total due from customer. Computed as Subtotal + TaxAmt + Freight. */
  totaldue: Option[BigDecimal],
  /** Sales representative comments. */
  comment: Option[/* max 128 chars */ String],
  /** Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime
){
   def toUnsavedRow(salesorderid: Defaulted[SalesorderheaderId], revisionnumber: Defaulted[TypoShort] = Defaulted.Provided(this.revisionnumber), orderdate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.orderdate), status: Defaulted[TypoShort] = Defaulted.Provided(this.status), onlineorderflag: Defaulted[Flag] = Defaulted.Provided(this.onlineorderflag), subtotal: Defaulted[BigDecimal] = Defaulted.Provided(this.subtotal), taxamt: Defaulted[BigDecimal] = Defaulted.Provided(this.taxamt), freight: Defaulted[BigDecimal] = Defaulted.Provided(this.freight), rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): SalesorderheaderRowUnsaved =
     SalesorderheaderRowUnsaved(duedate, shipdate, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, totaldue, comment, salesorderid, revisionnumber, orderdate, status, onlineorderflag, subtotal, taxamt, freight, rowguid, modifieddate)
 }

object SalesorderheaderRow {
  implicit lazy val reads: Reads[SalesorderheaderRow] = Reads[SalesorderheaderRow](json => JsResult.fromTry(
      Try(
        SalesorderheaderRow(
          salesorderid = json.\("salesorderid").as(SalesorderheaderId.reads),
          revisionnumber = json.\("revisionnumber").as(TypoShort.reads),
          orderdate = json.\("orderdate").as(TypoLocalDateTime.reads),
          duedate = json.\("duedate").as(TypoLocalDateTime.reads),
          shipdate = json.\("shipdate").toOption.map(_.as(TypoLocalDateTime.reads)),
          status = json.\("status").as(TypoShort.reads),
          onlineorderflag = json.\("onlineorderflag").as(Flag.reads),
          purchaseordernumber = json.\("purchaseordernumber").toOption.map(_.as(OrderNumber.reads)),
          accountnumber = json.\("accountnumber").toOption.map(_.as(AccountNumber.reads)),
          customerid = json.\("customerid").as(CustomerId.reads),
          salespersonid = json.\("salespersonid").toOption.map(_.as(BusinessentityId.reads)),
          territoryid = json.\("territoryid").toOption.map(_.as(SalesterritoryId.reads)),
          billtoaddressid = json.\("billtoaddressid").as(AddressId.reads),
          shiptoaddressid = json.\("shiptoaddressid").as(AddressId.reads),
          shipmethodid = json.\("shipmethodid").as(ShipmethodId.reads),
          creditcardid = json.\("creditcardid").toOption.map(_.as(CustomCreditcardId.reads)),
          creditcardapprovalcode = json.\("creditcardapprovalcode").toOption.map(_.as(Reads.StringReads)),
          currencyrateid = json.\("currencyrateid").toOption.map(_.as(CurrencyrateId.reads)),
          subtotal = json.\("subtotal").as(Reads.bigDecReads),
          taxamt = json.\("taxamt").as(Reads.bigDecReads),
          freight = json.\("freight").as(Reads.bigDecReads),
          totaldue = json.\("totaldue").toOption.map(_.as(Reads.bigDecReads)),
          comment = json.\("comment").toOption.map(_.as(Reads.StringReads)),
          rowguid = json.\("rowguid").as(TypoUUID.reads),
          modifieddate = json.\("modifieddate").as(TypoLocalDateTime.reads)
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[SalesorderheaderRow] = RowParser[SalesorderheaderRow] { row =>
    Success(
      SalesorderheaderRow(
        salesorderid = row(idx + 0)(SalesorderheaderId.column),
        revisionnumber = row(idx + 1)(TypoShort.column),
        orderdate = row(idx + 2)(TypoLocalDateTime.column),
        duedate = row(idx + 3)(TypoLocalDateTime.column),
        shipdate = row(idx + 4)(Column.columnToOption(TypoLocalDateTime.column)),
        status = row(idx + 5)(TypoShort.column),
        onlineorderflag = row(idx + 6)(Flag.column),
        purchaseordernumber = row(idx + 7)(Column.columnToOption(OrderNumber.column)),
        accountnumber = row(idx + 8)(Column.columnToOption(AccountNumber.column)),
        customerid = row(idx + 9)(CustomerId.column),
        salespersonid = row(idx + 10)(Column.columnToOption(BusinessentityId.column)),
        territoryid = row(idx + 11)(Column.columnToOption(SalesterritoryId.column)),
        billtoaddressid = row(idx + 12)(AddressId.column),
        shiptoaddressid = row(idx + 13)(AddressId.column),
        shipmethodid = row(idx + 14)(ShipmethodId.column),
        creditcardid = row(idx + 15)(Column.columnToOption(CustomCreditcardId.column)),
        creditcardapprovalcode = row(idx + 16)(Column.columnToOption(Column.columnToString)),
        currencyrateid = row(idx + 17)(Column.columnToOption(CurrencyrateId.column)),
        subtotal = row(idx + 18)(Column.columnToScalaBigDecimal),
        taxamt = row(idx + 19)(Column.columnToScalaBigDecimal),
        freight = row(idx + 20)(Column.columnToScalaBigDecimal),
        totaldue = row(idx + 21)(Column.columnToOption(Column.columnToScalaBigDecimal)),
        comment = row(idx + 22)(Column.columnToOption(Column.columnToString)),
        rowguid = row(idx + 23)(TypoUUID.column),
        modifieddate = row(idx + 24)(TypoLocalDateTime.column)
      )
    )
  }
  implicit lazy val text: Text[SalesorderheaderRow] = Text.instance[SalesorderheaderRow]{ (row, sb) =>
    SalesorderheaderId.text.unsafeEncode(row.salesorderid, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.revisionnumber, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.orderdate, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.duedate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.shipdate, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.status, sb)
    sb.append(Text.DELIMETER)
    Flag.text.unsafeEncode(row.onlineorderflag, sb)
    sb.append(Text.DELIMETER)
    Text.option(OrderNumber.text).unsafeEncode(row.purchaseordernumber, sb)
    sb.append(Text.DELIMETER)
    Text.option(AccountNumber.text).unsafeEncode(row.accountnumber, sb)
    sb.append(Text.DELIMETER)
    CustomerId.text.unsafeEncode(row.customerid, sb)
    sb.append(Text.DELIMETER)
    Text.option(BusinessentityId.text).unsafeEncode(row.salespersonid, sb)
    sb.append(Text.DELIMETER)
    Text.option(SalesterritoryId.text).unsafeEncode(row.territoryid, sb)
    sb.append(Text.DELIMETER)
    AddressId.text.unsafeEncode(row.billtoaddressid, sb)
    sb.append(Text.DELIMETER)
    AddressId.text.unsafeEncode(row.shiptoaddressid, sb)
    sb.append(Text.DELIMETER)
    ShipmethodId.text.unsafeEncode(row.shipmethodid, sb)
    sb.append(Text.DELIMETER)
    Text.option(CustomCreditcardId.text).unsafeEncode(row.creditcardid, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.creditcardapprovalcode, sb)
    sb.append(Text.DELIMETER)
    Text.option(CurrencyrateId.text).unsafeEncode(row.currencyrateid, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.subtotal, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.taxamt, sb)
    sb.append(Text.DELIMETER)
    Text.bigDecimalInstance.unsafeEncode(row.freight, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.bigDecimalInstance).unsafeEncode(row.totaldue, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.comment, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
  }
  implicit lazy val writes: OWrites[SalesorderheaderRow] = OWrites[SalesorderheaderRow](o =>
    new JsObject(ListMap[String, JsValue](
      "salesorderid" -> SalesorderheaderId.writes.writes(o.salesorderid),
      "revisionnumber" -> TypoShort.writes.writes(o.revisionnumber),
      "orderdate" -> TypoLocalDateTime.writes.writes(o.orderdate),
      "duedate" -> TypoLocalDateTime.writes.writes(o.duedate),
      "shipdate" -> Writes.OptionWrites(TypoLocalDateTime.writes).writes(o.shipdate),
      "status" -> TypoShort.writes.writes(o.status),
      "onlineorderflag" -> Flag.writes.writes(o.onlineorderflag),
      "purchaseordernumber" -> Writes.OptionWrites(OrderNumber.writes).writes(o.purchaseordernumber),
      "accountnumber" -> Writes.OptionWrites(AccountNumber.writes).writes(o.accountnumber),
      "customerid" -> CustomerId.writes.writes(o.customerid),
      "salespersonid" -> Writes.OptionWrites(BusinessentityId.writes).writes(o.salespersonid),
      "territoryid" -> Writes.OptionWrites(SalesterritoryId.writes).writes(o.territoryid),
      "billtoaddressid" -> AddressId.writes.writes(o.billtoaddressid),
      "shiptoaddressid" -> AddressId.writes.writes(o.shiptoaddressid),
      "shipmethodid" -> ShipmethodId.writes.writes(o.shipmethodid),
      "creditcardid" -> Writes.OptionWrites(CustomCreditcardId.writes).writes(o.creditcardid),
      "creditcardapprovalcode" -> Writes.OptionWrites(Writes.StringWrites).writes(o.creditcardapprovalcode),
      "currencyrateid" -> Writes.OptionWrites(CurrencyrateId.writes).writes(o.currencyrateid),
      "subtotal" -> Writes.BigDecimalWrites.writes(o.subtotal),
      "taxamt" -> Writes.BigDecimalWrites.writes(o.taxamt),
      "freight" -> Writes.BigDecimalWrites.writes(o.freight),
      "totaldue" -> Writes.OptionWrites(Writes.BigDecimalWrites).writes(o.totaldue),
      "comment" -> Writes.OptionWrites(Writes.StringWrites).writes(o.comment),
      "rowguid" -> TypoUUID.writes.writes(o.rowguid),
      "modifieddate" -> TypoLocalDateTime.writes.writes(o.modifieddate)
    ))
  )
}
