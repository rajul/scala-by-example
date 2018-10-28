package chapter05

import org.scalatest.FunSuite

class SumExampleTest extends FunSuite {
  val sumExample = new SumExample()

  test("Sum ints should calculate correct result") {
    assert(sumExample.sumInts(1, 100) == 5050)
  }

  test("Sum squares should calculate correct result") {
    assert(sumExample.sumSquares(1, 5) == 55)
  }

  test("Sum powers of two should calculate correct result") {
    assert(sumExample.sumPowersOfTwo(0, 2) == 7)
  }
}
