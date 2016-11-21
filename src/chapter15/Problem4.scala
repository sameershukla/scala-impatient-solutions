package chapter15

import scala.annotation.varargs

class Problem4 {

  @varargs 
  def sum(x: Int*): Int = x.sum

}