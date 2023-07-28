/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package table_privileges

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import adventureworks.information_schema.YesOrNo
import doobie.Get
import doobie.Read
import doobie.enumerated.Nullability
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import java.sql.ResultSet

case class TablePrivilegesViewRow(
  grantor: Option[SqlIdentifier],
  grantee: Option[SqlIdentifier],
  tableCatalog: Option[SqlIdentifier],
  tableSchema: Option[SqlIdentifier],
  tableName: Option[SqlIdentifier],
  privilegeType: Option[CharacterData],
  isGrantable: Option[YesOrNo],
  withHierarchy: Option[YesOrNo]
)

object TablePrivilegesViewRow {
  implicit val decoder: Decoder[TablePrivilegesViewRow] =
    (c: HCursor) =>
      for {
        grantor <- c.downField("grantor").as[Option[SqlIdentifier]]
        grantee <- c.downField("grantee").as[Option[SqlIdentifier]]
        tableCatalog <- c.downField("table_catalog").as[Option[SqlIdentifier]]
        tableSchema <- c.downField("table_schema").as[Option[SqlIdentifier]]
        tableName <- c.downField("table_name").as[Option[SqlIdentifier]]
        privilegeType <- c.downField("privilege_type").as[Option[CharacterData]]
        isGrantable <- c.downField("is_grantable").as[Option[YesOrNo]]
        withHierarchy <- c.downField("with_hierarchy").as[Option[YesOrNo]]
      } yield TablePrivilegesViewRow(grantor, grantee, tableCatalog, tableSchema, tableName, privilegeType, isGrantable, withHierarchy)
  implicit val encoder: Encoder[TablePrivilegesViewRow] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "grantor" := row.grantor,
        "grantee" := row.grantee,
        "table_catalog" := row.tableCatalog,
        "table_schema" := row.tableSchema,
        "table_name" := row.tableName,
        "privilege_type" := row.privilegeType,
        "is_grantable" := row.isGrantable,
        "with_hierarchy" := row.withHierarchy
      )}
  implicit val read: Read[TablePrivilegesViewRow] =
    new Read[TablePrivilegesViewRow](
      gets = List(
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[SqlIdentifier], Nullability.Nullable),
        (Get[CharacterData], Nullability.Nullable),
        (Get[YesOrNo], Nullability.Nullable),
        (Get[YesOrNo], Nullability.Nullable)
      ),
      unsafeGet = (rs: ResultSet, i: Int) => TablePrivilegesViewRow(
        grantor = Get[SqlIdentifier].unsafeGetNullable(rs, i + 0),
        grantee = Get[SqlIdentifier].unsafeGetNullable(rs, i + 1),
        tableCatalog = Get[SqlIdentifier].unsafeGetNullable(rs, i + 2),
        tableSchema = Get[SqlIdentifier].unsafeGetNullable(rs, i + 3),
        tableName = Get[SqlIdentifier].unsafeGetNullable(rs, i + 4),
        privilegeType = Get[CharacterData].unsafeGetNullable(rs, i + 5),
        isGrantable = Get[YesOrNo].unsafeGetNullable(rs, i + 6),
        withHierarchy = Get[YesOrNo].unsafeGetNullable(rs, i + 7)
      )
    )
  

}