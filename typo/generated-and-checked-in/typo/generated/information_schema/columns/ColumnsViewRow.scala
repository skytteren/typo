/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated
package information_schema
package columns

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try
import typo.generated.information_schema.CardinalNumber
import typo.generated.information_schema.CharacterData
import typo.generated.information_schema.SqlIdentifier
import typo.generated.information_schema.YesOrNo

case class ColumnsViewRow(
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"table_catalog","ordinal_position":1,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"1","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  tableCatalog: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"table_schema","ordinal_position":2,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"2","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  tableSchema: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"table_name","ordinal_position":3,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"3","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  tableName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"column_name","ordinal_position":4,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"4","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  columnName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"ordinal_position","ordinal_position":5,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"5","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  ordinalPosition: Option[CardinalNumber],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"column_default","ordinal_position":6,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"6","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  columnDefault: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"is_nullable","ordinal_position":7,"is_nullable":"YES","data_type":"character varying","character_maximum_length":3,"character_octet_length":12,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"yes_or_no","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"7","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  isNullable: Option[YesOrNo],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"data_type","ordinal_position":8,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"8","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  dataType: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"character_maximum_length","ordinal_position":9,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"9","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  characterMaximumLength: Option[CardinalNumber],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"character_octet_length","ordinal_position":10,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"10","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  characterOctetLength: Option[CardinalNumber],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"numeric_precision","ordinal_position":11,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"11","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  numericPrecision: Option[CardinalNumber],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"numeric_precision_radix","ordinal_position":12,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"12","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  numericPrecisionRadix: Option[CardinalNumber],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"numeric_scale","ordinal_position":13,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"13","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  numericScale: Option[CardinalNumber],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"datetime_precision","ordinal_position":14,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"14","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  datetimePrecision: Option[CardinalNumber],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"interval_type","ordinal_position":15,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"15","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  intervalType: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"interval_precision","ordinal_position":16,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"16","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  intervalPrecision: Option[CardinalNumber],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"character_set_catalog","ordinal_position":17,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"17","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  characterSetCatalog: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"character_set_schema","ordinal_position":18,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"18","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  characterSetSchema: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"character_set_name","ordinal_position":19,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"19","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  characterSetName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"collation_catalog","ordinal_position":20,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"20","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  collationCatalog: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"collation_schema","ordinal_position":21,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"21","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  collationSchema: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"collation_name","ordinal_position":22,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"22","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  collationName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"domain_catalog","ordinal_position":23,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"23","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  domainCatalog: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"domain_schema","ordinal_position":24,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"24","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  domainSchema: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"domain_name","ordinal_position":25,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"25","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  domainName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"udt_catalog","ordinal_position":26,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"26","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  udtCatalog: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"udt_schema","ordinal_position":27,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"27","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  udtSchema: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"udt_name","ordinal_position":28,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"28","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  udtName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"scope_catalog","ordinal_position":29,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"29","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  scopeCatalog: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"scope_schema","ordinal_position":30,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"30","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  scopeSchema: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"scope_name","ordinal_position":31,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"31","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  scopeName: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"maximum_cardinality","ordinal_position":32,"is_nullable":"YES","data_type":"integer","numeric_precision":32,"numeric_precision_radix":2,"numeric_scale":0,"domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"cardinal_number","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"int4","dtd_identifier":"32","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  maximumCardinality: Option[CardinalNumber],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"dtd_identifier","ordinal_position":33,"is_nullable":"YES","data_type":"name","collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"sql_identifier","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"name","dtd_identifier":"33","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  dtdIdentifier: Option[SqlIdentifier],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"is_self_referencing","ordinal_position":34,"is_nullable":"YES","data_type":"character varying","character_maximum_length":3,"character_octet_length":12,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"yes_or_no","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"34","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  isSelfReferencing: Option[YesOrNo],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"is_identity","ordinal_position":35,"is_nullable":"YES","data_type":"character varying","character_maximum_length":3,"character_octet_length":12,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"yes_or_no","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"35","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  isIdentity: Option[YesOrNo],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"identity_generation","ordinal_position":36,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"36","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  identityGeneration: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"identity_start","ordinal_position":37,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"37","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  identityStart: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"identity_increment","ordinal_position":38,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"38","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  identityIncrement: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"identity_maximum","ordinal_position":39,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"39","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  identityMaximum: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"identity_minimum","ordinal_position":40,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"40","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  identityMinimum: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"identity_cycle","ordinal_position":41,"is_nullable":"YES","data_type":"character varying","character_maximum_length":3,"character_octet_length":12,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"yes_or_no","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"41","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  identityCycle: Option[YesOrNo],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"is_generated","ordinal_position":42,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"42","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  isGenerated: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"generation_expression","ordinal_position":43,"is_nullable":"YES","data_type":"character varying","character_octet_length":1073741824,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"character_data","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"43","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  generationExpression: Option[CharacterData],
  /** debug: {"table_catalog":"postgres","table_schema":"information_schema","table_name":"columns","column_name":"is_updatable","ordinal_position":44,"is_nullable":"YES","data_type":"character varying","character_maximum_length":3,"character_octet_length":12,"collation_catalog":"postgres","collation_schema":"pg_catalog","collation_name":"C","domain_catalog":"postgres","domain_schema":"information_schema","domain_name":"yes_or_no","udt_catalog":"postgres","udt_schema":"pg_catalog","udt_name":"varchar","dtd_identifier":"44","is_self_referencing":"NO","is_identity":"NO","identity_cycle":"NO","is_generated":"NEVER","is_updatable":"NO"} */
  isUpdatable: Option[YesOrNo]
)

