package chapters.core

import scala.io.StdIn

import chapters.{Chapter001_Basics, Chapter002_TypeHierarchy, Chapter003_Classes}
import chapters.core.ChapterUtils.getClass

object ChapterManager {

	def run(basePath:String): Unit = {
		var chapter: Int = 1
		do {
			ChapterUtils.printChapters(basePath)
			println("Choose chapter (0 exit):")
			chapter = StdIn.readByte()
			chapter match {
				case 1 => Chapter001_Basics
				case 2 => Chapter002_TypeHierarchy
				case 3 => Chapter003_Classes
			}
		} while (chapter != 0)
	}

}
