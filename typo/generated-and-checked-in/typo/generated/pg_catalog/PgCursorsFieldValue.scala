/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import java.time.ZonedDateTime

sealed abstract class PgCursorsFieldValue[T](val name: String, val value: T)

object PgCursorsFieldValue {
  case class name(override val value: Option[String]) extends PgCursorsFieldValue("name", value)
  case class statement(override val value: Option[String]) extends PgCursorsFieldValue("statement", value)
  case class isHoldable(override val value: Option[Boolean]) extends PgCursorsFieldValue("is_holdable", value)
  case class isBinary(override val value: Option[Boolean]) extends PgCursorsFieldValue("is_binary", value)
  case class isScrollable(override val value: Option[Boolean]) extends PgCursorsFieldValue("is_scrollable", value)
  case class creationTime(override val value: Option[ZonedDateTime]) extends PgCursorsFieldValue("creation_time", value)
}