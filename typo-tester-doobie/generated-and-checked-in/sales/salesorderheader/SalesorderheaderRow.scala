/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

import adventureworks.TypoLocalDateTime
import adventureworks.person.address.AddressId
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.OrderNumber
import adventureworks.purchasing.shipmethod.ShipmethodId
import adventureworks.sales.creditcard.CreditcardId
import adventureworks.sales.currencyrate.CurrencyrateId
import adventureworks.sales.customer.CustomerId
import adventureworks.sales.salesterritory.SalesterritoryId
import doobie.enumerated.Nullability
import doobie.util.Get
import doobie.util.Read
import io.circe.Decoder
import io.circe.DecodingFailure
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet
import java.util.UUID
import scala.util.Try

case class SalesorderheaderRow(
  /** Primary key. */
  salesorderid: SalesorderheaderId,
  /** Incremental number to track changes to the sales order over time. */
  revisionnumber: Int,
  /** Dates the sales order was created. */
  orderdate: TypoLocalDateTime,
  /** Date the order is due to the customer. */
  duedate: TypoLocalDateTime,
  /** Date the order was shipped to the customer. */
  shipdate: Option[TypoLocalDateTime],
  /** Order current status. 1 = In process; 2 = Approved; 3 = Backordered; 4 = Rejected; 5 = Shipped; 6 = Cancelled */
  status: Int,
  /** 0 = Order placed by sales person. 1 = Order placed online by customer. */
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
  creditcardid: Option[CreditcardId],
  /** Approval code provided by the credit card company. */
  creditcardapprovalcode: Option[/* max 15 chars */ String],
  /** Currency exchange rate used. Foreign key to CurrencyRate.CurrencyRateID.
      Points to [[currencyrate.CurrencyrateRow.currencyrateid]] */
  currencyrateid: Option[CurrencyrateId],
  /** Sales subtotal. Computed as SUM(SalesOrderDetail.LineTotal)for the appropriate SalesOrderID. */
  subtotal: BigDecimal,
  /** Tax amount. */
  taxamt: BigDecimal,
  /** Shipping cost. */
  freight: BigDecimal,
  /** Total due from customer. Computed as Subtotal + TaxAmt + Freight. */
  totaldue: Option[BigDecimal],
  /** Sales representative comments. */
  comment: Option[/* max 128 chars */ String],
  rowguid: UUID,
  modifieddate: TypoLocalDateTime
)

