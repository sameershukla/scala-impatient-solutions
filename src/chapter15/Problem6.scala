package chapter15

object Field {
  @volatile var bool: Boolean = false
}

object Producer extends Runnable {

  override def run() {
    Thread.sleep(1000)
    Field.bool = true
  }

}

object Consumer extends Runnable {
  override def run() {
    while (!Field.bool) {
      Thread.sleep(100);
    }
    println("Field is true, finish trying")
  }
}

object Problem6 extends App {
  val producer = new Thread(Producer, "PRODUCER")
  val consumer = new Thread(Consumer, "CONSUMER")

  producer.start()
  consumer.start()
}
  

