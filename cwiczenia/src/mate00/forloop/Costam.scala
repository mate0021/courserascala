package mate00.forloop

object Costam extends App {

  def isPrime (n: Int): Boolean = {
    (2 until n).forall(a => (n % a) != 0)
  }
  

  
  println(isPrime(4))
}