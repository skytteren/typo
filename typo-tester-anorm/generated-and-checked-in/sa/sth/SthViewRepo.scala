/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sa
package sth

import java.sql.Connection

trait SthViewRepo {
  def selectAll(implicit c: Connection): List[SthViewRow]
  def selectByFieldValues(fieldValues: List[SthViewFieldOrIdValue[_]])(implicit c: Connection): List[SthViewRow]
}