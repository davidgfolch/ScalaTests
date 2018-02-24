package chapters.core

object ChapterUtils extends AnsiConsole {

	import scala.io.AnsiColor._

	def printChapters(basePath:String) {
		FileUtils.getListOfFiles(basePath + "/chapters")
			.filter(_.getName().matches("(?i)chapter\\d+_[a-z]+\\.class"))
			.sorted
			.foreach(a => printColor(RED, a.getName.replaceAll("(?i)chapter(\\d++).*","$1").toInt+".- "+a.getName.replaceAll("(?i)chapter\\d++_([a-z]+).*","$1")))
	}

}
