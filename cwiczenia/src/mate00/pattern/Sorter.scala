package mate00.pattern

object Sorter extends App {

  def insert (x: Int, xs: List[Int]): List[Int] = {
    xs match {
      case List() => List(x)
      case y :: ys => if (x < y) x :: insert(y, ys)
      else y :: insert(x, ys)
    }
  }
  
  def sort (list: List[Int]): List[Int] = {
    list match {
      case List() => List()
      case x :: xs => insert(x, sort(xs))
    }
  }
  
  println(sort(List(4, 1, 6, 7, 2)))
}