/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_subscription_rel

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgSubscriptionRelRepoImpl extends PgSubscriptionRelRepo {
  override def delete(compositeId: PgSubscriptionRelId): ConnectionIO[Boolean] = {
    sql"delete from pg_catalog.pg_subscription_rel where srrelid = ${compositeId.srrelid} AND srsubid = ${compositeId.srsubid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: PgSubscriptionRelRow): ConnectionIO[PgSubscriptionRelRow] = {
    sql"""insert into pg_catalog.pg_subscription_rel(srsubid, srrelid, srsubstate, srsublsn)
          values (${unsaved.srsubid}::oid, ${unsaved.srrelid}::oid, ${unsaved.srsubstate}::char, ${unsaved.srsublsn}::pg_lsn)
          returning srsubid, srrelid, srsubstate, srsublsn
       """.query(PgSubscriptionRelRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgSubscriptionRelRow] = {
    sql"select srsubid, srrelid, srsubstate, srsublsn from pg_catalog.pg_subscription_rel".query(PgSubscriptionRelRow.read).stream
  }
  override def selectById(compositeId: PgSubscriptionRelId): ConnectionIO[Option[PgSubscriptionRelRow]] = {
    sql"select srsubid, srrelid, srsubstate, srsublsn from pg_catalog.pg_subscription_rel where srrelid = ${compositeId.srrelid} AND srsubid = ${compositeId.srsubid}".query(PgSubscriptionRelRow.read).option
  }
  override def update(row: PgSubscriptionRelRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update pg_catalog.pg_subscription_rel
          set srsubstate = ${row.srsubstate}::char,
              srsublsn = ${row.srsublsn}::pg_lsn
          where srrelid = ${compositeId.srrelid} AND srsubid = ${compositeId.srsubid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PgSubscriptionRelRow): ConnectionIO[PgSubscriptionRelRow] = {
    sql"""insert into pg_catalog.pg_subscription_rel(srsubid, srrelid, srsubstate, srsublsn)
          values (
            ${unsaved.srsubid}::oid,
            ${unsaved.srrelid}::oid,
            ${unsaved.srsubstate}::char,
            ${unsaved.srsublsn}::pg_lsn
          )
          on conflict (srrelid, srsubid)
          do update set
            srsubstate = EXCLUDED.srsubstate,
            srsublsn = EXCLUDED.srsublsn
          returning srsubid, srrelid, srsubstate, srsublsn
       """.query(PgSubscriptionRelRow.read).unique
  }
}
