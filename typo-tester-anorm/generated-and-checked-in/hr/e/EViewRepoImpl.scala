/**
 * File has been automatically generated by `typo`.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 */
package adventureworks
package hr
package e

import anorm.SqlStringInterpolation
import java.sql.Connection

object EViewRepoImpl extends EViewRepo {
  override def selectAll(implicit c: Connection): List[EViewRow] = {
    SQL"""select "id", businessentityid, nationalidnumber, loginid, jobtitle, birthdate::text, maritalstatus, gender, hiredate::text, salariedflag, vacationhours, sickleavehours, currentflag, rowguid, modifieddate::text, organizationnode
          from hr.e
       """.as(EViewRow.rowParser(1).*)
  }
}
