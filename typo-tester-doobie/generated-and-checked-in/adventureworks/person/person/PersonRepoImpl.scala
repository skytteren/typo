/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package person

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import adventureworks.userdefined.FirstName
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class PersonRepoImpl extends PersonRepo {
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilder("person.person", PersonFields.structure)
  }
  override def deleteById(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"""delete from person.person where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int] = {
    sql"""delete from person.person where "businessentityid" = ANY(${businessentityids})""".update.run
  }
  override def insert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    sql"""insert into person.person("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.persontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.namestyle)(Write.fromPut(NameStyle.put))}::bool, ${fromWrite(unsaved.title)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.firstname)(Write.fromPut(/* user-picked */ FirstName.put))}::varchar, ${fromWrite(unsaved.middlename)(Write.fromPutOption(Name.put))}::varchar, ${fromWrite(unsaved.lastname)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.suffix)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.emailpromotion)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.additionalcontactinfo)(Write.fromPutOption(TypoXml.put))}::xml, ${fromWrite(unsaved.demographics)(Write.fromPutOption(TypoXml.put))}::xml, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
       """.query(using PersonRow.read).unique
  }
  override def insert(unsaved: PersonRowUnsaved): ConnectionIO[PersonRow] = {
    val fs = List(
      Some((Fragment.const(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""persontype""""), fr"${fromWrite(unsaved.persontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const(s""""title""""), fr"${fromWrite(unsaved.title)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""firstname""""), fr"${fromWrite(unsaved.firstname)(Write.fromPut(/* user-picked */ FirstName.put))}::varchar")),
      Some((Fragment.const(s""""middlename""""), fr"${fromWrite(unsaved.middlename)(Write.fromPutOption(Name.put))}::varchar")),
      Some((Fragment.const(s""""lastname""""), fr"${fromWrite(unsaved.lastname)(Write.fromPut(Name.put))}::varchar")),
      Some((Fragment.const(s""""suffix""""), fr"${fromWrite(unsaved.suffix)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s""""additionalcontactinfo""""), fr"${fromWrite(unsaved.additionalcontactinfo)(Write.fromPutOption(TypoXml.put))}::xml")),
      Some((Fragment.const(s""""demographics""""), fr"${fromWrite(unsaved.demographics)(Write.fromPutOption(TypoXml.put))}::xml")),
      unsaved.namestyle match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""namestyle""""), fr"${fromWrite(value: NameStyle)(Write.fromPut(NameStyle.put))}::bool"))
      },
      unsaved.emailpromotion match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""emailpromotion""""), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.person default values
            returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into person.person(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
         """
    }
    q.query(using PersonRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, PersonRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.person("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using PersonRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PersonRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY person.person("businessentityid", "persontype", "title", "firstname", "middlename", "lastname", "suffix", "additionalcontactinfo", "demographics", "namestyle", "emailpromotion", "rowguid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using PersonRowUnsaved.text)
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderSql("person.person", PersonFields.structure, PersonRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PersonRow] = {
    sql"""select "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text from person.person""".query(using PersonRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[PersonRow]] = {
    sql"""select "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text from person.person where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".query(using PersonRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, PersonRow] = {
    sql"""select "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text from person.person where "businessentityid" = ANY(${businessentityids})""".query(using PersonRow.read).stream
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilder("person.person", PersonFields.structure, PersonRow.read)
  }
  override def update(row: PersonRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update person.person
          set "persontype" = ${fromWrite(row.persontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
              "namestyle" = ${fromWrite(row.namestyle)(Write.fromPut(NameStyle.put))}::bool,
              "title" = ${fromWrite(row.title)(Write.fromPutOption(Meta.StringMeta.put))},
              "firstname" = ${fromWrite(row.firstname)(Write.fromPut(/* user-picked */ FirstName.put))}::varchar,
              "middlename" = ${fromWrite(row.middlename)(Write.fromPutOption(Name.put))}::varchar,
              "lastname" = ${fromWrite(row.lastname)(Write.fromPut(Name.put))}::varchar,
              "suffix" = ${fromWrite(row.suffix)(Write.fromPutOption(Meta.StringMeta.put))},
              "emailpromotion" = ${fromWrite(row.emailpromotion)(Write.fromPut(Meta.IntMeta.put))}::int4,
              "additionalcontactinfo" = ${fromWrite(row.additionalcontactinfo)(Write.fromPutOption(TypoXml.put))}::xml,
              "demographics" = ${fromWrite(row.demographics)(Write.fromPutOption(TypoXml.put))}::xml,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PersonRow): ConnectionIO[PersonRow] = {
    sql"""insert into person.person("businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.persontype)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.namestyle)(Write.fromPut(NameStyle.put))}::bool,
            ${fromWrite(unsaved.title)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.firstname)(Write.fromPut(/* user-picked */ FirstName.put))}::varchar,
            ${fromWrite(unsaved.middlename)(Write.fromPutOption(Name.put))}::varchar,
            ${fromWrite(unsaved.lastname)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.suffix)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.emailpromotion)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.additionalcontactinfo)(Write.fromPutOption(TypoXml.put))}::xml,
            ${fromWrite(unsaved.demographics)(Write.fromPutOption(TypoXml.put))}::xml,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "persontype" = EXCLUDED."persontype",
            "namestyle" = EXCLUDED."namestyle",
            "title" = EXCLUDED."title",
            "firstname" = EXCLUDED."firstname",
            "middlename" = EXCLUDED."middlename",
            "lastname" = EXCLUDED."lastname",
            "suffix" = EXCLUDED."suffix",
            "emailpromotion" = EXCLUDED."emailpromotion",
            "additionalcontactinfo" = EXCLUDED."additionalcontactinfo",
            "demographics" = EXCLUDED."demographics",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "persontype", "namestyle", "title", "firstname", "middlename", "lastname", "suffix", "emailpromotion", "additionalcontactinfo", "demographics", "rowguid", "modifieddate"::text
       """.query(using PersonRow.read).unique
  }
}
