/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package productvendor

import adventureworks.Defaulted
import adventureworks.TypoLocalDateTime
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object ProductvendorRepoImpl extends ProductvendorRepo {
  override def delete(compositeId: ProductvendorId)(implicit c: Connection): Boolean = {
    SQL"delete from purchasing.productvendor where productid = ${compositeId.productid} AND businessentityid = ${compositeId.businessentityid}".executeUpdate() > 0
  }
  override def insert(unsaved: ProductvendorRow)(implicit c: Connection): ProductvendorRow = {
    SQL"""insert into purchasing.productvendor(productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate)
          values (${unsaved.productid}::int4, ${unsaved.businessentityid}::int4, ${unsaved.averageleadtime}::int4, ${unsaved.standardprice}::numeric, ${unsaved.lastreceiptcost}::numeric, ${unsaved.lastreceiptdate}::timestamp, ${unsaved.minorderqty}::int4, ${unsaved.maxorderqty}::int4, ${unsaved.onorderqty}::int4, ${unsaved.unitmeasurecode}::bpchar, ${unsaved.modifieddate}::timestamp)
          returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
       """
      .executeInsert(ProductvendorRow.rowParser(1).single)
  
  }
  override def insert(unsaved: ProductvendorRowUnsaved)(implicit c: Connection): ProductvendorRow = {
    val namedParameters = List(
      Some((NamedParameter("productid", ParameterValue.from(unsaved.productid)), "::int4")),
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("averageleadtime", ParameterValue.from(unsaved.averageleadtime)), "::int4")),
      Some((NamedParameter("standardprice", ParameterValue.from(unsaved.standardprice)), "::numeric")),
      Some((NamedParameter("lastreceiptcost", ParameterValue.from(unsaved.lastreceiptcost)), "::numeric")),
      Some((NamedParameter("lastreceiptdate", ParameterValue.from(unsaved.lastreceiptdate)), "::timestamp")),
      Some((NamedParameter("minorderqty", ParameterValue.from(unsaved.minorderqty)), "::int4")),
      Some((NamedParameter("maxorderqty", ParameterValue.from(unsaved.maxorderqty)), "::int4")),
      Some((NamedParameter("onorderqty", ParameterValue.from(unsaved.onorderqty)), "::int4")),
      Some((NamedParameter("unitmeasurecode", ParameterValue.from(unsaved.unitmeasurecode)), "::bpchar")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[TypoLocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into purchasing.productvendor default values
            returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
         """
        .executeInsert(ProductvendorRow.rowParser(1).single)
    } else {
      val q = s"""insert into purchasing.productvendor(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(ProductvendorRow.rowParser(1).single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ProductvendorRow] = {
    SQL"""select productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
          from purchasing.productvendor
       """.as(ProductvendorRow.rowParser(1).*)
  }
  override def selectById(compositeId: ProductvendorId)(implicit c: Connection): Option[ProductvendorRow] = {
    SQL"""select productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
          from purchasing.productvendor
          where productid = ${compositeId.productid} AND businessentityid = ${compositeId.businessentityid}
       """.as(ProductvendorRow.rowParser(1).singleOpt)
  }
  override def update(row: ProductvendorRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update purchasing.productvendor
          set averageleadtime = ${row.averageleadtime}::int4,
              standardprice = ${row.standardprice}::numeric,
              lastreceiptcost = ${row.lastreceiptcost}::numeric,
              lastreceiptdate = ${row.lastreceiptdate}::timestamp,
              minorderqty = ${row.minorderqty}::int4,
              maxorderqty = ${row.maxorderqty}::int4,
              onorderqty = ${row.onorderqty}::int4,
              unitmeasurecode = ${row.unitmeasurecode}::bpchar,
              modifieddate = ${row.modifieddate}::timestamp
          where productid = ${compositeId.productid} AND businessentityid = ${compositeId.businessentityid}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: ProductvendorRow)(implicit c: Connection): ProductvendorRow = {
    SQL"""insert into purchasing.productvendor(productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate)
          values (
            ${unsaved.productid}::int4,
            ${unsaved.businessentityid}::int4,
            ${unsaved.averageleadtime}::int4,
            ${unsaved.standardprice}::numeric,
            ${unsaved.lastreceiptcost}::numeric,
            ${unsaved.lastreceiptdate}::timestamp,
            ${unsaved.minorderqty}::int4,
            ${unsaved.maxorderqty}::int4,
            ${unsaved.onorderqty}::int4,
            ${unsaved.unitmeasurecode}::bpchar,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productid, businessentityid)
          do update set
            averageleadtime = EXCLUDED.averageleadtime,
            standardprice = EXCLUDED.standardprice,
            lastreceiptcost = EXCLUDED.lastreceiptcost,
            lastreceiptdate = EXCLUDED.lastreceiptdate,
            minorderqty = EXCLUDED.minorderqty,
            maxorderqty = EXCLUDED.maxorderqty,
            onorderqty = EXCLUDED.onorderqty,
            unitmeasurecode = EXCLUDED.unitmeasurecode,
            modifieddate = EXCLUDED.modifieddate
          returning productid, businessentityid, averageleadtime, standardprice, lastreceiptcost, lastreceiptdate::text, minorderqty, maxorderqty, onorderqty, unitmeasurecode, modifieddate::text
       """
      .executeInsert(ProductvendorRow.rowParser(1).single)
  
  }
}
