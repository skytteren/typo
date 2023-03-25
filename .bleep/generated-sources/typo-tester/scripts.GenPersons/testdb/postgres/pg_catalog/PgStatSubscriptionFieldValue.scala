/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import java.time.ZonedDateTime

sealed abstract class PgStatSubscriptionFieldValue[T](val name: String, val value: T)

object PgStatSubscriptionFieldValue {
  case class subid(override val value: Option[Long]) extends PgStatSubscriptionFieldValue("subid", value)
  case class subname(override val value: Option[String]) extends PgStatSubscriptionFieldValue("subname", value)
  case class pid(override val value: Option[Int]) extends PgStatSubscriptionFieldValue("pid", value)
  case class relid(override val value: Option[Long]) extends PgStatSubscriptionFieldValue("relid", value)
  case class receivedLsn(override val value: Option[String]) extends PgStatSubscriptionFieldValue("received_lsn", value)
  case class lastMsgSendTime(override val value: Option[ZonedDateTime]) extends PgStatSubscriptionFieldValue("last_msg_send_time", value)
  case class lastMsgReceiptTime(override val value: Option[ZonedDateTime]) extends PgStatSubscriptionFieldValue("last_msg_receipt_time", value)
  case class latestEndLsn(override val value: Option[String]) extends PgStatSubscriptionFieldValue("latest_end_lsn", value)
  case class latestEndTime(override val value: Option[ZonedDateTime]) extends PgStatSubscriptionFieldValue("latest_end_time", value)
}