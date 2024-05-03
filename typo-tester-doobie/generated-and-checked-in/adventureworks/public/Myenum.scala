/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public

import cats.data.NonEmptyList
import doobie.enumerated.JdbcType
import doobie.postgres.Text
import doobie.util.Get
import doobie.util.Put
import doobie.util.Read
import doobie.util.Write
import doobie.util.meta.Meta
import io.circe.Decoder
import io.circe.Encoder

/** Enum `public.myenum`
  *  - a
  *  - b
  *  - c
  */
sealed abstract class Myenum(val value: String)

object Myenum {
  def apply(str: String): Either[String, Myenum] =
    ByName.get(str).toRight(s"'$str' does not match any of the following legal values: $Names")
  def force(str: String): Myenum =
    apply(str) match {
      case Left(msg) => sys.error(msg)
      case Right(value) => value
    }
  case object a extends Myenum("a")
  case object b extends Myenum("b")
  case object c extends Myenum("c")
  val All: List[Myenum] = List(a, b, c)
  val Names: String = All.map(_.value).mkString(", ")
  val ByName: Map[String, Myenum] = All.map(x => (x.value, x)).toMap
              
  implicit lazy val arrayGet: Get[Array[Myenum]] = adventureworks.StringArrayMeta.get.map(_.map(force))
  implicit lazy val arrayPut: Put[Array[Myenum]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_public.myenum"), "public.myenum").contramap(_.map(_.value))
  implicit lazy val decoder: Decoder[Myenum] = Decoder.decodeString.emap(Myenum.apply)
  implicit lazy val encoder: Encoder[Myenum] = Encoder.encodeString.contramap(_.value)
  implicit lazy val get: Get[Myenum] = Meta.StringMeta.get.temap(Myenum.apply)
  implicit lazy val ordering: Ordering[Myenum] = Ordering.by(_.value)
  implicit lazy val put: Put[Myenum] = Put.Advanced.one[Myenum](JdbcType.Other, NonEmptyList.one("public.myenum"), (ps, i, a) => ps.setString(i, a.value), (rs, i, a) => rs.updateString(i, a.value))
  implicit lazy val read: Read[Myenum] = Read.fromGet(get)
  implicit lazy val text: Text[Myenum] = new Text[Myenum] {
    override def unsafeEncode(v: Myenum, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value, sb)
    override def unsafeArrayEncode(v: Myenum, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value, sb)
  }
  implicit lazy val write: Write[Myenum] = Write.fromPut(put)
}
