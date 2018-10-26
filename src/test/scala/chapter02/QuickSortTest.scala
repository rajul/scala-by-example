package chapter02

import org.scalatest.FunSuite

class QuickSortTest extends FunSuite {

  val quickSorter = new QuickSort()

  test("Check quicksort procedural correctly") {
    val a = Array(3, 1, 3, 4, 5)
    quickSorter.sortProcedural(a)


    assert(a(0) == 1)
    assert(a(1) == 3)
    assert(a(2) == 3)
    assert(a(3) == 4)
    assert(a(4) == 5)
  }
  test("Check quicksort procedural sorts correctly 2") {
    val a = Array(3, 1, 4, 2, 5, 1)
    quickSorter.sortProcedural(a)


    assert(a(0) == 1)
    assert(a(1) == 1)
    assert(a(2) == 2)
    assert(a(3) == 3)
    assert(a(4) == 4)
    assert(a(5) == 5)
  }

  test("Check quicksort functional sorts correctly") {
    val a = Array(3, 1, 3, 4, 5)
    val b = quickSorter.sortFunctional(a)

    assert(b(0) == 1)
    assert(b(1) == 3)
    assert(b(2) == 3)
    assert(b(3) == 4)
    assert(b(4) == 5)
  }

  test("Check quicksort funcational sorts correctly 2") {
    val a = Array(3, 1, 4, 2, 5, 1)
    val b = quickSorter.sortFunctional(a)


    assert(b(0) == 1)
    assert(b(1) == 1)
    assert(b(2) == 2)
    assert(b(3) == 3)
    assert(b(4) == 4)
    assert(b(5) == 5)
  }
}
