/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package users

import adventureworks.customtypes.Defaulted
import adventureworks.customtypes.TypoInstant
import adventureworks.customtypes.TypoUnknownCitext
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

/**
 *Table: public.users
 *
 * Primary key: user_id */
case class UsersRow(
  userId: UsersId,
  name: String,
  lastName: Option[String],
  email: TypoUnknownCitext,
  password: String,
  /** Default: now() */
  createdAt: TypoInstant,
  verifiedOn: Option[TypoInstant]
){
   val id = userId
   def toUnsavedRow(createdAt: Defaulted[TypoInstant] = Defaulted.Provided(this.createdAt)): UsersRowUnsaved =
     UsersRowUnsaved(userId, name, lastName, email, password, verifiedOn, createdAt)
 }

object UsersRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[UsersRow] = new JdbcDecoder[UsersRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, UsersRow) =
      columIndex + 6 ->
        UsersRow(
          userId = UsersId.jdbcDecoder.unsafeDecode(columIndex + 0, rs)._2,
          name = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 1, rs)._2,
          lastName = JdbcDecoder.optionDecoder(JdbcDecoder.stringDecoder).unsafeDecode(columIndex + 2, rs)._2,
          email = TypoUnknownCitext.jdbcDecoder.unsafeDecode(columIndex + 3, rs)._2,
          password = JdbcDecoder.stringDecoder.unsafeDecode(columIndex + 4, rs)._2,
          createdAt = TypoInstant.jdbcDecoder.unsafeDecode(columIndex + 5, rs)._2,
          verifiedOn = JdbcDecoder.optionDecoder(TypoInstant.jdbcDecoder).unsafeDecode(columIndex + 6, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[UsersRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val userId = jsonObj.get("user_id").toRight("Missing field 'user_id'").flatMap(_.as(UsersId.jsonDecoder))
    val name = jsonObj.get("name").toRight("Missing field 'name'").flatMap(_.as(JsonDecoder.string))
    val lastName = jsonObj.get("last_name").fold[Either[String, Option[String]]](Right(None))(_.as(JsonDecoder.option(using JsonDecoder.string)))
    val email = jsonObj.get("email").toRight("Missing field 'email'").flatMap(_.as(TypoUnknownCitext.jsonDecoder))
    val password = jsonObj.get("password").toRight("Missing field 'password'").flatMap(_.as(JsonDecoder.string))
    val createdAt = jsonObj.get("created_at").toRight("Missing field 'created_at'").flatMap(_.as(TypoInstant.jsonDecoder))
    val verifiedOn = jsonObj.get("verified_on").fold[Either[String, Option[TypoInstant]]](Right(None))(_.as(JsonDecoder.option(using TypoInstant.jsonDecoder)))
    if (userId.isRight && name.isRight && lastName.isRight && email.isRight && password.isRight && createdAt.isRight && verifiedOn.isRight)
      Right(UsersRow(userId = userId.toOption.get, name = name.toOption.get, lastName = lastName.toOption.get, email = email.toOption.get, password = password.toOption.get, createdAt = createdAt.toOption.get, verifiedOn = verifiedOn.toOption.get))
    else Left(List[Either[String, Any]](userId, name, lastName, email, password, createdAt, verifiedOn).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[UsersRow] = new JsonEncoder[UsersRow] {
    override def unsafeEncode(a: UsersRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""user_id":""")
      UsersId.jsonEncoder.unsafeEncode(a.userId, indent, out)
      out.write(",")
      out.write(""""name":""")
      JsonEncoder.string.unsafeEncode(a.name, indent, out)
      out.write(",")
      out.write(""""last_name":""")
      JsonEncoder.option(using JsonEncoder.string).unsafeEncode(a.lastName, indent, out)
      out.write(",")
      out.write(""""email":""")
      TypoUnknownCitext.jsonEncoder.unsafeEncode(a.email, indent, out)
      out.write(",")
      out.write(""""password":""")
      JsonEncoder.string.unsafeEncode(a.password, indent, out)
      out.write(",")
      out.write(""""created_at":""")
      TypoInstant.jsonEncoder.unsafeEncode(a.createdAt, indent, out)
      out.write(",")
      out.write(""""verified_on":""")
      JsonEncoder.option(using TypoInstant.jsonEncoder).unsafeEncode(a.verifiedOn, indent, out)
      out.write("}")
    }
  }
  implicit lazy val text: Text[UsersRow] = Text.instance[UsersRow]{ (row, sb) =>
    UsersId.text.unsafeEncode(row.userId, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.name, sb)
    sb.append(Text.DELIMETER)
    Text.option(Text.stringInstance).unsafeEncode(row.lastName, sb)
    sb.append(Text.DELIMETER)
    TypoUnknownCitext.text.unsafeEncode(row.email, sb)
    sb.append(Text.DELIMETER)
    Text.stringInstance.unsafeEncode(row.password, sb)
    sb.append(Text.DELIMETER)
    TypoInstant.text.unsafeEncode(row.createdAt, sb)
    sb.append(Text.DELIMETER)
    Text.option(TypoInstant.text).unsafeEncode(row.verifiedOn, sb)
  }
}
