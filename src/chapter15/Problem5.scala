package chapter15

class Problem5 {
  
  def readFile = {
    scala.io.Source.fromFile("C:/Scala-Ws/scalafortheimpatient-solutions/src/chapter15/names.txt").getLines().mkString
  }
  
  
}