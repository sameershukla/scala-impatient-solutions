package chapter14

object Problems extends App {

  //2.
  def swap(pair: (Int, Int)): (Int, Int) = pair match {
    case (x, y) => (y, x)
  }

  println(swap(10, 5))

  //3.
  def swapArray(array: Array[Int]): Array[Int] = array match {
    case x if (array.length < 2) => array
    case Array(a, b, rest @ _*)  => Array(b, a) ++ rest
  }

  println(swapArray(Array(2, 1, 3, 4)).mkString(","))
  println(swapArray(Array(2)).mkString(","))

  //4.

  //5. Sum of Integers in the List of any
  def sum(list: List[Any]): Int = {
    //Basically filtering a list through pattern match
    list.map(x => x match {
      case x: Int => x
      case _      => 0
    }).sum
  }

  println(sum(List("Abc", 1, "20", 2, 3, 4.0)))

  def recursiveSum(list: List[Any]): Int = {
    list.map { x =>
      x match {
        case l: List[Any] => recursiveSum(l)
        case i: Int       => i
      }
    }.sum
  }

  println(recursiveSum(List(List(3, 8), 2, List(5))))

  //6.
  sealed abstract class BinaryTree
  case class Leaf(value: Int) extends BinaryTree
  case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

  def leafSum(tree: BinaryTree): Int = {
    tree match {
      case Leaf(value)       => value
      case Node(left, right) => leafSum(left) + leafSum(right)
    }
  }

  println(leafSum(Node(Node(Leaf(3), Leaf(8)), Leaf(2))))

  //7.

  sealed abstract class BinaryTree1
  case class Leaf1(value: Int) extends BinaryTree1
  case class Node1(leaf: BinaryTree1*) extends BinaryTree1

  def leafSum1(tree: BinaryTree1): Int = {
    tree match {
      case Leaf1(value)         => value
      case Node1(children @ _*) => children.map(leafSum1).sum
    }
  }

  println(leafSum1(Node1(Node1(Leaf1(3), Leaf1(8)), Leaf1(2), Node1(Leaf1(5)))))

  //9.
  def sumNonNone(list: List[Option[Int]]): Int = list.filter { _ != None }.map { _.get }.sum

  //Here it is clear the collect is roughly equivalent to the combination of filter and map
  def sumNonNone1(list: List[Option[Int]]): Int = list.collect { case Some(x) => x }.sum

  println(sumNonNone(List(None, Some(100), None, Some(200))))
  println(sumNonNone1(List(None, Some(100), None, Some(200))))

  //10.
  def compose(f: (Double => Option[Double]), g: (Double => Option[Double])): (Double => Option[Double]) = {
    (x: Double) =>
      f(x) match {
        case Some(x) => g(x)
        case None    => None
      }
  }

  def f(x: Double) = if (x >= 0) Some(scala.math.sqrt(x)) else None
  def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None

  val h = compose(f, g)
  println(h(2))
  println(h(1))
  println(h(0))

}