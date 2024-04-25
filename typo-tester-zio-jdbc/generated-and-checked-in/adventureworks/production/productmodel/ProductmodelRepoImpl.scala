/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.public.Name
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

class ProductmodelRepoImpl extends ProductmodelRepo {
  override def delete: DeleteBuilder[ProductmodelFields, ProductmodelRow] = {
    DeleteBuilder("production.productmodel", ProductmodelFields.structure)
  }
  override def deleteById(productmodelid: ProductmodelId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.productmodel where "productmodelid" = ${Segment.paramSegment(productmodelid)(ProductmodelId.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(productmodelids: Array[ProductmodelId]): ZIO[ZConnection, Throwable, Long] = {
    sql"""delete from production.productmodel where "productmodelid" = ANY(${productmodelids})""".delete
  }
  override def insert(unsaved: ProductmodelRow): ZIO[ZConnection, Throwable, ProductmodelRow] = {
    sql"""insert into production.productmodel("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")
          values (${Segment.paramSegment(unsaved.productmodelid)(ProductmodelId.setter)}::int4, ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar, ${Segment.paramSegment(unsaved.catalogdescription)(Setter.optionParamSetter(TypoXml.setter))}::xml, ${Segment.paramSegment(unsaved.instructions)(Setter.optionParamSetter(TypoXml.setter))}::xml, ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
       """.insertReturning(using ProductmodelRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: ProductmodelRowUnsaved): ZIO[ZConnection, Throwable, ProductmodelRow] = {
    val fs = List(
      Some((sql""""name"""", sql"${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar")),
      Some((sql""""catalogdescription"""", sql"${Segment.paramSegment(unsaved.catalogdescription)(Setter.optionParamSetter(TypoXml.setter))}::xml")),
      Some((sql""""instructions"""", sql"${Segment.paramSegment(unsaved.instructions)(Setter.optionParamSetter(TypoXml.setter))}::xml")),
      unsaved.productmodelid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""productmodelid"""", sql"${Segment.paramSegment(value: ProductmodelId)(ProductmodelId.setter)}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""rowguid"""", sql"${Segment.paramSegment(value: TypoUUID)(TypoUUID.setter)}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.productmodel default values
            returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.productmodel($names) values ($values) returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text"""
    }
    q.insertReturning(using ProductmodelRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productmodel("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductmodelRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, ProductmodelRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.productmodel("name", "catalogdescription", "instructions", "productmodelid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductmodelRowUnsaved.text)
  }
  override def select: SelectBuilder[ProductmodelFields, ProductmodelRow] = {
    SelectBuilderSql("production.productmodel", ProductmodelFields.structure, ProductmodelRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, ProductmodelRow] = {
    sql"""select "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text from production.productmodel""".query(using ProductmodelRow.jdbcDecoder).selectStream()
  }
  override def selectById(productmodelid: ProductmodelId): ZIO[ZConnection, Throwable, Option[ProductmodelRow]] = {
    sql"""select "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text from production.productmodel where "productmodelid" = ${Segment.paramSegment(productmodelid)(ProductmodelId.setter)}""".query(using ProductmodelRow.jdbcDecoder).selectOne
  }
  override def selectByIds(productmodelids: Array[ProductmodelId]): ZStream[ZConnection, Throwable, ProductmodelRow] = {
    sql"""select "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text from production.productmodel where "productmodelid" = ANY(${Segment.paramSegment(productmodelids)(ProductmodelId.arraySetter)})""".query(using ProductmodelRow.jdbcDecoder).selectStream()
  }
  override def update: UpdateBuilder[ProductmodelFields, ProductmodelRow] = {
    UpdateBuilder("production.productmodel", ProductmodelFields.structure, ProductmodelRow.jdbcDecoder)
  }
  override def update(row: ProductmodelRow): ZIO[ZConnection, Throwable, Boolean] = {
    val productmodelid = row.productmodelid
    sql"""update production.productmodel
          set "name" = ${Segment.paramSegment(row.name)(Name.setter)}::varchar,
              "catalogdescription" = ${Segment.paramSegment(row.catalogdescription)(Setter.optionParamSetter(TypoXml.setter))}::xml,
              "instructions" = ${Segment.paramSegment(row.instructions)(Setter.optionParamSetter(TypoXml.setter))}::xml,
              "rowguid" = ${Segment.paramSegment(row.rowguid)(TypoUUID.setter)}::uuid,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "productmodelid" = ${Segment.paramSegment(productmodelid)(ProductmodelId.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: ProductmodelRow): ZIO[ZConnection, Throwable, UpdateResult[ProductmodelRow]] = {
    sql"""insert into production.productmodel("productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.productmodelid)(ProductmodelId.setter)}::int4,
            ${Segment.paramSegment(unsaved.name)(Name.setter)}::varchar,
            ${Segment.paramSegment(unsaved.catalogdescription)(Setter.optionParamSetter(TypoXml.setter))}::xml,
            ${Segment.paramSegment(unsaved.instructions)(Setter.optionParamSetter(TypoXml.setter))}::xml,
            ${Segment.paramSegment(unsaved.rowguid)(TypoUUID.setter)}::uuid,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("productmodelid")
          do update set
            "name" = EXCLUDED."name",
            "catalogdescription" = EXCLUDED."catalogdescription",
            "instructions" = EXCLUDED."instructions",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productmodelid", "name", "catalogdescription", "instructions", "rowguid", "modifieddate"::text""".insertReturning(using ProductmodelRow.jdbcDecoder)
  }
}
