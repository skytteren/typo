/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import java.sql.Connection

class MaritalStatusRepoMock(map: scala.collection.mutable.Map[MaritalStatusId, MaritalStatusRow] = scala.collection.mutable.Map.empty) extends MaritalStatusRepo {
  override def delete(id: MaritalStatusId)(implicit c: Connection): Boolean = {
    map.remove(id).isDefined
  }
  override def insert(unsaved: MaritalStatusRow)(implicit c: Connection): MaritalStatusRow = {
    if (map.contains(unsaved.id))
      sys.error(s"id ${unsaved.id} already exists")
    else
      map.put(unsaved.id, unsaved)
    unsaved
  }
  override def selectAll(implicit c: Connection): List[MaritalStatusRow] = {
    map.values.toList
  }
  override def selectByFieldValues(fieldValues: List[MaritalStatusFieldOrIdValue[_]])(implicit c: Connection): List[MaritalStatusRow] = {
    fieldValues.foldLeft(map.values) {
      case (acc, MaritalStatusFieldValue.id(value)) => acc.filter(_.id == value)
    }.toList
  }
  override def selectById(id: MaritalStatusId)(implicit c: Connection): Option[MaritalStatusRow] = {
    map.get(id)
  }
  override def selectByIds(ids: Array[MaritalStatusId])(implicit c: Connection): List[MaritalStatusRow] = {
    ids.flatMap(map.get).toList
  }
}