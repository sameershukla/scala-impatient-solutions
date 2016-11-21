package chapter11

object Problem9 extends App {

  object RichFile {
    def unapply(path: String) = {
      if (path == "") None
      else {
        val (filepath, filename) = path.splitAt(path.lastIndexOf("/"))
        val (name, ext) = filename.splitAt(filename.lastIndexOf("."))
        Some((filepath, name.drop(1), ext))
      }
    }
  }

  val RichFile(filepath, name, ext) = "/home/ext/readme.txt"
  println(s"FilePath:$filepath :Name: $name :Ext:$ext")
}