/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodelproductdescriptionculture

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime

object ProductmodelproductdescriptioncultureRepoImpl extends ProductmodelproductdescriptioncultureRepo {
  override def delete(compositeId: ProductmodelproductdescriptioncultureId): ConnectionIO[Boolean] = {
    sql"delete from production.productmodelproductdescriptionculture where productmodelid = ${compositeId.productmodelid} AND productdescriptionid = ${compositeId.productdescriptionid} AND cultureid = ${compositeId.cultureid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRow): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    sql"""insert into production.productmodelproductdescriptionculture(productmodelid, productdescriptionid, cultureid, modifieddate)
          values (${unsaved.productmodelid}::int4, ${unsaved.productdescriptionid}::int4, ${unsaved.cultureid}::bpchar, ${unsaved.modifieddate}::timestamp)
          returning productmodelid, productdescriptionid, cultureid, modifieddate
       """.query[ProductmodelproductdescriptioncultureRow].unique
  }
  override def insert(unsaved: ProductmodelproductdescriptioncultureRowUnsaved): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    val fs = List(
      Some((Fragment.const(s"productmodelid"), fr"${unsaved.productmodelid}::int4")),
      Some((Fragment.const(s"productdescriptionid"), fr"${unsaved.productdescriptionid}::int4")),
      Some((Fragment.const(s"cultureid"), fr"${unsaved.cultureid}::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productmodelproductdescriptionculture default values
            returning productmodelid, productdescriptionid, cultureid, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productmodelproductdescriptionculture(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productmodelid, productdescriptionid, cultureid, modifieddate
         """
    }
    q.query[ProductmodelproductdescriptioncultureRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, ProductmodelproductdescriptioncultureRow] = {
    sql"select productmodelid, productdescriptionid, cultureid, modifieddate from production.productmodelproductdescriptionculture".query[ProductmodelproductdescriptioncultureRow].stream
  }
  override def selectByFieldValues(fieldValues: List[ProductmodelproductdescriptioncultureFieldOrIdValue[_]]): Stream[ConnectionIO, ProductmodelproductdescriptioncultureRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case ProductmodelproductdescriptioncultureFieldValue.productmodelid(value) => fr"productmodelid = $value"
        case ProductmodelproductdescriptioncultureFieldValue.productdescriptionid(value) => fr"productdescriptionid = $value"
        case ProductmodelproductdescriptioncultureFieldValue.cultureid(value) => fr"cultureid = $value"
        case ProductmodelproductdescriptioncultureFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from production.productmodelproductdescriptionculture $where".query[ProductmodelproductdescriptioncultureRow].stream
  
  }
  override def selectById(compositeId: ProductmodelproductdescriptioncultureId): ConnectionIO[Option[ProductmodelproductdescriptioncultureRow]] = {
    sql"select productmodelid, productdescriptionid, cultureid, modifieddate from production.productmodelproductdescriptionculture where productmodelid = ${compositeId.productmodelid} AND productdescriptionid = ${compositeId.productdescriptionid} AND cultureid = ${compositeId.cultureid}".query[ProductmodelproductdescriptioncultureRow].option
  }
  override def update(row: ProductmodelproductdescriptioncultureRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.productmodelproductdescriptionculture
          set modifieddate = ${row.modifieddate}::timestamp
          where productmodelid = ${compositeId.productmodelid} AND productdescriptionid = ${compositeId.productdescriptionid} AND cultureid = ${compositeId.cultureid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(compositeId: ProductmodelproductdescriptioncultureId, fieldValues: List[ProductmodelproductdescriptioncultureFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case ProductmodelproductdescriptioncultureFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update production.productmodelproductdescriptionculture
              $updates
              where productmodelid = ${compositeId.productmodelid} AND productdescriptionid = ${compositeId.productdescriptionid} AND cultureid = ${compositeId.cultureid}
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: ProductmodelproductdescriptioncultureRow): ConnectionIO[ProductmodelproductdescriptioncultureRow] = {
    sql"""insert into production.productmodelproductdescriptionculture(productmodelid, productdescriptionid, cultureid, modifieddate)
          values (
            ${unsaved.productmodelid}::int4,
            ${unsaved.productdescriptionid}::int4,
            ${unsaved.cultureid}::bpchar,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productmodelid, productdescriptionid, cultureid)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning productmodelid, productdescriptionid, cultureid, modifieddate
       """.query[ProductmodelproductdescriptioncultureRow].unique
  }
}