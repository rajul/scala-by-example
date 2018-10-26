package chapter02

import org.scalatest.FunSuite

class WhileLoopTest extends FunSuite {
  val whileLoop = new WhileLoop()

  test("Test while repeats") {
    var a = 1
    whileLoop.whileAlternativeImpl(a < 5, {println(a); a = a + 1;})
    assert(a == 5)
  }
}
