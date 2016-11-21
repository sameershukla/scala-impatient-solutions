package chapter6

class Point(val i: Double, val j: Double) {
  override def toString = s"i: $i, j:$j"
}

object Point {
  def apply(i: Double, j: Double) = new Point(i, j)
}

object Problem4 extends App {
  val p = Point(3, 4)
  println(p)
}