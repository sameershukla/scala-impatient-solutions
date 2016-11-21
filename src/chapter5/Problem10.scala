package chapter5

class Employee {

  private var name: String = ""
  var salary: Double = 0.0

  def this(n: String, s: Double) {
    this()
    name = n
    salary = s
  }

  override def toString = s"Name: $name + :Salary:$salary"
}

object Test10 extends App {
  val e1 = new Employee
  println(e1)
  
  val e2 = new Employee("Sameer", 100000000)
  println(e2)
}