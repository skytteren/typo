/**
 * File automatically generated by `typo` for its own test suite.
 *
 * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN
 */
package testdb
package hardcoded
package myschema
package marital_status

import doobie.enumerated.Nullability
import doobie.postgres.Text
import doobie.util.Read
import doobie.util.Write
import io.circe.Decoder
import io.circe.Encoder
import java.sql.ResultSet

/** Table: myschema.marital_status
    Primary key: id */
case class MaritalStatusRow(
  id: MaritalStatusId
)

object MaritalStatusRow {
  implicit lazy val decoder: Decoder[MaritalStatusRow] = Decoder.forProduct1[MaritalStatusRow, MaritalStatusId]("id")(MaritalStatusRow.apply)(MaritalStatusId.decoder)
  implicit lazy val encoder: Encoder[MaritalStatusRow] = Encoder.forProduct1[MaritalStatusRow, MaritalStatusId]("id")(x => (x.id))(MaritalStatusId.encoder)
  implicit lazy val read: Read[MaritalStatusRow] = new Read[MaritalStatusRow](
    gets = List(
      (MaritalStatusId.get, Nullability.NoNulls)
    ),
    unsafeGet = (rs: ResultSet, i: Int) => MaritalStatusRow(
      id = MaritalStatusId.get.unsafeGetNonNullable(rs, i + 0)
    )
  )
  implicit lazy val text: Text[MaritalStatusRow] = Text.instance[MaritalStatusRow]{ (row, sb) =>
    MaritalStatusId.text.unsafeEncode(row.id, sb)
  }
  implicit lazy val write: Write[MaritalStatusRow] = new Write[MaritalStatusRow](
    puts = List((MaritalStatusId.put, Nullability.NoNulls)),
    toList = x => List(x.id),
    unsafeSet = (rs, i, a) => {
                  MaritalStatusId.put.unsafeSetNonNullable(rs, i + 0, a.id)
                },
    unsafeUpdate = (ps, i, a) => {
                     MaritalStatusId.put.unsafeUpdateNonNullable(ps, i + 0, a.id)
                   }
  )
}
