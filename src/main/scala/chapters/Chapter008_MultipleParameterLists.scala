package chapters

import scala.concurrent.ExecutionContext

import chapters.core.ChapterBase

class Chapter008_MultipleParameterLists
	extends ChapterBase("Multiple parameter lists (currying)", "https://docs.scala-lang.org/tour/multiple-parameter-lists.html") {

	override def childClass = getClass.getName

	codeExample("\t//Methods may define multiple parameter lists. When a method is called with a fewer number of parameter lists, then this will yield a function taking the missing parameter lists as its arguments. This is formally known as currying.\n\t//Here is an example, defined in Traversable trait from Scala collections:\n\n\tdef foldLeft[B](z: B)(op: (B, A) => B): B\n\n\t//foldLeft applies a binary operator op to an initial value z and all elements of this traversable, going left to right. Shown below is an example of its usage.\n\t//Starting with an initial value of 0, foldLeft here applies the function (m, n) => m + n to each element in the List and the previous accumulated value.\n\n\tval numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)\n\tval res = numbers.foldLeft(0)((m, n) => m + n)\n\tprint(res) // 55\n\t//Multiple parameter lists have a more verbose invocation syntax; and hence should be used sparingly.")
	//Methods may define multiple parameter lists. When a method is called with a fewer number of parameter lists, then this will yield a function taking the missing parameter lists as its arguments. This is formally known as currying.
	//Here is an example, defined in Traversable trait from Scala collections:

	// def foldLeft[B](z: B)(op: (B, A) => B): B

	//foldLeft applies a binary operator op to an initial value z and all elements of this traversable, going left to right. Shown below is an example of its usage.
	//Starting with an initial value of 0, foldLeft here applies the function (m, n) => m + n to each element in the List and the previous accumulated value.

	val numbers = List(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
	val res = numbers.foldLeft(0)((m, n) => m + n)
	println(res) // 55
	//Multiple parameter lists have a more verbose invocation syntax; and hence should be used sparingly.

	if (printSubtitle("Single functional parameter", true)) {
		codeExample("\t\t//In case of a single functional parameter, like op in the case of foldLeft above, multiple parameter lists allow a concise syntax to pass an anonymous function to the method. Without multiple parameter lists, the code would look like this:\n\t\tprintln(numbers.foldLeft(0)({(m: Int, n: Int) => m + n}).toString)\n\t\t//Note that the use of multiple parameter lists here also allows us to take advantage of Scala type inference to make the code more concise as shown below; which would not be possible in a non-curried definition.\n\t\tprintln(numbers.foldLeft(0)(_ + _).toString)\n\t\t//Also, it allows us to fix the parameter z and pass around a partial function and reuse it as shown below:\n\t\tval numberFunc = numbers.foldLeft(List[Int]())_\n\t\tval squares = numberFunc((xs, x) => xs:+ x*x)\n\t\tprintln(squares.toString()) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)\n\t\tval cubes = numberFunc((xs, x) => xs:+ x*x*x)\n\t\tprintln(cubes.toString())  // List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)")
		//In case of a single functional parameter, like op in the case of foldLeft above, multiple parameter lists allow a concise syntax to pass an anonymous function to the method. Without multiple parameter lists, the code would look like this:
		println(numbers.foldLeft(0)({(m: Int, n: Int) => m + n}).toString)
		//Note that the use of multiple parameter lists here also allows us to take advantage of Scala type inference to make the code more concise as shown below; which would not be possible in a non-curried definition.
		println(numbers.foldLeft(0)(_ + _).toString)
		//Also, it allows us to fix the parameter z and pass around a partial function and reuse it as shown below:
		val numberFunc = numbers.foldLeft(List[Int]())_
		val squares = numberFunc((xs, x) => xs:+ x*x)
		println(squares.toString()) // List(1, 4, 9, 16, 25, 36, 49, 64, 81, 100)
		val cubes = numberFunc((xs, x) => xs:+ x*x*x)
		println(cubes.toString())  // List(1, 8, 27, 64, 125, 216, 343, 512, 729, 1000)
	}

	if (printSubtitle("Implicit parameters", true)) {
		codeExample("")
		//To specify certain parameters in a parameter list as implicit, multiple parameter lists should be used. An example of this is:
		def execute(arg: Int)(implicit ec: ExecutionContext) = ???


	}

	if (printSubtitle("", true)) {
		codeExample("")
	}

}

