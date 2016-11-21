package chapter5

class Person(var age: Int = 0)
{
  var personAge = if(age < 0) 0 else age  
  age = personAge
}

object Test6 extends App{
  val p1 = new Person(5)
  println(p1.age)
  
  val p2 = new Person(-10)
  println(p2.age)
}