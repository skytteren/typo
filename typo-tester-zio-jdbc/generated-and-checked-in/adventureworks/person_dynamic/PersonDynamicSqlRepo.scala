/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person_dynamic

import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PersonDynamicSqlRepo {
  def apply(firstName: Option[String]): ZStream[ZConnection, Throwable, PersonDynamicSqlRow]
}