/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salesterritory

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime
import java.util.UUID

object SalesterritoryRepoImpl extends SalesterritoryRepo {
  override def delete(territoryid: SalesterritoryId): ConnectionIO[Boolean] = {
    sql"delete from sales.salesterritory where territoryid = $territoryid".update.run.map(_ > 0)
  }
  override def insert(unsaved: SalesterritoryRow): ConnectionIO[SalesterritoryRow] = {
    sql"""insert into sales.salesterritory(territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate)
          values (${unsaved.territoryid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.countryregioncode}, ${unsaved.group}, ${unsaved.salesytd}::numeric, ${unsaved.saleslastyear}::numeric, ${unsaved.costytd}::numeric, ${unsaved.costlastyear}::numeric, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate
       """.query[SalesterritoryRow].unique
  }
  override def insert(unsaved: SalesterritoryRowUnsaved): ConnectionIO[SalesterritoryRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      Some((Fragment.const(s"countryregioncode"), fr"${unsaved.countryregioncode}")),
      Some((Fragment.const(s""""group""""), fr"${unsaved.group}")),
      unsaved.territoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"territoryid"), fr"${value: SalesterritoryId}::int4"))
      },
      unsaved.salesytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"salesytd"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.saleslastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"saleslastyear"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.costytd match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"costytd"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.costlastyear match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"costlastyear"), fr"${value: BigDecimal}::numeric"))
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
      sql"""insert into sales.salesterritory default values
            returning territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.salesterritory(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate
         """
    }
    q.query[SalesterritoryRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, SalesterritoryRow] = {
    sql"""select territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate from sales.salesterritory""".query[SalesterritoryRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SalesterritoryFieldOrIdValue[_]]): Stream[ConnectionIO, SalesterritoryRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SalesterritoryFieldValue.territoryid(value) => fr"territoryid = $value"
        case SalesterritoryFieldValue.name(value) => fr""""name" = $value"""
        case SalesterritoryFieldValue.countryregioncode(value) => fr"countryregioncode = $value"
        case SalesterritoryFieldValue.group(value) => fr""""group" = $value"""
        case SalesterritoryFieldValue.salesytd(value) => fr"salesytd = $value"
        case SalesterritoryFieldValue.saleslastyear(value) => fr"saleslastyear = $value"
        case SalesterritoryFieldValue.costytd(value) => fr"costytd = $value"
        case SalesterritoryFieldValue.costlastyear(value) => fr"costlastyear = $value"
        case SalesterritoryFieldValue.rowguid(value) => fr"rowguid = $value"
        case SalesterritoryFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sales.salesterritory $where".query[SalesterritoryRow].stream
  
  }
  override def selectById(territoryid: SalesterritoryId): ConnectionIO[Option[SalesterritoryRow]] = {
    sql"""select territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate from sales.salesterritory where territoryid = $territoryid""".query[SalesterritoryRow].option
  }
  override def selectByIds(territoryids: Array[SalesterritoryId]): Stream[ConnectionIO, SalesterritoryRow] = {
    sql"""select territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate from sales.salesterritory where territoryid = ANY($territoryids)""".query[SalesterritoryRow].stream
  }
  override def update(row: SalesterritoryRow): ConnectionIO[Boolean] = {
    val territoryid = row.territoryid
    sql"""update sales.salesterritory
          set "name" = ${row.name}::"public"."Name",
              countryregioncode = ${row.countryregioncode},
              "group" = ${row.group},
              salesytd = ${row.salesytd}::numeric,
              saleslastyear = ${row.saleslastyear}::numeric,
              costytd = ${row.costytd}::numeric,
              costlastyear = ${row.costlastyear}::numeric,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where territoryid = $territoryid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(territoryid: SalesterritoryId, fieldValues: List[SalesterritoryFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case SalesterritoryFieldValue.name(value) => fr""""name" = $value"""
            case SalesterritoryFieldValue.countryregioncode(value) => fr"countryregioncode = $value"
            case SalesterritoryFieldValue.group(value) => fr""""group" = $value"""
            case SalesterritoryFieldValue.salesytd(value) => fr"salesytd = $value"
            case SalesterritoryFieldValue.saleslastyear(value) => fr"saleslastyear = $value"
            case SalesterritoryFieldValue.costytd(value) => fr"costytd = $value"
            case SalesterritoryFieldValue.costlastyear(value) => fr"costlastyear = $value"
            case SalesterritoryFieldValue.rowguid(value) => fr"rowguid = $value"
            case SalesterritoryFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update sales.salesterritory
              $updates
              where territoryid = $territoryid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: SalesterritoryRow): ConnectionIO[SalesterritoryRow] = {
    sql"""insert into sales.salesterritory(territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate)
          values (
            ${unsaved.territoryid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.countryregioncode},
            ${unsaved.group},
            ${unsaved.salesytd}::numeric,
            ${unsaved.saleslastyear}::numeric,
            ${unsaved.costytd}::numeric,
            ${unsaved.costlastyear}::numeric,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (territoryid)
          do update set
            "name" = EXCLUDED."name",
            countryregioncode = EXCLUDED.countryregioncode,
            "group" = EXCLUDED."group",
            salesytd = EXCLUDED.salesytd,
            saleslastyear = EXCLUDED.saleslastyear,
            costytd = EXCLUDED.costytd,
            costlastyear = EXCLUDED.costlastyear,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning territoryid, "name", countryregioncode, "group", salesytd, saleslastyear, costytd, costlastyear, rowguid, modifieddate
       """.query[SalesterritoryRow].unique
  }
}
