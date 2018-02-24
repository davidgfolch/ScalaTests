package objects

object IdFactory {
	private var counter = 0

	def create(): Int = {
		counter += 1
		counter
	}

	def codeSource="object IdFactory {\n\tprivate var counter = 0\n\n\tdef create(): Int = {\n\t\tcounter += 1\n\t\tcounter\n\t}\n}"

}
