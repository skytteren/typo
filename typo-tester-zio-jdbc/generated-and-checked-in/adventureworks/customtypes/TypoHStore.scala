/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import adventureworks.Text
import java.sql.ResultSet
import java.sql.Types
import java.util.HashMap
import typo.dsl.Bijection
import typo.dsl.PGType
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** The text representation of an hstore, used for input and output, includes zero or more key => value pairs separated by commas */
case class TypoHStore(value: Map[String, String])

object TypoHStore {
  implicit lazy val bijection: Bijection[TypoHStore, Map[String, String]] = Bijection[TypoHStore, Map[String, String]](_.value)(TypoHStore.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoHStore] = JdbcDecoder[TypoHStore](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else {
                                 val b = Map.newBuilder[String, String]
                                 v.asInstanceOf[java.util.Map[?, ?]].forEach { case (k, v) => b += k.asInstanceOf[String] -> v.asInstanceOf[String]}
                                 TypoHStore(b.result())
                               }
    },
    "java.util.Map[java.lang.String, java.lang.String]"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoHStore] = JdbcEncoder.singleParamEncoder(using setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoHStore] = JsonDecoder[Map[String, String]].map(TypoHStore.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoHStore] = JsonEncoder[Map[String, String]].contramap(_.value)
  implicit def ordering(implicit O0: Ordering[Map[String, String]]): Ordering[TypoHStore] = Ordering.by(_.value)
  implicit lazy val pgType: PGType[TypoHStore] = PGType.instance[TypoHStore]("hstore", Types.OTHER)
  implicit lazy val setter: Setter[TypoHStore] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        {
          val b = new HashMap[String, String]
          v.value.foreach { case (k, v) => b.put(k, v)}
          b
        }
      )
    },
    "hstore"
  )
  implicit lazy val text: Text[TypoHStore] = new Text[TypoHStore] {
    override def unsafeEncode(v: TypoHStore, sb: StringBuilder) = Text.stringInstance.unsafeEncode(v.value.map { case (k, v) => s"$k => $v" }.mkString(","), sb)
    override def unsafeArrayEncode(v: TypoHStore, sb: StringBuilder) = Text.stringInstance.unsafeArrayEncode(v.value.map { case (k, v) => s"$k => $v" }.mkString(","), sb)
  }
}
