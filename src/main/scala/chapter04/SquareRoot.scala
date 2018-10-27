package chapter04

import ExpressionsObject._

object SquareRoot {

  def isGoodEnough(guess: Double, x: Double): Boolean = abs(square(guess) - x) < 0.001

  // Exercise 4.4.1
  def isGoodEnoughBetter(guess: Double, x: Double): Boolean = {
    abs(square(guess) - x) / x < 0.001
  }

  def improve(guess: Double, x: Double): Double = (guess + x / guess) / 2

  def sqrtIter(guess: Double, x: Double): Double = {
    if (isGoodEnough(guess, x)) guess else sqrtIter(improve(guess, x), x)
  }

  def sqrt(x: Double) = sqrtIter(1.0, x)
}
