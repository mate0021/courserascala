package funsets

import org.scalatest.FunSuite

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
 * This class is a test suite for the methods in object FunSets. To run
 * the test suite, you can either:
 *  - run the "test" command in the SBT console
 *  - right-click the file in eclipse and chose "Run As" - "JUnit Test"
 */
@RunWith(classOf[JUnitRunner])
class FunSetSuite extends FunSuite {


  /**
   * Link to the scaladoc - very clear and detailed tutorial of FunSuite
   *
   * http://doc.scalatest.org/1.9.1/index.html#org.scalatest.FunSuite
   *
   * Operators
   *  - test
   *  - ignore
   *  - pending
   */

  /**
   * Tests are written using the "test" operator and the "assert" method.
   */
  test("string take") {
    val message = "hello, world"
    assert(message.take(5) == "hello")
  }

  /**
   * For ScalaTest tests, there exists a special equality operator "===" that
   * can be used inside "assert". If the assertion fails, the two values will
   * be printed in the error message. Otherwise, when using "==", the test
   * error message will only say "assertion failed", without showing the values.
   *
   * Try it out! Change the values so that the assertion fails, and look at the
   * error message.
   */
  test("adding ints") {
    assert(1 + 2 === 3)
  }

  
  import FunSets._

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }
  
  /**
   * When writing tests, one would often like to re-use certain values for multiple
   * tests. For instance, we would like to create an Int-set and have multiple test
   * about it.
   * 
   * Instead of copy-pasting the code for creating the set into every test, we can
   * store it in the test class using a val:
   * 
   *   val s1 = singletonSet(1)
   * 
   * However, what happens if the method "singletonSet" has a bug and crashes? Then
   * the test methods are not even executed, because creating an instance of the
   * test class fails!
   * 
   * Therefore, we put the shared values into a separate trait (traits are like
   * abstract classes), and create an instance inside each test method.
   * 
   */

  trait TestSets {
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    
    val s12 = union(s1, s2)
    val s23 = union(s2, s3)
    
    val i1 = union(singletonSet(1), singletonSet(2))
    val i2 = union(singletonSet(2), singletonSet(3))
    
    val big1 = union(singletonSet(0), i1)
    val big2 = union(singletonSet(4), i2)
  }

  /**
   * This test is currently disabled (by using "ignore") because the method
   * "singletonSet" is not yet implemented and the test would fail.
   * 
   * Once you finish your implementation of "singletonSet", exchange the
   * function "ignore" by "test".
   */
  test("singletonSet(1) contains 1") {
    
    /**
     * We create a new instance of the "TestSets" trait, this gives us access
     * to the values "s1" to "s3". 
     */
    new TestSets {
      /**
       * The string argument of "assert" is a message that is printed in case
       * the test fails. This helps identifying which assertion failed.
       */
      assert(contains(s1, 1), "Singleton")
    }
  }

  test("union contains all elements") {
    new TestSets {
      val s = union(s1, s2)
      assert(contains(s, 1), "Union 1")
      assert(contains(s, 2), "Union 2")
      assert(!contains(s, 3), "Union 3")
    }
  }
  
  test("intersect contains common elements") {
    new TestSets {
      val result = intersect(s12, s23)
      assert(contains(result, 2))
      assert(!contains(result, 1))
    }
  }
  
  test("diff contains element only from one set") {
    new TestSets {
      val result = diff(s12, s23)
      assert(contains(result, 1))
      assert(!contains(result, 2))
    }
  }
  
  test("filtering") {
    new TestSets {
      val result = filter(s23, (x => x > 2))
      assert(contains(result, 3))
      assert(!contains(result, 2))
    }
  }
  
  test("filtering to empty") {
    new TestSets {
      val result = filter(s23, (x => x < 1))
      assert(!contains(result, 1))
      assert(!contains(result, 2))
      assert(!contains(result, 3))
    }
  }
  
  test("all ok") {
    new TestSets {
      val result = forall(big2, (x: Int) => x > 1)
      
      assert(result)
    }
  }
  
  test("one not ok") {
    new TestSets {
      val result = forall(big1, (x: Int) => x > 1)
      
      assert(!result)
    }
  }
  
  test("exists") {
    new TestSets {
      val result = exists(big2, (x: Int) => x < 3)
      
      assert(result)
    }
  }
  
  test("not exists") {
    new TestSets {
      val result = exists(big2, (x: Int) => x > 5)
      
      assert(!result)
    }
  }
  
  test("double map") {
    new TestSets {
      val result = map(big1, (x: Int) => x*2)
      assert(contains(result, 0))
      assert(contains(result, 2))
      assert(contains(result, 4))
      
      assert(!contains(result, 1))
    }
  }
  
  test("filter feedback") {
    val u1 = union(union(singletonSet(1), singletonSet(3)), union(singletonSet(4), singletonSet(5)));
    val res = union(union(singletonSet(7), singletonSet(1000)), u1);
//    printSet(result)
    
    val result = filter(res, (x: Int) => x < 5)
    assert(contains(result, 1))
    assert(contains(result, 3))
    assert(contains(result, 4))
    assert(!contains(result, 0), "0 not in set")
    
//    printSet(filter(result, (x: Int) => x < 5))
  }

}
