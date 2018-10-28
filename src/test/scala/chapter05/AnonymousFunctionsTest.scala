package chapter05

import org.scalatest.FunSuite

class AnonymousFunctionsTest extends FunSuite {
  val anonymousFunctions = new AnonymousFunctions()

  test("Sum ints should calculate correct result") {
    assert(anonymousFunctions.sumInts(1, 100) == 5050)
  }

  test("Sum squares should calculate correct result") {
    assert(anonymousFunctions.sumSquares(1, 5) == 55)
  }

}
