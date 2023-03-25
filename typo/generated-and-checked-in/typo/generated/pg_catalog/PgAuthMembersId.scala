/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgAuthMembersId(roleid: Long, member: Long)
object PgAuthMembersId {
  implicit val ordering: Ordering[PgAuthMembersId] = Ordering.by(x => (x.roleid, x.member))
  implicit val oFormat: OFormat[PgAuthMembersId] = new OFormat[PgAuthMembersId]{
    override def writes(o: PgAuthMembersId): JsObject =
      Json.obj(
        "roleid" -> o.roleid,
      "member" -> o.member
      )

    override def reads(json: JsValue): JsResult[PgAuthMembersId] = {
      JsResult.fromTry(
        Try(
          PgAuthMembersId(
            roleid = json.\("roleid").as[Long],
            member = json.\("member").as[Long]
          )
        )
      )
    }
  }
  implicit val rowParser: RowParser[PgAuthMembersId] = { row =>
    Success(
      PgAuthMembersId(
        roleid = row[Long]("roleid"),
        member = row[Long]("member")
      )
    )
  }

}