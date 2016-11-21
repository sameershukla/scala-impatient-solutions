package chapter16

import scala.xml.Node

object Problem6 extends App {

  val url = "http://w3.org/"
  val doc = (new scala.xml.parsing.XhtmlParser(scala.io.Source.fromURL(url))).initialize.document

  println((doc \\ "a").map { (x: Node) => (x.attribute("href").getOrElse(""), x.text) }.filter(x => x._1.toString().startsWith("http")))
  
}