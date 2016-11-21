package chapter8

object Problem5 extends App {

  class Point(val x: Double, val y: Double)

  class LabeledPoint(label: String, x: Double, y: Double) extends Point(x, y){
    override def toString = s"Label : $label, x: $x, y: $y"
  }
  
  val list: List[Point] = List(new LabeledPoint("Black Thursday", 1929, 230.07),new LabeledPoint("Black Friday", 1939, 230.07))
  for(point <- list) println(point)
}