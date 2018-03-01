package chapters.core

import scala.io.AnsiColor._
import scala.util.Try

class ChapterManager() extends AnsiConsole {

	val chapterUtils = new ChapterUtils()
	var printMenu: Boolean = true
	var lastChapter:Int = 0


	def run(): Unit = {
		do {
			printMenuNow
			AnsiConsole.readNumber match {
				case 0 => {
					println("Bye!")
					return
				}
				case -1 => invalidOption
				case -2 => executeNextChapter
				case chapter => executeChapter(chapter)
			}
		} while (true)
	}

	def nextChapter: Int = {
		lastChapter += 1
		lastChapter
	}
	def executeNextChapter = executeChapter(nextChapter)

	def executeChapter(chapter: Int) = {
		lastChapter=chapter
		val clzName = chapterUtils.classNameFromNumber(chapter)
		Try.apply {
			Class.forName(clzName).newInstance() //executes selected chapter class
		}.recover {
			case e: Exception =>
				println(e)
				invalidOption
		}
	}

	def invalidOption = {
		printMenu = false
		println("Please choose a valid chapter number")
	}

	def printMenuNow = {
		if (printMenu) {
			println()
			println(YELLOW + "================")
			printColor(YELLOW, "==  MAIN MENU ==")
			printColor(YELLOW, "================")
			chapterUtils.printChapters()
		}
		printColor(YELLOW, "Choose chapter 1..999 (0->exit, Enter->next chapter):")
		printMenu = true
	}
}


