/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package shift

import adventureworks.Defaulted
import adventureworks.public.Name
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime
import java.time.LocalTime

object ShiftRepoImpl extends ShiftRepo {
  override def delete(shiftid: ShiftId)(implicit c: Connection): Boolean = {
    SQL"delete from humanresources.shift where shiftid = $shiftid".executeUpdate() > 0
  }
  override def insert(unsaved: ShiftRow)(implicit c: Connection): ShiftRow = {
    SQL"""insert into humanresources.shift(shiftid, "name", starttime, endtime, modifieddate)
          values (${unsaved.shiftid}::int4, ${unsaved.name}::"public"."Name", ${unsaved.starttime}::time, ${unsaved.endtime}::time, ${unsaved.modifieddate}::timestamp)
          returning shiftid, "name", starttime, endtime, modifieddate
       """
      .executeInsert(rowParser.single)
  
  }
  override def insert(unsaved: ShiftRowUnsaved)(implicit c: Connection): ShiftRow = {
    val namedParameters = List(
      Some((NamedParameter("name", ParameterValue.from(unsaved.name)), """::"public"."Name"""")),
      Some((NamedParameter("starttime", ParameterValue.from(unsaved.starttime)), "::time")),
      Some((NamedParameter("endtime", ParameterValue.from(unsaved.endtime)), "::time")),
      unsaved.shiftid match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("shiftid", ParameterValue.from[ShiftId](value)), "::int4"))
      },
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into humanresources.shift default values
            returning shiftid, "name", starttime, endtime, modifieddate
         """
        .executeInsert(rowParser.single)
    } else {
      val q = s"""insert into humanresources.shift(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning shiftid, "name", starttime, endtime, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(rowParser.single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[ShiftRow] = {
    SQL"""select shiftid, "name", starttime, endtime, modifieddate
          from humanresources.shift
       """.as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ShiftFieldOrIdValue[_]])(implicit c: Connection): List[ShiftRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ShiftFieldValue.shiftid(value) => NamedParameter("shiftid", ParameterValue.from(value))
          case ShiftFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ShiftFieldValue.starttime(value) => NamedParameter("starttime", ParameterValue.from(value))
          case ShiftFieldValue.endtime(value) => NamedParameter("endtime", ParameterValue.from(value))
          case ShiftFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select shiftid, "name", starttime, endtime, modifieddate
                    from humanresources.shift
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(shiftid: ShiftId)(implicit c: Connection): Option[ShiftRow] = {
    SQL"""select shiftid, "name", starttime, endtime, modifieddate
          from humanresources.shift
          where shiftid = $shiftid
       """.as(rowParser.singleOpt)
  }
  override def selectByIds(shiftids: Array[ShiftId])(implicit c: Connection): List[ShiftRow] = {
    implicit val toStatement: ToStatement[Array[ShiftId]] =
      (s: PreparedStatement, index: Int, v: Array[ShiftId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"""select shiftid, "name", starttime, endtime, modifieddate
          from humanresources.shift
          where shiftid = ANY($shiftids)
       """.as(rowParser.*)
  
  }
  override def update(row: ShiftRow)(implicit c: Connection): Boolean = {
    val shiftid = row.shiftid
    SQL"""update humanresources.shift
          set "name" = ${row.name}::"public"."Name",
              starttime = ${row.starttime}::time,
              endtime = ${row.endtime}::time,
              modifieddate = ${row.modifieddate}::timestamp
          where shiftid = $shiftid
       """.executeUpdate() > 0
  }
  override def updateFieldValues(shiftid: ShiftId, fieldValues: List[ShiftFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ShiftFieldValue.name(value) => NamedParameter("name", ParameterValue.from(value))
          case ShiftFieldValue.starttime(value) => NamedParameter("starttime", ParameterValue.from(value))
          case ShiftFieldValue.endtime(value) => NamedParameter("endtime", ParameterValue.from(value))
          case ShiftFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update humanresources.shift
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where shiftid = {shiftid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("shiftid", ParameterValue.from(shiftid)))
          .executeUpdate() > 0
    }
  
  }
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
}