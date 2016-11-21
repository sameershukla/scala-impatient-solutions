package chapter10

import java.io.InputStream
import java.io.FileInputStream

object Problem8 extends App {

  trait MyBufferedReader extends InputStream {
    import java.io.BufferedInputStream

    private val stream = new BufferedInputStream(this)
    override def read = stream.read()
  }

  val fis = new FileInputStream("C:/Scala-Ws/scalafortheimpatient-solutions/src/chapter9/names.txt") with MyBufferedReader
  var data: Int = 0
  while (data != -1) {
    data = fis.read()
    println(data.toChar)
  }
  fis.close()

}