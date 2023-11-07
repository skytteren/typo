/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_opfamily

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

class PgOpfamilyRepoMock(map: scala.collection.mutable.Map[PgOpfamilyId, PgOpfamilyRow] = scala.collection.mutable.Map.empty) extends PgOpfamilyRepo {
  override def delete(oid: PgOpfamilyId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(oid).isDefined)
  }
  override def delete: DeleteBuilder[PgOpfamilyFields, PgOpfamilyRow] = {
    DeleteBuilderMock(DeleteParams.empty, PgOpfamilyFields, map)
  }
  override def insert(unsaved: PgOpfamilyRow): ZIO[ZConnection, Throwable, PgOpfamilyRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.oid))
          sys.error(s"id ${unsaved.oid} already exists")
        else
          map.put(unsaved.oid, unsaved)
    
      unsaved
    }
  }
  override def select: SelectBuilder[PgOpfamilyFields, PgOpfamilyRow] = {
    SelectBuilderMock(PgOpfamilyFields, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgOpfamilyRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(oid: PgOpfamilyId): ZIO[ZConnection, Throwable, Option[PgOpfamilyRow]] = {
    ZIO.succeed(map.get(oid))
  }
  override def selectByIds(oids: Array[PgOpfamilyId]): ZStream[ZConnection, Throwable, PgOpfamilyRow] = {
    ZStream.fromIterable(oids.flatMap(map.get))
  }
  override def selectByUnique(opfmethod: /* oid */ Long, opfname: String, opfnamespace: /* oid */ Long): ZIO[ZConnection, Throwable, Option[PgOpfamilyRow]] = {
    ZIO.succeed(map.values.find(v => opfmethod == v.opfmethod && opfname == v.opfname && opfnamespace == v.opfnamespace))
  }
  override def update(row: PgOpfamilyRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.oid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.oid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def update: UpdateBuilder[PgOpfamilyFields, PgOpfamilyRow] = {
    UpdateBuilderMock(UpdateParams.empty, PgOpfamilyFields, map)
  }
  override def upsert(unsaved: PgOpfamilyRow): ZIO[ZConnection, Throwable, UpdateResult[PgOpfamilyRow]] = {
    ZIO.succeed {
      map.put(unsaved.oid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}