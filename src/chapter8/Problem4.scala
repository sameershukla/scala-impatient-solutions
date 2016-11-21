package chapter8

import scala.collection.mutable.ArrayBuffer

object Problem4 extends App {

  abstract class Item {
    def price: Double
    def description: String
  }

  class SimpleItem(override val price: Double, override val description: String) extends Item {

  }

  class Bundle extends Item {
    val items = new ArrayBuffer[Item]()
    def addItem(item: Item) = items += item

    def price: Double = (for (i <- items) yield i.price).sum
    def description: String = items.map { _.description }.mkString(",")
  }

  val bundle = new Bundle
  bundle.addItem(new SimpleItem(800, "iPhone"))
  bundle.addItem(new SimpleItem(900, "iPad"))
  
  println(bundle.price)
  println(bundle.description)
}