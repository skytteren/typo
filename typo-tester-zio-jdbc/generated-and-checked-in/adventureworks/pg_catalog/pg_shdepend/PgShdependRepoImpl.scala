/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_shdepend

import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

object PgShdependRepoImpl extends PgShdependRepo {
  override def delete: DeleteBuilder[PgShdependFields, PgShdependRow] = {
    DeleteBuilder("pg_catalog.pg_shdepend", PgShdependFields)
  }
  override def insert(unsaved: PgShdependRow): ZIO[ZConnection, Throwable, PgShdependRow] = {
    sql"""insert into pg_catalog.pg_shdepend("dbid", "classid", "objid", "objsubid", "refclassid", "refobjid", "deptype")
          values (${Segment.paramSegment(unsaved.dbid)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.classid)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.objid)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.objsubid)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.refclassid)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.refobjid)(Setter.longSetter)}::oid, ${Segment.paramSegment(unsaved.deptype)(Setter.stringSetter)}::char)
          returning "dbid", "classid", "objid", "objsubid", "refclassid", "refobjid", "deptype"
       """.insertReturning(PgShdependRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def select: SelectBuilder[PgShdependFields, PgShdependRow] = {
    SelectBuilderSql("pg_catalog.pg_shdepend", PgShdependFields, PgShdependRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgShdependRow] = {
    sql"""select "dbid", "classid", "objid", "objsubid", "refclassid", "refobjid", "deptype" from pg_catalog.pg_shdepend""".query(PgShdependRow.jdbcDecoder).selectStream
  }
  override def update: UpdateBuilder[PgShdependFields, PgShdependRow] = {
    UpdateBuilder("pg_catalog.pg_shdepend", PgShdependFields, PgShdependRow.jdbcDecoder)
  }
}