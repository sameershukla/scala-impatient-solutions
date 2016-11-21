package chapter7

import java.util.{ HashMap => JavaHashMap }
import scala.collection.mutable.{ HashMap => ScalaHashMap }

object Problem6 extends App {

  val source = new JavaHashMap[String, Int]
  val destination = new ScalaHashMap[String, Int]

  source.put("A", 1)
  source.put("B", 2)

  for (key <- source.keySet.toArray(new Array[String](0)))
    destination(key) = source.get(key)

  println(destination)

}