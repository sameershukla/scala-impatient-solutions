package chapter16

import scala.xml.NodeSeq

object Problem8 extends App {

  def turnXmlToMap(dl: NodeSeq) = {
    (dl \\ "dt" zip dl \\ "dd").map { x => x._1.text -> x._2.text }.toMap
  }

  println(turnXmlToMap(<dl><dt>A</dt><dd>1</dd><dt>B</dt><dd>2</dd></dl>))

}