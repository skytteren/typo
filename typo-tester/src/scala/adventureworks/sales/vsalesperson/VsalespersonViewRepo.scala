/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalesperson

import java.sql.Connection

trait VsalespersonViewRepo {
  def selectAll(implicit c: Connection): List[VsalespersonViewRow]
  def selectByFieldValues(fieldValues: List[VsalespersonViewFieldOrIdValue[_]])(implicit c: Connection): List[VsalespersonViewRow]
}
