package kata.list

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class Day1ListTest extends FlatSpec with Matchers with BeforeAndAfter {

  var list: Day1List = Day1List create

  before {
    list = Day1List create
  }

  it should "create a new empty list" in {
    list.size shouldBe 0
    list.isEmpty shouldBe true
  }

  it should "add element to list front" in {
    list = 3 :: 2 :: 1 :: list

    list(0) shouldBe 3
    list(1) shouldBe 2
    list(2) shouldBe 1
    list.size shouldBe 3
  }
}
