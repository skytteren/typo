/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_hba_file_rules

import typo.dsl.SelectBuilder
import zio.jdbc.ZConnection
import zio.stream.ZStream

trait PgHbaFileRulesViewRepo {
  def select: SelectBuilder[PgHbaFileRulesViewFields, PgHbaFileRulesViewRow]
  def selectAll: ZStream[ZConnection, Throwable, PgHbaFileRulesViewRow]
}