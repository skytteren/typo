/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb

package object hardcoded {
  implicit val BigDecimalArrayParameterMetaData: anorm.ParameterMetaData[scala.Array[scala.math.BigDecimal]] = new anorm.ParameterMetaData[scala.Array[scala.math.BigDecimal]] {
    override def sqlType: java.lang.String = "_decimal"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
  }
  implicit val BigDecimalArrayToStatement: anorm.ToStatement[scala.Array[scala.math.BigDecimal]] = anorm.ToStatement[scala.Array[scala.math.BigDecimal]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("decimal", v.map(v => v: scala.AnyRef))))
  implicit val BooleanArrayParameterMetaData: anorm.ParameterMetaData[scala.Array[scala.Boolean]] = new anorm.ParameterMetaData[scala.Array[scala.Boolean]] {
    override def sqlType: java.lang.String = "_bool"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
  }
  implicit val BooleanArrayToStatement: anorm.ToStatement[scala.Array[scala.Boolean]] = anorm.ToStatement[scala.Array[scala.Boolean]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("bool", v.map(v => v: java.lang.Boolean))))
  implicit val DoubleArrayParameterMetaData: anorm.ParameterMetaData[scala.Array[scala.Double]] = new anorm.ParameterMetaData[scala.Array[scala.Double]] {
    override def sqlType: java.lang.String = "_float8"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
  }
  implicit val DoubleArrayToStatement: anorm.ToStatement[scala.Array[scala.Double]] = anorm.ToStatement[scala.Array[scala.Double]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("float8", v.map(v => v: java.lang.Double))))
  implicit val FloatArrayParameterMetaData: anorm.ParameterMetaData[scala.Array[scala.Float]] = new anorm.ParameterMetaData[scala.Array[scala.Float]] {
    override def sqlType: java.lang.String = "_float4"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
  }
  implicit val FloatArrayToStatement: anorm.ToStatement[scala.Array[scala.Float]] = anorm.ToStatement[scala.Array[scala.Float]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("float4", v.map(v => v: java.lang.Float))))
  implicit val IntArrayParameterMetaData: anorm.ParameterMetaData[scala.Array[scala.Int]] = new anorm.ParameterMetaData[scala.Array[scala.Int]] {
    override def sqlType: java.lang.String = "_int4"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
  }
  implicit val IntArrayToStatement: anorm.ToStatement[scala.Array[scala.Int]] = anorm.ToStatement[scala.Array[scala.Int]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("int4", v.map(v => v: java.lang.Integer))))
  implicit val LongArrayParameterMetaData: anorm.ParameterMetaData[scala.Array[scala.Long]] = new anorm.ParameterMetaData[scala.Array[scala.Long]] {
    override def sqlType: java.lang.String = "_int8"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
  }
  implicit val LongArrayToStatement: anorm.ToStatement[scala.Array[scala.Long]] = anorm.ToStatement[scala.Array[scala.Long]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("int8", v.map(v => v: java.lang.Long))))
  implicit val OffsetTimeReads: play.api.libs.json.Reads[java.time.OffsetTime] = implicitly[play.api.libs.json.Reads[java.lang.String]].flatMapResult { str =>
      try play.api.libs.json.JsSuccess(java.time.OffsetTime.parse(str)) catch {
        case x: java.time.format.DateTimeParseException => play.api.libs.json.JsError(s"must follow ${java.time.format.DateTimeFormatter.ISO_OFFSET_TIME}: ${x.getMessage}")
      }
    }
  implicit val OffsetTimeWrites: play.api.libs.json.Writes[java.time.OffsetTime] = implicitly[play.api.libs.json.Writes[java.lang.String]].contramap(_.toString)
  implicit val ShortArrayParameterMetaData: anorm.ParameterMetaData[scala.Array[scala.Short]] = new anorm.ParameterMetaData[scala.Array[scala.Short]] {
    override def sqlType: java.lang.String = "_int2"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
  }
  implicit val ShortArrayToStatement: anorm.ToStatement[scala.Array[scala.Short]] = anorm.ToStatement[scala.Array[scala.Short]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("int2", v.map(v => v: java.lang.Short))))
  implicit val StringArrayParameterMetaData: anorm.ParameterMetaData[scala.Array[java.lang.String]] = new anorm.ParameterMetaData[scala.Array[java.lang.String]] {
    override def sqlType: java.lang.String = "_varchar"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
  }
  implicit val StringArrayToStatement: anorm.ToStatement[scala.Array[java.lang.String]] = anorm.ToStatement[scala.Array[java.lang.String]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("varchar", v.map(v => v: scala.AnyRef))))
  implicit val UUIDArrayParameterMetaData: anorm.ParameterMetaData[scala.Array[java.util.UUID]] = new anorm.ParameterMetaData[scala.Array[java.util.UUID]] {
    override def sqlType: java.lang.String = "_uuid"
    override def jdbcType: scala.Int = java.sql.Types.ARRAY
  }
  implicit val UUIDArrayToStatement: anorm.ToStatement[scala.Array[java.util.UUID]] = anorm.ToStatement[scala.Array[java.util.UUID]]((ps, index, v) => ps.setArray(index, ps.getConnection.createArrayOf("uuid", v.map(v => v: scala.AnyRef))))
}
