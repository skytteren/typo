/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Domain `public.OrderNumber`
  * No constraint
  */
case class OrderNumber(value: String) extends AnyVal
object OrderNumber {
  implicit lazy val arraySetter: Setter[Array[OrderNumber]] = adventureworks.StringArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[OrderNumber, String] = Bijection[OrderNumber, String](_.value)(OrderNumber.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[OrderNumber] = JdbcDecoder.stringDecoder.map(OrderNumber.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[OrderNumber] = JdbcEncoder.stringEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[OrderNumber] = JsonDecoder.string.map(OrderNumber.apply)
  implicit lazy val jsonEncoder: JsonEncoder[OrderNumber] = JsonEncoder.string.contramap(_.value)
  implicit lazy val ordering: Ordering[OrderNumber] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[OrderNumber] = ParameterMetaData.instance[OrderNumber](ParameterMetaData.StringParameterMetaData.sqlType, ParameterMetaData.StringParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[OrderNumber] = Setter.stringSetter.contramap(_.value)
}