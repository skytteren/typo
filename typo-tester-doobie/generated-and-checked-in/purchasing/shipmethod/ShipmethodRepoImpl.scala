/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package shipmethod

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.util.UUID

object ShipmethodRepoImpl extends ShipmethodRepo {
  override def delete(shipmethodid: ShipmethodId): ConnectionIO[Boolean] = {
    sql"delete from purchasing.shipmethod where shipmethodid = ${shipmethodid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ShipmethodRow): ConnectionIO[ShipmethodRow] = {
    sql"""insert into purchasing.shipmethod(shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate)
          values (${unsaved.shipmethodid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.shipbase}::numeric, ${unsaved.shiprate}::numeric, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
       """.query(ShipmethodRow.read).unique
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
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: TypoLocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into purchasing.shipmethod default values
            returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into purchasing.shipmethod(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
         """
    }
    q.query(ShipmethodRow.read).unique
  
  }
  override def selectAll: Stream[ConnectionIO, ShipmethodRow] = {
    sql"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text from purchasing.shipmethod""".query(ShipmethodRow.read).stream
  }
  override def selectById(shipmethodid: ShipmethodId): ConnectionIO[Option[ShipmethodRow]] = {
    sql"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text from purchasing.shipmethod where shipmethodid = ${shipmethodid}""".query(ShipmethodRow.read).option
  }
  override def selectByIds(shipmethodids: Array[ShipmethodId]): Stream[ConnectionIO, ShipmethodRow] = {
    sql"""select shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text from purchasing.shipmethod where shipmethodid = ANY(${shipmethodids})""".query(ShipmethodRow.read).stream
  }
  override def update(row: ShipmethodRow): ConnectionIO[Boolean] = {
    val shipmethodid = row.shipmethodid
    sql"""update purchasing.shipmethod
          set "name" = ${row.name}::"public"."Name",
              shipbase = ${row.shipbase}::numeric,
              shiprate = ${row.shiprate}::numeric,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where shipmethodid = ${shipmethodid}
       """
      .update
      .run
      .map(_ > 0)
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
          returning shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate::text
       """.query(ShipmethodRow.read).unique
  }
}
