package mate00.klasy

import java.util.ArrayList

object Main {

  def main(args: Array[String]) = {
    println("asdf")

    println(nth(5, (0 to 5).toList))
  }
  
  def nth[T](n: Int, elems: List[T]): T = {
    def loop(current: Int): T = {
      if (current >= elems.size) throw new IndexOutOfBoundsException("exceeded!")
      else if (current == n) elems(current)
      else loop(current + 1)
    }
    
    loop(0)
  }
}

