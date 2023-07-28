/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package location

import doobie.free.connection.ConnectionIO
import doobie.free.connection.delay
import fs2.Stream

class LocationRepoMock(toRow: Function1[LocationRowUnsaved, LocationRow],
                       map: scala.collection.mutable.Map[LocationId, LocationRow] = scala.collection.mutable.Map.empty) extends LocationRepo {
  override def delete(locationid: LocationId): ConnectionIO[Boolean] = {
    delay(map.remove(locationid).isDefined)
  }
  override def insert(unsaved: LocationRow): ConnectionIO[LocationRow] = {
    delay {
      if (map.contains(unsaved.locationid))
        sys.error(s"id ${unsaved.locationid} already exists")
      else
        map.put(unsaved.locationid, unsaved)
      unsaved
    }
  }
  override def insert(unsaved: LocationRowUnsaved): ConnectionIO[LocationRow] = {
    insert(toRow(unsaved))
  }
  override def selectAll: Stream[ConnectionIO, LocationRow] = {
    Stream.emits(map.values.toList)
  }
  override def selectByFieldValues(fieldValues: List[LocationFieldOrIdValue[_]]): Stream[ConnectionIO, LocationRow] = {
    Stream.emits {
      fieldValues.foldLeft(map.values) {
        case (acc, LocationFieldValue.locationid(value)) => acc.filter(_.locationid == value)
        case (acc, LocationFieldValue.name(value)) => acc.filter(_.name == value)
        case (acc, LocationFieldValue.costrate(value)) => acc.filter(_.costrate == value)
        case (acc, LocationFieldValue.availability(value)) => acc.filter(_.availability == value)
        case (acc, LocationFieldValue.modifieddate(value)) => acc.filter(_.modifieddate == value)
      }.toList
    }
  }
  override def selectById(locationid: LocationId): ConnectionIO[Option[LocationRow]] = {
    delay(map.get(locationid))
  }
  override def selectByIds(locationids: Array[LocationId]): Stream[ConnectionIO, LocationRow] = {
    Stream.emits(locationids.flatMap(map.get).toList)
  }
  override def update(row: LocationRow): ConnectionIO[Boolean] = {
    delay {
      map.get(row.locationid) match {
        case Some(`row`) => false
        case Some(_) =>
          map.put(row.locationid, row)
          true
        case None => false
      }
    }
  }
  override def updateFieldValues(locationid: LocationId, fieldValues: List[LocationFieldValue[_]]): ConnectionIO[Boolean] = {
    delay {
      map.get(locationid) match {
        case Some(oldRow) =>
          val updatedRow = fieldValues.foldLeft(oldRow) {
            case (acc, LocationFieldValue.name(value)) => acc.copy(name = value)
            case (acc, LocationFieldValue.costrate(value)) => acc.copy(costrate = value)
            case (acc, LocationFieldValue.availability(value)) => acc.copy(availability = value)
            case (acc, LocationFieldValue.modifieddate(value)) => acc.copy(modifieddate = value)
          }
          if (updatedRow != oldRow) {
            map.put(locationid, updatedRow)
            true
          } else {
            false
          }
        case None => false
      }
    }
  }
  override def upsert(unsaved: LocationRow): ConnectionIO[LocationRow] = {
    delay {
      map.put(unsaved.locationid, unsaved)
      unsaved
    }
  }
}