package chapters.core

import scala.io.AnsiColor._

import utils.AnsiConsole

class ChapterManager(basePath:String) extends AnsiConsole {

	var printMenu: Boolean = true
	val chapterUtils = new ChapterUtils(basePath)

	def run(): Unit = {
		println(s"base path: $basePath")
		var chapter: Byte = -1
		do {
			printMenuNow
			chapter = AnsiConsole.readNumber
			chapter match {
				//				case 1 => new Chapter001_Basics
				//				case 2 => Chapter002_TypeHierarchy
				//				case 3 => Chapter003_Classes
				case 0 => println("Bye!")
				case -1 => invalidOption
				case _ => {
					try {
						val clzName=chapterUtils.classNameFromNumber(chapter)
						Class.forName(clzName).newInstance()  //executes selected chapter class
					} catch {
						case e: Exception =>
							println(e)
							invalidOption
					}
				}
			}
		} while (chapter != 0)
	}

	def printMenuNow = {
		if (printMenu) {
			println()
			printColor(YELLOW,"================")
			printColor(YELLOW,"==  MAIN MENU ==")
			printColor(YELLOW,"================")
			chapterUtils.printChapters()
		}
		printColor(YELLOW,"Choose chapter (0 exit):")
		printMenu = true
	}

	def invalidOption = {
		printMenu = false
		println("Please choose a valid chapter number")
	}
}


