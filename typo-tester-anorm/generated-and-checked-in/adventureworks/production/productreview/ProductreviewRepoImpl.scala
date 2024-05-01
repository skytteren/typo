/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productreview

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.production.product.ProductId
import adventureworks.public.Name
import adventureworks.streamingInsert
import anorm.NamedParameter
import anorm.ParameterMetaData
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

class ProductreviewRepoImpl extends ProductreviewRepo {
  override def delete: DeleteBuilder[ProductreviewFields, ProductreviewRow] = {
    DeleteBuilder("production.productreview", ProductreviewFields.structure)
  }
  override def deleteById(productreviewid: ProductreviewId)(implicit c: Connection): Boolean = {
    SQL"""delete from production.productreview where "productreviewid" = ${ParameterValue(productreviewid, null, ProductreviewId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(productreviewids: Array[ProductreviewId])(implicit c: Connection): Int = {
    SQL"""delete
          from production.productreview
          where "productreviewid" = ANY(${productreviewids})
       """.executeUpdate()
    
  }
  override def insert(unsaved: ProductreviewRow)(implicit c: Connection): ProductreviewRow = {
    SQL"""insert into production.productreview("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")
          values (${ParameterValue(unsaved.productreviewid, null, ProductreviewId.toStatement)}::int4, ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4, ${ParameterValue(unsaved.reviewername, null, Name.toStatement)}::varchar, ${ParameterValue(unsaved.reviewdate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.emailaddress, null, ToStatement.stringToStatement)}, ${ParameterValue(unsaved.rating, null, ToStatement.intToStatement)}::int4, ${ParameterValue(unsaved.comments, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
       """
      .executeInsert(ProductreviewRow.rowParser(1).single)
    
  }
  override def insert(unsaved: ProductreviewRowUnsaved)(implicit c: Connection): ProductreviewRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue(unsaved.productid, null, ProductId.toStatement)), "::int4")),
      Some((NamedParameter("reviewername", ParameterValue(unsaved.reviewername, null, Name.toStatement)), "::varchar")),
      Some((NamedParameter("emailaddress", ParameterValue(unsaved.emailaddress, null, ToStatement.stringToStatement)), "")),
      Some((NamedParameter("rating", ParameterValue(unsaved.rating, null, ToStatement.intToStatement)), "::int4")),
      Some((NamedParameter("comments", ParameterValue(unsaved.comments, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      unsaved.productreviewid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("productreviewid", ParameterValue(value, null, ProductreviewId.toStatement)), "::int4"))
      },
      unsaved.reviewdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("reviewdate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.productreview default values
            returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
         """
        .executeInsert(ProductreviewRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.productreview(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(ProductreviewRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[ProductreviewRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY production.productreview("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate") FROM STDIN""", batchSize, unsaved)(ProductreviewRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[ProductreviewRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY production.productreview("productid", "reviewername", "emailaddress", "rating", "comments", "productreviewid", "reviewdate", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(ProductreviewRowUnsaved.text, c)
  }
  override def select: SelectBuilder[ProductreviewFields, ProductreviewRow] = {
    SelectBuilderSql("production.productreview", ProductreviewFields.structure, ProductreviewRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[ProductreviewRow] = {
    SQL"""select "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
          from production.productreview
       """.as(ProductreviewRow.rowParser(1).*)
  }
  override def selectById(productreviewid: ProductreviewId)(implicit c: Connection): Option[ProductreviewRow] = {
    SQL"""select "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
          from production.productreview
          where "productreviewid" = ${ParameterValue(productreviewid, null, ProductreviewId.toStatement)}
       """.as(ProductreviewRow.rowParser(1).singleOpt)
  }
  override def selectByIds(productreviewids: Array[ProductreviewId])(implicit c: Connection): List[ProductreviewRow] = {
    SQL"""select "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
          from production.productreview
          where "productreviewid" = ANY(${productreviewids})
       """.as(ProductreviewRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(productreviewids: Array[ProductreviewId])(implicit c: Connection): Map[ProductreviewId, Option[ProductreviewRow]] = {
    val byId = selectByIds(productreviewids).view.map(x => (x.productreviewid, x)).toMap
    productreviewids.view.map(id => (id, byId.get(id))).toMap
  }
  override def update: UpdateBuilder[ProductreviewFields, ProductreviewRow] = {
    UpdateBuilder("production.productreview", ProductreviewFields.structure, ProductreviewRow.rowParser)
  }
  override def update(row: ProductreviewRow)(implicit c: Connection): Boolean = {
    val productreviewid = row.productreviewid
    SQL"""update production.productreview
          set "productid" = ${ParameterValue(row.productid, null, ProductId.toStatement)}::int4,
              "reviewername" = ${ParameterValue(row.reviewername, null, Name.toStatement)}::varchar,
              "reviewdate" = ${ParameterValue(row.reviewdate, null, TypoLocalDateTime.toStatement)}::timestamp,
              "emailaddress" = ${ParameterValue(row.emailaddress, null, ToStatement.stringToStatement)},
              "rating" = ${ParameterValue(row.rating, null, ToStatement.intToStatement)}::int4,
              "comments" = ${ParameterValue(row.comments, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "productreviewid" = ${ParameterValue(productreviewid, null, ProductreviewId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: ProductreviewRow)(implicit c: Connection): ProductreviewRow = {
    SQL"""insert into production.productreview("productreviewid", "productid", "reviewername", "reviewdate", "emailaddress", "rating", "comments", "modifieddate")
          values (
            ${ParameterValue(unsaved.productreviewid, null, ProductreviewId.toStatement)}::int4,
            ${ParameterValue(unsaved.productid, null, ProductId.toStatement)}::int4,
            ${ParameterValue(unsaved.reviewername, null, Name.toStatement)}::varchar,
            ${ParameterValue(unsaved.reviewdate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.emailaddress, null, ToStatement.stringToStatement)},
            ${ParameterValue(unsaved.rating, null, ToStatement.intToStatement)}::int4,
            ${ParameterValue(unsaved.comments, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("productreviewid")
          do update set
            "productid" = EXCLUDED."productid",
            "reviewername" = EXCLUDED."reviewername",
            "reviewdate" = EXCLUDED."reviewdate",
            "emailaddress" = EXCLUDED."emailaddress",
            "rating" = EXCLUDED."rating",
            "comments" = EXCLUDED."comments",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "productreviewid", "productid", "reviewername", "reviewdate"::text, "emailaddress", "rating", "comments", "modifieddate"::text
       """
      .executeInsert(ProductreviewRow.rowParser(1).single)
    
  }
}
