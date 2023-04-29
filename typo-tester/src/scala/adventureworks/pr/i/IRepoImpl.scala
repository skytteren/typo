/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package i

import adventureworks.production.illustration.IllustrationId
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection
import java.time.LocalDateTime
import org.postgresql.jdbc.PgSQLXML

object IRepoImpl extends IRepo {
  override def selectAll(implicit c: Connection): List[IRow] = {
    SQL"""select "id", illustrationid, diagram, modifieddate
          from pr.i
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[IFieldOrIdValue[_]])(implicit c: Connection): List[IRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case IFieldValue.id(value) => NamedParameter("id", ParameterValue.from(value))
          case IFieldValue.illustrationid(value) => NamedParameter("illustrationid", ParameterValue.from(value))
          case IFieldValue.diagram(value) => NamedParameter("diagram", ParameterValue.from(value))
          case IFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select "id", illustrationid, diagram, modifieddate
                    from pr.i
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  val rowParser: RowParser[IRow] =
    RowParser[IRow] { row =>
      Success(
        IRow(
          id = row[Option[Int]]("id"),
          illustrationid = row[Option[IllustrationId]]("illustrationid"),
          diagram = row[Option[PgSQLXML]]("diagram"),
          modifieddate = row[Option[LocalDateTime]]("modifieddate")
        )
      )
    }
}
