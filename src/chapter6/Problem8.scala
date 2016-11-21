package chapter6

object RGB extends Enumeration {
  val Black = Value(0x000000)
  val Red = Value(0xFF0000)
  val Green = Value(0x00FF00)
  val Blue = Value(0x0000FF)
  val Yellow = Value(0xFFFF00)
  val Magenta = Value(0xFF00FF)
  val Cyan = Value(0x00FFFF)
  val White = Value(0xFFFFFF)
}

object Run2 extends App{
  for(v <- RGB.values) println(v.id, v)
}