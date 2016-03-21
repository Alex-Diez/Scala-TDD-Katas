package kata.list

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class AlgebraicListTest extends FlatSpec with Matchers with BeforeAndAfter {

  var list: AlgebraicList = AlgebraicList create

  before {
    list = AlgebraicList create
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
