/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productlistpricehistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import anorm.BatchSql
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import scala.annotation.nowarn
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ProductlistpricehistoryRepoImpl extends ProductlistpricehistoryRepo {
  override def delete: DeleteBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = {
    DeleteBuilder("production.productlistpricehistory", ProductlistpricehistoryFields.structure)
  }
  override def deleteById(compositeId: ProductlistpricehistoryId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.productlistpricehistory where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDateTime.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[ProductlistpricehistoryId])(implicit c: Connection): Int = {
    val productid = compositeIds.map(_.productid)
    val startdate = compositeIds.map(_.startdate)
    SQL"""delete
          from production.productlistpricehistory
          where ("productid", "startdate")
          in (select unnest(${productid}), unnest(${startdate}))
       """.executeUpdate()
    
  }
  override def insert(unsaved: ProductlistpricehistoryRow)(implicit c: Connection): ProductlistpricehistoryRow = {
    SQL"""insert into production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate")
          values (${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4, ${ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.listprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
       """
      .executeInsert(ProductlistpricehistoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductlistpricehistoryRowUnsaved)(implicit c: Connection): ProductlistpricehistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue(unsaved.productid, null, ProductId.toStatement)), "::int4")),
      Some((NamedParameter("startdate", ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)), "::timestamp")),
      Some((NamedParameter("enddate", ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))), "::timestamp")),
      Some((NamedParameter("listprice", ParameterValue(unsaved.listprice, null, ToStatement.scalaBigDecimalToStatement)), "::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productlistpricehistory default values
            returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
         """
        .executeInsert(ProductlistpricehistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productlistpricehistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductlistpricehistoryRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[ProductlistpricehistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductlistpricehistoryRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductlistpricehistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductlistpricehistoryRowUnsaved.text, c)
  }
  override def select: SelectBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = {
    SelectBuilderSql("production.productlistpricehistory", ProductlistpricehistoryFields.structure, ProductlistpricehistoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductlistpricehistoryRow] = {
    SQL"""select "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
          from production.productlistpricehistory
       """.as(ProductlistpricehistoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: ProductlistpricehistoryId)(implicit c: Connection): Option[ProductlistpricehistoryRow] = {
    SQL"""select "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
          from production.productlistpricehistory
          where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDateTime.toStatement)}
       """.as(ProductlistpricehistoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[ProductlistpricehistoryId])(implicit c: Connection): List[ProductlistpricehistoryRow] = {
    val productid = compositeIds.map(_.productid)
    val startdate = compositeIds.map(_.startdate)
    SQL"""select "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
          from production.productlistpricehistory
          where ("productid", "startdate") 
          in (select unnest(${productid}), unnest(${startdate}))
       """.as(ProductlistpricehistoryRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(compositeIds: Array[ProductlistpricehistoryId])(implicit c: Connection): Map[ProductlistpricehistoryId, ProductlistpricehistoryRow] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
  }
  override def update: UpdateBuilder[ProductlistpricehistoryFields, ProductlistpricehistoryRow] = {
    UpdateBuilder("production.productlistpricehistory", ProductlistpricehistoryFields.structure, ProductlistpricehistoryRow.rowParser)
  }
  override def update(row: ProductlistpricehistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productlistpricehistory
          set "enddate" = ${ParameterValue(row.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
              "listprice" = ${ParameterValue(row.listprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDateTime.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: ProductlistpricehistoryRow)(implicit c: Connection): ProductlistpricehistoryRow = {
    SQL"""insert into production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate")
          values (
            ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4,
            ${ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
            ${ParameterValue(unsaved.listprice, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("productid", "startdate")
          do update set
            "enddate" = EXCLUDED."enddate",
            "listprice" = EXCLUDED."listprice",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
       """
      .executeInsert(ProductlistpricehistoryRow.rowParser(1).single)
    
  }
  override def upsertBatch(unsaved: Iterable[ProductlistpricehistoryRow])(implicit c: Connection): List[ProductlistpricehistoryRow] = {
    def toNamedParameter(row: ProductlistpricehistoryRow): List[NamedParameter] = List(
      NamedParameter("productid", ParameterValue(row.productid, null, ProductId.toStatement)),
      NamedParameter("startdate", ParameterValue(row.startdate, null, TypoLocalDateTime.toStatement)),
      NamedParameter("enddate", ParameterValue(row.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))),
      NamedParameter("listprice", ParameterValue(row.listprice, null, ToStatement.scalaBigDecimalToStatement)),
      NamedParameter("modifieddate", ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement))
    )
    unsaved.toList match {
      case Nil => Nil
      case head :: rest =>
        new anorm.adventureworks.ExecuteReturningSyntax.Ops(
          BatchSql(
            s"""insert into production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate")
                values ({productid}::int4, {startdate}::timestamp, {enddate}::timestamp, {listprice}::numeric, {modifieddate}::timestamp)
                on conflict ("productid", "startdate")
                do update set
                  "enddate" = EXCLUDED."enddate",
                  "listprice" = EXCLUDED."listprice",
                  "modifieddate" = EXCLUDED."modifieddate"
                returning "productid", "startdate"::text, "enddate"::text, "listprice", "modifieddate"::text
             """,
            toNamedParameter(head),
            rest.map(toNamedParameter)*
          )
        ).executeReturning(ProductlistpricehistoryRow.rowParser(1).*)
    }
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Iterator[ProductlistpricehistoryRow], batchSize: Int = 10000)(implicit c: Connection): Int = {
    SQL"create temporary table productlistpricehistory_TEMP (like production.productlistpricehistory) on commit drop".execute(): @nowarn
    streamingInsert(s"""copy productlistpricehistory_TEMP("productid", "startdate", "enddate", "listprice", "modifieddate") from stdin""", batchSize, unsaved)(ProductlistpricehistoryRow.text, c): @nowarn
    SQL"""insert into production.productlistpricehistory("productid", "startdate", "enddate", "listprice", "modifieddate")
          select * from productlistpricehistory_TEMP
          on conflict ("productid", "startdate")
          do update set
            "enddate" = EXCLUDED."enddate",
            "listprice" = EXCLUDED."listprice",
            "modifieddate" = EXCLUDED."modifieddate"
          ;
          drop table productlistpricehistory_TEMP;""".executeUpdate()
  }
}
