package chapters

import chapters.core.ChapterBase

class Chapter007_NestedMethods
	extends ChapterBase("Nested methods", "https://docs.scala-lang.org/tour/nested-functions.html") {

	override def childClass = getClass.getName

	codeExample("\t//In Scala it is possible to nest method definitions\n\tdef factorial(x: Int): Int = {\n\t\tdef fact(x: Int, accumulator: Int): Int = {\n\t\t\tif (x <= 1) accumulator\n\t\t\telse fact(x - 1, x * accumulator)\n\t\t}\n\t\tfact(x, 1)\n\t}\n\tprintln(\"Factorial of 2: \" + factorial(2))\n\tprintln(\"Factorial of 3: \" + factorial(3))")
	//In Scala it is possible to nest method definitions
	def factorial(x: Int): Int = {
		def fact(x: Int, accumulator: Int): Int = {
			if (x <= 1) accumulator
			else fact(x - 1, x * accumulator)
		}

		fact(x, 1)
	}

	println("Factorial of 2: " + factorial(2))
	println("Factorial of 3: " + factorial(3))

}

