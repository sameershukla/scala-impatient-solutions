package chapter10
import java.awt.Point
import scala.math.Ordered.orderingToOrdered

object Problem2 extends App {

  class OrderedPoint(x: Int = 1, y: Int = 1) extends Point(x, y) with scala.math.Ordered[Point] {
    override def compare(that: Point) = {
      (x, y) compare (that.x, that.y)
    }
  }

  val x1 = new OrderedPoint(1, 1)
  val x2 = new OrderedPoint(1, -1)
  val x3 = new OrderedPoint(2, 1)

  println(x1.compare(x2))
  println(x2.compare(x3))
  println(x1.compare(x3))
}