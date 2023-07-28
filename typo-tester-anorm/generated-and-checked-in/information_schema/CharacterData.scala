/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema

import anorm.Column
import anorm.ParameterMetaData
import anorm.ToStatement
import play.api.libs.json.Reads
import play.api.libs.json.Writes

/** Domain `information_schema.character_data`
  * No constraint
  */
case class CharacterData(value: String) extends AnyVal
object CharacterData {
  implicit val arrayToStatement: ToStatement[Array[CharacterData]] = implicitly[ToStatement[Array[String]]].contramap(_.map(_.value))
  implicit val column: Column[CharacterData] = implicitly[Column[String]].map(CharacterData.apply)
  implicit val ordering: Ordering[CharacterData] = Ordering.by(_.value)
  implicit val parameterMetadata: ParameterMetaData[CharacterData] = new ParameterMetaData[CharacterData] {
    override def sqlType: String = implicitly[ParameterMetaData[String]].sqlType
    override def jdbcType: Int = implicitly[ParameterMetaData[String]].jdbcType
  }
  implicit val reads: Reads[CharacterData] = implicitly[Reads[String]].map(CharacterData.apply)
  implicit val toStatement: ToStatement[CharacterData] = implicitly[ToStatement[String]].contramap(_.value)
  implicit val writes: Writes[CharacterData] = implicitly[Writes[String]].contramap(_.value)
}
