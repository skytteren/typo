/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.util.UUID

object BusinessentityRepoImpl extends BusinessentityRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"delete from person.businessentity where businessentityid = ${businessentityid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: BusinessentityRow): ConnectionIO[BusinessentityRow] = {
    sql"""insert into person.businessentity(businessentityid, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, rowguid, modifieddate::text
       """.query(BusinessentityRow.read).unique
  }
  override def insert(unsaved: BusinessentityRowUnsaved): ConnectionIO[BusinessentityRow] = {
    val fs = List(
      unsaved.businessentityid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"businessentityid"), fr"${value: BusinessentityId}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${value: UUID}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: TypoLocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.businessentity default values
            returning businessentityid, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.businessentity(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, rowguid, modifieddate::text
         """
    }
    q.query(BusinessentityRow.read).unique
  
  }
  override def selectAll: Stream[ConnectionIO, BusinessentityRow] = {
    sql"select businessentityid, rowguid, modifieddate::text from person.businessentity".query(BusinessentityRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[BusinessentityRow]] = {
    sql"select businessentityid, rowguid, modifieddate::text from person.businessentity where businessentityid = ${businessentityid}".query(BusinessentityRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, BusinessentityRow] = {
    sql"select businessentityid, rowguid, modifieddate::text from person.businessentity where businessentityid = ANY(${businessentityids})".query(BusinessentityRow.read).stream
  }
  override def update(row: BusinessentityRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update person.businessentity
          set rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${businessentityid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: BusinessentityRow): ConnectionIO[BusinessentityRow] = {
    sql"""insert into person.businessentity(businessentityid, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid)
          do update set
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, rowguid, modifieddate::text
       """.query(BusinessentityRow.read).unique
  }
}
