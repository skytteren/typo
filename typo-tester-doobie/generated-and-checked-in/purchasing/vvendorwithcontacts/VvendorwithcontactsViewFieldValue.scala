/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vvendorwithcontacts

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.Phone

sealed abstract class VvendorwithcontactsViewFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class VvendorwithcontactsViewFieldValue[T](name: String, value: T) extends VvendorwithcontactsViewFieldOrIdValue(name, value)

object VvendorwithcontactsViewFieldValue {
  case class businessentityid(override val value: Option[BusinessentityId]) extends VvendorwithcontactsViewFieldValue("businessentityid", value)
  case class name(override val value: Option[Name]) extends VvendorwithcontactsViewFieldValue("name", value)
  case class contacttype(override val value: Option[Name]) extends VvendorwithcontactsViewFieldValue("contacttype", value)
  case class title(override val value: Option[/* max 8 chars */ String]) extends VvendorwithcontactsViewFieldValue("title", value)
  case class firstname(override val value: Option[Name]) extends VvendorwithcontactsViewFieldValue("firstname", value)
  case class middlename(override val value: Option[Name]) extends VvendorwithcontactsViewFieldValue("middlename", value)
  case class lastname(override val value: Option[Name]) extends VvendorwithcontactsViewFieldValue("lastname", value)
  case class suffix(override val value: Option[/* max 10 chars */ String]) extends VvendorwithcontactsViewFieldValue("suffix", value)
  case class phonenumber(override val value: Option[Phone]) extends VvendorwithcontactsViewFieldValue("phonenumber", value)
  case class phonenumbertype(override val value: Option[Name]) extends VvendorwithcontactsViewFieldValue("phonenumbertype", value)
  case class emailaddress(override val value: Option[/* max 50 chars */ String]) extends VvendorwithcontactsViewFieldValue("emailaddress", value)
  case class emailpromotion(override val value: Option[Int]) extends VvendorwithcontactsViewFieldValue("emailpromotion", value)
}