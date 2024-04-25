/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package workorderrouting

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.production.location.LocationId
import adventureworks.production.workorder.WorkorderId
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.UpdateResult
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class WorkorderroutingRepoImpl extends WorkorderroutingRepo {
  override def delete: DeleteBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    DeleteBuilder("production.workorderrouting", WorkorderroutingFields.structure)
  }
  override def deleteById(compositeId: WorkorderroutingId): ZIO[ZConnection, Throwable, Boolean] = {
    sql"""delete from production.workorderrouting where "workorderid" = ${Segment.paramSegment(compositeId.workorderid)(WorkorderId.setter)} AND "productid" = ${Segment.paramSegment(compositeId.productid)(Setter.intSetter)} AND "operationsequence" = ${Segment.paramSegment(compositeId.operationsequence)(TypoShort.setter)}""".delete.map(_ > 0)
  }
  override def deleteByIds(compositeIds: Array[WorkorderroutingId]): ZIO[ZConnection, Throwable, Long] = {
    val workorderid = compositeIds.map(_.workorderid)
    val productid = compositeIds.map(_.productid)
    val operationsequence = compositeIds.map(_.operationsequence)
    sql"""delete
          from production.workorderrouting
          where ("workorderid", "productid", "operationsequence")
          in (select unnest(${workorderid}), unnest(${productid}), unnest(${operationsequence}))
       """.delete
    
  }
  override def insert(unsaved: WorkorderroutingRow): ZIO[ZConnection, Throwable, WorkorderroutingRow] = {
    sql"""insert into production.workorderrouting("workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate", "scheduledenddate", "actualstartdate", "actualenddate", "actualresourcehrs", "plannedcost", "actualcost", "modifieddate")
          values (${Segment.paramSegment(unsaved.workorderid)(WorkorderId.setter)}::int4, ${Segment.paramSegment(unsaved.productid)(Setter.intSetter)}::int4, ${Segment.paramSegment(unsaved.operationsequence)(TypoShort.setter)}::int2, ${Segment.paramSegment(unsaved.locationid)(LocationId.setter)}::int2, ${Segment.paramSegment(unsaved.scheduledstartdate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.scheduledenddate)(TypoLocalDateTime.setter)}::timestamp, ${Segment.paramSegment(unsaved.actualstartdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp, ${Segment.paramSegment(unsaved.actualenddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp, ${Segment.paramSegment(unsaved.actualresourcehrs)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric, ${Segment.paramSegment(unsaved.plannedcost)(Setter.bigDecimalScalaSetter)}::numeric, ${Segment.paramSegment(unsaved.actualcost)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric, ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp)
          returning "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text
       """.insertReturning(using WorkorderroutingRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insert(unsaved: WorkorderroutingRowUnsaved): ZIO[ZConnection, Throwable, WorkorderroutingRow] = {
    val fs = List(
      Some((sql""""workorderid"""", sql"${Segment.paramSegment(unsaved.workorderid)(WorkorderId.setter)}::int4")),
      Some((sql""""productid"""", sql"${Segment.paramSegment(unsaved.productid)(Setter.intSetter)}::int4")),
      Some((sql""""operationsequence"""", sql"${Segment.paramSegment(unsaved.operationsequence)(TypoShort.setter)}::int2")),
      Some((sql""""locationid"""", sql"${Segment.paramSegment(unsaved.locationid)(LocationId.setter)}::int2")),
      Some((sql""""scheduledstartdate"""", sql"${Segment.paramSegment(unsaved.scheduledstartdate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""scheduledenddate"""", sql"${Segment.paramSegment(unsaved.scheduledenddate)(TypoLocalDateTime.setter)}::timestamp")),
      Some((sql""""actualstartdate"""", sql"${Segment.paramSegment(unsaved.actualstartdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp")),
      Some((sql""""actualenddate"""", sql"${Segment.paramSegment(unsaved.actualenddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp")),
      Some((sql""""actualresourcehrs"""", sql"${Segment.paramSegment(unsaved.actualresourcehrs)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric")),
      Some((sql""""plannedcost"""", sql"${Segment.paramSegment(unsaved.plannedcost)(Setter.bigDecimalScalaSetter)}::numeric")),
      Some((sql""""actualcost"""", sql"${Segment.paramSegment(unsaved.actualcost)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((sql""""modifieddate"""", sql"${Segment.paramSegment(value: TypoLocalDateTime)(TypoLocalDateTime.setter)}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.workorderrouting default values
            returning "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text
         """
    } else {
      val names  = fs.map { case (n, _) => n }.mkFragment(SqlFragment(", "))
      val values = fs.map { case (_, f) => f }.mkFragment(SqlFragment(", "))
      sql"""insert into production.workorderrouting($names) values ($values) returning "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text"""
    }
    q.insertReturning(using WorkorderroutingRow.jdbcDecoder).map(_.updatedKeys.head)
    
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, WorkorderroutingRow], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.workorderrouting("workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate", "scheduledenddate", "actualstartdate", "actualenddate", "actualresourcehrs", "plannedcost", "actualcost", "modifieddate") FROM STDIN""", batchSize, unsaved)(WorkorderroutingRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: ZStream[ZConnection, Throwable, WorkorderroutingRowUnsaved], batchSize: Int): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY production.workorderrouting("workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate", "scheduledenddate", "actualstartdate", "actualenddate", "actualresourcehrs", "plannedcost", "actualcost", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(WorkorderroutingRowUnsaved.text)
  }
  override def select: SelectBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    SelectBuilderSql("production.workorderrouting", WorkorderroutingFields.structure, WorkorderroutingRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, WorkorderroutingRow] = {
    sql"""select "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text from production.workorderrouting""".query(using WorkorderroutingRow.jdbcDecoder).selectStream()
  }
  override def selectById(compositeId: WorkorderroutingId): ZIO[ZConnection, Throwable, Option[WorkorderroutingRow]] = {
    sql"""select "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text from production.workorderrouting where "workorderid" = ${Segment.paramSegment(compositeId.workorderid)(WorkorderId.setter)} AND "productid" = ${Segment.paramSegment(compositeId.productid)(Setter.intSetter)} AND "operationsequence" = ${Segment.paramSegment(compositeId.operationsequence)(TypoShort.setter)}""".query(using WorkorderroutingRow.jdbcDecoder).selectOne
  }
  override def selectByIds(compositeIds: Array[WorkorderroutingId]): ZStream[ZConnection, Throwable, WorkorderroutingRow] = {
    val workorderid = compositeIds.map(_.workorderid)
    val productid = compositeIds.map(_.productid)
    val operationsequence = compositeIds.map(_.operationsequence)
    sql"""select "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text
          from production.workorderrouting
          where ("workorderid", "productid", "operationsequence")
          in (select unnest(${workorderid}), unnest(${productid}), unnest(${operationsequence}))
       """.query(using WorkorderroutingRow.jdbcDecoder).selectStream()
    
  }
  override def update: UpdateBuilder[WorkorderroutingFields, WorkorderroutingRow] = {
    UpdateBuilder("production.workorderrouting", WorkorderroutingFields.structure, WorkorderroutingRow.jdbcDecoder)
  }
  override def update(row: WorkorderroutingRow): ZIO[ZConnection, Throwable, Boolean] = {
    val compositeId = row.compositeId
    sql"""update production.workorderrouting
          set "locationid" = ${Segment.paramSegment(row.locationid)(LocationId.setter)}::int2,
              "scheduledstartdate" = ${Segment.paramSegment(row.scheduledstartdate)(TypoLocalDateTime.setter)}::timestamp,
              "scheduledenddate" = ${Segment.paramSegment(row.scheduledenddate)(TypoLocalDateTime.setter)}::timestamp,
              "actualstartdate" = ${Segment.paramSegment(row.actualstartdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
              "actualenddate" = ${Segment.paramSegment(row.actualenddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
              "actualresourcehrs" = ${Segment.paramSegment(row.actualresourcehrs)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
              "plannedcost" = ${Segment.paramSegment(row.plannedcost)(Setter.bigDecimalScalaSetter)}::numeric,
              "actualcost" = ${Segment.paramSegment(row.actualcost)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
              "modifieddate" = ${Segment.paramSegment(row.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          where "workorderid" = ${Segment.paramSegment(compositeId.workorderid)(WorkorderId.setter)} AND "productid" = ${Segment.paramSegment(compositeId.productid)(Setter.intSetter)} AND "operationsequence" = ${Segment.paramSegment(compositeId.operationsequence)(TypoShort.setter)}""".update.map(_ > 0)
  }
  override def upsert(unsaved: WorkorderroutingRow): ZIO[ZConnection, Throwable, UpdateResult[WorkorderroutingRow]] = {
    sql"""insert into production.workorderrouting("workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate", "scheduledenddate", "actualstartdate", "actualenddate", "actualresourcehrs", "plannedcost", "actualcost", "modifieddate")
          values (
            ${Segment.paramSegment(unsaved.workorderid)(WorkorderId.setter)}::int4,
            ${Segment.paramSegment(unsaved.productid)(Setter.intSetter)}::int4,
            ${Segment.paramSegment(unsaved.operationsequence)(TypoShort.setter)}::int2,
            ${Segment.paramSegment(unsaved.locationid)(LocationId.setter)}::int2,
            ${Segment.paramSegment(unsaved.scheduledstartdate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.scheduledenddate)(TypoLocalDateTime.setter)}::timestamp,
            ${Segment.paramSegment(unsaved.actualstartdate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
            ${Segment.paramSegment(unsaved.actualenddate)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp,
            ${Segment.paramSegment(unsaved.actualresourcehrs)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
            ${Segment.paramSegment(unsaved.plannedcost)(Setter.bigDecimalScalaSetter)}::numeric,
            ${Segment.paramSegment(unsaved.actualcost)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric,
            ${Segment.paramSegment(unsaved.modifieddate)(TypoLocalDateTime.setter)}::timestamp
          )
          on conflict ("workorderid", "productid", "operationsequence")
          do update set
            "locationid" = EXCLUDED."locationid",
            "scheduledstartdate" = EXCLUDED."scheduledstartdate",
            "scheduledenddate" = EXCLUDED."scheduledenddate",
            "actualstartdate" = EXCLUDED."actualstartdate",
            "actualenddate" = EXCLUDED."actualenddate",
            "actualresourcehrs" = EXCLUDED."actualresourcehrs",
            "plannedcost" = EXCLUDED."plannedcost",
            "actualcost" = EXCLUDED."actualcost",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "workorderid", "productid", "operationsequence", "locationid", "scheduledstartdate"::text, "scheduledenddate"::text, "actualstartdate"::text, "actualenddate"::text, "actualresourcehrs", "plannedcost", "actualcost", "modifieddate"::text""".insertReturning(using WorkorderroutingRow.jdbcDecoder)
  }
}
