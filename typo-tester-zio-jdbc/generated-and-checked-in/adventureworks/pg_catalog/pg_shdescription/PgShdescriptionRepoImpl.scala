/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdescription

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgShdescriptionRepoImpl extends PgShdescriptionRepo {
  override def delete(compositeId: PgShdescriptionId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from pg_catalog.pg_shdescription where "objoid" = ${Segment.paramSegment(compositeId.objoid)(Setter.longSetter)} AND "classoid" = ${Segment.paramSegment(compositeId.classoid)(Setter.longSetter)}""".delete.map(_ > 0)
  }
  override def delete: DeleteBuilder[PgShdescriptionFields, PgShdescriptionRow] = {
    DeleteBuilder("pg_catalog.pg_shdescription", PgShdescriptionFields)
  }
  override def insert(unsaved: PgShdescriptionRow): ZIO[ZConnection, Throwable, PgShdescriptionRow] = {
    sql"""insert into pg_catalog.pg_shdescription("objoid", "classoid", "description")
          values (${Segment.paramSegment(unsaved.objoid)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.classoid)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.description)(Setter.stringSetter)})
          returning "objoid", "classoid", "description"
       """.insertReturning(PgShdescriptionRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def select: SelectBuilder[PgShdescriptionFields, PgShdescriptionRow] = {
    SelectBuilderSql("pg_catalog.pg_shdescription", PgShdescriptionFields, PgShdescriptionRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgShdescriptionRow] = {
    sql"""select "objoid", "classoid", "description" from pg_catalog.pg_shdescription""".query(PgShdescriptionRow.jdbcDecoder).selectStream
  }
  override def selectById(compositeId: PgShdescriptionId): ZIO[ZConnection, Throwable, Option[PgShdescriptionRow]] = {
    sql"""select "objoid", "classoid", "description" from pg_catalog.pg_shdescription where "objoid" = ${Segment.paramSegment(compositeId.objoid)(Setter.longSetter)} AND "classoid" = ${Segment.paramSegment(compositeId.classoid)(Setter.longSetter)}""".query(PgShdescriptionRow.jdbcDecoder).selectOne
  }
  override def update(row: PgShdescriptionRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update pg_catalog.pg_shdescription
          set "description" = ${Segment.paramSegment(row.description)(Setter.stringSetter)}
          where "objoid" = ${Segment.paramSegment(compositeId.objoid)(Setter.longSetter)} AND "classoid" = ${Segment.paramSegment(compositeId.classoid)(Setter.longSetter)}""".update.map(_ > 0)
  }
  override def update: UpdateBuilder[PgShdescriptionFields, PgShdescriptionRow] = {
    UpdateBuilder("pg_catalog.pg_shdescription", PgShdescriptionFields, PgShdescriptionRow.jdbcDecoder)
  }
  override def upsert(unsaved: PgShdescriptionRow): ZIO[ZConnection, Throwable, UpdateResult[PgShdescriptionRow]] = {
    sql"""insert into pg_catalog.pg_shdescription("objoid", "classoid", "description")
          values (
            ${Segment.paramSegment(unsaved.objoid)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.classoid)(Setter.longSetter)}::oid,
            ${Segment.paramSegment(unsaved.description)(Setter.stringSetter)}
          )
          on conflict ("objoid", "classoid")
          do update set
            "description" = EXCLUDED."description"
          returning "objoid", "classoid", "description"""".insertReturning(PgShdescriptionRow.jdbcDecoder)
  }
}