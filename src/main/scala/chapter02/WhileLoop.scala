package chapter02

class WhileLoop {
  def whileAlternativeImpl(p: => Boolean, s: => Unit): Unit = {
    if(p) {
      s
      whileAlternativeImpl(p, s)
    }
  }

}
