package chapter4

object Problems extends App {
  //1.
  val ghizmos = Map("iPhone" -> 700, "McBook" -> 2000, "iPad" -> 900)
  val discountedGhizmos = for ((key, value) <- ghizmos) yield key -> value * .9
  println(discountedGhizmos)

  //2.
  val mutableMap = scala.collection.mutable.Map[String, Int]()
  scala.io.Source.fromFile("C:/Scala-Ws/scalafortheimpatient-solutions/src/chapter4/names.txt").getLines().foreach { x =>
    mutableMap(x) = mutableMap.getOrElse(x, 0) + 1
  }
  println(mutableMap)

  //3.
  var immutableMap = scala.collection.immutable.Map[String, Int]()
  scala.io.Source.fromFile("C:/Scala-Ws/scalafortheimpatient-solutions/src/chapter4/names.txt").getLines().foreach { x =>
    immutableMap += x -> (immutableMap.getOrElse(x, 0) + 1)
  }
  println(immutableMap)

  //4.
  var sortedMap = scala.collection.immutable.SortedMap[String, Int]()
  scala.io.Source.fromFile("C:/Scala-Ws/scalafortheimpatient-solutions/src/chapter4/names.txt").getLines().foreach { x =>
    sortedMap += x -> (sortedMap.getOrElse(x, 0) + 1)
  }
  println(sortedMap)

  //5.
  var treeMap = new java.util.TreeMap[String, Int]()
  scala.io.Source.fromFile("C:/Scala-Ws/scalafortheimpatient-solutions/src/chapter4/names.txt").getLines().foreach { x =>
    if (treeMap.get(x) > 0) treeMap.put(x, treeMap.get(x) + 1) else treeMap.put(x, 1)
  }
  println(treeMap)

  //6.
  val linkedHashMap = scala.collection.mutable.LinkedHashMap("Monday" -> java.util.Calendar.MONDAY, "Tuesday" -> java.util.Calendar.TUESDAY, "Wednesday" -> java.util.Calendar.WEDNESDAY, "Thursday" -> java.util.Calendar.THURSDAY, "Friday" -> java.util.Calendar.FRIDAY, "Saturday" -> java.util.Calendar.SATURDAY, "Sunday" -> java.util.Calendar.SUNDAY)
  println(linkedHashMap)
  
  //7.
  import scala.collection.JavaConversions.propertiesAsScalaMap
  val props = System.getProperties()
  val keyWithMaxLength = (for((k,v) <- props) yield k.length()).max
  for((k,v) <- props)  printf("%-" + keyWithMaxLength + "s | %s\n", k, v)
  
  //8.
  def minmax(values: Array[Int]) : (Int, Int) = {
   (values.min, values.max)
  }
  println(minmax(Array(5,100,2,-2,0,9,29,99)))
  
  //9.
  def lteqgt(values: Array[Int], v: Int) : (Int, Int, Int) = {
    (values.filter { _ < v }.length, values.filter(_ == v).length, values.filter { _ > v }.length)
  }
  
  println(lteqgt(Array(5,100,2,-2,0,9,29,99),29))
  
  //10.
  def convertCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".zip("abcdefghijklmnopqrstuvwxyz").toMap
  println(convertCase('S'))
}