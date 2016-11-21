package chapter8

object Problem7 extends App {

  class Square(x: Int, y: Int, width: Int) extends java.awt.Rectangle(x, y, width, width) {
    def this(width: Int) = this(0, 0, width)
    def this() = this(0, 0, 0)
  }

  println("1:", new Square(1,1,20))
  println("2:", new Square(20))
  println("3:", new Square)
}