package typo

object db {
  case class EnumName(value: String) extends AnyVal
  sealed trait DbType
  object DbType {
    case object BigInt extends DbType
    case class VarChar(n: Int) extends DbType
    case object Boolean extends DbType
    case class StringEnum(name: EnumName, values: List[String]) extends DbType
  }

  case class ColName(value: String) extends AnyVal
  case class Col(name: ColName, tpe: DbType, isNotNull: Boolean, hasDefault: Boolean)
  case class TableName(value: String) extends AnyVal
  case class PrimaryKey(colName: ColName)
  case class ForeignKey(col: ColName, otherTable: TableName, otherColumn: ColName)
  case class UniqueKey(cols: List[ColName])
  case class Table(
      name: TableName,
      cols: Seq[Col],
      primaryKey: Option[PrimaryKey],
      uniqueKeys: List[UniqueKey],
      foreignKeys: List[ForeignKey]
  ) {
    val allKeyNames: Set[ColName] =
      (primaryKey.map(_.colName) ++ uniqueKeys.flatMap(_.cols) ++ foreignKeys.map(_.col)).toSet

    val colsByName: Map[ColName, Col] =
      cols.map(col => (col.name, col)).toMap
    val idCol: Option[Col] =
      primaryKey.map(pk => colsByName(pk.colName))
  }
}
