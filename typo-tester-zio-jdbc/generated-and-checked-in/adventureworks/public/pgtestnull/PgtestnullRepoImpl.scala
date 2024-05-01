/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package public
package pgtestnull

import adventureworks.customtypes.TypoBox
import adventureworks.customtypes.TypoBytea
import adventureworks.customtypes.TypoCircle
import adventureworks.customtypes.TypoHStore
import adventureworks.customtypes.TypoInet
import adventureworks.customtypes.TypoInstant
import adventureworks.customtypes.TypoInt2Vector
import adventureworks.customtypes.TypoInterval
import adventureworks.customtypes.TypoJson
import adventureworks.customtypes.TypoJsonb
import adventureworks.customtypes.TypoLine
import adventureworks.customtypes.TypoLineSegment
import adventureworks.customtypes.TypoLocalDate
import adventureworks.customtypes.TypoLocalDateTime
import adventureworks.customtypes.TypoLocalTime
import adventureworks.customtypes.TypoMoney
import adventureworks.customtypes.TypoOffsetTime
import adventureworks.customtypes.TypoPath
import adventureworks.customtypes.TypoPoint
import adventureworks.customtypes.TypoPolygon
import adventureworks.customtypes.TypoShort
import adventureworks.customtypes.TypoUUID
import adventureworks.customtypes.TypoVector
import adventureworks.customtypes.TypoXml
import adventureworks.public.Mydomain
import adventureworks.public.Myenum
import adventureworks.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder
import zio.ZIO
import zio.jdbc.SqlFragment.Segment
import zio.jdbc.SqlFragment.Setter
import zio.jdbc.ZConnection
import zio.jdbc.sqlInterpolator
import zio.stream.ZStream

