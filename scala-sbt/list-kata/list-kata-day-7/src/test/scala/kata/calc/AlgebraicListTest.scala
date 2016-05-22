package kata.calc

import org.scalatest.{FlatSpec, Matchers}

class AlgebraicListTest extends FlatSpec with Matchers {

    it should " create a new empty list " in {
        val list = AlgebraicList()

        list.size shouldBe 0
        list.isEmpty shouldBe true
    }

    it should " add new element to front of list " in {
        var list: AlgebraicList[Int] = AlgebraicList()
        list = 1 :: list

        list(0) shouldBe Some(1)
        list.size shouldBe 1
    }

    it should " add new elements to front of list " in {
        var list: AlgebraicList[Int] = AlgebraicList()
        list = 3 :: 2 :: 1 :: list

        list(0) shouldBe Some(3)
        list(1) shouldBe Some(2)
        list(2) shouldBe Some(1)
        list.size shouldBe 3
    }

    it should " concatenate two lists " in {
        val listOne = 3 :: 2 :: 1 :: AlgebraicList()
        val listTwo = 6 :: 5 :: 4 :: AlgebraicList()

        val list = listTwo ::: listOne

        list shouldBe 6 :: 5 :: 4 :: 3 :: 2 :: 1 :: AlgebraicList()
    }
}
