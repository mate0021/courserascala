package mate00.listy

private object Concat extends App {
  
  def concat[T] (xs: List[T], ys: List[T]): List[T] = {
    xs match {
      case List() => ys
      case x :: xtail => x :: concat(xtail, ys)
    }
  }
  
  def reverse[T] (xs: List[T]): List[T] = {
    xs match {
      case List() => List()
      case x :: xtail => reverse(xtail) ++ List(x)
    }
  }
  
  def remove[T] (xs: List[T], n: Int): List[T] = {
    if (n > xs.length) xs
    else xs match {
      case List() => List()
      case x :: xtail => 
        if (n == 0) xtail
        else x :: remove(xtail, n - 1)
      						
    }
  }
  
  def remove_apiVer[T] (xs: List[T], n: Int): List[T] = {
    (xs take n) ::: (xs drop n + 1)
  }
  
  def merge (xs: List[Int], ys: List[Int]): List[Int] = {
    xs match {
      case Nil => ys
      case x :: xtail =>
        ys match {
          case Nil => xs
          case y :: ytail =>
            if (x < y) x :: merge(xtail, ys)
            else y :: merge(xs, ytail)
        }
    }
  }
  
  def merge_patmat(xs: List[Int], ys: List[Int]): List[Int] = {
    (xs, ys) match {
      case (Nil, y :: ytail) => ys
      case (x :: xtail, Nil) => xs
      case (x :: xtail, y :: ytail) =>
        if (x < y) x :: merge(xtail, ys)
        else y :: merge(xs, ytail)
    }
  }
  
  val l1 = List(1, 2, 3, 4)
  val l2 = List(6, 7, 8, 9)
  
  println(concat(l1, l2))
  
  println(reverse(l2))
  
  println(remove_apiVer(l2, 3))

  println(merge_patmat(l2, l1))
}