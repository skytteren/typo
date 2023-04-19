/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pe
package p

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Name
import adventureworks.public.NameStyle
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import java.util.UUID

object PRepoImpl extends PRepo {
  override def selectAll(implicit c: Connection): List[PRow] = {
    SQL"select id, businessentityid, persontype, namestyle, title, firstname, middlename, lastname, suffix, emailpromotion, additionalcontactinfo, demographics, rowguid, modifieddate from pe.p".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PFieldOrIdValue[_]])(implicit c: Connection): List[PRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case PFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case PFieldValue.persontype(value) => NamedParameter("persontype", ParameterValue.from(value))
          case PFieldValue.namestyle(value) => NamedParameter("namestyle", ParameterValue.from(value))
          case PFieldValue.title(value) => NamedParameter("title", ParameterValue.from(value))
          case PFieldValue.firstname(value) => NamedParameter("firstname", ParameterValue.from(value))
          case PFieldValue.middlename(value) => NamedParameter("middlename", ParameterValue.from(value))
          case PFieldValue.lastname(value) => NamedParameter("lastname", ParameterValue.from(value))
          case PFieldValue.suffix(value) => NamedParameter("suffix", ParameterValue.from(value))
          case PFieldValue.emailpromotion(value) => NamedParameter("emailpromotion", ParameterValue.from(value))
          case PFieldValue.additionalcontactinfo(value) => NamedParameter("additionalcontactinfo", ParameterValue.from(value))
          case PFieldValue.demographics(value) => NamedParameter("demographics", ParameterValue.from(value))
          case PFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case PFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from pe.p where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[PRow] =
    RowParser[PRow] { row =>
      Success(
        PRow(
          id = row[Option[Int]]("id"),
          businessentityid = row[Option[BusinessentityId]]("businessentityid"),
          persontype = row[Option[/* bpchar */ String]]("persontype"),
          namestyle = row[NameStyle]("namestyle"),
          title = row[Option[String]]("title"),
          firstname = row[Option[Name]]("firstname"),
          middlename = row[Option[Name]]("middlename"),
          lastname = row[Option[Name]]("lastname"),
          suffix = row[Option[String]]("suffix"),
          emailpromotion = row[Option[Int]]("emailpromotion"),
          additionalcontactinfo = row[Option[/* xml */ String]]("additionalcontactinfo"),
          demographics = row[Option[/* xml */ String]]("demographics"),
          rowguid = row[Option[UUID]]("rowguid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}
