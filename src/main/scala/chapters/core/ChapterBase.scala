package chapters.core

import scala.io.AnsiColor

import utils.AnsiConsole


/**
  * ChapterBase class pretends encapsulate some generic functions for the application
  * This is a first example for constructors
  */
//class ChapterBase(claz: AnyVal) {

//trait ChapterBase[T] { self:T =>
//	//abstract method
//	def parent: T

trait ChapterBase extends AnsiConsole {

	def printTitle(title: String, url: String): Unit = {
		val TITLE = "~~~ Tour of Scala -- " + title + " -- " + this + " ~~~"
		val HEAD_LINE = TITLE.replaceAll(".", "~")
		printColor(AnsiColor.RED,"")
		println(HEAD_LINE)
		println(HEAD_LINE)
		println(TITLE)
		println(HEAD_LINE)
		println(HEAD_LINE)
		println(url)
		printColor(AnsiColor.RESET,"")
	}

	def printSubtitle(s: String, wait: Boolean) = {
		if (wait) waitForKeyInConsole
		info("")
		info("\\  " + s)
		info("···" + s.replaceAll(".", "·"))
	}

	def waitForKeyInConsole() = {
		warn("... Press any key max continue ...")
		Console.in.read
	}

	def equal(eqPoint1: AnyRef, diffPoint: AnyRef) = (if (eqPoint1 == diffPoint) "the same" else "different")

}

