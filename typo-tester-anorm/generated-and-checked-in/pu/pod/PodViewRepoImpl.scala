/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pu
package pod

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object PodViewRepoImpl extends PodViewRepo {
  override def selectAll(implicit c: Connection): List[PodViewRow] = {
    SQL"""select "id", purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate
          from pu.pod
       """.as(PodViewRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PodViewFieldOrIdValue[_]])(implicit c: Connection): List[PodViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PodViewFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PodViewFieldValue.purchaseorderid(value) => NamedParameter("purchaseorderid", ParameterValue.from(value))
          case PodViewFieldValue.purchaseorderdetailid(value) => NamedParameter("purchaseorderdetailid", ParameterValue.from(value))
          case PodViewFieldValue.duedate(value) => NamedParameter("duedate", ParameterValue.from(value))
          case PodViewFieldValue.orderqty(value) => NamedParameter("orderqty", ParameterValue.from(value))
          case PodViewFieldValue.productid(value) => NamedParameter("productid", ParameterValue.from(value))
          case PodViewFieldValue.unitprice(value) => NamedParameter("unitprice", ParameterValue.from(value))
          case PodViewFieldValue.receivedqty(value) => NamedParameter("receivedqty", ParameterValue.from(value))
          case PodViewFieldValue.rejectedqty(value) => NamedParameter("rejectedqty", ParameterValue.from(value))
          case PodViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", purchaseorderid, purchaseorderdetailid, duedate, orderqty, productid, unitprice, receivedqty, rejectedqty, modifieddate
                    from pu.pod
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PodViewRow.rowParser.*)
    }
  
  }
}
