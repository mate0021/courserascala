package mate00.klasy

class Rational(x: Int, y: Int) {
  
  require(y != 0, "denominator should be non zero")
  
  println("asdf")
  
  def num = x / g
  
  def den = y / g
  
  def this(x: Int) = this(x, 1)
  
  def + (that: Rational) = {
    new Rational(num * that.den + that.num * den, den * that.den) 
  }
  
  def - (that: Rational) =  this + -that
  
  def unary_- = {
    new Rational(-num, den)
  }
  
  def < (that: Rational) = {
    num * that.den < that.num * den
  }
  
  def max (that: Rational) = {
    if (this < that) this
    else that
  }
  
  private def gcd (x: Int, y: Int): Int = 
    if (y == 0) x
    else gcd(y, x % y)
    
  private val g = gcd(x, y)
  
  override def toString = 
      num + "/" + den

}

