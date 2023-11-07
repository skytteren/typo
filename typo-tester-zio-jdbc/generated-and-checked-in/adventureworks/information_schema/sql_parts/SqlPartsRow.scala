/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package sql_parts

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.YesOrNo
import java.sql.ResultSet
import zio.jdbc.JdbcDecoder
import zio.json.JsonDecoder
import zio.json.JsonEncoder
import zio.json.ast.Json
import zio.json.internal.Write

case class SqlPartsRow(
  featureId: Option[CharacterData],
  featureName: Option[CharacterData],
  isSupported: Option[YesOrNo],
  isVerifiedBy: Option[CharacterData],
  comments: Option[CharacterData]
)

object SqlPartsRow {
  implicit lazy val jdbcDecoder: JdbcDecoder[SqlPartsRow] = new JdbcDecoder[SqlPartsRow] {
    override def unsafeDecode(columIndex: Int, rs: ResultSet): (Int, SqlPartsRow) =
      columIndex + 4 ->
        SqlPartsRow(
          featureId = JdbcDecoder.optionDecoder(CharacterData.jdbcDecoder).unsafeDecode(columIndex + 0, rs)._2,
          featureName = JdbcDecoder.optionDecoder(CharacterData.jdbcDecoder).unsafeDecode(columIndex + 1, rs)._2,
          isSupported = JdbcDecoder.optionDecoder(YesOrNo.jdbcDecoder).unsafeDecode(columIndex + 2, rs)._2,
          isVerifiedBy = JdbcDecoder.optionDecoder(CharacterData.jdbcDecoder).unsafeDecode(columIndex + 3, rs)._2,
          comments = JdbcDecoder.optionDecoder(CharacterData.jdbcDecoder).unsafeDecode(columIndex + 4, rs)._2
        )
  }
  implicit lazy val jsonDecoder: JsonDecoder[SqlPartsRow] = JsonDecoder[Json.Obj].mapOrFail { jsonObj =>
    val featureId = jsonObj.get("feature_id").fold[Either[String, Option[CharacterData]]](Right(None))(_.as(JsonDecoder.option(CharacterData.jsonDecoder)))
    val featureName = jsonObj.get("feature_name").fold[Either[String, Option[CharacterData]]](Right(None))(_.as(JsonDecoder.option(CharacterData.jsonDecoder)))
    val isSupported = jsonObj.get("is_supported").fold[Either[String, Option[YesOrNo]]](Right(None))(_.as(JsonDecoder.option(YesOrNo.jsonDecoder)))
    val isVerifiedBy = jsonObj.get("is_verified_by").fold[Either[String, Option[CharacterData]]](Right(None))(_.as(JsonDecoder.option(CharacterData.jsonDecoder)))
    val comments = jsonObj.get("comments").fold[Either[String, Option[CharacterData]]](Right(None))(_.as(JsonDecoder.option(CharacterData.jsonDecoder)))
    if (featureId.isRight && featureName.isRight && isSupported.isRight && isVerifiedBy.isRight && comments.isRight)
      Right(SqlPartsRow(featureId = featureId.toOption.get, featureName = featureName.toOption.get, isSupported = isSupported.toOption.get, isVerifiedBy = isVerifiedBy.toOption.get, comments = comments.toOption.get))
    else Left(List[Either[String, Any]](featureId, featureName, isSupported, isVerifiedBy, comments).flatMap(_.left.toOption).mkString(", "))
  }
  implicit lazy val jsonEncoder: JsonEncoder[SqlPartsRow] = new JsonEncoder[SqlPartsRow] {
    override def unsafeEncode(a: SqlPartsRow, indent: Option[Int], out: Write): Unit = {
      out.write("{")
      out.write(""""feature_id":""")
      JsonEncoder.option(CharacterData.jsonEncoder).unsafeEncode(a.featureId, indent, out)
      out.write(",")
      out.write(""""feature_name":""")
      JsonEncoder.option(CharacterData.jsonEncoder).unsafeEncode(a.featureName, indent, out)
      out.write(",")
      out.write(""""is_supported":""")
      JsonEncoder.option(YesOrNo.jsonEncoder).unsafeEncode(a.isSupported, indent, out)
      out.write(",")
      out.write(""""is_verified_by":""")
      JsonEncoder.option(CharacterData.jsonEncoder).unsafeEncode(a.isVerifiedBy, indent, out)
      out.write(",")
      out.write(""""comments":""")
      JsonEncoder.option(CharacterData.jsonEncoder).unsafeEncode(a.comments, indent, out)
      out.write("}")
    }
  }
}