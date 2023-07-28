/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_database

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgDatabaseRepoImpl extends PgDatabaseRepo {
  override def delete(oid: PgDatabaseId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_database where oid = ${oid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgDatabaseRow): ConnectionIO[PgDatabaseRow] = {
    sql"""insert into pg_catalog.pg_database(oid, datname, datdba, "encoding", datcollate, datctype, datistemplate, datallowconn, datconnlimit, datlastsysoid, datfrozenxid, datminmxid, dattablespace, datacl)
          values (${unsaved.oid}::oid, ${unsaved.datname}::name, ${unsaved.datdba}::oid, ${unsaved.encoding}::int4, ${unsaved.datcollate}::name, ${unsaved.datctype}::name, ${unsaved.datistemplate}, ${unsaved.datallowconn}, ${unsaved.datconnlimit}::int4, ${unsaved.datlastsysoid}::oid, ${unsaved.datfrozenxid}::xid, ${unsaved.datminmxid}::xid, ${unsaved.dattablespace}::oid, ${unsaved.datacl}::_aclitem)
          returning oid, datname, datdba, "encoding", datcollate, datctype, datistemplate, datallowconn, datconnlimit, datlastsysoid, datfrozenxid, datminmxid, dattablespace, datacl
       """.query[PgDatabaseRow].unique
  }
  override def selectAll: Stream[ConnectionIO, PgDatabaseRow] = {
    sql"""select oid, datname, datdba, "encoding", datcollate, datctype, datistemplate, datallowconn, datconnlimit, datlastsysoid, datfrozenxid, datminmxid, dattablespace, datacl from pg_catalog.pg_database""".query[PgDatabaseRow].stream
  }
  override def selectById(oid: PgDatabaseId): ConnectionIO[Option[PgDatabaseRow]] = {
    sql"""select oid, datname, datdba, "encoding", datcollate, datctype, datistemplate, datallowconn, datconnlimit, datlastsysoid, datfrozenxid, datminmxid, dattablespace, datacl from pg_catalog.pg_database where oid = ${oid}""".query[PgDatabaseRow].option
  }
  override def selectByIds(oids: Array[PgDatabaseId]): Stream[ConnectionIO, PgDatabaseRow] = {
    sql"""select oid, datname, datdba, "encoding", datcollate, datctype, datistemplate, datallowconn, datconnlimit, datlastsysoid, datfrozenxid, datminmxid, dattablespace, datacl from pg_catalog.pg_database where oid = ANY(${oids})""".query[PgDatabaseRow].stream
  }
  override def update(row: PgDatabaseRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_database
          set datname = ${row.datname}::name,
              datdba = ${row.datdba}::oid,
              "encoding" = ${row.encoding}::int4,
              datcollate = ${row.datcollate}::name,
              datctype = ${row.datctype}::name,
              datistemplate = ${row.datistemplate},
              datallowconn = ${row.datallowconn},
              datconnlimit = ${row.datconnlimit}::int4,
              datlastsysoid = ${row.datlastsysoid}::oid,
              datfrozenxid = ${row.datfrozenxid}::xid,
              datminmxid = ${row.datminmxid}::xid,
              dattablespace = ${row.dattablespace}::oid,
              datacl = ${row.datacl}::_aclitem
          where oid = ${oid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgDatabaseRow): ConnectionIO[PgDatabaseRow] = {
    sql"""insert into pg_catalog.pg_database(oid, datname, datdba, "encoding", datcollate, datctype, datistemplate, datallowconn, datconnlimit, datlastsysoid, datfrozenxid, datminmxid, dattablespace, datacl)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.datname}::name,
            ${unsaved.datdba}::oid,
            ${unsaved.encoding}::int4,
            ${unsaved.datcollate}::name,
            ${unsaved.datctype}::name,
            ${unsaved.datistemplate},
            ${unsaved.datallowconn},
            ${unsaved.datconnlimit}::int4,
            ${unsaved.datlastsysoid}::oid,
            ${unsaved.datfrozenxid}::xid,
            ${unsaved.datminmxid}::xid,
            ${unsaved.dattablespace}::oid,
            ${unsaved.datacl}::_aclitem
          )
          on conflict (oid)
          do update set
            datname = EXCLUDED.datname,
            datdba = EXCLUDED.datdba,
            "encoding" = EXCLUDED."encoding",
            datcollate = EXCLUDED.datcollate,
            datctype = EXCLUDED.datctype,
            datistemplate = EXCLUDED.datistemplate,
            datallowconn = EXCLUDED.datallowconn,
            datconnlimit = EXCLUDED.datconnlimit,
            datlastsysoid = EXCLUDED.datlastsysoid,
            datfrozenxid = EXCLUDED.datfrozenxid,
            datminmxid = EXCLUDED.datminmxid,
            dattablespace = EXCLUDED.dattablespace,
            datacl = EXCLUDED.datacl
          returning oid, datname, datdba, "encoding", datcollate, datctype, datistemplate, datallowconn, datconnlimit, datlastsysoid, datfrozenxid, datminmxid, dattablespace, datacl
       """.query[PgDatabaseRow].unique
  }
}
