package patmat

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

import patmat.Huffman._

@RunWith(classOf[JUnitRunner])
class HuffmanSuite extends FunSuite {
  trait TestTrees {
    val t1 = Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5)
    val t2 = Fork(Fork(Leaf('a',2), Leaf('b',3), List('a','b'), 5), Leaf('d',4), List('a','b','d'), 9)
  }

  test("weight of a larger tree") {
    new TestTrees {
      assert(weight(t1) === 5)
    }
  }

  test("chars of a larger tree") {
    new TestTrees {
      assert(chars(t2) === List('a','b','d'))
    }
  }

  test("string2chars(\"hello, world\")") {
    assert(string2Chars("hello, world") === List('h', 'e', 'l', 'l', 'o', ',', ' ', 'w', 'o', 'r', 'l', 'd'))
  }

  test("makeOrderedLeafList for some frequency table") {
    assert(makeOrderedLeafList(List(('t', 2), ('e', 1), ('x', 3))) === List(Leaf('e',1), Leaf('t',2), Leaf('x',3)))
  }

  test("combine of some leaf list") {
    val leaflist = List(Leaf('e', 1), Leaf('t', 2), Leaf('x', 4))
    assert(combine(leaflist) === List(Fork(Leaf('e',1),Leaf('t',2),List('e', 't'),3), Leaf('x',4)))
  }

  test("decode and encode a very short text should be identity") {
    new TestTrees {
      assert(decode(t1, encode(t1)("ab".toList)) === "ab".toList)
    }
  }
  
  test("Frequency split") {
    val word = string2Chars("scallaa")
    assert(times(word).contains(('s', 1)))
    assert(times(word).contains(('c', 1)))
    assert(times(word).contains(('a', 3)))
    assert(times(word).contains(('l', 2)))
  }
  
  test("until") {
    val sample = List(Leaf('g', 1), Leaf('s', 3), Leaf('a', 5))
    val expected = List(Fork(Fork(Leaf('g', 1), Leaf('s', 3), List('g', 's'), 4), Leaf('a', 5), List('g', 's', 'a'), 9))
    assert(until(singleton, combine)(sample) === expected)
  }
  
  test("decode gas") {
    val tree = Fork(Fork(Leaf('g', 1), Leaf('s', 3), List('g', 's'), 4), Leaf('a', 5), List('g', 's', 'a'), 9)
    val expected = "gas".toList
    assert(decode(tree, List(0, 0, 1, 0, 1)) === expected)
  }
  
  test("encode gas") {
    val tree = Fork(Fork(Leaf('g', 1), Leaf('s', 3), List('g', 's'), 4), Leaf('a', 5), List('g', 's', 'a'), 9)
    val expected = List(0, 0, 1, 0, 1)
    assert(encode(tree)("gas".toList) === expected)
  }
  
  test("quick encode gas") {
    val tree = Fork(Fork(Leaf('g', 1), Leaf('s', 3), List('g', 's'), 4), Leaf('a', 5), List('g', 's', 'a'), 9)
    val expected = List(0, 0, 1, 0, 1)
    assert(quickEncode(tree)("gas".toList) === expected)
  }
  
  test("trav") {
    val tree = Fork(Fork(Leaf('g', 1), Leaf('s', 3), List('g', 's'), 4), Leaf('a', 5), List('g', 's', 'a'), 9)
//    println(traverse(tree))
  }
  
}
