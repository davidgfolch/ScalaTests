import scala.io.StdIn

import chapters._
import core.ChapterManager.getClass
import core.{ChapterManager, ChapterUtils}

/**
  * Main method has to be static , thats why main is defined as an object (objects are single instance of their own definitions)
  */
object main {

	def main(args: Array[String]): Unit = {
		val CLASSPATH_FOLDER = getClass.getResource("").getPath
		ChapterManager.run(CLASSPATH_FOLDER)
	}

}

//def toStream[A](iter: Iterator[A]) = Stream.unfold(iter)(i => if (i.hasNext) Some((i.next, i)) else None)