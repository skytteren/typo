/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_opfamily

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgOpfamilyRepoImpl extends PgOpfamilyRepo {
  override def delete(oid: PgOpfamilyId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_opfamily where oid = ${oid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgOpfamilyRow): ConnectionIO[PgOpfamilyRow] = {
    sql"""insert into pg_catalog.pg_opfamily(oid, opfmethod, opfname, opfnamespace, opfowner)
          values (${unsaved.oid}::oid, ${unsaved.opfmethod}::oid, ${unsaved.opfname}::name, ${unsaved.opfnamespace}::oid, ${unsaved.opfowner}::oid)
          returning oid, opfmethod, opfname, opfnamespace, opfowner
       """.query(PgOpfamilyRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgOpfamilyRow] = {
    sql"select oid, opfmethod, opfname, opfnamespace, opfowner from pg_catalog.pg_opfamily".query(PgOpfamilyRow.read).stream
  }
  override def selectById(oid: PgOpfamilyId): ConnectionIO[Option[PgOpfamilyRow]] = {
    sql"select oid, opfmethod, opfname, opfnamespace, opfowner from pg_catalog.pg_opfamily where oid = ${oid}".query(PgOpfamilyRow.read).option
  }
  override def selectByIds(oids: Array[PgOpfamilyId]): Stream[ConnectionIO, PgOpfamilyRow] = {
    sql"select oid, opfmethod, opfname, opfnamespace, opfowner from pg_catalog.pg_opfamily where oid = ANY(${oids})".query(PgOpfamilyRow.read).stream
  }
  override def update(row: PgOpfamilyRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_opfamily
          set opfmethod = ${row.opfmethod}::oid,
              opfname = ${row.opfname}::name,
              opfnamespace = ${row.opfnamespace}::oid,
              opfowner = ${row.opfowner}::oid
          where oid = ${oid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgOpfamilyRow): ConnectionIO[PgOpfamilyRow] = {
    sql"""insert into pg_catalog.pg_opfamily(oid, opfmethod, opfname, opfnamespace, opfowner)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.opfmethod}::oid,
            ${unsaved.opfname}::name,
            ${unsaved.opfnamespace}::oid,
            ${unsaved.opfowner}::oid
          )
          on conflict (oid)
          do update set
            opfmethod = EXCLUDED.opfmethod,
            opfname = EXCLUDED.opfname,
            opfnamespace = EXCLUDED.opfnamespace,
            opfowner = EXCLUDED.opfowner
          returning oid, opfmethod, opfname, opfnamespace, opfowner
       """.query(PgOpfamilyRow.read).unique
  }
}
