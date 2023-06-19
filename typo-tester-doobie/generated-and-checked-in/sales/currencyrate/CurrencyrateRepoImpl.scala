/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currencyrate

import adventureworks.Defaulted
import doobie.free.connection.ConnectionIO
import doobie.free.connection.pure
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragment.Fragment
import doobie.util.fragments
import fs2.Stream
import java.time.LocalDateTime

object CurrencyrateRepoImpl extends CurrencyrateRepo {
  override def delete(currencyrateid: CurrencyrateId): ConnectionIO[Boolean] = {
    sql"delete from sales.currencyrate where currencyrateid = $currencyrateid".update.run.map(_ > 0)
  }
  override def insert(unsaved: CurrencyrateRow): ConnectionIO[CurrencyrateRow] = {
    sql"""insert into sales.currencyrate(currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate)
          values (${unsaved.currencyrateid}::int4, ${unsaved.currencyratedate}::timestamp, ${unsaved.fromcurrencycode}::bpchar, ${unsaved.tocurrencycode}::bpchar, ${unsaved.averagerate}::numeric, ${unsaved.endofdayrate}::numeric, ${unsaved.modifieddate}::timestamp)
          returning currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
       """.query[CurrencyrateRow].unique
  }
  override def insert(unsaved: CurrencyrateRowUnsaved): ConnectionIO[CurrencyrateRow] = {
    val fs = List(
      Some((Fragment.const(s"currencyratedate"), fr"${unsaved.currencyratedate}::timestamp")),
      Some((Fragment.const(s"fromcurrencycode"), fr"${unsaved.fromcurrencycode}::bpchar")),
      Some((Fragment.const(s"tocurrencycode"), fr"${unsaved.tocurrencycode}::bpchar")),
      Some((Fragment.const(s"averagerate"), fr"${unsaved.averagerate}::numeric")),
      Some((Fragment.const(s"endofdayrate"), fr"${unsaved.endofdayrate}::numeric")),
      unsaved.currencyrateid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"currencyrateid"), fr"${value: CurrencyrateId}::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const(s"modifieddate"), fr"${value: LocalDateTime}::timestamp"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into sales.currencyrate default values
            returning currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
         """
    } else {
      import cats.syntax.foldable.toFoldableOps
      sql"""insert into sales.currencyrate(${fs.map { case (n, _) => n }.intercalate(fr", ")})
            values (${fs.map { case (_, f) => f }.intercalate(fr", ")})
            returning currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
         """
    }
    q.query[CurrencyrateRow].unique
  
  }
  override def selectAll: Stream[ConnectionIO, CurrencyrateRow] = {
    sql"select currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate from sales.currencyrate".query[CurrencyrateRow].stream
  }
  override def selectByFieldValues(fieldValues: List[CurrencyrateFieldOrIdValue[_]]): Stream[ConnectionIO, CurrencyrateRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case CurrencyrateFieldValue.currencyrateid(value) => fr"currencyrateid = $value"
        case CurrencyrateFieldValue.currencyratedate(value) => fr"currencyratedate = $value"
        case CurrencyrateFieldValue.fromcurrencycode(value) => fr"fromcurrencycode = $value"
        case CurrencyrateFieldValue.tocurrencycode(value) => fr"tocurrencycode = $value"
        case CurrencyrateFieldValue.averagerate(value) => fr"averagerate = $value"
        case CurrencyrateFieldValue.endofdayrate(value) => fr"endofdayrate = $value"
        case CurrencyrateFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from sales.currencyrate $where".query[CurrencyrateRow].stream
  
  }
  override def selectById(currencyrateid: CurrencyrateId): ConnectionIO[Option[CurrencyrateRow]] = {
    sql"select currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate from sales.currencyrate where currencyrateid = $currencyrateid".query[CurrencyrateRow].option
  }
  override def selectByIds(currencyrateids: Array[CurrencyrateId]): Stream[ConnectionIO, CurrencyrateRow] = {
    sql"select currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate from sales.currencyrate where currencyrateid = ANY($currencyrateids)".query[CurrencyrateRow].stream
  }
  override def update(row: CurrencyrateRow): ConnectionIO[Boolean] = {
    val currencyrateid = row.currencyrateid
    sql"""update sales.currencyrate
          set currencyratedate = ${row.currencyratedate}::timestamp,
              fromcurrencycode = ${row.fromcurrencycode}::bpchar,
              tocurrencycode = ${row.tocurrencycode}::bpchar,
              averagerate = ${row.averagerate}::numeric,
              endofdayrate = ${row.endofdayrate}::numeric,
              modifieddate = ${row.modifieddate}::timestamp
          where currencyrateid = $currencyrateid
       """
      .update
      .run
      .map(_ > 0)
  }
  override def updateFieldValues(currencyrateid: CurrencyrateId, fieldValues: List[CurrencyrateFieldValue[_]]): ConnectionIO[Boolean] = {
    fieldValues match {
      case Nil => pure(false)
      case nonEmpty =>
        val updates = fragments.set(
          nonEmpty.map {
            case CurrencyrateFieldValue.currencyratedate(value) => fr"currencyratedate = $value"
            case CurrencyrateFieldValue.fromcurrencycode(value) => fr"fromcurrencycode = $value"
            case CurrencyrateFieldValue.tocurrencycode(value) => fr"tocurrencycode = $value"
            case CurrencyrateFieldValue.averagerate(value) => fr"averagerate = $value"
            case CurrencyrateFieldValue.endofdayrate(value) => fr"endofdayrate = $value"
            case CurrencyrateFieldValue.modifieddate(value) => fr"modifieddate = $value"
          } :_*
        )
        sql"""update sales.currencyrate
              $updates
              where currencyrateid = $currencyrateid
           """.update.run.map(_ > 0)
    }
  }
  override def upsert(unsaved: CurrencyrateRow): ConnectionIO[CurrencyrateRow] = {
    sql"""insert into sales.currencyrate(currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate)
          values (
            ${unsaved.currencyrateid}::int4,
            ${unsaved.currencyratedate}::timestamp,
            ${unsaved.fromcurrencycode}::bpchar,
            ${unsaved.tocurrencycode}::bpchar,
            ${unsaved.averagerate}::numeric,
            ${unsaved.endofdayrate}::numeric,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (currencyrateid)
          do update set
            currencyratedate = EXCLUDED.currencyratedate,
            fromcurrencycode = EXCLUDED.fromcurrencycode,
            tocurrencycode = EXCLUDED.tocurrencycode,
            averagerate = EXCLUDED.averagerate,
            endofdayrate = EXCLUDED.endofdayrate,
            modifieddate = EXCLUDED.modifieddate
          returning currencyrateid, currencyratedate, fromcurrencycode, tocurrencycode, averagerate, endofdayrate, modifieddate
       """.query[CurrencyrateRow].unique
  }
}
