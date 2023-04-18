/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pd

import adventureworks.production.productdescription.ProductdescriptionId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object PdRepoImpl extends PdRepo {
  override def selectAll(implicit c: Connection): List[PdRow] = {
    SQL"""select id, productdescriptionid, description, rowguid, modifieddate from pr.pd""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PdFieldOrIdValue[_]])(implicit c: Connection): List[PdRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PdFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PdFieldValue.productdescriptionid(value) => NamedParameter("productdescriptionid", ParameterValue.from(value))
          case PdFieldValue.description(value) => NamedParameter("description", ParameterValue.from(value))
          case PdFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case PdFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from pr.pd where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[PdRow] =
    RowParser[PdRow] { row =>
      Success(
        PdRow(
          id = row[Option[Int]]("id"),
          productdescriptionid = row[Option[ProductdescriptionId]]("productdescriptionid"),
          description = row[Option[String]]("description"),
          rowguid = row[Option[UUID]]("rowguid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}