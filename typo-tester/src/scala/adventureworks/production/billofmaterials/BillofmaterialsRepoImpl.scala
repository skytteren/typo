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
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToSql
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object BillofmaterialsRepoImpl extends BillofmaterialsRepo {
  override def delete(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Boolean = {
    SQL"delete from production.billofmaterials where billofmaterialsid = $billofmaterialsid".executeUpdate() > 0
  }
  override def insert(unsaved: BillofmaterialsRowUnsaved)(implicit c: Connection): BillofmaterialsRow = {
    val namedParameters = List(
      Some((NamedParameter("productassemblyid", ParameterValue.from(unsaved.productassemblyid)), "::int4")),
      Some((NamedParameter("componentid", ParameterValue.from(unsaved.componentid)), "::int4")),
      unsaved.startdate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("startdate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      },
      Some((NamedParameter("enddate", ParameterValue.from(unsaved.enddate)), "::timestamp")),
      Some((NamedParameter("unitmeasurecode", ParameterValue.from(unsaved.unitmeasurecode)), "::bpchar")),
      Some((NamedParameter("bomlevel", ParameterValue.from(unsaved.bomlevel)), "::int2")),
      unsaved.perassemblyqty match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("perassemblyqty", ParameterValue.from[BigDecimal](value)), "::numeric"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    
    if (namedParameters.isEmpty) {
      SQL"""insert into production.billofmaterials default values
            returning billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into production.billofmaterials(${namedParameters.map{case (x, _) => "\"" + x.name + "\""}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[BillofmaterialsRow] = {
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
          from production.billofmaterials
       """.as(rowParser.*)
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
        val q = s"""select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
                    from production.billofmaterials
                    where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(billofmaterialsid: BillofmaterialsId)(implicit c: Connection): Option[BillofmaterialsRow] = {
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
          from production.billofmaterials
          where billofmaterialsid = $billofmaterialsid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(billofmaterialsids: Array[BillofmaterialsId])(implicit c: Connection): List[BillofmaterialsRow] = {
    implicit val arrayToSql: ToSql[Array[BillofmaterialsId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[BillofmaterialsId]] =
      (s: PreparedStatement, index: Int, v: Array[BillofmaterialsId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select billofmaterialsid, productassemblyid, componentid, startdate, enddate, unitmeasurecode, bomlevel, perassemblyqty, modifieddate
          from production.billofmaterials
          where billofmaterialsid = ANY($billofmaterialsids)
       """.as(rowParser.*)
  
  }
  override def update(row: BillofmaterialsRow)(implicit c: Connection): Boolean = {
    val billofmaterialsid = row.billofmaterialsid
    SQL"""update production.billofmaterials
          set productassemblyid = ${row.productassemblyid},
              componentid = ${row.componentid},
              startdate = ${row.startdate},
              enddate = ${row.enddate},
              unitmeasurecode = ${row.unitmeasurecode},
              bomlevel = ${row.bomlevel},
              perassemblyqty = ${row.perassemblyqty},
              modifieddate = ${row.modifieddate}
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
        val q = s"""update production.billofmaterials
                    set ${namedParams.map(x => s"\"${x.name}\" = {${x.name}}").mkString(", ")}
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
  val rowParser: RowParser[BillofmaterialsRow] =
    RowParser[BillofmaterialsRow] { row =>
      Success(
        BillofmaterialsRow(
          billofmaterialsid = row[BillofmaterialsId]("billofmaterialsid"),
          productassemblyid = row[Option[ProductId]]("productassemblyid"),
          componentid = row[ProductId]("componentid"),
          startdate = row[LocalDateTime]("startdate"),
          enddate = row[Option[LocalDateTime]]("enddate"),
          unitmeasurecode = row[UnitmeasureId]("unitmeasurecode"),
          bomlevel = row[Int]("bomlevel"),
          perassemblyqty = row[BigDecimal]("perassemblyqty"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
