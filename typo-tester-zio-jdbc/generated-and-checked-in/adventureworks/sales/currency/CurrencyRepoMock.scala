/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

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

class CurrencyRepoMock(toRow: Function1[CurrencyRowUnsaved, CurrencyRow],
                       map: scala.collection.mutable.Map[CurrencyId, CurrencyRow] = scala.collection.mutable.Map.empty) extends CurrencyRepo {
  override def delete: DeleteBuilder[CurrencyFields, CurrencyRow] = {
    DeleteBuilderMock(DeleteParams.empty, CurrencyFields.structure, map)
  }
  override def deleteById(currencycode: CurrencyId): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed(map.remove(currencycode).isDefined)
  }
  override def deleteByIds(currencycodes: Array[CurrencyId]): ZIO[ZConnection, Throwable, Long] = {
    ZIO.succeed(currencycodes.map(id => map.remove(id)).count(_.isDefined).toLong)
  }
  override def insert(unsaved: CurrencyRow): ZIO[ZConnection, Throwable, CurrencyRow] = {
    ZIO.succeed {
      val _ =
        if (map.contains(unsaved.currencycode))
          sys.error(s"id ${unsaved.currencycode} already exists")
        else
          map.put(unsaved.currencycode, unsaved)
    
      unsaved
    }
  }
  override def insert(unsaved: CurrencyRowUnsaved): ZIO[ZConnection, Throwable, CurrencyRow] = {
    insert(toRow(unsaved))
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, CurrencyRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.currencycode -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, CurrencyRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, unsavedRow) =>
      ZIO.succeed {
        val row = toRow(unsavedRow)
        map += (row.currencycode -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
  override def select: SelectBuilder[CurrencyFields, CurrencyRow] = {
    SelectBuilderMock(CurrencyFields.structure, ZIO.succeed(Chunk.fromIterable(map.values)), SelectParams.empty)
  }
  override def selectAll: ZStream[ZConnection, Throwable, CurrencyRow] = {
    ZStream.fromIterable(map.values)
  }
  override def selectById(currencycode: CurrencyId): ZIO[ZConnection, Throwable, Option[CurrencyRow]] = {
    ZIO.succeed(map.get(currencycode))
  }
  override def selectByIds(currencycodes: Array[CurrencyId]): ZStream[ZConnection, Throwable, CurrencyRow] = {
    ZStream.fromIterable(currencycodes.flatMap(map.get))
  }
  override def selectByIdsTracked(currencycodes: Array[CurrencyId]): ZIO[ZConnection, Throwable, Map[CurrencyId, CurrencyRow]] = {
    selectByIds(currencycodes).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.currencycode, x)).toMap
      currencycodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[CurrencyFields, CurrencyRow] = {
    UpdateBuilderMock(UpdateParams.empty, CurrencyFields.structure, map)
  }
  override def update(row: CurrencyRow): ZIO[ZConnection, Throwable, Boolean] = {
    ZIO.succeed {
      map.get(row.currencycode) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.currencycode, row): @nowarn
          true
        case None => false
      }
    }
  }
  override def upsert(unsaved: CurrencyRow): ZIO[ZConnection, Throwable, UpdateResult[CurrencyRow]] = {
    ZIO.succeed {
      map.put(unsaved.currencycode, unsaved): @nowarn
      UpdateResult(1, Chunk.single(unsaved))
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: ZStream[ZConnection, Throwable, CurrencyRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    unsaved.scanZIO(0L) { case (acc, row) =>
      ZIO.succeed {
        map += (row.currencycode -> row)
        acc + 1
      }
    }.runLast.map(_.getOrElse(0L))
  }
}
