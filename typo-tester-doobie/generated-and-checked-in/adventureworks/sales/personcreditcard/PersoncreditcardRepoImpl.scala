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
import adventureworks.userdefined.CustomCreditcardId
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Put
import doobie.util.Write
import doobie.util.fragment.Fragment
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class PersoncreditcardRepoImpl extends PersoncreditcardRepo {
  override def delete: DeleteBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    DeleteBuilder("sales.personcreditcard", PersoncreditcardFields.structure)
  }
  override def deleteById(compositeId: PersoncreditcardId): ConnectionIO[Boolean] = {
    sql"""delete from sales.personcreditcard where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "creditcardid" = ${fromWrite(compositeId.creditcardid)(Write.fromPut(/* user-picked */ CustomCreditcardId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[PersoncreditcardId])(implicit put0: Put[Array[/* user-picked */ CustomCreditcardId]]): ConnectionIO[Int] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val creditcardid = compositeIds.map(_.creditcardid)
    sql"""delete
          from sales.personcreditcard
          where ("businessentityid", "creditcardid")
          in (select unnest(${businessentityid}), unnest(${creditcardid}))
       """.update.run
    
  }
  override def insert(unsaved: PersoncreditcardRow): ConnectionIO[PersoncreditcardRow] = {
    sql"""insert into sales.personcreditcard("businessentityid", "creditcardid", "modifieddate")
          values (${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.creditcardid)(Write.fromPut(/* user-picked */ CustomCreditcardId.put))}::int4, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "businessentityid", "creditcardid", "modifieddate"::text
       """.query(using PersoncreditcardRow.read).unique
  }
  override def insert(unsaved: PersoncreditcardRowUnsaved): ConnectionIO[PersoncreditcardRow] = {
    val fs = List(
      Some((Fragment.const(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const(s""""creditcardid""""), fr"${fromWrite(unsaved.creditcardid)(Write.fromPut(/* user-picked */ CustomCreditcardId.put))}::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.personcreditcard default values
            returning "businessentityid", "creditcardid", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into sales.personcreditcard(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "businessentityid", "creditcardid", "modifieddate"::text
         """
    }
    q.query(using PersoncreditcardRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, PersoncreditcardRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.personcreditcard("businessentityid", "creditcardid", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using PersoncreditcardRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, PersoncreditcardRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY sales.personcreditcard("businessentityid", "creditcardid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using PersoncreditcardRowUnsaved.text)
  }
  override def select: SelectBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    SelectBuilderSql("sales.personcreditcard", PersoncreditcardFields.structure, PersoncreditcardRow.read)
  }
  override def selectAll: Stream[ConnectionIO, PersoncreditcardRow] = {
    sql"""select "businessentityid", "creditcardid", "modifieddate"::text from sales.personcreditcard""".query(using PersoncreditcardRow.read).stream
  }
  override def selectById(compositeId: PersoncreditcardId): ConnectionIO[Option[PersoncreditcardRow]] = {
    sql"""select "businessentityid", "creditcardid", "modifieddate"::text from sales.personcreditcard where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "creditcardid" = ${fromWrite(compositeId.creditcardid)(Write.fromPut(/* user-picked */ CustomCreditcardId.put))}""".query(using PersoncreditcardRow.read).option
  }
  override def selectByIds(compositeIds: Array[PersoncreditcardId])(implicit puts0: Put[Array[/* user-picked */ CustomCreditcardId]]): Stream[ConnectionIO, PersoncreditcardRow] = {
    val businessentityid = compositeIds.map(_.businessentityid)
    val creditcardid = compositeIds.map(_.creditcardid)
    sql"""select "businessentityid", "creditcardid", "modifieddate"::text
          from sales.personcreditcard
          where ("businessentityid", "creditcardid") 
          in (select unnest(${businessentityid}), unnest(${creditcardid}))
       """.query(using PersoncreditcardRow.read).stream
    
  }
  override def selectByIdsTracked(compositeIds: Array[PersoncreditcardId])(implicit puts0: Put[Array[/* user-picked */ CustomCreditcardId]]): ConnectionIO[Map[PersoncreditcardId, Option[PersoncreditcardRow]]] = {
    selectByIds(compositeIds).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.compositeId, x)).toMap
      compositeIds.view.map(id => (id, byId.get(id))).toMap
    }
  }
  override def update: UpdateBuilder[PersoncreditcardFields, PersoncreditcardRow] = {
    UpdateBuilder("sales.personcreditcard", PersoncreditcardFields.structure, PersoncreditcardRow.read)
  }
  override def update(row: PersoncreditcardRow): ConnectionIO[Boolean] = {
    val compositeId = row.compositeId
    sql"""update sales.personcreditcard
          set "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "businessentityid" = ${fromWrite(compositeId.businessentityid)(Write.fromPut(BusinessentityId.put))} AND "creditcardid" = ${fromWrite(compositeId.creditcardid)(Write.fromPut(/* user-picked */ CustomCreditcardId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: PersoncreditcardRow): ConnectionIO[PersoncreditcardRow] = {
    sql"""insert into sales.personcreditcard("businessentityid", "creditcardid", "modifieddate")
          values (
            ${fromWrite(unsaved.businessentityid)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.creditcardid)(Write.fromPut(/* user-picked */ CustomCreditcardId.put))}::int4,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("businessentityid", "creditcardid")
          do update set
            "modifieddate" = EXCLUDED."modifieddate"
          returning "businessentityid", "creditcardid", "modifieddate"::text
       """.query(using PersoncreditcardRow.read).unique
  }
}
