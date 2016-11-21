package chapter8

class BankAccount(initalBalance: Double) {
  private var balance = initalBalance
  def currentBalance = balance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

class CheckingAccount(initalBalance: Double, val fine: Double = 0) extends BankAccount(initalBalance) {
  override def deposit(amount : Double) = super.deposit(amount - fine)
  override def withdraw(amount: Double) = super.withdraw(amount - fine)
}