package chapters

import chapters.core.ChapterBase

class Chapter004_Traits
	extends ChapterBase("Traits", "https://docs.scala-lang.org/tour/traits.html") {

	override def childClass = getClass.getName

	if (printSubtitle("Defining a trait", false)) {
		codeExample("\t// A minimal trait is simply the keyword trait and an identifier\n\ttrait HairColor\n\n\t// Traits become especially useful as generic types and with abstract methods.\n\t// Extending the trait Iterator[A] requires a type A and implementations of the methods hasNext and next.\n\ttrait Iterator[A] {\n\t\tdef hasNext: Boolean\n\t\tdef next(): A\n\t}")
		// A minimal trait is simply the keyword trait and an identifier
		trait HairColor
	}

	if (printSubtitle("Using traits", true)) {
		codeExample("\t// Use the extends keyword max extend a trait. Then implement any abstract members of the trait using the override keyword\n\tclass IntIterator(max: Int) extends Iterator[Int] {\n\t\tprivate var current = 0\n\t\toverride def hasNext: Boolean = current < max\n\t\toverride def next(): Int =  {\n\t\t\tif (hasNext) {\n\t\t\t\tcurrent += 1\n\t\t\t\tcurrent - 1\n\t\t\t} else 0\n\t\t}\n\t}\n\n\tval iterator = new IntIterator(10)\n\tprintln(iterator.next())  // 0\n\tprintln(iterator.next())  // 1")
		// Use the extends keyword max extend a trait. Then implement any abstract members of the trait using the override keyword
		class IntIterator(max: Int) extends Iterator[Int] {
			private var current = 0

			override def next(): Int = {
				if (hasNext) {
					current += 1
					current - 1
				} else 0
			}

			override def hasNext: Boolean = current < max
		}

		// Traits become especially useful as generic types and with abstract methods.
		// Extending the trait Iterator[A] requires a type A and implementations of the methods hasNext and next.
		trait Iterator[A] {
			def hasNext: Boolean

			def next(): A
		}
		val iterator = new IntIterator(10)
		println(iterator.next()) // 0
		println(iterator.next()) // 1
	}

	if (printSubtitle("Subtyping", true)) {
		codeExample("\t//Where a given trait is required, a subtype of the trait can be used instead.\n\timport scala.collection.mutable.ArrayBuffer\n\n\t//The trait Pet has an abstract field name which gets implemented by Cat and Dog in their constructors. On the last line, we call pet.name which must be implemented in any subtype of the trait Pet.\n\ttrait Pet {\n\t\tval name: String\n\t}\n\n\tclass Cat(val name: String) extends Pet\n\tclass Dog(val name: String) extends Pet\n\n\tval dog = new Dog(\"Harry\")\n\tval cat = new Cat(\"Sally\")\n\n\tval animals = ArrayBuffer.empty[Pet]\n\tanimals.append(dog)\n\tanimals.append(cat)\n\tanimals.foreach(pet => println(pet.name))  // Prints Harry Sally")
		//Where a given trait is required, a subtype of the trait can be used instead.
		import scala.collection.mutable.ArrayBuffer
		//The trait Pet has an abstract field name which gets implemented by Cat and Dog in their constructors. On the last line, we call pet.name which must be implemented in any subtype of the trait Pet.
		trait Pet {
			val name: String
		}
		class Cat(val name: String) extends Pet
		class Dog(val name: String) extends Pet
		val dog = new Dog("Harry")
		val cat = new Cat("Sally")
		val animals = ArrayBuffer.empty[Pet]
		animals.append(dog)
		animals.append(cat)
		animals.foreach(pet => println(pet.name)) // Prints Harry Sally
	}

}

