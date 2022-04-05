import de.heikoseeberger.sbtheader.FileType
import de.heikoseeberger.sbtheader.HeaderPlugin.autoImport._
import sbt.Def

object LicenseHeader {

  lazy val settings: Seq[Def.Setting[_]] = Seq(
    headerLicense  := Some(HeaderLicense.ALv2("2018-2020", "Saverio Veltri")),
    headerMappings := headerMappings.value ++ Map(
      HeaderFileType.conf    -> HeaderCommentStyle.hashLineComment,
      FileType("properties") -> HeaderCommentStyle.hashLineComment,
      FileType("sbt")        -> HeaderCommentStyle.cStyleBlockComment,
      HeaderFileType.java    -> HeaderCommentStyle.cStyleBlockComment,
      HeaderFileType.scala   -> HeaderCommentStyle.cStyleBlockComment
    )
  )

}
