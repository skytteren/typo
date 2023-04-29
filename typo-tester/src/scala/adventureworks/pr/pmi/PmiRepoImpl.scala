/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pmi

import adventureworks.production.illustration.IllustrationId
import adventureworks.production.productmodel.ProductmodelId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime

object PmiRepoImpl extends PmiRepo {
  override def selectAll(implicit c: Connection): List[PmiRow] = {
    SQL"""select productmodelid, illustrationid, modifieddate
          from pr.pmi
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PmiFieldOrIdValue[_]])(implicit c: Connection): List[PmiRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PmiFieldValue.productmodelid(value) => NamedParameter("productmodelid", ParameterValue.from(value))
          case PmiFieldValue.illustrationid(value) => NamedParameter("illustrationid", ParameterValue.from(value))
          case PmiFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select productmodelid, illustrationid, modifieddate
                    from pr.pmi
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[PmiRow] =
    RowParser[PmiRow] { row =>
      Success(
        PmiRow(
          productmodelid = row[Option[ProductmodelId]]("productmodelid"),
          illustrationid = row[Option[IllustrationId]]("illustrationid"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}
