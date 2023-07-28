/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_replication_origin

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgReplicationOriginRepoImpl extends PgReplicationOriginRepo {
  override def delete(roident: PgReplicationOriginId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_replication_origin where roident = ${roident}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgReplicationOriginRow): ConnectionIO[PgReplicationOriginRow] = {
    sql"""insert into pg_catalog.pg_replication_origin(roident, roname)
          values (${unsaved.roident}::oid, ${unsaved.roname})
          returning roident, roname
       """.query(PgReplicationOriginRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgReplicationOriginRow] = {
    sql"select roident, roname from pg_catalog.pg_replication_origin".query(PgReplicationOriginRow.read).stream
  }
  override def selectById(roident: PgReplicationOriginId): ConnectionIO[Option[PgReplicationOriginRow]] = {
    sql"select roident, roname from pg_catalog.pg_replication_origin where roident = ${roident}".query(PgReplicationOriginRow.read).option
  }
  override def selectByIds(roidents: Array[PgReplicationOriginId]): Stream[ConnectionIO, PgReplicationOriginRow] = {
    sql"select roident, roname from pg_catalog.pg_replication_origin where roident = ANY(${roidents})".query(PgReplicationOriginRow.read).stream
  }
  override def update(row: PgReplicationOriginRow): ConnectionIO[Boolean] = {
    val roident = row.roident
    sql"""update pg_catalog.pg_replication_origin
          set roname = ${row.roname}
          where roident = ${roident}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgReplicationOriginRow): ConnectionIO[PgReplicationOriginRow] = {
    sql"""insert into pg_catalog.pg_replication_origin(roident, roname)
          values (
            ${unsaved.roident}::oid,
            ${unsaved.roname}
          )
          on conflict (roident)
          do update set
            roname = EXCLUDED.roname
          returning roident, roname
       """.query(PgReplicationOriginRow.read).unique
  }
}
