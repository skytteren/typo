/**
 * File has been automatically generated by `typo` for internal use.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
 *
 * (If you're developing `typo` and want to change it: run `bleep generate-sources`)
 */
package typo
package generated

import java.sql.Connection

trait FindViewsRepo {
  def selectAll(implicit c: Connection): List[FindViewsRow]
  def selectByFieldValues(fieldValues: List[FindViewsFieldValue[_]])(implicit c: Connection): List[FindViewsRow]
}