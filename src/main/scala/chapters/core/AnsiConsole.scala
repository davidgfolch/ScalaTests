package chapters.core

import scala.io.AnsiColor._

class AnsiConsole {

	def printColor(color: String, str: String) = Console.out.println(color + str + RESET)

	def info(str: String) = printColor(GREEN, str)

	def warn(str: String) = printColor(YELLOW, str)

	def error(str: String) = printColor(RED, str)


	/**
	  * Pretyfies a code example
	  * Copy & paste escaped code into the string parameter
	  *
	  * @param str
	  */
	def codeExample(str: String) = {
		val noTabs = str.replaceAll("\t", "   ")
		val maxLen: Int = noTabs.split("\n")
			.map(p => p.length)
			.reduceLeft(_ max _) + 3
		val horizontalBorder = new String(new Array[Char](maxLen + 2))
			.replaceAll(".", "-")
		printColor(RESET, horizontalBorder)
		noTabs
			.replaceAll("/\\*[^*]*\\*+(?:[^/*][^*]*\\*+)*/", GREEN + "$0" + RESET) //multiline coments
			.split("\n")
			.map(codeLine => {
				val spaces = new String(new Array[Char](maxLen - codeLine.length))
					.replaceAll(".", " ")
				"|" +
				codeColors(codeLine) +
				spaces //+"|"
			})
			.foreach(Console.out.println) //printColor(RESET, a))
		printColor(RESET, horizontalBorder)
	}

	private def codeColors(codeLine: String): String = {
		var str = codeLine.replaceAll("(\\b)([0-9]+)(\\b)", "$1" + BLUE + "$2" + RESET + "$3")
			//variables, objects names
			.replaceAll("(?i)(new|object|trait|class|def|val|var) (\\w+)", "$1 " + YELLOW + "$2" + RESET)
			//keywords
			.replaceAll("(?i)(object|package|extends|with|new|true|false|override|class|case class|def|private|val|var) ", MAGENTA + "$1 " + RESET)
			//types
			.replaceAll("(?i)(\\b)(Any|AnyVal|AnyRef|String|Double|Float|Long|Int|Short|Byte|Boolean|Char|List|Option|Null)(\\b)", "$1" + GREEN + "$2" + RESET + "$3")
			//strings
			.replaceAll("\"([^\"]*)\"", BLUE + "$0" + RESET)
			//strings
			.replaceAll("'([^']*)'", BLUE + "$0" + RESET)
			//inlinecomments
			.replaceAll("//.*", CYAN + "$0" + RESET)
		//clean colors inside -> inline comments
		str=replaceRecursive(str, "(.*//.*)" + ansiCodePattern + "(.*)", "$1$2", 0)
		//clean colors inside -> strings ""
		str=replaceRecursive(str, "(.*\".*)"+ ansiCodePattern + "(.*\".*)", "$1$2" , 0)
		//clean colors inside -> strings ''
		str=replaceRecursive(str, "(.*'.*)"+ ansiCodePattern + "(.*'.*)", "$1$2" , 0)
		str
	}

	private def replaceRecursive(str: String, regex: String, replacement: String, level: Int): String = {
		if (str.matches(regex))
			return replaceRecursive(str.replaceAll(regex, replacement), regex, replacement, level + 1) + (if (level == 0) RESET else "")
		str
	}

	val ansiCodePattern: String = "\\u001b\\[[0-9]{1,2}[m]"

}
