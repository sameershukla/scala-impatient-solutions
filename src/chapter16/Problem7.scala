package chapter16

import scala.xml.NodeSeq
import scala.collection.immutable.HashMap
import scala.xml.Text

object Problem7 extends App {

  def transformMapToXml(map: Map[String, String]): NodeSeq = {
    <dl>{ map.map(pair => <dt>{ Text(pair._1) }</dt><dd>{ Text(pair._2) }</dd>) }</dl>
  }

  println(transformMapToXml(Map("A" -> "1", "B" -> "2")))
}