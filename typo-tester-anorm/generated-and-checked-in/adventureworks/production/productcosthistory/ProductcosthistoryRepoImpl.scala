/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productcosthistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.streamingInsert
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class ProductcosthistoryRepoImpl extends ProductcosthistoryRepo {
  override def delete: DeleteBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    DeleteBuilder("production.productcosthistory", ProductcosthistoryFields.structure)
  }
  override def deleteById(compositeId: ProductcosthistoryId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.productcosthistory where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDateTime.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[ProductcosthistoryId])(implicit c: Connection): Int = {
    val productid = compositeIds.map(_.productid)
    val startdate = compositeIds.map(_.startdate)
    SQL"""delete
          from production.productcosthistory
          where ("productid", "startdate")
          in (select unnest(${productid}), unnest(${startdate}))
       """.executeUpdate()
    
  }
  override def insert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow = {
    SQL"""insert into production.productcosthistory("productid", "startdate", "enddate", "standardcost", "modifieddate")
          values (${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4, ${ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.standardcost, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
       """
      .executeInsert(ProductcosthistoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductcosthistoryRowUnsaved)(implicit c: Connection): ProductcosthistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue(unsaved.productid, null, ProductId.toStatement)), "::int4")),
      Some((NamedParameter("startdate", ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)), "::timestamp")),
      Some((NamedParameter("enddate", ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))), "::timestamp")),
      Some((NamedParameter("standardcost", ParameterValue(unsaved.standardcost, null, ToStatement.scalaBigDecimalToStatement)), "::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productcosthistory default values
            returning "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
         """
        .executeInsert(ProductcosthistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productcosthistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductcosthistoryRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[ProductcosthistoryRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY production.productcosthistory("productid", "startdate", "enddate", "standardcost", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductcosthistoryRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductcosthistoryRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY production.productcosthistory("productid", "startdate", "enddate", "standardcost", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductcosthistoryRowUnsaved.text, c)
  }
  override def select: SelectBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    SelectBuilderSql("production.productcosthistory", ProductcosthistoryFields.structure, ProductcosthistoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductcosthistoryRow] = {
    SQL"""select "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
          from production.productcosthistory
       """.as(ProductcosthistoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: ProductcosthistoryId)(implicit c: Connection): Option[ProductcosthistoryRow] = {
    SQL"""select "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
          from production.productcosthistory
          where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDateTime.toStatement)}
       """.as(ProductcosthistoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[ProductcosthistoryId])(implicit c: Connection): List[ProductcosthistoryRow] = {
    val productid = compositeIds.map(_.productid)
    val startdate = compositeIds.map(_.startdate)
    SQL"""select "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
          from production.productcosthistory
          where ("productid", "startdate") 
          in (select unnest(${productid}), unnest(${startdate}))
       """.as(ProductcosthistoryRow.rowParser(1).*)
    
  }
  override def update: UpdateBuilder[ProductcosthistoryFields, ProductcosthistoryRow] = {
    UpdateBuilder("production.productcosthistory", ProductcosthistoryFields.structure, ProductcosthistoryRow.rowParser)
  }
  override def update(row: ProductcosthistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productcosthistory
          set "enddate" = ${ParameterValue(row.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
              "standardcost" = ${ParameterValue(row.standardcost, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "productid" = ${ParameterValue(compositeId.productid, null, ProductId.toStatement)} AND "startdate" = ${ParameterValue(compositeId.startdate, null, TypoLocalDateTime.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: ProductcosthistoryRow)(implicit c: Connection): ProductcosthistoryRow = {
    SQL"""insert into production.productcosthistory("productid", "startdate", "enddate", "standardcost", "modifieddate")
          values (
            ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4,
            ${ParameterValue(unsaved.startdate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.enddate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
            ${ParameterValue(unsaved.standardcost, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("productid", "startdate")
          do update set
            "enddate" = EXCLUDED."enddate",
            "standardcost" = EXCLUDED."standardcost",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productid", "startdate"::text, "enddate"::text, "standardcost", "modifieddate"::text
       """
      .executeInsert(ProductcosthistoryRow.rowParser(1).single)
    
  }
}
