/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package jobcandidate

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoXml
import adventureworks.person.businessentity.BusinessentityId
import cats.instances.list.catsStdInstancesForList
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.update.Update
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class JobcandidateRepoImpl extends JobcandidateRepo {
  override def delete: DeleteBuilder[JobcandidateFields, JobcandidateRow] = {
    DeleteBuilder("humanresources.jobcandidate", JobcandidateFields.structure)
  }
  override def deleteById(jobcandidateid: JobcandidateId): ConnectionIO[Boolean] = {
    sql"""delete from humanresources.jobcandidate where "jobcandidateid" = ${fromWrite(jobcandidateid)(Write.fromPut(JobcandidateId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(jobcandidateids: Array[JobcandidateId]): ConnectionIO[Int] = {
    sql"""delete from humanresources.jobcandidate where "jobcandidateid" = ANY(${jobcandidateids})""".update.run
  }
  override def insert(unsaved: JobcandidateRow): ConnectionIO[JobcandidateRow] = {
    sql"""insert into humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate")
          values (${fromWrite(unsaved.jobcandidateid)(Write.fromPut(JobcandidateId.put))}::int4, ${fromWrite(unsaved.businessentityid)(Write.fromPutOption(BusinessentityId.put))}::int4, ${fromWrite(unsaved.resume)(Write.fromPutOption(TypoXml.put))}::xml, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text
       """.query(using JobcandidateRow.read).unique
  }
  override def insert(unsaved: JobcandidateRowUnsaved): ConnectionIO[JobcandidateRow] = {
    val fs = List(
      Some((Fragment.const0(s""""businessentityid""""), fr"${fromWrite(unsaved.businessentityid)(Write.fromPutOption(BusinessentityId.put))}::int4")),
      Some((Fragment.const0(s""""resume""""), fr"${fromWrite(unsaved.resume)(Write.fromPutOption(TypoXml.put))}::xml")),
      unsaved.jobcandidateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""jobcandidateid""""), fr"${fromWrite(value: JobcandidateId)(Write.fromPut(JobcandidateId.put))}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into humanresources.jobcandidate default values
            returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into humanresources.jobcandidate(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text
         """
    }
    q.query(using JobcandidateRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, JobcandidateRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate") FROM STDIN""").copyIn(unsaved, batchSize)(using JobcandidateRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, JobcandidateRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY humanresources.jobcandidate("businessentityid", "resume", "jobcandidateid", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using JobcandidateRowUnsaved.text)
  }
  override def select: SelectBuilder[JobcandidateFields, JobcandidateRow] = {
    SelectBuilderSql("humanresources.jobcandidate", JobcandidateFields.structure, JobcandidateRow.read)
  }
  override def selectAll: Stream[ConnectionIO, JobcandidateRow] = {
    sql"""select "jobcandidateid", "businessentityid", "resume", "modifieddate"::text from humanresources.jobcandidate""".query(using JobcandidateRow.read).stream
  }
  override def selectById(jobcandidateid: JobcandidateId): ConnectionIO[Option[JobcandidateRow]] = {
    sql"""select "jobcandidateid", "businessentityid", "resume", "modifieddate"::text from humanresources.jobcandidate where "jobcandidateid" = ${fromWrite(jobcandidateid)(Write.fromPut(JobcandidateId.put))}""".query(using JobcandidateRow.read).option
  }
  override def selectByIds(jobcandidateids: Array[JobcandidateId]): Stream[ConnectionIO, JobcandidateRow] = {
    sql"""select "jobcandidateid", "businessentityid", "resume", "modifieddate"::text from humanresources.jobcandidate where "jobcandidateid" = ANY(${jobcandidateids})""".query(using JobcandidateRow.read).stream
  }
  override def selectByIdsTracked(jobcandidateids: Array[JobcandidateId]): ConnectionIO[Map[JobcandidateId, JobcandidateRow]] = {
    selectByIds(jobcandidateids).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.jobcandidateid, x)).toMap
      jobcandidateids.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def update: UpdateBuilder[JobcandidateFields, JobcandidateRow] = {
    UpdateBuilder("humanresources.jobcandidate", JobcandidateFields.structure, JobcandidateRow.read)
  }
  override def update(row: JobcandidateRow): ConnectionIO[Boolean] = {
    val jobcandidateid = row.jobcandidateid
    sql"""update humanresources.jobcandidate
          set "businessentityid" = ${fromWrite(row.businessentityid)(Write.fromPutOption(BusinessentityId.put))}::int4,
              "resume" = ${fromWrite(row.resume)(Write.fromPutOption(TypoXml.put))}::xml,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "jobcandidateid" = ${fromWrite(jobcandidateid)(Write.fromPut(JobcandidateId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: JobcandidateRow): ConnectionIO[JobcandidateRow] = {
    sql"""insert into humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate")
          values (
            ${fromWrite(unsaved.jobcandidateid)(Write.fromPut(JobcandidateId.put))}::int4,
            ${fromWrite(unsaved.businessentityid)(Write.fromPutOption(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.resume)(Write.fromPutOption(TypoXml.put))}::xml,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          )
          on conflict ("jobcandidateid")
          do update set
            "businessentityid" = EXCLUDED."businessentityid",
            "resume" = EXCLUDED."resume",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text
       """.query(using JobcandidateRow.read).unique
  }
  override def upsertBatch(unsaved: List[JobcandidateRow]): Stream[ConnectionIO, JobcandidateRow] = {
    Update[JobcandidateRow](
      s"""insert into humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate")
          values (?::int4,?::int4,?::xml,?::timestamp)
          on conflict ("jobcandidateid")
          do update set
            "businessentityid" = EXCLUDED."businessentityid",
            "resume" = EXCLUDED."resume",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "jobcandidateid", "businessentityid", "resume", "modifieddate"::text"""
    )(using JobcandidateRow.write)
    .updateManyWithGeneratedKeys[JobcandidateRow]("jobcandidateid", "businessentityid", "resume", "modifieddate")(unsaved)(using catsStdInstancesForList, JobcandidateRow.read)
  }
  /* NOTE: this functionality is not safe if you use auto-commit mode! it runs 3 SQL statements */
  override def upsertStreaming(unsaved: Stream[ConnectionIO, JobcandidateRow], batchSize: Int = 10000): ConnectionIO[Int] = {
    for {
      _ <- sql"create temporary table jobcandidate_TEMP (like humanresources.jobcandidate) on commit drop".update.run
      _ <- new FragmentOps(sql"""copy jobcandidate_TEMP("jobcandidateid", "businessentityid", "resume", "modifieddate") from stdin""").copyIn(unsaved, batchSize)(using JobcandidateRow.text)
      res <- sql"""insert into humanresources.jobcandidate("jobcandidateid", "businessentityid", "resume", "modifieddate")
                   select * from jobcandidate_TEMP
                   on conflict ("jobcandidateid")
                   do update set
                     "businessentityid" = EXCLUDED."businessentityid",
                     "resume" = EXCLUDED."resume",
                     "modifieddate" = EXCLUDED."modifieddate"
                   ;
                   drop table jobcandidate_TEMP;""".update.run
    } yield res
  }
}
