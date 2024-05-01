/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.public.Name
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class DepartmentRepoImpl extends DepartmentRepo {
  override def delete: DeleteBuilder[DepartmentFields, DepartmentRow] = {
    DeleteBuilder("humanresources.department", DepartmentFields.structure)
  }
  override def deleteById(departmentid: DepartmentId): ConnectionIO[Boolean] = {
    sql"""delete from humanresources.department where "departmentid" = ${fromWrite(departmentid)(Write.fromPut(DepartmentId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(departmentids: Array[DepartmentId]): ConnectionIO[Int] = {
    sql"""delete from humanresources.department where "departmentid" = ANY(${departmentids})""".update.run
  }
  override def insert(unsaved: DepartmentRow): ConnectionIO[DepartmentRow] = {
    sql"""insert into humanresources.department("departmentid", "name", "groupname", "modifieddate")
          values (${fromWrite(unsaved.departmentid)(Write.fromPut(DepartmentId.put))}::int4, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.groupname)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "departmentid", "name", "groupname", "modifieddate"::text
       """.query(using DepartmentRow.read).unique
  }
  override def insert(unsaved: DepartmentRowUnsaved): ConnectionIO[DepartmentRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      Some((Fragment.const(s""""groupname""""), fr"${fromWrite(unsaved.groupname)(Write.fromPut(Name.put))}::varchar")),
      unsaved.departmentid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""departmentid""""), fr"${fromWrite(value: DepartmentId)(Write.fromPut(DepartmentId.put))}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.department default values
            returning "departmentid", "name", "groupname", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into humanresources.department(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "departmentid", "name", "groupname", "modifieddate"::text
         """
    }
    q.query(using DepartmentRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, DepartmentRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY humanresources.department("departmentid", "name", "groupname", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using DepartmentRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, DepartmentRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY humanresources.department("name", "groupname", "departmentid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using DepartmentRowUnsaved.text)
  }
  override def select: SelectBuilder[DepartmentFields, DepartmentRow] = {
    SelectBuilderSql("humanresources.department", DepartmentFields.structure, DepartmentRow.read)
  }
  override def selectAll: Stream[ConnectionIO, DepartmentRow] = {
    sql"""select "departmentid", "name", "groupname", "modifieddate"::text from humanresources.department""".query(using DepartmentRow.read).stream
  }
  override def selectById(departmentid: DepartmentId): ConnectionIO[Option[DepartmentRow]] = {
    sql"""select "departmentid", "name", "groupname", "modifieddate"::text from humanresources.department where "departmentid" = ${fromWrite(departmentid)(Write.fromPut(DepartmentId.put))}""".query(using DepartmentRow.read).option
  }
  override def selectByIds(departmentids: Array[DepartmentId]): Stream[ConnectionIO, DepartmentRow] = {
    sql"""select "departmentid", "name", "groupname", "modifieddate"::text from humanresources.department where "departmentid" = ANY(${departmentids})""".query(using DepartmentRow.read).stream
  }
  override def selectByIdsTracked(departmentids: Array[DepartmentId]): ConnectionIO[Map[DepartmentId, Option[DepartmentRow]]] = {
    selectByIds(departmentids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.departmentid, x)).toMap
      departmentids.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[DepartmentFields, DepartmentRow] = {
    UpdateBuilder("humanresources.department", DepartmentFields.structure, DepartmentRow.read)
  }
  override def update(row: DepartmentRow): ConnectionIO[Boolean] = {
    val departmentid = row.departmentid
    sql"""update humanresources.department
          set "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "groupname" = ${fromWrite(row.groupname)(Write.fromPut(Name.put))}::varchar,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "departmentid" = ${fromWrite(departmentid)(Write.fromPut(DepartmentId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: DepartmentRow): ConnectionIO[DepartmentRow] = {
    sql"""insert into humanresources.department("departmentid", "name", "groupname", "modifieddate")
          values (
            ${fromWrite(unsaved.departmentid)(Write.fromPut(DepartmentId.put))}::int4,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.groupname)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("departmentid")
          do update set
            "name" = EXCLUDED."name",
            "groupname" = EXCLUDED."groupname",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "departmentid", "name", "groupname", "modifieddate"::text
       """.query(using DepartmentRow.read).unique
  }
}
