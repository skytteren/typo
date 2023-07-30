package typo
package internal
package codegen

object CustomTypeFile {
  def apply(options: InternalOptions, genOrdering: GenOrdering)(ct: CustomType): sc.File = {

    val comments = scaladoc(ct.comment)(Nil)

    val instances =
      List(genOrdering.ordering(ct.typoType, ct.params)) ++
        options.jsonLibs.flatMap(_.customTypeInstances(ct)) ++
        options.dbLib.toList.flatMap(_.customTypeInstances(ct))

    val str =
      code"""$comments
            |case class ${ct.typoType.name}(${ct.params.map(_.code).mkCode(", ")})
            |
            |${sc.Obj(ct.typoType.value, instances, ct.objBody0)}
""".stripMargin

    sc.File(ct.typoType, str, secondaryTypes = Nil)
  }
}
