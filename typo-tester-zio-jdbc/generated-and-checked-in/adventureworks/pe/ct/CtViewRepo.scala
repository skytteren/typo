/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package ct

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait CtViewRepo {
  def select: SelectBuilder[CtViewFields, CtViewRow]
  def selectAll: ZStream[ZConnection, Throwable, CtViewRow]
}