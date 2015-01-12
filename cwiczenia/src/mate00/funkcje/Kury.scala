package mate00.funkcje

class Kury {
  
  def sum (f: Int => Int): (Int, Int) => Int = {
    def curried (a: Int, b: Int): Int = {
      if (a > b) 0
      else f(a) + curried(a + 1, b)
    }
    curried
  }
  
  def product (f: Int => Int) (a: Int, b: Int): Int = {
    if (a > b) 1
    else f(a) * product(f)(a + 1, b)
  }
  
  def factorial (n: Int): Int = product(x => x)(1, n)

}