/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package scrapreason

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ScrapreasonRepoImpl extends ScrapreasonRepo {
  override def delete: DeleteBuilder[ScrapreasonFields, ScrapreasonRow] = {
    DeleteBuilder("production.scrapreason", ScrapreasonFields.structure)
  }
  override def deleteById(scrapreasonid: ScrapreasonId): ConnectionIO[Boolean] = {
    sql"""delete from production.scrapreason where "scrapreasonid" = ${fromWrite(scrapreasonid)(Write.fromPut(ScrapreasonId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(scrapreasonids: Array[ScrapreasonId]): ConnectionIO[Int] = {
    sql"""delete from production.scrapreason where "scrapreasonid" = ANY(${scrapreasonids})""".update.run
  }
  override def insert(unsaved: ScrapreasonRow): ConnectionIO[ScrapreasonRow] = {
    sql"""insert into production.scrapreason("scrapreasonid", "name", "modifieddate")
          values (${fromWrite(unsaved.scrapreasonid)(Write.fromPut(ScrapreasonId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "scrapreasonid", "name", "modifieddate"::text
       """.query(using ScrapreasonRow.read).unique
  }
  override def insert(unsaved: ScrapreasonRowUnsaved): ConnectionIO[ScrapreasonRow] = {
    val fs = List(
      Some((Fragment.const0(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      unsaved.scrapreasonid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""scrapreasonid""""), fr"${fromWrite(value: ScrapreasonId)(Write.fromPut(ScrapreasonId.put))}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.scrapreason default values
            returning "scrapreasonid", "name", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.scrapreason(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "scrapreasonid", "name", "modifieddate"::text
         """
    }
    q.query(using ScrapreasonRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ScrapreasonRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.scrapreason("scrapreasonid", "name", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ScrapreasonRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ScrapreasonRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.scrapreason("name", "scrapreasonid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ScrapreasonRowUnsaved.text)
  }
  override def select: SelectBuilder[ScrapreasonFields, ScrapreasonRow] = {
    SelectBuilderSql("production.scrapreason", ScrapreasonFields.structure, ScrapreasonRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ScrapreasonRow] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason""".query(using ScrapreasonRow.read).stream
  }
  override def selectById(scrapreasonid: ScrapreasonId): ConnectionIO[Option[ScrapreasonRow]] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason where "scrapreasonid" = ${fromWrite(scrapreasonid)(Write.fromPut(ScrapreasonId.put))}""".query(using ScrapreasonRow.read).option
  }
  override def selectByIds(scrapreasonids: Array[ScrapreasonId]): Stream[ConnectionIO, ScrapreasonRow] = {
    sql"""select "scrapreasonid", "name", "modifieddate"::text from production.scrapreason where "scrapreasonid" = ANY(${scrapreasonids})""".query(using ScrapreasonRow.read).stream
  }
  override def selectByIdsTracked(scrapreasonids: Array[ScrapreasonId]): ConnectionIO[Map[ScrapreasonId, ScrapreasonRow]] = {
    selectByIds(scrapreasonids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.scrapreasonid, x)).toMap
      scrapreasonids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ScrapreasonFields, ScrapreasonRow] = {
    UpdateBuilder("production.scrapreason", ScrapreasonFields.structure, ScrapreasonRow.read)
  }
  override def update(row: ScrapreasonRow): ConnectionIO[Boolean] = {
    val scrapreasonid = row.scrapreasonid
    sql"""update production.scrapreason
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "scrapreasonid" = ${fromWrite(scrapreasonid)(Write.fromPut(ScrapreasonId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ScrapreasonRow): ConnectionIO[ScrapreasonRow] = {
    sql"""insert into production.scrapreason("scrapreasonid", "name", "modifieddate")
          values (
            ${fromWrite(unsaved.scrapreasonid)(Write.fromPut(ScrapreasonId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("scrapreasonid")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "scrapreasonid", "name", "modifieddate"::text
       """.query(using ScrapreasonRow.read).unique
  }
  override def upsertBatch(unsaved: List[ScrapreasonRow]): Stream[ConnectionIO, ScrapreasonRow] = {
    Update[ScrapreasonRow](
      s"""insert into production.scrapreason("scrapreasonid", "name", "modifieddate")
          values (?::int4,?::varchar,?::timestamp)
          on conflict ("scrapreasonid")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "scrapreasonid", "name", "modifieddate"::text"""
    )(using ScrapreasonRow.write)
    .updateManyWithGeneratedKeys[ScrapreasonRow]("scrapreasonid", "name", "modifieddate")(unsaved)(using catsStdInstancesForList, ScrapreasonRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, ScrapreasonRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table scrapreason_TEMP (like production.scrapreason) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy scrapreason_TEMP("scrapreasonid", "name", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using ScrapreasonRow.text)
      res <- sql"""insert into production.scrapreason("scrapreasonid", "name", "modifieddate")
                   select * from scrapreason_TEMP
                   on conflict ("scrapreasonid")
                   do update set
                     "name" = EXCLUDED."name",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table scrapreason_TEMP;""".update.run
    } yield res
  }
}
