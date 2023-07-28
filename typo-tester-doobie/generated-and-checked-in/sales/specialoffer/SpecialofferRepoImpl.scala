/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package specialoffer

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime
import java.util.UUID

object SpecialofferRepoImpl extends SpecialofferRepo {
  override def delete(specialofferid: SpecialofferId): ConnectionIO[Boolean] = {
    sql"delete from sales.specialoffer where specialofferid = $specialofferid".update.run.map(_ > 0)
  }
  override def insert(unsaved: SpecialofferRow): ConnectionIO[SpecialofferRow] = {
    sql"""insert into sales.specialoffer(specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate)
          values (${unsaved.specialofferid}::int4, ${unsaved.description}, ${unsaved.discountpct}::numeric, ${unsaved.`type`}, ${unsaved.category}, ${unsaved.startdate}::timestamp, ${unsaved.enddate}::timestamp, ${unsaved.minqty}::int4, ${unsaved.maxqty}::int4, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate
       """.query[SpecialofferRow].unique
  }
  override def insert(unsaved: SpecialofferRowUnsaved): ConnectionIO[SpecialofferRow] = {
    val fs = List(
      Some((Fragment.const(s"description"), fr"${unsaved.description}")),
      Some((Fragment.const(s""""type""""), fr"${unsaved.`type`}")),
      Some((Fragment.const(s"category"), fr"${unsaved.category}")),
      Some((Fragment.const(s"startdate"), fr"${unsaved.startdate}::timestamp")),
      Some((Fragment.const(s"enddate"), fr"${unsaved.enddate}::timestamp")),
      Some((Fragment.const(s"maxqty"), fr"${unsaved.maxqty}::int4")),
      unsaved.specialofferid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"specialofferid"), fr"${value: SpecialofferId}::int4"))
      },
      unsaved.discountpct match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"discountpct"), fr"${value: BigDecimal}::numeric"))
      },
      unsaved.minqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"minqty"), fr"${value: Int}::int4"))
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
      sql"""insert into sales.specialoffer default values
            returning specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.specialoffer(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate
         """
    }
    q.query[SpecialofferRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, SpecialofferRow] = {
    sql"""select specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate from sales.specialoffer""".query[SpecialofferRow].stream
  }
  override def selectByFieldValues(fieldValues: List[SpecialofferFieldOrIdValue[_]]): Stream[ConnectionIO, SpecialofferRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case SpecialofferFieldValue.specialofferid(value) => fr"specialofferid = $value"
        case SpecialofferFieldValue.description(value) => fr"description = $value"
        case SpecialofferFieldValue.discountpct(value) => fr"discountpct = $value"
        case SpecialofferFieldValue.`type`(value) => fr""""type" = $value"""
        case SpecialofferFieldValue.category(value) => fr"category = $value"
        case SpecialofferFieldValue.startdate(value) => fr"startdate = $value"
        case SpecialofferFieldValue.enddate(value) => fr"enddate = $value"
        case SpecialofferFieldValue.minqty(value) => fr"minqty = $value"
        case SpecialofferFieldValue.maxqty(value) => fr"maxqty = $value"
        case SpecialofferFieldValue.rowguid(value) => fr"rowguid = $value"
        case SpecialofferFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sales.specialoffer $where".query[SpecialofferRow].stream
  
  }
  override def selectById(specialofferid: SpecialofferId): ConnectionIO[Option[SpecialofferRow]] = {
    sql"""select specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate from sales.specialoffer where specialofferid = $specialofferid""".query[SpecialofferRow].option
  }
  override def selectByIds(specialofferids: Array[SpecialofferId]): Stream[ConnectionIO, SpecialofferRow] = {
    sql"""select specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate from sales.specialoffer where specialofferid = ANY($specialofferids)""".query[SpecialofferRow].stream
  }
  override def update(row: SpecialofferRow): ConnectionIO[Boolean] = {
    val specialofferid = row.specialofferid
    sql"""update sales.specialoffer
          set description = ${row.description},
              discountpct = ${row.discountpct}::numeric,
              "type" = ${row.`type`},
              category = ${row.category},
              startdate = ${row.startdate}::timestamp,
              enddate = ${row.enddate}::timestamp,
              minqty = ${row.minqty}::int4,
              maxqty = ${row.maxqty}::int4,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where specialofferid = $specialofferid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(specialofferid: SpecialofferId, fieldValues: List[SpecialofferFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case SpecialofferFieldValue.description(value) => fr"description = $value"
            case SpecialofferFieldValue.discountpct(value) => fr"discountpct = $value"
            case SpecialofferFieldValue.`type`(value) => fr""""type" = $value"""
            case SpecialofferFieldValue.category(value) => fr"category = $value"
            case SpecialofferFieldValue.startdate(value) => fr"startdate = $value"
            case SpecialofferFieldValue.enddate(value) => fr"enddate = $value"
            case SpecialofferFieldValue.minqty(value) => fr"minqty = $value"
            case SpecialofferFieldValue.maxqty(value) => fr"maxqty = $value"
            case SpecialofferFieldValue.rowguid(value) => fr"rowguid = $value"
            case SpecialofferFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update sales.specialoffer
              $updates
              where specialofferid = $specialofferid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: SpecialofferRow): ConnectionIO[SpecialofferRow] = {
    sql"""insert into sales.specialoffer(specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate)
          values (
            ${unsaved.specialofferid}::int4,
            ${unsaved.description},
            ${unsaved.discountpct}::numeric,
            ${unsaved.`type`},
            ${unsaved.category},
            ${unsaved.startdate}::timestamp,
            ${unsaved.enddate}::timestamp,
            ${unsaved.minqty}::int4,
            ${unsaved.maxqty}::int4,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (specialofferid)
          do update set
            description = EXCLUDED.description,
            discountpct = EXCLUDED.discountpct,
            "type" = EXCLUDED."type",
            category = EXCLUDED.category,
            startdate = EXCLUDED.startdate,
            enddate = EXCLUDED.enddate,
            minqty = EXCLUDED.minqty,
            maxqty = EXCLUDED.maxqty,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning specialofferid, description, discountpct, "type", category, startdate, enddate, minqty, maxqty, rowguid, modifieddate
       """.query[SpecialofferRow].unique
  }
}