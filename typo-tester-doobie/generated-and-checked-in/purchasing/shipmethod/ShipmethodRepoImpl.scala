/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime
import java.util.UUID

object ShipmethodRepoImpl extends ShipmethodRepo {
  override def delete(shipmethodid: ShipmethodId): ConnectionIO[Boolean] = {
    sql"delete from purchasing.shipmethod where shipmethodid = $shipmethodid".update.run.map(_ > 0)
  }
  override def insert(unsaved: ShipmethodRow): ConnectionIO[ShipmethodRow] = {
    sql"""insert into purchasing.shipmethod(shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate)
          values (${unsaved.shipmethodid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.shipbase}::numeric, ${unsaved.shiprate}::numeric, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
       """.query[ShipmethodRow].unique
  }
  override def insert(unsaved: ShipmethodRowUnsaved): ConnectionIO[ShipmethodRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      unsaved.shipmethodid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"shipmethodid"), fr"${value: ShipmethodId}::int4"))
      },
      unsaved.shipbase match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"shipbase"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.shiprate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"shiprate"), fr"${value: BigDecimal}::numeric"))
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
      sql"""insert into purchasing.shipmethod default values
            returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into purchasing.shipmethod(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
         """
    }
    q.query[ShipmethodRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, ShipmethodRow] = {
    sql"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate from purchasing.shipmethod""".query[ShipmethodRow].stream
  }
  override def selectByFieldValues(fieldValues: List[ShipmethodFieldOrIdValue[_]]): Stream[ConnectionIO, ShipmethodRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case ShipmethodFieldValue.shipmethodid(value) => fr"shipmethodid = $value"
        case ShipmethodFieldValue.name(value) => fr""""name" = $value"""
        case ShipmethodFieldValue.shipbase(value) => fr"shipbase = $value"
        case ShipmethodFieldValue.shiprate(value) => fr"shiprate = $value"
        case ShipmethodFieldValue.rowguid(value) => fr"rowguid = $value"
        case ShipmethodFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from purchasing.shipmethod $where".query[ShipmethodRow].stream
  
  }
  override def selectById(shipmethodid: ShipmethodId): ConnectionIO[Option[ShipmethodRow]] = {
    sql"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate from purchasing.shipmethod where shipmethodid = $shipmethodid""".query[ShipmethodRow].option
  }
  override def selectByIds(shipmethodids: Array[ShipmethodId]): Stream[ConnectionIO, ShipmethodRow] = {
    sql"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate from purchasing.shipmethod where shipmethodid = ANY($shipmethodids)""".query[ShipmethodRow].stream
  }
  override def update(row: ShipmethodRow): ConnectionIO[Boolean] = {
    val shipmethodid = row.shipmethodid
    sql"""update purchasing.shipmethod
          set "name" = ${row.name}::"public"."Name",
              shipbase = ${row.shipbase}::numeric,
              shiprate = ${row.shiprate}::numeric,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where shipmethodid = $shipmethodid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(shipmethodid: ShipmethodId, fieldValues: List[ShipmethodFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case ShipmethodFieldValue.name(value) => fr""""name" = $value"""
            case ShipmethodFieldValue.shipbase(value) => fr"shipbase = $value"
            case ShipmethodFieldValue.shiprate(value) => fr"shiprate = $value"
            case ShipmethodFieldValue.rowguid(value) => fr"rowguid = $value"
            case ShipmethodFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update purchasing.shipmethod
              $updates
              where shipmethodid = $shipmethodid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: ShipmethodRow): ConnectionIO[ShipmethodRow] = {
    sql"""insert into purchasing.shipmethod(shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate)
          values (
            ${unsaved.shipmethodid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.shipbase}::numeric,
            ${unsaved.shiprate}::numeric,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (shipmethodid)
          do update set
            "name" = EXCLUDED."name",
            shipbase = EXCLUDED.shipbase,
            shiprate = EXCLUDED.shiprate,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
       """.query[ShipmethodRow].unique
  }
}
