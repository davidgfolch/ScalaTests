package chapters.core

import scala.io.StdIn

import chapters.{Chapter001_Basics, Chapter002_TypeHierarchy, Chapter003_Classes}

object ChapterManager {

	def run(basePath:String): Unit = {
		var chapter: Int = 1
		var print=true
		do {
			if (print) {
				ChapterUtils.printChapters(basePath)
				println("Choose chapter (0 exit):")
			}
			print=true
			chapter = StdIn.readByte()
			chapter match {
				case 1 => Chapter001_Basics
				case 2 => Chapter002_TypeHierarchy
				case 3 => Chapter003_Classes
				case 0 => println("Bye!")
				case _ => {
					print = false
					println("Please choose a valid chapter number")
				}
			}
		} while (chapter != 0)
	}

}
