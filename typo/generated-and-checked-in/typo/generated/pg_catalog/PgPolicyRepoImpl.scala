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

object PgPolicyRepoImpl extends PgPolicyRepo {
  override def selectAll(implicit c: Connection): List[PgPolicyRow] = {
    SQL"""select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck from pg_catalog.pg_policy""".as(PgPolicyRow.rowParser.*)
  }
  override def selectById(oid: PgPolicyId)(implicit c: Connection): Option[PgPolicyRow] = {
    SQL"""select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck from pg_catalog.pg_policy where oid = $oid""".as(PgPolicyRow.rowParser.singleOpt)
  }
  override def selectByIds(oids: List[PgPolicyId])(implicit c: Connection): List[PgPolicyRow] = {
    SQL"""select oid, polname, polrelid, polcmd, polpermissive, polroles, polqual, polwithcheck from pg_catalog.pg_policy where oid in $oids""".as(PgPolicyRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PgPolicyFieldValue[_]])(implicit c: Connection): List[PgPolicyRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgPolicyFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgPolicyFieldValue.polname(value) => NamedParameter("polname", ParameterValue.from(value))
          case PgPolicyFieldValue.polrelid(value) => NamedParameter("polrelid", ParameterValue.from(value))
          case PgPolicyFieldValue.polcmd(value) => NamedParameter("polcmd", ParameterValue.from(value))
          case PgPolicyFieldValue.polpermissive(value) => NamedParameter("polpermissive", ParameterValue.from(value))
          case PgPolicyFieldValue.polroles(value) => NamedParameter("polroles", ParameterValue.from(value))
          case PgPolicyFieldValue.polqual(value) => NamedParameter("polqual", ParameterValue.from(value))
          case PgPolicyFieldValue.polwithcheck(value) => NamedParameter("polwithcheck", ParameterValue.from(value))
        }
        val q = s"""select * from pg_catalog.pg_policy where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        SQL(q)
          .on(namedParams: _*)
          .as(PgPolicyRow.rowParser.*)
    }

  }
  override def updateFieldValues(oid: PgPolicyId, fieldValues: List[PgPolicyFieldValue[_]])(implicit c: Connection): Int = {
    fieldValues match {
      case Nil => 0
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PgPolicyFieldValue.oid(value) => NamedParameter("oid", ParameterValue.from(value))
          case PgPolicyFieldValue.polname(value) => NamedParameter("polname", ParameterValue.from(value))
          case PgPolicyFieldValue.polrelid(value) => NamedParameter("polrelid", ParameterValue.from(value))
          case PgPolicyFieldValue.polcmd(value) => NamedParameter("polcmd", ParameterValue.from(value))
          case PgPolicyFieldValue.polpermissive(value) => NamedParameter("polpermissive", ParameterValue.from(value))
          case PgPolicyFieldValue.polroles(value) => NamedParameter("polroles", ParameterValue.from(value))
          case PgPolicyFieldValue.polqual(value) => NamedParameter("polqual", ParameterValue.from(value))
          case PgPolicyFieldValue.polwithcheck(value) => NamedParameter("polwithcheck", ParameterValue.from(value))
        }
        val q = s"""update pg_catalog.pg_policy
          set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
          where oid = $oid"""
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate()
    }

  }
  override def insert(oid: PgPolicyId, unsaved: PgPolicyRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("polname", ParameterValue.from(unsaved.polname))),
      Some(NamedParameter("polrelid", ParameterValue.from(unsaved.polrelid))),
      Some(NamedParameter("polcmd", ParameterValue.from(unsaved.polcmd))),
      Some(NamedParameter("polpermissive", ParameterValue.from(unsaved.polpermissive))),
      Some(NamedParameter("polroles", ParameterValue.from(unsaved.polroles))),
      Some(NamedParameter("polqual", ParameterValue.from(unsaved.polqual))),
      Some(NamedParameter("polwithcheck", ParameterValue.from(unsaved.polwithcheck)))
    ).flatten

    SQL"""insert into pg_catalog.pg_policy(oid, ${namedParameters.map(_.name).mkString(", ")})
      values (${oid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
      """
      .on(namedParameters :_*)
      .execute()

  }
  override def delete(oid: PgPolicyId)(implicit c: Connection): Boolean = {
    SQL"""delete from pg_catalog.pg_policy where oid = $oid""".executeUpdate() > 0
  }
  override def selectByUnique(polrelid: Long, polname: String)(implicit c: Connection): Option[PgPolicyRow] = {
    ???
  }
}