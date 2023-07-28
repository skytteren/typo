/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime
import java.util.UUID

object AddressRepoImpl extends AddressRepo {
  override def delete(addressid: AddressId)(implicit c: Connection): Boolean = {
    SQL"delete from person.address where addressid = $addressid".executeUpdate() > 0
  }
  override def insert(unsaved: AddressRow)(implicit c: Connection): AddressRow = {
    SQL"""insert into person.address(addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate)
          values (${unsaved.addressid}::int4, ${unsaved.addressline1}, ${unsaved.addressline2}, ${unsaved.city}, ${unsaved.stateprovinceid}::int4, ${unsaved.postalcode}, ${unsaved.spatiallocation}::bytea, ${unsaved.rowguid}::uuid, ${unsaved.modifieddate}::timestamp)
          returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
       """
      .executeInsert(AddressRow.rowParser(1).single)
  
  }
  override def insert(unsaved: AddressRowUnsaved)(implicit c: Connection): AddressRow = {
    val namedParameters = List(
      Some((NamedParameter("addressline1", ParameterValue.from(unsaved.addressline1)), "")),
      Some((NamedParameter("addressline2", ParameterValue.from(unsaved.addressline2)), "")),
      Some((NamedParameter("city", ParameterValue.from(unsaved.city)), "")),
      Some((NamedParameter("stateprovinceid", ParameterValue.from(unsaved.stateprovinceid)), "::int4")),
      Some((NamedParameter("postalcode", ParameterValue.from(unsaved.postalcode)), "")),
      Some((NamedParameter("spatiallocation", ParameterValue.from(unsaved.spatiallocation)), "::bytea")),
      unsaved.addressid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("addressid", ParameterValue.from[AddressId](value)), "::int4"))
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
      SQL"""insert into person.address default values
            returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
         """
        .executeInsert(AddressRow.rowParser(1).single)
    } else {
      val q = s"""insert into person.address(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(AddressRow.rowParser(1).single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[AddressRow] = {
    SQL"""select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
          from person.address
       """.as(AddressRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[AddressFieldOrIdValue[_]])(implicit c: Connection): List[AddressRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case AddressFieldValue.addressid(value) => NamedParameter("addressid", ParameterValue.from(value))
          case AddressFieldValue.addressline1(value) => NamedParameter("addressline1", ParameterValue.from(value))
          case AddressFieldValue.addressline2(value) => NamedParameter("addressline2", ParameterValue.from(value))
          case AddressFieldValue.city(value) => NamedParameter("city", ParameterValue.from(value))
          case AddressFieldValue.stateprovinceid(value) => NamedParameter("stateprovinceid", ParameterValue.from(value))
          case AddressFieldValue.postalcode(value) => NamedParameter("postalcode", ParameterValue.from(value))
          case AddressFieldValue.spatiallocation(value) => NamedParameter("spatiallocation", ParameterValue.from(value))
          case AddressFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case AddressFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
                    from person.address
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(AddressRow.rowParser(1).*)
    }
  
  }
  override def selectById(addressid: AddressId)(implicit c: Connection): Option[AddressRow] = {
    SQL"""select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
          from person.address
          where addressid = $addressid
       """.as(AddressRow.rowParser(1).singleOpt)
  }
  override def selectByIds(addressids: Array[AddressId])(implicit c: Connection): List[AddressRow] = {
    implicit val toStatement: ToStatement[Array[AddressId]] =
      (s: PreparedStatement, index: Int, v: Array[AddressId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
          from person.address
          where addressid = ANY($addressids)
       """.as(AddressRow.rowParser(1).*)
  
  }
  override def update(row: AddressRow)(implicit c: Connection): Boolean = {
    val addressid = row.addressid
    SQL"""update person.address
          set addressline1 = ${row.addressline1},
              addressline2 = ${row.addressline2},
              city = ${row.city},
              stateprovinceid = ${row.stateprovinceid}::int4,
              postalcode = ${row.postalcode},
              spatiallocation = ${row.spatiallocation}::bytea,
              rowguid = ${row.rowguid}::uuid,
              modifieddate = ${row.modifieddate}::timestamp
          where addressid = $addressid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(addressid: AddressId, fieldValues: List[AddressFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case AddressFieldValue.addressline1(value) => NamedParameter("addressline1", ParameterValue.from(value))
          case AddressFieldValue.addressline2(value) => NamedParameter("addressline2", ParameterValue.from(value))
          case AddressFieldValue.city(value) => NamedParameter("city", ParameterValue.from(value))
          case AddressFieldValue.stateprovinceid(value) => NamedParameter("stateprovinceid", ParameterValue.from(value))
          case AddressFieldValue.postalcode(value) => NamedParameter("postalcode", ParameterValue.from(value))
          case AddressFieldValue.spatiallocation(value) => NamedParameter("spatiallocation", ParameterValue.from(value))
          case AddressFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case AddressFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update person.address
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where addressid = {addressid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("addressid", ParameterValue.from(addressid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: AddressRow)(implicit c: Connection): AddressRow = {
    SQL"""insert into person.address(addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate)
          values (
            ${unsaved.addressid}::int4,
            ${unsaved.addressline1},
            ${unsaved.addressline2},
            ${unsaved.city},
            ${unsaved.stateprovinceid}::int4,
            ${unsaved.postalcode},
            ${unsaved.spatiallocation}::bytea,
            ${unsaved.rowguid}::uuid,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (addressid)
          do update set
            addressline1 = EXCLUDED.addressline1,
            addressline2 = EXCLUDED.addressline2,
            city = EXCLUDED.city,
            stateprovinceid = EXCLUDED.stateprovinceid,
            postalcode = EXCLUDED.postalcode,
            spatiallocation = EXCLUDED.spatiallocation,
            rowguid = EXCLUDED.rowguid,
            modifieddate = EXCLUDED.modifieddate
          returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate
       """
      .executeInsert(AddressRow.rowParser(1).single)
  
  }
}