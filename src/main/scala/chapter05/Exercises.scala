package chapter05

class Exercises {
  def sum(f: Int => Int)(a: Int, b: Int): Int = {
    def iter(a: Int, result: Int): Int = {
      if(a > b) result
      else iter(a+1, result + a)
    }

    iter(a, 0)
  }


  def product(f: Int => Int)(a: Int, b: Int): Int = {
    def iter(a: Int, result: Int): Int = {
      if(a > b) result
      else iter(a + 1, result * a)
    }

    iter(a, 1)
  }

  def factorial(n: Int) = product(x => x)(1, n)


  def operation(op: (Int, Int) => Int)(f: Int => Int)(initialValue: Int)(a: Int, b: Int): Int = {
    def iter(a: Int, result: Int): Int = {
      if(a > b) result
      else iter(a + 1, op(result, a))
    }

    iter(a, initialValue)
  }

  def sum1 = operation((x, y) => x + y)(z => z)(0)
  def product1 = operation((x, y) => x * y)(z => z)(1)
}
