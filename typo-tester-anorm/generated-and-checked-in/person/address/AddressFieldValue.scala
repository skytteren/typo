/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.person.stateprovince.StateprovinceId
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class AddressFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class AddressFieldValue[T](name: String, value: T) extends AddressFieldOrIdValue(name, value)

object AddressFieldValue {
  case class addressid(override val value: AddressId) extends AddressFieldOrIdValue("addressid", value)
  case class addressline1(override val value: /* max 60 chars */ String) extends AddressFieldValue("addressline1", value)
  case class addressline2(override val value: Option[/* max 60 chars */ String]) extends AddressFieldValue("addressline2", value)
  case class city(override val value: /* max 30 chars */ String) extends AddressFieldValue("city", value)
  case class stateprovinceid(override val value: StateprovinceId) extends AddressFieldValue("stateprovinceid", value)
  case class postalcode(override val value: /* max 15 chars */ String) extends AddressFieldValue("postalcode", value)
  case class spatiallocation(override val value: Option[Array[Byte]]) extends AddressFieldValue("spatiallocation", value)
  case class rowguid(override val value: UUID) extends AddressFieldValue("rowguid", value)
  case class modifieddate(override val value: LocalDateTime) extends AddressFieldValue("modifieddate", value)
}