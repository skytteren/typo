/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package column_domain_usage

import java.sql.Connection

trait ColumnDomainUsageViewRepo {
  def selectAll(implicit c: Connection): List[ColumnDomainUsageViewRow]
}