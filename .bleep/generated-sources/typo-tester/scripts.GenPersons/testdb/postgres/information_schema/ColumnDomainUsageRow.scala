/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package postgres
package information_schema

import anorm.RowParser
import anorm.Success
import play.api.libs.json.JsObject
import play.api.libs.json.JsResult
import play.api.libs.json.JsValue
import play.api.libs.json.Json
import play.api.libs.json.OFormat
import scala.util.Try

case class ColumnDomainUsageRow(
  domainCatalog: Option[String],
  domainSchema: Option[String],
  domainName: Option[String],
  tableCatalog: Option[String],
  tableSchema: Option[String],
  tableName: Option[String],
  columnName: Option[String]
)

object ColumnDomainUsageRow {
  def rowParser(prefix: String): RowParser[ColumnDomainUsageRow] = { row =>
    Success(
      ColumnDomainUsageRow(
        domainCatalog = row[Option[String]](prefix + "domain_catalog"),
        domainSchema = row[Option[String]](prefix + "domain_schema"),
        domainName = row[Option[String]](prefix + "domain_name"),
        tableCatalog = row[Option[String]](prefix + "table_catalog"),
        tableSchema = row[Option[String]](prefix + "table_schema"),
        tableName = row[Option[String]](prefix + "table_name"),
        columnName = row[Option[String]](prefix + "column_name")
      )
    )
  }

  implicit val oFormat: OFormat[ColumnDomainUsageRow] = new OFormat[ColumnDomainUsageRow]{
    override def writes(o: ColumnDomainUsageRow): JsObject =
      Json.obj(
        "domain_catalog" -> o.domainCatalog,
      "domain_schema" -> o.domainSchema,
      "domain_name" -> o.domainName,
      "table_catalog" -> o.tableCatalog,
      "table_schema" -> o.tableSchema,
      "table_name" -> o.tableName,
      "column_name" -> o.columnName
      )

    override def reads(json: JsValue): JsResult[ColumnDomainUsageRow] = {
      JsResult.fromTry(
        Try(
          ColumnDomainUsageRow(
            domainCatalog = json.\("domain_catalog").toOption.map(_.as[String]),
            domainSchema = json.\("domain_schema").toOption.map(_.as[String]),
            domainName = json.\("domain_name").toOption.map(_.as[String]),
            tableCatalog = json.\("table_catalog").toOption.map(_.as[String]),
            tableSchema = json.\("table_schema").toOption.map(_.as[String]),
            tableName = json.\("table_name").toOption.map(_.as[String]),
            columnName = json.\("column_name").toOption.map(_.as[String])
          )
        )
      )
    }
  }
}