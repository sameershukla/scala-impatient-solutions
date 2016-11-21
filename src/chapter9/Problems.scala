package chapter9

object Problems extends App {

  //1.
  def reverse = {
    println(scala.io.Source.fromFile("C:/Scala-Ws/scalafortheimpatient-solutions-solutions/src/chapter9/names.txt").getLines().toList.reverse)
  }

  reverse

  //2. 

  //3. 
  scala.io.Source.fromFile("C:/Scala-Ws/scalafortheimpatient-solutions/src/chapter9/story.txt").getLines().mkString.split(" ").filter { _.length > 12 }.foreach { println(_) }

  //4.
  val doubles = scala.io.Source.fromFile("C:/Scala-Ws/scalafortheimpatient-solutions/src/chapter9/floatingpoint.txt").getLines().mkString.split(" ").map { _.toDouble }

  println("Sum:" + doubles.sum)
  println("Average:" + (doubles.sum) / doubles.size)
  println("Min:" + doubles.min)
  println("Max:" + doubles.max)

  //5.
  val out = new java.io.PrintWriter("05.out")
  for (i <- 0 to 20) out.printf("%-" + 10 + "s %s\n", math.pow(2.0, i).toString(), math.pow(2.0, -i).toString)

  //7.
  val pattern = "^[0-9]+(\\.[0-9]+)?$".r
  val result = scala.io.Source.fromFile("C:/Scala-Ws/scalafortheimpatient-solutions/src/chapter9/7.txt").getLines().mkString.split("""\s+""").toList.filter {x => x match {
    case pattern(x) => false
    case _ => true
  }}
  println(result)
}