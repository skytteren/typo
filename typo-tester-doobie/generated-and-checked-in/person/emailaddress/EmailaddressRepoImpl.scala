/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.util.UUID

object EmailaddressRepoImpl extends EmailaddressRepo {
  override def delete(compositeId: EmailaddressId): ConnectionIO[Boolean] = {
    sql"delete from person.emailaddress where businessentityid = ${compositeId.businessentityid} AND emailaddressid = ${compositeId.emailaddressid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {
    sql"""insert into person.emailaddress(businessentityid, emailaddressid, emailaddress, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.emailaddressid}::int4, ${unsaved.emailaddress}, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text
       """.query(EmailaddressRow.read).unique
  }
  override def insert(unsaved: EmailaddressRowUnsaved): ConnectionIO[EmailaddressRow] = {
    val fs = List(
      Some((Fragment.const(s"businessentityid"), fr"${unsaved.businessentityid}::int4")),
      Some((Fragment.const(s"emailaddress"), fr"${unsaved.emailaddress}")),
      unsaved.emailaddressid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"emailaddressid"), fr"${value: Int}::int4"))
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
      sql"""insert into person.emailaddress default values
            returning businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.emailaddress(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text
         """
    }
    q.query(EmailaddressRow.read).unique
  
  }
  override def selectAll: Stream[ConnectionIO, EmailaddressRow] = {
    sql"select businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text from person.emailaddress".query(EmailaddressRow.read).stream
  }
  override def selectById(compositeId: EmailaddressId): ConnectionIO[Option[EmailaddressRow]] = {
    sql"select businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text from person.emailaddress where businessentityid = ${compositeId.businessentityid} AND emailaddressid = ${compositeId.emailaddressid}".query(EmailaddressRow.read).option
  }
  override def update(row: EmailaddressRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update person.emailaddress
          set emailaddress = ${row.emailaddress},
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND emailaddressid = ${compositeId.emailaddressid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: EmailaddressRow): ConnectionIO[EmailaddressRow] = {
    sql"""insert into person.emailaddress(businessentityid, emailaddressid, emailaddress, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.emailaddressid}::int4,
            ${unsaved.emailaddress},
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, emailaddressid)
          do update set
            emailaddress = EXCLUDED.emailaddress,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, emailaddressid, emailaddress, rowguid, modifieddate::text
       """.query(EmailaddressRow.read).unique
  }
}
