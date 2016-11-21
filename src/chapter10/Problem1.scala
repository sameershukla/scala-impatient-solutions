package chapter10

object Problem1 extends App {

  trait RectangleLike {

    def getX(): Double
    def getY(): Double
    def getWidth(): Double
    def getHeight(): Double
    def setFrame(x: Double, y: Double, width: Double, height: Double)

    def translate(x: Int, y: Int) = {
      setFrame(getX + x, getY + y, getWidth, getHeight)
    }

    def grow(x: Int, y: Int) = {
      setFrame(getX - x, getY - y, getWidth + 2 * x, getHeight + 2 * y)
    }
    override def toString = "[%f, %f, %f, %f]".format(getX(), getY(), getWidth(), getHeight())
  }

  val egg = new java.awt.geom.Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
  println(egg)
  egg.translate(20, -20)
  println(egg)
  egg.grow(10,20)
  println(egg)

}