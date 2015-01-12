package mate00.funkcje

object cwiczenia {
  println("Welcome to the Scala worksheet")       //> Welcome to the Scala worksheet
  
  val c = new Cwiczenia                           //> c  : mate00.funkcje.Cwiczenia = mate00.funkcje.Cwiczenia@6acd5f8b
  
  c.sum(x => x * x)(1, 5)                         //> res0: Int = 55
  
  val k = new Kury                                //> k  : mate00.funkcje.Kury = mate00.funkcje.Kury@5c73a7ab
  
  def normalSum = k.sum(x => x)                   //> normalSum: => (Int, Int) => Int
  
  normalSum(1, 5)                                 //> res1: Int = 15
  
  def squareSum = k.sum(x => x * x)               //> squareSum: => (Int, Int) => Int
  
  squareSum(1, 5)                                 //> res2: Int = 55
  
  def normal(x: Int): Int = x                     //> normal: (x: Int)Int
  k.sum (normal) (1, 5)                           //> res3: Int = 15
  
  k.factorial(4)                                  //> res4: Int = 24
}