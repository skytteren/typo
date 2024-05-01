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
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class ProductphotoRepoImpl extends ProductphotoRepo {
  override def delete: DeleteBuilder[ProductphotoFields, ProductphotoRow] = {
    DeleteBuilder("production.productphoto", ProductphotoFields.structure)
  }
  override def deleteById(productphotoid: ProductphotoId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.productphoto where "productphotoid" = ${Segment.paramSegment(productphotoid)(ProductphotoId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(productphotoids: Array[ProductphotoId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from production.productphoto where "productphotoid" = ANY(${productphotoids})""".delete
  }
  override def insert(unsaved: ProductphotoRow): ZIO[ZConnection, Throwable, ProductphotoRow] = {
    sql"""insert into production.productphoto("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate")
          values (${Segment.paramSegment(unsaved.productphotoid)(ProductphotoId.setter)}::int4, ${Segment.paramSegment(unsaved.thumbnailphoto)(Setter.optionParamSetter(TypoBytea.setter))}::bytea, ${Segment.paramSegment(unsaved.thumbnailphotofilename)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.largephoto)(Setter.optionParamSetter(TypoBytea.setter))}::bytea, ${Segment.paramSegment(unsaved.largephotofilename)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text
       """.insertReturning(using ProductphotoRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: ProductphotoRowUnsaved): ZIO[ZConnection, Throwable, ProductphotoRow] = {
    val fs = List(
      Some((sql""""thumbnailphoto"""", sql"${Segment.paramSegment(unsaved.thumbnailphoto)(Setter.optionParamSetter(TypoBytea.setter))}::bytea")),
      Some((sql""""thumbnailphotofilename"""", sql"${Segment.paramSegment(unsaved.thumbnailphotofilename)(Setter.optionParamSetter(Setter.stringSetter))}")),
      Some((sql""""largephoto"""", sql"${Segment.paramSegment(unsaved.largephoto)(Setter.optionParamSetter(TypoBytea.setter))}::bytea")),
      Some((sql""""largephotofilename"""", sql"${Segment.paramSegment(unsaved.largephotofilename)(Setter.optionParamSetter(Setter.stringSetter))}")),
      unsaved.productphotoid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""productphotoid"""", sql"${Segment.paramSegment(value: ProductphotoId)(ProductphotoId.setter)}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productphoto default values
            returning "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.productphoto($names) values ($values) returning "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text"""
    }
    q.insertReturning(using ProductphotoRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductphotoRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productphoto("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductphotoRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductphotoRowUnsaved], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productphoto("thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "productphotoid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductphotoRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductphotoFields, ProductphotoRow] = {
    SelectBuilderSql("production.productphoto", ProductphotoFields.structure, ProductphotoRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductphotoRow] = {
    sql"""select "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text from production.productphoto""".query(using ProductphotoRow.jdbcDecoder).selectStream()
  }
  override def selectById(productphotoid: ProductphotoId): ZIO[ZConnection, Throwable, Option[ProductphotoRow]] = {
    sql"""select "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text from production.productphoto where "productphotoid" = ${Segment.paramSegment(productphotoid)(ProductphotoId.setter)}""".query(using ProductphotoRow.jdbcDecoder).selectOne
  }
  override def selectByIds(productphotoids: Array[ProductphotoId]): ZStream[ZConnection, Throwable, ProductphotoRow] = {
    sql"""select "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text from production.productphoto where "productphotoid" = ANY(${Segment.paramSegment(productphotoids)(ProductphotoId.arraySetter)})""".query(using ProductphotoRow.jdbcDecoder).selectStream()
  }
  override def selectByIdsTracked(productphotoids: Array[ProductphotoId]): ZIO[ZConnection, Throwable, Map[ProductphotoId, Option[ProductphotoRow]]] = {
    selectByIds(productphotoids).runCollect.map { rows =>
      val byId = rows.view.map(x => (x.productphotoid, x)).toMap
      productphotoids.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[ProductphotoFields, ProductphotoRow] = {
    UpdateBuilder("production.productphoto", ProductphotoFields.structure, ProductphotoRow.jdbcDecoder)
  }
  override def update(row: ProductphotoRow): ZIO[ZConnection, Throwable, Boolean] = {
    val productphotoid = row.productphotoid
    sql"""update production.productphoto
          set "thumbnailphoto" = ${Segment.paramSegment(row.thumbnailphoto)(Setter.optionParamSetter(TypoBytea.setter))}::bytea,
              "thumbnailphotofilename" = ${Segment.paramSegment(row.thumbnailphotofilename)(Setter.optionParamSetter(Setter.stringSetter))},
              "largephoto" = ${Segment.paramSegment(row.largephoto)(Setter.optionParamSetter(TypoBytea.setter))}::bytea,
              "largephotofilename" = ${Segment.paramSegment(row.largephotofilename)(Setter.optionParamSetter(Setter.stringSetter))},
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productphotoid" = ${Segment.paramSegment(productphotoid)(ProductphotoId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: ProductphotoRow): ZIO[ZConnection, Throwable, UpdateResult[ProductphotoRow]] = {
    sql"""insert into production.productphoto("productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productphotoid)(ProductphotoId.setter)}::int4,
            ${Segment.paramSegment(unsaved.thumbnailphoto)(Setter.optionParamSetter(TypoBytea.setter))}::bytea,
            ${Segment.paramSegment(unsaved.thumbnailphotofilename)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.largephoto)(Setter.optionParamSetter(TypoBytea.setter))}::bytea,
            ${Segment.paramSegment(unsaved.largephotofilename)(Setter.optionParamSetter(Setter.stringSetter))},
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("productphotoid")
          do update set
            "thumbnailphoto" = EXCLUDED."thumbnailphoto",
            "thumbnailphotofilename" = EXCLUDED."thumbnailphotofilename",
            "largephoto" = EXCLUDED."largephoto",
            "largephotofilename" = EXCLUDED."largephotofilename",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productphotoid", "thumbnailphoto", "thumbnailphotofilename", "largephoto", "largephotofilename", "modifieddate"::text""".insertReturning(using ProductphotoRow.jdbcDecoder)
  }
}
