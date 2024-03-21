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

import anorm.SqlStringInterpolation
import java.sql.Connection

class ReferentialConstraintsViewRepoImpl extends ReferentialConstraintsViewRepo {
  override def selectAll(implicit c: Connection): List[ReferentialConstraintsViewRow] = {
    SQL"""select "constraint_catalog", "constraint_schema", "constraint_name", "unique_constraint_catalog", "unique_constraint_schema", "unique_constraint_name", "match_option", "update_rule", "delete_rule"
          from information_schema.referential_constraints
       """.as(ReferentialConstraintsViewRow.rowParser(1).*)
  }
}
