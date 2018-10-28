package chapter05

class SumExample {
  def sumIntsRepetitive(a: Int, b: Int): Int = {
    if (a > b) 0 else a + sumIntsRepetitive(a + 1, b)
  }

  def sumSquaresRepetitive(a: Int, b: Int): Int = {
    if (a > b) 0 else square(a) + sumIntsRepetitive(a + 1, b)
  }

  def sumPowersOfTwoRepetitive(a: Int, b: Int): Int = {
    if (a > b) 0 else powerOfTwo(a) + sumIntsRepetitive(a + 1, b)
  }


  def square(x: Int): Int = x * x
  def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)

  def id(x: Int): Int = x

  def sum(f: Int => Int, a: Int, b: Int): Int = {
    if (a > b) 0 else f(a) + sum(f, a + 1, b)
  }

  def sumInts(a: Int, b: Int): Int = sum(id, a, b)
  def sumSquares(a: Int, b: Int): Int = sum(square, a, b)
  def sumPowersOfTwo(a: Int, b: Int): Int = sum(powerOfTwo, a, b)
}
