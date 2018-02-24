package objects

sealed trait ScalaTypeHierarchy[+A] {
	def stringify: String
}

case class Leaf[A](value: A) extends ScalaTypeHierarchy[A] {
	override def stringify: String = value.toString
}

case class Branch[A](left: ScalaTypeHierarchy[A], right: ScalaTypeHierarchy[A]) extends ScalaTypeHierarchy[A] {
	override def stringify: String = left.stringify + "->" + right.stringify
}

object ScalaTypeHierarchy {

	def any = Leaf("Any")

	def anyVal = Leaf("AnyVal")

	def anyRef = Leaf("AnyRef")

	def nullBranch = Branch(Leaf("Null"), nothing)

	def nothing = Leaf("Nothing")

	def branches: Array[ScalaTypeHierarchy[String]] = Array(
		//anyVal
		Branch(any, Branch(anyVal, Branch(Leaf("Double"), nothing))),
		Branch(any, Branch(anyVal, Branch(Leaf("Float"), nothing))),
		Branch(any, Branch(anyVal, Branch(Leaf("Long"), nothing))),
		Branch(any, Branch(anyVal, Branch(Leaf("Int"), nothing))),
		Branch(any, Branch(anyVal, Branch(Leaf("Short"), nothing))),
		Branch(any, Branch(anyVal, Branch(Leaf("Byte"), nothing))),
		Branch(any, Branch(anyVal, Branch(Leaf("Unit"), nothing))),
		Branch(any, Branch(anyVal, Branch(Leaf("Boolean"), nothing))),
		Branch(any, Branch(anyVal, Branch(Leaf("Char"), nothing))),
		//anyRef
		Branch(any, Branch(anyRef, Branch(Leaf("List"), nullBranch))),
		Branch(any, Branch(anyRef, Branch(Leaf("Option"), nullBranch))),
		Branch(any, Branch(anyRef, Branch(Leaf("YourClass"), nullBranch)))
	)

	override def toString: String = super.toString + "\n" +
		this.any.stringify + "\n" +
		this.branches.map(a => a.stringify).mkString("\n")
}