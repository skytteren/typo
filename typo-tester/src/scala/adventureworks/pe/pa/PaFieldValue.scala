/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pa

import adventureworks.person.businessentity.BusinessentityId
import java.time.LocalDateTime
import java.util.UUID

sealed abstract class PaFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class PaFieldValue[T](name: String, value: T) extends PaFieldOrIdValue(name, value)

object PaFieldValue {
  case class id(override val value: Option[Int]) extends PaFieldValue("id", value)
  case class businessentityid(override val value: Option[BusinessentityId]) extends PaFieldValue("businessentityid", value)
  case class passwordhash(override val value: Option[String]) extends PaFieldValue("passwordhash", value)
  case class passwordsalt(override val value: Option[String]) extends PaFieldValue("passwordsalt", value)
  case class rowguid(override val value: Option[UUID]) extends PaFieldValue("rowguid", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends PaFieldValue("modifieddate", value)
}