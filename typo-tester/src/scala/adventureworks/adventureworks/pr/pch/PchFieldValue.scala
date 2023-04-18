/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pch

import adventureworks.production.product.ProductId
import java.time.LocalDateTime

sealed abstract class PchFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class PchFieldValue[T](name: String, value: T) extends PchFieldOrIdValue(name, value)

object PchFieldValue {
  case class id(override val value: Option[Int]) extends PchFieldValue("id", value)
  case class productid(override val value: Option[ProductId]) extends PchFieldValue("productid", value)
  case class startdate(override val value: Option[LocalDateTime]) extends PchFieldValue("startdate", value)
  case class enddate(override val value: Option[LocalDateTime]) extends PchFieldValue("enddate", value)
  case class standardcost(override val value: Option[BigDecimal]) extends PchFieldValue("standardcost", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends PchFieldValue("modifieddate", value)
}