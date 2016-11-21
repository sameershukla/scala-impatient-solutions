package chapter7

package object random {
  
  private val a = 1664525
  private val b = 1013904223
  
  private var seed = 0
  def setSeed(seed : Int) = (this.seed = seed)  
  def nextInt() : Int = {
    seed = seed * a + b
    seed
  }
  def nextDouble() : Double = {
    1.0 / nextInt
  }

}
 

object Problem3 extends App
{

  import random._
  random.setSeed(100)
  println(random.nextInt())
  println(random.nextDouble())
}