/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_statistic_ext

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgStatisticExtRepoImpl extends PgStatisticExtRepo {
  override def delete(oid: PgStatisticExtId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_statistic_ext where oid = ${oid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgStatisticExtRow): ConnectionIO[PgStatisticExtRow] = {
    sql"""insert into pg_catalog.pg_statistic_ext(oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs)
          values (${unsaved.oid}::oid, ${unsaved.stxrelid}::oid, ${unsaved.stxname}::name, ${unsaved.stxnamespace}::oid, ${unsaved.stxowner}::oid, ${unsaved.stxstattarget}::int4, ${unsaved.stxkeys}::int2vector, ${unsaved.stxkind}::_char, ${unsaved.stxexprs}::pg_node_tree)
          returning oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs
       """.query[PgStatisticExtRow].unique
  }
  override def selectAll: Stream[ConnectionIO, PgStatisticExtRow] = {
    sql"select oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs from pg_catalog.pg_statistic_ext".query[PgStatisticExtRow].stream
  }
  override def selectById(oid: PgStatisticExtId): ConnectionIO[Option[PgStatisticExtRow]] = {
    sql"select oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs from pg_catalog.pg_statistic_ext where oid = ${oid}".query[PgStatisticExtRow].option
  }
  override def selectByIds(oids: Array[PgStatisticExtId]): Stream[ConnectionIO, PgStatisticExtRow] = {
    sql"select oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs from pg_catalog.pg_statistic_ext where oid = ANY(${oids})".query[PgStatisticExtRow].stream
  }
  override def update(row: PgStatisticExtRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_statistic_ext
          set stxrelid = ${row.stxrelid}::oid,
              stxname = ${row.stxname}::name,
              stxnamespace = ${row.stxnamespace}::oid,
              stxowner = ${row.stxowner}::oid,
              stxstattarget = ${row.stxstattarget}::int4,
              stxkeys = ${row.stxkeys}::int2vector,
              stxkind = ${row.stxkind}::_char,
              stxexprs = ${row.stxexprs}::pg_node_tree
          where oid = ${oid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgStatisticExtRow): ConnectionIO[PgStatisticExtRow] = {
    sql"""insert into pg_catalog.pg_statistic_ext(oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.stxrelid}::oid,
            ${unsaved.stxname}::name,
            ${unsaved.stxnamespace}::oid,
            ${unsaved.stxowner}::oid,
            ${unsaved.stxstattarget}::int4,
            ${unsaved.stxkeys}::int2vector,
            ${unsaved.stxkind}::_char,
            ${unsaved.stxexprs}::pg_node_tree
          )
          on conflict (oid)
          do update set
            stxrelid = EXCLUDED.stxrelid,
            stxname = EXCLUDED.stxname,
            stxnamespace = EXCLUDED.stxnamespace,
            stxowner = EXCLUDED.stxowner,
            stxstattarget = EXCLUDED.stxstattarget,
            stxkeys = EXCLUDED.stxkeys,
            stxkind = EXCLUDED.stxkind,
            stxexprs = EXCLUDED.stxexprs
          returning oid, stxrelid, stxname, stxnamespace, stxowner, stxstattarget, stxkeys, stxkind, stxexprs
       """.query[PgStatisticExtRow].unique
  }
}
