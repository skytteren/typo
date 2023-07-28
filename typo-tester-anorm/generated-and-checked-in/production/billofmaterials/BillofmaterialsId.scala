/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `production.billofmaterials` */
case class BillofmaterialsId(value: Int) extends AnyVal
object BillofmaterialsId {
  implicit val arrayToStatement: ToStatement[Array[BillofmaterialsId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit val column: Column[BillofmaterialsId] = implicitly[Column[Int]].map(BillofmaterialsId.apply)
  implicit val ordering: Ordering[BillofmaterialsId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[BillofmaterialsId] = new ParameterMetaData[BillofmaterialsId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit val reads: Reads[BillofmaterialsId] = implicitly[Reads[Int]].map(BillofmaterialsId.apply)
  implicit val toStatement: ToStatement[BillofmaterialsId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val writes: Writes[BillofmaterialsId] = implicitly[Writes[Int]].contramap(_.value)
}
