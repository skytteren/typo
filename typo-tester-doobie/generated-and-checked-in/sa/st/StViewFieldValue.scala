/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package st

import adventureworks.person.countryregion.CountryregionId
import adventureworks.public.Name
import adventureworks.sales.salesterritory.SalesterritoryId
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class StViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class StViewFieldValue[T](name: String, value: T) extends StViewFieldOrIdValue(name, value)

object StViewFieldValue {
  case class id(override val value: Option[Int]) extends StViewFieldValue("id", value)
  case class territoryid(override val value: Option[SalesterritoryId]) extends StViewFieldValue("territoryid", value)
  case class name(override val value: Option[Name]) extends StViewFieldValue("name", value)
  case class countryregioncode(override val value: Option[CountryregionId]) extends StViewFieldValue("countryregioncode", value)
  case class group(override val value: Option[/* max 50 chars */ String]) extends StViewFieldValue("group", value)
  case class salesytd(override val value: Option[BigDecimal]) extends StViewFieldValue("salesytd", value)
  case class saleslastyear(override val value: Option[BigDecimal]) extends StViewFieldValue("saleslastyear", value)
  case class costytd(override val value: Option[BigDecimal]) extends StViewFieldValue("costytd", value)
  case class costlastyear(override val value: Option[BigDecimal]) extends StViewFieldValue("costlastyear", value)
  case class rowguid(override val value: Option[UUID]) extends StViewFieldValue("rowguid", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends StViewFieldValue("modifieddate", value)
}