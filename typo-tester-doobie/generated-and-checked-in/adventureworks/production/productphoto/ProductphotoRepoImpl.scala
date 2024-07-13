/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ProductphotoRepoImpl extends ProductphotoRepo {
  override def delete: DeleteBuilder[ProductphotoFields, ProductphotoRow] = {
    DeleteBuilder("production.productphoto", ProductphotoFields.structure)
  }
  override def deleteById(productphotoid: ProductphotoId): ConnectionIO[Boolean] = {
    sql"""delete from production.productphoto where "productphotoid" = ${fromWrite(productphotoid)(Write.fromPut(ProductphotoId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(productphotoids: Array[ProductphotoId]): ConnectionIO[Int] = {
    sql"""delete from production.productphoto where "productphotoid" = ANY(${productphotoids})""".update.run
  }
  override def insert(unsaved: ProductphotoRow): ConnectionIO[ProductphotoRow] = {
    sql"""insert into production.productphoto("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate")
          values (${fromWrite(unsaved.productphotoid)(Write.fromPut(ProductphotoId.put))}::int4, ${fromWrite(unsaved.thumbnailphoto)(Write.fromPutOption(TypoBytea.put))}::bytea, ${fromWrite(unsaved.thumbnailphotofilename)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.largephoto)(Write.fromPutOption(TypoBytea.put))}::bytea, ${fromWrite(unsaved.largephotofilename)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text
       """.query(using ProductphotoRow.read).unique
  }
  override def insert(unsaved: ProductphotoRowUnsaved): ConnectionIO[ProductphotoRow] = {
    val fs = List(
      Some((Fragment.const0(s""""thumbnailphoto""""), fr"${fromWrite(unsaved.thumbnailphoto)(Write.fromPutOption(TypoBytea.put))}::bytea")),
      Some((Fragment.const0(s""""thumbnailphotofilename""""), fr"${fromWrite(unsaved.thumbnailphotofilename)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""largephoto""""), fr"${fromWrite(unsaved.largephoto)(Write.fromPutOption(TypoBytea.put))}::bytea")),
      Some((Fragment.const0(s""""largephotofilename""""), fr"${fromWrite(unsaved.largephotofilename)(Write.fromPutOption(Meta.StringMeta.put))}")),
      unsaved.productphotoid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""productphotoid""""), fr"${fromWrite(value: ProductphotoId)(Write.fromPut(ProductphotoId.put))}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productphoto default values
            returning "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.productphoto(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text
         """
    }
    q.query(using ProductphotoRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, ProductphotoRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productphoto("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using ProductphotoRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, ProductphotoRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.productphoto("thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "productphotoid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using ProductphotoRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductphotoFields, ProductphotoRow] = {
    SelectBuilderSql("production.productphoto", ProductphotoFields.structure, ProductphotoRow.read)
  }
  override def selectAll: Stream[ConnectionIO, ProductphotoRow] = {
    sql"""select "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text from production.productphoto""".query(using ProductphotoRow.read).stream
  }
  override def selectById(productphotoid: ProductphotoId): ConnectionIO[Option[ProductphotoRow]] = {
    sql"""select "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text from production.productphoto where "productphotoid" = ${fromWrite(productphotoid)(Write.fromPut(ProductphotoId.put))}""".query(using ProductphotoRow.read).option
  }
  override def selectByIds(productphotoids: Array[ProductphotoId]): Stream[ConnectionIO, ProductphotoRow] = {
    sql"""select "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text from production.productphoto where "productphotoid" = ANY(${productphotoids})""".query(using ProductphotoRow.read).stream
  }
  override def selectByIdsTracked(productphotoids: Array[ProductphotoId]): ConnectionIO[Map[ProductphotoId, ProductphotoRow]] = {
    selectByIds(productphotoids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.productphotoid, x)).toMap
      productphotoids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[ProductphotoFields, ProductphotoRow] = {
    UpdateBuilder("production.productphoto", ProductphotoFields.structure, ProductphotoRow.read)
  }
  override def update(row: ProductphotoRow): ConnectionIO[Boolean] = {
    val productphotoid = row.productphotoid
    sql"""update production.productphoto
          set "thumbnailphoto" = ${fromWrite(row.thumbnailphoto)(Write.fromPutOption(TypoBytea.put))}::bytea,
              "thumbnailphotofilename" = ${fromWrite(row.thumbnailphotofilename)(Write.fromPutOption(Meta.StringMeta.put))},
              "largephoto" = ${fromWrite(row.largephoto)(Write.fromPutOption(TypoBytea.put))}::bytea,
              "largephotofilename" = ${fromWrite(row.largephotofilename)(Write.fromPutOption(Meta.StringMeta.put))},
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "productphotoid" = ${fromWrite(productphotoid)(Write.fromPut(ProductphotoId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: ProductphotoRow): ConnectionIO[ProductphotoRow] = {
    sql"""insert into production.productphoto("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate")
          values (
            ${fromWrite(unsaved.productphotoid)(Write.fromPut(ProductphotoId.put))}::int4,
            ${fromWrite(unsaved.thumbnailphoto)(Write.fromPutOption(TypoBytea.put))}::bytea,
            ${fromWrite(unsaved.thumbnailphotofilename)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.largephoto)(Write.fromPutOption(TypoBytea.put))}::bytea,
            ${fromWrite(unsaved.largephotofilename)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("productphotoid")
          do update set
            "thumbnailphoto" = EXCLUDED."thumbnailphoto",
            "thumbnailphotofilename" = EXCLUDED."thumbnailphotofilename",
            "largephoto" = EXCLUDED."largephoto",
            "largephotofilename" = EXCLUDED."largephotofilename",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text
       """.query(using ProductphotoRow.read).unique
  }
  override def upsertBatch(unsaved: List[ProductphotoRow]): Stream[ConnectionIO, ProductphotoRow] = {
    Update[ProductphotoRow](
      s"""insert into production.productphoto("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate")
          values (?::int4,?::bytea,?,?::bytea,?,?::timestamp)
          on conflict ("productphotoid")
          do update set
            "thumbnailphoto" = EXCLUDED."thumbnailphoto",
            "thumbnailphotofilename" = EXCLUDED."thumbnailphotofilename",
            "largephoto" = EXCLUDED."largephoto",
            "largephotofilename" = EXCLUDED."largephotofilename",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text"""
    )(using ProductphotoRow.write)
    .updateManyWithGeneratedKeys[ProductphotoRow]("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate")(unsaved)(using catsStdInstancesForList, ProductphotoRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, ProductphotoRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table productphoto_TEMP (like production.productphoto) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy productphoto_TEMP("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using ProductphotoRow.text)
      res <- sql"""insert into production.productphoto("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate")
                   select * from productphoto_TEMP
                   on conflict ("productphotoid")
                   do update set
                     "thumbnailphoto" = EXCLUDED."thumbnailphoto",
                     "thumbnailphotofilename" = EXCLUDED."thumbnailphotofilename",
                     "largephoto" = EXCLUDED."largephoto",
                     "largephotofilename" = EXCLUDED."largephotofilename",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table productphoto_TEMP;""".update.run
    } yield res
  }
}
