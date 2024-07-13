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

class CountryregionRepoImpl extends CountryregionRepo {
  override def delete: DeleteBuilder[CountryregionFields, CountryregionRow] = {
    DeleteBuilder("person.countryregion", CountryregionFields.structure)
  }
  override def deleteById(countryregioncode: CountryregionId): ConnectionIO[Boolean] = {
    sql"""delete from person.countryregion where "countryregioncode" = ${fromWrite(countryregioncode)(Write.fromPut(CountryregionId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(countryregioncodes: Array[CountryregionId]): ConnectionIO[Int] = {
    sql"""delete from person.countryregion where "countryregioncode" = ANY(${countryregioncodes})""".update.run
  }
  override def insert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow] = {
    sql"""insert into person.countryregion("countryregioncode", "name", "modifieddate")
          values (${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))}, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "countryregioncode", "name", "modifieddate"::text
       """.query(using CountryregionRow.read).unique
  }
  override def insert(unsaved: CountryregionRowUnsaved): ConnectionIO[CountryregionRow] = {
    val fs = List(
      Some((Fragment.const0(s""""countryregioncode""""), fr"${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))}")),
      Some((Fragment.const0(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.countryregion default values
            returning "countryregioncode", "name", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into person.countryregion(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "countryregioncode", "name", "modifieddate"::text
         """
    }
    q.query(using CountryregionRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, CountryregionRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.countryregion("countryregioncode", "name", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using CountryregionRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, CountryregionRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.countryregion("countryregioncode", "name", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using CountryregionRowUnsaved.text)
  }
  override def select: SelectBuilder[CountryregionFields, CountryregionRow] = {
    SelectBuilderSql("person.countryregion", CountryregionFields.structure, CountryregionRow.read)
  }
  override def selectAll: Stream[ConnectionIO, CountryregionRow] = {
    sql"""select "countryregioncode", "name", "modifieddate"::text from person.countryregion""".query(using CountryregionRow.read).stream
  }
  override def selectById(countryregioncode: CountryregionId): ConnectionIO[Option[CountryregionRow]] = {
    sql"""select "countryregioncode", "name", "modifieddate"::text from person.countryregion where "countryregioncode" = ${fromWrite(countryregioncode)(Write.fromPut(CountryregionId.put))}""".query(using CountryregionRow.read).option
  }
  override def selectByIds(countryregioncodes: Array[CountryregionId]): Stream[ConnectionIO, CountryregionRow] = {
    sql"""select "countryregioncode", "name", "modifieddate"::text from person.countryregion where "countryregioncode" = ANY(${countryregioncodes})""".query(using CountryregionRow.read).stream
  }
  override def selectByIdsTracked(countryregioncodes: Array[CountryregionId]): ConnectionIO[Map[CountryregionId, CountryregionRow]] = {
    selectByIds(countryregioncodes).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.countryregioncode, x)).toMap
      countryregioncodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[CountryregionFields, CountryregionRow] = {
    UpdateBuilder("person.countryregion", CountryregionFields.structure, CountryregionRow.read)
  }
  override def update(row: CountryregionRow): ConnectionIO[Boolean] = {
    val countryregioncode = row.countryregioncode
    sql"""update person.countryregion
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "countryregioncode" = ${fromWrite(countryregioncode)(Write.fromPut(CountryregionId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: CountryregionRow): ConnectionIO[CountryregionRow] = {
    sql"""insert into person.countryregion("countryregioncode", "name", "modifieddate")
          values (
            ${fromWrite(unsaved.countryregioncode)(Write.fromPut(CountryregionId.put))},
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("countryregioncode")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "countryregioncode", "name", "modifieddate"::text
       """.query(using CountryregionRow.read).unique
  }
  override def upsertBatch(unsaved: List[CountryregionRow]): Stream[ConnectionIO, CountryregionRow] = {
    Update[CountryregionRow](
      s"""insert into person.countryregion("countryregioncode", "name", "modifieddate")
          values (?,?::varchar,?::timestamp)
          on conflict ("countryregioncode")
          do update set
            "name" = EXCLUDED."name",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "countryregioncode", "name", "modifieddate"::text"""
    )(using CountryregionRow.write)
    .updateManyWithGeneratedKeys[CountryregionRow]("countryregioncode", "name", "modifieddate")(unsaved)(using catsStdInstancesForList, CountryregionRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, CountryregionRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table countryregion_TEMP (like person.countryregion) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy countryregion_TEMP("countryregioncode", "name", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using CountryregionRow.text)
      res <- sql"""insert into person.countryregion("countryregioncode", "name", "modifieddate")
                   select * from countryregion_TEMP
                   on conflict ("countryregioncode")
                   do update set
                     "name" = EXCLUDED."name",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table countryregion_TEMP;""".update.run
    } yield res
  }
}
