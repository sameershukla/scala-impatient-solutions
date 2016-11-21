package chapter7
import java.lang.System._

object Problem9 extends App
{

  val username = getProperty("user.name")
  val password = Console.readLine("password:");
  password match {
    case x if(x !="secret") => println(s"Error Invalid Password $password")
    case _ => println("Welcome %s!".format(username))
  }
  
}