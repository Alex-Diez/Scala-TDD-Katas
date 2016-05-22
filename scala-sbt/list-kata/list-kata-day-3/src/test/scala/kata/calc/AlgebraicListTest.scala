package kata.calc

import org.scalatest.{FlatSpec, Matchers}

class AlgebraicListTest extends FlatSpec with Matchers {

    it should " create a new empty list " in {
        val list = new AlgebraicList()

        list.size shouldBe 0
        list.isEmpty shouldBe true
    }

    it should " add elements at the front of a list " in {
        val list = new AlgebraicList()

        val l = 3 :: 2 :: 1 :: list

        l.size shouldBe 3
        l(0) shouldBe 3
        l(1) shouldBe 2
        l(2) shouldBe 1
    }

    it should " concatenate two lists " in {
        val listOne = 3 :: 2 :: 1 :: new AlgebraicList()
        val listTwo = 6 :: 5 :: 4 :: new AlgebraicList()

        val concat = listTwo ::: listOne

        concat shouldBe 6 :: 5 :: 4 :: 3 :: 2 :: 1 :: new AlgebraicList()
    }
}
