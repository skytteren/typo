/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package purchaseorderheader

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.purchasing.shipmethod.ShipmethodId
import adventureworks.streamingInsert
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class PurchaseorderheaderRepoImpl extends PurchaseorderheaderRepo {
  override def delete: DeleteBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    DeleteBuilder("purchasing.purchaseorderheader", PurchaseorderheaderFields.structure)
  }
  override def deleteById(purchaseorderid: PurchaseorderheaderId)(implicit c: Connection): Boolean = {
    SQL"""delete from purchasing.purchaseorderheader where "purchaseorderid" = ${ParameterValue(purchaseorderid, null, PurchaseorderheaderId.toStatement)}""".executeUpdate() > 0
  }
  override def deleteByIds(purchaseorderids: Array[PurchaseorderheaderId])(implicit c: Connection): Int = {
    SQL"""delete
          from purchasing.purchaseorderheader
          where "purchaseorderid" = ANY(${purchaseorderids})
       """.executeUpdate()
    
  }
  override def insert(unsaved: PurchaseorderheaderRow)(implicit c: Connection): PurchaseorderheaderRow = {
    SQL"""insert into purchasing.purchaseorderheader("purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")
          values (${ParameterValue(unsaved.purchaseorderid, null, PurchaseorderheaderId.toStatement)}::int4, ${ParameterValue(unsaved.revisionnumber, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.status, null, TypoShort.toStatement)}::int2, ${ParameterValue(unsaved.employeeid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.vendorid, null, BusinessentityId.toStatement)}::int4, ${ParameterValue(unsaved.shipmethodid, null, ShipmethodId.toStatement)}::int4, ${ParameterValue(unsaved.orderdate, null, TypoLocalDateTime.toStatement)}::timestamp, ${ParameterValue(unsaved.shipdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp, ${ParameterValue(unsaved.subtotal, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.taxamt, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.freight, null, ToStatement.scalaBigDecimalToStatement)}::numeric, ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp)
          returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
       """
      .executeInsert(PurchaseorderheaderRow.rowParser(1).single)
    
  }
  override def insert(unsaved: PurchaseorderheaderRowUnsaved)(implicit c: Connection): PurchaseorderheaderRow = {
    val namedParameters = List(
      Some((NamedParameter("employeeid", ParameterValue(unsaved.employeeid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("vendorid", ParameterValue(unsaved.vendorid, null, BusinessentityId.toStatement)), "::int4")),
      Some((NamedParameter("shipmethodid", ParameterValue(unsaved.shipmethodid, null, ShipmethodId.toStatement)), "::int4")),
      Some((NamedParameter("shipdate", ParameterValue(unsaved.shipdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))), "::timestamp")),
      unsaved.purchaseorderid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("purchaseorderid", ParameterValue(value, null, PurchaseorderheaderId.toStatement)), "::int4"))
      },
      unsaved.revisionnumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("revisionnumber", ParameterValue(value, null, TypoShort.toStatement)), "::int2"))
      },
      unsaved.status match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("status", ParameterValue(value, null, TypoShort.toStatement)), "::int2"))
      },
      unsaved.orderdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("orderdate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      },
      unsaved.subtotal match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("subtotal", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.taxamt match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("taxamt", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.freight match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("freight", ParameterValue(value, null, ToStatement.scalaBigDecimalToStatement)), "::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue(value, null, TypoLocalDateTime.toStatement)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into purchasing.purchaseorderheader default values
            returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
         """
        .executeInsert(PurchaseorderheaderRow.rowParser(1).single)
    } else {
      val q = s"""insert into purchasing.purchaseorderheader(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(PurchaseorderheaderRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[PurchaseorderheaderRow], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY purchasing.purchaseorderheader("purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate") FROM STDIN""", batchSize, unsaved)(PurchaseorderheaderRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[PurchaseorderheaderRowUnsaved], batchSize: Int)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY purchasing.purchaseorderheader("employeeid", "vendorid", "shipmethodid", "shipdate", "purchaseorderid", "revisionnumber", "status", "orderdate", "subtotal", "taxamt", "freight", "modifieddate") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PurchaseorderheaderRowUnsaved.text, c)
  }
  override def select: SelectBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    SelectBuilderSql("purchasing.purchaseorderheader", PurchaseorderheaderFields.structure, PurchaseorderheaderRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PurchaseorderheaderRow] = {
    SQL"""select "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
          from purchasing.purchaseorderheader
       """.as(PurchaseorderheaderRow.rowParser(1).*)
  }
  override def selectById(purchaseorderid: PurchaseorderheaderId)(implicit c: Connection): Option[PurchaseorderheaderRow] = {
    SQL"""select "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
          from purchasing.purchaseorderheader
          where "purchaseorderid" = ${ParameterValue(purchaseorderid, null, PurchaseorderheaderId.toStatement)}
       """.as(PurchaseorderheaderRow.rowParser(1).singleOpt)
  }
  override def selectByIds(purchaseorderids: Array[PurchaseorderheaderId])(implicit c: Connection): List[PurchaseorderheaderRow] = {
    SQL"""select "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
          from purchasing.purchaseorderheader
          where "purchaseorderid" = ANY(${purchaseorderids})
       """.as(PurchaseorderheaderRow.rowParser(1).*)
    
  }
  override def update: UpdateBuilder[PurchaseorderheaderFields, PurchaseorderheaderRow] = {
    UpdateBuilder("purchasing.purchaseorderheader", PurchaseorderheaderFields.structure, PurchaseorderheaderRow.rowParser)
  }
  override def update(row: PurchaseorderheaderRow)(implicit c: Connection): Boolean = {
    val purchaseorderid = row.purchaseorderid
    SQL"""update purchasing.purchaseorderheader
          set "revisionnumber" = ${ParameterValue(row.revisionnumber, null, TypoShort.toStatement)}::int2,
              "status" = ${ParameterValue(row.status, null, TypoShort.toStatement)}::int2,
              "employeeid" = ${ParameterValue(row.employeeid, null, BusinessentityId.toStatement)}::int4,
              "vendorid" = ${ParameterValue(row.vendorid, null, BusinessentityId.toStatement)}::int4,
              "shipmethodid" = ${ParameterValue(row.shipmethodid, null, ShipmethodId.toStatement)}::int4,
              "orderdate" = ${ParameterValue(row.orderdate, null, TypoLocalDateTime.toStatement)}::timestamp,
              "shipdate" = ${ParameterValue(row.shipdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
              "subtotal" = ${ParameterValue(row.subtotal, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "taxamt" = ${ParameterValue(row.taxamt, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "freight" = ${ParameterValue(row.freight, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
              "modifieddate" = ${ParameterValue(row.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          where "purchaseorderid" = ${ParameterValue(purchaseorderid, null, PurchaseorderheaderId.toStatement)}
       """.executeUpdate() > 0
  }
  override def upsert(unsaved: PurchaseorderheaderRow)(implicit c: Connection): PurchaseorderheaderRow = {
    SQL"""insert into purchasing.purchaseorderheader("purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate", "shipdate", "subtotal", "taxamt", "freight", "modifieddate")
          values (
            ${ParameterValue(unsaved.purchaseorderid, null, PurchaseorderheaderId.toStatement)}::int4,
            ${ParameterValue(unsaved.revisionnumber, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.status, null, TypoShort.toStatement)}::int2,
            ${ParameterValue(unsaved.employeeid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.vendorid, null, BusinessentityId.toStatement)}::int4,
            ${ParameterValue(unsaved.shipmethodid, null, ShipmethodId.toStatement)}::int4,
            ${ParameterValue(unsaved.orderdate, null, TypoLocalDateTime.toStatement)}::timestamp,
            ${ParameterValue(unsaved.shipdate, null, ToStatement.optionToStatement(TypoLocalDateTime.toStatement, TypoLocalDateTime.parameterMetadata))}::timestamp,
            ${ParameterValue(unsaved.subtotal, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.taxamt, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.freight, null, ToStatement.scalaBigDecimalToStatement)}::numeric,
            ${ParameterValue(unsaved.modifieddate, null, TypoLocalDateTime.toStatement)}::timestamp
          )
          on conflict ("purchaseorderid")
          do update set
            "revisionnumber" = EXCLUDED."revisionnumber",
            "status" = EXCLUDED."status",
            "employeeid" = EXCLUDED."employeeid",
            "vendorid" = EXCLUDED."vendorid",
            "shipmethodid" = EXCLUDED."shipmethodid",
            "orderdate" = EXCLUDED."orderdate",
            "shipdate" = EXCLUDED."shipdate",
            "subtotal" = EXCLUDED."subtotal",
            "taxamt" = EXCLUDED."taxamt",
            "freight" = EXCLUDED."freight",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "purchaseorderid", "revisionnumber", "status", "employeeid", "vendorid", "shipmethodid", "orderdate"::text, "shipdate"::text, "subtotal", "taxamt", "freight", "modifieddate"::text
       """
      .executeInsert(PurchaseorderheaderRow.rowParser(1).single)
    
  }
}
