/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class PersonFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class PersonFieldValue[T](name: String, value: T) extends PersonFieldOrIdValue(name, value)

object PersonFieldValue {
  case class businessentityid(override val value: BusinessentityId) extends PersonFieldOrIdValue("businessentityid", value)
  case class persontype(override val value: /* bpchar */ String) extends PersonFieldValue("persontype", value)
  case class namestyle(override val value: NameStyle) extends PersonFieldValue("namestyle", value)
  case class title(override val value: Option[/* max 8 chars */ String]) extends PersonFieldValue("title", value)
  case class firstname(override val value: Name) extends PersonFieldValue("firstname", value)
  case class middlename(override val value: Option[Name]) extends PersonFieldValue("middlename", value)
  case class lastname(override val value: Name) extends PersonFieldValue("lastname", value)
  case class suffix(override val value: Option[/* max 10 chars */ String]) extends PersonFieldValue("suffix", value)
  case class emailpromotion(override val value: Int) extends PersonFieldValue("emailpromotion", value)
  case class additionalcontactinfo(override val value: Option[TypoXml]) extends PersonFieldValue("additionalcontactinfo", value)
  case class demographics(override val value: Option[TypoXml]) extends PersonFieldValue("demographics", value)
  case class rowguid(override val value: UUID) extends PersonFieldValue("rowguid", value)
  case class modifieddate(override val value: LocalDateTime) extends PersonFieldValue("modifieddate", value)
}