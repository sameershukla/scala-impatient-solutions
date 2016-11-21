package chapter10

object Problem3 extends App {

  trait CryptoLogger {
    def log(message: String)
  }

  trait CaesarLogger extends CryptoLogger {
    val shift: Int = 3
    abstract override def log(message: String) = {
      super.log(message.map(_ + shift).map(_.toChar).mkString)
    }
  }

  class ConsoleLogger extends CryptoLogger {
    def log(msg: String) = { println(msg) }
  }

  (new ConsoleLogger).log("Hello World")
  (new ConsoleLogger with CaesarLogger).log("Hello World")
  (new {
    override val shift: Int = -3
  } with ConsoleLogger with CaesarLogger).log("Hello World")
}