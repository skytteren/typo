/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package production
package productphoto

import adventureworks.Defaulted
import anorm.NamedParameter
import anorm.ParameterValue
import anorm.RowParser
import anorm.SqlParser
import anorm.SqlStringInterpolation
import anorm.Success
import anorm.ToSql
import anorm.ToStatement
import java.lang.Integer
import java.sql.Connection
import java.sql.PreparedStatement
import java.time.LocalDateTime

object ProductphotoRepoImpl extends ProductphotoRepo {
  override def delete(productphotoid: ProductphotoId)(implicit c: Connection): Boolean = {
    SQL"delete from production.productphoto where productphotoid = $productphotoid".executeUpdate() > 0
  }
  override def insert(unsaved: ProductphotoRowUnsaved)(implicit c: Connection): ProductphotoId = {
    val namedParameters = List(
      Some(NamedParameter("thumbnailphoto", ParameterValue.from(unsaved.thumbnailphoto))),
      Some(NamedParameter("thumbnailphotofilename", ParameterValue.from(unsaved.thumbnailphotofilename))),
      Some(NamedParameter("largephoto", ParameterValue.from(unsaved.largephoto))),
      Some(NamedParameter("largephotofilename", ParameterValue.from(unsaved.largephotofilename))),
      unsaved.modifieddate match {
        case Defaulted.UseDefault => None
        case Defaulted.Provided(value) => Some(NamedParameter("modifieddate", ParameterValue.from[LocalDateTime](value)))
      }
    ).flatten
    
    SQL"""insert into production.productphoto(${namedParameters.map(_.name).mkString(", ")})
          values (${namedParameters.map(np => s"{${np.name}}").mkString(", ")})
          returning productphotoid
    """
      .on(namedParameters :_*)
      .executeInsert(idRowParser.single)
  
  }
  override def selectAll(implicit c: Connection): List[ProductphotoRow] = {
    SQL"select productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate from production.productphoto".as(rowParser.*)
  }
  override def selectByFieldValues(fieldValues: List[ProductphotoFieldOrIdValue[_]])(implicit c: Connection): List[ProductphotoRow] = {
    fieldValues match {
      case Nil => selectAll
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductphotoFieldValue.productphotoid(value) => NamedParameter("productphotoid", ParameterValue.from(value))
          case ProductphotoFieldValue.thumbnailphoto(value) => NamedParameter("thumbnailphoto", ParameterValue.from(value))
          case ProductphotoFieldValue.thumbnailphotofilename(value) => NamedParameter("thumbnailphotofilename", ParameterValue.from(value))
          case ProductphotoFieldValue.largephoto(value) => NamedParameter("largephoto", ParameterValue.from(value))
          case ProductphotoFieldValue.largephotofilename(value) => NamedParameter("largephotofilename", ParameterValue.from(value))
          case ProductphotoFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""select * from production.productphoto where ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(" AND ")}"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .as(rowParser.*)
    }
  
  }
  override def selectById(productphotoid: ProductphotoId)(implicit c: Connection): Option[ProductphotoRow] = {
    SQL"select productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate from production.productphoto where productphotoid = $productphotoid".as(rowParser.singleOpt)
  }
  override def selectByIds(productphotoids: Array[ProductphotoId])(implicit c: Connection): List[ProductphotoRow] = {
    implicit val arrayToSql: ToSql[Array[ProductphotoId]] = _ => ("?", 1) // fix wrong instance from anorm
    implicit val toStatement: ToStatement[Array[ProductphotoId]] =
      (s: PreparedStatement, index: Int, v: Array[ProductphotoId]) =>
        s.setArray(index, s.getConnection.createArrayOf("int4", v.map(x => x.value: Integer)))
    
    SQL"select productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate from production.productphoto where productphotoid = ANY($productphotoids)".as(rowParser.*)
  
  }
  override def update(row: ProductphotoRow)(implicit c: Connection): Boolean = {
    val productphotoid = row.productphotoid
    SQL"""update production.productphoto
          set thumbnailphoto = ${row.thumbnailphoto},
              thumbnailphotofilename = ${row.thumbnailphotofilename},
              largephoto = ${row.largephoto},
              largephotofilename = ${row.largephotofilename},
              modifieddate = ${row.modifieddate}
          where productphotoid = $productphotoid""".executeUpdate() > 0
  }
  override def updateFieldValues(productphotoid: ProductphotoId, fieldValues: List[ProductphotoFieldValue[_]])(implicit c: Connection): Boolean = {
    fieldValues match {
      case Nil => false
      case nonEmpty =>
        val namedParams = nonEmpty.map{
          case ProductphotoFieldValue.thumbnailphoto(value) => NamedParameter("thumbnailphoto", ParameterValue.from(value))
          case ProductphotoFieldValue.thumbnailphotofilename(value) => NamedParameter("thumbnailphotofilename", ParameterValue.from(value))
          case ProductphotoFieldValue.largephoto(value) => NamedParameter("largephoto", ParameterValue.from(value))
          case ProductphotoFieldValue.largephotofilename(value) => NamedParameter("largephotofilename", ParameterValue.from(value))
          case ProductphotoFieldValue.modifieddate(value) => NamedParameter("modifieddate", ParameterValue.from(value))
        }
        val q = s"""update production.productphoto
                    set ${namedParams.map(x => s"${x.name} = {${x.name}}").mkString(", ")}
                    where productphotoid = $productphotoid"""
        // this line is here to include an extension method which is only needed for scala 3. no import is emitted for `SQL` to avoid warning for scala 2
        import anorm._
        SQL(q)
          .on(namedParams: _*)
          .executeUpdate() > 0
    }
  
  }
  val rowParser: RowParser[ProductphotoRow] =
    RowParser[ProductphotoRow] { row =>
      Success(
        ProductphotoRow(
          productphotoid = row[ProductphotoId]("productphotoid"),
          thumbnailphoto = row[Option[Array[Byte]]]("thumbnailphoto"),
          thumbnailphotofilename = row[Option[String]]("thumbnailphotofilename"),
          largephoto = row[Option[Array[Byte]]]("largephoto"),
          largephotofilename = row[Option[String]]("largephotofilename"),
          modifieddate = row[LocalDateTime]("modifieddate")
        )
      )
    }
  val idRowParser: RowParser[ProductphotoId] =
    SqlParser.get[ProductphotoId]("productphotoid")
}
