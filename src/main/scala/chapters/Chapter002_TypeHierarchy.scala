package chapters

import scala.collection.mutable.TreeMap

import core.ChapterBase
import objects.{Branch, Leaf, ScalaTypeHierarchy}

/**
  * This was a class originally
  */
object Chapter002_TypeHierarchy extends ChapterBase {

	printTitle("Unified Types", "https://docs.scala-lang.org/tour/unified-types.html")

	//====================================================================================
	printSubtitle("In Scala, all values have a type, including numerical values and functions. The diagram below illustrates a subset of the type hierarchy.", false)
	println(ScalaTypeHierarchy)

	//====================================================================================
	printSubtitle("Scala Type Hierarchy", false)
	codeExample("val list: List[Any] = List(\n  \"a string\",\n  732,  // an integer\n  'c',  // a character\n  true, // a boolean value\n  () => \"an anonymous function returning a string\"\n)\n\nlist.foreach(element => println(element))")
	//====================================================================================
	val list: List[Any] = List(
		"a string",
		732,  // an integer
		'c',  // a character
		true, // a boolean value
		() => "an anonymous function returning a string"
	)
	list.foreach(element => println(element))

	//====================================================================================
	printSubtitle("Type Casting", true)
	codeExample("\tval x: Long = 987654321\n\tval y: Float = x  // 9.8765434E8 (note that some precision is lost in this case)\n\t//val z: Long = y  //Casting is unidirectional. This will not compile:\n\tval face: Char = '☺'\n\tval number: Int = face  // 9786")
	//====================================================================================
	val x: Long = 987654321
	val y: Float = x  // 9.8765434E8 (note that some precision is lost in this case)
	//val z: Long = y  //Casting is unidirectional. This will not compile
	val face: Char = '☺'
	val number: Int = face  // 9786

	//====================================================================================
	printSubtitle("Nothing and Null", true)
	codeExample("\tval x: Long = 987654321\n\tval y: Float = x  // 9.8765434E8 (note that some precision is lost in this case)\n\t//val z: Long = y  //Casting is unidirectional. This will not compile:\n\tval face: Char = '☺'\n\tval number: Int = face  // 9786")
	//====================================================================================

}

