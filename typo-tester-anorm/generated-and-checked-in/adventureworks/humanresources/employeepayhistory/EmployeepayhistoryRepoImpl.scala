/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package employeepayhistory

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
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

class EmployeepayhistoryRepoImpl extends EmployeepayhistoryRepo {
  override def delete: DeleteBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    DeleteBuilder("humanresources.employeepayhistory", EmployeepayhistoryFields.structure)
  }
  override def deleteById(compositeId: EmployeepayhistoryId)(implicit c: Connection): Boolean = {
    SQL"""delete from humanresources.employeepayhistory where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "ratechangedate" = ${ParameterValue(compositeId.ratechangedate, null, TypoLocalDateTime.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[EmployeepayhistoryId])(implicit c: Connection): Int = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val ratechangedate = compositeIds.map(_.ratechangedate)
    SQL"""delete
          from humanresources.employeepayhistory
          where ("businessentityid", "ratechangedate")
          in (select unnest(${businessentityid}), unnest(${ratechangedate}))
       """.executeUpdate()
    
  }
  override def insert(unsaved: EmployeepayhistoryRow)(implicit c: Connection): EmployeepayhistoryRow = {
    SQL"""insert into humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate")
          values (${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.ratechangedate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.rate, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.payfrequency, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
       """
      .executeInsert(EmployeepayhistoryRow.rowParser(1).single)
    
  }
  override def insert(unsaved: EmployeepayhistoryRowUnsaved)(implicit c: Connection): EmployeepayhistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("ratechangedate", ParameterValue(unsaved.ratechangedate, null, TypoLocalDateTime.toStatement)), "::timestamp")),
      Some((NamedParameter("rate", ParameterValue(unsaved.rate, null, ToStatement.scalaBigDecimalToStatement)), "::numeric")),
      Some((NamedParameter("payfrequency", ParameterValue(unsaved.payfrequency, null, TypoShort.toStatement)), "::int2")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into humanresources.employeepayhistory default values
            returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
         """
        .executeInsert(EmployeepayhistoryRow.rowParser(1).single)
    } else {
      val q = s"""insert into humanresources.employeepayhistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(EmployeepayhistoryRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[EmployeepayhistoryRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate") FROM STDIN""", batchSize, unsaved)(EmployeepayhistoryRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[EmployeepayhistoryRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(EmployeepayhistoryRowUnsaved.text, c)
  }
  override def select: SelectBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    SelectBuilderSql("humanresources.employeepayhistory", EmployeepayhistoryFields.structure, EmployeepayhistoryRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[EmployeepayhistoryRow] = {
    SQL"""select "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
          from humanresources.employeepayhistory
       """.as(EmployeepayhistoryRow.rowParser(1).*)
  }
  override def selectById(compositeId: EmployeepayhistoryId)(implicit c: Connection): Option[EmployeepayhistoryRow] = {
    SQL"""select "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
          from humanresources.employeepayhistory
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "ratechangedate" = ${ParameterValue(compositeId.ratechangedate, null, TypoLocalDateTime.toStatement)}
       """.as(EmployeepayhistoryRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[EmployeepayhistoryId])(implicit c: Connection): List[EmployeepayhistoryRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val ratechangedate = compositeIds.map(_.ratechangedate)
    SQL"""select "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
          from humanresources.employeepayhistory
          where ("businessentityid", "ratechangedate") 
          in (select unnest(${businessentityid}), unnest(${ratechangedate}))
       """.as(EmployeepayhistoryRow.rowParser(1).*)
    
  }
  override def selectByIdsTracked(compositeIds: Array[EmployeepayhistoryId])(implicit c: Connection): Map[EmployeepayhistoryId, Option[EmployeepayhistoryRow]] = {
    val byId = selectByIds(compositeIds).view.map(x => (x.compositeId, x)).toMap
    compositeIds.view.map(id => (id, byId.get(id))).toMap
  }
  override def update: UpdateBuilder[EmployeepayhistoryFields, EmployeepayhistoryRow] = {
    UpdateBuilder("humanresources.employeepayhistory", EmployeepayhistoryFields.structure, EmployeepayhistoryRow.rowParser)
  }
  override def update(row: EmployeepayhistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update humanresources.employeepayhistory
          set "rate" = ${ParameterValue(row.rate, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "payfrequency" = ${ParameterValue(row.payfrequency, null, TypoShort.toStatement)}::int2,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "ratechangedate" = ${ParameterValue(compositeId.ratechangedate, null, TypoLocalDateTime.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: EmployeepayhistoryRow)(implicit c: Connection): EmployeepayhistoryRow = {
    SQL"""insert into humanresources.employeepayhistory("businessentityid", "ratechangedate", "rate", "payfrequency", "modifieddate")
          values (
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.ratechangedate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.rate, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.payfrequency, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("businessentityid", "ratechangedate")
          do update set
            "rate" = EXCLUDED."rate",
            "payfrequency" = EXCLUDED."payfrequency",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "ratechangedate"::text, "rate", "payfrequency", "modifieddate"::text
       """
      .executeInsert(EmployeepayhistoryRow.rowParser(1).single)
    
  }
}
