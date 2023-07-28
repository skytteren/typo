/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_server

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgForeignServerRepoImpl extends PgForeignServerRepo {
  override def delete(oid: PgForeignServerId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_foreign_server where oid = ${oid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgForeignServerRow): ConnectionIO[PgForeignServerRow] = {
    sql"""insert into pg_catalog.pg_foreign_server(oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions)
          values (${unsaved.oid}::oid, ${unsaved.srvname}::name, ${unsaved.srvowner}::oid, ${unsaved.srvfdw}::oid, ${unsaved.srvtype}, ${unsaved.srvversion}, ${unsaved.srvacl}::_aclitem, ${unsaved.srvoptions}::_text)
          returning oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions
       """.query(PgForeignServerRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgForeignServerRow] = {
    sql"select oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions from pg_catalog.pg_foreign_server".query(PgForeignServerRow.read).stream
  }
  override def selectById(oid: PgForeignServerId): ConnectionIO[Option[PgForeignServerRow]] = {
    sql"select oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions from pg_catalog.pg_foreign_server where oid = ${oid}".query(PgForeignServerRow.read).option
  }
  override def selectByIds(oids: Array[PgForeignServerId]): Stream[ConnectionIO, PgForeignServerRow] = {
    sql"select oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions from pg_catalog.pg_foreign_server where oid = ANY(${oids})".query(PgForeignServerRow.read).stream
  }
  override def update(row: PgForeignServerRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_foreign_server
          set srvname = ${row.srvname}::name,
              srvowner = ${row.srvowner}::oid,
              srvfdw = ${row.srvfdw}::oid,
              srvtype = ${row.srvtype},
              srvversion = ${row.srvversion},
              srvacl = ${row.srvacl}::_aclitem,
              srvoptions = ${row.srvoptions}::_text
          where oid = ${oid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgForeignServerRow): ConnectionIO[PgForeignServerRow] = {
    sql"""insert into pg_catalog.pg_foreign_server(oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.srvname}::name,
            ${unsaved.srvowner}::oid,
            ${unsaved.srvfdw}::oid,
            ${unsaved.srvtype},
            ${unsaved.srvversion},
            ${unsaved.srvacl}::_aclitem,
            ${unsaved.srvoptions}::_text
          )
          on conflict (oid)
          do update set
            srvname = EXCLUDED.srvname,
            srvowner = EXCLUDED.srvowner,
            srvfdw = EXCLUDED.srvfdw,
            srvtype = EXCLUDED.srvtype,
            srvversion = EXCLUDED.srvversion,
            srvacl = EXCLUDED.srvacl,
            srvoptions = EXCLUDED.srvoptions
          returning oid, srvname, srvowner, srvfdw, srvtype, srvversion, srvacl, srvoptions
       """.query(PgForeignServerRow.read).unique
  }
}
