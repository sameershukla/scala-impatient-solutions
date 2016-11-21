package chapter16
import scala.xml

object Problem4 extends App {

  val url = "http://w3.org/"
  val doc = (new scala.xml.parsing.XhtmlParser(scala.io.Source.fromURL(url))).initialize.document
  println((doc \\ "img").filter { x => x.attributes("img") == null }.mkString)
  
}