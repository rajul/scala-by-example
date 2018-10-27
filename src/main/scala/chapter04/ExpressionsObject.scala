package chapter04

object ExpressionsObject {
  def square(x: Double) = x * x
  def sumOfSquares(x: Double, y: Double) = square(x) + square(y)

  def abs(x: Double) = if(x >= 0) x else -x
}
