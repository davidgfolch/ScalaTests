package chapters

import chapters.core.ChapterBase

class Chapter005_ClassCompositionWithMixins
	extends ChapterBase("Class Composition with Mixins", "https://docs.scala-lang.org/tour/mixin-class-composition.html") {

	override def childClass = getClass.getName

	codeExample("\t//Mixins are traits which are used to compose a class.\n\tabstract class A {\n\t\tval message: String\n\t}\n\tclass B extends A {\n\t\tval message = \"I'm an instance of class B\"\n\t}\n\ttrait C extends A {\n\t\tdef loudMessage = message.toUpperCase()\n\t}\n\tclass D extends B with C\n\n\tval d = new D\n\tprintln(d.message)  // I'm an instance of class B\n\tprintln(d.loudMessage)  // I'M AN INSTANCE OF CLASS B\n\t//Class D has a superclass B and a mixin C. Classes can only have one superclass but many mixins (using the keywords extends and with respectively). The mixins and the superclass may have the same supertype.\t")
	//====================================================================================
	//Mixins are traits which are used to compose a class.
	abstract class A {
		val message: String
	}
	class B extends A {
		val message = "I'm an instance of class B"
	}

	class D extends B with C

	val d = new D

	trait C extends A {
		def loudMessage = message.toUpperCase()
	}

	println(d.message) // I'm an instance of class B
	println(d.loudMessage) // I'M AN INSTANCE OF CLASS B
	//Class D has a superclass B and a mixin C. Classes can only have one superclass but many mixins (using the keywords extends and with respectively). The mixins and the superclass may have the same supertype.

	if (printSubtitle("Using traits", true)) {
		codeExample("\t\t//The class has an abstract type T and the standard iterator methods.\n\t\tabstract class AbsIterator {\n\t\t\ttype T\n\t\t\tdef hasNext: Boolean\n\t\t\tdef next(): T\n\t\t}\n\n\t\t//StringIterator takes a String and can be used to iterate over the String (e.g. to see if a String contains a certain character).\n\t\tclass StringIterator(s: String) extends AbsIterator {\n\t\t\ttype T = Char\n\t\t\tprivate var i = 0\n\t\t\tdef hasNext = i < s.length\n\t\t\tdef next() = {\n\t\t\t\ti += 1\n\t\t\t\ts charAt i - 1\n\t\t\t}\n\t\t}\n\n\t\t//Now let’s create a trait which also extends AbsIterator.\n\t\ttrait RichIterator extends AbsIterator {\n\t\t\tdef foreach(f: T => Unit): Unit = while (hasNext) f(next())\n\t\t}\n\n\t\t//Because RichIterator is a trait, it doesn’t need to implement the abstract members of AbsIterator.\n\t\t//We would like to combine the functionality of StringIterator and RichIterator into a single class.\n\t\tobject StringIteratorTest extends App {\n\t\t\tval richStringIter = new RichStringIter\n\t\t\tclass RichStringIter extends StringIterator(\"Scala\") with RichIterator\n\t\t\trichStringIter foreach println\n\t\t}\n\t\t//The new class RichStringIter has StringIterator as a superclass and RichIterator as a mixin.\n\t\t//With single inheritance we would not be able to achieve this level of flexibility.")
		//The class has an abstract type T and the standard iterator methods.
		abstract class AbsIterator {
			type T
			def hasNext: Boolean
			def next(): T
		}

		//StringIterator takes a String and can be used to iterate over the String (e.g. to see if a String contains a certain character).
		class StringIterator(s: String) extends AbsIterator {
			type T = Char
			private var i = 0
			def hasNext = i < s.length
			def next() = {
				i += 1
				s charAt i - 1
			}
		}

		//Now let’s create a trait which also extends AbsIterator.
		trait RichIterator extends AbsIterator {
			def foreach(f: T => Unit): Unit = while (hasNext) f(next())
		}

		//Because RichIterator is a trait, it doesn’t need to implement the abstract members of AbsIterator.
		//We would like to combine the functionality of StringIterator and RichIterator into a single class.
		object StringIteratorTest extends App {
			val richStringIter = new RichStringIter
			class RichStringIter extends StringIterator("Scala") with RichIterator
			richStringIter foreach println
		}
		//The new class RichStringIter has StringIterator as a superclass and RichIterator as a mixin.
		//With single inheritance we would not be able to achieve this level of flexibility.
	}
}

