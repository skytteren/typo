/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package customtypes

import java.sql.ResultSet
import java.sql.Types
import org.postgresql.util.PGobject
import typo.dsl.Bijection
import typo.dsl.ParameterMetaData
import zio.jdbc.JdbcDecoder
import zio.jdbc.JdbcEncoder
import zio.jdbc.SqlFragment.Setter
import zio.json.JsonDecoder
import zio.json.JsonEncoder

/** anyarray (via PGObject) */
case class TypoAnyArray(value: String)

object TypoAnyArray {
  implicit lazy val arrayJdbcDecoder: JdbcDecoder[Array[TypoAnyArray]] = JdbcDecoder[Array[TypoAnyArray]]((rs: ResultSet) => (i: Int) =>
    rs.getArray(i) match {
      case null => null
      case arr => arr.getArray.asInstanceOf[Array[AnyRef]].map(x => TypoAnyArray(x.asInstanceOf[String]))
    },
    "scala.Array[org.postgresql.util.PGobject]"
  )
  implicit lazy val arrayJdbcEncoder: JdbcEncoder[Array[TypoAnyArray]] = JdbcEncoder.singleParamEncoder(arraySetter)
  implicit lazy val arraySetter: Setter[Array[TypoAnyArray]] = Setter.forSqlType((ps, i, v) =>
    ps.setArray(
      i,
      ps.getConnection.createArrayOf(
        "anyarray",
        v.map { vv =>
          {
            val obj = new PGobject
            obj.setType("anyarray")
            obj.setValue(vv.value)
            obj
          }
        }
      )
    ),
    Types.ARRAY
  )
  implicit lazy val bijection: Bijection[TypoAnyArray, String] = Bijection[TypoAnyArray, String](_.value)(TypoAnyArray.apply)
  implicit lazy val jdbcDecoder: JdbcDecoder[TypoAnyArray] = JdbcDecoder[TypoAnyArray](
    (rs: ResultSet) => (i: Int) => {
      val v = rs.getObject(i)
      if (v eq null) null else TypoAnyArray(v.asInstanceOf[PGobject].getValue)
    },
    "org.postgresql.util.PGobject"
  )
  implicit lazy val jdbcEncoder: JdbcEncoder[TypoAnyArray] = JdbcEncoder.singleParamEncoder(setter)
  implicit lazy val jsonDecoder: JsonDecoder[TypoAnyArray] = JsonDecoder.string.map(TypoAnyArray.apply)
  implicit lazy val jsonEncoder: JsonEncoder[TypoAnyArray] = JsonEncoder.string.contramap(_.value)
  implicit lazy val ordering: Ordering[TypoAnyArray] = Ordering.by(_.value)
  implicit lazy val parameterMetadata: ParameterMetaData[TypoAnyArray] = ParameterMetaData.instance[TypoAnyArray]("anyarray", Types.OTHER)
  implicit lazy val setter: Setter[TypoAnyArray] = Setter.other(
    (ps, i, v) => {
      ps.setObject(
        i,
        {
          val obj = new PGobject
          obj.setType("anyarray")
          obj.setValue(v.value)
          obj
        }
      )
    },
    "anyarray"
  )
}