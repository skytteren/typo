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
import doobie.free.connection.ConnectionIO
import doobie.postgres.syntax.FragmentOps
import doobie.syntax.SqlInterpolator.SingleFragment.fromWrite
import doobie.syntax.string.toSqlInterpolator
import doobie.util.Write
import doobie.util.fragment.Fragment
import doobie.util.meta.Meta
import fs2.Stream
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class DocumentRepoImpl extends DocumentRepo {
  override def delete: DeleteBuilder[DocumentFields, DocumentRow] = {
    DeleteBuilder("production.document", DocumentFields.structure)
  }
  override def deleteById(documentnode: DocumentId): ConnectionIO[Boolean] = {
    sql"""delete from production.document where "documentnode" = ${fromWrite(documentnode)(Write.fromPut(DocumentId.put))}""".update.run.map(_ > 0)
  }
  override def deleteByIds(documentnodes: Array[DocumentId]): ConnectionIO[Int] = {
    sql"""delete from production.document where "documentnode" = ANY(${documentnodes})""".update.run
  }
  override def insert(unsaved: DocumentRow): ConnectionIO[DocumentRow] = {
    sql"""insert into production.document("title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate", "documentnode")
          values (${fromWrite(unsaved.title)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.owner)(Write.fromPut(BusinessentityId.put))}::int4, ${fromWrite(unsaved.folderflag)(Write.fromPut(Flag.put))}::bool, ${fromWrite(unsaved.filename)(Write.fromPut(Meta.StringMeta.put))}, ${fromWrite(unsaved.fileextension)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.revision)(Write.fromPut(Meta.StringMeta.put))}::bpchar, ${fromWrite(unsaved.changenumber)(Write.fromPut(Meta.IntMeta.put))}::int4, ${fromWrite(unsaved.status)(Write.fromPut(TypoShort.put))}::int2, ${fromWrite(unsaved.documentsummary)(Write.fromPutOption(Meta.StringMeta.put))}, ${fromWrite(unsaved.document)(Write.fromPutOption(TypoBytea.put))}::bytea, ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid, ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp, ${fromWrite(unsaved.documentnode)(Write.fromPut(DocumentId.put))})
          returning "title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate"::text, "documentnode"
       """.query(using DocumentRow.read).unique
  }
  override def insert(unsaved: DocumentRowUnsaved): ConnectionIO[DocumentRow] = {
    val fs = List(
      Some((Fragment.const0(s""""title""""), fr"${fromWrite(unsaved.title)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""owner""""), fr"${fromWrite(unsaved.owner)(Write.fromPut(BusinessentityId.put))}::int4")),
      Some((Fragment.const0(s""""filename""""), fr"${fromWrite(unsaved.filename)(Write.fromPut(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""fileextension""""), fr"${fromWrite(unsaved.fileextension)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""revision""""), fr"${fromWrite(unsaved.revision)(Write.fromPut(Meta.StringMeta.put))}::bpchar")),
      Some((Fragment.const0(s""""status""""), fr"${fromWrite(unsaved.status)(Write.fromPut(TypoShort.put))}::int2")),
      Some((Fragment.const0(s""""documentsummary""""), fr"${fromWrite(unsaved.documentsummary)(Write.fromPutOption(Meta.StringMeta.put))}")),
      Some((Fragment.const0(s""""document""""), fr"${fromWrite(unsaved.document)(Write.fromPutOption(TypoBytea.put))}::bytea")),
      unsaved.folderflag match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""folderflag""""), fr"${fromWrite(value: Flag)(Write.fromPut(Flag.put))}::bool"))
      },
      unsaved.changenumber match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""changenumber""""), fr"${fromWrite(value: Int)(Write.fromPut(Meta.IntMeta.put))}::int4"))
      },
      unsaved.rowguid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""rowguid""""), fr"${fromWrite(value: TypoUUID)(Write.fromPut(TypoUUID.put))}::uuid"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""modifieddate""""), fr"${fromWrite(value: TypoLocalDateTime)(Write.fromPut(TypoLocalDateTime.put))}::timestamp"))
      },
      unsaved.documentnode match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((Fragment.const0(s""""documentnode""""), fr"${fromWrite(value: DocumentId)(Write.fromPut(DocumentId.put))}"))
      }
    ).flatten
    
    val q = if (fs.isEmpty) {
      sql"""insert into production.document default values
            returning "title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate"::text, "documentnode"
         """
    } else {
      val CommaSeparate = Fragment.FragmentMonoid.intercalate(fr", ")
      sql"""insert into production.document(${CommaSeparate.combineAllOption(fs.map { case (n, _) => n }).get})
            values (${CommaSeparate.combineAllOption(fs.map { case (_, f) => f }).get})
            returning "title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate"::text, "documentnode"
         """
    }
    q.query(using DocumentRow.read).unique
    
  }
  override def insertStreaming(unsaved: Stream[ConnectionIO, DocumentRow], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.document("title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate", "documentnode") FROM STDIN""").copyIn(unsaved, batchSize)(using DocumentRow.text)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Stream[ConnectionIO, DocumentRowUnsaved], batchSize: Int = 10000): ConnectionIO[Long] = {
    new FragmentOps(sql"""COPY production.document("title", "owner", "filename", "fileextension", "revision", "status", "documentsummary", "document", "folderflag", "changenumber", "rowguid", "modifieddate", "documentnode") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""").copyIn(unsaved, batchSize)(using DocumentRowUnsaved.text)
  }
  override def select: SelectBuilder[DocumentFields, DocumentRow] = {
    SelectBuilderSql("production.document", DocumentFields.structure, DocumentRow.read)
  }
  override def selectAll: Stream[ConnectionIO, DocumentRow] = {
    sql"""select "title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate"::text, "documentnode" from production.document""".query(using DocumentRow.read).stream
  }
  override def selectById(documentnode: DocumentId): ConnectionIO[Option[DocumentRow]] = {
    sql"""select "title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate"::text, "documentnode" from production.document where "documentnode" = ${fromWrite(documentnode)(Write.fromPut(DocumentId.put))}""".query(using DocumentRow.read).option
  }
  override def selectByIds(documentnodes: Array[DocumentId]): Stream[ConnectionIO, DocumentRow] = {
    sql"""select "title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate"::text, "documentnode" from production.document where "documentnode" = ANY(${documentnodes})""".query(using DocumentRow.read).stream
  }
  override def selectByIdsTracked(documentnodes: Array[DocumentId]): ConnectionIO[Map[DocumentId, DocumentRow]] = {
    selectByIds(documentnodes).compile.toList.map { rows =>
      val byId = rows.view.map(x => (x.documentnode, x)).toMap
      documentnodes.view.flatMap(id => byId.get(id).map(x => (id, x))).toMap
    }
  }
  override def selectByUniqueRowguid(rowguid: TypoUUID): ConnectionIO[Option[DocumentRow]] = {
    sql"""select "title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate"::text, "documentnode"
          from production.document
          where "rowguid" = ${fromWrite(rowguid)(Write.fromPut(TypoUUID.put))}
       """.query(using DocumentRow.read).option
  }
  override def update: UpdateBuilder[DocumentFields, DocumentRow] = {
    UpdateBuilder("production.document", DocumentFields.structure, DocumentRow.read)
  }
  override def update(row: DocumentRow): ConnectionIO[Boolean] = {
    val documentnode = row.documentnode
    sql"""update production.document
          set "title" = ${fromWrite(row.title)(Write.fromPut(Meta.StringMeta.put))},
              "owner" = ${fromWrite(row.owner)(Write.fromPut(BusinessentityId.put))}::int4,
              "folderflag" = ${fromWrite(row.folderflag)(Write.fromPut(Flag.put))}::bool,
              "filename" = ${fromWrite(row.filename)(Write.fromPut(Meta.StringMeta.put))},
              "fileextension" = ${fromWrite(row.fileextension)(Write.fromPutOption(Meta.StringMeta.put))},
              "revision" = ${fromWrite(row.revision)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
              "changenumber" = ${fromWrite(row.changenumber)(Write.fromPut(Meta.IntMeta.put))}::int4,
              "status" = ${fromWrite(row.status)(Write.fromPut(TypoShort.put))}::int2,
              "documentsummary" = ${fromWrite(row.documentsummary)(Write.fromPutOption(Meta.StringMeta.put))},
              "document" = ${fromWrite(row.document)(Write.fromPutOption(TypoBytea.put))}::bytea,
              "rowguid" = ${fromWrite(row.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
              "modifieddate" = ${fromWrite(row.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp
          where "documentnode" = ${fromWrite(documentnode)(Write.fromPut(DocumentId.put))}"""
      .update
      .run
      .map(_ > 0)
  }
  override def upsert(unsaved: DocumentRow): ConnectionIO[DocumentRow] = {
    sql"""insert into production.document("title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate", "documentnode")
          values (
            ${fromWrite(unsaved.title)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.owner)(Write.fromPut(BusinessentityId.put))}::int4,
            ${fromWrite(unsaved.folderflag)(Write.fromPut(Flag.put))}::bool,
            ${fromWrite(unsaved.filename)(Write.fromPut(Meta.StringMeta.put))},
            ${fromWrite(unsaved.fileextension)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.revision)(Write.fromPut(Meta.StringMeta.put))}::bpchar,
            ${fromWrite(unsaved.changenumber)(Write.fromPut(Meta.IntMeta.put))}::int4,
            ${fromWrite(unsaved.status)(Write.fromPut(TypoShort.put))}::int2,
            ${fromWrite(unsaved.documentsummary)(Write.fromPutOption(Meta.StringMeta.put))},
            ${fromWrite(unsaved.document)(Write.fromPutOption(TypoBytea.put))}::bytea,
            ${fromWrite(unsaved.rowguid)(Write.fromPut(TypoUUID.put))}::uuid,
            ${fromWrite(unsaved.modifieddate)(Write.fromPut(TypoLocalDateTime.put))}::timestamp,
            ${fromWrite(unsaved.documentnode)(Write.fromPut(DocumentId.put))}
          )
          on conflict ("documentnode")
          do update set
            "title" = EXCLUDED."title",
            "owner" = EXCLUDED."owner",
            "folderflag" = EXCLUDED."folderflag",
            "filename" = EXCLUDED."filename",
            "fileextension" = EXCLUDED."fileextension",
            "revision" = EXCLUDED."revision",
            "changenumber" = EXCLUDED."changenumber",
            "status" = EXCLUDED."status",
            "documentsummary" = EXCLUDED."documentsummary",
            "document" = EXCLUDED."document",
            "rowguid" = EXCLUDED."rowguid",
            "modifieddate" = EXCLUDED."modifieddate"
          returning "title", "owner", "folderflag", "filename", "fileextension", "revision", "changenumber", "status", "documentsummary", "document", "rowguid", "modifieddate"::text, "documentnode"
       """.query(using DocumentRow.read).unique
  }
}
