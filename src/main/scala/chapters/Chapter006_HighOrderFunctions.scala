package chapters

import chapters.core.ChapterBase

class Chapter006_HighOrderFunctions
	extends ChapterBase("High-order functions", "https://docs.scala-lang.org/tour/higher-order-functions.html") {

	override def childClass = getClass.getName

	codeExample("\t//Higher order functions take other functions as parameters or return a function as a result. This is possible because functions are first-class values in Scala.\n\tval salaries = Seq(20000, 70000, 40000)\n\t//doubleSalary is a function which takes a single Int, x, and returns x * 2. In general, the tuple on the left of the arrow => is a parameter list and the value of the expression on the right is what gets returned. On line 3, the function doubleSalary gets applied to each element in the list of salaries.\n\tval doubleSalary = (x: Int) => x * 2\n\tprintln(salaries.map(doubleSalary)) // List(40000, 140000, 80000)\n\t//anonymous function: and pass it directly as an argument to map\n\t//Notice how x is not declared as an Int in the above example. That’s because the compiler can infer the type based on the type of function map expects. An even more idiomatic way to write the same piece of code would be\n\tprintln(salaries.map(x => x * 2)) // List(40000, 140000, 80000)\n\tprintln(salaries.map(_ * 2))\n\t//Since the Scala compiler already knows the type of the parameters (a single Int), you just need to provide the right side of the function. The only caveat is that you need to use _ in place of a parameter name (it was x in the previous example).")
	//Higher order functions take other functions as parameters or return a function as a result. This is possible because functions are first-class values in Scala.
	val salaries = Seq(20000, 70000, 40000)
	//doubleSalary is a function which takes a single Int, x, and returns x * 2. In general, the tuple on the left of the arrow => is a parameter list and the value of the expression on the right is what gets returned. On line 3, the function doubleSalary gets applied to each element in the list of salaries.
	val doubleSalary = (x: Int) => x * 2
	println(salaries.map(doubleSalary))
	//anonymous function: and pass it directly as an argument to map
	//Notice how x is not declared as an Int in the above example. That’s because the compiler can infer the type based on the type of function map expects. An even more idiomatic way to write the same piece of code would be
	println(salaries.map(x => x * 2))
	println(salaries.map(_ * 2))
	//Since the Scala compiler already knows the type of the parameters (a single Int), you just need to provide the right side of the function. The only caveat is that you need to use _ in place of a parameter name (it was x in the previous example).

	if (printSubtitle("Coercing methods into functions", true)) {
		codeExample("\t//It is also possible to pass methods as arguments to higher-order functions because the Scala compiler will coerce the method into a function.\n\tcase class WeeklyWeatherForecast(temperatures: Seq[Double]) {\n\t\tprivate def convertCtoF(temp: Double) = temp * 1.8 + 32\n\t\tdef forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF\n\t}\n\t//Here the method convertCtoF is passed to forecastInFahrenheit This is possible because the compiler coerces convertCtoF to the function x => convertCtoF(x) (note: x will be a generated name which is guaranteed to be unique within its scope).")
		//It is also possible to pass methods as arguments to higher-order functions because the Scala compiler will coerce the method into a function.
		case class WeeklyWeatherForecast(temperatures: Seq[Double]) {
			def forecastInFahrenheit: Seq[Double] = temperatures.map(convertCtoF) // <-- passing the method convertCtoF

			private def convertCtoF(temp: Double) = temp * 1.8 + 32
		}
		//Here the method convertCtoF is passed to forecastInFahrenheit This is possible because the compiler coerces convertCtoF to the function x => convertCtoF(x) (note: x will be a generated name which is guaranteed to be unique within its scope).
	}

	if (printSubtitle("Functions that accept functions", true)) {
		codeExample("\t//Note the promotionFunction declaration in promotion, is a function of type Double => Double, function that takes a Double and returns a Double\n\tobject SalaryRaiser {\n\n\t\tprivate def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =\n\t\t\tsalaries.map(promotionFunction)\n\n\t\tdef smallPromotion(salaries: List[Double]): List[Double] =\n\t\t\tpromotion(salaries, salary => salary * 1.1)\n\n\t\tdef bigPromotion(salaries: List[Double]): List[Double] =\n\t\t\tpromotion(salaries, salary => salary * math.log(salary))\n\n\t\tdef hugePromotion(salaries: List[Double]): List[Double] =\n\t\t\tpromotion(salaries, salary => salary * salary)\n\t}\n\tval list=List[Double](10, 20, 30)\n\tprintln(SalaryRaiser.smallPromotion(list))\n\tprintln(SalaryRaiser.bigPromotion(list))\n\tprintln(SalaryRaiser.hugePromotion(list))")
		//Note the promotionFunction declaration in promotion, is a function of type Double => Double, function that takes a Double and returns a Double
		object SalaryRaiser {

			def smallPromotion(salaries: List[Double]): List[Double] =
				promotion(salaries, salary => salary * 1.1)

			def bigPromotion(salaries: List[Double]): List[Double] =
				promotion(salaries, salary => salary * math.log(salary))

			def hugePromotion(salaries: List[Double]): List[Double] =
				promotion(salaries, salary => salary * salary)

			private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
				salaries.map(promotionFunction)
		}
		val list = List[Double](10, 20, 30)
		println(SalaryRaiser.smallPromotion(list))
		println(SalaryRaiser.bigPromotion(list))
		println(SalaryRaiser.hugePromotion(list))

	}

	if (printSubtitle("Functions that return functions", true)) {
		codeExample("\t//Notice the return type of urlBuilder (String, String) => String. This means that the returned anonymous function takes two Strings and returns a String.\n\tdef urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {\n\t\tval schema = if (ssl) \"https://\" else \"http://\"\n\t\t(endpoint: String, query: String) => s\"$schema$domainName/$endpoint?$query\"\n\t}\n\n\tval domainName = \"www.example.com\"\n\tdef getURL = urlBuilder(ssl=true, domainName)\n\tval endpoint = \"users\"\n\tval query = \"id=1\"\n\tprintln(getURL(endpoint, query)) // \"https://www.example.com/users?id=1\": String")
		//Notice the return type of urlBuilder (String, String) => String. This means that the returned anonymous function takes two Strings and returns a String.
		def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
			val schema = if (ssl) "https://" else "http://"
			(endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
		}
		val domainName = "www.example.com"
		val query = "id=1"
		val endpoint = "users"

		def getURL = urlBuilder(ssl = true, domainName)
		println(getURL(endpoint, query)) // "https://www.example.com/users?id=1": String
	}

}

