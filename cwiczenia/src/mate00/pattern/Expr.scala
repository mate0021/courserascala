package mate00.pattern

trait Expr {
  
  def eval: Int = {
    this match {
      case Number(n) => n
      case Sum(left, right) => left.eval + right.eval
      case Prod(left, right) => left.eval * right.eval
    }
  }
  
  def show: String = {
    this match {
      case Number(n) => n.toString
      case Sum(left, right) => left.show + " + " + right.show
      case Prod(left, right) => 
        left match {
          case Number(n) => n.toString
          case Sum(l, r) => "(" + l.show + " + " + r.show + ")"
        }
        right match {
          case Number(n) => n.toString
          case Sum(l, r) => "(" + l.show + " + " + r.show + ")"
        }
    }
  }
  
}

case class Number(n: Int) extends Expr {
}

case class Sum(left: Expr, right: Expr) extends Expr {
}

case class Prod(left: Expr, right: Expr) extends Expr {
}