package chapter5

import scala.util.Success
import scala.util.Failure

class BankAccount{
  private var balance: Double = 0
  
  def deposit(amount: Double) = balance += amount
  def withdraw(amount: Double) = util.Try{if(amount <= balance) balance -= amount else throw new IllegalArgumentException("No sufficient balance to withdraw")}

  def total = balance
  
}

object Test extends App{
  val bank = new BankAccount
  bank.deposit(200)
  println(bank.total)
  bank.withdraw(150) match {
    case Success(_) => println(bank.total)
    case _ => println("Low Balance")
  }
  bank.withdraw(150) match {
    case Success(_) => println(bank.total)
    case Failure(x) => println(x.getMessage)
  }

}