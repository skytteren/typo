/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productmodel

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime
import java.util.UUID

object ProductmodelRepoImpl extends ProductmodelRepo {
  override def delete(productmodelid: ProductmodelId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productmodel where productmodelid = $productmodelid".executeUpdate() > 0
  }
  override def insert(unsaved: ProductmodelRow)(implicit c: Connection): ProductmodelRow = {
    SQL"""insert into production.productmodel(productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate)
          values (${unsaved.productmodelid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.catalogdescription}::xml, ${unsaved.instructions}::xml, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
       """
      .executeInsert(ProductmodelRow.rowParser.single)
  
  }
  override def insert(unsaved: ProductmodelRowUnsaved)(implicit c: Connection): ProductmodelRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      Some((NamedParameter("catalogdescription", ParameterValue.from(unsaved.catalogdescription)), "::xml")),
      Some((NamedParameter("instructions", ParameterValue.from(unsaved.instructions)), "::xml")),
      unsaved.productmodelid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("productmodelid", ParameterValue.from[ProductmodelId](value)), "::int4"))
      },
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
      SQL"""insert into production.productmodel default values
            returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
         """
        .executeInsert(ProductmodelRow.rowParser.single)
    } else {
      val q = s"""insert into production.productmodel(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(ProductmodelRow.rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ProductmodelRow] = {
    SQL"""select productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
          from production.productmodel
       """.as(ProductmodelRow.rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ProductmodelFieldOrIdValue[_]])(implicit c: Connection): List[ProductmodelRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductmodelFieldValue.productmodelid(value) => NamedParameter("productmodelid", ParameterValue.from(value))
          case ProductmodelFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ProductmodelFieldValue.catalogdescription(value) => NamedParameter("catalogdescription", ParameterValue.from(value))
          case ProductmodelFieldValue.instructions(value) => NamedParameter("instructions", ParameterValue.from(value))
          case ProductmodelFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductmodelFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
                    from production.productmodel
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(ProductmodelRow.rowParser.*)
    }
  
  }
  override def selectById(productmodelid: ProductmodelId)(implicit c: Connection): Option[ProductmodelRow] = {
    SQL"""select productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
          from production.productmodel
          where productmodelid = $productmodelid
       """.as(ProductmodelRow.rowParser.singleOpt)
  }
  override def selectByIds(productmodelids: Array[ProductmodelId])(implicit c: Connection): List[ProductmodelRow] = {
    implicit val toStatement: ToStatement[Array[ProductmodelId]] =
      (s: PreparedStatement, index: Int, v: Array[ProductmodelId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
          from production.productmodel
          where productmodelid = ANY($productmodelids)
       """.as(ProductmodelRow.rowParser.*)
  
  }
  override def update(row: ProductmodelRow)(implicit c: Connection): Boolean = {
    val productmodelid = row.productmodelid
    SQL"""update production.productmodel
          set "name" = ${row.name}::"public"."Name",
              catalogdescription = ${row.catalogdescription}::xml,
              instructions = ${row.instructions}::xml,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where productmodelid = $productmodelid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(productmodelid: ProductmodelId, fieldValues: List[ProductmodelFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductmodelFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ProductmodelFieldValue.catalogdescription(value) => NamedParameter("catalogdescription", ParameterValue.from(value))
          case ProductmodelFieldValue.instructions(value) => NamedParameter("instructions", ParameterValue.from(value))
          case ProductmodelFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case ProductmodelFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update production.productmodel
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where productmodelid = {productmodelid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("productmodelid", ParameterValue.from(productmodelid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: ProductmodelRow)(implicit c: Connection): ProductmodelRow = {
    SQL"""insert into production.productmodel(productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate)
          values (
            ${unsaved.productmodelid}::int4,
            ${unsaved.name}::"public"."Name",
            ${unsaved.catalogdescription}::xml,
            ${unsaved.instructions}::xml,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (productmodelid)
          do update set
            "name" = EXCLUDED."name",
            catalogdescription = EXCLUDED.catalogdescription,
            instructions = EXCLUDED.instructions,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning productmodelid, "name", catalogdescription, instructions, rowguid, modifieddate
       """
      .executeInsert(ProductmodelRow.rowParser.single)
  
  }
}
