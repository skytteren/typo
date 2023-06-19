/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package salespersonquotahistory

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object SalespersonquotahistoryRepoImpl extends SalespersonquotahistoryRepo {
  override def delete(compositeId: SalespersonquotahistoryId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.salespersonquotahistory where businessentityid = ${compositeId.businessentityid} AND quotadate = ${compositeId.quotadate}".executeUpdate() > 0
  }
  override def insert(unsaved: SalespersonquotahistoryRow)(implicit c: Connection): SalespersonquotahistoryRow = {
    SQL"""insert into sales.salespersonquotahistory(businessentityid, quotadate, salesquota, rowguid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.quotadate}::timestamp, ${unsaved.salesquota}::numeric, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, quotadate, salesquota, rowguid, modifieddate
       """
      .executeInsert(SalespersonquotahistoryRow.rowParser.single)
  
  }
  override def insert(unsaved: SalespersonquotahistoryRowUnsaved)(implicit c: Connection): SalespersonquotahistoryRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("quotadate", ParameterValue.from(unsaved.quotadate)), "::timestamp")),
      Some((NamedParameter("salesquota", ParameterValue.from(unsaved.salesquota)), "::numeric")),
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("rowguid", ParameterValue.from[UUID](value)), "::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.salespersonquotahistory default values
            returning businessentityid, quotadate, salesquota, rowguid, modifieddate
         """
        .executeInsert(SalespersonquotahistoryRow.rowParser.single)
    } else {
      val q = s"""insert into sales.salespersonquotahistory(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, quotadate, salesquota, rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(SalespersonquotahistoryRow.rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[SalespersonquotahistoryRow] = {
    SQL"""select businessentityid, quotadate, salesquota, rowguid, modifieddate
          from sales.salespersonquotahistory
       """.as(SalespersonquotahistoryRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[SalespersonquotahistoryFieldOrIdValue[_]])(implicit c: Connection): List[SalespersonquotahistoryRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalespersonquotahistoryFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case SalespersonquotahistoryFieldValue.quotadate(value) => NamedParameter("quotadate", ParameterValue.from(value))
          case SalespersonquotahistoryFieldValue.salesquota(value) => NamedParameter("salesquota", ParameterValue.from(value))
          case SalespersonquotahistoryFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SalespersonquotahistoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select businessentityid, quotadate, salesquota, rowguid, modifieddate
                    from sales.salespersonquotahistory
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(SalespersonquotahistoryRow.rowParser.*)
    }
  
  }
  override def selectById(compositeId: SalespersonquotahistoryId)(implicit c: Connection): Option[SalespersonquotahistoryRow] = {
    SQL"""select businessentityid, quotadate, salesquota, rowguid, modifieddate
          from sales.salespersonquotahistory
          where businessentityid = ${compositeId.businessentityid} AND quotadate = ${compositeId.quotadate}
       """.as(SalespersonquotahistoryRow.rowParser.singleOpt)
  }
  override def update(row: SalespersonquotahistoryRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.salespersonquotahistory
          set salesquota = ${row.salesquota}::numeric,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND quotadate = ${compositeId.quotadate}
       """.executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: SalespersonquotahistoryId, fieldValues: List[SalespersonquotahistoryFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case SalespersonquotahistoryFieldValue.salesquota(value) => NamedParameter("salesquota", ParameterValue.from(value))
          case SalespersonquotahistoryFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case SalespersonquotahistoryFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update sales.salespersonquotahistory
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where businessentityid = {businessentityid} AND quotadate = {quotadate}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("businessentityid", ParameterValue.from(compositeId.businessentityid)), NamedParameter("quotadate", ParameterValue.from(compositeId.quotadate)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: SalespersonquotahistoryRow)(implicit c: Connection): SalespersonquotahistoryRow = {
    SQL"""insert into sales.salespersonquotahistory(businessentityid, quotadate, salesquota, rowguid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.quotadate}::timestamp,
            ${unsaved.salesquota}::numeric,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, quotadate)
          do update set
            salesquota = EXCLUDED.salesquota,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, quotadate, salesquota, rowguid, modifieddate
       """
      .executeInsert(SalespersonquotahistoryRow.rowParser.single)
  
  }
}
