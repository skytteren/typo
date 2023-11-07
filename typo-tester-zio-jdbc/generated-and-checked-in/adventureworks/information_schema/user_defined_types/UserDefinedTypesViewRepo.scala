/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package user_defined_types

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait UserDefinedTypesViewRepo {
  def select: SelectBuilder[UserDefinedTypesViewFields, UserDefinedTypesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, UserDefinedTypesViewRow]
}