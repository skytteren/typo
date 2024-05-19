/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package transactionhistory

import adventureworks.Text
import typo.dsl.Bijection
import typo.dsl.PGType
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
  implicit lazy val pgType: PGType[TransactionhistoryId] = PGType.PGTypeInt.as
  implicit lazy val setter: Setter[TransactionhistoryId] = Setter.intSetter.contramap(_.value)
  implicit lazy val text: Text[TransactionhistoryId] = new Text[TransactionhistoryId] {
    override def unsafeEncode(v: TransactionhistoryId, sb: StringBuilder) = Text.intInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: TransactionhistoryId, sb: StringBuilder) = Text.intInstance.unsafeArrayEncode(v.value, sb)
  }
}
