package typo

case class Options(
    pkg: String,
    jsonLibs: List[JsonLibName],
    dbLib: Option[DbLibName],
    naming: sc.QIdent => Naming = new Naming(_),
    typeOverride: TypeOverride = TypeOverride.Empty,
    nullabilityOverride: NullabilityOverride = NullabilityOverride.Empty,
    generateMockRepos: Selector = Selector.All,
    header: String = Options.header,
    enableFieldValue: Boolean = false,
    debugTypes: Boolean = false,
    inlineImplicits: Boolean = true
)

object Options {
  val header =
    """|/**
       | * File has been automatically generated by `typo`.
       | *
       | * IF YOU CHANGE THIS FILE YOUR CHANGES WILL BE OVERWRITTEN.
       | */
       |""".stripMargin
}
