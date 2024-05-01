/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package compositepk
package person

import anorm.NamedParameter
import anorm.ParameterMetaData
import anorm.ParameterValue
import anorm.RowParser
import anorm.SQL
import anorm.SimpleSql
import anorm.SqlStringInterpolation
import anorm.ToStatement
import java.sql.Connection
import testdb.hardcoded.customtypes.Defaulted
import testdb.hardcoded.streamingInsert
import typo.dsl.DeleteBuilder
import typo.dsl.SelectBuilder
import typo.dsl.SelectBuilderSql
import typo.dsl.UpdateBuilder

class PersonRepoImpl extends PersonRepo {
  override def delete: DeleteBuilder[PersonFields, PersonRow] = {
    DeleteBuilder("compositepk.person", PersonFields.structure)
  }
  override def deleteById(compositeId: PersonId)(implicit c: Connection): Boolean = {
    SQL"""delete from compositepk.person where "one" = ${ParameterValue(compositeId.one, null, ToStatement.longToStatement)} AND "two" = ${ParameterValue(compositeId.two, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}""".executeUpdate() > 0
  }
  override def insert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    SQL"""insert into compositepk.person("one", "two", "name")
          values (${ParameterValue(unsaved.one, null, ToStatement.longToStatement)}::int8, ${ParameterValue(unsaved.two, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}, ${ParameterValue(unsaved.name, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))})
          returning "one", "two", "name"
       """
      .executeInsert(PersonRow.rowParser(1).single)
    
  }
  override def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue(unsaved.name, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), "")),
      unsaved.one match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("one", ParameterValue(value, null, ToStatement.longToStatement)), "::int8"))
      },
      unsaved.two match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("two", ParameterValue(value, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))), ""))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into compositepk.person default values
            returning "one", "two", "name"
         """
        .executeInsert(PersonRow.rowParser(1).single)
    } else {
      val q = s"""insert into compositepk.person(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning "one", "two", "name"
               """
      SimpleSql(SQL(q), namedParameters.map { case (np, _) => np.tupled }.toMap, RowParser.successful)
        .executeInsert(PersonRow.rowParser(1).single)
    }
    
  }
  override def insertStreaming(unsaved: Iterator[PersonRow], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY compositepk.person("one", "two", "name") FROM STDIN""", batchSize, unsaved)(PersonRow.text, c)
  }
  /* NOTE: this functionality requires PostgreSQL 16 or later! */
  override def insertUnsavedStreaming(unsaved: Iterator[PersonRowUnsaved], batchSize: Int = 10000)(implicit c: Connection): Long = {
    streamingInsert(s"""COPY compositepk.person("name", "one", "two") FROM STDIN (DEFAULT '__DEFAULT_VALUE__')""", batchSize, unsaved)(PersonRowUnsaved.text, c)
  }
  override def select: SelectBuilder[PersonFields, PersonRow] = {
    SelectBuilderSql("compositepk.person", PersonFields.structure, PersonRow.rowParser)
  }
  override def selectAll(implicit c: Connection): List[PersonRow] = {
    SQL"""select "one", "two", "name"
          from compositepk.person
       """.as(PersonRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[?]])(implicit c: Connection): List[PersonRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParameters = nonEmpty.map{
          case PersonFieldValue.one(value) => NamedParameter("one", ParameterValue(value, null, ToStatement.longToStatement))
          case PersonFieldValue.two(value) => NamedParameter("two", ParameterValue(value, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData)))
          case PersonFieldValue.name(value) => NamedParameter("name", ParameterValue(value, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData)))
        }
        val quote = '"'.toString
        val q = s"""select "one", "two", "name"
                    from compositepk.person
                    where ${namedParameters.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        SimpleSql(SQL(q), namedParameters.map(_.tupled).toMap, RowParser.successful)
          .as(PersonRow.rowParser(1).*)
    }
    
  }
  override def selectById(compositeId: PersonId)(implicit c: Connection): Option[PersonRow] = {
    SQL"""select "one", "two", "name"
          from compositepk.person
          where "one" = ${ParameterValue(compositeId.one, null, ToStatement.longToStatement)} AND "two" = ${ParameterValue(compositeId.two, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}
       """.as(PersonRow.rowParser(1).singleOpt)
  }
  override def update: UpdateBuilder[PersonFields, PersonRow] = {
    UpdateBuilder("compositepk.person", PersonFields.structure, PersonRow.rowParser)
  }
  override def update(row: PersonRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update compositepk.person
          set "name" = ${ParameterValue(row.name, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}
          where "one" = ${ParameterValue(compositeId.one, null, ToStatement.longToStatement)} AND "two" = ${ParameterValue(compositeId.two, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}
       """.executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: PersonId, fieldValues: List[PersonFieldValue[?]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParameters = nonEmpty.map{
          case PersonFieldValue.name(value) => NamedParameter("name", ParameterValue(value, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData)))
        }
        val quote = '"'.toString
        val q = s"""update compositepk.person
                    set ${namedParameters.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where "one" = {one} AND "two" = {two}
                 """
        SimpleSql(SQL(q), namedParameters.map(_.tupled).toMap ++ List(("one", ParameterValue(compositeId.one, null, ToStatement.longToStatement)), ("two", ParameterValue(compositeId.two, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData)))), RowParser.successful)
          .executeUpdate() > 0
    }
    
  }
  override def upsert(unsaved: PersonRow)(implicit c: Connection): PersonRow = {
    SQL"""insert into compositepk.person("one", "two", "name")
          values (
            ${ParameterValue(unsaved.one, null, ToStatement.longToStatement)}::int8,
            ${ParameterValue(unsaved.two, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))},
            ${ParameterValue(unsaved.name, null, ToStatement.optionToStatement(ToStatement.stringToStatement, ParameterMetaData.StringParameterMetaData))}
          )
          on conflict ("one", "two")
          do update set
            "name" = EXCLUDED."name"
          returning "one", "two", "name"
       """
      .executeInsert(PersonRow.rowParser(1).single)
    
  }
}
