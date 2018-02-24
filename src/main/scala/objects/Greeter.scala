package objects

/**
  * Example standard class
  *
  * @param prefix
  * @param suffix
  */
class Greeter(prefix: String, suffix: String) {

	def greet(name: String): Unit =
		println(prefix + name + suffix)
}

object Greeter {
	def sourceCode="class Greeter(prefix: String, suffix: String) {\n\tdef greet(name: String): Unit =\n\t\tprintln(prefix + name + suffix)\n}"
}



