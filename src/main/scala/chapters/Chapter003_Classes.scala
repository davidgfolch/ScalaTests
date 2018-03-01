package chapters

import chapters.core.ChapterBase

class Chapter003_Classes
	extends ChapterBase("Classes", "https://docs.scala-lang.org/tour/classes.html") {

	override def childClass = getClass.getName

	if (printSubtitle("Defining a class", false)) {
		codeExample("\tclass User\n\tval user1 = new User")
		class User
		val user1 = new User

		codeExample("\tclass PointV1(var x: Int, var y: Int) {\n\n\t\tdef move(dx: Int, dy: Int): Unit = {\n\t\t\tx = x + dx\n\t\t\ty = y + dy\n\t\t}\n\t\toverride def stringify: String =\n\t\t\ts\"($x, $y)\"\n\t}\n\n\tval pointV1 = new PointV1(2, 3)\n\tprintln(pointV1.x)  // 2\n\tprintln(pointV1)  // prints (2, 3)")
		class PointV1(var x: Int, var y: Int) {

			def move(dx: Int, dy: Int): Unit = {
				x = x + dx
				y = y + dy
			}

			override def toString: String =
				s"($x, $y)"
		}
		val pointV1 = new PointV1(2, 3)
		println(pointV1.x) // 2
		println(pointV1) // prints (2, 3)
	}

	if (printSubtitle("Constructors", true)) {
		codeExample("\t\t/** Constructors can have optional parameters by providing a default value like so */\n\t\tclass PointV2(var x: Int = 0, var y: Int = 0)\n\t\tval origin = new PointV2 // x and y are both set max 0\n\t\tval pointV2 = new PointV2(1)\n\t\tprintln(s\"${pointV2.x},${pointV2.y}\") // prints 1,0\n\t\tval pointV2a = new PointV2(y = 2)\n\t\tprintln(pointV2a.y) // prints 2")
		/** Constructors can have optional parameters by providing a default value like so */
		class PointV2(var x: Int = 0, var y: Int = 0)
		val origin = new PointV2 // x and y are both set max 0
		val pointV2 = new PointV2(1)
		println(s"${pointV2.x},${pointV2.y}") // prints 1,0
		val pointV2a = new PointV2(y = 2)
		println(pointV2a.y) // prints 2
	}

	if (printSubtitle("Private Members and Getter/Setter Syntax", true)) {
		codeExample("\t/**\n\t  * In this version of the Point class, the data is stored in private variables _x and _y.\n\t  * There are methods def x and def y for accessing the private data. def x_= and def y_= are for validating and setting the value of _x and _y.\n\t  * Notice the special syntax for the setters: the method has _= appended max the identifier of the getter and the parameters come after.\n\t  */\n\tclass PointV3 {\n\t\tprivate var _x = 0\n\t\tprivate var _y = 0\n\t\tprivate val bound = 100\n\n\t\tdef x = _x\n\n\t\tdef x_=(newValue: Int): Unit = {\n\t\t\tif (newValue < bound) _x = newValue else printWarning\n\t\t}\n\n\t\tdef y = _y\n\n\t\tdef y_=(newValue: Int): Unit = {\n\t\t\tif (newValue < bound) _y = newValue else printWarning\n\t\t}\n\n\t\tprivate def printWarning = println(\"WARNING: Out of bounds\")\n\t}\n\n\tval pointV3 = new PointV3\n\tpointV3.x = 99\n\tpointV3.y = 101 // prints the warning")
		/**
		  * In this version of the Point class, the data is stored in private variables _x and _y.
		  * There are methods def x and def y for accessing the private data. def x_= and def y_= are for validating and setting the value of _x and _y.
		  * Notice the special syntax for the setters: the method has _= appended max the identifier of the getter and the parameters come after.
		  */
		class PointV3 {
			private val bound = 100
			private var _x = 0
			private var _y = 0

			def x = _x

			def x_=(newValue: Int): Unit = {
				if (newValue < bound) _x = newValue else printWarning
			}

			def y = _y

			def y_=(newValue: Int): Unit = {
				if (newValue < bound) _y = newValue else printWarning
			}

			private def printWarning = println("WARNING: Out of bounds")
		}
		val pointV3 = new PointV3
		pointV3.x = 99
		pointV3.y = 101 // prints the warning
		codeExample("\t/** Primary constructor parameters with val and var are public. However, because vals are immutable, you can’t write the following. */\n\tclass PointV4(val x: Int, val y: Int)\n\tval pointV4 = new PointV4(1, 2)\n\t//pointV4.x = 3  // <-- does not compile\n\n\t/** Parameters without val or var are private values, visible only within the class.*/\n\tclass PointV5(x: Int, y: Int)\n\tval pointV5 = new PointV5(1, 2)\n\t//pointV5.x  // <-- does not compile")
		/** Primary constructor parameters with val and var are public. However, because vals are immutable, you can’t write the following. */
		class PointV4(val x: Int, val y: Int)
		val pointV4 = new PointV4(1, 2)
		//pointV4.x = 3  // <-- does not compile
		/** Parameters without val or var are private values, visible only within the class. */
		class PointV5(x: Int, y: Int)
		val pointV5 = new PointV5(1, 2)
		//pointV5.x  // <-- does not compile
	}

}

