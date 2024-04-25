/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package countryregion

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

class CountryregionRepoImpl extends CountryregionRepo {
  override def delete: DeleteBuilder[CountryregionFields, CountryregionRow] = {
    DeleteBuilder("person.countryregion", CountryregionFields.structure)
  }
  override def deleteById(countryregioncode: CountryregionId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from person.countryregion where "countryregioncode" = ${Segment.paramSegment(countryregioncode)(CountryregionId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(countryregioncodes: Array[CountryregionId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from person.countryregion where "countryregioncode" = ANY(${countryregioncodes})""".delete
  }
  override def insert(unsaved: CountryregionRow): ZIO[ZConnection, Throwable, CountryregionRow] = {
    sql"""insert into person.countryregion("countryregioncode", "name", "modifieddate")
          values (${Segment.paramSegment(unsaved.countryregioncode)(CountryregionId.setter)}, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "countryregioncode", "name", "modifieddate"::text
       """.insertReturning(using CountryregionRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: CountryregionRowUnsaved): ZIO[ZConnection, Throwable, CountryregionRow] = {
    val fs = List(
      Some((sql""""countryregioncode"""", sql"${Segment.paramSegment(unsaved.countryregioncode)(CountryregionId.setter)}")),
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.countryregion default values
            returning "countryregioncode", "name", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into person.countryregion($names) values ($values) returning "countryregioncode", "name", "modifieddate"::text"""
    }
    q.insertReturning(using CountryregionRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CountryregionRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.countryregion("countryregioncode", "name", "modifieddate") FROM STDIN""", batchSize, unsaved)(CountryregionRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CountryregionRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY person.countryregion("countryregioncode", "name", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(CountryregionRowUnsaved.text)
  }
  override def select: SelectBuilder[CountryregionFields, CountryregionRow] = {
    SelectBuilderSql("person.countryregion", CountryregionFields.structure, CountryregionRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CountryregionRow] = {
    sql"""select "countryregioncode", "name", "modifieddate"::text from person.countryregion""".query(using CountryregionRow.jdbcDecoder).selectStream()
  }
  override def selectById(countryregioncode: CountryregionId): ZIO[ZConnection, Throwable, Option[CountryregionRow]] = {
    sql"""select "countryregioncode", "name", "modifieddate"::text from person.countryregion where "countryregioncode" = ${Segment.paramSegment(countryregioncode)(CountryregionId.setter)}""".query(using CountryregionRow.jdbcDecoder).selectOne
  }
  override def selectByIds(countryregioncodes: Array[CountryregionId]): ZStream[ZConnection, Throwable, CountryregionRow] = {
    sql"""select "countryregioncode", "name", "modifieddate"::text from person.countryregion where "countryregioncode" = ANY(${Segment.paramSegment(countryregioncodes)(CountryregionId.arraySetter)})""".query(using CountryregionRow.jdbcDecoder).selectStream()
  }
  override def update: UpdateBuilder[CountryregionFields, CountryregionRow] = {
    UpdateBuilder("person.countryregion", CountryregionFields.structure, CountryregionRow.jdbcDecoder)
  }
  override def update(row: CountryregionRow): ZIO[ZConnection, Throwable, Boolean] = {
    val countryregioncode = row.countryregioncode
    sql"""update person.countryregion
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "countryregioncode" = ${Segment.paramSegment(countryregioncode)(CountryregionId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: CountryregionRow): ZIO[ZConnection, Throwable, UpdateResult[CountryregionRow]] = {
    sql"""insert into person.countryregion("countryregioncode", "name", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.countryregioncode)(CountryregionId.setter)},
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("countryregioncode")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "countryregioncode", "name", "modifieddate"::text""".insertReturning(using CountryregionRow.jdbcDecoder)
  }
}
