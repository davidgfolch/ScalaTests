package chapters.core

import scala.Int
import scala.io.{AnsiColor, StdIn}

/**
  * ChapterBase class pretends encapsulate some generic functions for the application
  * This is a first example for constructors
  */
abstract class ChapterBase(title:String, url:String) extends AnsiConsole {

	def childClass:String

	printTitle(title, url)

	def printTitle(title: String, url: String): Unit = {
		val TITLE = "~~~ Tour of Scala -- " + title + " -- " + childClass.replaceAll("chapters\\.","") + " ~~~"
		val HEAD_LINE = TITLE.replaceAll(".", "~")
		printColor(AnsiColor.RED, "")
		println(HEAD_LINE)
		println(HEAD_LINE)
		println(TITLE)
		println(HEAD_LINE)
		println(HEAD_LINE)
		println(url)
		println(AnsiColor.RESET)
	}

	var exitChapter = false

	def printSubtitle(s: String, wait: Boolean):Boolean = {
		if (exitChapter) return false
		if (wait) {
			exitChapter=(!waitForKeyInConsole==true)
			if (exitChapter) return false
		}
		info("")
		info("\\  " + s)
		info("···" + s.replaceAll(".", "·"))
		true
	}

	def waitForKeyInConsole():Boolean = {
		warn("... Press enter to continue or go back to (m)enu...")
		val command = StdIn.readLine()
		if ("m".equals(command)) return false
		true
	}

	def equal(eqPoint1: AnyRef, diffPoint: AnyRef) = (if (eqPoint1 == diffPoint) "the same" else "different")

}


