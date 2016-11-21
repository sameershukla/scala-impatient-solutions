package chapter5

class Person1(val name: String = "")
{
  val names = name.split(" ")
  val firstName = names(0)
  val lastName = names(1)
}

object Test7 extends App{
  val person = new Person1("Fred Smith")
  println(person.firstName)
  println(person.lastName)
}