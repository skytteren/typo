/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package pp

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.person.phonenumbertype.PhonenumbertypeId
import adventureworks.public.Phone
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object PpRepoImpl extends PpRepo {
  override def selectAll(implicit c: Connection): List[PpRow] = {
    SQL"""select "id", businessentityid, phonenumber, phonenumbertypeid, modifieddate
          from pe.pp
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PpFieldOrIdValue[_]])(implicit c: Connection): List[PpRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PpFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PpFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case PpFieldValue.phonenumber(value) => NamedParameter("phonenumber", ParameterValue.from(value))
          case PpFieldValue.phonenumbertypeid(value) => NamedParameter("phonenumbertypeid", ParameterValue.from(value))
          case PpFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", businessentityid, phonenumber, phonenumbertypeid, modifieddate
                    from pe.pp
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[PpRow] =
    RowParser[PpRow] { row =>
      Success(
        PpRow(
          id = row[Option[Int]]("id"),
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          phonenumber = row[Option[Phone]]("phonenumber"),
          phonenumbertypeid = row[Option[PhonenumbertypeId]]("phonenumbertypeid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}