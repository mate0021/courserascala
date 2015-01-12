package mate00.fold

object Folder {

  def main (args: Array[String]) {
    val l1 = List(1, 2, 3, 4)
    println(l1.foldLeft(0)(_ + _))
    
    println(l1.foldLeft(0)((x, y) => x + y))
  }
}