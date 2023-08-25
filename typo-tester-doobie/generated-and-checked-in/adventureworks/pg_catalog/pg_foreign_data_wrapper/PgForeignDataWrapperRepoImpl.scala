/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_foreign_data_wrapper

import adventureworks.customtypes.TypoAclItem
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object PgForeignDataWrapperRepoImpl extends PgForeignDataWrapperRepo {
  override def delete(oid: PgForeignDataWrapperId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_foreign_data_wrapper where oid = ${fromWrite(oid)(Write.fromPut(PgForeignDataWrapperId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgForeignDataWrapperFields, PgForeignDataWrapperRow] = {
    DeleteBuilder("pg_catalog.pg_foreign_data_wrapper", PgForeignDataWrapperFields)
  }
  override def insert(unsaved: PgForeignDataWrapperRow): ConnectionIO[PgForeignDataWrapperRow] = {
    sql"""insert into pg_catalog.pg_foreign_data_wrapper(oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgForeignDataWrapperId.put))}::oid, ${fromWrite(unsaved.fdwname)(Write.fromPut(Meta.StringMeta.put))}::name, ${fromWrite(unsaved.fdwowner)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.fdwhandler)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.fdwvalidator)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.fdwacl)(Write.fromPutOption(TypoAclItem.arrayPut))}::_aclitem, ${fromWrite(unsaved.fdwoptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text)
          returning oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions
       """.query(PgForeignDataWrapperRow.read).unique
  }
  override def select: SelectBuilder[PgForeignDataWrapperFields, PgForeignDataWrapperRow] = {
    SelectBuilderSql("pg_catalog.pg_foreign_data_wrapper", PgForeignDataWrapperFields, PgForeignDataWrapperRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgForeignDataWrapperRow] = {
    sql"select oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions from pg_catalog.pg_foreign_data_wrapper".query(PgForeignDataWrapperRow.read).stream
  }
  override def selectById(oid: PgForeignDataWrapperId): ConnectionIO[Option[PgForeignDataWrapperRow]] = {
    sql"select oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions from pg_catalog.pg_foreign_data_wrapper where oid = ${fromWrite(oid)(Write.fromPut(PgForeignDataWrapperId.put))}".query(PgForeignDataWrapperRow.read).option
  }
  override def selectByIds(oids: Array[PgForeignDataWrapperId]): Stream[ConnectionIO, PgForeignDataWrapperRow] = {
    sql"select oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions from pg_catalog.pg_foreign_data_wrapper where oid = ANY(${oids})".query(PgForeignDataWrapperRow.read).stream
  }
  override def selectByUnique(fdwname: String): ConnectionIO[Option[PgForeignDataWrapperRow]] = {
    sql"""select fdwname
          from pg_catalog.pg_foreign_data_wrapper
          where fdwname = ${fromWrite(fdwname)(Write.fromPut(Meta.StringMeta.put))}
       """.query(PgForeignDataWrapperRow.read).option
  }
  override def update(row: PgForeignDataWrapperRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_foreign_data_wrapper
          set fdwname = ${fromWrite(row.fdwname)(Write.fromPut(Meta.StringMeta.put))}::name,
              fdwowner = ${fromWrite(row.fdwowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
              fdwhandler = ${fromWrite(row.fdwhandler)(Write.fromPut(Meta.LongMeta.put))}::oid,
              fdwvalidator = ${fromWrite(row.fdwvalidator)(Write.fromPut(Meta.LongMeta.put))}::oid,
              fdwacl = ${fromWrite(row.fdwacl)(Write.fromPutOption(TypoAclItem.arrayPut))}::_aclitem,
              fdwoptions = ${fromWrite(row.fdwoptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text
          where oid = ${fromWrite(oid)(Write.fromPut(PgForeignDataWrapperId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgForeignDataWrapperFields, PgForeignDataWrapperRow] = {
    UpdateBuilder("pg_catalog.pg_foreign_data_wrapper", PgForeignDataWrapperFields, PgForeignDataWrapperRow.read)
  }
  override def upsert(unsaved: PgForeignDataWrapperRow): ConnectionIO[PgForeignDataWrapperRow] = {
    sql"""insert into pg_catalog.pg_foreign_data_wrapper(oid, fdwname, fdwowner, fdwhandler, fdwvalidator, fdwacl, fdwoptions)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgForeignDataWrapperId.put))}::oid,
            ${fromWrite(unsaved.fdwname)(Write.fromPut(Meta.StringMeta.put))}::name,
            ${fromWrite(unsaved.fdwowner)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.fdwhandler)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.fdwvalidator)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.fdwacl)(Write.fromPutOption(TypoAclItem.arrayPut))}::_aclitem,
            ${fromWrite(unsaved.fdwoptions)(Write.fromPutOption(adventureworks.StringArrayMeta.put))}::_text
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
       """.query(PgForeignDataWrapperRow.read).unique
  }
}