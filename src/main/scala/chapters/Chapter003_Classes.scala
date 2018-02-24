package chapters

import core.ChapterBase
import objects.ScalaTypeHierarchy

/**
  * This was a class originally
  */
object Chapter003_Classes extends ChapterBase {

	printTitle("Classes", "https://docs.scala-lang.org/tour/classes.html")

	//====================================================================================
	printSubtitle("Defining a class", false)
	codeExample("\tclass User\n\tval user1 = new User")
	//====================================================================================
	class User
	val user1 = new User

	codeExample("\tclass Point(var x: Int, var y: Int) {\n\n\t\tdef move(dx: Int, dy: Int): Unit = {\n\t\t\tx = x + dx\n\t\t\ty = y + dy\n\t\t}\n\t\toverride def toString: String =\n\t\t\ts\"($x, $y)\"\n\t}\n\n\tval point1 = new Point(2, 3)\n\tprintln(point1.x)  // 2\n\tprintln(point1)  // prints (2, 3)")
	//====================================================================================
	class Point(var x: Int, var y: Int) {

		def move(dx: Int, dy: Int): Unit = {
			x = x + dx
			y = y + dy
		}
		override def toString: String =
			s"($x, $y)"
	}

	val point1 = new Point(2, 3)
	println(point1.x)  // 2
	println(point1)  // prints (2, 3)

	//====================================================================================
	printSubtitle("Defining a class", true)
	codeExample("")
	//====================================================================================

	//... code here ...

	//====================================================================================
	printSubtitle("Defining a class", true)
	codeExample("")
	//====================================================================================

	//... code here ...
	//====================================================================================
	printSubtitle("Defining a class", true)
	codeExample("")
	//====================================================================================

	//... code here ...
	//====================================================================================
	printSubtitle("Defining a class", true)
	codeExample("")
	//====================================================================================

	//... code here ...
	//====================================================================================
	printSubtitle("Defining a class", true)
	codeExample("")
	//====================================================================================

	//... code here ...
	//====================================================================================
	printSubtitle("Defining a class", true)
	codeExample("")
	//====================================================================================

	//... code here ...
	//====================================================================================
	printSubtitle("Defining a class", true)
	codeExample("")
	//====================================================================================

	//... code here ...
	//====================================================================================
	printSubtitle("Defining a class", true)
	codeExample("")
	//====================================================================================

	//... code here ...
	//====================================================================================
	printSubtitle("Defining a class", true)
	codeExample("")
	//====================================================================================

	//... code here ...

}

