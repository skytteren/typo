/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package d

import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection

object DViewRepoImpl extends DViewRepo {
  override def selectAll(implicit c: Connection): List[DViewRow] = {
    SQL"""select title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate, documentnode
          from pr.d
       """.as(DViewRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[DViewFieldOrIdValue[_]])(implicit c: Connection): List[DViewRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case DViewFieldValue.title(value) => NamedParameter("title", ParameterValue.from(value))
          case DViewFieldValue.owner(value) => NamedParameter("owner", ParameterValue.from(value))
          case DViewFieldValue.folderflag(value) => NamedParameter("folderflag", ParameterValue.from(value))
          case DViewFieldValue.filename(value) => NamedParameter("filename", ParameterValue.from(value))
          case DViewFieldValue.fileextension(value) => NamedParameter("fileextension", ParameterValue.from(value))
          case DViewFieldValue.revision(value) => NamedParameter("revision", ParameterValue.from(value))
          case DViewFieldValue.changenumber(value) => NamedParameter("changenumber", ParameterValue.from(value))
          case DViewFieldValue.status(value) => NamedParameter("status", ParameterValue.from(value))
          case DViewFieldValue.documentsummary(value) => NamedParameter("documentsummary", ParameterValue.from(value))
          case DViewFieldValue.document(value) => NamedParameter("document", ParameterValue.from(value))
          case DViewFieldValue.rowguid(value) => NamedParameter("rowguid", ParameterValue.from(value))
          case DViewFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
          case DViewFieldValue.documentnode(value) => NamedParameter("documentnode", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select title, "owner", folderflag, filename, fileextension, revision, changenumber, status, documentsummary, "document", rowguid, modifieddate, documentnode
                    from pr.d
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(DViewRow.rowParser(1).*)
    }
  
  }
}
