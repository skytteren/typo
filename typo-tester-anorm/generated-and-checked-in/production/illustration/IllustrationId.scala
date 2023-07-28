/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package illustration

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `production.illustration` */
case class IllustrationId(value: Int) extends AnyVal
object IllustrationId {
  implicit val arrayToStatement: ToStatement[Array[IllustrationId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit val column: Column[IllustrationId] = implicitly[Column[Int]].map(IllustrationId.apply)
  implicit val ordering: Ordering[IllustrationId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[IllustrationId] = new ParameterMetaData[IllustrationId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit val reads: Reads[IllustrationId] = implicitly[Reads[Int]].map(IllustrationId.apply)
  implicit val toStatement: ToStatement[IllustrationId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val writes: Writes[IllustrationId] = implicitly[Writes[Int]].contramap(_.value)
}
