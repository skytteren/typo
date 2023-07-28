/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.TypoLocalDateTime
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import anorm.RowParser
import anorm.Success
import java.util.UUID
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OWrites
import play.api.libs.json.Reads
import scala.collection.immutable.ListMap
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
  modifieddate: TypoLocalDateTime,
  /** Primary key for Document records. */
  documentnode: DocumentId
)

object DocumentRow {
  implicit val reads: Reads[DocumentRow] = Reads[DocumentRow](json => JsResult.fromTry(
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
          modifieddate = json.\("modifieddate").as[TypoLocalDateTime],
          documentnode = json.\("documentnode").as[DocumentId]
        )
      )
    ),
  )
  def rowParser(idx: Int): RowParser[DocumentRow] = RowParser[DocumentRow] { row =>
    Success(
      DocumentRow(
        title = row[/* max 50 chars */ String](idx + 0),
        owner = row[BusinessentityId](idx + 1),
        folderflag = row[Flag](idx + 2),
        filename = row[/* max 400 chars */ String](idx + 3),
        fileextension = row[Option[/* max 8 chars */ String]](idx + 4),
        revision = row[/* bpchar */ String](idx + 5),
        changenumber = row[Int](idx + 6),
        status = row[Int](idx + 7),
        documentsummary = row[Option[String]](idx + 8),
        document = row[Option[Array[Byte]]](idx + 9),
        rowguid = row[UUID](idx + 10),
        modifieddate = row[TypoLocalDateTime](idx + 11),
        documentnode = row[DocumentId](idx + 12)
      )
    )
  }
  implicit val writes: OWrites[DocumentRow] = OWrites[DocumentRow](o =>
    new JsObject(ListMap[String, JsValue](
      "title" -> Json.toJson(o.title),
      "owner" -> Json.toJson(o.owner),
      "folderflag" -> Json.toJson(o.folderflag),
      "filename" -> Json.toJson(o.filename),
      "fileextension" -> Json.toJson(o.fileextension),
      "revision" -> Json.toJson(o.revision),
      "changenumber" -> Json.toJson(o.changenumber),
      "status" -> Json.toJson(o.status),
      "documentsummary" -> Json.toJson(o.documentsummary),
      "document" -> Json.toJson(o.document),
      "rowguid" -> Json.toJson(o.rowguid),
      "modifieddate" -> Json.toJson(o.modifieddate),
      "documentnode" -> Json.toJson(o.documentnode)
    ))
  )
}
