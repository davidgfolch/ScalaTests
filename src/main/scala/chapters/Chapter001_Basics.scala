package chapters

import chapters.core.ChapterBase
import objects.{Greeter, IdFactory, Point}

class Chapter001_Basics
	extends ChapterBase("Basics","https://docs.scala-lang.org/tour/basics.html") {

	override def childClass: String = getClass.getName

	//====================================================================================
	printSubtitle("You can output results of expressions using println", false)
	codeExample("\t\tprintln(1) // 1\n\t\tprintln(1 + 1) // 2\n\t\tprintln(\"Hello!\") // Hello!\n\t\tprintln(\"Hello,\" + \" world!\") // Hello, world!")
	//====================================================================================
	println(1) // 1
	println(1 + 1) // 2
	println("Hello!") // Hello!
	println("Hello," + " world!") // Hello, world!

	//====================================================================================
	printSubtitle("You can name results of expressions with the val keyword", true)
	codeExample("\t\tval x = 1 + 1\n\t\t//\t\tx = 3 // This does not compile.\n\t\tprintln(x) // 2\n\t\tval z: Int = 1 + 1\n\t\tval y = 1 + 1")
	//====================================================================================
	val x = 1 + 1
	//		x = 3 // This does not compile.
	println(x) // 2
	val z: Int = 1 + 1
	val y = 1 + 1

	//====================================================================================
	printSubtitle("Variables can be reassigned", true)
	codeExample("\t\tvar a = 1 + 1\n\t\ta = 3 // This compiles because \"a\" is declared with the \"var\" keyword.\n\t\tprintln(a * a) // 9")
	//====================================================================================
	//		(x: Int) => x + 1 //annonimous function
	val addOne = (x: Int) => x + 1 //named function
	a = 3 // This compiles because "a" is declared with the "var" keyword.
	println(a * a) // 9

	//====================================================================================
	printSubtitle("Blocks", true)
	codeExample("\t\tprintln({\n\t\t\tval x = 1 + 1\n\t\t\tx + 1\n\t\t}) // 3")
	//====================================================================================
	println({
		val x = 1 + 1
		x + 1
	}) // 3

	//====================================================================================
	printSubtitle("Functions", true)
	codeExample("\t\t//\t\t(x: Int) => x + 1 //annonimous function\n\t\tval addOne = (x: Int) => x + 1 //named function\n\t\tprintln(\"addOne function =\" + addOne(1)) // 2\n\n\t\tval add = (x: Int, y: Int) => x + y\n\t\tprintln(\"add(1, 2) = \" + add(1, 2)) // 3\n\n\t\tval getTheAnswer = () => 42\n\t\tprintln(\"no params function = \" + getTheAnswer()) // 42")
	val add = (x: Int, y: Int) => x + y
	println("addOne function =" + addOne(1)) // 2
	val getTheAnswer = () => 42
	println("add(1, 2) = " + add(1, 2)) // 3
	//====================================================================================
	val greeter = new Greeter("Hello, ", "!")
	println("no params function = " + getTheAnswer()) // 42

	//====================================================================================
	printSubtitle("Methods", true)
	codeExample("\t\tdef addMethod(x: Int, y: Int): Int = x + y\n\t\tprintln(\"addMethod = \" + addMethod(1, 2)) // 3\n\n\t\tdef addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier\n\t\tprintln(s\"addThenMultiply = ${addThenMultiply(1, 2)(3)}\") // 9\n\n\t\tdef name: String = System.getProperty(\"user.name\")\n\t\tprintln(s\"no param method, $name !\")\n\n\t\tdef getSquareString(input: Double): String = {\n\t\t\tval square = input * input\n\t\t\tsquare.stringify\n\t\t}\n\t\tprintln(\"multiline method getSquareString, \" + getSquareString(5))")
	//====================================================================================
	val eqPoint1 = Point(1, 2)

	println("addMethod = " + addMethod(1, 2)) // 3
	val eqPoint2 = Point(1, 2)

	println(s"addThenMultiply = ${addThenMultiply(1, 2)(3)}") // 9
	val diffPoint = Point(2, 2)

	println(s"no param method, $name !")
	//====================================================================================
	val newId: Int = IdFactory.create()

	println("multiline method getSquareString, " + getSquareString(5))

	//====================================================================================
	printSubtitle("Classes", true)
	codeExample("\t\tval greeter = new Greeter(\"Hello, \", \"!\")\n\t\tgreeter.greet(\"Scala developer\") // Hello, Scala developer!")
	val anotherGreeter = new DefaultGreeter()
	greeter.greet("Scala developer") // Hello, Scala developer!
	codeExample(Greeter.sourceCode)

	//====================================================================================
	printSubtitle("Case Classes (inmutable)", true)
	codeExample("\t\tval eqPoint1 = PointV3(1, 2)\n\t\tval eqPoint2 = PointV3(1, 2)\n\t\tval diffPoint = PointV3(2, 2)\n\t\tprintln(s\"$eqPoint1 and $eqPoint2 are the same\" + equal(eqPoint1, eqPoint2)) // PointV3(1,2) and PointV3(1,2) are the same.\n\t\tprintln(s\"$eqPoint1 and $diffPoint are \" + equal(eqPoint1, diffPoint)) // PointV3(1,2) and PointV3(2,2) are different.")
	codeExample(Point.sourceCode)
	val customGreeter = new CustomizableGreeter("How are you, ", "?")
	//====================================================================================
	var a = 1 + 1

	//====================================================================================
	def addMethod(x: Int, y: Int): Int = x + y
	println(s"$eqPoint1 and $eqPoint2 are the same" + equal(eqPoint1, eqPoint2)) // PointV3(1,2) and PointV3(1,2) are the same.
	println(s"$eqPoint1 and $diffPoint are " + equal(eqPoint1, diffPoint)) // PointV3(1,2) and PointV3(2,2) are different.

	printSubtitle("Object (single instances)", true)
	codeExample(IdFactory.codeSource)
	codeExample("\t\tval newId: Int = IdFactory.create()\n\t\tprintln(s\"IdFactory.create() = $newId\") // 1\n\t\tprintln(s\"IdFactory.create() = ${IdFactory.create()}\") // 2")

	def addThenMultiply(x: Int, y: Int)(multiplier: Int): Int = (x + y) * multiplier
	println(s"IdFactory.create() = $newId") // 1
	println(s"IdFactory.create() = ${IdFactory.create()}") // 2

	//====================================================================================
	printSubtitle("Traits", true)
	codeExample("\t\ttrait AnotherGreeter {\n\t\t\tdef greet(name: String): Unit\n\t\t}\n\t\ttrait AnotherGreeterImpl {\n\t\t\tdef greet(name: String): Unit =\n\t\t\t\tprintln(\"Hello, \" + name + \"!  Thats anotherGreeterImpl trait\")\n\t\t}\n\t\tclass DefaultGreeter extends AnotherGreeterImpl\n\n\t\tclass CustomizableGreeter(prefix: String, postfix: String) extends AnotherGreeter {\n\t\t\toverride def greet(name: String): Unit = {\n\t\t\t\tprintln(prefix + name + postfix + \"  This is the CustomizableGreeter.greet overriding greet\")\n\t\t\t}\n\t\t}\n\n\t\tval anotherGreeter = new DefaultGreeter()\n\t\tanotherGreeter.greet(\"Scala developer\") // Hello, Scala developer!\n\n\t\tval customGreeter = new CustomizableGreeter(\"How are you, \", \"?\")\n\t\tcustomGreeter.greet(\"Scala developer\") // How are you, Scala developer?")

	def name: String = System.getProperty("user.name")

	def getSquareString(input: Double): String = {
		val square = input * input
		square.toString
	}

	//====================================================================================
	trait AnotherGreeter {
		def greet(name: String): Unit
	}

	trait AnotherGreeterImpl {
		def greet(name: String): Unit =
			println("Hello, " + name + "!  Thats anotherGreeterImpl trait")
	}

	class DefaultGreeter extends AnotherGreeterImpl
	anotherGreeter.greet("Scala developer") // Hello, Scala developer!

	class CustomizableGreeter(prefix: String, postfix: String) extends AnotherGreeter {
		override def greet(name: String): Unit = {
			println(prefix + name + postfix + "  This is the CustomizableGreeter.greet overriding greet")
		}
	}
	customGreeter.greet("Scala developer") // How are you, Scala developer?
}
