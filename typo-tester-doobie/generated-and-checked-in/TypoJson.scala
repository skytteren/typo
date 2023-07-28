/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks

import cats.data.NonEmptyList
import doobie.util.Get
import doobie.util.Put
import io.circe.Decoder
import io.circe.Encoder
import org.postgresql.util.PGobject

/** json (via PGObject) */
case class TypoJson(value: String)

object TypoJson {
  implicit val arrayGet: Get[Array[TypoJson]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_json"))
    .map(_.map(v => TypoJson(v.asInstanceOf[String])))
  implicit val arrayPut: Put[Array[TypoJson]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_json"), "json")
    .contramap(_.map(v => {
                            val obj = new PGobject
                            obj.setType("json")
                            obj.setValue(v.value)
                            obj
                          }))
  implicit val decoder: Decoder[TypoJson] = Decoder.forProduct1[TypoJson, String]("value")(TypoJson.apply)
  implicit val encoder: Encoder[TypoJson] = Encoder.forProduct1[TypoJson, String]("value")(x => (x.value))
  implicit val get: Get[TypoJson] = Get.Advanced.other[PGobject](NonEmptyList.one("json"))
    .map(v => TypoJson(v.getValue))
  implicit val put: Put[TypoJson] = Put.Advanced.other[PGobject](NonEmptyList.one("json")).contramap(v => {
                                                                          val obj = new PGobject
                                                                          obj.setType("json")
                                                                          obj.setValue(v.value)
                                                                          obj
                                                                        })
}
