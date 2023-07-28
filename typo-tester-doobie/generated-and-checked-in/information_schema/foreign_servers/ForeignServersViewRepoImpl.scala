/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_servers

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object ForeignServersViewRepoImpl extends ForeignServersViewRepo {
  override def selectAll: Stream[ConnectionIO, ForeignServersViewRow] = {
    sql"select foreign_server_catalog, foreign_server_name, foreign_data_wrapper_catalog, foreign_data_wrapper_name, foreign_server_type, foreign_server_version, authorization_identifier from information_schema.foreign_servers".query(ForeignServersViewRow.read).stream
  }
}
