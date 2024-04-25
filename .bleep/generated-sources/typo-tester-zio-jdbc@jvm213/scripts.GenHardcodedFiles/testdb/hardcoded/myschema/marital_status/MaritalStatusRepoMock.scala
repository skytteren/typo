/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.DeleteBuilder.DeleteBuilderMock
import typo.dsl.DeleteParams
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderMock
import typo.dsl.SelectParams
import typo.dsl.UpdateBuilder
import typo.dsl.UpdateBuilder.UpdateBuilderMock
import typo.dsl.UpdateParams
import zio.Chunk
import zio.ZIO
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

class MaritalStatusRepoMock(map: scala.collection.mutable.Map[MaritalStatusId, MaritalStatusRow] = scala.collection.mutable.Map.empty) extends MaritalStatusRepo {
  override def delete: DeleteBuilder[MaritalStatusFields, MaritalStatusRow] = {
    DeleteBuilderMock(DeleteParams.empty, MaritalStatusFields.structure.fields, map)
  }
  override def deleteById(id: MaritalStatusId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(id).isDefined)
  }
  override def deleteByIds(ids: Array[MaritalStatusId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(ids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: MaritalStatusRow): ZIO[ZConnection, Throwable, MaritalStatusRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.id))
          sys.error(s"id ${unsaved.id} already exists")
        else
          map.put(unsaved.id, unsaved)
    
      unsaved
    }
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, MaritalStatusRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.id -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[MaritalStatusFields, MaritalStatusRow] = {
    SelectBuilderMock(MaritalStatusFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, MaritalStatusRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectByFieldValues(fieldValues: List[MaritalStatusFieldOrIdValue[?]]): ZStream[ZConnection, Throwable, MaritalStatusRow] = {
    ZStream.fromIterable {
      fieldValues.foldLeft(map.values) {
        case (acc, MaritalStatusFieldValue.id(value)) => acc.filter(_.id == value)
      }
    }
  }
  override def selectById(id: MaritalStatusId): ZIO[ZConnection, Throwable, Option[MaritalStatusRow]] = {
    ZIO.succeed(map.get(id))
  }
  override def selectByIds(ids: Array[MaritalStatusId]): ZStream[ZConnection, Throwable, MaritalStatusRow] = {
    ZStream.fromIterable(ids.flatMap(map.get))
  }
  override def update: UpdateBuilder[MaritalStatusFields, MaritalStatusRow] = {
    UpdateBuilderMock(UpdateParams.empty, MaritalStatusFields.structure.fields, map)
  }
  override def upsert(unsaved: MaritalStatusRow): ZIO[ZConnection, Throwable, UpdateResult[MaritalStatusRow]] = {
    ZIO.succeed {
      map.put(unsaved.id, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
