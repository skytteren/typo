/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_data_wrapper_options

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait ForeignDataWrapperOptionsViewRepo {
  def select: SelectBuilder[ForeignDataWrapperOptionsViewFields, ForeignDataWrapperOptionsViewRow]
  def selectAll: ZStream[ZConnection, Throwable, ForeignDataWrapperOptionsViewRow]
}