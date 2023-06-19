/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import adventureworks.public.Name
import anorm.RowParser
import anorm.Success
import java.time.LocalDateTime
import java.time.LocalTime
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ShiftRow(
  /** Primary key for Shift records. */
  shiftid: ShiftId,
  /** Shift description. */
  name: Name,
  /** Shift start time. */
  starttime: LocalTime,
  /** Shift end time. */
  endtime: LocalTime,
  modifieddate: LocalDateTime
)

object ShiftRow {
  val rowParser: RowParser[ShiftRow] =
    RowParser[ShiftRow] { row =>
      Success(
        ShiftRow(
          shiftid = row[ShiftId]("shiftid"),
          name = row[Name]("name"),
          starttime = row[LocalTime]("starttime"),
          endtime = row[LocalTime]("endtime"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  implicit val oFormat: OFormat[ShiftRow] = new OFormat[ShiftRow]{
    override def writes(o: ShiftRow): JsObject =
      Json.obj(
        "shiftid" -> o.shiftid,
        "name" -> o.name,
        "starttime" -> o.starttime,
        "endtime" -> o.endtime,
        "modifieddate" -> o.modifieddate
      )
  
    override def reads(json: JsValue): JsResult[ShiftRow] = {
      JsResult.fromTry(
        Try(
          ShiftRow(
            shiftid = json.\("shiftid").as[ShiftId],
            name = json.\("name").as[Name],
            starttime = json.\("starttime").as[LocalTime],
            endtime = json.\("endtime").as[LocalTime],
            modifieddate = json.\("modifieddate").as[LocalDateTime]
          )
        )
      )
    }
  }
}
