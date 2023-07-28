/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package sales
package personcreditcard

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.SqlStringInterpolation
import java.sql.Connection
import java.time.LocalDateTime

object PersoncreditcardRepoImpl extends PersoncreditcardRepo {
  override def delete(compositeId: PersoncreditcardId)(implicit c: Connection): Boolean = {
    SQL"delete from sales.personcreditcard where businessentityid = ${compositeId.businessentityid} AND creditcardid = ${compositeId.creditcardid}".executeUpdate() > 0
  }
  override def insert(unsaved: PersoncreditcardRow)(implicit c: Connection): PersoncreditcardRow = {
    SQL"""insert into sales.personcreditcard(businessentityid, creditcardid, modifieddate)
          values (${unsaved.businessentityid}::int4, ${unsaved.creditcardid}::int4, ${unsaved.modifieddate}::timestamp)
          returning businessentityid, creditcardid, modifieddate
       """
      .executeInsert(PersoncreditcardRow.rowParser(1).single)
  
  }
  override def insert(unsaved: PersoncreditcardRowUnsaved)(implicit c: Connection): PersoncreditcardRow = {
    val namedParameters = List(
      Some((NamedParameter("businessentityid", ParameterValue.from(unsaved.businessentityid)), "::int4")),
      Some((NamedParameter("creditcardid", ParameterValue.from(unsaved.creditcardid)), "::int4")),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some((NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)), "::timestamp"))
      }
    ).flatten
    val quote = '"'.toString
    if (namedParameters.isEmpty) {
      SQL"""insert into sales.personcreditcard default values
            returning businessentityid, creditcardid, modifieddate
         """
        .executeInsert(PersoncreditcardRow.rowParser(1).single)
    } else {
      val q = s"""insert into sales.personcreditcard(${namedParameters.map{case (x, _) => quote + x.name + quote}.mkString(", ")})
                  values (${namedParameters.map{ case (np, cast) => s"{${np.name}}$cast"}.mkString(", ")})
                  returning businessentityid, creditcardid, modifieddate
               """
      // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
      import anorm._
      SQL(q)
        .on(namedParameters.map(_._1) :_*)
        .executeInsert(PersoncreditcardRow.rowParser(1).single)
    }
  
  }
  override def selectAll(implicit c: Connection): List[PersoncreditcardRow] = {
    SQL"""select businessentityid, creditcardid, modifieddate
          from sales.personcreditcard
       """.as(PersoncreditcardRow.rowParser(1).*)
  }
  override def selectByFieldValues(fieldValues: List[PersoncreditcardFieldOrIdValue[_]])(implicit c: Connection): List[PersoncreditcardRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PersoncreditcardFieldValue.businessentityid(value) => NamedParameter("businessentityid", ParameterValue.from(value))
          case PersoncreditcardFieldValue.creditcardid(value) => NamedParameter("creditcardid", ParameterValue.from(value))
          case PersoncreditcardFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""select businessentityid, creditcardid, modifieddate
                    from sales.personcreditcard
                    where ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(" AND ")}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(PersoncreditcardRow.rowParser(1).*)
    }
  
  }
  override def selectById(compositeId: PersoncreditcardId)(implicit c: Connection): Option[PersoncreditcardRow] = {
    SQL"""select businessentityid, creditcardid, modifieddate
          from sales.personcreditcard
          where businessentityid = ${compositeId.businessentityid} AND creditcardid = ${compositeId.creditcardid}
       """.as(PersoncreditcardRow.rowParser(1).singleOpt)
  }
  override def update(row: PersoncreditcardRow)(implicit c: Connection): Boolean = {
    val compositeId = row.compositeId
    SQL"""update sales.personcreditcard
          set modifieddate = ${row.modifieddate}::timestamp
          where businessentityid = ${compositeId.businessentityid} AND creditcardid = ${compositeId.creditcardid}
       """.executeUpdate() > 0
  }
  override def updateFieldValues(compositeId: PersoncreditcardId, fieldValues: List[PersoncreditcardFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case PersoncreditcardFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val quote = '"'.toString
        val q = s"""update sales.personcreditcard
                    set ${namedParams.map(x => s"$quote${x.name}$quote = {${x.name}}").mkString(", ")}
                    where businessentityid = {businessentityid} AND creditcardid = {creditcardid}
                 """
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .on(NamedParameter("businessentityid", ParameterValue.from(compositeId.businessentityid)), NamedParameter("creditcardid", ParameterValue.from(compositeId.creditcardid)))
          .executeUpdate() > 0
    }
  
  }
  override def upsert(unsaved: PersoncreditcardRow)(implicit c: Connection): PersoncreditcardRow = {
    SQL"""insert into sales.personcreditcard(businessentityid, creditcardid, modifieddate)
          values (
            ${unsaved.businessentityid}::int4,
            ${unsaved.creditcardid}::int4,
            ${unsaved.modifieddate}::timestamp
          )
          on conflict (businessentityid, creditcardid)
          do update set
            modifieddate = EXCLUDED.modifieddate
          returning businessentityid, creditcardid, modifieddate
       """
      .executeInsert(PersoncreditcardRow.rowParser(1).single)
  
  }
}