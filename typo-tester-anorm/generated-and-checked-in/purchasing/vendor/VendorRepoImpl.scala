/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package purchasing
package vendor

import adventureworks.Defaulted
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object VendorRepoImpl extends VendorRepo {
  override def delete(businessentityid: BusinessentityId)(implicit c: Connection): Boolean = {
    SQL"delete from purchasing.vendor where businessentityid = $businessentityid".executeUpdate() > 0
  }
  override def insert(unsaved: VendorRow)(implicit c: Connection): VendorRow = {
    SQL"""insert into purchasing.vendor(businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.accountnumber}::"public".AccountNumber, ${unsaved.name}::"public"."Name", ${unsaved.creditrating}::int2, ${unsaved.preferredvendorstatus}::"public"."Flag", ${unsaved.activeflag}::"public"."Flag", ${unsaved.purchasingwebserviceurl}, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate
       """
      .executeInsert(VendorRow.rowParser.single)
  
  }
  override def insert(unsaved: VendorRowUnsaved)(implicit c: Connection): VendorRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("accountnumber", ParameterValue.from(unsaved.accountnumber)), """::"public".AccountNumber""")),
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      Some((NamedParameter("creditrating", ParameterValue.from(unsaved.creditrating)), "::int2")),
      Some((NamedParameter("purchasingwebserviceurl", ParameterValue.from(unsaved.purchasingwebserviceurl)), "")),
      unsaved.preferredvendorstatus match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("preferredvendorstatus", ParameterValue.from[Flag](value)), """::"public"."Flag""""))
      },
      unsaved.activeflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("activeflag", ParameterValue.from[Flag](value)), """::"public"."Flag""""))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into purchasing.vendor default values
            returning businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate
         """
        .executeInsert(VendorRow.rowParser.single)
    } else {
      val q = s"""insert into purchasing.vendor(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(VendorRow.rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[VendorRow] = {
    SQL"""select businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate
          from purchasing.vendor
       """.as(VendorRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[VendorFieldOrIdValue[_]])(implicit c: Connection): List[VendorRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VendorFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case VendorFieldValue.accountnumber(value) => NamedParameter("accountnumber", ParameterValue.from(value))
          case VendorFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case VendorFieldValue.creditrating(value) => NamedParameter("creditrating", ParameterValue.from(value))
          case VendorFieldValue.preferredvendorstatus(value) => NamedParameter("preferredvendorstatus", ParameterValue.from(value))
          case VendorFieldValue.activeflag(value) => NamedParameter("activeflag", ParameterValue.from(value))
          case VendorFieldValue.purchasingwebserviceurl(value) => NamedParameter("purchasingwebserviceurl", ParameterValue.from(value))
          case VendorFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate
                    from purchasing.vendor
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(VendorRow.rowParser.*)
    }
  
  }
  override def selectById(businessentityid: BusinessentityId)(implicit c: Connection): Option[VendorRow] = {
    SQL"""select businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate
          from purchasing.vendor
          where businessentityid = $businessentityid
       """.as(VendorRow.rowParser.singleOpt)
  }
  override def selectByIds(businessentityids: Array[BusinessentityId])(implicit c: Connection): List[VendorRow] = {
    implicit val toStatement: ToStatement[Array[BusinessentityId]] =
      (s: PreparedStatement, index: Int, v: Array[BusinessentityId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate
          from purchasing.vendor
          where businessentityid = ANY($businessentityids)
       """.as(VendorRow.rowParser.*)
  
  }
  override def update(row: VendorRow)(implicit c: Connection): Boolean = {
    val businessentityid = row.businessentityid
    SQL"""update purchasing.vendor
          set accountnumber = ${row.accountnumber}::"public".AccountNumber,
              "name" = ${row.name}::"public"."Name",
              creditrating = ${row.creditrating}::int2,
              preferredvendorstatus = ${row.preferredvendorstatus}::"public"."Flag",
              activeflag = ${row.activeflag}::"public"."Flag",
              purchasingwebserviceurl = ${row.purchasingwebserviceurl},
              modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = $businessentityid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(businessentityid: BusinessentityId, fieldValues: List[VendorFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case VendorFieldValue.accountnumber(value) => NamedParameter("accountnumber", ParameterValue.from(value))
          case VendorFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case VendorFieldValue.creditrating(value) => NamedParameter("creditrating", ParameterValue.from(value))
          case VendorFieldValue.preferredvendorstatus(value) => NamedParameter("preferredvendorstatus", ParameterValue.from(value))
          case VendorFieldValue.activeflag(value) => NamedParameter("activeflag", ParameterValue.from(value))
          case VendorFieldValue.purchasingwebserviceurl(value) => NamedParameter("purchasingwebserviceurl", ParameterValue.from(value))
          case VendorFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update purchasing.vendor
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where businessentityid = {businessentityid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("businessentityid", ParameterValue.from(businessentityid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: VendorRow)(implicit c: Connection): VendorRow = {
    SQL"""insert into purchasing.vendor(businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.accountnumber}::"public".AccountNumber,
            ${unsaved.name}::"public"."Name",
            ${unsaved.creditrating}::int2,
            ${unsaved.preferredvendorstatus}::"public"."Flag",
            ${unsaved.activeflag}::"public"."Flag",
            ${unsaved.purchasingwebserviceurl},
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid)
          do update set
            accountnumber = EXCLUDED.accountnumber,
            "name" = EXCLUDED."name",
            creditrating = EXCLUDED.creditrating,
            preferredvendorstatus = EXCLUDED.preferredvendorstatus,
            activeflag = EXCLUDED.activeflag,
            purchasingwebserviceurl = EXCLUDED.purchasingwebserviceurl,
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, accountnumber, "name", creditrating, preferredvendorstatus, activeflag, purchasingwebserviceurl, modifieddate
       """
      .executeInsert(VendorRow.rowParser.single)
  
  }
}
