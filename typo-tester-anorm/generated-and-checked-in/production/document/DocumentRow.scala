/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class DocumentRow(
  /** Title of the document. */
  title: /* max 50 chars */ String,
  /** Employee who controls the document.  Foreign key to Employee.BusinessEntityID
      Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  owner: BusinessentityId,
  /** 0 = This is a folder, 1 = This is a document. */
  folderflag: Flag,
  /** File name of the document */
  filename: /* max 400 chars */ String,
  /** File extension indicating the document type. For example, .doc or .txt. */
  fileextension: Option[/* max 8 chars */ String],
  /** Revision number of the document. */
  revision: /* bpchar */ String,
  /** Engineering change approval number. */
  changenumber: Int,
  /** 1 = Pending approval, 2 = Approved, 3 = Obsolete */
  status: Int,
  /** Document abstract. */
  documentsummary: Option[String],
  /** Complete document. */
  document: Option[Array[Byte]],
  /** ROWGUIDCOL number uniquely identifying the record. Required for FileStream. */
  rowguid: UUID,
  modifieddate: LocalDateTime,
  /** Primary key for Document records. */
  documentnode: DocumentId
)

object DocumentRow {
  val rowParser: RowParser[DocumentRow] =
    RowParser[DocumentRow] { row =>
      Success(
        DocumentRow(
          title = row[/* max 50 chars */ String]("title"),
          owner = row[BusinessentityId]("owner"),
          folderflag = row[Flag]("folderflag"),
          filename = row[/* max 400 chars */ String]("filename"),
          fileextension = row[Option[/* max 8 chars */ String]]("fileextension"),
          revision = row[/* bpchar */ String]("revision"),
          changenumber = row[Int]("changenumber"),
          status = row[Int]("status"),
          documentsummary = row[Option[String]]("documentsummary"),
          document = row[Option[Array[Byte]]]("document"),
          rowguid = row[UUID]("rowguid"),
          modifieddate = row[LocalDateTime]("modifieddate"),
          documentnode = row[DocumentId]("documentnode")
        )
      )
    }
  implicit val oFormat: OFormat[DocumentRow] = new OFormat[DocumentRow]{
    override def writes(o: DocumentRow): JsObject =
      Json.obj(
        "title" -> o.title,
        "owner" -> o.owner,
        "folderflag" -> o.folderflag,
        "filename" -> o.filename,
        "fileextension" -> o.fileextension,
        "revision" -> o.revision,
        "changenumber" -> o.changenumber,
        "status" -> o.status,
        "documentsummary" -> o.documentsummary,
        "document" -> o.document,
        "rowguid" -> o.rowguid,
        "modifieddate" -> o.modifieddate,
        "documentnode" -> o.documentnode
      )
  
    override def reads(json: JsValue): JsResult[DocumentRow] = {
      JsResult.fromTry(
        Try(
          DocumentRow(
            title = json.\("title").as[/* max 50 chars */ String],
            owner = json.\("owner").as[BusinessentityId],
            folderflag = json.\("folderflag").as[Flag],
            filename = json.\("filename").as[/* max 400 chars */ String],
            fileextension = json.\("fileextension").toOption.map(_.as[/* max 8 chars */ String]),
            revision = json.\("revision").as[/* bpchar */ String],
            changenumber = json.\("changenumber").as[Int],
            status = json.\("status").as[Int],
            documentsummary = json.\("documentsummary").toOption.map(_.as[String]),
            document = json.\("document").toOption.map(_.as[Array[Byte]]),
            rowguid = json.\("rowguid").as[UUID],
            modifieddate = json.\("modifieddate").as[LocalDateTime],
            documentnode = json.\("documentnode").as[DocumentId]
          )
        )
      )
    }
  }
}
