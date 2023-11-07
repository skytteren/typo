/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_file_settings

import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgFileSettingsViewRepoImpl extends PgFileSettingsViewRepo {
  override def select: SelectBuilder[PgFileSettingsViewFields, PgFileSettingsViewRow] = {
    SelectBuilderSql("pg_catalog.pg_file_settings", PgFileSettingsViewFields, PgFileSettingsViewRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgFileSettingsViewRow] = {
    sql"""select "sourcefile", "sourceline", "seqno", "name", "setting", "applied", "error" from pg_catalog.pg_file_settings""".query(PgFileSettingsViewRow.jdbcDecoder).selectStream
  }
}