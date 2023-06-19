/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime
import java.util.UUID

object ProductmodelRepoImpl extends ProductmodelRepo {
  override def delete(productmodelid: ProductmodelId): ConnectionIO[Boolean] = {
    sql"delete from production.productmodel where productmodelid = $productmodelid".update.run.map(_ > 0)
  }
  override def insert(unsaved: ProductmodelRow): ConnectionIO[ProductmodelRow] = {
    sql"""insert into production.productmodel(productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate)
          values (${unsaved.productmodelid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.catalogdescription}::xml, ${unsaved.instructions}::xml, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
       """.query[ProductmodelRow].unique
  }
  override def insert(unsaved: ProductmodelRowUnsaved): ConnectionIO[ProductmodelRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      Some((Fragment.const(s"catalogdescription"), fr"${unsaved.catalogdescription}::xml")),
      Some((Fragment.const(s"instructions"), fr"${unsaved.instructions}::xml")),
      unsaved.productmodelid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"productmodelid"), fr"${value: ProductmodelId}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${value: UUID}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productmodel default values
            returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productmodel(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
         """
    }
    q.query[ProductmodelRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, ProductmodelRow] = {
    sql"""select productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate from production.productmodel""".query[ProductmodelRow].stream
  }
  override def selectByFieldValues(fieldValues: List[ProductmodelFieldOrIdValue[_]]): Stream[ConnectionIO, ProductmodelRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case ProductmodelFieldValue.productmodelid(value) => fr"productmodelid = $value"
        case ProductmodelFieldValue.name(value) => fr""""name" = $value"""
        case ProductmodelFieldValue.catalogdescription(value) => fr"catalogdescription = $value"
        case ProductmodelFieldValue.instructions(value) => fr"instructions = $value"
        case ProductmodelFieldValue.rowguid(value) => fr"rowguid = $value"
        case ProductmodelFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from production.productmodel $where".query[ProductmodelRow].stream
  
  }
  override def selectById(productmodelid: ProductmodelId): ConnectionIO[Option[ProductmodelRow]] = {
    sql"""select productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate from production.productmodel where productmodelid = $productmodelid""".query[ProductmodelRow].option
  }
  override def selectByIds(productmodelids: Array[ProductmodelId]): Stream[ConnectionIO, ProductmodelRow] = {
    sql"""select productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate from production.productmodel where productmodelid = ANY($productmodelids)""".query[ProductmodelRow].stream
  }
  override def update(row: ProductmodelRow): ConnectionIO[Boolean] = {
    val productmodelid = row.productmodelid
    sql"""update production.productmodel
          set "name" = ${row.name}::"public"."Name",
              catalogdescription = ${row.catalogdescription}::xml,
              instructions = ${row.instructions}::xml,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where productmodelid = $productmodelid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(productmodelid: ProductmodelId, fieldValues: List[ProductmodelFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case ProductmodelFieldValue.name(value) => fr""""name" = $value"""
            case ProductmodelFieldValue.catalogdescription(value) => fr"catalogdescription = $value"
            case ProductmodelFieldValue.instructions(value) => fr"instructions = $value"
            case ProductmodelFieldValue.rowguid(value) => fr"rowguid = $value"
            case ProductmodelFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update production.productmodel
              $updates
              where productmodelid = $productmodelid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: ProductmodelRow): ConnectionIO[ProductmodelRow] = {
    sql"""insert into production.productmodel(productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate)
          values (
            ${unsaved.productmodelid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.catalogdescription}::xml,
            ${unsaved.instructions}::xml,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productmodelid)
          do update set
            "name" = EXCLUDED."name",
            catalogdescription = EXCLUDED.catalogdescription,
            instructions = EXCLUDED.instructions,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
       """.query[ProductmodelRow].unique
  }
}
