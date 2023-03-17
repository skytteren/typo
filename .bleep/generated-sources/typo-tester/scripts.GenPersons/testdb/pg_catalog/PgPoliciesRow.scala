package testdb
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgPoliciesRow(
  /** Points to [[testdb.pg_catalog.PgNamespaceRow.nspname]] */
  schemaname: String,
  /** Points to [[testdb.pg_catalog.PgClassRow.relname]] */
  tablename: String,
  /** Points to [[testdb.pg_catalog.PgPolicyRow.polname]] */
  policyname: String,
  permissive: /* unknown nullability */ Option[String],
  roles: /* unknown nullability */ Option[Array[String]],
  cmd: /* unknown nullability */ Option[String],
  qual: /* unknown nullability */ Option[String],
  withCheck: /* unknown nullability */ Option[String]
)

object PgPoliciesRow {
  implicit val rowParser: RowParser[PgPoliciesRow] = { row =>
    Success(
      PgPoliciesRow(
        schemaname = row[String]("schemaname"),
        tablename = row[String]("tablename"),
        policyname = row[String]("policyname"),
        permissive = row[/* unknown nullability */ Option[String]]("permissive"),
        roles = row[/* unknown nullability */ Option[Array[String]]]("roles"),
        cmd = row[/* unknown nullability */ Option[String]]("cmd"),
        qual = row[/* unknown nullability */ Option[String]]("qual"),
        withCheck = row[/* unknown nullability */ Option[String]]("with_check")
      )
    )
  }

  implicit val oFormat: OFormat[PgPoliciesRow] = new OFormat[PgPoliciesRow]{
    override def writes(o: PgPoliciesRow): JsObject =
      Json.obj(
        "schemaname" -> o.schemaname,
      "tablename" -> o.tablename,
      "policyname" -> o.policyname,
      "permissive" -> o.permissive,
      "roles" -> o.roles,
      "cmd" -> o.cmd,
      "qual" -> o.qual,
      "with_check" -> o.withCheck
      )

    override def reads(json: JsValue): JsResult[PgPoliciesRow] = {
      JsResult.fromTry(
        Try(
          PgPoliciesRow(
            schemaname = json.\("schemaname").as[String],
            tablename = json.\("tablename").as[String],
            policyname = json.\("policyname").as[String],
            permissive = json.\("permissive").toOption.map(_.as[String]),
            roles = json.\("roles").toOption.map(_.as[Array[String]]),
            cmd = json.\("cmd").toOption.map(_.as[String]),
            qual = json.\("qual").toOption.map(_.as[String]),
            withCheck = json.\("with_check").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}
