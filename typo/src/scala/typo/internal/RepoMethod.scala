package typo
package internal

sealed trait RepoMethod

object RepoMethod {
  case class SelectAll(
      relName: db.RelationName,
      cols: NonEmptyList[ComputedColumn],
      rowType: sc.Type
  ) extends RepoMethod

  case class SelectById(
      relName: db.RelationName,
      cols: NonEmptyList[ComputedColumn],
      id: IdComputed,
      rowType: sc.Type
  ) extends RepoMethod

  case class SelectAllByIds(
      relName: db.RelationName,
      cols: NonEmptyList[ComputedColumn],
      unaryId: IdComputed.Unary,
      idsParam: sc.Param,
      rowType: sc.Type
  ) extends RepoMethod

  case class SelectByUnique(
      params: NonEmptyList[ComputedColumn],
      fieldValueType: sc.Type.Qualified,
      rowType: sc.Type
  ) extends RepoMethod

  case class SelectByFieldValues(
      relName: db.RelationName,
      cols: NonEmptyList[ComputedColumn],
      fieldValueType: sc.Type.Qualified,
      fieldValueOrIdsParam: sc.Param,
      rowType: sc.Type
  ) extends RepoMethod

  case class UpdateFieldValues(
      relName: db.RelationName,
      id: IdComputed,
      varargs: sc.Param,
      fieldValueType: sc.Type.Qualified,
      cases: NonEmptyList[ComputedColumn],
      rowType: sc.Type
  ) extends RepoMethod

  case class Update(
      relName: db.RelationName,
      cols: NonEmptyList[ComputedColumn],
      id: IdComputed,
      param: sc.Param,
      colsNotId: NonEmptyList[ComputedColumn]
  ) extends RepoMethod

  case class Upsert(
      relName: db.RelationName,
      cols: NonEmptyList[ComputedColumn],
      id: IdComputed,
      unsavedParam: sc.Param,
      rowType: sc.Type
  ) extends RepoMethod

  case class Insert(
      relName: db.RelationName,
      cols: NonEmptyList[ComputedColumn],
      unsavedParam: sc.Param,
      rowType: sc.Type
  ) extends RepoMethod

  case class InsertUnsaved(
      relName: db.RelationName,
      cols: NonEmptyList[ComputedColumn],
      unsaved: ComputedRowUnsaved,
      unsavedParam: sc.Param,
      default: ComputedDefault,
      rowType: sc.Type
  ) extends RepoMethod

  case class Delete(
      relName: db.RelationName,
      id: IdComputed
  ) extends RepoMethod

  case class SqlFile(sqlFile: ComputedSqlFile) extends RepoMethod

}
