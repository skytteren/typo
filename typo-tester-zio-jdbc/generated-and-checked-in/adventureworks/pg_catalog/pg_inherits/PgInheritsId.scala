/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pg_catalog
package pg_inherits

import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/** Type for the composite primary key of table `pg_catalog.pg_inherits` */
case class PgInheritsId(inhrelid: /* oid */ Long, inhseqno: Int)
object PgInheritsId {
  implicit lazy val jsonDecoder: JsonDecoder[PgInheritsId] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val inhrelid = jsonObj.get("inhrelid").toRight("Missing field 'inhrelid'").flatMap(_.as(JsonDecoder.long))
    val inhseqno = jsonObj.get("inhseqno").toRight("Missing field 'inhseqno'").flatMap(_.as(JsonDecoder.int))
    if (inhrelid.isRight && inhseqno.isRight)
      Right(PgInheritsId(inhrelid = inhrelid.toOption.get, inhseqno = inhseqno.toOption.get))
    else Left(List[Either[String, Any]](inhrelid, inhseqno).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[PgInheritsId] = new JsonEncoder[PgInheritsId] {
    override def unsafeEncode(a: PgInheritsId, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""inhrelid":""")
      JsonEncoder.long.unsafeEncode(a.inhrelid, indent, out)
      out.write(",")
      out.write(""""inhseqno":""")
      JsonEncoder.int.unsafeEncode(a.inhseqno, indent, out)
      out.write("}")
    }
  }
  implicit lazy val ordering: Ordering[PgInheritsId] = Ordering.by(x => (x.inhrelid, x.inhseqno))
}