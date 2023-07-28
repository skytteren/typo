/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorder

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `production.workorder` */
case class WorkorderId(value: Int) extends AnyVal
object WorkorderId {
  implicit val arrayToStatement: ToStatement[Array[WorkorderId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit val column: Column[WorkorderId] = implicitly[Column[Int]].map(WorkorderId.apply)
  implicit val ordering: Ordering[WorkorderId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[WorkorderId] = new ParameterMetaData[WorkorderId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit val reads: Reads[WorkorderId] = implicitly[Reads[Int]].map(WorkorderId.apply)
  implicit val toStatement: ToStatement[WorkorderId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val writes: Writes[WorkorderId] = implicitly[Writes[Int]].contramap(_.value)
}
