/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package shoppingcartitem

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime

object ShoppingcartitemRepoImpl extends ShoppingcartitemRepo {
  override def delete(shoppingcartitemid: ShoppingcartitemId): ConnectionIO[Boolean] = {
    sql"delete from sales.shoppingcartitem where shoppingcartitemid = $shoppingcartitemid".update.run.map(_ > 0)
  }
  override def insert(unsaved: ShoppingcartitemRow): ConnectionIO[ShoppingcartitemRow] = {
    sql"""insert into sales.shoppingcartitem(shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate)
          values (${unsaved.shoppingcartitemid}::int4, ${unsaved.shoppingcartid}, ${unsaved.quantity}::int4, ${unsaved.productid}::int4, ${unsaved.datecreated}::timestamp, ${unsaved.modifieddate}::timestamp)
          returning shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate
       """.query[ShoppingcartitemRow].unique
  }
  override def insert(unsaved: ShoppingcartitemRowUnsaved): ConnectionIO[ShoppingcartitemRow] = {
    val fs = List(
      Some((Fragment.const(s"shoppingcartid"), fr"${unsaved.shoppingcartid}")),
      Some((Fragment.const(s"productid"), fr"${unsaved.productid}::int4")),
      unsaved.shoppingcartitemid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"shoppingcartitemid"), fr"${value: ShoppingcartitemId}::int4"))
      },
      unsaved.quantity match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"quantity"), fr"${value: Int}::int4"))
      },
      unsaved.datecreated match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"datecreated"), fr"${value: LocalDateTime}::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.shoppingcartitem default values
            returning shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.shoppingcartitem(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate
         """
    }
    q.query[ShoppingcartitemRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, ShoppingcartitemRow] = {
    sql"select shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate from sales.shoppingcartitem".query[ShoppingcartitemRow].stream
  }
  override def selectByFieldValues(fieldValues: List[ShoppingcartitemFieldOrIdValue[_]]): Stream[ConnectionIO, ShoppingcartitemRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case ShoppingcartitemFieldValue.shoppingcartitemid(value) => fr"shoppingcartitemid = $value"
        case ShoppingcartitemFieldValue.shoppingcartid(value) => fr"shoppingcartid = $value"
        case ShoppingcartitemFieldValue.quantity(value) => fr"quantity = $value"
        case ShoppingcartitemFieldValue.productid(value) => fr"productid = $value"
        case ShoppingcartitemFieldValue.datecreated(value) => fr"datecreated = $value"
        case ShoppingcartitemFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sales.shoppingcartitem $where".query[ShoppingcartitemRow].stream
  
  }
  override def selectById(shoppingcartitemid: ShoppingcartitemId): ConnectionIO[Option[ShoppingcartitemRow]] = {
    sql"select shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate from sales.shoppingcartitem where shoppingcartitemid = $shoppingcartitemid".query[ShoppingcartitemRow].option
  }
  override def selectByIds(shoppingcartitemids: Array[ShoppingcartitemId]): Stream[ConnectionIO, ShoppingcartitemRow] = {
    sql"select shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate from sales.shoppingcartitem where shoppingcartitemid = ANY($shoppingcartitemids)".query[ShoppingcartitemRow].stream
  }
  override def update(row: ShoppingcartitemRow): ConnectionIO[Boolean] = {
    val shoppingcartitemid = row.shoppingcartitemid
    sql"""update sales.shoppingcartitem
          set shoppingcartid = ${row.shoppingcartid},
              quantity = ${row.quantity}::int4,
              productid = ${row.productid}::int4,
              datecreated = ${row.datecreated}::timestamp,
              modifieddate = ${row.modifieddate}::timestamp
          where shoppingcartitemid = $shoppingcartitemid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(shoppingcartitemid: ShoppingcartitemId, fieldValues: List[ShoppingcartitemFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case ShoppingcartitemFieldValue.shoppingcartid(value) => fr"shoppingcartid = $value"
            case ShoppingcartitemFieldValue.quantity(value) => fr"quantity = $value"
            case ShoppingcartitemFieldValue.productid(value) => fr"productid = $value"
            case ShoppingcartitemFieldValue.datecreated(value) => fr"datecreated = $value"
            case ShoppingcartitemFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update sales.shoppingcartitem
              $updates
              where shoppingcartitemid = $shoppingcartitemid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: ShoppingcartitemRow): ConnectionIO[ShoppingcartitemRow] = {
    sql"""insert into sales.shoppingcartitem(shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate)
          values (
            ${unsaved.shoppingcartitemid}::int4,
            ${unsaved.shoppingcartid},
            ${unsaved.quantity}::int4,
            ${unsaved.productid}::int4,
            ${unsaved.datecreated}::timestamp,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (shoppingcartitemid)
          do update set
            shoppingcartid = EXCLUDED.shoppingcartid,
            quantity = EXCLUDED.quantity,
            productid = EXCLUDED.productid,
            datecreated = EXCLUDED.datecreated,
            modifieddate = EXCLUDED.modifieddate
          returning shoppingcartitemid, shoppingcartid, quantity, productid, datecreated, modifieddate
       """.query[ShoppingcartitemRow].unique
  }
}