package adventureworks.person_detail

import adventureworks.{TypoLocalDateTime, withConnection}
import org.scalactic.TypeCheckedTripleEquals
import org.scalatest.funsuite.AnyFunSuite

class PersonDetailTest extends AnyFunSuite with TypeCheckedTripleEquals {
  test("timestamp works") {
    withConnection { implicit c =>
      PersonDetailSqlRepoImpl(1, TypoLocalDateTime.now)
    }
  }
}