/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productinventory

import adventureworks.Defaulted
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

/** This class corresponds to a row in table `production.productinventory` which has not been persisted yet */
case class ProductinventoryRowUnsaved(
  /** Storage compartment within an inventory location.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"productinventory","column_name":"shelf","ordinal_position":3,"is_nullable":"NO","data_type":"character varying","character_maximum_length":10,"character_octet_length":40,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  shelf: String,
  /** Storage container on a shelf in an inventory location.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"productinventory","column_name":"bin","ordinal_position":4,"is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  bin: Int,
  /** Default: 0
      Quantity of products in the inventory location.
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"productinventory","column_name":"quantity","ordinal_position":5,"column_default":"0","is_nullable":"NO","data_type":"smallint","numeric_precision":16,"numeric_precision_radix":2,"numeric_scale":0,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"int2","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  quantity: Defaulted[Int],
  /** Default: uuid_generate_v1()
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"productinventory","column_name":"rowguid","ordinal_position":6,"column_default":"uuid_generate_v1()","is_nullable":"NO","data_type":"uuid","udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"uuid","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  rowguid: Defaulted[UUID],
  /** Default: now()
      debug: {"table_catalog":"Adventureworks","table_schema":"production","table_name":"productinventory","column_name":"modifieddate","ordinal_position":7,"column_default":"now()","is_nullable":"NO","data_type":"timestamp without time zone","datetime_precision":6,"udt_catalog":"Adventureworks","udt_schema":"pg_catalog","udt_name":"timestamp","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"YES"} */
  modifieddate: Defaulted[LocalDateTime]
) {
  def unsafeToRow(compositeId: ProductinventoryId): ProductinventoryRow =
    ProductinventoryRow(
      productid = compositeId.productid,
      locationid = compositeId.locationid,
      shelf = shelf,
      bin = bin,
      quantity = quantity match {
                   case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                   case Defaulted.Provided(value) => value
                 },
      rowguid = rowguid match {
                  case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                  case Defaulted.Provided(value) => value
                },
      modifieddate = modifieddate match {
                       case Defaulted.UseDefault => sys.error("cannot produce row when you depend on a value which is defaulted in database")
                       case Defaulted.Provided(value) => value
                     }
    )
}
object ProductinventoryRowUnsaved {
  implicit val oFormat: OFormat[ProductinventoryRowUnsaved] = new OFormat[ProductinventoryRowUnsaved]{
    override def writes(o: ProductinventoryRowUnsaved): JsObject =
      Json.obj(
        "shelf" -> o.shelf,
        "bin" -> o.bin,
        "quantity" -> o.quantity,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ProductinventoryRowUnsaved] = {
      JsResult.fromTry(
        Try(
          ProductinventoryRowUnsaved(
            shelf = json.\("shelf").as[String],
            bin = json.\("bin").as[Int],
            quantity = json.\("quantity").as[Defaulted[Int]],
            rowguid = json.\("rowguid").as[Defaulted[UUID]],
            modifieddate = json.\("modifieddate").as[Defaulted[LocalDateTime]]
          )
        )
      )
    }
  }
}