object SalesorderheaderRow {
  implicit val decoder: Decoder[SalesorderheaderRow] = Decoder.instanceTry[SalesorderheaderRow]((c: HCursor) =>
    Try {
      def orThrow[R](either: Either[DecodingFailure, R]): R = either match {
        case Left(err) => throw err
        case Right(r)  => r
      }
      SalesorderheaderRow(
        salesorderid = orThrow(c.get("salesorderid")(Decoder[SalesorderheaderId])),
        revisionnumber = orThrow(c.get("revisionnumber")(Decoder[Int])),
        orderdate = orThrow(c.get("orderdate")(Decoder[TypoLocalDateTime])),
        duedate = orThrow(c.get("duedate")(Decoder[TypoLocalDateTime])),
        shipdate = orThrow(c.get("shipdate")(Decoder[Option[TypoLocalDateTime]])),
        status = orThrow(c.get("status")(Decoder[Int])),
        onlineorderflag = orThrow(c.get("onlineorderflag")(Decoder[Flag])),
        purchaseordernumber = orThrow(c.get("purchaseordernumber")(Decoder[Option[OrderNumber]])),
        accountnumber = orThrow(c.get("accountnumber")(Decoder[Option[AccountNumber]])),
        customerid = orThrow(c.get("customerid")(Decoder[CustomerId])),
        salespersonid = orThrow(c.get("salespersonid")(Decoder[Option[BusinessentityId]])),
        territoryid = orThrow(c.get("territoryid")(Decoder[Option[SalesterritoryId]])),
        billtoaddressid = orThrow(c.get("billtoaddressid")(Decoder[AddressId])),
        shiptoaddressid = orThrow(c.get("shiptoaddressid")(Decoder[AddressId])),
        shipmethodid = orThrow(c.get("shipmethodid")(Decoder[ShipmethodId])),
        creditcardid = orThrow(c.get("creditcardid")(Decoder[Option[CreditcardId]])),
        creditcardapprovalcode = orThrow(c.get("creditcardapprovalcode")(Decoder[Option[/* max 15 chars */ String]])),
        currencyrateid = orThrow(c.get("currencyrateid")(Decoder[Option[CurrencyrateId]])),
        subtotal = orThrow(c.get("subtotal")(Decoder[BigDecimal])),
        taxamt = orThrow(c.get("taxamt")(Decoder[BigDecimal])),
        freight = orThrow(c.get("freight")(Decoder[BigDecimal])),
        totaldue = orThrow(c.get("totaldue")(Decoder[Option[BigDecimal]])),
        comment = orThrow(c.get("comment")(Decoder[Option[/* max 128 chars */ String]])),
        rowguid = orThrow(c.get("rowguid")(Decoder[UUID])),
        modifieddate = orThrow(c.get("modifieddate")(Decoder[TypoLocalDateTime]))
      )
    }
  )
  implicit val encoder: Encoder[SalesorderheaderRow] = Encoder[SalesorderheaderRow](row =>
    Json.obj(
      "salesorderid" -> Encoder[SalesorderheaderId].apply(row.salesorderid),
      "revisionnumber" -> Encoder[Int].apply(row.revisionnumber),
      "orderdate" -> Encoder[TypoLocalDateTime].apply(row.orderdate),
      "duedate" -> Encoder[TypoLocalDateTime].apply(row.duedate),
      "shipdate" -> Encoder[Option[TypoLocalDateTime]].apply(row.shipdate),
      "status" -> Encoder[Int].apply(row.status),
      "onlineorderflag" -> Encoder[Flag].apply(row.onlineorderflag),
      "purchaseordernumber" -> Encoder[Option[OrderNumber]].apply(row.purchaseordernumber),
      "accountnumber" -> Encoder[Option[AccountNumber]].apply(row.accountnumber),
      "customerid" -> Encoder[CustomerId].apply(row.customerid),
      "salespersonid" -> Encoder[Option[BusinessentityId]].apply(row.salespersonid),
      "territoryid" -> Encoder[Option[SalesterritoryId]].apply(row.territoryid),
      "billtoaddressid" -> Encoder[AddressId].apply(row.billtoaddressid),
      "shiptoaddressid" -> Encoder[AddressId].apply(row.shiptoaddressid),
      "shipmethodid" -> Encoder[ShipmethodId].apply(row.shipmethodid),
      "creditcardid" -> Encoder[Option[CreditcardId]].apply(row.creditcardid),
      "creditcardapprovalcode" -> Encoder[Option[/* max 15 chars */ String]].apply(row.creditcardapprovalcode),
      "currencyrateid" -> Encoder[Option[CurrencyrateId]].apply(row.currencyrateid),
      "subtotal" -> Encoder[BigDecimal].apply(row.subtotal),
      "taxamt" -> Encoder[BigDecimal].apply(row.taxamt),
      "freight" -> Encoder[BigDecimal].apply(row.freight),
      "totaldue" -> Encoder[Option[BigDecimal]].apply(row.totaldue),
      "comment" -> Encoder[Option[/* max 128 chars */ String]].apply(row.comment),
      "rowguid" -> Encoder[UUID].apply(row.rowguid),
      "modifieddate" -> Encoder[TypoLocalDateTime].apply(row.modifieddate)
    )
  )
  implicit val read: Read[SalesorderheaderRow] = new Read[SalesorderheaderRow](
    gets = List(
      (Get[SalesorderheaderId], Nullability.NoNulls),
      (Get[Int], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.Nullable),
      (Get[Int], Nullability.NoNulls),
      (Get[Flag], Nullability.NoNulls),
      (Get[OrderNumber], Nullability.Nullable),
      (Get[AccountNumber], Nullability.Nullable),
      (Get[CustomerId], Nullability.NoNulls),
      (Get[BusinessentityId], Nullability.Nullable),
      (Get[SalesterritoryId], Nullability.Nullable),
      (Get[AddressId], Nullability.NoNulls),
      (Get[AddressId], Nullability.NoNulls),
      (Get[ShipmethodId], Nullability.NoNulls),
      (Get[CreditcardId], Nullability.Nullable),
      (Get[/* max 15 chars */ String], Nullability.Nullable),
      (Get[CurrencyrateId], Nullability.Nullable),
      (Get[BigDecimal], Nullability.NoNulls),
      (Get[BigDecimal], Nullability.NoNulls),
      (Get[BigDecimal], Nullability.NoNulls),
      (Get[BigDecimal], Nullability.Nullable),
      (Get[/* max 128 chars */ String], Nullability.Nullable),
      (Get[UUID], Nullability.NoNulls),
      (Get[TypoLocalDateTime], Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => SalesorderheaderRow(
      salesorderid = Get[SalesorderheaderId].unsafeGetNonNullable(rs, i + 0),
      revisionnumber = Get[Int].unsafeGetNonNullable(rs, i + 1),
      orderdate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 2),
      duedate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 3),
      shipdate = Get[TypoLocalDateTime].unsafeGetNullable(rs, i + 4),
      status = Get[Int].unsafeGetNonNullable(rs, i + 5),
      onlineorderflag = Get[Flag].unsafeGetNonNullable(rs, i + 6),
      purchaseordernumber = Get[OrderNumber].unsafeGetNullable(rs, i + 7),
      accountnumber = Get[AccountNumber].unsafeGetNullable(rs, i + 8),
      customerid = Get[CustomerId].unsafeGetNonNullable(rs, i + 9),
      salespersonid = Get[BusinessentityId].unsafeGetNullable(rs, i + 10),
      territoryid = Get[SalesterritoryId].unsafeGetNullable(rs, i + 11),
      billtoaddressid = Get[AddressId].unsafeGetNonNullable(rs, i + 12),
      shiptoaddressid = Get[AddressId].unsafeGetNonNullable(rs, i + 13),
      shipmethodid = Get[ShipmethodId].unsafeGetNonNullable(rs, i + 14),
      creditcardid = Get[CreditcardId].unsafeGetNullable(rs, i + 15),
      creditcardapprovalcode = Get[/* max 15 chars */ String].unsafeGetNullable(rs, i + 16),
      currencyrateid = Get[CurrencyrateId].unsafeGetNullable(rs, i + 17),
      subtotal = Get[BigDecimal].unsafeGetNonNullable(rs, i + 18),
      taxamt = Get[BigDecimal].unsafeGetNonNullable(rs, i + 19),
      freight = Get[BigDecimal].unsafeGetNonNullable(rs, i + 20),
      totaldue = Get[BigDecimal].unsafeGetNullable(rs, i + 21),
      comment = Get[/* max 128 chars */ String].unsafeGetNullable(rs, i + 22),
      rowguid = Get[UUID].unsafeGetNonNullable(rs, i + 23),
      modifieddate = Get[TypoLocalDateTime].unsafeGetNonNullable(rs, i + 24)
    )
  )
}
