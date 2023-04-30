/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package plph

import adventureworks.production.product.ProductId
import java.time.LocalDateTime

sealed abstract class PlphFieldOrIdValue[T](val name: String, val value: T)
sealed abstract class PlphFieldValue[T](name: String, value: T) extends PlphFieldOrIdValue(name, value)

object PlphFieldValue {
  case class id(override val value: Option[Int]) extends PlphFieldValue("id", value)
  case class productid(override val value: Option[ProductId]) extends PlphFieldValue("productid", value)
  case class startdate(override val value: Option[LocalDateTime]) extends PlphFieldValue("startdate", value)
  case class enddate(override val value: Option[LocalDateTime]) extends PlphFieldValue("enddate", value)
  case class listprice(override val value: Option[BigDecimal]) extends PlphFieldValue("listprice", value)
  case class modifieddate(override val value: Option[LocalDateTime]) extends PlphFieldValue("modifieddate", value)
}