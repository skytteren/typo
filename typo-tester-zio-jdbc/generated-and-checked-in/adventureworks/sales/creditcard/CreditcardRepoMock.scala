/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package creditcard

import adventureworks.userdefined.CustomCreditcardId
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
import zio.jdbc.JdbcEncoder
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.stream.ZStream

class CreditcardRepoMock(toRow: Function1[CreditcardRowUnsaved, CreditcardRow],
                         map: scala.collection.mutable.Map[/* user-picked */ CustomCreditcardId, CreditcardRow] = scala.collection.mutable.Map.empty) extends CreditcardRepo {
  override def delete: DeleteBuilder[CreditcardFields, CreditcardRow] = {
    DeleteBuilderMock(DeleteParams.empty, CreditcardFields.structure.fields, map)
  }
  override def deleteById(creditcardid: /* user-picked */ CustomCreditcardId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(creditcardid).isDefined)
  }
  override def deleteByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(creditcardids.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: CreditcardRow): ZIO[ZConnection, Throwable, CreditcardRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.creditcardid))
          sys.error(s"id ${unsaved.creditcardid} already exists")
        else
          map.put(unsaved.creditcardid, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: CreditcardRowUnsaved): ZIO[ZConnection, Throwable, CreditcardRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CreditcardRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.creditcardid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CreditcardRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.creditcardid -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[CreditcardFields, CreditcardRow] = {
    SelectBuilderMock(CreditcardFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CreditcardRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(creditcardid: /* user-picked */ CustomCreditcardId): ZIO[ZConnection, Throwable, Option[CreditcardRow]] = {
    ZIO.succeed(map.get(creditcardid))
  }
  override def selectByIds(creditcardids: Array[/* user-picked */ CustomCreditcardId])(implicit encoder0: JdbcEncoder[Array[/* user-picked */ CustomCreditcardId]]): ZStream[ZConnection, Throwable, CreditcardRow] = {
    ZStream.fromIterable(creditcardids.flatMap(map.get))
  }
  override def update: UpdateBuilder[CreditcardFields, CreditcardRow] = {
    UpdateBuilderMock(UpdateParams.empty, CreditcardFields.structure.fields, map)
  }
  override def update(row: CreditcardRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.creditcardid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.creditcardid, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: CreditcardRow): ZIO[ZConnection, Throwable, UpdateResult[CreditcardRow]] = {
    ZIO.succeed {
      map.put(unsaved.creditcardid, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
}
