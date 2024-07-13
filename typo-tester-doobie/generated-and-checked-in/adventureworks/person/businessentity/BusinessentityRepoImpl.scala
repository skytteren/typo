/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentity

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
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

class BusinessentityRepoImpl extends BusinessentityRepo {
  override def delete: DeleteBuilder[BusinessentityFields, BusinessentityRow] = {
    DeleteBuilder("person.businessentity", BusinessentityFields.structure)
  }
  override def deleteById(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"""delete from person.businessentity where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int] = {
    sql"""delete from person.businessentity where "businessentityid" = ANY(${businessentityids})""".update.run
  }
  override def insert(unsaved: BusinessentityRow): ConnectionIO[BusinessentityRow] = {
    sql"""insert into person.businessentity("businessentityid", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "rowguid", "modifieddate"::text
       """.query(using BusinessentityRow.read).unique
  }
  override def insert(unsaved: BusinessentityRowUnsaved): ConnectionIO[BusinessentityRow] = {
    val fs = List(
      unsaved.businessentityid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""businessentityid""""), fr"${fromWrite(value: BusinessentityId)(Write.fromPut(BusinessentityId.put))}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.businessentity default values
            returning "businessentityid", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into person.businessentity(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "rowguid", "modifieddate"::text
         """
    }
    q.query(using BusinessentityRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, BusinessentityRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.businessentity("businessentityid", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using BusinessentityRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, BusinessentityRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.businessentity("businessentityid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using BusinessentityRowUnsaved.text)
  }
  override def select: SelectBuilder[BusinessentityFields, BusinessentityRow] = {
    SelectBuilderSql("person.businessentity", BusinessentityFields.structure, BusinessentityRow.read)
  }
  override def selectAll: Stream[ConnectionIO, BusinessentityRow] = {
    sql"""select "businessentityid", "rowguid", "modifieddate"::text from person.businessentity""".query(using BusinessentityRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[BusinessentityRow]] = {
    sql"""select "businessentityid", "rowguid", "modifieddate"::text from person.businessentity where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".query(using BusinessentityRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, BusinessentityRow] = {
    sql"""select "businessentityid", "rowguid", "modifieddate"::text from person.businessentity where "businessentityid" = ANY(${businessentityids})""".query(using BusinessentityRow.read).stream
  }
  override def selectByIdsTracked(businessentityids: Array[BusinessentityId]): ConnectionIO[Map[BusinessentityId, BusinessentityRow]] = {
    selectByIds(businessentityids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.businessentityid, x)).toMap
      businessentityids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[BusinessentityFields, BusinessentityRow] = {
    UpdateBuilder("person.businessentity", BusinessentityFields.structure, BusinessentityRow.read)
  }
  override def update(row: BusinessentityRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update person.businessentity
          set "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: BusinessentityRow): ConnectionIO[BusinessentityRow] = {
    sql"""insert into person.businessentity("businessentityid", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "rowguid", "modifieddate"::text
       """.query(using BusinessentityRow.read).unique
  }
  override def upsertBatch(unsaved: List[BusinessentityRow]): Stream[ConnectionIO, BusinessentityRow] = {
    Update[BusinessentityRow](
      s"""insert into person.businessentity("businessentityid", "rowguid", "modifieddate")
          values (?::int4,?::uuid,?::timestamp)
          on conflict ("businessentityid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "rowguid", "modifieddate"::text"""
    )(using BusinessentityRow.write)
    .updateManyWithGeneratedKeys[BusinessentityRow]("businessentityid", "rowguid", "modifieddate")(unsaved)(using catsStdInstancesForList, BusinessentityRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, BusinessentityRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table businessentity_TEMP (like person.businessentity) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy businessentity_TEMP("businessentityid", "rowguid", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using BusinessentityRow.text)
      res <- sql"""insert into person.businessentity("businessentityid", "rowguid", "modifieddate")
                   select * from businessentity_TEMP
                   on conflict ("businessentityid")
                   do update set
                     "rowguid" = EXCLUDED."rowguid",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table businessentity_TEMP;""".update.run
    } yield res
  }
}
