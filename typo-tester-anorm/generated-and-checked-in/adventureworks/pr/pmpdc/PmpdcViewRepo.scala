/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmpdc

import java.sql.Connection
import typo.dsl.SelectBuilder

trait PmpdcViewRepo {
  def select: SelectBuilder[PmpdcViewFields, PmpdcViewRow]
  def selectAll(implicit c: Connection): List[PmpdcViewRow]
}