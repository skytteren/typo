/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package identity_test

import adventureworks.customtypes.Defaulted
import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class IdentityTestRepoImpl extends IdentityTestRepo {
  override def delete: DeleteBuilder[IdentityTestFields, IdentityTestRow] = {
    DeleteBuilder(""""public"."identity-test"""", IdentityTestFields.structure)
  }
  override def deleteById(name: IdentityTestId): ConnectionIO[Boolean] = {
    sql"""delete from "public"."identity-test" where "name" = ${fromWrite(name)(Write.fromPut(IdentityTestId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(names: Array[IdentityTestId]): ConnectionIO[Int] = {
    sql"""delete from "public"."identity-test" where "name" = ANY(${names})""".update.run
  }
  override def insert(unsaved: IdentityTestRow): ConnectionIO[IdentityTestRow] = {
    sql"""insert into "public"."identity-test"("default_generated", "name")
          values (${fromWrite(unsaved.defaultGenerated)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(IdentityTestId.put))})
          returning "always_generated", "default_generated", "name"
       """.query(using IdentityTestRow.read).unique
  }
  override def insert(unsaved: IdentityTestRowUnsaved): ConnectionIO[IdentityTestRow] = {
    val fs = List(
      Some((Fragment.const0(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(IdentityTestId.put))}")),
      unsaved.defaultGenerated match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""default_generated""""), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int4"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into "public"."identity-test" default values
            returning "always_generated", "default_generated", "name"
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into "public"."identity-test"(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "always_generated", "default_generated", "name"
         """
    }
    q.query(using IdentityTestRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, IdentityTestRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY "public"."identity-test"("default_generated", "name") FROM STDIN""").copyIn(unsaved, batchSize)(using IdentityTestRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, IdentityTestRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY "public"."identity-test"("name", "default_generated") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using IdentityTestRowUnsaved.text)
  }
  override def select: SelectBuilder[IdentityTestFields, IdentityTestRow] = {
    SelectBuilderSql(""""public"."identity-test"""", IdentityTestFields.structure, IdentityTestRow.read)
  }
  override def selectAll: Stream[ConnectionIO, IdentityTestRow] = {
    sql"""select "always_generated", "default_generated", "name" from "public"."identity-test"""".query(using IdentityTestRow.read).stream
  }
  override def selectById(name: IdentityTestId): ConnectionIO[Option[IdentityTestRow]] = {
    sql"""select "always_generated", "default_generated", "name" from "public"."identity-test" where "name" = ${fromWrite(name)(Write.fromPut(IdentityTestId.put))}""".query(using IdentityTestRow.read).option
  }
  override def selectByIds(names: Array[IdentityTestId]): Stream[ConnectionIO, IdentityTestRow] = {
    sql"""select "always_generated", "default_generated", "name" from "public"."identity-test" where "name" = ANY(${names})""".query(using IdentityTestRow.read).stream
  }
  override def selectByIdsTracked(names: Array[IdentityTestId]): ConnectionIO[Map[IdentityTestId, IdentityTestRow]] = {
    selectByIds(names).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.name, x)).toMap
      names.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[IdentityTestFields, IdentityTestRow] = {
    UpdateBuilder(""""public"."identity-test"""", IdentityTestFields.structure, IdentityTestRow.read)
  }
  override def update(row: IdentityTestRow): ConnectionIO[Boolean] = {
    val name = row.name
    sql"""update "public"."identity-test"
          set "default_generated" = ${fromWrite(row.defaultGenerated)(Write.fromPut(Meta.IntMeta.put))}::int4
          where "name" = ${fromWrite(name)(Write.fromPut(IdentityTestId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: IdentityTestRow): ConnectionIO[IdentityTestRow] = {
    sql"""insert into "public"."identity-test"("default_generated", "name")
          values (
            ${fromWrite(unsaved.defaultGenerated)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(IdentityTestId.put))}
          )
          on conflict ("name")
          do update set
            "default_generated" = EXCLUDED."default_generated"
          returning "always_generated", "default_generated", "name"
       """.query(using IdentityTestRow.read).unique
  }
  override def upsertBatch(unsaved: List[IdentityTestRow]): Stream[ConnectionIO, IdentityTestRow] = {
    Update[IdentityTestRow](
      s"""insert into "public"."identity-test"("default_generated", "name")
          values (?::int4,?)
          on conflict ("name")
          do update set
            "default_generated" = EXCLUDED."default_generated"
          returning "always_generated", "default_generated", "name""""
    )(using IdentityTestRow.write)
    .updateManyWithGeneratedKeys[IdentityTestRow]("always_generated", "default_generated", "name")(unsaved)(using catsStdInstancesForList, IdentityTestRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, IdentityTestRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"""create temporary table identity-test_TEMP (like "public"."identity-test") on commit drop""".update.run
      _ <- new FragmentOps(sql"""copy identity-test_TEMP("default_generated", "name") from stdin""").copyIn(unsaved, batchSize)(using IdentityTestRow.text)
      res <- sql"""insert into "public"."identity-test"("default_generated", "name")
                   select * from identity-test_TEMP
                   on conflict ("name")
                   do update set
                     "default_generated" = EXCLUDED."default_generated"
                   ;
                   drop table identity-test_TEMP;""".update.run
    } yield res
  }
}
