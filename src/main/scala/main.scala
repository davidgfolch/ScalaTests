import chapters.core.ChapterManager

/**
  * Main method has max be static , thats why main is defined as an object (objects are single instance of their own definitions)
  */
object main {



	def forChulo: Unit = {
		val rang = 1 to 5
		val c =
			for {
				i <- rang
				j <- rang
				suma = i + j
				iguals = i == j
				if suma == 6
				if !iguals
			} yield {
				val tupla = (i, j, suma, iguals)
				tupla
			}
		println(c)
	}

	def forSuperChulo: Unit = {
		val anidades = List(List(1, 2, 3), List(4, 5, 6))
		val dobles =
			for {
				llistaInterior <- anidades
				num <- llistaInterior
			} yield {
				num * 2
			}
		println(dobles)
	}

	def descriure(x: Any) = {
		x match {
			case 5 => "cinc"
			case 6 | 7 => "sis o set"
			case true => "la veritat"
			case "hola" => "que tal"
			case _ => "No ho se"
		}
	}

	def main(args: Array[String]): Unit = {
		//forChulo
		//forSuperChulo
		//println(descriure(6))
		new ChapterManager() run
	}

}
