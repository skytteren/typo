/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_language

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgLanguageRepoImpl extends PgLanguageRepo {
  override def delete(oid: PgLanguageId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_language where oid = ${oid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgLanguageRow): ConnectionIO[PgLanguageRow] = {
    sql"""insert into pg_catalog.pg_language(oid, lanname, lanowner, lanispl, lanpltrusted, lanplcallfoid, laninline, lanvalidator, lanacl)
          values (${unsaved.oid}::oid, ${unsaved.lanname}::name, ${unsaved.lanowner}::oid, ${unsaved.lanispl}, ${unsaved.lanpltrusted}, ${unsaved.lanplcallfoid}::oid, ${unsaved.laninline}::oid, ${unsaved.lanvalidator}::oid, ${unsaved.lanacl}::_aclitem)
          returning oid, lanname, lanowner, lanispl, lanpltrusted, lanplcallfoid, laninline, lanvalidator, lanacl
       """.query(PgLanguageRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgLanguageRow] = {
    sql"select oid, lanname, lanowner, lanispl, lanpltrusted, lanplcallfoid, laninline, lanvalidator, lanacl from pg_catalog.pg_language".query(PgLanguageRow.read).stream
  }
  override def selectById(oid: PgLanguageId): ConnectionIO[Option[PgLanguageRow]] = {
    sql"select oid, lanname, lanowner, lanispl, lanpltrusted, lanplcallfoid, laninline, lanvalidator, lanacl from pg_catalog.pg_language where oid = ${oid}".query(PgLanguageRow.read).option
  }
  override def selectByIds(oids: Array[PgLanguageId]): Stream[ConnectionIO, PgLanguageRow] = {
    sql"select oid, lanname, lanowner, lanispl, lanpltrusted, lanplcallfoid, laninline, lanvalidator, lanacl from pg_catalog.pg_language where oid = ANY(${oids})".query(PgLanguageRow.read).stream
  }
  override def update(row: PgLanguageRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_language
          set lanname = ${row.lanname}::name,
              lanowner = ${row.lanowner}::oid,
              lanispl = ${row.lanispl},
              lanpltrusted = ${row.lanpltrusted},
              lanplcallfoid = ${row.lanplcallfoid}::oid,
              laninline = ${row.laninline}::oid,
              lanvalidator = ${row.lanvalidator}::oid,
              lanacl = ${row.lanacl}::_aclitem
          where oid = ${oid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgLanguageRow): ConnectionIO[PgLanguageRow] = {
    sql"""insert into pg_catalog.pg_language(oid, lanname, lanowner, lanispl, lanpltrusted, lanplcallfoid, laninline, lanvalidator, lanacl)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.lanname}::name,
            ${unsaved.lanowner}::oid,
            ${unsaved.lanispl},
            ${unsaved.lanpltrusted},
            ${unsaved.lanplcallfoid}::oid,
            ${unsaved.laninline}::oid,
            ${unsaved.lanvalidator}::oid,
            ${unsaved.lanacl}::_aclitem
          )
          on conflict (oid)
          do update set
            lanname = EXCLUDED.lanname,
            lanowner = EXCLUDED.lanowner,
            lanispl = EXCLUDED.lanispl,
            lanpltrusted = EXCLUDED.lanpltrusted,
            lanplcallfoid = EXCLUDED.lanplcallfoid,
            laninline = EXCLUDED.laninline,
            lanvalidator = EXCLUDED.lanvalidator,
            lanacl = EXCLUDED.lanacl
          returning oid, lanname, lanowner, lanispl, lanpltrusted, lanplcallfoid, laninline, lanvalidator, lanacl
       """.query(PgLanguageRow.read).unique
  }
}
