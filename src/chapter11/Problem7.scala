package chapter11

object Problem7 extends App {

  class BitSequence {

    private var chunks: Long = 0

    def apply(index: Byte): Boolean = ((chunks & (1 << index)) > 0)
    def update(index: Byte, value: Boolean) {
      if (value)
        chunks |= (1 << index)
      else
        chunks &= ~(1 << index)
    }

  }

  val seq = new BitSequence()

  println(seq(15))
  seq(15) = true
  println(seq(15))
}