/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package password

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class PasswordRepoImpl extends PasswordRepo {
  override def delete: DeleteBuilder[PasswordFields, PasswordRow] = {
    DeleteBuilder("person.password", PasswordFields.structure)
  }
  override def deleteById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from person.password where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from person.password where "businessentityid" = ANY(${businessentityids})""".delete
  }
  override def insert(unsaved: PasswordRow): ZIO[ZConnection, Throwable, PasswordRow] = {
    sql"""insert into person.password("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.passwordhash)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.passwordsalt)(Setter.stringSetter)}, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text
       """.insertReturning(using PasswordRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: PasswordRowUnsaved): ZIO[ZConnection, Throwable, PasswordRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""passwordhash"""", sql"${Segment.paramSegment(unsaved.passwordhash)(Setter.stringSetter)}")),
      Some((sql""""passwordsalt"""", sql"${Segment.paramSegment(unsaved.passwordsalt)(Setter.stringSetter)}")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.password default values
            returning "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into person.password($names) values ($values) returning "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using PasswordRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PasswordRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.password("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(PasswordRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, PasswordRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.password("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PasswordRowUnsaved.text)
  }
  override def select: SelectBuilder[PasswordFields, PasswordRow] = {
    SelectBuilderSql("person.password", PasswordFields.structure, PasswordRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PasswordRow] = {
    sql"""select "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text from person.password""".query(using PasswordRow.jdbcDecoder).selectStream()
  }
  override def selectById(businessentityid: BusinessentityId): ZIO[ZConnection, Throwable, Option[PasswordRow]] = {
    sql"""select "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text from person.password where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".query(using PasswordRow.jdbcDecoder).selectOne
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): ZStream[ZConnection, Throwable, PasswordRow] = {
    sql"""select "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text from person.password where "businessentityid" = ANY(${Segment.paramSegment(businessentityids)(BusinessentityId.arraySetter)})""".query(using PasswordRow.jdbcDecoder).selectStream()
  }
  override def update: UpdateBuilder[PasswordFields, PasswordRow] = {
    UpdateBuilder("person.password", PasswordFields.structure, PasswordRow.jdbcDecoder)
  }
  override def update(row: PasswordRow): ZIO[ZConnection, Throwable, Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update person.password
          set "passwordhash" = ${Segment.paramSegment(row.passwordhash)(Setter.stringSetter)},
              "passwordsalt" = ${Segment.paramSegment(row.passwordsalt)(Setter.stringSetter)},
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(businessentityid)(BusinessentityId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: PasswordRow): ZIO[ZConnection, Throwable, UpdateResult[PasswordRow]] = {
    sql"""insert into person.password("businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.passwordhash)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.passwordsalt)(Setter.stringSetter)},
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "passwordhash" = EXCLUDED."passwordhash",
            "passwordsalt" = EXCLUDED."passwordsalt",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "passwordhash", "passwordsalt", "rowguid", "modifieddate"::text""".insertReturning(using PasswordRow.jdbcDecoder)
  }
}
