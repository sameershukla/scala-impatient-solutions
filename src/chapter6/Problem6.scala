package chapter6

import com.sun.tracing.Probe

object Problem6 extends Enumeration {
  val club = Value("♣")
  val diamond = Value("♦")
  val heart = Value("♥")
  val spade = Value("♠")
}

object Run extends App {
  println(Problem6.club)
  println(Problem6.diamond)
  println(Problem6.heart)
  println(Problem6.spade)
}