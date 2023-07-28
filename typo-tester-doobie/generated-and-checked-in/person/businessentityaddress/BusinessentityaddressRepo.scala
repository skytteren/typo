/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package businessentityaddress

import doobie.free.connection.ConnectionIO
import fs2.Stream

trait BusinessentityaddressRepo {
  def delete(compositeId: BusinessentityaddressId): ConnectionIO[Boolean]
  def insert(unsaved: BusinessentityaddressRow): ConnectionIO[BusinessentityaddressRow]
  def insert(unsaved: BusinessentityaddressRowUnsaved): ConnectionIO[BusinessentityaddressRow]
  def selectAll: Stream[ConnectionIO, BusinessentityaddressRow]
  def selectByFieldValues(fieldValues: List[BusinessentityaddressFieldOrIdValue[_]]): Stream[ConnectionIO, BusinessentityaddressRow]
  def selectById(compositeId: BusinessentityaddressId): ConnectionIO[Option[BusinessentityaddressRow]]
  def update(row: BusinessentityaddressRow): ConnectionIO[Boolean]
  def updateFieldValues(compositeId: BusinessentityaddressId, fieldValues: List[BusinessentityaddressFieldValue[_]]): ConnectionIO[Boolean]
  def upsert(unsaved: BusinessentityaddressRow): ConnectionIO[BusinessentityaddressRow]
}