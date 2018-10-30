package chapter05

class Currying {
  def powerOfTwo(x: Int): Int = if (x == 0) 1 else 2 * powerOfTwo(x - 1)

  def sum1(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = {
      if(a > b) 0
      else f(a) + sumF(a+1, b)
    }

    sumF
  }

  val sumInts1 = sum1(x => x)
  val sumSquares1 = sum1(x => x*x)
  val sumPowersOfTwo1 = sum1(powerOfTwo)


  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    if(a > b) 0
    else f(a) + sum(f)(a+1, b)
  }

  val sumInts = sum(x => x)
  val sumSquares = sum(x => x*x)
  val sumPowersOfTwo = sum(powerOfTwo)
}
