/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_ts_parser

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgTsParserRepoImpl extends PgTsParserRepo {
  override def delete(oid: PgTsParserId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_ts_parser where oid = $oid".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgTsParserRow): ConnectionIO[PgTsParserRow] = {
    sql"""insert into pg_catalog.pg_ts_parser(oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype)
          values (${unsaved.oid}::oid, ${unsaved.prsname}::name, ${unsaved.prsnamespace}::oid, ${unsaved.prsstart}::regproc, ${unsaved.prstoken}::regproc, ${unsaved.prsend}::regproc, ${unsaved.prsheadline}::regproc, ${unsaved.prslextype}::regproc)
          returning oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
       """.query[PgTsParserRow].unique
  }
  override def selectAll: Stream[ConnectionIO, PgTsParserRow] = {
    sql"select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype from pg_catalog.pg_ts_parser".query[PgTsParserRow].stream
  }
  override def selectById(oid: PgTsParserId): ConnectionIO[Option[PgTsParserRow]] = {
    sql"select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype from pg_catalog.pg_ts_parser where oid = $oid".query[PgTsParserRow].option
  }
  override def selectByIds(oids: Array[PgTsParserId]): Stream[ConnectionIO, PgTsParserRow] = {
    sql"select oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype from pg_catalog.pg_ts_parser where oid = ANY($oids)".query[PgTsParserRow].stream
  }
  override def update(row: PgTsParserRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_ts_parser
          set prsname = ${row.prsname}::name,
              prsnamespace = ${row.prsnamespace}::oid,
              prsstart = ${row.prsstart}::regproc,
              prstoken = ${row.prstoken}::regproc,
              prsend = ${row.prsend}::regproc,
              prsheadline = ${row.prsheadline}::regproc,
              prslextype = ${row.prslextype}::regproc
          where oid = $oid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgTsParserRow): ConnectionIO[PgTsParserRow] = {
    sql"""insert into pg_catalog.pg_ts_parser(oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.prsname}::name,
            ${unsaved.prsnamespace}::oid,
            ${unsaved.prsstart}::regproc,
            ${unsaved.prstoken}::regproc,
            ${unsaved.prsend}::regproc,
            ${unsaved.prsheadline}::regproc,
            ${unsaved.prslextype}::regproc
          )
          on conflict (oid)
          do update set
            prsname = EXCLUDED.prsname,
            prsnamespace = EXCLUDED.prsnamespace,
            prsstart = EXCLUDED.prsstart,
            prstoken = EXCLUDED.prstoken,
            prsend = EXCLUDED.prsend,
            prsheadline = EXCLUDED.prsheadline,
            prslextype = EXCLUDED.prslextype
          returning oid, prsname, prsnamespace, prsstart, prstoken, prsend, prsheadline, prslextype
       """.query[PgTsParserRow].unique
  }
}