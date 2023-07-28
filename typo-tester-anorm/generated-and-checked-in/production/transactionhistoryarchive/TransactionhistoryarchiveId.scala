/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistoryarchive

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Type for the primary key of table `production.transactionhistoryarchive` */
case class TransactionhistoryarchiveId(value: Int) extends AnyVal
object TransactionhistoryarchiveId {
  implicit val arrayToStatement: ToStatement[Array[TransactionhistoryarchiveId]] = implicitly[ToStatement[Array[Int]]].contramap(_.map(_.value))
  implicit val column: Column[TransactionhistoryarchiveId] = implicitly[Column[Int]].map(TransactionhistoryarchiveId.apply)
  implicit val ordering: Ordering[TransactionhistoryarchiveId] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[TransactionhistoryarchiveId] = new ParameterMetaData[TransactionhistoryarchiveId] {
    override def sqlType: String = implicitly[ParameterMetaData[Int]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[Int]].jdbcType
  }
  implicit val reads: Reads[TransactionhistoryarchiveId] = implicitly[Reads[Int]].map(TransactionhistoryarchiveId.apply)
  implicit val toStatement: ToStatement[TransactionhistoryarchiveId] = implicitly[ToStatement[Int]].contramap(_.value)
  implicit val writes: Writes[TransactionhistoryarchiveId] = implicitly[Writes[Int]].contramap(_.value)
}
