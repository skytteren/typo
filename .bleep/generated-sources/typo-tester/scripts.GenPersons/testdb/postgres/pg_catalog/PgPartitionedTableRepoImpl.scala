/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgPartitionedTableRepoImpl extends PgPartitionedTableRepo {
  override def selectAll(implicit c: Connection): List[PgPartitionedTableRow] = {
    SQL"""select partrelid, partstrat, partnatts, partdefid, partattrs, partclass, partcollation, partexprs from pg_catalog.pg_partitioned_table""".as(PgPartitionedTableRow.rowParser.*)
  }
  override def selectById(partrelid: PgPartitionedTableId)(implicit c: Connection): Option[PgPartitionedTableRow] = {
    SQL"""select partrelid, partstrat, partnatts, partdefid, partattrs, partclass, partcollation, partexprs from pg_catalog.pg_partitioned_table where partrelid = $partrelid""".as(PgPartitionedTableRow.rowParser.singleOpt)
  }
  override def selectByIds(partrelids: List[PgPartitionedTableId])(implicit c: Connection): List[PgPartitionedTableRow] = {
    SQL"""select partrelid, partstrat, partnatts, partdefid, partattrs, partclass, partcollation, partexprs from pg_catalog.pg_partitioned_table where partrelid in $partrelids""".as(PgPartitionedTableRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgPartitionedTableFieldValue[_]])(implicit c: Connection): List[PgPartitionedTableRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgPartitionedTableFieldValue.partrelid(value) => NamedParameter("partrelid", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partstrat(value) => NamedParameter("partstrat", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partnatts(value) => NamedParameter("partnatts", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partdefid(value) => NamedParameter("partdefid", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partattrs(value) => NamedParameter("partattrs", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partclass(value) => NamedParameter("partclass", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partcollation(value) => NamedParameter("partcollation", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partexprs(value) => NamedParameter("partexprs", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_partitioned_table where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgPartitionedTableRow.rowParser.*)
    }

  }
  override def updateFieldValues(partrelid: PgPartitionedTableId, fieldValues: List[PgPartitionedTableFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgPartitionedTableFieldValue.partrelid(value) => NamedParameter("partrelid", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partstrat(value) => NamedParameter("partstrat", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partnatts(value) => NamedParameter("partnatts", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partdefid(value) => NamedParameter("partdefid", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partattrs(value) => NamedParameter("partattrs", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partclass(value) => NamedParameter("partclass", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partcollation(value) => NamedParameter("partcollation", ParameterValue.from(value))
          case PgPartitionedTableFieldValue.partexprs(value) => NamedParameter("partexprs", ParameterValue.from(value))
        }
        SQL"""update pg_catalog.pg_partitioned_table
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where partrelid = $partrelid"""
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(partrelid: PgPartitionedTableId, unsaved: PgPartitionedTableRowUnsaved)(implicit c: Connection): Unit = {
    val namedParameters = List(
      Some(NamedParameter("partstrat", ParameterValue.from(unsaved.partstrat))),
      Some(NamedParameter("partnatts", ParameterValue.from(unsaved.partnatts))),
      Some(NamedParameter("partdefid", ParameterValue.from(unsaved.partdefid))),
      Some(NamedParameter("partattrs", ParameterValue.from(unsaved.partattrs))),
      Some(NamedParameter("partclass", ParameterValue.from(unsaved.partclass))),
      Some(NamedParameter("partcollation", ParameterValue.from(unsaved.partcollation))),
      Some(NamedParameter("partexprs", ParameterValue.from(unsaved.partexprs)))
    ).flatten

    SQL"""insert into pg_catalog.pg_partitioned_table(partrelid, ${namedParameters.map(_.name).mkString(", ")})
      values (${partrelid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(partrelid: PgPartitionedTableId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_partitioned_table where partrelid = $partrelid""".executeUpdate() > 0
  }
}
