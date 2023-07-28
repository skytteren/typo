/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesorderheader

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
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class SalesorderheaderFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class SalesorderheaderFieldValue[T](name: String, value: T) extends SalesorderheaderFieldOrIdValue(name, value)

object SalesorderheaderFieldValue {
  case class salesorderid(override val value: SalesorderheaderId) extends SalesorderheaderFieldOrIdValue("salesorderid", value)
  case class revisionnumber(override val value: Int) extends SalesorderheaderFieldValue("revisionnumber", value)
  case class orderdate(override val value: LocalDateTime) extends SalesorderheaderFieldValue("orderdate", value)
  case class duedate(override val value: LocalDateTime) extends SalesorderheaderFieldValue("duedate", value)
  case class shipdate(override val value: Option[LocalDateTime]) extends SalesorderheaderFieldValue("shipdate", value)
  case class status(override val value: Int) extends SalesorderheaderFieldValue("status", value)
  case class onlineorderflag(override val value: Flag) extends SalesorderheaderFieldValue("onlineorderflag", value)
  case class purchaseordernumber(override val value: Option[OrderNumber]) extends SalesorderheaderFieldValue("purchaseordernumber", value)
  case class accountnumber(override val value: Option[AccountNumber]) extends SalesorderheaderFieldValue("accountnumber", value)
  case class customerid(override val value: CustomerId) extends SalesorderheaderFieldValue("customerid", value)
  case class salespersonid(override val value: Option[BusinessentityId]) extends SalesorderheaderFieldValue("salespersonid", value)
  case class territoryid(override val value: Option[SalesterritoryId]) extends SalesorderheaderFieldValue("territoryid", value)
  case class billtoaddressid(override val value: AddressId) extends SalesorderheaderFieldValue("billtoaddressid", value)
  case class shiptoaddressid(override val value: AddressId) extends SalesorderheaderFieldValue("shiptoaddressid", value)
  case class shipmethodid(override val value: ShipmethodId) extends SalesorderheaderFieldValue("shipmethodid", value)
  case class creditcardid(override val value: Option[CreditcardId]) extends SalesorderheaderFieldValue("creditcardid", value)
  case class creditcardapprovalcode(override val value: Option[/* max 15 chars */ String]) extends SalesorderheaderFieldValue("creditcardapprovalcode", value)
  case class currencyrateid(override val value: Option[CurrencyrateId]) extends SalesorderheaderFieldValue("currencyrateid", value)
  case class subtotal(override val value: BigDecimal) extends SalesorderheaderFieldValue("subtotal", value)
  case class taxamt(override val value: BigDecimal) extends SalesorderheaderFieldValue("taxamt", value)
  case class freight(override val value: BigDecimal) extends SalesorderheaderFieldValue("freight", value)
  case class totaldue(override val value: Option[BigDecimal]) extends SalesorderheaderFieldValue("totaldue", value)
  case class comment(override val value: Option[/* max 128 chars */ String]) extends SalesorderheaderFieldValue("comment", value)
  case class rowguid(override val value: UUID) extends SalesorderheaderFieldValue("rowguid", value)
  case class modifieddate(override val value: LocalDateTime) extends SalesorderheaderFieldValue("modifieddate", value)
}