/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package currency

import adventureworks.Defaulted
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object CurrencyRepoImpl extends CurrencyRepo {
  override def delete(currencycode: CurrencyId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.currency where currencycode = $currencycode".executeUpdate() > 0
  }
  override def insert(unsaved: CurrencyRowUnsaved)(implicit c: Connection): CurrencyRow = {
    val namedParameters = List(
      Some((NamedParameter("currencycode", ParameterValue.from(unsaved.currencycode)), "::bpchar")),
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.currency default values
            returning currencycode, "name", modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into sales.currency(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning currencycode, "name", modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[CurrencyRow] = {
    SQL"""select currencycode, "name", modifieddate
          from sales.currency
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[CurrencyFieldOrIdValue[_]])(implicit c: Connection): List[CurrencyRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CurrencyFieldValue.currencycode(value) => NamedParameter("currencycode", ParameterValue.from(value))
          case CurrencyFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case CurrencyFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select currencycode, "name", modifieddate
                    from sales.currency
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(currencycode: CurrencyId)(implicit c: Connection): Option[CurrencyRow] = {
    SQL"""select currencycode, "name", modifieddate
          from sales.currency
          where currencycode = $currencycode
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(currencycodes: Array[CurrencyId])(implicit c: Connection): List[CurrencyRow] = {
    implicit val toStatement: ToStatement[Array[CurrencyId]] =
      (s: PreparedStatement, index: Int, v: Array[CurrencyId]) =>
        s.setArray(index, s.getConnection.createArrayOf("bpchar", v.map(x => x.value)))
    
    SQL"""select currencycode, "name", modifieddate
          from sales.currency
          where currencycode = ANY($currencycodes)
       """.as(rowParser.*)
  
  }
  override def update(row: CurrencyRow)(implicit c: Connection): Boolean = {
    val currencycode = row.currencycode
    SQL"""update sales.currency
          set "name" = ${row.name}::"public"."Name",
              modifieddate = ${row.modifieddate}::timestamp
          where currencycode = $currencycode
       """.executeUpdate() > 0
  }
  override def updateFieldValues(currencycode: CurrencyId, fieldValues: List[CurrencyFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case CurrencyFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case CurrencyFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update sales.currency
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where currencycode = {currencycode}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("currencycode", ParameterValue.from(currencycode)))
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[CurrencyRow] =
    RowParser[CurrencyRow] { row =>
      Success(
        CurrencyRow(
          currencycode = row[CurrencyId]("currencycode"),
          name = row[Name]("name"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
}
