/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_range

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgRangeRepoImpl extends PgRangeRepo {
  override def delete(rngtypid: PgRangeId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_range where rngtypid = ${rngtypid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgRangeRow): ConnectionIO[PgRangeRow] = {
    sql"""insert into pg_catalog.pg_range(rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff)
          values (${unsaved.rngtypid}::oid, ${unsaved.rngsubtype}::oid, ${unsaved.rngmultitypid}::oid, ${unsaved.rngcollation}::oid, ${unsaved.rngsubopc}::oid, ${unsaved.rngcanonical}::regproc, ${unsaved.rngsubdiff}::regproc)
          returning rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff
       """.query(PgRangeRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgRangeRow] = {
    sql"select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff from pg_catalog.pg_range".query(PgRangeRow.read).stream
  }
  override def selectById(rngtypid: PgRangeId): ConnectionIO[Option[PgRangeRow]] = {
    sql"select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff from pg_catalog.pg_range where rngtypid = ${rngtypid}".query(PgRangeRow.read).option
  }
  override def selectByIds(rngtypids: Array[PgRangeId]): Stream[ConnectionIO, PgRangeRow] = {
    sql"select rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff from pg_catalog.pg_range where rngtypid = ANY(${rngtypids})".query(PgRangeRow.read).stream
  }
  override def update(row: PgRangeRow): ConnectionIO[Boolean] = {
    val rngtypid = row.rngtypid
    sql"""update pg_catalog.pg_range
          set rngsubtype = ${row.rngsubtype}::oid,
              rngmultitypid = ${row.rngmultitypid}::oid,
              rngcollation = ${row.rngcollation}::oid,
              rngsubopc = ${row.rngsubopc}::oid,
              rngcanonical = ${row.rngcanonical}::regproc,
              rngsubdiff = ${row.rngsubdiff}::regproc
          where rngtypid = ${rngtypid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgRangeRow): ConnectionIO[PgRangeRow] = {
    sql"""insert into pg_catalog.pg_range(rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff)
          values (
            ${unsaved.rngtypid}::oid,
            ${unsaved.rngsubtype}::oid,
            ${unsaved.rngmultitypid}::oid,
            ${unsaved.rngcollation}::oid,
            ${unsaved.rngsubopc}::oid,
            ${unsaved.rngcanonical}::regproc,
            ${unsaved.rngsubdiff}::regproc
          )
          on conflict (rngtypid)
          do update set
            rngsubtype = EXCLUDED.rngsubtype,
            rngmultitypid = EXCLUDED.rngmultitypid,
            rngcollation = EXCLUDED.rngcollation,
            rngsubopc = EXCLUDED.rngsubopc,
            rngcanonical = EXCLUDED.rngcanonical,
            rngsubdiff = EXCLUDED.rngsubdiff
          returning rngtypid, rngsubtype, rngmultitypid, rngcollation, rngsubopc, rngcanonical, rngsubdiff
       """.query(PgRangeRow.read).unique
  }
}
