/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import cats.data.NonEmptyList
import doobie.Get
import doobie.Meta
import doobie.Put
import io.circe.Decoder
import io.circe.Encoder
import io.circe.HCursor
import io.circe.Json
import org.postgresql.util.PGobject

/** anyarray (via PGObject) */
case class TypoAnyArray(value: String)
object TypoAnyArray {
  implicit val decoder: Decoder[TypoAnyArray] =
    (c: HCursor) =>
      for {
        value <- c.downField("value").as[String]
      } yield TypoAnyArray(value)
  implicit val encoder: Encoder[TypoAnyArray] = {
    import io.circe.syntax._
    row =>
      Json.obj(
        "value" := row.value
      )}
  implicit val get: Get[TypoAnyArray] =
    Get.Advanced.other[PGobject](cats.data.NonEmptyList.one("anyarray"))
      .map(v => TypoAnyArray(v.getValue))
  
  implicit val put: Put[TypoAnyArray] =
    Put.Advanced.other[PGobject](NonEmptyList.one("anyarray"))
      .contramap(v => {
                        val obj = new PGobject
                        obj.setType("anyarray")
                        obj.setValue(v.value)
                        obj
                      })
  
  implicit val meta: Meta[TypoAnyArray] = new Meta(get, put)
  val gets: Get[Array[TypoAnyArray]] =
    Get.Advanced.array[AnyRef](NonEmptyList.one("_anyarray"))
      .map(_.map(v => TypoAnyArray(v.asInstanceOf[String])))
  
  val puts: Put[Array[TypoAnyArray]] =
    Put.Advanced.array[AnyRef](NonEmptyList.one("_anyarray"), "anyarray")
      .contramap(_.map(v => {
                              val obj = new PGobject
                              obj.setType("anyarray")
                              obj.setValue(v.value)
                              obj
                            }))
  
  implicit val metas: Meta[Array[TypoAnyArray]] = new Meta(gets, puts)
}