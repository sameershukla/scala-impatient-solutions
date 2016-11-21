package misc

import scala.util.Success
import scala.util.Failure
import scala.collection.mutable.LinkedHashSet
import scala.collection.SortedSet
import scala.collection.immutable.TreeSet

object Problems extends App {

  //1. Remove duplicates from the List, write your own program
  def distinctElements(list: List[Int]) =
    println(list.zipWithIndex.groupBy(_._1).filterNot(_._2.size > 1).keys)

  distinctElements(List(2, 3, 4, 4, 6, 7, 8, 6, 9))

  //2. write the generic function for the above one
  def genDistinctElements[A](list: List[A]) =
    println(list.zipWithIndex.groupBy(_._1).filterNot(_._2.size > 1).keys)

  genDistinctElements(List("ABC", "SAMEER", "SHUKLA", "ABC"))

  //3. reverse a list
  def reverse(list: List[Int]): List[Int] = list match {
    case List()    => List()
    case x :: list => reverse(list) ++ List(x)
  }

  println(reverse(List(1, 2, 3, 4)))

  //4. Read a file and count the occurrences of specific word.
  def count(word: String): Int = {
    scala.io.Source.fromFile("C:/Scala-Ws/scalafortheimpatient-solutions/src/misc/names.txt").getLines().filter { _ == word }.size
  }

  println(count("sameer"))
  println(count("190"))

  //5. print total line if file exists else handle failure gracefully
  def readfile(file: String) = {
    util.Try { scala.io.Source.fromFile(file).getLines().toList } match {
      case Success(lines) => println(lines.size)
      //here f represents exception
      case Failure(f)     => println(s"Error: File $file doesn't exists")
    }
  }

  readfile("C:/Scala-Ws/scalafortheimpatient-solutions/src/misc/names.txt")
  readfile("C:/Scala-Ws/scalafortheimpatient-solutions/src/misc/names1.txt")

  //6. Return the last element of the list using fold and reduce
  def last[A](list: List[A]): A = {
    list.reduceLeft((x, y) => y)
  }

  println(last(List(1, 2, 3, 4, 5)))
  println(last(List("shashi", "sameer", "aryav")))

  //7.check whether list contain certain element, 2 ways to do this one using map and other using foldLeft and reduce
  def contains[A](list: List[A], element: A): Boolean = {
    list.map(_ == element).contains(true)
  }

  def containsUsingFold[A](list: List[A], element: A): Boolean = {
    list.foldLeft(false)((_ || _ == element))
  }

  println(contains(List(1, 2, 3, 4, 5), 2))
  println(contains(List(1, 2, 3, 4, 5), 20))

  println(containsUsingFold(List(1, 2, 3, 4, 5), 2))
  println(containsUsingFold(List(1, 2, 3, 4, 5), 20))

  //8. Find Second last item from the list
  def penultimate(xs: List[Int]): Int = {
    //xs.foldLeft(xs.head, xs.tail.head)((r, c) => (r._2, c))._1
    xs.zipWithIndex.groupBy(_._2).mapValues(_.map(_._1)).get(xs.size - 2).get(0)
  }

  println(penultimate(List(1, 2, 3, 4, 5)))

  //9. Reverse all elements of list using fold
  def reverseUsingFold[A](xs: List[A]): List[A] = {
    xs.foldLeft(List[A]())((x, y) => y :: x)
  }

  println(reverseUsingFold(List(1, 2, 3, 4, 5)))

  //10. Remove Duplicates from the List using foldLeft.
  def remove[A](xs: List[A]): List[A] = {
    //x is a seed value meaning Set and + y, meaning adding element of list to the set
    xs.foldLeft(Set[A]())((x, y) => x + y).toList
  }

  println(remove(List(1, 2, 2, 3, 1, 4, 5)))

  //11. Sort the Array using foldleft
  def sort(xs: List[Int]): List[Int] = {
    xs.foldLeft(TreeSet[Int]())((x, y) => x + y).toList
  }

  println(sort(List(4, 3, 2, 1, 20, 10, 5, 9)))

  //12. Sorting customized Objects
  case class Person(name: String, age: Int) extends Ordered[Person] {
    import scala.math.Ordered.orderingToOrdered

    def compare(that: Person): Int = (this.name, this.age) compare (that.name, that.age)
  }
  
  println(List(Person("Shashi",67), Person("Aryav", 1), Person("Indira", 90), Person("Sameer", 37)).sortBy { _.age })
  println(List(Person("Shashi",67), Person("Aryav", 1), Person("Indira", 90), Person("Sameer", 37)).sortBy { _.name })
  
  //13. Filter Non Doubles in a list
  val list = List(1,"Abc",20.0,40.0,'C').map (x => x match {
    case d: Double => d
    case _ => 0.0
  }).filterNot(x => x == 0.0)
  println(list)
  
  val dList = List(1,"Abc",20.0,40.0,'C').filter { x => x == Double }
  println(dList)
}