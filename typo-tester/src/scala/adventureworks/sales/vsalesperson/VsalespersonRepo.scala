/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package vsalesperson

import java.sql.Connection

trait VsalespersonRepo {
  def selectAll(implicit c: Connection): List[VsalespersonRow]
  def selectByFieldValues(fieldValues: List[VsalespersonFieldOrIdValue[_]])(implicit c: Connection): List[VsalespersonRow]
}