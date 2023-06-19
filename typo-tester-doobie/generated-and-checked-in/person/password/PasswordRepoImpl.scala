/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime
import java.util.UUID

object PasswordRepoImpl extends PasswordRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"""delete from person."password" where businessentityid = $businessentityid""".update.run.map(_ > 0)
  }
  override def insert(unsaved: PasswordRow): ConnectionIO[PasswordRow] = {
    sql"""insert into person."password"(businessentityid, passwordhash, passwordsalt, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.passwordhash}, ${unsaved.passwordsalt}, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, passwordhash, passwordsalt, rowguid, modifieddate
       """.query[PasswordRow].unique
  }
  override def insert(unsaved: PasswordRowUnsaved): ConnectionIO[PasswordRow] = {
    val fs = List(
      Some((Fragment.const(s"businessentityid"), fr"${unsaved.businessentityid}::int4")),
      Some((Fragment.const(s"passwordhash"), fr"${unsaved.passwordhash}")),
      Some((Fragment.const(s"passwordsalt"), fr"${unsaved.passwordsalt}")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${value: UUID}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person."password" default values
            returning businessentityid, passwordhash, passwordsalt, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person."password"(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning businessentityid, passwordhash, passwordsalt, rowguid, modifieddate
         """
    }
    q.query[PasswordRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, PasswordRow] = {
    sql"""select businessentityid, passwordhash, passwordsalt, rowguid, modifieddate from person."password"""".query[PasswordRow].stream
  }
  override def selectByFieldValues(fieldValues: List[PasswordFieldOrIdValue[_]]): Stream[ConnectionIO, PasswordRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case PasswordFieldValue.businessentityid(value) => fr"businessentityid = $value"
        case PasswordFieldValue.passwordhash(value) => fr"passwordhash = $value"
        case PasswordFieldValue.passwordsalt(value) => fr"passwordsalt = $value"
        case PasswordFieldValue.rowguid(value) => fr"rowguid = $value"
        case PasswordFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"""select * from person."password" $where""".query[PasswordRow].stream
  
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[PasswordRow]] = {
    sql"""select businessentityid, passwordhash, passwordsalt, rowguid, modifieddate from person."password" where businessentityid = $businessentityid""".query[PasswordRow].option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, PasswordRow] = {
    sql"""select businessentityid, passwordhash, passwordsalt, rowguid, modifieddate from person."password" where businessentityid = ANY($businessentityids)""".query[PasswordRow].stream
  }
  override def update(row: PasswordRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update person."password"
          set passwordhash = ${row.passwordhash},
              passwordsalt = ${row.passwordsalt},
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = $businessentityid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[PasswordFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case PasswordFieldValue.passwordhash(value) => fr"passwordhash = $value"
            case PasswordFieldValue.passwordsalt(value) => fr"passwordsalt = $value"
            case PasswordFieldValue.rowguid(value) => fr"rowguid = $value"
            case PasswordFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update person."password"
              $updates
              where businessentityid = $businessentityid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: PasswordRow): ConnectionIO[PasswordRow] = {
    sql"""insert into person."password"(businessentityid, passwordhash, passwordsalt, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.passwordhash},
            ${unsaved.passwordsalt},
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid)
          do update set
            passwordhash = EXCLUDED.passwordhash,
            passwordsalt = EXCLUDED.passwordsalt,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, passwordhash, passwordsalt, rowguid, modifieddate
       """.query[PasswordRow].unique
  }
}
