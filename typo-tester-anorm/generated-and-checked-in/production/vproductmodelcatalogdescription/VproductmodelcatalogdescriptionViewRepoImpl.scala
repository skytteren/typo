/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package vproductmodelcatalogdescription

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object VproductmodelcatalogdescriptionViewRepoImpl extends VproductmodelcatalogdescriptionViewRepo {
  override def selectAll(implicit c: Connection): List[VproductmodelcatalogdescriptionViewRow] = {
    SQL"""select productmodelid, "name", Summary, manufacturer, copyright, producturl, warrantyperiod, warrantydescription, noofyears, maintenancedescription, wheel, saddle, pedal, bikeframe, crankset, pictureangle, picturesize, productphotoid, material, color, productline, "style", riderexperience, rowguid, modifieddate
          from production.vproductmodelcatalogdescription
       """.as(VproductmodelcatalogdescriptionViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[VproductmodelcatalogdescriptionViewFieldOrIdValue[_]])(implicit c: Connection): List[VproductmodelcatalogdescriptionViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VproductmodelcatalogdescriptionViewFieldValue.productmodelid(value) => NamedParameter("productmodelid", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.Summary(value) => NamedParameter("Summary", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.manufacturer(value) => NamedParameter("manufacturer", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.copyright(value) => NamedParameter("copyright", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.producturl(value) => NamedParameter("producturl", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.warrantyperiod(value) => NamedParameter("warrantyperiod", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.warrantydescription(value) => NamedParameter("warrantydescription", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.noofyears(value) => NamedParameter("noofyears", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.maintenancedescription(value) => NamedParameter("maintenancedescription", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.wheel(value) => NamedParameter("wheel", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.saddle(value) => NamedParameter("saddle", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.pedal(value) => NamedParameter("pedal", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.bikeframe(value) => NamedParameter("bikeframe", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.crankset(value) => NamedParameter("crankset", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.pictureangle(value) => NamedParameter("pictureangle", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.picturesize(value) => NamedParameter("picturesize", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.productphotoid(value) => NamedParameter("productphotoid", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.material(value) => NamedParameter("material", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.color(value) => NamedParameter("color", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.productline(value) => NamedParameter("productline", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.style(value) => NamedParameter("style", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.riderexperience(value) => NamedParameter("riderexperience", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case VproductmodelcatalogdescriptionViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select productmodelid, "name", Summary, manufacturer, copyright, producturl, warrantyperiod, warrantydescription, noofyears, maintenancedescription, wheel, saddle, pedal, bikeframe, crankset, pictureangle, picturesize, productphotoid, material, color, productline, "style", riderexperience, rowguid, modifieddate
                    from production.vproductmodelcatalogdescription
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(VproductmodelcatalogdescriptionViewRow.rowParser(1).*)
    }
  
  }
}