/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.AccountNumber
import adventureworks.public.Flag
import adventureworks.public.Name
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

class VendorRepoImpl extends VendorRepo {
  override def delete(businessentityid: BusinessentityId): ConnectionIO[Boolean] = {
    sql"""delete from purchasing.vendor where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(businessentityids: Array[BusinessentityId]): ConnectionIO[Int] = {
    sql"""delete from purchasing.vendor where "businessentityid" = ANY(${businessentityids})""".update.run
  }
  override def delete: DeleteBuilder[VendorFields, VendorRow] = {
    DeleteBuilder("purchasing.vendor", VendorFields.structure)
  }
  override def insert(unsaved: VendorRow): ConnectionIO[VendorRow] = {
    sql"""insert into purchasing.vendor("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.accountnumber)(Write.fromPut(AccountNumber.put))}::varchar, ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar, ${fromWrite(unsaved.creditrating)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.preferredvendorstatus)(Write.fromPut(Flag.put))}::bool, ${fromWrite(unsaved.activeflag)(Write.fromPut(Flag.put))}::bool, ${fromWrite(unsaved.purchasingwebserviceurl)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
       """.query(using VendorRow.read).unique
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, VendorRow], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY purchasing.vendor("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using VendorRow.text)
  }
  override def insert(unsaved: VendorRowUnsaved): ConnectionIO[VendorRow] = {
    val fs = List(
      Some((Fragment.const(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""accountnumber""""), fr"${fromWrite(unsaved.accountnumber)(Write.fromPut(AccountNumber.put))}::varchar")),
      Some((Fragment.const(s""""name""""), fr"${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar")),
      Some((Fragment.const(s""""creditrating""""), fr"${fromWrite(unsaved.creditrating)(Write.fromPut(TypoShort.put))}::int2")),
      Some((Fragment.const(s""""purchasingwebserviceurl""""), fr"${fromWrite(unsaved.purchasingwebserviceurl)(Write.fromPutOption(Meta.StringMeta.put))}")),
      unsaved.preferredvendorstatus match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""preferredvendorstatus""""), fr"${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::bool"))
      },
      unsaved.activeflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""activeflag""""), fr"${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::bool"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into purchasing.vendor default values
            returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into purchasing.vendor(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
         """
    }
    q.query(using VendorRow.read).unique
    
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, VendorRowUnsaved], batchSize: Int): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY purchasing.vendor("businessentityid", "accountnumber", "name", "creditrating", "purchasingwebserviceurl", "preferredvendorstatus", "activeflag", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using VendorRowUnsaved.text)
  }
  override def select: SelectBuilder[VendorFields, VendorRow] = {
    SelectBuilderSql("purchasing.vendor", VendorFields.structure, VendorRow.read)
  }
  override def selectAll: Stream[ConnectionIO, VendorRow] = {
    sql"""select "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text from purchasing.vendor""".query(using VendorRow.read).stream
  }
  override def selectById(businessentityid: BusinessentityId): ConnectionIO[Option[VendorRow]] = {
    sql"""select "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text from purchasing.vendor where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}""".query(using VendorRow.read).option
  }
  override def selectByIds(businessentityids: Array[BusinessentityId]): Stream[ConnectionIO, VendorRow] = {
    sql"""select "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text from purchasing.vendor where "businessentityid" = ANY(${businessentityids})""".query(using VendorRow.read).stream
  }
  override def update(row: VendorRow): ConnectionIO[Boolean] = {
    val businessentityid = row.businessentityid
    sql"""update purchasing.vendor
          set "accountnumber" = ${fromWrite(row.accountnumber)(Write.fromPut(AccountNumber.put))}::varchar,
              "name" = ${fromWrite(row.name)(Write.fromPut(Name.put))}::varchar,
              "creditrating" = ${fromWrite(row.creditrating)(Write.fromPut(TypoShort.put))}::int2,
              "preferredvendorstatus" = ${fromWrite(row.preferredvendorstatus)(Write.fromPut(Flag.put))}::bool,
              "activeflag" = ${fromWrite(row.activeflag)(Write.fromPut(Flag.put))}::bool,
              "purchasingwebserviceurl" = ${fromWrite(row.purchasingwebserviceurl)(Write.fromPutOption(Meta.StringMeta.put))},
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "businessentityid" = ${fromWrite(businessentityid)(Write.fromPut(BusinessentityId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[VendorFields, VendorRow] = {
    UpdateBuilder("purchasing.vendor", VendorFields.structure, VendorRow.read)
  }
  override def upsert(unsaved: VendorRow): ConnectionIO[VendorRow] = {
    sql"""insert into purchasing.vendor("businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.accountnumber)(Write.fromPut(AccountNumber.put))}::varchar,
            ${fromWrite(unsaved.name)(Write.fromPut(Name.put))}::varchar,
            ${fromWrite(unsaved.creditrating)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.preferredvendorstatus)(Write.fromPut(Flag.put))}::bool,
            ${fromWrite(unsaved.activeflag)(Write.fromPut(Flag.put))}::bool,
            ${fromWrite(unsaved.purchasingwebserviceurl)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid")
          do update set
            "accountnumber" = EXCLUDED."accountnumber",
            "name" = EXCLUDED."name",
            "creditrating" = EXCLUDED."creditrating",
            "preferredvendorstatus" = EXCLUDED."preferredvendorstatus",
            "activeflag" = EXCLUDED."activeflag",
            "purchasingwebserviceurl" = EXCLUDED."purchasingwebserviceurl",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "accountnumber", "name", "creditrating", "preferredvendorstatus", "activeflag", "purchasingwebserviceurl", "modifieddate"::text
       """.query(using VendorRow.read).unique
  }
}
