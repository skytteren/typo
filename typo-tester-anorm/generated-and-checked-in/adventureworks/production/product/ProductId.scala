/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package product

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes
import typo.dsl.Bijection

/** Type for the primary key of table `production.product` */
case class ProductId(value: Int) extends AnyVal
object ProductId {
  implicit lazy val arrayColumn: Column[Array[ProductId]] = Column.columnToArray(column, implicitly)
  implicit lazy val arrayToStatement: ToStatement[Array[ProductId]] = adventureworks.IntArrayToStatement.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[ProductId, Int] = Bijection[ProductId, Int](_.value)(ProductId.apply)
  implicit lazy val column: Column[ProductId] = Column.columnToInt.map(ProductId.apply)
  implicit lazy val ordering: Ordering[ProductId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[ProductId] = new ParameterMetaData[ProductId] {
    override def sqlType: String = ParameterMetaData.IntParameterMetaData.sqlType
    override def jdbcType: Int = ParameterMetaData.IntParameterMetaData.jdbcType
  }
  implicit lazy val reads: Reads[ProductId] = Reads.IntReads.map(ProductId.apply)
  implicit lazy val toStatement: ToStatement[ProductId] = ToStatement.intToStatement.contramap(_.value)
  implicit lazy val writes: Writes[ProductId] = Writes.IntWrites.contramap(_.value)
}