package chapter5

class Counter(private var value: Int = 0) {
  def increment = { if (value < Int.MaxValue) 0 else value += 1 }
  def current() = value
}

object Test1 extends App {

  val c = new Counter(Int.MaxValue - 1)
  println(c.current)
  c.increment
  println(c.current)
  c.increment
  println(c.current)
}