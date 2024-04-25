/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentitycontact

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.contacttype.ContacttypeId
import adventureworks.streamingInsert
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class BusinessentitycontactRepoImpl extends BusinessentitycontactRepo {
  override def delete(compositeId: BusinessentitycontactId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.businessentitycontact where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "personid" = ${ParameterValue(compositeId.personid, null, BusinessentityId.toStatement)} AND "contacttypeid" = ${ParameterValue(compositeId.contacttypeid, null, ContacttypeId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[BusinessentitycontactId])(implicit c: Connection): Int = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val personid = compositeIds.map(_.personid)
    val contacttypeid = compositeIds.map(_.contacttypeid)
    SQL"""delete
          from person.businessentitycontact
          where ("businessentityid", "personid", "contacttypeid")
          in (select unnest(${businessentityid}), unnest(${personid}), unnest(${contacttypeid}))
       """.executeUpdate()
    
  }
  override def delete: DeleteBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    DeleteBuilder("person.businessentitycontact", BusinessentitycontactFields.structure)
  }
  override def insert(unsaved: BusinessentitycontactRow)(implicit c: Connection): BusinessentitycontactRow = {
    SQL"""insert into person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")
          values (${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.personid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.contacttypeid, null, ContacttypeId.toStatement)}::int4, ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
       """
      .executeInsert(BusinessentitycontactRow.rowParser(1).single)
    
  }
  override def insertStreaming(unsaved: Iterator[BusinessentitycontactRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate") FROM STDIN""", batchSize, unsaved)(BusinessentitycontactRow.text, c)
  }
  override def insert(unsaved: BusinessentitycontactRowUnsaved)(implicit c: Connection): BusinessentitycontactRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("personid", ParameterValue(unsaved.personid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("contacttypeid", ParameterValue(unsaved.contacttypeid, null, ContacttypeId.toStatement)), "::int4")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue(value, null, TypoUUID.toStatement)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.businessentitycontact default values
            returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
         """
        .executeInsert(BusinessentitycontactRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.businessentitycontact(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(BusinessentitycontactRow.rowParser(1).single)
    }
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[BusinessentitycontactRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(BusinessentitycontactRowUnsaved.text, c)
  }
  override def select: SelectBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    SelectBuilderSql("person.businessentitycontact", BusinessentitycontactFields.structure, BusinessentitycontactRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[BusinessentitycontactRow] = {
    SQL"""select "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
          from person.businessentitycontact
       """.as(BusinessentitycontactRow.rowParser(1).*)
  }
  override def selectById(compositeId: BusinessentitycontactId)(implicit c: Connection): Option[BusinessentitycontactRow] = {
    SQL"""select "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
          from person.businessentitycontact
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "personid" = ${ParameterValue(compositeId.personid, null, BusinessentityId.toStatement)} AND "contacttypeid" = ${ParameterValue(compositeId.contacttypeid, null, ContacttypeId.toStatement)}
       """.as(BusinessentitycontactRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[BusinessentitycontactId])(implicit c: Connection): List[BusinessentitycontactRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val personid = compositeIds.map(_.personid)
    val contacttypeid = compositeIds.map(_.contacttypeid)
    SQL"""select "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
          from person.businessentitycontact
          where ("businessentityid", "personid", "contacttypeid") 
          in (select unnest(${businessentityid}), unnest(${personid}), unnest(${contacttypeid}))
       """.as(BusinessentitycontactRow.rowParser(1).*)
    
  }
  override def update(row: BusinessentitycontactRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update person.businessentitycontact
          set "rowguid" = ${ParameterValue(row.rowguid, null, TypoUUID.toStatement)}::uuid,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "personid" = ${ParameterValue(compositeId.personid, null, BusinessentityId.toStatement)} AND "contacttypeid" = ${ParameterValue(compositeId.contacttypeid, null, ContacttypeId.toStatement)}
       """.executeUpdate() > 0
  }
  override def update: UpdateBuilder[BusinessentitycontactFields, BusinessentitycontactRow] = {
    UpdateBuilder("person.businessentitycontact", BusinessentitycontactFields.structure, BusinessentitycontactRow.rowParser)
  }
  override def upsert(unsaved: BusinessentitycontactRow)(implicit c: Connection): BusinessentitycontactRow = {
    SQL"""insert into person.businessentitycontact("businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate")
          values (
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.personid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.contacttypeid, null, ContacttypeId.toStatement)}::int4,
            ${ParameterValue(unsaved.rowguid, null, TypoUUID.toStatement)}::uuid,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("businessentityid", "personid", "contacttypeid")
          do update set
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "personid", "contacttypeid", "rowguid", "modifieddate"::text
       """
      .executeInsert(BusinessentitycontactRow.rowParser(1).single)
    
  }
}
