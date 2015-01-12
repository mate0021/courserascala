package mate00.highorder

object ListHigh {
  
  def square (xs: List[Int]): List[Int] = {
    xs match {
      case Nil => List()
      case x :: xtail => (x * x) :: square(xtail)
    }
  }
  
  def square_high (xs: List[Int]): List[Int] = 
    xs map (x => x * x)
  
  
  def pack[T] (xs: List[T]): List[List[T]] = {
    xs match {
      case Nil => Nil
      case x :: _ => { 
    	  val (first, last) = xs.span(e => e == x)
    	  first :: pack(last)
      }
    }
  }
  
  def encode[T] (xs: List[T]): List[(T, Int)] = {
    pack(xs).map (ys => (ys.head, ys.length))
  }
  
  
  
  
  def main (arg: Array[String]) = {
    val v1 = List(1, 2, 3)
    println(square(v1))
    println(square_high(v1))
    
    val v2 = List('a', 'a', 'a', 'b', 'b', 'c', 'c', 'a')
    println(pack(v2))
    println(encode(v2))
  }

}