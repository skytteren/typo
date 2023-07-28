/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package humanresources
package vjobcandidate

import anorm.SqlStringInterpolation
import java.sql.Connection

object VjobcandidateViewRepoImpl extends VjobcandidateViewRepo {
  override def selectAll(implicit c: Connection): List[VjobcandidateViewRow] = {
    SQL"""select jobcandidateid, businessentityid, "Name.Prefix", "Name.First", "Name.Middle", "Name.Last", "Name.Suffix", Skills, "Addr.Type", "Addr.Loc.CountryRegion", "Addr.Loc.State", "Addr.Loc.City", "Addr.PostalCode", EMail, WebSite, modifieddate::text
          from humanresources.vjobcandidate
       """.as(VjobcandidateViewRow.rowParser(1).*)
  }
}
