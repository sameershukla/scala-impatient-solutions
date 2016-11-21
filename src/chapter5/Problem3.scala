package chapter5

class Time(private var hour: Int = 0, private var mins: Int = 0) {

  def before(other: Time): Boolean = ((other.hour * 60) + other.mins) > ((hour * 60) + mins)

}

object Test3 extends App{
  val thistime = new Time(3,40)
  println(thistime.before(new Time(2,10)))
  println(thistime.before(new Time(4,10)))
}