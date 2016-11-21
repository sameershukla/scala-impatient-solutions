package chapter11

import scala.collection.mutable.ArrayBuffer

object Problem5 extends App {

  class Table {
    private val ops = new ArrayBuffer[String]

    def |(op: String) = {
      ops += "<td>" + op + "</td>"
      this
    }

    def ||(op: String) = {
      ops += "<tr><td>" + op + "</td></tr>"
      this
    }

    override def toString = "<table><tr>" + ops.mkString + "</tr></table>"
  }

  object Table { def apply() = new Table() }

  println(Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM,.NET")

}