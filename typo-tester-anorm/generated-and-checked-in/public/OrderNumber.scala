/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Domain `public.OrderNumber`
  * No constraint
  */
case class OrderNumber(value: String) extends AnyVal
object OrderNumber {
  implicit val arrayToStatement: ToStatement[Array[OrderNumber]] = implicitly[ToStatement[Array[String]]].contramap(_.map(_.value))
  implicit val column: Column[OrderNumber] = implicitly[Column[String]].map(OrderNumber.apply)
  implicit val ordering: Ordering[OrderNumber] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[OrderNumber] = new ParameterMetaData[OrderNumber] {
    override def sqlType: String = implicitly[ParameterMetaData[String]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[String]].jdbcType
  }
  implicit val reads: Reads[OrderNumber] = implicitly[Reads[String]].map(OrderNumber.apply)
  implicit val toStatement: ToStatement[OrderNumber] = implicitly[ToStatement[String]].contramap(_.value)
  implicit val writes: Writes[OrderNumber] = implicitly[Writes[String]].contramap(_.value)
}
