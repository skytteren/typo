/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package billofmaterials

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object BillofmaterialsRepoImpl extends BillofmaterialsRepo {
  override def delete(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Boolean = {
    SQL"delete from production.billofmaterials where billofmaterialsid = $billofmaterialsid".executeUpdate() > 0
  }
  override def insert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow = {
    SQL"""insert into production.billofmaterials(billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate)
          values (${unsaved.billofmaterialsid}::int4, ${unsaved.productassemblyid}::int4, ${unsaved.componentid}::int4, ${unsaved.startdate}::timestamp, ${unsaved.enddate}::timestamp, ${unsaved.unitmeasurecode}::bpchar, ${unsaved.bomlevel}::int2, ${unsaved.perassemblyqty}::numeric, ${unsaved.modifieddate}::timestamp)
          returning billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
       """
      .executeInsert(BillofmaterialsRow.rowParser(1).single)
  
  }
  override def insert(unsaved: BillofmaterialsRowUnsaved)(implicit c: Connection): BillofmaterialsRow = {
    val namedParameters = List(
      Some((NamedParameter("productassemblyid", ParameterValue.from(unsaved.productassemblyid)), "::int4")),
      Some((NamedParameter("componentid", ParameterValue.from(unsaved.componentid)), "::int4")),
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::timestamp")),
      Some((NamedParameter("unitmeasurecode", ParameterValue.from(unsaved.unitmeasurecode)), "::bpchar")),
      Some((NamedParameter("bomlevel", ParameterValue.from(unsaved.bomlevel)), "::int2")),
      unsaved.billofmaterialsid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("billofmaterialsid", ParameterValue.from[BillofmaterialsId](value)), "::int4"))
      },
      unsaved.startdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("startdate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      },
      unsaved.perassemblyqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("perassemblyqty", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into production.billofmaterials default values
            returning billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
         """
        .executeInsert(BillofmaterialsRow.rowParser(1).single)
    } else {
      val q = s"""insert into production.billofmaterials(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(BillofmaterialsRow.rowParser(1).single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[BillofmaterialsRow] = {
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
          from production.billofmaterials
       """.as(BillofmaterialsRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[BillofmaterialsFieldOrIdValue[_]])(implicit c: Connection): List[BillofmaterialsRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case BillofmaterialsFieldValue.billofmaterialsid(value) => NamedParameter("billofmaterialsid", ParameterValue.from(value))
          case BillofmaterialsFieldValue.productassemblyid(value) => NamedParameter("productassemblyid", ParameterValue.from(value))
          case BillofmaterialsFieldValue.componentid(value) => NamedParameter("componentid", ParameterValue.from(value))
          case BillofmaterialsFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case BillofmaterialsFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case BillofmaterialsFieldValue.unitmeasurecode(value) => NamedParameter("unitmeasurecode", ParameterValue.from(value))
          case BillofmaterialsFieldValue.bomlevel(value) => NamedParameter("bomlevel", ParameterValue.from(value))
          case BillofmaterialsFieldValue.perassemblyqty(value) => NamedParameter("perassemblyqty", ParameterValue.from(value))
          case BillofmaterialsFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
                    from production.billofmaterials
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(BillofmaterialsRow.rowParser(1).*)
    }
  
  }
  override def selectById(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Option[BillofmaterialsRow] = {
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
          from production.billofmaterials
          where billofmaterialsid = $billofmaterialsid
       """.as(BillofmaterialsRow.rowParser(1).singleOpt)
  }
  override def selectByIds(billofmaterialsids: Array[BillofmaterialsId])(implicit c: Connection): List[BillofmaterialsRow] = {
    implicit val toStatement: ToStatement[Array[BillofmaterialsId]] =
      (s: PreparedStatement, index: Int, v: Array[BillofmaterialsId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
          from production.billofmaterials
          where billofmaterialsid = ANY($billofmaterialsids)
       """.as(BillofmaterialsRow.rowParser(1).*)
  
  }
  override def update(row: BillofmaterialsRow)(implicit c: Connection): Boolean = {
    val billofmaterialsid = row.billofmaterialsid
    SQL"""update production.billofmaterials
          set productassemblyid = ${row.productassemblyid}::int4,
              componentid = ${row.componentid}::int4,
              startdate = ${row.startdate}::timestamp,
              enddate = ${row.enddate}::timestamp,
              unitmeasurecode = ${row.unitmeasurecode}::bpchar,
              bomlevel = ${row.bomlevel}::int2,
              perassemblyqty = ${row.perassemblyqty}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where billofmaterialsid = $billofmaterialsid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(billofmaterialsid: BillofmaterialsId, fieldValues: List[BillofmaterialsFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case BillofmaterialsFieldValue.productassemblyid(value) => NamedParameter("productassemblyid", ParameterValue.from(value))
          case BillofmaterialsFieldValue.componentid(value) => NamedParameter("componentid", ParameterValue.from(value))
          case BillofmaterialsFieldValue.startdate(value) => NamedParameter("startdate", ParameterValue.from(value))
          case BillofmaterialsFieldValue.enddate(value) => NamedParameter("enddate", ParameterValue.from(value))
          case BillofmaterialsFieldValue.unitmeasurecode(value) => NamedParameter("unitmeasurecode", ParameterValue.from(value))
          case BillofmaterialsFieldValue.bomlevel(value) => NamedParameter("bomlevel", ParameterValue.from(value))
          case BillofmaterialsFieldValue.perassemblyqty(value) => NamedParameter("perassemblyqty", ParameterValue.from(value))
          case BillofmaterialsFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update production.billofmaterials
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where billofmaterialsid = {billofmaterialsid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("billofmaterialsid", ParameterValue.from(billofmaterialsid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: BillofmaterialsRow)(implicit c: Connection): BillofmaterialsRow = {
    SQL"""insert into production.billofmaterials(billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate)
          values (
            ${unsaved.billofmaterialsid}::int4,
            ${unsaved.productassemblyid}::int4,
            ${unsaved.componentid}::int4,
            ${unsaved.startdate}::timestamp,
            ${unsaved.enddate}::timestamp,
            ${unsaved.unitmeasurecode}::bpchar,
            ${unsaved.bomlevel}::int2,
            ${unsaved.perassemblyqty}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (billofmaterialsid)
          do update set
            productassemblyid = EXCLUDED.productassemblyid,
            componentid = EXCLUDED.componentid,
            startdate = EXCLUDED.startdate,
            enddate = EXCLUDED.enddate,
            unitmeasurecode = EXCLUDED.unitmeasurecode,
            bomlevel = EXCLUDED.bomlevel,
            perassemblyqty = EXCLUDED.perassemblyqty,
            modifieddate = EXCLUDED.modifieddate
          returning billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
       """
      .executeInsert(BillofmaterialsRow.rowParser(1).single)
  
  }
}