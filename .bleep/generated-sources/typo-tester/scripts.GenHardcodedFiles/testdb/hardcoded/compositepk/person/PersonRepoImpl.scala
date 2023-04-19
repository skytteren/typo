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
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import java.sql.Connection

object PersonRepoImpl extends PersonRepo {
  override def delete(compositeId: PersonId)(implicit c: Connection): Boolean = {
    SQL"""delete from compositepk.person where one = ${compositeId.one}, two = ${compositeId.two}""".executeUpdate() > 0
  }
  override def insert(unsaved: PersonRowUnsaved)(implicit c: Connection): PersonId = {
    SQL"""insert into compositepk.person(name)
          values (${unsaved.name})
          returning one, two
    """
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[PersonRow] = {
    SQL"""select one, two, name from compositepk.person""".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[PersonFieldOrIdValue[_]])(implicit c: Connection): List[PersonRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PersonFieldValue.one(value) => NamedParameter("one", ParameterValue.from(value))
          case PersonFieldValue.two(value) => NamedParameter("two", ParameterValue.from(value))
          case PersonFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
        }
        val q = s"""select * from compositepk.person where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(compositeId: PersonId)(implicit c: Connection): Option[PersonRow] = {
    SQL"""select one, two, name from compositepk.person where one = ${compositeId.one}, two = ${compositeId.two}""".as(rowParser.singleOpt)
  }
  override def update(row: PersonRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update compositepk.person
          set name = ${row.name}
          where one = ${compositeId.one}, two = ${compositeId.two}""".executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: PersonId, fieldValues: List[PersonFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PersonFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
        }
        val q = s"""update compositepk.person
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where one = ${compositeId.one}, two = ${compositeId.two}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[PersonRow] =
    RowParser[PersonRow] { row =>
      Success(
        PersonRow(
          one = row[Long]("one"),
          two = row[Option[String]]("two"),
          name = row[Option[String]]("name")
        )
      )
    }
  val idRowParser: RowParser[PersonId] =
    RowParser[PersonId] { row =>
      Success(
        PersonId(
          one = row[Long]("one"),
          two = row[Option[String]]("two")
        )
      )
    }
}
