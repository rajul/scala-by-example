package chapter04

class TailRecursionExamples {
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def factorialNonTailRec(n: Int): Int = if (n == 0) 1 else n * factorialNonTailRec(n - 1)

  def factorial(n: Int): Int = {
    def factorialTailRec(x: Int, acc: Int): Int = {
      if(x == 0)
        acc
      else
        factorialTailRec(x-1, acc * x)
    }

    factorialTailRec(n, 1)
  }
}
