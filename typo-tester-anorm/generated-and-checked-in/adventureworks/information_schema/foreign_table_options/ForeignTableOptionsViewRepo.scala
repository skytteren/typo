/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_table_options

import java.sql.Connection
import typo.dsl.SelectBuilder

trait ForeignTableOptionsViewRepo {
  def select: SelectBuilder[ForeignTableOptionsViewFields, ForeignTableOptionsViewRow]
  def selectAll(implicit c: Connection): List[ForeignTableOptionsViewRow]
}