/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_cast

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

object PgCastRepoImpl extends PgCastRepo {
  override def delete(oid: PgCastId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_cast where oid = ${fromWrite(oid)(Write.fromPut(PgCastId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgCastFields, PgCastRow] = {
    DeleteBuilder("pg_catalog.pg_cast", PgCastFields)
  }
  override def insert(unsaved: PgCastRow): ConnectionIO[PgCastRow] = {
    sql"""insert into pg_catalog.pg_cast(oid, castsource, casttarget, castfunc, castcontext, castmethod)
          values (${fromWrite(unsaved.oid)(Write.fromPut(PgCastId.put))}::oid, ${fromWrite(unsaved.castsource)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.casttarget)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.castfunc)(Write.fromPut(Meta.LongMeta.put))}::oid, ${fromWrite(unsaved.castcontext)(Write.fromPut(Meta.StringMeta.put))}::char, ${fromWrite(unsaved.castmethod)(Write.fromPut(Meta.StringMeta.put))}::char)
          returning oid, castsource, casttarget, castfunc, castcontext, castmethod
       """.query(PgCastRow.read).unique
  }
  override def select: SelectBuilder[PgCastFields, PgCastRow] = {
    SelectBuilderSql("pg_catalog.pg_cast", PgCastFields, PgCastRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PgCastRow] = {
    sql"select oid, castsource, casttarget, castfunc, castcontext, castmethod from pg_catalog.pg_cast".query(PgCastRow.read).stream
  }
  override def selectById(oid: PgCastId): ConnectionIO[Option[PgCastRow]] = {
    sql"select oid, castsource, casttarget, castfunc, castcontext, castmethod from pg_catalog.pg_cast where oid = ${fromWrite(oid)(Write.fromPut(PgCastId.put))}".query(PgCastRow.read).option
  }
  override def selectByIds(oids: Array[PgCastId]): Stream[ConnectionIO, PgCastRow] = {
    sql"select oid, castsource, casttarget, castfunc, castcontext, castmethod from pg_catalog.pg_cast where oid = ANY(${oids})".query(PgCastRow.read).stream
  }
  override def selectByUnique(castsource: /* oid */ Long, casttarget: /* oid */ Long): ConnectionIO[Option[PgCastRow]] = {
    sql"""select castsource, casttarget
          from pg_catalog.pg_cast
          where castsource = ${fromWrite(castsource)(Write.fromPut(Meta.LongMeta.put))} AND casttarget = ${fromWrite(casttarget)(Write.fromPut(Meta.LongMeta.put))}
       """.query(PgCastRow.read).option
  }
  override def update(row: PgCastRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_cast
          set castsource = ${fromWrite(row.castsource)(Write.fromPut(Meta.LongMeta.put))}::oid,
              casttarget = ${fromWrite(row.casttarget)(Write.fromPut(Meta.LongMeta.put))}::oid,
              castfunc = ${fromWrite(row.castfunc)(Write.fromPut(Meta.LongMeta.put))}::oid,
              castcontext = ${fromWrite(row.castcontext)(Write.fromPut(Meta.StringMeta.put))}::char,
              castmethod = ${fromWrite(row.castmethod)(Write.fromPut(Meta.StringMeta.put))}::char
          where oid = ${fromWrite(oid)(Write.fromPut(PgCastId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[PgCastFields, PgCastRow] = {
    UpdateBuilder("pg_catalog.pg_cast", PgCastFields, PgCastRow.read)
  }
  override def upsert(unsaved: PgCastRow): ConnectionIO[PgCastRow] = {
    sql"""insert into pg_catalog.pg_cast(oid, castsource, casttarget, castfunc, castcontext, castmethod)
          values (
            ${fromWrite(unsaved.oid)(Write.fromPut(PgCastId.put))}::oid,
            ${fromWrite(unsaved.castsource)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.casttarget)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.castfunc)(Write.fromPut(Meta.LongMeta.put))}::oid,
            ${fromWrite(unsaved.castcontext)(Write.fromPut(Meta.StringMeta.put))}::char,
            ${fromWrite(unsaved.castmethod)(Write.fromPut(Meta.StringMeta.put))}::char
          )
          on conflict (oid)
          do update set
            castsource = EXCLUDED.castsource,
            casttarget = EXCLUDED.casttarget,
            castfunc = EXCLUDED.castfunc,
            castcontext = EXCLUDED.castcontext,
            castmethod = EXCLUDED.castmethod
          returning oid, castsource, casttarget, castfunc, castcontext, castmethod
       """.query(PgCastRow.read).unique
  }
}