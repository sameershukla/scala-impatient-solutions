package chapter1

object Problems extends App
{

   //6.
   println(BigInt(2).pow(1024))
  
   //7.
   import BigInt.probablePrime
   import scala.util.Random
   probablePrime(100, Random)
   
   //8.
   println(BigInt(100, Random).toString(36))
   
   //9.
   val string = "abcdefghijk"
   println(string.take(1))
   println(string.drop(string.length()-1))
   
   //or
   println(string.head)
   println(string.last)
   
}