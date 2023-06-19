/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package department

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime

object DepartmentRepoImpl extends DepartmentRepo {
  override def delete(departmentid: DepartmentId): ConnectionIO[Boolean] = {
    sql"delete from humanresources.department where departmentid = $departmentid".update.run.map(_ > 0)
  }
  override def insert(unsaved: DepartmentRow): ConnectionIO[DepartmentRow] = {
    sql"""insert into humanresources.department(departmentid, "name", groupname, modifieddate)
          values (${unsaved.departmentid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.groupname}::"public"."Name", ${unsaved.modifieddate}::timestamp)
          returning departmentid, "name", groupname, modifieddate
       """.query[DepartmentRow].unique
  }
  override def insert(unsaved: DepartmentRowUnsaved): ConnectionIO[DepartmentRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      Some((Fragment.const(s"groupname"), fr"""${unsaved.groupname}::"public"."Name"""")),
      unsaved.departmentid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"departmentid"), fr"${value: DepartmentId}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.department default values
            returning departmentid, "name", groupname, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into humanresources.department(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning departmentid, "name", groupname, modifieddate
         """
    }
    q.query[DepartmentRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, DepartmentRow] = {
    sql"""select departmentid, "name", groupname, modifieddate from humanresources.department""".query[DepartmentRow].stream
  }
  override def selectByFieldValues(fieldValues: List[DepartmentFieldOrIdValue[_]]): Stream[ConnectionIO, DepartmentRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case DepartmentFieldValue.departmentid(value) => fr"departmentid = $value"
        case DepartmentFieldValue.name(value) => fr""""name" = $value"""
        case DepartmentFieldValue.groupname(value) => fr"groupname = $value"
        case DepartmentFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from humanresources.department $where".query[DepartmentRow].stream
  
  }
  override def selectById(departmentid: DepartmentId): ConnectionIO[Option[DepartmentRow]] = {
    sql"""select departmentid, "name", groupname, modifieddate from humanresources.department where departmentid = $departmentid""".query[DepartmentRow].option
  }
  override def selectByIds(departmentids: Array[DepartmentId]): Stream[ConnectionIO, DepartmentRow] = {
    sql"""select departmentid, "name", groupname, modifieddate from humanresources.department where departmentid = ANY($departmentids)""".query[DepartmentRow].stream
  }
  override def update(row: DepartmentRow): ConnectionIO[Boolean] = {
    val departmentid = row.departmentid
    sql"""update humanresources.department
          set "name" = ${row.name}::"public"."Name",
              groupname = ${row.groupname}::"public"."Name",
              modifieddate = ${row.modifieddate}::timestamp
          where departmentid = $departmentid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(departmentid: DepartmentId, fieldValues: List[DepartmentFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case DepartmentFieldValue.name(value) => fr""""name" = $value"""
            case DepartmentFieldValue.groupname(value) => fr"groupname = $value"
            case DepartmentFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update humanresources.department
              $updates
              where departmentid = $departmentid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: DepartmentRow): ConnectionIO[DepartmentRow] = {
    sql"""insert into humanresources.department(departmentid, "name", groupname, modifieddate)
          values (
            ${unsaved.departmentid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.groupname}::"public"."Name",
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (departmentid)
          do update set
            "name" = EXCLUDED."name",
            groupname = EXCLUDED.groupname,
            modifieddate = EXCLUDED.modifieddate
          returning departmentid, "name", groupname, modifieddate
       """.query[DepartmentRow].unique
  }
}
