package chapter13

import scala.collection.mutable.HashMap
import scala.collection.mutable.TreeSet

object Problems extends App {

  //1
  def indexes(str: String) = {
    var map = new HashMap[Char, TreeSet[Int]]
    str.zipWithIndex.map(x => {
      map(x._1) = map.getOrElse(x._1, new TreeSet[Int]) + x._2
    })
    map
  }

  println(indexes("Mississippi"))

  //2
  def indexes1(str: String) = {
    str.zipWithIndex.groupBy(_._1).mapValues(_.map(_._2).toList)

  }
  println(indexes1("Mississippi"))

  //3 
  def removeZero(list: List[Int]) = {
    println(list.map(_.toString.split("0")).flatten)
  }

  removeZero(List(2, 3, 10, 40, 5, 60))

  //4
  def func(string: Array[String], inputMap: Map[String, Int]): Array[Int] = {
    string.flatMap {inputMap.get(_)}
  }

  println(func(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)).mkString(","))

   //4 implementation 2, it is done using collect function, because collect accepts partial function and map is also a Partial 
   //Function, need to dig it more. 
  def usingCollect(string: Array[String], inputMap: Map[String, Int]): Array[Int] = {
    string collect inputMap
  }

  println(usingCollect(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)).mkString(","))

  
  //5
  def mkString2(seq: Seq[Any], separator: String) = {
    seq.reduceLeft(_ + separator + _)
  }

  println(mkString2(List(2, 3, 4, 5), ","))

  //6
  def reverseList(list: List[Int]) = list.foldLeft(List[Int]())((x, y) => y :: x)

  println(reverseList(List(4, 3, 2, 1)))

  //7
  val prices = List(5.0, 20.0, 9.95)
  val quantities = List(10, 2, 1)

  println((prices zip quantities).map { Function.tupled(_ * _) })
  
  //8
  def convert1Dto2D(column: Int, array: Array[Int]) = {
     array.grouped(column).toArray
  }
  
  println(convert1Dto2D(3, Array(1,2,3,4,5,6)).map { x => x.mkString(",") }.mkString(","))
  
  
}