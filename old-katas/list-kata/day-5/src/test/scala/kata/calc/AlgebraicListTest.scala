package kata.calc

import org.scalatest.{FlatSpec, Matchers}

class AlgebraicListTest extends FlatSpec with Matchers {

    it should " create a new empty list " in {
        val list = AlgebraicList()

        list.size shouldBe 0
        list.isEmpty shouldBe true
    }

    it should " add element to front of the list " in {
        var list: AlgebraicList[Int] = AlgebraicList()

        list = 3 :: 2 :: 1 :: list

        list(0) shouldBe Some(3)
        list(1) shouldBe Some(2)
        list(2) shouldBe Some(1)
        list.size shouldBe 3
    }

    it should " return first element of list " in {
        val list = 3 :: 2 :: 1 :: AlgebraicList()

        list.head shouldBe Some(3)
        list.head shouldBe Some(3)
    }

    it should " return all elements without first " in {
        val list = 3 :: 2 :: 1 :: AlgebraicList()

        list.tail shouldBe Some(2 :: 1 :: AlgebraicList())
        list.tail shouldBe Some(2 :: 1 :: AlgebraicList())
    }
}
