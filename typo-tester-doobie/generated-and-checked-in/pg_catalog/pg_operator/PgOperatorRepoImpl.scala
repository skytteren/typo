/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_operator

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgOperatorRepoImpl extends PgOperatorRepo {
  override def delete(oid: PgOperatorId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_operator where oid = $oid".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgOperatorRow): ConnectionIO[PgOperatorRow] = {
    sql"""insert into pg_catalog.pg_operator(oid, oprname, oprnamespace, oprowner, oprkind, oprcanmerge, oprcanhash, oprleft, oprright, oprresult, oprcom, oprnegate, oprcode, oprrest, oprjoin)
          values (${unsaved.oid}::oid, ${unsaved.oprname}::name, ${unsaved.oprnamespace}::oid, ${unsaved.oprowner}::oid, ${unsaved.oprkind}::char, ${unsaved.oprcanmerge}, ${unsaved.oprcanhash}, ${unsaved.oprleft}::oid, ${unsaved.oprright}::oid, ${unsaved.oprresult}::oid, ${unsaved.oprcom}::oid, ${unsaved.oprnegate}::oid, ${unsaved.oprcode}::regproc, ${unsaved.oprrest}::regproc, ${unsaved.oprjoin}::regproc)
          returning oid, oprname, oprnamespace, oprowner, oprkind, oprcanmerge, oprcanhash, oprleft, oprright, oprresult, oprcom, oprnegate, oprcode, oprrest, oprjoin
       """.query[PgOperatorRow].unique
  }
  override def selectAll: Stream[ConnectionIO, PgOperatorRow] = {
    sql"select oid, oprname, oprnamespace, oprowner, oprkind, oprcanmerge, oprcanhash, oprleft, oprright, oprresult, oprcom, oprnegate, oprcode, oprrest, oprjoin from pg_catalog.pg_operator".query[PgOperatorRow].stream
  }
  override def selectById(oid: PgOperatorId): ConnectionIO[Option[PgOperatorRow]] = {
    sql"select oid, oprname, oprnamespace, oprowner, oprkind, oprcanmerge, oprcanhash, oprleft, oprright, oprresult, oprcom, oprnegate, oprcode, oprrest, oprjoin from pg_catalog.pg_operator where oid = $oid".query[PgOperatorRow].option
  }
  override def selectByIds(oids: Array[PgOperatorId]): Stream[ConnectionIO, PgOperatorRow] = {
    sql"select oid, oprname, oprnamespace, oprowner, oprkind, oprcanmerge, oprcanhash, oprleft, oprright, oprresult, oprcom, oprnegate, oprcode, oprrest, oprjoin from pg_catalog.pg_operator where oid = ANY($oids)".query[PgOperatorRow].stream
  }
  override def update(row: PgOperatorRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_operator
          set oprname = ${row.oprname}::name,
              oprnamespace = ${row.oprnamespace}::oid,
              oprowner = ${row.oprowner}::oid,
              oprkind = ${row.oprkind}::char,
              oprcanmerge = ${row.oprcanmerge},
              oprcanhash = ${row.oprcanhash},
              oprleft = ${row.oprleft}::oid,
              oprright = ${row.oprright}::oid,
              oprresult = ${row.oprresult}::oid,
              oprcom = ${row.oprcom}::oid,
              oprnegate = ${row.oprnegate}::oid,
              oprcode = ${row.oprcode}::regproc,
              oprrest = ${row.oprrest}::regproc,
              oprjoin = ${row.oprjoin}::regproc
          where oid = $oid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgOperatorRow): ConnectionIO[PgOperatorRow] = {
    sql"""insert into pg_catalog.pg_operator(oid, oprname, oprnamespace, oprowner, oprkind, oprcanmerge, oprcanhash, oprleft, oprright, oprresult, oprcom, oprnegate, oprcode, oprrest, oprjoin)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.oprname}::name,
            ${unsaved.oprnamespace}::oid,
            ${unsaved.oprowner}::oid,
            ${unsaved.oprkind}::char,
            ${unsaved.oprcanmerge},
            ${unsaved.oprcanhash},
            ${unsaved.oprleft}::oid,
            ${unsaved.oprright}::oid,
            ${unsaved.oprresult}::oid,
            ${unsaved.oprcom}::oid,
            ${unsaved.oprnegate}::oid,
            ${unsaved.oprcode}::regproc,
            ${unsaved.oprrest}::regproc,
            ${unsaved.oprjoin}::regproc
          )
          on conflict (oid)
          do update set
            oprname = EXCLUDED.oprname,
            oprnamespace = EXCLUDED.oprnamespace,
            oprowner = EXCLUDED.oprowner,
            oprkind = EXCLUDED.oprkind,
            oprcanmerge = EXCLUDED.oprcanmerge,
            oprcanhash = EXCLUDED.oprcanhash,
            oprleft = EXCLUDED.oprleft,
            oprright = EXCLUDED.oprright,
            oprresult = EXCLUDED.oprresult,
            oprcom = EXCLUDED.oprcom,
            oprnegate = EXCLUDED.oprnegate,
            oprcode = EXCLUDED.oprcode,
            oprrest = EXCLUDED.oprrest,
            oprjoin = EXCLUDED.oprjoin
          returning oid, oprname, oprnamespace, oprowner, oprkind, oprcanmerge, oprcanhash, oprleft, oprright, oprresult, oprcom, oprnegate, oprcode, oprrest, oprjoin
       """.query[PgOperatorRow].unique
  }
}