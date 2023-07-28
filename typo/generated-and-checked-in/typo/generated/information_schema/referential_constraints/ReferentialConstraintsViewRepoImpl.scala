/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema
package referential_constraints

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object ReferentialConstraintsViewRepoImpl extends ReferentialConstraintsViewRepo {
  override def selectAll(implicit c: Connection): List[ReferentialConstraintsViewRow] = {
    SQL"""select "constraint_catalog", "constraint_schema", "constraint_name", unique_constraint_catalog, unique_constraint_schema, unique_constraint_name, match_option, update_rule, delete_rule
          from information_schema.referential_constraints
       """.as(ReferentialConstraintsViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[ReferentialConstraintsViewFieldOrIdValue[_]])(implicit c: Connection): List[ReferentialConstraintsViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ReferentialConstraintsViewFieldValue.constraintCatalog(value) => NamedParameter("constraint_catalog", ParameterValue.from(value))
          case ReferentialConstraintsViewFieldValue.constraintSchema(value) => NamedParameter("constraint_schema", ParameterValue.from(value))
          case ReferentialConstraintsViewFieldValue.constraintName(value) => NamedParameter("constraint_name", ParameterValue.from(value))
          case ReferentialConstraintsViewFieldValue.uniqueConstraintCatalog(value) => NamedParameter("unique_constraint_catalog", ParameterValue.from(value))
          case ReferentialConstraintsViewFieldValue.uniqueConstraintSchema(value) => NamedParameter("unique_constraint_schema", ParameterValue.from(value))
          case ReferentialConstraintsViewFieldValue.uniqueConstraintName(value) => NamedParameter("unique_constraint_name", ParameterValue.from(value))
          case ReferentialConstraintsViewFieldValue.matchOption(value) => NamedParameter("match_option", ParameterValue.from(value))
          case ReferentialConstraintsViewFieldValue.updateRule(value) => NamedParameter("update_rule", ParameterValue.from(value))
          case ReferentialConstraintsViewFieldValue.deleteRule(value) => NamedParameter("delete_rule", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "constraint_catalog", "constraint_schema", "constraint_name", unique_constraint_catalog, unique_constraint_schema, unique_constraint_name, match_option, update_rule, delete_rule
                    from information_schema.referential_constraints
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(ReferentialConstraintsViewRow.rowParser(1).*)
    }
  
  }
}
