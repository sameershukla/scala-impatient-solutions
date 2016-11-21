package chapter3

import scala.collection.mutable.ArrayBuffer

object Problems extends App {

  //1.
  def init(n: Int): Array[Int] = {
    val array = new Array[Int](n)
    (0 to n - 1) map (i => array(i) = util.Random.nextInt())
    array
  }

  println(init(10).mkString(","))

  //2.
  def swap(array: Array[Int]): Array[Int] = {
    for (i <- 0 until (array.length-1) by 2) {
      val temp = array(i)
      array(i) = array(i + 1)
      array(i + 1) = temp
    }
    array
  }

  println(swap(Array(1, 2, 3, 4, 5)).mkString(","))

  //3.
  def swapAndYield(array: Array[Int]): Array[Int] = {
    val result = for (i <- 0 until 1) yield swap(array)
    result(0)
  }

  println(swapAndYield(Array(1, 2, 3, 4, 5)).mkString(","))

  //4. 
  def transformInOrder(array: Array[Int]): Array[Int] = {
    array.filter { _ > 0 } ++ array.filter { _ <= 0 }
  }

  println(transformInOrder(Array(1, -1, 2, 0, 3, 0, 4, -5)).mkString(","))

  //5.
  def average(array: Array[Double]): Double = array.sum / array.length

  println(average(Array(0.1, 0.3, 0.5)))
  
  //6.
  def reverse(array: Array[Int]): ArrayBuffer[Int] = {
     array.reverse.to[ArrayBuffer]
  }
  
  println(reverse(Array(1,2,3,4,5)))
  
  //7.
  println(Array(1,2,1,3,5,2,6,5,8).distinct.mkString(","))
  
  //8.
  def op(array: ArrayBuffer[Int]) = {
    var indexes = (for (i <- 0 until array.length if array(i) < 0) yield i).reverse.dropRight(1)
    for(i <- indexes) array.remove(i)
    println(array.mkString(";"))
  }
  op(ArrayBuffer(1, -2, 3, -4, 5, -6, 7))
  
  //9.
  def timezone = {
    val timezones = java.util.TimeZone.getAvailableIDs.filter { _.startsWith("America/") }.map { _.replace("America/","")}.sorted 
    println(timezones.mkString("\n"))
  }
  timezone
  
  
}