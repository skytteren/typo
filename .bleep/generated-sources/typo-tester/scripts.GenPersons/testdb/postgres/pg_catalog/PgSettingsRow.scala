/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package pg_catalog

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class PgSettingsRow(
  name: Option[String],
  setting: Option[String],
  unit: Option[String],
  category: Option[String],
  shortDesc: Option[String],
  extraDesc: Option[String],
  context: Option[String],
  vartype: Option[String],
  source: Option[String],
  minVal: Option[String],
  maxVal: Option[String],
  enumvals: Option[Array[String]],
  bootVal: Option[String],
  resetVal: Option[String],
  sourcefile: Option[String],
  sourceline: Option[Int],
  pendingRestart: Option[Boolean]
)

object PgSettingsRow {
  def rowParser(prefix: String): RowParser[PgSettingsRow] = { row =>
    Success(
      PgSettingsRow(
        name = row[Option[String]](prefix + "name"),
        setting = row[Option[String]](prefix + "setting"),
        unit = row[Option[String]](prefix + "unit"),
        category = row[Option[String]](prefix + "category"),
        shortDesc = row[Option[String]](prefix + "short_desc"),
        extraDesc = row[Option[String]](prefix + "extra_desc"),
        context = row[Option[String]](prefix + "context"),
        vartype = row[Option[String]](prefix + "vartype"),
        source = row[Option[String]](prefix + "source"),
        minVal = row[Option[String]](prefix + "min_val"),
        maxVal = row[Option[String]](prefix + "max_val"),
        enumvals = row[Option[Array[String]]](prefix + "enumvals"),
        bootVal = row[Option[String]](prefix + "boot_val"),
        resetVal = row[Option[String]](prefix + "reset_val"),
        sourcefile = row[Option[String]](prefix + "sourcefile"),
        sourceline = row[Option[Int]](prefix + "sourceline"),
        pendingRestart = row[Option[Boolean]](prefix + "pending_restart")
      )
    )
  }

  implicit val oFormat: OFormat[PgSettingsRow] = new OFormat[PgSettingsRow]{
    override def writes(o: PgSettingsRow): JsObject =
      Json.obj(
        "name" -> o.name,
      "setting" -> o.setting,
      "unit" -> o.unit,
      "category" -> o.category,
      "short_desc" -> o.shortDesc,
      "extra_desc" -> o.extraDesc,
      "context" -> o.context,
      "vartype" -> o.vartype,
      "source" -> o.source,
      "min_val" -> o.minVal,
      "max_val" -> o.maxVal,
      "enumvals" -> o.enumvals,
      "boot_val" -> o.bootVal,
      "reset_val" -> o.resetVal,
      "sourcefile" -> o.sourcefile,
      "sourceline" -> o.sourceline,
      "pending_restart" -> o.pendingRestart
      )

    override def reads(json: JsValue): JsResult[PgSettingsRow] = {
      JsResult.fromTry(
        Try(
          PgSettingsRow(
            name = json.\("name").toOption.map(_.as[String]),
            setting = json.\("setting").toOption.map(_.as[String]),
            unit = json.\("unit").toOption.map(_.as[String]),
            category = json.\("category").toOption.map(_.as[String]),
            shortDesc = json.\("short_desc").toOption.map(_.as[String]),
            extraDesc = json.\("extra_desc").toOption.map(_.as[String]),
            context = json.\("context").toOption.map(_.as[String]),
            vartype = json.\("vartype").toOption.map(_.as[String]),
            source = json.\("source").toOption.map(_.as[String]),
            minVal = json.\("min_val").toOption.map(_.as[String]),
            maxVal = json.\("max_val").toOption.map(_.as[String]),
            enumvals = json.\("enumvals").toOption.map(_.as[Array[String]]),
            bootVal = json.\("boot_val").toOption.map(_.as[String]),
            resetVal = json.\("reset_val").toOption.map(_.as[String]),
            sourcefile = json.\("sourcefile").toOption.map(_.as[String]),
            sourceline = json.\("sourceline").toOption.map(_.as[Int]),
            pendingRestart = json.\("pending_restart").toOption.map(_.as[Boolean])
          )
        )
      )
    }
  }
}