/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package poh

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.purchaseorderheader.PurchaseorderheaderId
import adventureworks.purchasing.shipmethod.ShipmethodId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object PohRepoImpl extends PohRepo {
  override def selectAll(implicit c: Connection): List[PohRow] = {
    SQL"""select "id", purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate, shipdate, subtotal, taxamt, freight, modifieddate
          from pu.poh
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PohFieldOrIdValue[_]])(implicit c: Connection): List[PohRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PohFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PohFieldValue.purchaseorderid(value) => NamedParameter("purchaseorderid", ParameterValue.from(value))
          case PohFieldValue.revisionnumber(value) => NamedParameter("revisionnumber", ParameterValue.from(value))
          case PohFieldValue.status(value) => NamedParameter("status", ParameterValue.from(value))
          case PohFieldValue.employeeid(value) => NamedParameter("employeeid", ParameterValue.from(value))
          case PohFieldValue.vendorid(value) => NamedParameter("vendorid", ParameterValue.from(value))
          case PohFieldValue.shipmethodid(value) => NamedParameter("shipmethodid", ParameterValue.from(value))
          case PohFieldValue.orderdate(value) => NamedParameter("orderdate", ParameterValue.from(value))
          case PohFieldValue.shipdate(value) => NamedParameter("shipdate", ParameterValue.from(value))
          case PohFieldValue.subtotal(value) => NamedParameter("subtotal", ParameterValue.from(value))
          case PohFieldValue.taxamt(value) => NamedParameter("taxamt", ParameterValue.from(value))
          case PohFieldValue.freight(value) => NamedParameter("freight", ParameterValue.from(value))
          case PohFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", purchaseorderid, revisionnumber, status, employeeid, vendorid, shipmethodid, orderdate, shipdate, subtotal, taxamt, freight, modifieddate
                    from pu.poh
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[PohRow] =
    RowParser[PohRow] { row =>
      Success(
        PohRow(
          id = row[Option[Int]]("id"),
          purchaseorderid = row[Option[PurchaseorderheaderId]]("purchaseorderid"),
          revisionnumber = row[Option[Int]]("revisionnumber"),
          status = row[Option[Int]]("status"),
          employeeid = row[Option[BusinessentityId]]("employeeid"),
          vendorid = row[Option[BusinessentityId]]("vendorid"),
          shipmethodid = row[Option[ShipmethodId]]("shipmethodid"),
          orderdate = row[Option[LocalDateTime]]("orderdate"),
          shipdate = row[Option[LocalDateTime]]("shipdate"),
          subtotal = row[Option[BigDecimal]]("subtotal"),
          taxamt = row[Option[BigDecimal]]("taxamt"),
          freight = row[Option[BigDecimal]]("freight"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}