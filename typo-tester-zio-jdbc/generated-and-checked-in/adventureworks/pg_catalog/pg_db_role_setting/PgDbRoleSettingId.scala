/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_db_role_setting

import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Type for the composite primary key of table `pg_catalog.pg_db_role_setting` */
case class PgDbRoleSettingId(setdatabase: /* oid */ Long, setrole: /* oid */ Long)
object PgDbRoleSettingId {
  implicit lazy val jsonDecoder: JsonDecoder[PgDbRoleSettingId] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val setdatabase = jsonObj.get("setdatabase").toRight("Missing field 'setdatabase'").flatMap(_.as(JsonDecoder.long))
    val setrole = jsonObj.get("setrole").toRight("Missing field 'setrole'").flatMap(_.as(JsonDecoder.long))
    if (setdatabase.isRight && setrole.isRight)
      Right(PgDbRoleSettingId(setdatabase = setdatabase.toOption.get, setrole = setrole.toOption.get))
    else Left(List[Either[String, Any]](setdatabase, setrole).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgDbRoleSettingId] = new JsonEncoder[PgDbRoleSettingId] {
    override def unsafeEncode(a: PgDbRoleSettingId, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""setdatabase":""")
      JsonEncoder.long.unsafeEncode(a.setdatabase, indent, out)
      out.write(",")
      out.write(""""setrole":""")
      JsonEncoder.long.unsafeEncode(a.setrole, indent, out)
      out.write("}")
    }
  }
  implicit lazy val ordering: Ordering[PgDbRoleSettingId] = Ordering.by(x => (x.setdatabase, x.setrole))
}