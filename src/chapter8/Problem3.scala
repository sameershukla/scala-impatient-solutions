package chapter8

object Problem3 extends App
{

  abstract class Employee(val name: String, val age: Int){
    val emptype = "Employee"
    override def toString = s"EmpType: $emptype"
    def salary : Double
  }
  
  class Manager(override val name: String, override val age: Int) extends Employee(name, age)
  {
    override val emptype = "Manager"  
    override def toString = s"$emptype"
    override def salary: Double = 200.00
    
  }
  
  class SoftwareEngineer(override val name: String, override val age: Int) extends Employee(name, age){
    override val emptype = "Software Engineer"
    override def toString = s"$emptype"
    override def salary: Double = 400.00
  }
  
  val employeeList = List(new Manager("Manager1", 45),new Manager("Manager2", 35), new SoftwareEngineer("Engineer1", 30))
  //find out the salary of the employees with employeetype
  for(x <- employeeList) println(x.emptype + " <->" + x.salary)
}