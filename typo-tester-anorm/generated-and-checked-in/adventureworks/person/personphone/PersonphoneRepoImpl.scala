/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package personphone

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
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

class PersonphoneRepoImpl extends PersonphoneRepo {
  override def delete: DeleteBuilder[PersonphoneFields, PersonphoneRow] = {
    DeleteBuilder("person.personphone", PersonphoneFields.structure)
  }
  override def deleteById(compositeId: PersonphoneId)(implicit c: Connection): Boolean = {
    SQL"""delete from person.personphone where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "phonenumber" = ${ParameterValue(compositeId.phonenumber, null, Phone.toStatement)} AND "phonenumbertypeid" = ${ParameterValue(compositeId.phonenumbertypeid, null, PhonenumbertypeId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(compositeIds: Array[PersonphoneId])(implicit c: Connection): Int = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val phonenumber = compositeIds.map(_.phonenumber)
    val phonenumbertypeid = compositeIds.map(_.phonenumbertypeid)
    SQL"""delete
          from person.personphone
          where ("businessentityid", "phonenumber", "phonenumbertypeid")
          in (select unnest(${businessentityid}), unnest(${phonenumber}), unnest(${phonenumbertypeid}))
       """.executeUpdate()
    
  }
  override def insert(unsaved: PersonphoneRow)(implicit c: Connection): PersonphoneRow = {
    SQL"""insert into person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")
          values (${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.phonenumber, null, Phone.toStatement)}::varchar, ${ParameterValue(unsaved.phonenumbertypeid, null, PhonenumbertypeId.toStatement)}::int4, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
       """
      .executeInsert(PersonphoneRow.rowParser(1).single)
    
  }
  override def insert(unsaved: PersonphoneRowUnsaved)(implicit c: Connection): PersonphoneRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("phonenumber", ParameterValue(unsaved.phonenumber, null, Phone.toStatement)), "::varchar")),
      Some((NamedParameter("phonenumbertypeid", ParameterValue(unsaved.phonenumbertypeid, null, PhonenumbertypeId.toStatement)), "::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into person.personphone default values
            returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
         """
        .executeInsert(PersonphoneRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.personphone(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(PersonphoneRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[PersonphoneRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate") FROM STDIN""", batchSize, unsaved)(PersonphoneRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[PersonphoneRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PersonphoneRowUnsaved.text, c)
  }
  override def select: SelectBuilder[PersonphoneFields, PersonphoneRow] = {
    SelectBuilderSql("person.personphone", PersonphoneFields.structure, PersonphoneRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PersonphoneRow] = {
    SQL"""select "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
          from person.personphone
       """.as(PersonphoneRow.rowParser(1).*)
  }
  override def selectById(compositeId: PersonphoneId)(implicit c: Connection): Option[PersonphoneRow] = {
    SQL"""select "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
          from person.personphone
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "phonenumber" = ${ParameterValue(compositeId.phonenumber, null, Phone.toStatement)} AND "phonenumbertypeid" = ${ParameterValue(compositeId.phonenumbertypeid, null, PhonenumbertypeId.toStatement)}
       """.as(PersonphoneRow.rowParser(1).singleOpt)
  }
  override def selectByIds(compositeIds: Array[PersonphoneId])(implicit c: Connection): List[PersonphoneRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val phonenumber = compositeIds.map(_.phonenumber)
    val phonenumbertypeid = compositeIds.map(_.phonenumbertypeid)
    SQL"""select "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
          from person.personphone
          where ("businessentityid", "phonenumber", "phonenumbertypeid") 
          in (select unnest(${businessentityid}), unnest(${phonenumber}), unnest(${phonenumbertypeid}))
       """.as(PersonphoneRow.rowParser(1).*)
    
  }
  override def update: UpdateBuilder[PersonphoneFields, PersonphoneRow] = {
    UpdateBuilder("person.personphone", PersonphoneFields.structure, PersonphoneRow.rowParser)
  }
  override def update(row: PersonphoneRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update person.personphone
          set "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "businessentityid" = ${ParameterValue(compositeId.businessentityid, null, BusinessentityId.toStatement)} AND "phonenumber" = ${ParameterValue(compositeId.phonenumber, null, Phone.toStatement)} AND "phonenumbertypeid" = ${ParameterValue(compositeId.phonenumbertypeid, null, PhonenumbertypeId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PersonphoneRow)(implicit c: Connection): PersonphoneRow = {
    SQL"""insert into person.personphone("businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate")
          values (
            ${ParameterValue(unsaved.businessentityid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.phonenumber, null, Phone.toStatement)}::varchar,
            ${ParameterValue(unsaved.phonenumbertypeid, null, PhonenumbertypeId.toStatement)}::int4,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("businessentityid", "phonenumber", "phonenumbertypeid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "phonenumber", "phonenumbertypeid", "modifieddate"::text
       """
      .executeInsert(PersonphoneRow.rowParser(1).single)
    
  }
}
