/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package pgtest

import doobie.free.connection.ConnectionIO
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.UpdateBuilder

trait PgtestRepo {
  def delete: DeleteBuilder[PgtestFields, PgtestRow]
  def insert(unsaved: PgtestRow): ConnectionIO[PgtestRow]
  def insertStreaming(unsaved: Stream[ConnectionIO, PgtestRow], batchSize: Int = 10000): ConnectionIO[Long]
  def select: SelectBuilder[PgtestFields, PgtestRow]
  def selectAll: Stream[ConnectionIO, PgtestRow]
  def update: UpdateBuilder[PgtestFields, PgtestRow]
}
