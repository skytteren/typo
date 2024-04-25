/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesreason

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import adventureworks.streamingInsert
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

class SalesreasonRepoImpl extends SalesreasonRepo {
  override def delete(salesreasonid: SalesreasonId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from sales.salesreason where "salesreasonid" = ${Segment.paramSegment(salesreasonid)(SalesreasonId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(salesreasonids: Array[SalesreasonId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from sales.salesreason where "salesreasonid" = ANY(${salesreasonids})""".delete
  }
  override def delete: DeleteBuilder[SalesreasonFields, SalesreasonRow] = {
    DeleteBuilder("sales.salesreason", SalesreasonFields.structure)
  }
  override def insert(unsaved: SalesreasonRow): ZIO[ZConnection, Throwable, SalesreasonRow] = {
    sql"""insert into sales.salesreason("salesreasonid", "name", "reasontype", "modifieddate")
          values (${Segment.paramSegment(unsaved.salesreasonid)(SalesreasonId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.reasontype)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "salesreasonid", "name", "reasontype", "modifieddate"::text
       """.insertReturning(using SalesreasonRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, SalesreasonRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salesreason("salesreasonid", "name", "reasontype", "modifieddate") FROM STDIN""", batchSize, unsaved)(SalesreasonRow.text)
  }
  override def insert(unsaved: SalesreasonRowUnsaved): ZIO[ZConnection, Throwable, SalesreasonRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      Some((sql""""reasontype"""", sql"${Segment.paramSegment(unsaved.reasontype)(Name.setter)}::varchar")),
      unsaved.salesreasonid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""salesreasonid"""", sql"${Segment.paramSegment(value: SalesreasonId)(SalesreasonId.setter)}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.salesreason default values
            returning "salesreasonid", "name", "reasontype", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into sales.salesreason($names) values ($values) returning "salesreasonid", "name", "reasontype", "modifieddate"::text"""
    }
    q.insertReturning(using SalesreasonRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, SalesreasonRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY sales.salesreason("name", "reasontype", "salesreasonid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(SalesreasonRowUnsaved.text)
  }
  override def select: SelectBuilder[SalesreasonFields, SalesreasonRow] = {
    SelectBuilderSql("sales.salesreason", SalesreasonFields.structure, SalesreasonRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, SalesreasonRow] = {
    sql"""select "salesreasonid", "name", "reasontype", "modifieddate"::text from sales.salesreason""".query(using SalesreasonRow.jdbcDecoder).selectStream()
  }
  override def selectById(salesreasonid: SalesreasonId): ZIO[ZConnection, Throwable, Option[SalesreasonRow]] = {
    sql"""select "salesreasonid", "name", "reasontype", "modifieddate"::text from sales.salesreason where "salesreasonid" = ${Segment.paramSegment(salesreasonid)(SalesreasonId.setter)}""".query(using SalesreasonRow.jdbcDecoder).selectOne
  }
  override def selectByIds(salesreasonids: Array[SalesreasonId]): ZStream[ZConnection, Throwable, SalesreasonRow] = {
    sql"""select "salesreasonid", "name", "reasontype", "modifieddate"::text from sales.salesreason where "salesreasonid" = ANY(${Segment.paramSegment(salesreasonids)(SalesreasonId.arraySetter)})""".query(using SalesreasonRow.jdbcDecoder).selectStream()
  }
  override def update(row: SalesreasonRow): ZIO[ZConnection, Throwable, Boolean] = {
    val salesreasonid = row.salesreasonid
    sql"""update sales.salesreason
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "reasontype" = ${Segment.paramSegment(row.reasontype)(Name.setter)}::varchar,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "salesreasonid" = ${Segment.paramSegment(salesreasonid)(SalesreasonId.setter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[SalesreasonFields, SalesreasonRow] = {
    UpdateBuilder("sales.salesreason", SalesreasonFields.structure, SalesreasonRow.jdbcDecoder)
  }
  override def upsert(unsaved: SalesreasonRow): ZIO[ZConnection, Throwable, UpdateResult[SalesreasonRow]] = {
    sql"""insert into sales.salesreason("salesreasonid", "name", "reasontype", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.salesreasonid)(SalesreasonId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.reasontype)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("salesreasonid")
          do update set
            "name" = EXCLUDED."name",
            "reasontype" = EXCLUDED."reasontype",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "salesreasonid", "name", "reasontype", "modifieddate"::text""".insertReturning(using SalesreasonRow.jdbcDecoder)
  }
}
