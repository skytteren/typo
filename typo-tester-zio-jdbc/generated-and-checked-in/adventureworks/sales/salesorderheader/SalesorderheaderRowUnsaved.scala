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
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** This class corresponds to a row in table `sales.salesorderheader` which has not been persisted yet */
case class SalesorderheaderRowUnsaved(
  /** Date the order is due to the customer.
      Constraint CK_SalesOrderHeader_DueDate affecting columns duedate, orderdate:  ((duedate >= orderdate)) */
  duedate: TypoLocalDateTime,
  /** Date the order was shipped to the customer.
      Constraint CK_SalesOrderHeader_ShipDate affecting columns orderdate, shipdate:  (((shipdate >= orderdate) OR (shipdate IS NULL))) */
  shipdate: Option[TypoLocalDateTime],
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
  /** Total due from customer. Computed as Subtotal + TaxAmt + Freight. */
  totaldue: Option[BigDecimal],
  /** Sales representative comments. */
  comment: Option[/* max 128 chars */ String],
  /** Default: nextval('sales.salesorderheader_salesorderid_seq'::regclass)
      Primary key. */
  salesorderid: Defaulted[SalesorderheaderId] = Defaulted.UseDefault,
  /** Default: 0
      Incremental number to track changes to the sales order over time. */
  revisionnumber: Defaulted[TypoShort] = Defaulted.UseDefault,
  /** Default: now()
      Dates the sales order was created.
      Constraint CK_SalesOrderHeader_DueDate affecting columns duedate, orderdate:  ((duedate >= orderdate))
      Constraint CK_SalesOrderHeader_ShipDate affecting columns orderdate, shipdate:  (((shipdate >= orderdate) OR (shipdate IS NULL))) */
  orderdate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault,
  /** Default: 1
      Order current status. 1 = In process; 2 = Approved; 3 = Backordered; 4 = Rejected; 5 = Shipped; 6 = Cancelled
      Constraint CK_SalesOrderHeader_Status affecting columns status:  (((status >= 0) AND (status <= 8))) */
  status: Defaulted[TypoShort] = Defaulted.UseDefault,
  /** Default: true
      0 = Order placed by sales person. 1 = Order placed online by customer. */
  onlineorderflag: Defaulted[Flag] = Defaulted.UseDefault,
  /** Default: 0.00
      Sales subtotal. Computed as SUM(SalesOrderDetail.LineTotal)for the appropriate SalesOrderID.
      Constraint CK_SalesOrderHeader_SubTotal affecting columns subtotal:  ((subtotal >= 0.00)) */
  subtotal: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Tax amount.
      Constraint CK_SalesOrderHeader_TaxAmt affecting columns taxamt:  ((taxamt >= 0.00)) */
  taxamt: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: 0.00
      Shipping cost.
      Constraint CK_SalesOrderHeader_Freight affecting columns freight:  ((freight >= 0.00)) */
  freight: Defaulted[BigDecimal] = Defaulted.UseDefault,
  /** Default: uuid_generate_v1() */
  rowguid: Defaulted[TypoUUID] = Defaulted.UseDefault,
  /** Default: now() */
  modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.UseDefault
) {
  def toRow(salesorderidDefault: => SalesorderheaderId, revisionnumberDefault: => TypoShort, orderdateDefault: => TypoLocalDateTime, statusDefault: => TypoShort, onlineorderflagDefault: => Flag, subtotalDefault: => BigDecimal, taxamtDefault: => BigDecimal, freightDefault: => BigDecimal, rowguidDefault: => TypoUUID, modifieddateDefault: => TypoLocalDateTime): SalesorderheaderRow =
    SalesorderheaderRow(
      duedate = duedate,
      shipdate = shipdate,
      purchaseordernumber = purchaseordernumber,
      accountnumber = accountnumber,
      customerid = customerid,
      salespersonid = salespersonid,
      territoryid = territoryid,
      billtoaddressid = billtoaddressid,
      shiptoaddressid = shiptoaddressid,
      shipmethodid = shipmethodid,
      creditcardid = creditcardid,
      creditcardapprovalcode = creditcardapprovalcode,
      currencyrateid = currencyrateid,
      totaldue = totaldue,
      comment = comment,
      salesorderid = salesorderid match {
                       case Defaulted.UseDefault => salesorderidDefault
                       case Defaulted.Provided(value) => value
                     },
      revisionnumber = revisionnumber match {
                         case Defaulted.UseDefault => revisionnumberDefault
                         case Defaulted.Provided(value) => value
                       },
      orderdate = orderdate match {
                    case Defaulted.UseDefault => orderdateDefault
                    case Defaulted.Provided(value) => value
                  },
      status = status match {
                 case Defaulted.UseDefault => statusDefault
                 case Defaulted.Provided(value) => value
               },
      onlineorderflag = onlineorderflag match {
                          case Defaulted.UseDefault => onlineorderflagDefault
                          case Defaulted.Provided(value) => value
                        },
      subtotal = subtotal match {
                   case Defaulted.UseDefault => subtotalDefault
                   case Defaulted.Provided(value) => value
                 },
      taxamt = taxamt match {
                 case Defaulted.UseDefault => taxamtDefault
                 case Defaulted.Provided(value) => value
               },
      freight = freight match {
                  case Defaulted.UseDefault => freightDefault
                  case Defaulted.Provided(value) => value
                },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => rowguidDefault
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => modifieddateDefault
                       case Defaulted.Provided(value) => value
                     }
    )
}
object SalesorderheaderRowUnsaved {
  implicit lazy val jsonDecoder: JsonDecoder[SalesorderheaderRowUnsaved] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val duedate = jsonObj.get("duedate").toRight("Missing field 'duedate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val shipdate = jsonObj.get("shipdate").fold[Either[String, Option[TypoLocalDateTime]]](Right(None))(_.as(JsonDecoder.option(using TypoLocalDateTime.jsonDecoder)))
    val purchaseordernumber = jsonObj.get("purchaseordernumber").fold[Either[String, Option[OrderNumber]]](Right(None))(_.as(JsonDecoder.option(using OrderNumber.jsonDecoder)))
    val accountnumber = jsonObj.get("accountnumber").fold[Either[String, Option[AccountNumber]]](Right(None))(_.as(JsonDecoder.option(using AccountNumber.jsonDecoder)))
    val customerid = jsonObj.get("customerid").toRight("Missing field 'customerid'").flatMap(_.as(CustomerId.jsonDecoder))
    val salespersonid = jsonObj.get("salespersonid").fold[Either[String, Option[BusinessentityId]]](Right(None))(_.as(JsonDecoder.option(using BusinessentityId.jsonDecoder)))
    val territoryid = jsonObj.get("territoryid").fold[Either[String, Option[SalesterritoryId]]](Right(None))(_.as(JsonDecoder.option(using SalesterritoryId.jsonDecoder)))
    val billtoaddressid = jsonObj.get("billtoaddressid").toRight("Missing field 'billtoaddressid'").flatMap(_.as(AddressId.jsonDecoder))
    val shiptoaddressid = jsonObj.get("shiptoaddressid").toRight("Missing field 'shiptoaddressid'").flatMap(_.as(AddressId.jsonDecoder))
    val shipmethodid = jsonObj.get("shipmethodid").toRight("Missing field 'shipmethodid'").flatMap(_.as(ShipmethodId.jsonDecoder))
    val creditcardid = jsonObj.get("creditcardid").fold[Either[String, Option[CustomCreditcardId]]](Right(None))(_.as(JsonDecoder.option(using CustomCreditcardId.jsonDecoder)))
    val creditcardapprovalcode = jsonObj.get("creditcardapprovalcode").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val currencyrateid = jsonObj.get("currencyrateid").fold[Either[String, Option[CurrencyrateId]]](Right(None))(_.as(JsonDecoder.option(using CurrencyrateId.jsonDecoder)))
    val totaldue = jsonObj.get("totaldue").fold[Either[String, Option[BigDecimal]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.scalaBigDecimal)))
    val comment = jsonObj.get("comment").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val salesorderid = jsonObj.get("salesorderid").toRight("Missing field 'salesorderid'").flatMap(_.as(Defaulted.jsonDecoder(SalesorderheaderId.jsonDecoder)))
    val revisionnumber = jsonObj.get("revisionnumber").toRight("Missing field 'revisionnumber'").flatMap(_.as(Defaulted.jsonDecoder(TypoShort.jsonDecoder)))
    val orderdate = jsonObj.get("orderdate").toRight("Missing field 'orderdate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    val status = jsonObj.get("status").toRight("Missing field 'status'").flatMap(_.as(Defaulted.jsonDecoder(TypoShort.jsonDecoder)))
    val onlineorderflag = jsonObj.get("onlineorderflag").toRight("Missing field 'onlineorderflag'").flatMap(_.as(Defaulted.jsonDecoder(Flag.jsonDecoder)))
    val subtotal = jsonObj.get("subtotal").toRight("Missing field 'subtotal'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.scalaBigDecimal)))
    val taxamt = jsonObj.get("taxamt").toRight("Missing field 'taxamt'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.scalaBigDecimal)))
    val freight = jsonObj.get("freight").toRight("Missing field 'freight'").flatMap(_.as(Defaulted.jsonDecoder(JsonDecoder.scalaBigDecimal)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(Defaulted.jsonDecoder(TypoUUID.jsonDecoder)))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(Defaulted.jsonDecoder(TypoLocalDateTime.jsonDecoder)))
    if (duedate.isRight && shipdate.isRight && purchaseordernumber.isRight && accountnumber.isRight && customerid.isRight && salespersonid.isRight && territoryid.isRight && billtoaddressid.isRight && shiptoaddressid.isRight && shipmethodid.isRight && creditcardid.isRight && creditcardapprovalcode.isRight && currencyrateid.isRight && totaldue.isRight && comment.isRight && salesorderid.isRight && revisionnumber.isRight && orderdate.isRight && status.isRight && onlineorderflag.isRight && subtotal.isRight && taxamt.isRight && freight.isRight && rowguid.isRight && modifieddate.isRight)
      Right(SalesorderheaderRowUnsaved(duedate = duedate.toOption.get, shipdate = shipdate.toOption.get, purchaseordernumber = purchaseordernumber.toOption.get, accountnumber = accountnumber.toOption.get, customerid = customerid.toOption.get, salespersonid = salespersonid.toOption.get, territoryid = territoryid.toOption.get, billtoaddressid = billtoaddressid.toOption.get, shiptoaddressid = shiptoaddressid.toOption.get, shipmethodid = shipmethodid.toOption.get, creditcardid = creditcardid.toOption.get, creditcardapprovalcode = creditcardapprovalcode.toOption.get, currencyrateid = currencyrateid.toOption.get, totaldue = totaldue.toOption.get, comment = comment.toOption.get, salesorderid = salesorderid.toOption.get, revisionnumber = revisionnumber.toOption.get, orderdate = orderdate.toOption.get, status = status.toOption.get, onlineorderflag = onlineorderflag.toOption.get, subtotal = subtotal.toOption.get, taxamt = taxamt.toOption.get, freight = freight.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get))
    else Left(List[Either[String, Any]](duedate, shipdate, purchaseordernumber, accountnumber, customerid, salespersonid, territoryid, billtoaddressid, shiptoaddressid, shipmethodid, creditcardid, creditcardapprovalcode, currencyrateid, totaldue, comment, salesorderid, revisionnumber, orderdate, status, onlineorderflag, subtotal, taxamt, freight, rowguid, modifieddate).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SalesorderheaderRowUnsaved] = new JsonEncoder[SalesorderheaderRowUnsaved] {
    override def unsafeEncode(a: SalesorderheaderRowUnsaved, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""duedate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.duedate, indent, out)
      out.write(",")
      out.write(""""shipdate":""")
      JsonEncoder.option(using TypoLocalDateTime.jsonEncoder).unsafeEncode(a.shipdate, indent, out)
      out.write(",")
      out.write(""""purchaseordernumber":""")
      JsonEncoder.option(using OrderNumber.jsonEncoder).unsafeEncode(a.purchaseordernumber, indent, out)
      out.write(",")
      out.write(""""accountnumber":""")
      JsonEncoder.option(using AccountNumber.jsonEncoder).unsafeEncode(a.accountnumber, indent, out)
      out.write(",")
      out.write(""""customerid":""")
      CustomerId.jsonEncoder.unsafeEncode(a.customerid, indent, out)
      out.write(",")
      out.write(""""salespersonid":""")
      JsonEncoder.option(using BusinessentityId.jsonEncoder).unsafeEncode(a.salespersonid, indent, out)
      out.write(",")
      out.write(""""territoryid":""")
      JsonEncoder.option(using SalesterritoryId.jsonEncoder).unsafeEncode(a.territoryid, indent, out)
      out.write(",")
      out.write(""""billtoaddressid":""")
      AddressId.jsonEncoder.unsafeEncode(a.billtoaddressid, indent, out)
      out.write(",")
      out.write(""""shiptoaddressid":""")
      AddressId.jsonEncoder.unsafeEncode(a.shiptoaddressid, indent, out)
      out.write(",")
      out.write(""""shipmethodid":""")
      ShipmethodId.jsonEncoder.unsafeEncode(a.shipmethodid, indent, out)
      out.write(",")
      out.write(""""creditcardid":""")
      JsonEncoder.option(using CustomCreditcardId.jsonEncoder).unsafeEncode(a.creditcardid, indent, out)
      out.write(",")
      out.write(""""creditcardapprovalcode":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.creditcardapprovalcode, indent, out)
      out.write(",")
      out.write(""""currencyrateid":""")
      JsonEncoder.option(using CurrencyrateId.jsonEncoder).unsafeEncode(a.currencyrateid, indent, out)
      out.write(",")
      out.write(""""totaldue":""")
      JsonEncoder.option(using JsonEncoder.scalaBigDecimal).unsafeEncode(a.totaldue, indent, out)
      out.write(",")
      out.write(""""comment":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.comment, indent, out)
      out.write(",")
      out.write(""""salesorderid":""")
      Defaulted.jsonEncoder(SalesorderheaderId.jsonEncoder).unsafeEncode(a.salesorderid, indent, out)
      out.write(",")
      out.write(""""revisionnumber":""")
      Defaulted.jsonEncoder(TypoShort.jsonEncoder).unsafeEncode(a.revisionnumber, indent, out)
      out.write(",")
      out.write(""""orderdate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.orderdate, indent, out)
      out.write(",")
      out.write(""""status":""")
      Defaulted.jsonEncoder(TypoShort.jsonEncoder).unsafeEncode(a.status, indent, out)
      out.write(",")
      out.write(""""onlineorderflag":""")
      Defaulted.jsonEncoder(Flag.jsonEncoder).unsafeEncode(a.onlineorderflag, indent, out)
      out.write(",")
      out.write(""""subtotal":""")
      Defaulted.jsonEncoder(JsonEncoder.scalaBigDecimal).unsafeEncode(a.subtotal, indent, out)
      out.write(",")
      out.write(""""taxamt":""")
      Defaulted.jsonEncoder(JsonEncoder.scalaBigDecimal).unsafeEncode(a.taxamt, indent, out)
      out.write(",")
      out.write(""""freight":""")
      Defaulted.jsonEncoder(JsonEncoder.scalaBigDecimal).unsafeEncode(a.freight, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      Defaulted.jsonEncoder(TypoUUID.jsonEncoder).unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      Defaulted.jsonEncoder(TypoLocalDateTime.jsonEncoder).unsafeEncode(a.modifieddate, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[SalesorderheaderRowUnsaved] = Text.instance[SalesorderheaderRowUnsaved]{ (row, sb) =>
    TypoLocalDateTime.text.unsafeEncode(row.duedate, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoLocalDateTime.text).unsafeEncode(row.shipdate, sb)
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
    Text.option(Text.bigDecimalInstance).unsafeEncode(row.totaldue, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.comment, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(SalesorderheaderId.text).unsafeEncode(row.salesorderid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoShort.text).unsafeEncode(row.revisionnumber, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.orderdate, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoShort.text).unsafeEncode(row.status, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Flag.text).unsafeEncode(row.onlineorderflag, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.subtotal, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.taxamt, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(Text.bigDecimalInstance).unsafeEncode(row.freight, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoUUID.text).unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    Defaulted.text(TypoLocalDateTime.text).unsafeEncode(row.modifieddate, sb)
  }
}
