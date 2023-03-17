package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgStatSysIndexesRepoImpl extends PgStatSysIndexesRepo {
  override def selectAll(implicit c: Connection): List[PgStatSysIndexesRow] = {
    SQL"""select relid, indexrelid, schemaname, relname, indexrelname, idx_scan, idx_tup_read, idx_tup_fetch from pg_catalog.pg_stat_sys_indexes""".as(PgStatSysIndexesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgStatSysIndexesFieldValue[_]])(implicit c: Connection): List[PgStatSysIndexesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgStatSysIndexesFieldValue.relid(value) => NamedParameter("relid", ParameterValue.from(value))
          case PgStatSysIndexesFieldValue.indexrelid(value) => NamedParameter("indexrelid", ParameterValue.from(value))
          case PgStatSysIndexesFieldValue.schemaname(value) => NamedParameter("schemaname", ParameterValue.from(value))
          case PgStatSysIndexesFieldValue.relname(value) => NamedParameter("relname", ParameterValue.from(value))
          case PgStatSysIndexesFieldValue.indexrelname(value) => NamedParameter("indexrelname", ParameterValue.from(value))
          case PgStatSysIndexesFieldValue.idxScan(value) => NamedParameter("idx_scan", ParameterValue.from(value))
          case PgStatSysIndexesFieldValue.idxTupRead(value) => NamedParameter("idx_tup_read", ParameterValue.from(value))
          case PgStatSysIndexesFieldValue.idxTupFetch(value) => NamedParameter("idx_tup_fetch", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_stat_sys_indexes where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgStatSysIndexesRow.rowParser.*)
    }

  }
}