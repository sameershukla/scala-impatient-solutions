package chapter8

class BankAccount1(initalBalance: Double) {
  private var balance = initalBalance
  def currentBalance = balance
  def deposit(amount: Double) = { balance += amount; balance }
  def withdraw(amount: Double) = { balance -= amount; balance }
}

class CheckingAccount1(initalBalance: Double, val fine: Double = 0) extends BankAccount1(initalBalance) {
  override def deposit(amount: Double) = super.deposit(amount - fine)
  override def withdraw(amount: Double) = super.withdraw(amount - fine)
}

class SavingsAccount1(initialBalance: Double) extends CheckingAccount1(initialBalance) {

  private var freeTx: Int = 0

  override def deposit(amount: Double) = if (freeTx > 0) {
    freeTx -= 1
    super.deposit(amount)
  } else super.deposit(amount - fine)

  override def withdraw(amount: Double) = if (freeTx > 0) {
    freeTx -= 1
    super.withdraw(amount)
  } else {
    super.withdraw(amount - fine)
  }

  def earnMonthlyInterest(interest: Double) = {
    freeTx = 3
    super.deposit(interest)
  }
}

