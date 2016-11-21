package chapter10
import java.io._

object Problems9 extends App {

  trait Logger {
    def log(msg: String)
  }

  trait PrintLogger extends Logger {
    def log(msg: String) = println(msg)
  }

  trait MyBufferedReader extends InputStream with PrintLogger {
    import java.io.BufferedInputStream

    private val stream = new BufferedInputStream(this)
    override def read = {
      val r = stream.read()
      log(r.toString)
      r
    }
  }

  val fis = new FileInputStream("C:/Scala-Ws/scalafortheimpatient-solutions/src/chapter9/names.txt") with MyBufferedReader
  var data: Int = 0
  while (data != -1) {
    data = fis.read()
    println(data.toChar)
  }
  fis.close()

}