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

/** pg_node_tree (via PGObject) */
case class TypoPgNodeTree(value: String)

object TypoPgNodeTree {
  implicit val arrayGet: Get[Array[TypoPgNodeTree]] = Get.Advanced.array[AnyRef](NonEmptyList.one("_pg_node_tree"))
    .map(_.map(v => TypoPgNodeTree(v.asInstanceOf[String])))
  implicit val arrayPut: Put[Array[TypoPgNodeTree]] = Put.Advanced.array[AnyRef](NonEmptyList.one("_pg_node_tree"), "pg_node_tree")
    .contramap(_.map(v => {
                            val obj = new PGobject
                            obj.setType("pg_node_tree")
                            obj.setValue(v.value)
                            obj
                          }))
  implicit val decoder: Decoder[TypoPgNodeTree] = Decoder.forProduct1[TypoPgNodeTree, String]("value")(TypoPgNodeTree.apply)
  implicit val encoder: Encoder[TypoPgNodeTree] = Encoder.forProduct1[TypoPgNodeTree, String]("value")(x => (x.value))
  implicit val get: Get[TypoPgNodeTree] = Get.Advanced.other[PGobject](NonEmptyList.one("pg_node_tree"))
    .map(v => TypoPgNodeTree(v.getValue))
  implicit val put: Put[TypoPgNodeTree] = Put.Advanced.other[PGobject](NonEmptyList.one("pg_node_tree")).contramap(v => {
                                                                                  val obj = new PGobject
                                                                                  obj.setType("pg_node_tree")
                                                                                  obj.setValue(v.value)
                                                                                  obj
                                                                                })
}
