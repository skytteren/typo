/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SQL
import anorm.SqlStringInterpolation
import java.sql.Connection

object PgAmopRepoImpl extends PgAmopRepo {
  override def selectAll(implicit c: Connection): List[PgAmopRow] = {
    SQL"""select oid, amopfamily, amoplefttype, amoprighttype, amopstrategy, amoppurpose, amopopr, amopmethod, amopsortfamily from pg_catalog.pg_amop""".as(PgAmopRow.rowParser.*)
  }
  override def selectById(oid: PgAmopId)(implicit c: Connection): Option[PgAmopRow] = {
    SQL"""select oid, amopfamily, amoplefttype, amoprighttype, amopstrategy, amoppurpose, amopopr, amopmethod, amopsortfamily from pg_catalog.pg_amop where oid = $oid""".as(PgAmopRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgAmopId])(implicit c: Connection): List[PgAmopRow] = {
    SQL"""select oid, amopfamily, amoplefttype, amoprighttype, amopstrategy, amoppurpose, amopopr, amopmethod, amopsortfamily from pg_catalog.pg_amop where oid in $oids""".as(PgAmopRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgAmopFieldValue[_]])(implicit c: Connection): List[PgAmopRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAmopFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgAmopFieldValue.amopfamily(value) => NamedParameter("amopfamily", ParameterValue.from(value))
          case PgAmopFieldValue.amoplefttype(value) => NamedParameter("amoplefttype", ParameterValue.from(value))
          case PgAmopFieldValue.amoprighttype(value) => NamedParameter("amoprighttype", ParameterValue.from(value))
          case PgAmopFieldValue.amopstrategy(value) => NamedParameter("amopstrategy", ParameterValue.from(value))
          case PgAmopFieldValue.amoppurpose(value) => NamedParameter("amoppurpose", ParameterValue.from(value))
          case PgAmopFieldValue.amopopr(value) => NamedParameter("amopopr", ParameterValue.from(value))
          case PgAmopFieldValue.amopmethod(value) => NamedParameter("amopmethod", ParameterValue.from(value))
          case PgAmopFieldValue.amopsortfamily(value) => NamedParameter("amopsortfamily", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_amop where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgAmopRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgAmopId, fieldValues: List[PgAmopFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgAmopFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgAmopFieldValue.amopfamily(value) => NamedParameter("amopfamily", ParameterValue.from(value))
          case PgAmopFieldValue.amoplefttype(value) => NamedParameter("amoplefttype", ParameterValue.from(value))
          case PgAmopFieldValue.amoprighttype(value) => NamedParameter("amoprighttype", ParameterValue.from(value))
          case PgAmopFieldValue.amopstrategy(value) => NamedParameter("amopstrategy", ParameterValue.from(value))
          case PgAmopFieldValue.amoppurpose(value) => NamedParameter("amoppurpose", ParameterValue.from(value))
          case PgAmopFieldValue.amopopr(value) => NamedParameter("amopopr", ParameterValue.from(value))
          case PgAmopFieldValue.amopmethod(value) => NamedParameter("amopmethod", ParameterValue.from(value))
          case PgAmopFieldValue.amopsortfamily(value) => NamedParameter("amopsortfamily", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_amop
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgAmopId, unsaved: PgAmopRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("amopfamily", ParameterValue.from(unsaved.amopfamily))),
      Some(NamedParameter("amoplefttype", ParameterValue.from(unsaved.amoplefttype))),
      Some(NamedParameter("amoprighttype", ParameterValue.from(unsaved.amoprighttype))),
      Some(NamedParameter("amopstrategy", ParameterValue.from(unsaved.amopstrategy))),
      Some(NamedParameter("amoppurpose", ParameterValue.from(unsaved.amoppurpose))),
      Some(NamedParameter("amopopr", ParameterValue.from(unsaved.amopopr))),
      Some(NamedParameter("amopmethod", ParameterValue.from(unsaved.amopmethod))),
      Some(NamedParameter("amopsortfamily", ParameterValue.from(unsaved.amopsortfamily)))
    ).flatten

    SQL"""insert into pg_catalog.pg_amop(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgAmopId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_amop where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(amopfamily: Long, amoplefttype: Long, amoprighttype: Long, amopstrategy: Short)(implicit c: Connection): Option[PgAmopRow] = {
    ???
  }
  override def selectByUnique(amopopr: Long, amoppurpose: String, amopfamily: Long)(implicit c: Connection): Option[PgAmopRow] = {
    ???
  }
}
