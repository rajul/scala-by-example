package chapter04

object CallDifferenceExample {
  def first(x: Int, y: Int) = x // Call by value

  def constOne(x: Int, y: => Int) = x // Call by name
}
