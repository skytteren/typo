/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package information_schema
package foreign_data_wrappers

import adventureworks.information_schema.CharacterData
import adventureworks.information_schema.SqlIdentifier
import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ForeignDataWrappersViewRow(
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.foreignDataWrapperCatalog]] */
  foreignDataWrapperCatalog: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.foreignDataWrapperName]] */
  foreignDataWrapperName: Option[SqlIdentifier],
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.authorizationIdentifier]] */
  authorizationIdentifier: Option[SqlIdentifier],
  libraryName: Option[CharacterData],
  /** Points to [[`_pg_foreign_data_wrappers`.PgForeignDataWrappersViewRow.foreignDataWrapperLanguage]] */
  foreignDataWrapperLanguage: Option[CharacterData]
)

object ForeignDataWrappersViewRow {
  def rowParser(idx: Int): RowParser[ForeignDataWrappersViewRow] =
    RowParser[ForeignDataWrappersViewRow] { row =>
      Success(
        ForeignDataWrappersViewRow(
          foreignDataWrapperCatalog = row[Option[SqlIdentifier]](idx + 0),
          foreignDataWrapperName = row[Option[SqlIdentifier]](idx + 1),
          authorizationIdentifier = row[Option[SqlIdentifier]](idx + 2),
          libraryName = row[Option[CharacterData]](idx + 3),
          foreignDataWrapperLanguage = row[Option[CharacterData]](idx + 4)
        )
      )
    }
  implicit val oFormat: OFormat[ForeignDataWrappersViewRow] = new OFormat[ForeignDataWrappersViewRow]{
    override def writes(o: ForeignDataWrappersViewRow): JsObject =
      Json.obj(
        "foreign_data_wrapper_catalog" -> o.foreignDataWrapperCatalog,
        "foreign_data_wrapper_name" -> o.foreignDataWrapperName,
        "authorization_identifier" -> o.authorizationIdentifier,
        "library_name" -> o.libraryName,
        "foreign_data_wrapper_language" -> o.foreignDataWrapperLanguage
      )
  
    override def reads(json: JsValue): JsResult[ForeignDataWrappersViewRow] = {
      JsResult.fromTry(
        Try(
          ForeignDataWrappersViewRow(
            foreignDataWrapperCatalog = json.\("foreign_data_wrapper_catalog").toOption.map(_.as[SqlIdentifier]),
            foreignDataWrapperName = json.\("foreign_data_wrapper_name").toOption.map(_.as[SqlIdentifier]),
            authorizationIdentifier = json.\("authorization_identifier").toOption.map(_.as[SqlIdentifier]),
            libraryName = json.\("library_name").toOption.map(_.as[CharacterData]),
            foreignDataWrapperLanguage = json.\("foreign_data_wrapper_language").toOption.map(_.as[CharacterData])
          )
        )
      )
    }
  }
}