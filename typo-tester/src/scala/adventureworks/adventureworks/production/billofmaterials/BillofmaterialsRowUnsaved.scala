/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.Defaulted
import adventureworks.production.product.ProductId
import adventureworks.production.unitmeasure.UnitmeasureId
import java.time.LocalDateTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.billofmaterials` which has not been persisted yet */
case class BillofmaterialsRowUnsaved(
  /** Parent product identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"productassemblyid","ordinal_position":2,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  productassemblyid: Option[ProductId],
  /** Component identification number. Foreign key to Product.ProductID.
      Points to [[product.ProductRow.productid]]
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"componentid","ordinal_position":3,"is_nullable":"NO","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  componentid: ProductId,
  /** Default: now()
      Date the component started being used in the assembly item.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"startdate","ordinal_position":4,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  startdate: Defaulted[LocalDateTime],
  /** Date the component stopped being used in the assembly item.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"enddate","ordinal_position":5,"is_nullable":"YES","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  enddate: Option[LocalDateTime],
  /** Standard code identifying the unit of measure for the quantity.
      Points to [[unitmeasure.UnitmeasureRow.unitmeasurecode]]
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"unitmeasurecode","ordinal_position":6,"is_nullable":"NO","data_type":"character","character_maximum_length":3,"character_octet_length":12,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"bpchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  unitmeasurecode: UnitmeasureId,
  /** Indicates the depth the component is from its parent (AssemblyID).
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"bomlevel","ordinal_position":7,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  bomlevel: Int,
  /** Default: 1.00
      Quantity of the component needed to create the assembly.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"perassemblyqty","ordinal_position":8,"column_default":"1.00","is_nullable":"NO","data_type":"numeric","numeric_precision":8,"numeric_precision_radix":10,"numeric_scale":2,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"numeric","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  perassemblyqty: Defaulted[BigDecimal],
  /** Default: now()
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"billofmaterials","column_name":"modifieddate","ordinal_position":9,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(billofmaterialsid: BillofmaterialsId): BillofmaterialsRow =
    BillofmaterialsRow(
      billofmaterialsid = billofmaterialsid,
      productassemblyid = productassemblyid,
      componentid = componentid,
      startdate = startdate match {
                    case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                    case Defaulted.Provided(value) => value
                  },
      enddate = enddate,
      unitmeasurecode = unitmeasurecode,
      bomlevel = bomlevel,
      perassemblyqty = perassemblyqty match {
                         case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                         case Defaulted.Provided(value) => value
                       },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object BillofmaterialsRowUnsaved {
  implicit val oFormat: OFormat[BillofmaterialsRowUnsaved] = new OFormat[BillofmaterialsRowUnsaved]{
    override def writes(o: BillofmaterialsRowUnsaved): JsObject =
      Json.obj(
        "productassemblyid" -> o.productassemblyid,
        "componentid" -> o.componentid,
        "startdate" -> o.startdate,
        "enddate" -> o.enddate,
        "unitmeasurecode" -> o.unitmeasurecode,
        "bomlevel" -> o.bomlevel,
        "perassemblyqty" -> o.perassemblyqty,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[BillofmaterialsRowUnsaved] = {
      JsResult.fromTry(
        Try(
          BillofmaterialsRowUnsaved(
            productassemblyid = json.\("productassemblyid").toOption.map(_.as[ProductId]),
            componentid = json.\("componentid").as[ProductId],
            startdate = json.\("startdate").as[Defaulted[LocalDateTime]],
            enddate = json.\("enddate").toOption.map(_.as[LocalDateTime]),
            unitmeasurecode = json.\("unitmeasurecode").as[UnitmeasureId],
            bomlevel = json.\("bomlevel").as[Int],
            perassemblyqty = json.\("perassemblyqty").as[Defaulted[BigDecimal]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}