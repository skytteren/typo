/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class ScrapreasonRepoImpl extends ScrapreasonRepo {
  override def delete: DeleteBuilder[ScrapreasonFields, ScrapreasonRow] = {
    DeleteBuilder("production.scrapreason", ScrapreasonFields.structure)
  }
  override def deleteById(scrapreasonid: ScrapreasonId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.scrapreason where "scrapreasonid" = ${Segment.paramSegment(scrapreasonid)(ScrapreasonId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(scrapreasonids: Array[ScrapreasonId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from production.scrapreason where "scrapreasonid" = ANY(${scrapreasonids})""".delete
  }
  override def insert(unsaved: ScrapreasonRow): ZIO[ZConnection, Throwable, ScrapreasonRow] = {
    sql"""insert into production.scrapreason("scrapreasonid", "name", "modifieddate")
          values (${Segment.paramSegment(unsaved.scrapreasonid)(ScrapreasonId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "scrapreasonid", "name", "modifieddate"::text
       """.insertReturning(using ScrapreasonRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: ScrapreasonRowUnsaved): ZIO[ZConnection, Throwable, ScrapreasonRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      unsaved.scrapreasonid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""scrapreasonid"""", sql"${Segment.paramSegment(value: ScrapreasonId)(ScrapreasonId.setter)}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.scrapreason default values
            returning "scrapreasonid", "name", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.scrapreason($names) values ($values) returning "scrapreasonid", "name", "modifieddate"::text"""
    }
    q.insertReturning(using ScrapreasonRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ScrapreasonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.scrapreason("scrapreasonid", "name", "modifieddate") FROM STDIN""", batchSize, unsaved)(ScrapreasonRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ScrapreasonRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.scrapreason("name", "scrapreasonid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ScrapreasonRowUnsaved.text)
  }
  override def select: SelectBuilder[ScrapreasonFields, ScrapreasonRow] = {
    SelectBuilderSql("production.scrapreason", ScrapreasonFields.structure, ScrapreasonRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ScrapreasonRow] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason""".query(using ScrapreasonRow.jdbcDecoder).selectStream()
  }
  override def selectById(scrapreasonid: ScrapreasonId): ZIO[ZConnection, Throwable, Option[ScrapreasonRow]] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason where "scrapreasonid" = ${Segment.paramSegment(scrapreasonid)(ScrapreasonId.setter)}""".query(using ScrapreasonRow.jdbcDecoder).selectOne
  }
  override def selectByIds(scrapreasonids: Array[ScrapreasonId]): ZStream[ZConnection, Throwable, ScrapreasonRow] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason where "scrapreasonid" = ANY(${Segment.paramSegment(scrapreasonids)(ScrapreasonId.arraySetter)})""".query(using ScrapreasonRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(scrapreasonids: Array[ScrapreasonId]): ZIO[ZConnection, Throwable, Map[ScrapreasonId, ScrapreasonRow]] = {
    selectByIds(scrapreasonids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.scrapreasonid, x)).toMap
      scrapreasonids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ScrapreasonFields, ScrapreasonRow] = {
    UpdateBuilder("production.scrapreason", ScrapreasonFields.structure, ScrapreasonRow.jdbcDecoder)
  }
  override def update(row: ScrapreasonRow): ZIO[ZConnection, Throwable, Boolean] = {
    val scrapreasonid = row.scrapreasonid
    sql"""update production.scrapreason
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "scrapreasonid" = ${Segment.paramSegment(scrapreasonid)(ScrapreasonId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: ScrapreasonRow): ZIO[ZConnection, Throwable, UpdateResult[ScrapreasonRow]] = {
    sql"""insert into production.scrapreason("scrapreasonid", "name", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.scrapreasonid)(ScrapreasonId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("scrapreasonid")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "scrapreasonid", "name", "modifieddate"::text""".insertReturning(using ScrapreasonRow.jdbcDecoder)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, ScrapreasonRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    val created = sql"create temporary table scrapreason_TEMP (like production.scrapreason) on commit drop".execute
    val copied = streamingInsert(s"""copy scrapreason_TEMP("scrapreasonid", "name", "modifieddate") from stdin""", batchSize, unsaved)(ScrapreasonRow.text)
    val merged = sql"""insert into production.scrapreason("scrapreasonid", "name", "modifieddate")
                       select * from scrapreason_TEMP
                       on conflict ("scrapreasonid")
                       do update set
                         "name" = EXCLUDED."name",
                         "modifieddate" = EXCLUDED."modifieddate"
                       ;
                       drop table scrapreason_TEMP;""".update
    created *> copied *> merged
  }
}
