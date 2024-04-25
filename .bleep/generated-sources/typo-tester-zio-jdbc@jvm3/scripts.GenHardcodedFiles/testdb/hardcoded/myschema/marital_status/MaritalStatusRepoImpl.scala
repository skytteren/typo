/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import testdb.hardcoded.streamingInsert
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

class MaritalStatusRepoImpl extends MaritalStatusRepo {
  override def delete(id: MaritalStatusId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from myschema.marital_status where "id" = ${Segment.paramSegment(id)(MaritalStatusId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(ids: Array[MaritalStatusId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from myschema.marital_status where "id" = ANY(${ids})""".delete
  }
  override def delete: DeleteBuilder[MaritalStatusFields, MaritalStatusRow] = {
    DeleteBuilder("myschema.marital_status", MaritalStatusFields.structure)
  }
  override def insert(unsaved: MaritalStatusRow): ZIO[ZConnection, Throwable, MaritalStatusRow] = {
    sql"""insert into myschema.marital_status("id")
          values (${Segment.paramSegment(unsaved.id)(MaritalStatusId.setter)}::int8)
          returning "id"
       """.insertReturning(using MaritalStatusRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, MaritalStatusRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY myschema.marital_status("id") FROM STDIN""", batchSize, unsaved)(MaritalStatusRow.text)
  }
  override def select: SelectBuilder[MaritalStatusFields, MaritalStatusRow] = {
    SelectBuilderSql("myschema.marital_status", MaritalStatusFields.structure, MaritalStatusRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, MaritalStatusRow] = {
    sql"""select "id" from myschema.marital_status""".query(using MaritalStatusRow.jdbcDecoder).selectStream()
  }
  override def selectById(id: MaritalStatusId): ZIO[ZConnection, Throwable, Option[MaritalStatusRow]] = {
    sql"""select "id" from myschema.marital_status where "id" = ${Segment.paramSegment(id)(MaritalStatusId.setter)}""".query(using MaritalStatusRow.jdbcDecoder).selectOne
  }
  override def selectByIds(ids: Array[MaritalStatusId]): ZStream[ZConnection, Throwable, MaritalStatusRow] = {
    sql"""select "id" from myschema.marital_status where "id" = ANY(${Segment.paramSegment(ids)(MaritalStatusId.arraySetter)})""".query(using MaritalStatusRow.jdbcDecoder).selectStream()
  }
  override def selectByFieldValues(fieldValues: List[MaritalStatusFieldOrIdValue[?]]): ZStream[ZConnection, Throwable, MaritalStatusRow] = {
    fieldValues match {
      case Nil      => selectAll
      case nonEmpty =>
        val wheres = SqlFragment.empty.and(
          nonEmpty.map {
            case MaritalStatusFieldValue.id(value) => sql""""id" = ${Segment.paramSegment(value)(MaritalStatusId.setter)}"""
          }
        )
        sql"""select "id" from myschema.marital_status where $wheres""".query(using MaritalStatusRow.jdbcDecoder).selectStream()
    }
  }
  override def update: UpdateBuilder[MaritalStatusFields, MaritalStatusRow] = {
    UpdateBuilder("myschema.marital_status", MaritalStatusFields.structure, MaritalStatusRow.jdbcDecoder)
  }
  override def upsert(unsaved: MaritalStatusRow): ZIO[ZConnection, Throwable, UpdateResult[MaritalStatusRow]] = {
    sql"""insert into myschema.marital_status("id")
          values (
            ${Segment.paramSegment(unsaved.id)(MaritalStatusId.setter)}::int8
          )
          on conflict ("id")
          returning "id"""".insertReturning(using MaritalStatusRow.jdbcDecoder)
  }
}
