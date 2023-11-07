/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** Type for the primary key of table `production.transactionhistory` */
case class TransactionhistoryId(value: Int) extends AnyVal
object TransactionhistoryId {
  implicit lazy val arraySetter: Setter[Array[TransactionhistoryId]] = adventureworks.IntArraySetter.contramap(_.map(_.value))
  implicit lazy val bijection: Bijection[TransactionhistoryId, Int] = Bijection[TransactionhistoryId, Int](_.value)(TransactionhistoryId.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TransactionhistoryId] = JdbcDecoder.intDecoder.map(TransactionhistoryId.apply)
  implicit lazy val jdbcEncoder: JdbcEncoder[TransactionhistoryId] = JdbcEncoder.intEncoder.contramap(_.value)
  implicit lazy val jsonDecoder: JsonDecoder[TransactionhistoryId] = JsonDecoder.int.map(TransactionhistoryId.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TransactionhistoryId] = JsonEncoder.int.contramap(_.value)
  implicit lazy val ordering: Ordering[TransactionhistoryId] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TransactionhistoryId] = ParameterMetaData.instance[TransactionhistoryId](ParameterMetaData.IntParameterMetaData.sqlType, ParameterMetaData.IntParameterMetaData.jdbcType)
  implicit lazy val setter: Setter[TransactionhistoryId] = Setter.intSetter.contramap(_.value)
}