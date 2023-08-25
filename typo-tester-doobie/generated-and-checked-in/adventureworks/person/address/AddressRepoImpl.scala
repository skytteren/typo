/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package person
package address

import adventureworks.Defaulted
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.person.stateprovince.StateprovinceId
import doobie.free.connection.ConnectionIO
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import java.util.UUID
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

object AddressRepoImpl extends AddressRepo {
  override def delete(addressid: AddressId): ConnectionIO[Boolean] = {
    sql"delete from person.address where addressid = ${fromWrite(addressid)(Write.fromPut(AddressId.put))}".update.run.map(_ > 0)
  }
  override def delete: DeleteBuilder[AddressFields, AddressRow] = {
    DeleteBuilder("person.address", AddressFields)
  }
  override def insert(unsaved: AddressRow): ConnectionIO[AddressRow] = {
    sql"""insert into person.address(addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate)
          values (${fromWrite(unsaved.addressid)(Write.fromPut(AddressId.put))}::int4, ${fromWrite(unsaved.addressline1)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.addressline2)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.city)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4, ${fromWrite(unsaved.postalcode)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.spatiallocation)(Write.fromPutOption(Meta.ByteArrayMeta.put))}::bytea, ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp)
          returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text
       """.query(AddressRow.read).unique
  }
  override def insert(unsaved: AddressRowUnsaved): ConnectionIO[AddressRow] = {
    val fs = List(
      Some((Fragment.const(s"addressline1"), fr"${fromWrite(unsaved.addressline1)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"addressline2"), fr"${fromWrite(unsaved.addressline2)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"city"), fr"${fromWrite(unsaved.city)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"stateprovinceid"), fr"${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4")),
      Some((Fragment.const(s"postalcode"), fr"${fromWrite(unsaved.postalcode)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const(s"spatiallocation"), fr"${fromWrite(unsaved.spatiallocation)(Write.fromPutOption(Meta.ByteArrayMeta.put))}::bytea")),
      unsaved.addressid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"addressid"), fr"${fromWrite(value: AddressId)(Write.fromPut(AddressId.put))}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"rowguid"), fr"${fromWrite(value: UUID)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into person.address default values
            returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into person.address(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text
         """
    }
    q.query(AddressRow.read).unique
    
  }
  override def select: SelectBuilder[AddressFields, AddressRow] = {
    SelectBuilderSql("person.address", AddressFields, AddressRow.read)
  }
  override def selectAll: Stream[ConnectionIO, AddressRow] = {
    sql"select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text from person.address".query(AddressRow.read).stream
  }
  override def selectById(addressid: AddressId): ConnectionIO[Option[AddressRow]] = {
    sql"select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text from person.address where addressid = ${fromWrite(addressid)(Write.fromPut(AddressId.put))}".query(AddressRow.read).option
  }
  override def selectByIds(addressids: Array[AddressId]): Stream[ConnectionIO, AddressRow] = {
    sql"select addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text from person.address where addressid = ANY(${addressids})".query(AddressRow.read).stream
  }
  override def update(row: AddressRow): ConnectionIO[Boolean] = {
    val addressid = row.addressid
    sql"""update person.address
          set addressline1 = ${fromWrite(row.addressline1)(Write.fromPut(Meta.StringMeta.put))},
              addressline2 = ${fromWrite(row.addressline2)(Write.fromPutOption(Meta.StringMeta.put))},
              city = ${fromWrite(row.city)(Write.fromPut(Meta.StringMeta.put))},
              stateprovinceid = ${fromWrite(row.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4,
              postalcode = ${fromWrite(row.postalcode)(Write.fromPut(Meta.StringMeta.put))},
              spatiallocation = ${fromWrite(row.spatiallocation)(Write.fromPutOption(Meta.ByteArrayMeta.put))}::bytea,
              rowguid = ${fromWrite(row.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
              modifieddate = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where addressid = ${fromWrite(addressid)(Write.fromPut(AddressId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def update: UpdateBuilder[AddressFields, AddressRow] = {
    UpdateBuilder("person.address", AddressFields, AddressRow.read)
  }
  override def upsert(unsaved: AddressRow): ConnectionIO[AddressRow] = {
    sql"""insert into person.address(addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate)
          values (
            ${fromWrite(unsaved.addressid)(Write.fromPut(AddressId.put))}::int4,
            ${fromWrite(unsaved.addressline1)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.addressline2)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.city)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.stateprovinceid)(Write.fromPut(StateprovinceId.put))}::int4,
            ${fromWrite(unsaved.postalcode)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.spatiallocation)(Write.fromPutOption(Meta.ByteArrayMeta.put))}::bytea,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(adventureworks.UUIDMeta.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
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
          returning addressid, addressline1, addressline2, city, stateprovinceid, postalcode, spatiallocation, rowguid, modifieddate::text
       """.query(AddressRow.read).unique
  }
}