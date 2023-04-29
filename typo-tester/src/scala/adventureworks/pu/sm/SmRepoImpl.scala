/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package sm

import adventureworks.public.Name
import adventureworks.purchasing.shipmethod.ShipmethodId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object SmRepoImpl extends SmRepo {
  override def selectAll(implicit c: Connection): List[SmRow] = {
    SQL"""select "id", shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
          from pu.sm
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SmFieldOrIdValue[_]])(implicit c: Connection): List[SmRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SmFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case SmFieldValue.shipmethodid(value) => NamedParameter("shipmethodid", ParameterValue.from(value))
          case SmFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case SmFieldValue.shipbase(value) => NamedParameter("shipbase", ParameterValue.from(value))
          case SmFieldValue.shiprate(value) => NamedParameter("shiprate", ParameterValue.from(value))
          case SmFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SmFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", shipmethodid, "name", shipbase, shiprate, rowguid, modifieddate
                    from pu.sm
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[SmRow] =
    RowParser[SmRow] { row =>
      Success(
        SmRow(
          id = row[Option[Int]]("id"),
          shipmethodid = row[Option[ShipmethodId]]("shipmethodid"),
          name = row[Option[Name]]("name"),
          shipbase = row[Option[BigDecimal]]("shipbase"),
          shiprate = row[Option[BigDecimal]]("shiprate"),
          rowguid = row[Option[UUID]]("rowguid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}
