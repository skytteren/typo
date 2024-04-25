/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.streamingInsert
import adventureworks.userdefined.CustomCreditcardId
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

class PersoncreditcardRepoImpl extends PersoncreditcardRepo {
  override def delete(compositeId: PersoncreditcardId)(implicit c: Connection): Boolean = {
    SQL"""delete from sales.personcreditcard where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "creditcardid" = ${ParameterValue(compositeId.creditcardid, null, /* user-picked */ CustomCreditcardId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[PersoncreditcardId])(implicit c: Connection, toStatement0: ToStatement[Array[/* user-picked */ CustomCreditcardId]]): Int = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val creditcardid = compositeIds.map(_.creditcardid)
    SQL"""delete
          from sales.personcreditcard
          where ("businessentityid", "creditcardid")
          in (select unnest(${businessentityid}), unnest(${creditcardid}))
       """.executeUpdate()
    
  }
  override def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    DeleteBuilder("sales.personcreditcard", PersoncreditcardFields.structure)
  }
  override def insert(unsaved: PersoncreditcardRow)(implicit c: Connection): PersoncreditcardRow = {
    SQL"""insert into sales.personcreditcard("businessentityid", "creditcardid", "modifieddate")
          values (${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.creditcardid, null, /* user-picked */ CustomCreditcardId.toStatement)}::int4, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "businessentityid", "creditcardid", "modifieddate"::text
       """
      .executeInsert(PersoncreditcardRow.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[PersoncreditcardRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.personcreditcard("businessentityid", "creditcardid", "modifieddate") FROM STDIN""", batchSize, unsaved)(PersoncreditcardRow.text, c)
  }
  override def insert(unsaved: PersoncreditcardRowUnsaved)(implicit c: Connection): PersoncreditcardRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("creditcardid", ParameterValue(unsaved.creditcardid, null, /* user-picked */ CustomCreditcardId.toStatement)), "::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.personcreditcard default values
            returning "businessentityid", "creditcardid", "modifieddate"::text
         """
        .executeInsert(PersoncreditcardRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.personcreditcard(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "businessentityid", "creditcardid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(PersoncreditcardRow.rowParser(1).single)
    }
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[PersoncreditcardRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY sales.personcreditcard("businessentityid", "creditcardid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PersoncreditcardRowUnsaved.text, c)
  }
  override def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    SelectBuilderSql("sales.personcreditcard", PersoncreditcardFields.structure, PersoncreditcardRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PersoncreditcardRow] = {
    SQL"""select "businessentityid", "creditcardid", "modifieddate"::text
          from sales.personcreditcard
       """.as(PersoncreditcardRow.rowParser(1).*)
  }
  override def selectById(compositeId: PersoncreditcardId)(implicit c: Connection): Option[PersoncreditcardRow] = {
    SQL"""select "businessentityid", "creditcardid", "modifieddate"::text
          from sales.personcreditcard
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "creditcardid" = ${ParameterValue(compositeId.creditcardid, null, /* user-picked */ CustomCreditcardId.toStatement)}
       """.as(PersoncreditcardRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[PersoncreditcardId])(implicit c: Connection, toStatement0: ToStatement[Array[/* user-picked */ CustomCreditcardId]]): List[PersoncreditcardRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val creditcardid = compositeIds.map(_.creditcardid)
    SQL"""select "businessentityid", "creditcardid", "modifieddate"::text
          from sales.personcreditcard
          where ("businessentityid", "creditcardid") 
          in (select unnest(${businessentityid}), unnest(${creditcardid}))
       """.as(PersoncreditcardRow.rowParser(1).*)
    
  }
  override def update(row: PersoncreditcardRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.personcreditcard
          set "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "creditcardid" = ${ParameterValue(compositeId.creditcardid, null, /* user-picked */ CustomCreditcardId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    UpdateBuilder("sales.personcreditcard", PersoncreditcardFields.structure, PersoncreditcardRow.rowParser)
  }
  override def upsert(unsaved: PersoncreditcardRow)(implicit c: Connection): PersoncreditcardRow = {
    SQL"""insert into sales.personcreditcard("businessentityid", "creditcardid", "modifieddate")
          values (
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.creditcardid, null, /* user-picked */ CustomCreditcardId.toStatement)}::int4,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("businessentityid", "creditcardid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "creditcardid", "modifieddate"::text
       """
      .executeInsert(PersoncreditcardRow.rowParser(1).single)
    
  }
}
