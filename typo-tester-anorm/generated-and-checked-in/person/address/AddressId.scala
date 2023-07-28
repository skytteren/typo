/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `person.address` */
case class AddressId(value: Int) extends AnyVal
object AddressId {
  implicit val arrayToStatement: ToStatement[Array[AddressId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit val column: Column[AddressId] = implicitly[Column[Int]].map(AddressId.apply)
  implicit val ordering: Ordering[AddressId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[AddressId] = new ParameterMetaData[AddressId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit val reads: Reads[AddressId] = implicitly[Reads[Int]].map(AddressId.apply)
  implicit val toStatement: ToStatement[AddressId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val writes: Writes[AddressId] = implicitly[Writes[Int]].contramap(_.value)
}
