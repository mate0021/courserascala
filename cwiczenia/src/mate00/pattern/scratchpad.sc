package mate00.pattern

object scratchpad {
	val e1 = Number(1)                        //> e1  : mate00.pattern.Number = Number(1)
	val e2 = Number(2)                        //> e2  : mate00.pattern.Number = Number(2)
	val e4 = Number(4)                        //> e4  : mate00.pattern.Number = Number(4)
	val e5 = Number(5)                        //> e5  : mate00.pattern.Number = Number(5)
	
	val sum = Sum(e1, e2)                     //> sum  : mate00.pattern.Sum = Sum(Number(1),Number(2))
	sum.show                                  //> res0: String = 1 + 2
	sum.eval                                  //> res1: Int = 3
	
	val prod = Prod(Sum(e1, e5), e4)          //> prod  : mate00.pattern.Prod = Prod(Sum(Number(1),Number(5)),Number(4))
	prod.eval                                 //> res2: Int = 24
	prod.show                                 //> res3: String = 4
	
	val prod2 = Prod(e4, Sum(e1, e5))         //> prod2  : mate00.pattern.Prod = Prod(Number(4),Sum(Number(1),Number(5)))
	prod2.eval                                //> res4: Int = 24
	prod2.show                                //> res5: String = (1 + 5)
	
	for {
		i <- 1 until 7
		j <- 1 until i
		if (i+j > 10)
	} yield (i, j)                            //> res6: scala.collection.immutable.IndexedSeq[(Int, Int)] = Vector((6,5))
	
	List(1, 2, 2, 3).distinct                 //> res7: List[Int] = List(1, 2, 3)
	
	val l = List("qwree", "asd", "zxc")       //> l  : List[String] = List(qwree, asd, zxc)
	l.groupBy(_.length)                       //> res8: scala.collection.immutable.Map[Int,List[String]] = Map(5 -> List(qwree
                                                  //| ), 3 -> List(asd, zxc))
	
	val mapa = "Qweqwee".groupBy(x => x.toLower).mapValues(x => x.length)
                                                  //> mapa  : scala.collection.immutable.Map[Char,Int] = Map(e -> 3, w -> 2, q -> 
                                                  //| 2)
	
	for (s <- l) yield s                      //> res9: List[String] = List(qwree, asd, zxc)
	
	l.flatMap(x => x.toList)                  //> res10: List[Char] = List(q, w, r, e, e, a, s, d, z, x, c)
	
	
	val ll = List(1,2,3)                      //> ll  : List[Int] = List(1, 2, 3)
	for {
		x <- 1 until ll.size
	} yield x                                 //> res11: scala.collection.immutable.IndexedSeq[Int] = Vector(1, 2)
}