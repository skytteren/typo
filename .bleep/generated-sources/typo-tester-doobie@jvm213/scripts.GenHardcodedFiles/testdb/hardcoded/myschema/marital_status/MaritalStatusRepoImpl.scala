/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragments
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class MaritalStatusRepoImpl extends MaritalStatusRepo {
  override def delete: DeleteBuilder[MaritalStatusFields, MaritalStatusRow] = {
    DeleteBuilder("myschema.marital_status", MaritalStatusFields.structure)
  }
  override def deleteById(id: MaritalStatusId): ConnectionIO[Boolean] = {
    sql"""delete from myschema.marital_status where "id" = ${fromWrite(id)(Write.fromPut(MaritalStatusId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(ids: Array[MaritalStatusId]): ConnectionIO[Int] = {
    sql"""delete from myschema.marital_status where "id" = ANY(${ids})""".update.run
  }
  override def insert(unsaved: MaritalStatusRow): ConnectionIO[MaritalStatusRow] = {
    sql"""insert into myschema.marital_status("id")
          values (${fromWrite(unsaved.id)(Write.fromPut(MaritalStatusId.put))}::int8)
          returning "id"
       """.query(using MaritalStatusRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, MaritalStatusRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY myschema.marital_status("id") FROM STDIN""").copyIn(unsaved, batchSize)(using MaritalStatusRow.text)
  }
  override def select: SelectBuilder[MaritalStatusFields, MaritalStatusRow] = {
    SelectBuilderSql("myschema.marital_status", MaritalStatusFields.structure, MaritalStatusRow.read)
  }
  override def selectAll: Stream[ConnectionIO, MaritalStatusRow] = {
    sql"""select "id" from myschema.marital_status""".query(using MaritalStatusRow.read).stream
  }
  override def selectByFieldValues(fieldValues: List[MaritalStatusFieldOrIdValue[?]]): Stream[ConnectionIO, MaritalStatusRow] = {
    val where = fragments.whereAndOpt(
      fieldValues.map {
        case MaritalStatusFieldValue.id(value) => fr""""id" = ${fromWrite(value)(Write.fromPut(MaritalStatusId.put))}"""
      }
    )
    sql"""select "id" from myschema.marital_status $where""".query(using MaritalStatusRow.read).stream
  }
  override def selectById(id: MaritalStatusId): ConnectionIO[Option[MaritalStatusRow]] = {
    sql"""select "id" from myschema.marital_status where "id" = ${fromWrite(id)(Write.fromPut(MaritalStatusId.put))}""".query(using MaritalStatusRow.read).option
  }
  override def selectByIds(ids: Array[MaritalStatusId]): Stream[ConnectionIO, MaritalStatusRow] = {
    sql"""select "id" from myschema.marital_status where "id" = ANY(${ids})""".query(using MaritalStatusRow.read).stream
  }
  override def selectByIdsTracked(ids: Array[MaritalStatusId]): ConnectionIO[Map[MaritalStatusId, MaritalStatusRow]] = {
    selectByIds(ids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.id, x)).toMap
      ids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[MaritalStatusFields, MaritalStatusRow] = {
    UpdateBuilder("myschema.marital_status", MaritalStatusFields.structure, MaritalStatusRow.read)
  }
  override def upsert(unsaved: MaritalStatusRow): ConnectionIO[MaritalStatusRow] = {
    sql"""insert into myschema.marital_status("id")
          values (
            ${fromWrite(unsaved.id)(Write.fromPut(MaritalStatusId.put))}::int8
          )
          on conflict ("id")
          do nothing
          returning "id"
       """.query(using MaritalStatusRow.read).unique
  }
  override def upsertBatch(unsaved: List[MaritalStatusRow]): Stream[ConnectionIO, MaritalStatusRow] = {
    Update[MaritalStatusRow](
      s"""insert into myschema.marital_status("id")
          values (?::int8)
          on conflict ("id")
          do nothing
          returning "id""""
    )(using MaritalStatusRow.write)
    .updateManyWithGeneratedKeys[MaritalStatusRow]("id")(unsaved)(using catsStdInstancesForList, MaritalStatusRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, MaritalStatusRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table marital_status_TEMP (like myschema.marital_status) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy marital_status_TEMP("id") from stdin""").copyIn(unsaved, batchSize)(using MaritalStatusRow.text)
      res <- sql"""insert into myschema.marital_status("id")
                   select * from marital_status_TEMP
                   on conflict ("id")
                   do nothing
                   ;
                   drop table marital_status_TEMP;""".update.run
    } yield res
  }
}
