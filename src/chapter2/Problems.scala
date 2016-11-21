package chapter2

object Problems extends App {

  //1.
  def signum(n: Int) = n match {
    case x if (x > 0) => 1
    case y if (y < 0) => -1
    case zero => {
      zero
    }
  }

  println(signum(1))
  println(signum(-1))
  println(signum(0))

  //2. value is () and type is Unit
  val v = {}
  println(v)

  //4.
  for (i <- 10 to 0 by -1) println(i)

  //5.
  def countdown(n: Int) = for (i <- n to 0 by -1) println(i)

  countdown(5)

  //6.
  def unicode(string: String): Long = {
    var product = 1L
    for (ch <- string)
      product = product * ch.toLong
    product
  }
  println(unicode("Hello"))

  //7.
  def unicode1(string: String): Long = {
    var product = 1L
    string.map { x => (product = product * x) }
    product
  }
  println(unicode1("Hello"))

  //9.
  def recursive(string: String): Long = {
    if (string.isEmpty()) 1 else string.head.toLong * recursive(string.tail)
  }

  println(recursive("Hello"))
}