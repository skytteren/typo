/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package views

import java.sql.Connection

trait ViewsViewRepo {
  def selectAll(implicit c: Connection): List[ViewsViewRow]
}