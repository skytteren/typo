/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package pgtestnull

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import fs2.Stream

object PgtestnullRepoImpl extends PgtestnullRepo {
  override def insert(unsaved: PgtestnullRow): ConnectionIO[PgtestnullRow] = {
    sql"""insert into "public".pgtestnull(box, circle, line, lseg, "path", point, polygon, "interval", money, "xml", json, jsonb, hstore, inet, "timestamp", timestampz, "time", timez, "date", uuid, boxes, circlees, linees, lseges, pathes, pointes, polygones, intervales, moneyes, xmles, jsones, jsonbes, hstores, inets, timestamps, timestampzs, times, timezs, dates, uuids)
          values (${unsaved.box}::box, ${unsaved.circle}::circle, ${unsaved.line}::line, ${unsaved.lseg}::lseg, ${unsaved.path}::path, ${unsaved.point}::point, ${unsaved.polygon}::polygon, ${unsaved.interval}::interval, ${unsaved.money}::money, ${unsaved.xml}::xml, ${unsaved.json}::json, ${unsaved.jsonb}::jsonb, ${unsaved.hstore}::hstore, ${unsaved.inet}::inet, ${unsaved.timestamp}::timestamp, ${unsaved.timestampz}::timestamptz, ${unsaved.time}::time, ${unsaved.timez}::timetz, ${unsaved.date}::date, ${unsaved.uuid}::uuid, ${unsaved.boxes}::_box, ${unsaved.circlees}::_circle, ${unsaved.linees}::_line, ${unsaved.lseges}::_lseg, ${unsaved.pathes}::_path, ${unsaved.pointes}::_point, ${unsaved.polygones}::_polygon, ${unsaved.intervales}::_interval, ${unsaved.moneyes}::_money, ${unsaved.xmles}::_xml, ${unsaved.jsones}::_json, ${unsaved.jsonbes}::_jsonb, ${unsaved.hstores}::_hstore, ${unsaved.inets}::_inet, ${unsaved.timestamps}::_timestamp, ${unsaved.timestampzs}::_timestamptz, ${unsaved.times}::_time, ${unsaved.timezs}::_timetz, ${unsaved.dates}::_date, ${unsaved.uuids}::_uuid)
          returning box, circle, line, lseg, "path", point, polygon, "interval", money::numeric, "xml", json, jsonb, hstore, inet, "timestamp"::text, timestampz::text, "time"::text, timez::text, "date"::text, uuid, boxes, circlees, linees, lseges, pathes, pointes, polygones, intervales, moneyes::numeric[], xmles, jsones, jsonbes, hstores, inets, timestamps::text[], timestampzs::text[], times::text[], timezs::text[], dates::text[], uuids
       """.query(PgtestnullRow.read).unique
  }
  override def selectAll: Stream[ConnectionIO, PgtestnullRow] = {
    sql"""select box, circle, line, lseg, "path", point, polygon, "interval", money::numeric, "xml", json, jsonb, hstore, inet, "timestamp"::text, timestampz::text, "time"::text, timez::text, "date"::text, uuid, boxes, circlees, linees, lseges, pathes, pointes, polygones, intervales, moneyes::numeric[], xmles, jsones, jsonbes, hstores, inets, timestamps::text[], timestampzs::text[], times::text[], timezs::text[], dates::text[], uuids from "public".pgtestnull""".query(PgtestnullRow.read).stream
  }
}
