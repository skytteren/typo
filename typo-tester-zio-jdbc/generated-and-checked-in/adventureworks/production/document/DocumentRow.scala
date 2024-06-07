/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package document

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.person.businessentity.BusinessentityId
import adventureworks.public.Flag
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Table: production.document
    Product maintenance documents.
    Primary key: documentnode */
case class DocumentRow(
  /** Title of the document. */
  title: /* max 50 chars */ String,
  /** Employee who controls the document.  Foreign key to Employee.BusinessEntityID
      Points to [[humanresources.employee.EmployeeRow.businessentityid]] */
  owner: BusinessentityId,
  /** 0 = This is a folder, 1 = This is a document.
      Default: false */
  folderflag: Flag,
  /** File name of the document */
  filename: /* max 400 chars */ String,
  /** File extension indicating the document type. For example, .doc or .txt. */
  fileextension: Option[/* max 8 chars */ String],
  /** Revision number of the document. */
  revision: /* bpchar, max 5 chars */ String,
  /** Engineering change approval number.
      Default: 0 */
  changenumber: Int,
  /** 1 = Pending approval, 2 = Approved, 3 = Obsolete
      Constraint CK_Document_Status affecting columns status: (((status >= 1) AND (status <= 3))) */
  status: TypoShort,
  /** Document abstract. */
  documentsummary: Option[String],
  /** Complete document. */
  document: Option[TypoBytea],
  /** ROWGUIDCOL number uniquely identifying the record. Required for FileStream.
      Default: uuid_generate_v1() */
  rowguid: TypoUUID,
  /** Default: now() */
  modifieddate: TypoLocalDateTime,
  /** Primary key for Document records.
      Default: '/'::character varying */
  documentnode: DocumentId
){
   val id = documentnode
   def toUnsavedRow(documentnode: Defaulted[DocumentId], folderflag: Defaulted[Flag] = Defaulted.Provided(this.folderflag), changenumber: Defaulted[Int] = Defaulted.Provided(this.changenumber), rowguid: Defaulted[TypoUUID] = Defaulted.Provided(this.rowguid), modifieddate: Defaulted[TypoLocalDateTime] = Defaulted.Provided(this.modifieddate)): DocumentRowUnsaved =
     DocumentRowUnsaved(title, owner, filename, fileextension, revision, status, documentsummary, document, folderflag, changenumber, rowguid, modifieddate, documentnode)
 }

object DocumentRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[DocumentRow] = new JdbcDecoder[DocumentRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, DocumentRow) =
      columIndex + 12 ->
        DocumentRow(
          title = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 0, rs)._2,
          owner = BusinessentityId.jdbcDecoder.unsafeDecode(columIndex + 1, rs)._2,
          folderflag = Flag.jdbcDecoder.unsafeDecode(columIndex + 2, rs)._2,
          filename = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 3, rs)._2,
          fileextension = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 4, rs)._2,
          revision = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 5, rs)._2,
          changenumber = JdbcDecoder.intDecoder.unsafeDecode(columIndex + 6, rs)._2,
          status = TypoShort.jdbcDecoder.unsafeDecode(columIndex + 7, rs)._2,
          documentsummary = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 8, rs)._2,
          document = JdbcDecoder.optionDecoder(TypoBytea.jdbcDecoder).unsafeDecode(columIndex + 9, rs)._2,
          rowguid = TypoUUID.jdbcDecoder.unsafeDecode(columIndex + 10, rs)._2,
          modifieddate = TypoLocalDateTime.jdbcDecoder.unsafeDecode(columIndex + 11, rs)._2,
          documentnode = DocumentId.jdbcDecoder.unsafeDecode(columIndex + 12, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[DocumentRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val title = jsonObj.get("title").toRight("Missing field 'title'").flatMap(_.as(JsonDecoder.string))
    val owner = jsonObj.get("owner").toRight("Missing field 'owner'").flatMap(_.as(BusinessentityId.jsonDecoder))
    val folderflag = jsonObj.get("folderflag").toRight("Missing field 'folderflag'").flatMap(_.as(Flag.jsonDecoder))
    val filename = jsonObj.get("filename").toRight("Missing field 'filename'").flatMap(_.as(JsonDecoder.string))
    val fileextension = jsonObj.get("fileextension").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val revision = jsonObj.get("revision").toRight("Missing field 'revision'").flatMap(_.as(JsonDecoder.string))
    val changenumber = jsonObj.get("changenumber").toRight("Missing field 'changenumber'").flatMap(_.as(JsonDecoder.int))
    val status = jsonObj.get("status").toRight("Missing field 'status'").flatMap(_.as(TypoShort.jsonDecoder))
    val documentsummary = jsonObj.get("documentsummary").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val document = jsonObj.get("document").fold[Either[String, Option[TypoBytea]]](Right(None))(_.as(JsonDecoder.option(using TypoBytea.jsonDecoder)))
    val rowguid = jsonObj.get("rowguid").toRight("Missing field 'rowguid'").flatMap(_.as(TypoUUID.jsonDecoder))
    val modifieddate = jsonObj.get("modifieddate").toRight("Missing field 'modifieddate'").flatMap(_.as(TypoLocalDateTime.jsonDecoder))
    val documentnode = jsonObj.get("documentnode").toRight("Missing field 'documentnode'").flatMap(_.as(DocumentId.jsonDecoder))
    if (title.isRight && owner.isRight && folderflag.isRight && filename.isRight && fileextension.isRight && revision.isRight && changenumber.isRight && status.isRight && documentsummary.isRight && document.isRight && rowguid.isRight && modifieddate.isRight && documentnode.isRight)
      Right(DocumentRow(title = title.toOption.get, owner = owner.toOption.get, folderflag = folderflag.toOption.get, filename = filename.toOption.get, fileextension = fileextension.toOption.get, revision = revision.toOption.get, changenumber = changenumber.toOption.get, status = status.toOption.get, documentsummary = documentsummary.toOption.get, document = document.toOption.get, rowguid = rowguid.toOption.get, modifieddate = modifieddate.toOption.get, documentnode = documentnode.toOption.get))
    else Left(List[Either[String, Any]](title, owner, folderflag, filename, fileextension, revision, changenumber, status, documentsummary, document, rowguid, modifieddate, documentnode).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[DocumentRow] = new JsonEncoder[DocumentRow] {
    override def unsafeEncode(a: DocumentRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""title":""")
      JsonEncoder.string.unsafeEncode(a.title, indent, out)
      out.write(",")
      out.write(""""owner":""")
      BusinessentityId.jsonEncoder.unsafeEncode(a.owner, indent, out)
      out.write(",")
      out.write(""""folderflag":""")
      Flag.jsonEncoder.unsafeEncode(a.folderflag, indent, out)
      out.write(",")
      out.write(""""filename":""")
      JsonEncoder.string.unsafeEncode(a.filename, indent, out)
      out.write(",")
      out.write(""""fileextension":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.fileextension, indent, out)
      out.write(",")
      out.write(""""revision":""")
      JsonEncoder.string.unsafeEncode(a.revision, indent, out)
      out.write(",")
      out.write(""""changenumber":""")
      JsonEncoder.int.unsafeEncode(a.changenumber, indent, out)
      out.write(",")
      out.write(""""status":""")
      TypoShort.jsonEncoder.unsafeEncode(a.status, indent, out)
      out.write(",")
      out.write(""""documentsummary":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.documentsummary, indent, out)
      out.write(",")
      out.write(""""document":""")
      JsonEncoder.option(using TypoBytea.jsonEncoder).unsafeEncode(a.document, indent, out)
      out.write(",")
      out.write(""""rowguid":""")
      TypoUUID.jsonEncoder.unsafeEncode(a.rowguid, indent, out)
      out.write(",")
      out.write(""""modifieddate":""")
      TypoLocalDateTime.jsonEncoder.unsafeEncode(a.modifieddate, indent, out)
      out.write(",")
      out.write(""""documentnode":""")
      DocumentId.jsonEncoder.unsafeEncode(a.documentnode, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[DocumentRow] = Text.instance[DocumentRow]{ (row, sb) =>
    Text.stringInstance.unsafeEncode(row.title, sb)
    sb.append(Text.DELIMETER)
    BusinessentityId.text.unsafeEncode(row.owner, sb)
    sb.append(Text.DELIMETER)
    Flag.text.unsafeEncode(row.folderflag, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.filename, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.fileextension, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.revision, sb)
    sb.append(Text.DELIMETER)
    Text.intInstance.unsafeEncode(row.changenumber, sb)
    sb.append(Text.DELIMETER)
    TypoShort.text.unsafeEncode(row.status, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.documentsummary, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoBytea.text).unsafeEncode(row.document, sb)
    sb.append(Text.DELIMETER)
    TypoUUID.text.unsafeEncode(row.rowguid, sb)
    sb.append(Text.DELIMETER)
    TypoLocalDateTime.text.unsafeEncode(row.modifieddate, sb)
    sb.append(Text.DELIMETER)
    DocumentId.text.unsafeEncode(row.documentnode, sb)
  }
}