class PgtestnullRepoImpl extends PgtestnullRepo {
  override def delete: DeleteBuilder[PgtestnullFields, PgtestnullRow] = {
    DeleteBuilder("public.pgtestnull", PgtestnullFields.structure)
  }
  override def insert(unsaved: PgtestnullRow): ZIO[ZConnection, Throwable, PgtestnullRow] = {
    sql"""insert into public.pgtestnull("bool", "box", "bpchar", "bytea", "char", "circle", "date", "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money", "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time", "timestamp", "timestampz", "timez", "uuid", "varchar", "vector", "xml", "boxes", "bpchares", "chares", "circlees", "datees", "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes", "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees", "timestampes", "timestampzes", "timezes", "uuides", "varchares", "xmles")
          values (${Segment.paramSegment(unsaved.bool)(Setter.optionParamSetter(Setter.booleanSetter))}, ${Segment.paramSegment(unsaved.box)(Setter.optionParamSetter(TypoBox.setter))}::box, ${Segment.paramSegment(unsaved.bpchar)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar, ${Segment.paramSegment(unsaved.bytea)(Setter.optionParamSetter(TypoBytea.setter))}::bytea, ${Segment.paramSegment(unsaved.char)(Setter.optionParamSetter(Setter.stringSetter))}::bpchar, ${Segment.paramSegment(unsaved.circle)(Setter.optionParamSetter(TypoCircle.setter))}::circle, ${Segment.paramSegment(unsaved.date)(Setter.optionParamSetter(TypoLocalDate.setter))}::date, ${Segment.paramSegment(unsaved.float4)(Setter.optionParamSetter(Setter.floatSetter))}::float4, ${Segment.paramSegment(unsaved.float8)(Setter.optionParamSetter(Setter.doubleSetter))}::float8, ${Segment.paramSegment(unsaved.hstore)(Setter.optionParamSetter(TypoHStore.setter))}::hstore, ${Segment.paramSegment(unsaved.inet)(Setter.optionParamSetter(TypoInet.setter))}::inet, ${Segment.paramSegment(unsaved.int2)(Setter.optionParamSetter(TypoShort.setter))}::int2, ${Segment.paramSegment(unsaved.int2vector)(Setter.optionParamSetter(TypoInt2Vector.setter))}::int2vector, ${Segment.paramSegment(unsaved.int4)(Setter.optionParamSetter(Setter.intSetter))}::int4, ${Segment.paramSegment(unsaved.int8)(Setter.optionParamSetter(Setter.longSetter))}::int8, ${Segment.paramSegment(unsaved.interval)(Setter.optionParamSetter(TypoInterval.setter))}::interval, ${Segment.paramSegment(unsaved.json)(Setter.optionParamSetter(TypoJson.setter))}::json, ${Segment.paramSegment(unsaved.jsonb)(Setter.optionParamSetter(TypoJsonb.setter))}::jsonb, ${Segment.paramSegment(unsaved.line)(Setter.optionParamSetter(TypoLine.setter))}::line, ${Segment.paramSegment(unsaved.lseg)(Setter.optionParamSetter(TypoLineSegment.setter))}::lseg, ${Segment.paramSegment(unsaved.money)(Setter.optionParamSetter(TypoMoney.setter))}::money, ${Segment.paramSegment(unsaved.mydomain)(Setter.optionParamSetter(Mydomain.setter))}::text, ${Segment.paramSegment(unsaved.myenum)(Setter.optionParamSetter(Myenum.setter))}::public.myenum, ${Segment.paramSegment(unsaved.name)(Setter.optionParamSetter(Setter.stringSetter))}::name, ${Segment.paramSegment(unsaved.numeric)(Setter.optionParamSetter(Setter.bigDecimalScalaSetter))}::numeric, ${Segment.paramSegment(unsaved.path)(Setter.optionParamSetter(TypoPath.setter))}::path, ${Segment.paramSegment(unsaved.point)(Setter.optionParamSetter(TypoPoint.setter))}::point, ${Segment.paramSegment(unsaved.polygon)(Setter.optionParamSetter(TypoPolygon.setter))}::polygon, ${Segment.paramSegment(unsaved.text)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.time)(Setter.optionParamSetter(TypoLocalTime.setter))}::time, ${Segment.paramSegment(unsaved.timestamp)(Setter.optionParamSetter(TypoLocalDateTime.setter))}::timestamp, ${Segment.paramSegment(unsaved.timestampz)(Setter.optionParamSetter(TypoInstant.setter))}::timestamptz, ${Segment.paramSegment(unsaved.timez)(Setter.optionParamSetter(TypoOffsetTime.setter))}::timetz, ${Segment.paramSegment(unsaved.uuid)(Setter.optionParamSetter(TypoUUID.setter))}::uuid, ${Segment.paramSegment(unsaved.varchar)(Setter.optionParamSetter(Setter.stringSetter))}, ${Segment.paramSegment(unsaved.vector)(Setter.optionParamSetter(TypoVector.setter))}::vector, ${Segment.paramSegment(unsaved.xml)(Setter.optionParamSetter(TypoXml.setter))}::xml, ${Segment.paramSegment(unsaved.boxes)(Setter.optionParamSetter(TypoBox.arraySetter))}::_box, ${Segment.paramSegment(unsaved.bpchares)(Setter.optionParamSetter(adventureworks.StringArraySetter))}::_bpchar, ${Segment.paramSegment(unsaved.chares)(Setter.optionParamSetter(adventureworks.StringArraySetter))}::_bpchar, ${Segment.paramSegment(unsaved.circlees)(Setter.optionParamSetter(TypoCircle.arraySetter))}::_circle, ${Segment.paramSegment(unsaved.datees)(Setter.optionParamSetter(TypoLocalDate.arraySetter))}::_date, ${Segment.paramSegment(unsaved.float4es)(Setter.optionParamSetter(adventureworks.FloatArraySetter))}::_float4, ${Segment.paramSegment(unsaved.float8es)(Setter.optionParamSetter(adventureworks.DoubleArraySetter))}::_float8, ${Segment.paramSegment(unsaved.inetes)(Setter.optionParamSetter(TypoInet.arraySetter))}::_inet, ${Segment.paramSegment(unsaved.int2es)(Setter.optionParamSetter(TypoShort.arraySetter))}::_int2, ${Segment.paramSegment(unsaved.int2vectores)(Setter.optionParamSetter(TypoInt2Vector.arraySetter))}::_int2vector, ${Segment.paramSegment(unsaved.int4es)(Setter.optionParamSetter(adventureworks.IntArraySetter))}::_int4, ${Segment.paramSegment(unsaved.int8es)(Setter.optionParamSetter(adventureworks.LongArraySetter))}::_int8, ${Segment.paramSegment(unsaved.intervales)(Setter.optionParamSetter(TypoInterval.arraySetter))}::_interval, ${Segment.paramSegment(unsaved.jsones)(Setter.optionParamSetter(TypoJson.arraySetter))}::_json, ${Segment.paramSegment(unsaved.jsonbes)(Setter.optionParamSetter(TypoJsonb.arraySetter))}::_jsonb, ${Segment.paramSegment(unsaved.linees)(Setter.optionParamSetter(TypoLine.arraySetter))}::_line, ${Segment.paramSegment(unsaved.lseges)(Setter.optionParamSetter(TypoLineSegment.arraySetter))}::_lseg, ${Segment.paramSegment(unsaved.moneyes)(Setter.optionParamSetter(TypoMoney.arraySetter))}::_money, ${Segment.paramSegment(unsaved.myenumes)(Setter.optionParamSetter(Myenum.arraySetter))}::_myenum, ${Segment.paramSegment(unsaved.namees)(Setter.optionParamSetter(adventureworks.StringArraySetter))}::_name, ${Segment.paramSegment(unsaved.numerices)(Setter.optionParamSetter(adventureworks.ScalaBigDecimalArraySetter))}::_numeric, ${Segment.paramSegment(unsaved.pathes)(Setter.optionParamSetter(TypoPath.arraySetter))}::_path, ${Segment.paramSegment(unsaved.pointes)(Setter.optionParamSetter(TypoPoint.arraySetter))}::_point, ${Segment.paramSegment(unsaved.polygones)(Setter.optionParamSetter(TypoPolygon.arraySetter))}::_polygon, ${Segment.paramSegment(unsaved.textes)(Setter.optionParamSetter(adventureworks.StringArraySetter))}::_text, ${Segment.paramSegment(unsaved.timees)(Setter.optionParamSetter(TypoLocalTime.arraySetter))}::_time, ${Segment.paramSegment(unsaved.timestampes)(Setter.optionParamSetter(TypoLocalDateTime.arraySetter))}::_timestamp, ${Segment.paramSegment(unsaved.timestampzes)(Setter.optionParamSetter(TypoInstant.arraySetter))}::_timestamptz, ${Segment.paramSegment(unsaved.timezes)(Setter.optionParamSetter(TypoOffsetTime.arraySetter))}::_timetz, ${Segment.paramSegment(unsaved.uuides)(Setter.optionParamSetter(TypoUUID.arraySetter))}::_uuid, ${Segment.paramSegment(unsaved.varchares)(Setter.optionParamSetter(adventureworks.StringArraySetter))}::_varchar, ${Segment.paramSegment(unsaved.xmles)(Setter.optionParamSetter(TypoXml.arraySetter))}::_xml)
          returning "bool", "box", "bpchar", "bytea", "char", "circle", "date"::text, "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money"::numeric, "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time"::text, "timestamp"::text, "timestampz"::text, "timez"::text, "uuid", "varchar", "vector"::float4[], "xml", "boxes", "bpchares", "chares", "circlees", "datees"::text[], "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes"::numeric[], "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees"::text[], "timestampes"::text[], "timestampzes"::text[], "timezes"::text[], "uuides", "varchares", "xmles"
       """.insertReturning(using PgtestnullRow.jdbcDecoder).map(_.updatedKeys.head)
  }
  override def insertStreaming(unsaved: ZStream[ZConnection, Throwable, PgtestnullRow], batchSize: Int = 10000): ZIO[ZConnection, Throwable, Long] = {
    streamingInsert(s"""COPY public.pgtestnull("bool", "box", "bpchar", "bytea", "char", "circle", "date", "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money", "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time", "timestamp", "timestampz", "timez", "uuid", "varchar", "vector", "xml", "boxes", "bpchares", "chares", "circlees", "datees", "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes", "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees", "timestampes", "timestampzes", "timezes", "uuides", "varchares", "xmles") FROM STDIN""", batchSize, unsaved)(PgtestnullRow.text)
  }
  override def select: SelectBuilder[PgtestnullFields, PgtestnullRow] = {
    SelectBuilderSql("public.pgtestnull", PgtestnullFields.structure, PgtestnullRow.jdbcDecoder)
  }
  override def selectAll: ZStream[ZConnection, Throwable, PgtestnullRow] = {
    sql"""select "bool", "box", "bpchar", "bytea", "char", "circle", "date"::text, "float4", "float8", "hstore", "inet", "int2", "int2vector", "int4", "int8", "interval", "json", "jsonb", "line", "lseg", "money"::numeric, "mydomain", "myenum", "name", "numeric", "path", "point", "polygon", "text", "time"::text, "timestamp"::text, "timestampz"::text, "timez"::text, "uuid", "varchar", "vector"::float4[], "xml", "boxes", "bpchares", "chares", "circlees", "datees"::text[], "float4es", "float8es", "inetes", "int2es", "int2vectores", "int4es", "int8es", "intervales", "jsones", "jsonbes", "linees", "lseges", "moneyes"::numeric[], "myenumes", "namees", "numerices", "pathes", "pointes", "polygones", "textes", "timees"::text[], "timestampes"::text[], "timestampzes"::text[], "timezes"::text[], "uuides", "varchares", "xmles" from public.pgtestnull""".query(using PgtestnullRow.jdbcDecoder).selectStream()
  }
  override def update: UpdateBuilder[PgtestnullFields, PgtestnullRow] = {
    UpdateBuilder("public.pgtestnull", PgtestnullFields.structure, PgtestnullRow.jdbcDecoder)
  }
}
