/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_policies

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgPoliciesViewRow(
  schemaname: Option[String],
  tablename: Option[String],
  policyname: Option[String],
  permissive: Option[String],
  roles: Option[Array[String]],
  cmd: Option[String],
  qual: Option[String],
  withCheck: Option[String]
)

object PgPoliciesViewRow {
  def rowParser(idx: Int): RowParser[PgPoliciesViewRow] =
    RowParser[PgPoliciesViewRow] { row =>
      Success(
        PgPoliciesViewRow(
          schemaname = row[Option[String]](idx + 0),
          tablename = row[Option[String]](idx + 1),
          policyname = row[Option[String]](idx + 2),
          permissive = row[Option[String]](idx + 3),
          roles = row[Option[Array[String]]](idx + 4),
          cmd = row[Option[String]](idx + 5),
          qual = row[Option[String]](idx + 6),
          withCheck = row[Option[String]](idx + 7)
        )
      )
    }
  implicit val oFormat: OFormat[PgPoliciesViewRow] = new OFormat[PgPoliciesViewRow]{
    override def writes(o: PgPoliciesViewRow): JsObject =
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
  
    override def reads(json: JsValue): JsResult[PgPoliciesViewRow] = {
      JsResult.fromTry(
        Try(
          PgPoliciesViewRow(
            schemaname = json.\("schemaname").toOption.map(_.as[String]),
            tablename = json.\("tablename").toOption.map(_.as[String]),
            policyname = json.\("policyname").toOption.map(_.as[String]),
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