object ColumnsViewRow {
  val rowParser: RowParser[ColumnsViewRow] =
    RowParser[ColumnsViewRow] { row =>
      Success(
        ColumnsViewRow(
          tableCatalog = row[Option[SqlIdentifier]]("table_catalog"),
          tableSchema = row[Option[SqlIdentifier]]("table_schema"),
          tableName = row[Option[SqlIdentifier]]("table_name"),
          columnName = row[Option[SqlIdentifier]]("column_name"),
          ordinalPosition = row[Option[CardinalNumber]]("ordinal_position"),
          columnDefault = row[Option[CharacterData]]("column_default"),
          isNullable = row[Option[YesOrNo]]("is_nullable"),
          dataType = row[Option[CharacterData]]("data_type"),
          characterMaximumLength = row[Option[CardinalNumber]]("character_maximum_length"),
          characterOctetLength = row[Option[CardinalNumber]]("character_octet_length"),
          numericPrecision = row[Option[CardinalNumber]]("numeric_precision"),
          numericPrecisionRadix = row[Option[CardinalNumber]]("numeric_precision_radix"),
          numericScale = row[Option[CardinalNumber]]("numeric_scale"),
          datetimePrecision = row[Option[CardinalNumber]]("datetime_precision"),
          intervalType = row[Option[CharacterData]]("interval_type"),
          intervalPrecision = row[Option[CardinalNumber]]("interval_precision"),
          characterSetCatalog = row[Option[SqlIdentifier]]("character_set_catalog"),
          characterSetSchema = row[Option[SqlIdentifier]]("character_set_schema"),
          characterSetName = row[Option[SqlIdentifier]]("character_set_name"),
          collationCatalog = row[Option[SqlIdentifier]]("collation_catalog"),
          collationSchema = row[Option[SqlIdentifier]]("collation_schema"),
          collationName = row[Option[SqlIdentifier]]("collation_name"),
          domainCatalog = row[Option[SqlIdentifier]]("domain_catalog"),
          domainSchema = row[Option[SqlIdentifier]]("domain_schema"),
          domainName = row[Option[SqlIdentifier]]("domain_name"),
          udtCatalog = row[Option[SqlIdentifier]]("udt_catalog"),
          udtSchema = row[Option[SqlIdentifier]]("udt_schema"),
          udtName = row[Option[SqlIdentifier]]("udt_name"),
          scopeCatalog = row[Option[SqlIdentifier]]("scope_catalog"),
          scopeSchema = row[Option[SqlIdentifier]]("scope_schema"),
          scopeName = row[Option[SqlIdentifier]]("scope_name"),
          maximumCardinality = row[Option[CardinalNumber]]("maximum_cardinality"),
          dtdIdentifier = row[Option[SqlIdentifier]]("dtd_identifier"),
          isSelfReferencing = row[Option[YesOrNo]]("is_self_referencing"),
          isIdentity = row[Option[YesOrNo]]("is_identity"),
          identityGeneration = row[Option[CharacterData]]("identity_generation"),
          identityStart = row[Option[CharacterData]]("identity_start"),
          identityIncrement = row[Option[CharacterData]]("identity_increment"),
          identityMaximum = row[Option[CharacterData]]("identity_maximum"),
          identityMinimum = row[Option[CharacterData]]("identity_minimum"),
          identityCycle = row[Option[YesOrNo]]("identity_cycle"),
          isGenerated = row[Option[CharacterData]]("is_generated"),
          generationExpression = row[Option[CharacterData]]("generation_expression"),
          isUpdatable = row[Option[YesOrNo]]("is_updatable")
        )
      )
    }
  implicit val oFormat: OFormat[ColumnsViewRow] = new OFormat[ColumnsViewRow]{
    override def writes(o: ColumnsViewRow): JsObject =
      Json.obj(
        "table_catalog" -> o.tableCatalog,
        "table_schema" -> o.tableSchema,
        "table_name" -> o.tableName,
        "column_name" -> o.columnName,
        "ordinal_position" -> o.ordinalPosition,
        "column_default" -> o.columnDefault,
        "is_nullable" -> o.isNullable,
        "data_type" -> o.dataType,
        "character_maximum_length" -> o.characterMaximumLength,
        "character_octet_length" -> o.characterOctetLength,
        "numeric_precision" -> o.numericPrecision,
        "numeric_precision_radix" -> o.numericPrecisionRadix,
        "numeric_scale" -> o.numericScale,
        "datetime_precision" -> o.datetimePrecision,
        "interval_type" -> o.intervalType,
        "interval_precision" -> o.intervalPrecision,
        "character_set_catalog" -> o.characterSetCatalog,
        "character_set_schema" -> o.characterSetSchema,
        "character_set_name" -> o.characterSetName,
        "collation_catalog" -> o.collationCatalog,
        "collation_schema" -> o.collationSchema,
        "collation_name" -> o.collationName,
        "domain_catalog" -> o.domainCatalog,
        "domain_schema" -> o.domainSchema,
        "domain_name" -> o.domainName,
        "udt_catalog" -> o.udtCatalog,
        "udt_schema" -> o.udtSchema,
        "udt_name" -> o.udtName,
        "scope_catalog" -> o.scopeCatalog,
        "scope_schema" -> o.scopeSchema,
        "scope_name" -> o.scopeName,
        "maximum_cardinality" -> o.maximumCardinality,
        "dtd_identifier" -> o.dtdIdentifier,
        "is_self_referencing" -> o.isSelfReferencing,
        "is_identity" -> o.isIdentity,
        "identity_generation" -> o.identityGeneration,
        "identity_start" -> o.identityStart,
        "identity_increment" -> o.identityIncrement,
        "identity_maximum" -> o.identityMaximum,
        "identity_minimum" -> o.identityMinimum,
        "identity_cycle" -> o.identityCycle,
        "is_generated" -> o.isGenerated,
        "generation_expression" -> o.generationExpression,
        "is_updatable" -> o.isUpdatable
      )
  
    override def reads(json: JsValue): JsResult[ColumnsViewRow] = {
      JsResult.fromTry(
        Try(
          ColumnsViewRow(
            tableCatalog = json.\("table_catalog").toOption.map(_.as[SqlIdentifier]),
            tableSchema = json.\("table_schema").toOption.map(_.as[SqlIdentifier]),
            tableName = json.\("table_name").toOption.map(_.as[SqlIdentifier]),
            columnName = json.\("column_name").toOption.map(_.as[SqlIdentifier]),
            ordinalPosition = json.\("ordinal_position").toOption.map(_.as[CardinalNumber]),
            columnDefault = json.\("column_default").toOption.map(_.as[CharacterData]),
            isNullable = json.\("is_nullable").toOption.map(_.as[YesOrNo]),
            dataType = json.\("data_type").toOption.map(_.as[CharacterData]),
            characterMaximumLength = json.\("character_maximum_length").toOption.map(_.as[CardinalNumber]),
            characterOctetLength = json.\("character_octet_length").toOption.map(_.as[CardinalNumber]),
            numericPrecision = json.\("numeric_precision").toOption.map(_.as[CardinalNumber]),
            numericPrecisionRadix = json.\("numeric_precision_radix").toOption.map(_.as[CardinalNumber]),
            numericScale = json.\("numeric_scale").toOption.map(_.as[CardinalNumber]),
            datetimePrecision = json.\("datetime_precision").toOption.map(_.as[CardinalNumber]),
            intervalType = json.\("interval_type").toOption.map(_.as[CharacterData]),
            intervalPrecision = json.\("interval_precision").toOption.map(_.as[CardinalNumber]),
            characterSetCatalog = json.\("character_set_catalog").toOption.map(_.as[SqlIdentifier]),
            characterSetSchema = json.\("character_set_schema").toOption.map(_.as[SqlIdentifier]),
            characterSetName = json.\("character_set_name").toOption.map(_.as[SqlIdentifier]),
            collationCatalog = json.\("collation_catalog").toOption.map(_.as[SqlIdentifier]),
            collationSchema = json.\("collation_schema").toOption.map(_.as[SqlIdentifier]),
            collationName = json.\("collation_name").toOption.map(_.as[SqlIdentifier]),
            domainCatalog = json.\("domain_catalog").toOption.map(_.as[SqlIdentifier]),
            domainSchema = json.\("domain_schema").toOption.map(_.as[SqlIdentifier]),
            domainName = json.\("domain_name").toOption.map(_.as[SqlIdentifier]),
            udtCatalog = json.\("udt_catalog").toOption.map(_.as[SqlIdentifier]),
            udtSchema = json.\("udt_schema").toOption.map(_.as[SqlIdentifier]),
            udtName = json.\("udt_name").toOption.map(_.as[SqlIdentifier]),
            scopeCatalog = json.\("scope_catalog").toOption.map(_.as[SqlIdentifier]),
            scopeSchema = json.\("scope_schema").toOption.map(_.as[SqlIdentifier]),
            scopeName = json.\("scope_name").toOption.map(_.as[SqlIdentifier]),
            maximumCardinality = json.\("maximum_cardinality").toOption.map(_.as[CardinalNumber]),
            dtdIdentifier = json.\("dtd_identifier").toOption.map(_.as[SqlIdentifier]),
            isSelfReferencing = json.\("is_self_referencing").toOption.map(_.as[YesOrNo]),
            isIdentity = json.\("is_identity").toOption.map(_.as[YesOrNo]),
            identityGeneration = json.\("identity_generation").toOption.map(_.as[CharacterData]),
            identityStart = json.\("identity_start").toOption.map(_.as[CharacterData]),
            identityIncrement = json.\("identity_increment").toOption.map(_.as[CharacterData]),
            identityMaximum = json.\("identity_maximum").toOption.map(_.as[CharacterData]),
            identityMinimum = json.\("identity_minimum").toOption.map(_.as[CharacterData]),
            identityCycle = json.\("identity_cycle").toOption.map(_.as[YesOrNo]),
            isGenerated = json.\("is_generated").toOption.map(_.as[CharacterData]),
            generationExpression = json.\("generation_expression").toOption.map(_.as[CharacterData]),
            isUpdatable = json.\("is_updatable").toOption.map(_.as[YesOrNo])
          )
        )
      )
    }
  }
}
