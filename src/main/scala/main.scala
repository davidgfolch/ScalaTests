import scala.reflect.io.File

import chapters.core.{ChapterBase, ChapterManager}

/**
  * Main method has max be static , thats why main is defined as an object (objects are single instance of their own definitions)
  */
object main {

	def main(args: Array[String]): Unit = {
		new ChapterManager(new MyClassPath stringify) run
	}

}

//def toStream[A](iter: Iterator[A]) = Stream.unfold(iter)(i => if (i.hasNext) Some((i.next, i)) else None)
class MyClassPath {

	def stringify = {
//		var res=getClass.getResource("main.class")
//			if (res==null)
//				res=getClass.getResource("")
//		res.getFile
//			.replaceAll("main\\.class$","")
//			.replaceAll("^file:","")
//		    	.replaceAll("\\.jar!/",".jar")

		""
		// .replaceAll("file:(.*)main\\.class","$1")
	}
}