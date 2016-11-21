package chapter11

object Problem10 extends App {

  object RichFile {
    def unapplySeq(path: String) :Option[Seq[String]]  = {
      if(path == "") None else {
        if(path.startsWith("/")) Some(path.drop(1).split("/")) else  Some(path.split("/"))
      }
    }
  }

  val RichFile(first, middle, last) = "/home/ext/readme.txt"
  val RichFile(first1, middle1, last1) = "home/ext/readme.txt"
  
  println("First: %s, Middle: %s, Last: %s".format(first, middle, last))
  println("First: %s, Middle: %s, Last: %s".format(first1, middle1, last1))
}