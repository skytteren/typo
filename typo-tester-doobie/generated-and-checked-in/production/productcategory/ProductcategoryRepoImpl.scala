/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcategory

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import fs2.Stream
import java.util.UUID

object ProductcategoryRepoImpl extends ProductcategoryRepo {
  override def delete(productcategoryid: ProductcategoryId): ConnectionIO[Boolean] = {
    sql"delete from production.productcategory where productcategoryid = ${productcategoryid}".update.run.map(_ > 0)
  }
  override def insert(unsaved: ProductcategoryRow): ConnectionIO[ProductcategoryRow] = {
    sql"""insert into production.productcategory(productcategoryid, "name", rowguid, modifieddate)
          values (${unsaved.productcategoryid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning productcategoryid, "name", rowguid, modifieddate::text
       """.query[ProductcategoryRow].unique
  }
  override def insert(unsaved: ProductcategoryRowUnsaved): ConnectionIO[ProductcategoryRow] = {
    val fs = List(
      Some((Fragment.const(s""""name""""), fr"""${unsaved.name}::"public"."Name"""")),
      unsaved.productcategoryid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"productcategoryid"), fr"${value: ProductcategoryId}::int4"))
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
      sql"""insert into production.productcategory default values
            returning productcategoryid, "name", rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into production.productcategory(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning productcategoryid, "name", rowguid, modifieddate::text
         """
    }
    q.query[ProductcategoryRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, ProductcategoryRow] = {
    sql"""select productcategoryid, "name", rowguid, modifieddate::text from production.productcategory""".query[ProductcategoryRow].stream
  }
  override def selectById(productcategoryid: ProductcategoryId): ConnectionIO[Option[ProductcategoryRow]] = {
    sql"""select productcategoryid, "name", rowguid, modifieddate::text from production.productcategory where productcategoryid = ${productcategoryid}""".query[ProductcategoryRow].option
  }
  override def selectByIds(productcategoryids: Array[ProductcategoryId]): Stream[ConnectionIO, ProductcategoryRow] = {
    sql"""select productcategoryid, "name", rowguid, modifieddate::text from production.productcategory where productcategoryid = ANY(${productcategoryids})""".query[ProductcategoryRow].stream
  }
  override def update(row: ProductcategoryRow): ConnectionIO[Boolean] = {
    val productcategoryid = row.productcategoryid
    sql"""update production.productcategory
          set "name" = ${row.name}::"public"."Name",
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where productcategoryid = ${productcategoryid}
       """
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductcategoryRow): ConnectionIO[ProductcategoryRow] = {
    sql"""insert into production.productcategory(productcategoryid, "name", rowguid, modifieddate)
          values (
            ${unsaved.productcategoryid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productcategoryid)
          do update set
            "name" = EXCLUDED."name",
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productcategoryid, "name", rowguid, modifieddate::text
       """.query[ProductcategoryRow].unique
  }
}
