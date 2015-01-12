package mate00.trees

object cwiczenia {

	val emptyTree = Empty                     //> emptyTree  : mate00.trees.Empty.type = o
	
	val t1 = emptyTree include 3              //> t1  : mate00.trees.IntSet = [o-3-o]
	
	val t2 = t1 include 12                    //> t2  : mate00.trees.IntSet = [o-3-[o-12-o]]
	
	val t3 = t2 include 1                     //> t3  : mate00.trees.IntSet = [[o-1-o]-3-[o-12-o]]
	
	val t4 = t1 include 1                     //> t4  : mate00.trees.IntSet = [[o-1-o]-3-o]
	
	val t5 = ((Empty include 5) include 7) include 3
                                                  //> t5  : mate00.trees.IntSet = [[o-3-o]-5-[o-7-o]]
	
	val t6 = ((Empty include 12) include 8) include 15
                                                  //> t6  : mate00.trees.IntSet = [[o-8-o]-12-[o-15-o]]
  
  t5 union t6                                     //> res0: mate00.trees.IntSet = [[[o-3-[[o-5-o]-7-o]]-8-o]-12-[o-15-o]]
}