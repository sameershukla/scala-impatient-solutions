package chapter10

object Problem10 extends App {

  trait IterableInputStream extends java.io.InputStream with Iterable[Byte] {
    class InputStreamIterator(outer: IterableInputStream) extends Iterator[Byte] {
      def hasNext: Boolean = outer.available() > 0
      def next: Byte = outer.read().toByte
    }

    def iterator: Iterator[Byte] = new InputStreamIterator(this)
  }

  val f = new java.io.FileInputStream("C:/Scala-Ws/scalafortheimpatient-solutions/src/chapter9/names.txt") with IterableInputStream

  for (b <- f) println(b.toChar)

}