/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package emailaddress

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
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

class EmailaddressRepoImpl extends EmailaddressRepo {
  override def delete: DeleteBuilder[EmailaddressFields, EmailaddressRow] = {
    DeleteBuilder("person.emailaddress", EmailaddressFields.structure)
  }
  override def deleteById(compositeId: EmailaddressId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from person.emailaddress where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "emailaddressid" = ${Segment.paramSegment(compositeId.emailaddressid)(Setter.intSetter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[EmailaddressId]): ZIO[ZConnection, Throwable, Long] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val emailaddressid = compositeIds.map(_.emailaddressid)
    sql"""delete
          from person.emailaddress
          where ("businessentityid", "emailaddressid")
          in (select unnest(${businessentityid}), unnest(${emailaddressid}))
       """.delete
    
  }
  override def insert(unsaved: EmailaddressRow): ZIO[ZConnection, Throwable, EmailaddressRow] = {
    sql"""insert into person.emailaddress("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4, ${Segment.paramSegment(unsaved.emailaddressid)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.emailaddress)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text
       """.insertReturning(using EmailaddressRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: EmailaddressRowUnsaved): ZIO[ZConnection, Throwable, EmailaddressRow] = {
    val fs = List(
      Some((sql""""businessentityid"""", sql"${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4")),
      Some((sql""""emailaddress"""", sql"${Segment.paramSegment(unsaved.emailaddress)(Setter.optionParamSetter(Setter.stringSetter))}")),
      unsaved.emailaddressid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""emailaddressid"""", sql"${Segment.paramSegment(value: Int)(Setter.intSetter)}::int4"))
      },
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
      sql"""insert into person.emailaddress default values
            returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into person.emailaddress($names) values ($values) returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using EmailaddressRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, EmailaddressRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.emailaddress("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(EmailaddressRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, EmailaddressRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.emailaddress("businessentityid", "emailaddress", "emailaddressid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(EmailaddressRowUnsaved.text)
  }
  override def select: SelectBuilder[EmailaddressFields, EmailaddressRow] = {
    SelectBuilderSql("person.emailaddress", EmailaddressFields.structure, EmailaddressRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, EmailaddressRow] = {
    sql"""select "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text from person.emailaddress""".query(using EmailaddressRow.jdbcDecoder).selectStream()
  }
  override def selectById(compositeId: EmailaddressId): ZIO[ZConnection, Throwable, Option[EmailaddressRow]] = {
    sql"""select "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text from person.emailaddress where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "emailaddressid" = ${Segment.paramSegment(compositeId.emailaddressid)(Setter.intSetter)}""".query(using EmailaddressRow.jdbcDecoder).selectOne
  }
  override def selectByIds(compositeIds: Array[EmailaddressId]): ZStream[ZConnection, Throwable, EmailaddressRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val emailaddressid = compositeIds.map(_.emailaddressid)
    sql"""select "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text
          from person.emailaddress
          where ("businessentityid", "emailaddressid")
          in (select unnest(${businessentityid}), unnest(${emailaddressid}))
       """.query(using EmailaddressRow.jdbcDecoder).selectStream()
    
  }
  override def selectByIdsTracked(compositeIds: Array[EmailaddressId]): ZIO[ZConnection, Throwable, Map[EmailaddressId, EmailaddressRow]] = {
    selectByIds(compositeIds).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[EmailaddressFields, EmailaddressRow] = {
    UpdateBuilder("person.emailaddress", EmailaddressFields.structure, EmailaddressRow.jdbcDecoder)
  }
  override def update(row: EmailaddressRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update person.emailaddress
          set "emailaddress" = ${Segment.paramSegment(row.emailaddress)(Setter.optionParamSetter(Setter.stringSetter))},
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "businessentityid" = ${Segment.paramSegment(compositeId.businessentityid)(BusinessentityId.setter)} AND "emailaddressid" = ${Segment.paramSegment(compositeId.emailaddressid)(Setter.intSetter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: EmailaddressRow): ZIO[ZConnection, Throwable, UpdateResult[EmailaddressRow]] = {
    sql"""insert into person.emailaddress("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.businessentityid)(BusinessentityId.setter)}::int4,
            ${Segment.paramSegment(unsaved.emailaddressid)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.emailaddress)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("businessentityid", "emailaddressid")
          do update set
            "emailaddress" = EXCLUDED."emailaddress",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate"::text""".insertReturning(using EmailaddressRow.jdbcDecoder)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, EmailaddressRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table emailaddress_TEMP (like person.emailaddress) on commit drop".execute
    val copied = streamingInsert(s"""copy emailaddress_TEMP("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate") from stdin""", batchSize, unsaved)(EmailaddressRow.text)
    val merged = sql"""insert into person.emailaddress("businessentityid", "emailaddressid", "emailaddress", "rowguid", "modifieddate")
                       select * from emailaddress_TEMP
                       on conflict ("businessentityid", "emailaddressid")
                       do update set
                         "emailaddress" = EXCLUDED."emailaddress",
                         "rowguid" = EXCLUDED."rowguid",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table emailaddress_TEMP;""".update
    created *> copied *> merged
  }
}
