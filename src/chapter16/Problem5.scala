package chapter16

object Problem5 extends App
{

  val url = "http://w3.org/"
  val doc = (new scala.xml.parsing.XhtmlParser(scala.io.Source.fromURL(url))).initialize.document

  (doc \\ "img").map { x => println(x.attribute("src")) }
  
}