package chapter11

object Problem6 extends App {

  class ASCIIArt(val content: String) {

    def +(that: ASCIIArt) = new ASCIIArt(
      this.content.split("\n").zip(that.content.split("\n")).map(x => x._1 + x._2).mkString("\n"))

    def ^(that: ASCIIArt) = new ASCIIArt(content + that.content)

    override def toString = content
  }

  val x = new ASCIIArt(
    """ /\_/\ 
( ' ' )
(  -  )
 | | | 
(__|__)""")

  val y = new ASCIIArt(
    """   -----
 / Hello \
<  Scala |
 \ Coder /
   -----""")

  println(x + y)
  println(x ^ y)
}