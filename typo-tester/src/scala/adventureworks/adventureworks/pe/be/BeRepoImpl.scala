/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package be

import adventureworks.person.businessentity.BusinessentityId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object BeRepoImpl extends BeRepo {
  override def selectAll(implicit c: Connection): List[BeRow] = {
    SQL"select id, businessentityid, rowguid, modifieddate from pe.be".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[BeFieldOrIdValue[_]])(implicit c: Connection): List[BeRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case BeFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case BeFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case BeFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case BeFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from pe.be where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[BeRow] =
    RowParser[BeRow] { row =>
      Success(
        BeRow(
          id = row[Option[Int]]("id"),
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          rowguid = row[Option[UUID]]("rowguid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}
