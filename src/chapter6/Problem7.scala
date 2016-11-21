package chapter6

object Suits extends Enumeration {
  type Suits = Value
  val Spade = Value("♠")
  val Club = Value("♣")
  val Heart = Value("♥")
  val Diamond = Value("♦")
  def isRed(card: Suits) = card == Heart
}

object Run1 extends App {
  println(Problem6.club)
  println(Problem6.diamond)
  println(Problem6.heart)
  println(Problem6.spade)

  println(for(s <- Suits.values) yield (s, Suits.isRed(s)))
}