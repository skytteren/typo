/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package customer

import java.sql.Connection

class CustomerRepoMock(toRow: Function1[CustomerRowUnsaved, CustomerRow],
                       map: scala.collection.mutable.Map[CustomerId, CustomerRow] = scala.collection.mutable.Map.empty) extends CustomerRepo {
  override def delete(customerid: CustomerId)(implicit c: Connection): Boolean = {
    map.remove(customerid).isDefined
  }
  override def insert(unsaved: CustomerRow)(implicit c: Connection): CustomerRow = {
    if (map.contains(unsaved.customerid))
      sys.error(s"id ${unsaved.customerid} already exists")
    else
      map.put(unsaved.customerid, unsaved)
    unsaved
  }
  override def insert(unsaved: CustomerRowUnsaved)(implicit c: Connection): CustomerRow = {
    insert(toRow(unsaved))
  }
  override def selectAll(implicit c: Connection): List[CustomerRow] = {
    map.values.toList
  }
  override def selectByFieldValues(fieldValues: List[CustomerFieldOrIdValue[_]])(implicit c: Connection): List[CustomerRow] = {
    fieldValues.foldLeft(map.values) {
      case (acc, CustomerFieldValue.customerid(value)) => acc.filter(_.customerid == value)
      case (acc, CustomerFieldValue.personid(value)) => acc.filter(_.personid == value)
      case (acc, CustomerFieldValue.storeid(value)) => acc.filter(_.storeid == value)
      case (acc, CustomerFieldValue.territoryid(value)) => acc.filter(_.territoryid == value)
      case (acc, CustomerFieldValue.rowguid(value)) => acc.filter(_.rowguid == value)
      case (acc, CustomerFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
    }.toList
  }
  override def selectById(customerid: CustomerId)(implicit c: Connection): Option[CustomerRow] = {
    map.get(customerid)
  }
  override def selectByIds(customerids: Array[CustomerId])(implicit c: Connection): List[CustomerRow] = {
    customerids.flatMap(map.get).toList
  }
  override def update(row: CustomerRow)(implicit c: Connection): Boolean = {
    map.get(row.customerid) match {
      case Some(`row`) => false
      case Some(_) =>
        map.put(row.customerid, row)
        true
      case None => false
    }
  }
  override def updateFieldValues(customerid: CustomerId, fieldValues: List[CustomerFieldValue[_]])(implicit c: Connection): Boolean = {
    map.get(customerid) match {
      case Some(oldRow) =>
        val updatedRow = fieldValues.foldLeft(oldRow) {
          case (acc, CustomerFieldValue.personid(value)) => acc.copy(personid = value)
          case (acc, CustomerFieldValue.storeid(value)) => acc.copy(storeid = value)
          case (acc, CustomerFieldValue.territoryid(value)) => acc.copy(territoryid = value)
          case (acc, CustomerFieldValue.rowguid(value)) => acc.copy(rowguid = value)
          case (acc, CustomerFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
        }
        if (updatedRow != oldRow) {
          map.put(customerid, updatedRow)
          true
        } else {
          false
        }
      case None => false
    }
  }
  override def upsert(unsaved: CustomerRow)(implicit c: Connection): CustomerRow = {
    map.put(unsaved.customerid, unsaved)
    unsaved
  }
}