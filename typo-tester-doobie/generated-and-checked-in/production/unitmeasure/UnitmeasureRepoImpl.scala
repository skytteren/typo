/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package unitmeasure

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime

object UnitmeasureRepoImpl extends UnitmeasureRepo {
  override def delete(unitmeasurecode: UnitmeasureId): ConnectionIO[Boolean] = {
    sql"delete from production.unitmeasure where unitmeasurecode = $unitmeasurecode".update.run.map(_ > 0)
  }
  override def insert(unsaved: UnitmeasureRow): ConnectionIO[UnitmeasureRow] = {
    sql"""insert into production.unitmeasure(unitmeasurecode, "name", modifieddate)
          values (${unsaved.unitmeasurecode}::bpchar, ${unsaved.name}::"public"."Name", ${unsaved.modifieddate}::timestamp)
          returning unitmeasurecode, "name", modifieddate
       """.query[UnitmeasureRow].unique
  }
  override def insert(unsaved: UnitmeasureRowUnsaved): ConnectionIO[UnitmeasureRow] = {
    val fs = List(
      Some((Fragment.const(s"unitmeasurecode"), fr"${unsaved.unitmeasurecode}::bpchar")),
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.unitmeasure default values
            returning unitmeasurecode, "name", modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.unitmeasure(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning unitmeasurecode, "name", modifieddate
         """
    }
    q.query[UnitmeasureRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, UnitmeasureRow] = {
    sql"""select unitmeasurecode, "name", modifieddate from production.unitmeasure""".query[UnitmeasureRow].stream
  }
  override def selectByFieldValues(fieldValues: List[UnitmeasureFieldOrIdValue[_]]): Stream[ConnectionIO, UnitmeasureRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case UnitmeasureFieldValue.unitmeasurecode(value) => fr"unitmeasurecode = $value"
        case UnitmeasureFieldValue.name(value) => fr""""name" = $value"""
        case UnitmeasureFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from production.unitmeasure $where".query[UnitmeasureRow].stream
  
  }
  override def selectById(unitmeasurecode: UnitmeasureId): ConnectionIO[Option[UnitmeasureRow]] = {
    sql"""select unitmeasurecode, "name", modifieddate from production.unitmeasure where unitmeasurecode = $unitmeasurecode""".query[UnitmeasureRow].option
  }
  override def selectByIds(unitmeasurecodes: Array[UnitmeasureId]): Stream[ConnectionIO, UnitmeasureRow] = {
    sql"""select unitmeasurecode, "name", modifieddate from production.unitmeasure where unitmeasurecode = ANY($unitmeasurecodes)""".query[UnitmeasureRow].stream
  }
  override def update(row: UnitmeasureRow): ConnectionIO[Boolean] = {
    val unitmeasurecode = row.unitmeasurecode
    sql"""update production.unitmeasure
          set "name" = ${row.name}::"public"."Name",
              modifieddate = ${row.modifieddate}::timestamp
          where unitmeasurecode = $unitmeasurecode
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(unitmeasurecode: UnitmeasureId, fieldValues: List[UnitmeasureFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case UnitmeasureFieldValue.name(value) => fr""""name" = $value"""
            case UnitmeasureFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update production.unitmeasure
              $updates
              where unitmeasurecode = $unitmeasurecode
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: UnitmeasureRow): ConnectionIO[UnitmeasureRow] = {
    sql"""insert into production.unitmeasure(unitmeasurecode, "name", modifieddate)
          values (
            ${unsaved.unitmeasurecode}::bpchar,
            ${unsaved.name}::"public"."Name",
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (unitmeasurecode)
          do update set
            "name" = EXCLUDED."name",
            modifieddate = EXCLUDED.modifieddate
          returning unitmeasurecode, "name", modifieddate
       """.query[UnitmeasureRow].unique
  }
}
