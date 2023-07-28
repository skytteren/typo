/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object MaritalStatusRepoImpl extends MaritalStatusRepo {
  override def delete(id: MaritalStatusId): ConnectionIO[Boolean] = {
    sql"""delete from myschema.marital_status where "id" = ${id}""".update.run.map(_ > 0)
  }
  override def insert(unsaved: MaritalStatusRow): ConnectionIO[MaritalStatusRow] = {
    sql"""insert into myschema.marital_status("id")
          values (${unsaved.id}::int8)
          returning "id"
       """.query[MaritalStatusRow].unique
  }
  override def selectAll: Stream[ConnectionIO, MaritalStatusRow] = {
    sql"""select "id" from myschema.marital_status""".query[MaritalStatusRow].stream
  }
  override def selectById(id: MaritalStatusId): ConnectionIO[Option[MaritalStatusRow]] = {
    sql"""select "id" from myschema.marital_status where "id" = ${id}""".query[MaritalStatusRow].option
  }
  override def selectByIds(ids: Array[MaritalStatusId]): Stream[ConnectionIO, MaritalStatusRow] = {
    sql"""select "id" from myschema.marital_status where "id" = ANY(${ids})""".query[MaritalStatusRow].stream
  }
  override def upsert(unsaved: MaritalStatusRow): ConnectionIO[MaritalStatusRow] = {
    sql"""insert into myschema.marital_status("id")
          values (
            ${unsaved.id}::int8
          )
          on conflict ("id")
          do update set
            
          returning "id"
       """.query[MaritalStatusRow].unique
  }
}
