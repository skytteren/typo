/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package bom

import adventureworks.production.billofmaterials.BillofmaterialsId
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object BomRepoImpl extends BomRepo {
  override def selectAll(implicit c: Connection): List[BomRow] = {
    SQL"select id, billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate from pr.bom".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[BomFieldOrIdValue[_]])(implicit c: Connection): List[BomRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case BomFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case BomFieldValue.billofmaterialsid(value) => NamedParameter("billofmaterialsid", ParameterValue.from(value))
          case BomFieldValue.productassemblyid(value) => NamedParameter("productassemblyid", ParameterValue.from(value))
          case BomFieldValue.componentid(value) => NamedParameter("componentid", ParameterValue.from(value))
          case BomFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case BomFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case BomFieldValue.unitmeasurecode(value) => NamedParameter("unitmeasurecode", ParameterValue.from(value))
          case BomFieldValue.bomlevel(value) => NamedParameter("bomlevel", ParameterValue.from(value))
          case BomFieldValue.perassemblyqty(value) => NamedParameter("perassemblyqty", ParameterValue.from(value))
          case BomFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from pr.bom where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[BomRow] =
    RowParser[BomRow] { row =>
      Success(
        BomRow(
          id = row[Option[Int]]("id"),
          billofmaterialsid = row[Option[BillofmaterialsId]]("billofmaterialsid"),
          productassemblyid = row[Option[ProductId]]("productassemblyid"),
          componentid = row[Option[ProductId]]("componentid"),
          startdate = row[Option[LocalDateTime]]("startdate"),
          enddate = row[Option[LocalDateTime]]("enddate"),
          unitmeasurecode = row[Option[UnitmeasureId]]("unitmeasurecode"),
          bomlevel = row[Option[Int]]("bomlevel"),
          perassemblyqty = row[Option[BigDecimal]]("perassemblyqty"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}
