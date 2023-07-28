/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_policy

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgPolicyRepoImpl extends PgPolicyRepo {
  override def delete(oid: PgPolicyId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_policy where oid = ${oid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgPolicyRow): ConnectionIO[PgPolicyRow] = {
    sql"""insert into pg_catalog.pg_policy(oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck)
          values (${unsaved.oid}::oid, ${unsaved.polname}::name, ${unsaved.polrelid}::oid, ${unsaved.polcmd}::char, ${unsaved.polpermissive}, ${unsaved.polroles}::_oid, ${unsaved.polqual}::pg_node_tree, ${unsaved.polwithcheck}::pg_node_tree)
          returning oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck
       """.query[PgPolicyRow].unique
  }
  override def selectAll: Stream[ConnectionIO, PgPolicyRow] = {
    sql"select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck from pg_catalog.pg_policy".query[PgPolicyRow].stream
  }
  override def selectById(oid: PgPolicyId): ConnectionIO[Option[PgPolicyRow]] = {
    sql"select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck from pg_catalog.pg_policy where oid = ${oid}".query[PgPolicyRow].option
  }
  override def selectByIds(oids: Array[PgPolicyId]): Stream[ConnectionIO, PgPolicyRow] = {
    sql"select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck from pg_catalog.pg_policy where oid = ANY(${oids})".query[PgPolicyRow].stream
  }
  override def update(row: PgPolicyRow): ConnectionIO[Boolean] = {
    val oid = row.oid
    sql"""update pg_catalog.pg_policy
          set polname = ${row.polname}::name,
              polrelid = ${row.polrelid}::oid,
              polcmd = ${row.polcmd}::char,
              polpermissive = ${row.polpermissive},
              polroles = ${row.polroles}::_oid,
              polqual = ${row.polqual}::pg_node_tree,
              polwithcheck = ${row.polwithcheck}::pg_node_tree
          where oid = ${oid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgPolicyRow): ConnectionIO[PgPolicyRow] = {
    sql"""insert into pg_catalog.pg_policy(oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck)
          values (
            ${unsaved.oid}::oid,
            ${unsaved.polname}::name,
            ${unsaved.polrelid}::oid,
            ${unsaved.polcmd}::char,
            ${unsaved.polpermissive},
            ${unsaved.polroles}::_oid,
            ${unsaved.polqual}::pg_node_tree,
            ${unsaved.polwithcheck}::pg_node_tree
          )
          on conflict (oid)
          do update set
            polname = EXCLUDED.polname,
            polrelid = EXCLUDED.polrelid,
            polcmd = EXCLUDED.polcmd,
            polpermissive = EXCLUDED.polpermissive,
            polroles = EXCLUDED.polroles,
            polqual = EXCLUDED.polqual,
            polwithcheck = EXCLUDED.polwithcheck
          returning oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck
       """.query[PgPolicyRow].unique
  }
}
