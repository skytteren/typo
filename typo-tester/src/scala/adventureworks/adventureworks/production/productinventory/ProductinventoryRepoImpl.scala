/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.Defaulted
import adventureworks.production.location.LocationId
import adventureworks.production.product.ProductId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object ProductinventoryRepoImpl extends ProductinventoryRepo {
  override def delete(compositeId: ProductinventoryId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productinventory where productid = ${compositeId.productid}, locationid = ${compositeId.locationid}".executeUpdate() > 0
  }
  override def insert(compositeId: ProductinventoryId, unsaved: ProductinventoryRowUnsaved)(implicit c: Connection): Boolean = {
    val namedParameters = List(
      Some(NamedParameter("shelf", ParameterValue.from(unsaved.shelf))),
      Some(NamedParameter("bin", ParameterValue.from(unsaved.bin))),
      unsaved.quantity match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("quantity", ParameterValue.from[Int](value)))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("rowguid", ParameterValue.from[UUID](value)))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.productinventory(productid, locationid, ${namedParameters.map(_.name).mkString(", ")})
          values (${compositeId.productid}, ${compositeId.locationid}, ${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
    """
      .on(namedParameters :_*)
      .execute()
  
  }
  override def selectAll(implicit c: Connection): List[ProductinventoryRow] = {
    SQL"select productid, locationid, shelf, bin, quantity, rowguid, modifieddate from production.productinventory".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ProductinventoryFieldOrIdValue[_]])(implicit c: Connection): List[ProductinventoryRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductinventoryFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case ProductinventoryFieldValue.locationid(value) => NamedParameter("locationid", ParameterValue.from(value))
          case ProductinventoryFieldValue.shelf(value) => NamedParameter("shelf", ParameterValue.from(value))
          case ProductinventoryFieldValue.bin(value) => NamedParameter("bin", ParameterValue.from(value))
          case ProductinventoryFieldValue.quantity(value) => NamedParameter("quantity", ParameterValue.from(value))
          case ProductinventoryFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductinventoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from production.productinventory where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: ProductinventoryId)(implicit c: Connection): Option[ProductinventoryRow] = {
    SQL"select productid, locationid, shelf, bin, quantity, rowguid, modifieddate from production.productinventory where productid = ${compositeId.productid}, locationid = ${compositeId.locationid}".as(rowParser.singleOpt)
  }
  override def update(row: ProductinventoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update production.productinventory
          set shelf = ${row.shelf},
              bin = ${row.bin},
              quantity = ${row.quantity},
              rowguid = ${row.rowguid},
              modifieddate = ${row.modifieddate}
          where productid = ${compositeId.productid}, locationid = ${compositeId.locationid}""".executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: ProductinventoryId, fieldValues: List[ProductinventoryFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductinventoryFieldValue.shelf(value) => NamedParameter("shelf", ParameterValue.from(value))
          case ProductinventoryFieldValue.bin(value) => NamedParameter("bin", ParameterValue.from(value))
          case ProductinventoryFieldValue.quantity(value) => NamedParameter("quantity", ParameterValue.from(value))
          case ProductinventoryFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductinventoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.productinventory
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where productid = ${compositeId.productid}, locationid = ${compositeId.locationid}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ProductinventoryRow] =
    RowParser[ProductinventoryRow] { row =>
      Success(
        ProductinventoryRow(
          productid = row[ProductId]("productid"),
          locationid = row[LocationId]("locationid"),
          shelf = row[String]("shelf"),
          bin = row[Int]("bin"),
          quantity = row[Int]("quantity"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[ProductinventoryId] =
    RowParser[ProductinventoryId] { row =>
      Success(
        ProductinventoryId(
          productid = row[ProductId]("productid"),
          locationid = row[LocationId]("locationid")
        )
      )
    }
}
