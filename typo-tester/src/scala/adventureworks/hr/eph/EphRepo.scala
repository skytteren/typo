/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package eph

import java.sql.Connection

trait EphRepo {
  def selectAll(implicit c: Connection): List[EphRow]
  def selectByFieldValues(fieldValues: List[EphFieldOrIdValue[_]])(implicit c: Connection): List[EphRow]
}