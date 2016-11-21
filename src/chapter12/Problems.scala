package chapter12

object Problems extends App {
  //1
  def values(fun: (Int) => Int, low: Int, high: Int): IndexedSeq[(Int, Int)] = {
    for (i <- low to high) yield (i, fun(i))
  }

  println(values(x => x * x, -5, 5))

  //2
  def compare(x: Int, y: Int): Int = if (x > y) x else y
  println(List(2, 1, 4, 3, 6, 5).reduceLeft(compare))

  //3
  def fact(n: Int): Int = if (n > 0) (1 to n).reduceLeft(_ * _) else 0
  println(fact(5))

  //4
  def factorial(n: Int): Int = (1 to n).foldLeft(1)(_ * _)
  println(factorial(5))

  //5
  def largest(fun: (Int) => Int, inputs: Seq[Int]): Int = {
    inputs.map(x => fun(x)).max
  }
  println(largest(x => 10 * x - x * x, 1 to 10))

  //6
  def largest1(fun: (Int) => Int, inputs: Seq[Int]) = {
    inputs.map(x => fun(x)).zip(inputs).max._2
  }

  println(largest1(x => 10 * x - x * x, 1 to 10))

  //7
  def adjustToPair(fun: (Int, Int) => Int)(pair: (Int, Int)) = fun(pair._1, pair._2)

  println(adjustToPair(_ * _)(6, 7))

  val pairs = (1 to 10) zip (11 to 20)
  println(pairs.map(adjustToPair(_ * _)))

  //8
  val strings = Array("Hello", "World", "Foo")
  val integers = Array(5, 5, 3)
  println(strings.corresponds(integers)((a, b) => a.length() == b))
  integers(1) = 30
  println(strings.corresponds(integers)(_.length == _))

  //9
  val strings1 = Array("Hello", "World", "Foo")
  val integers1 = Array(5, 5, 3)
  def corresponds[A, B](thatA: Seq[A], thatB: Seq[B], func: (A, B) => Boolean): Boolean = thatA.zip(thatB).forall(pair => func(pair._1, pair._2))
  println(corresponds(strings1, integers1, (x: String, y: Int) => x.length() == y))
  integers1(1) = 30
  println(corresponds(strings1, integers1, (x: String, y: Int) => x.length() == y))

}