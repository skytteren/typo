/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_data_wrapper

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgForeignDataWrapperRepoImpl extends PgForeignDataWrapperRepo {
  override def delete(oid: PgForeignDataWrapperId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_foreign_data_wrapper where oid = $oid".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgForeignDataWrapperRow): ConnectionIO[PgForeignDataWrapperRow] = {
    sql"""insert into pg_catalog.pg_foreign_data_wrapper(oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions)
          values (${unsaved.oid}::oid, ${unsaved.fdwname}::name, ${unsaved.fdwowner}::oid, ${unsaved.fdwhandler}::oid, ${unsaved.fdwvalidator}::oid, ${unsaved.fdwacl}::_aclitem, ${unsaved.fdwoptions}::_text)
          returning oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions
       """.query[PgForeignDataWrapperRow].unique
  }
  override def selectAll: Stream[ConnectionIO, PgForeignDataWrapperRow] = {
    sql"select oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions from pg_catalog.pg_foreign_data_wrapper".query[PgForeignDataWrapperRow].stream
  }
  override def selectById(oid: PgForeignDataWrapperId): ConnectionIO[Option[PgForeignDataWrapperRow]] = {
    sql"select oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions from pg_catalog.pg_foreign_data_wrapper where oid = $oid".query[PgForeignDataWrapperRow].option
  }
  override def selectByIds(oids: Array[PgForeignDataWrapperId]): Stream[ConnectionIO, PgForeignDataWrapperRow] = {
    sql"select oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions from pg_catalog.pg_foreign_data_wrapper where oid = ANY($oids)".query[PgForeignDataWrapperRow].stream
  }
  override def update(row: PgForeignDataWrapperRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_foreign_data_wrapper
          set fdwname = ${row.fdwname}::name,
              fdwowner = ${row.fdwowner}::oid,
              fdwhandler = ${row.fdwhandler}::oid,
              fdwvalidator = ${row.fdwvalidator}::oid,
              fdwacl = ${row.fdwacl}::_aclitem,
              fdwoptions = ${row.fdwoptions}::_text
          where oid = $oid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgForeignDataWrapperRow): ConnectionIO[PgForeignDataWrapperRow] = {
    sql"""insert into pg_catalog.pg_foreign_data_wrapper(oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.fdwname}::name,
            ${unsaved.fdwowner}::oid,
            ${unsaved.fdwhandler}::oid,
            ${unsaved.fdwvalidator}::oid,
            ${unsaved.fdwacl}::_aclitem,
            ${unsaved.fdwoptions}::_text
          )
          on conflict (oid)
          do update set
            fdwname = EXCLUDED.fdwname,
            fdwowner = EXCLUDED.fdwowner,
            fdwhandler = EXCLUDED.fdwhandler,
            fdwvalidator = EXCLUDED.fdwvalidator,
            fdwacl = EXCLUDED.fdwacl,
            fdwoptions = EXCLUDED.fdwoptions
          returning oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions
       """.query[PgForeignDataWrapperRow].unique
  }
}