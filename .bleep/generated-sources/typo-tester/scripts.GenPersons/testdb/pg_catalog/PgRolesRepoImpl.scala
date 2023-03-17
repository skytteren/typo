package testdb.pg_catalog

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

trait PgRolesRepoImpl extends PgRolesRepo {
  override def selectAll(implicit c: Connection): List[PgRolesRow] = {
    SQL"""select rolname, rolsuper, rolinherit, rolcreaterole, rolcreatedb, rolcanlogin, rolreplication, rolconnlimit, rolpassword, rolvaliduntil, rolbypassrls, rolconfig, oid from pg_catalog.pg_roles""".as(PgRolesRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgRolesFieldValue[_]])(implicit c: Connection): List[PgRolesRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgRolesFieldValue.rolname(value) => NamedParameter("rolname", ParameterValue.from(value))
          case PgRolesFieldValue.rolsuper(value) => NamedParameter("rolsuper", ParameterValue.from(value))
          case PgRolesFieldValue.rolinherit(value) => NamedParameter("rolinherit", ParameterValue.from(value))
          case PgRolesFieldValue.rolcreaterole(value) => NamedParameter("rolcreaterole", ParameterValue.from(value))
          case PgRolesFieldValue.rolcreatedb(value) => NamedParameter("rolcreatedb", ParameterValue.from(value))
          case PgRolesFieldValue.rolcanlogin(value) => NamedParameter("rolcanlogin", ParameterValue.from(value))
          case PgRolesFieldValue.rolreplication(value) => NamedParameter("rolreplication", ParameterValue.from(value))
          case PgRolesFieldValue.rolconnlimit(value) => NamedParameter("rolconnlimit", ParameterValue.from(value))
          case PgRolesFieldValue.rolpassword(value) => NamedParameter("rolpassword", ParameterValue.from(value))
          case PgRolesFieldValue.rolvaliduntil(value) => NamedParameter("rolvaliduntil", ParameterValue.from(value))
          case PgRolesFieldValue.rolbypassrls(value) => NamedParameter("rolbypassrls", ParameterValue.from(value))
          case PgRolesFieldValue.rolconfig(value) => NamedParameter("rolconfig", ParameterValue.from(value))
          case PgRolesFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
        }
        SQL"""select * from pg_catalog.pg_roles where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
          .on(namedParams: _*)
          .as(PgRolesRow.rowParser.*)
    }

  }
}