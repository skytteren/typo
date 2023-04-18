/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package cc

import adventureworks.sales.creditcard.CreditcardId
import java.time.LocalDateTime

sealed abstract class CcFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class CcFieldValue[T](name: String, value: T) extends CcFieldOrIdValue(name, value)

object CcFieldValue {
  case class id(override val value: Option[Int]) extends CcFieldValue("id", value)
  case class creditcardid(override val value: Option[CreditcardId]) extends CcFieldValue("creditcardid", value)
  case class cardtype(override val value: Option[String]) extends CcFieldValue("cardtype", value)
  case class cardnumber(override val value: Option[String]) extends CcFieldValue("cardnumber", value)
  case class expmonth(override val value: Option[Int]) extends CcFieldValue("expmonth", value)
  case class expyear(override val value: Option[Int]) extends CcFieldValue("expyear", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends CcFieldValue("modifieddate", value)
}