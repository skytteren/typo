/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package domains

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object DomainsViewRepoImpl extends DomainsViewRepo {
  override def selectAll: Stream[ConnectionIO, DomainsViewRow] = {
    sql"""select domain_catalog, domain_schema, domain_name, data_type, character_maximum_length, character_octet_length, "character_set_catalog", "character_set_schema", "character_set_name", "collation_catalog", "collation_schema", "collation_name", numeric_precision, numeric_precision_radix, numeric_scale, datetime_precision, interval_type, interval_precision, domain_default, udt_catalog, udt_schema, udt_name, "scope_catalog", "scope_schema", "scope_name", maximum_cardinality, dtd_identifier from information_schema.domains""".query(DomainsViewRow.read).stream
  }
}
