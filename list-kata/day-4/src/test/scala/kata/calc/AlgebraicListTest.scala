package kata.calc

import org.scalatest.{FlatSpec, Matchers}

class AlgebraicListTest extends FlatSpec with Matchers {

    it should " create a new empty list " in {
        val list = AlgebraicList

        list.size shouldBe 0
        list.isEmpty shouldBe true
    }

    it should " add element at the front of list " in {
        var list: AlgebraicList = AlgebraicList

        list = 3 :: 2 :: 1 :: list

        list(0) shouldBe 3
        list(1) shouldBe 2
        list(2) shouldBe 1
        list.size shouldBe 3
    }

    ignore should " concatenate two lists " in {
        val listOne: AlgebraicList = 3 :: 2 :: 1 :: AlgebraicList
        val listTwo: AlgebraicList = 6 :: 5 :: 4 :: AlgebraicList

        val list = listTwo ::: listOne

        list shouldBe 6 :: 5 :: 4 :: 3 :: 2 :: 1 :: AlgebraicList
    }
}
