package chapter5

class Car(val manufacturer: String, val model: String, val year: Int = -1, var license: String = "") {
  override def toString = s"Manufacturer: $manufacturer + : model: $model + :year: $year + :license: +$license"
}

object Test8 extends App{
  val c1 = new Car("Maruti", "Alto 800", 2013, "ABCD")
  println(c1)

  val c2 = new Car("Maruti", "Alto 800")
  println(c2)

  val c3 = new Car("Maruti", "Alto 800", 2013)
  println(c3)

}