package chapters.core

import org.reflections.Reflections
import scala.io.AnsiColor._

import utils.AnsiConsole

class ChapterUtils() extends AnsiConsole {

	val reflections = new Reflections("chapters")
	val chapters: Array[String] = reflections.getSubTypesOf(classOf[ChapterBase]).toArray()
		.map(a => (a.asInstanceOf[Class[ChapterBase]]).getName)
		.sorted

	def printChapters() {
		chapters.foreach(a =>
			printColor(RED, a.replaceAll("(?i)(.*\\.)?chapter(\\d++).*", "$2").toInt + ".- " +
				a.replaceAll("(?i)(.*\\.)?chapter\\d++_([a-z]+).*", "$2")
					.replaceAll("([a-z]{2,})([A-Z])", "$1 $2")
			)
		)
	}

	def classNameFromNumber(chapter: Int): String = {
		chapters
			.filter(_.replaceAll("chapters\\.Chapter[0]*([0-9])+_.*", "$1").toInt == chapter)
			.map(_.replaceAll(".class", ""))
			.mkString(",")
	}

	//	def repeatChar(c: Char, n: Int): String = c.stringify * n

}
