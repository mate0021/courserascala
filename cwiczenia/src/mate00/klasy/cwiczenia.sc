package mate00.klasy

object cwiczenia {
	val r1 = new Rational(1, 2)               //> asdf
                                                  //| r1  : mate00.klasy.Rational = 1/2
	val r2 = new Rational(5, 7)               //> asdf
                                                  //| r2  : mate00.klasy.Rational = 5/7
	val r3 = new Rational(3, 2)               //> asdf
                                                  //| r3  : mate00.klasy.Rational = 3/2
	
	r1.sub(r2).sub(r3)                        //> asdf
                                                  //| asdf
                                                  //| asdf
                                                  //| asdf
                                                  //| res0: mate00.klasy.Rational = 12/-7
	
	r1.add(new Rational(1, 2))                //> asdf
                                                  //| asdf
                                                  //| res1: mate00.klasy.Rational = 1/1
	
	def gcd (x: Int, y: Int): Int = {
		if (y == 0) x
		else gcd(y, x % y)
	}                                         //> gcd: (x: Int, y: Int)Int
	
	gcd(24, 64)                               //> res2: Int = 8
}