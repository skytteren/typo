/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_sequences

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgSequencesViewRepo {
  def select: SelectBuilder[PgSequencesViewFields, PgSequencesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgSequencesViewRow]
}