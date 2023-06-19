/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package pr
package pp

import doobie.free.connection.ConnectionIO
import doobie.syntax.string.toSqlInterpolator
import doobie.util.fragments
import fs2.Stream

object PpViewRepoImpl extends PpViewRepo {
  override def selectAll: Stream[ConnectionIO, PpViewRow] = {
    sql"""select "id", productphotoid, thumbnailphoto, thumbnailphotofilename, largephoto, largephotofilename, modifieddate from pr.pp""".query[PpViewRow].stream
  }
  override def selectByFieldValues(fieldValues: List[PpViewFieldOrIdValue[_]]): Stream[ConnectionIO, PpViewRow] = {
    val where = fragments.whereAnd(
      fieldValues.map {
        case PpViewFieldValue.id(value) => fr""""id" = $value"""
        case PpViewFieldValue.productphotoid(value) => fr"productphotoid = $value"
        case PpViewFieldValue.thumbnailphoto(value) => fr"thumbnailphoto = $value"
        case PpViewFieldValue.thumbnailphotofilename(value) => fr"thumbnailphotofilename = $value"
        case PpViewFieldValue.largephoto(value) => fr"largephoto = $value"
        case PpViewFieldValue.largephotofilename(value) => fr"largephotofilename = $value"
        case PpViewFieldValue.modifieddate(value) => fr"modifieddate = $value"
      } :_*
    )
    sql"select * from pr.pp $where".query[PpViewRow].stream
  
  }
}
