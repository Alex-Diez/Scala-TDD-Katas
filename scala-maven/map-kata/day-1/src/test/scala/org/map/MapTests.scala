package org.map

import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class MapTests extends FunSuite with Matchers with BeforeAndAfter {

    var map: Map = Nil

    before {
        map = new Map
    }

    test("create a new empty map") {
        map.size shouldBe 0
        map.isEmpty shouldBe true
    }

    test("size of map should increase when put into it") {
        val oldSize = map.size
        map.put(1, 1)

        map.isEmpty shouldBe false
        map.size shouldBe oldSize + 1
    }

    test("size of map should decrease when remove from it") {
        map.put(1, 1)
        val oldSize = map.size
        map.remove(1)

        map.size shouldBe oldSize - 1
    }

    test("find put value inside map") {
        map.put(1, 1)

        map.contains(1) shouldBe true

        map.put(2, 2)

        map.contains(2) shouldBe true
    }

    test("map should contains all put key into it") {
        map.put(1, 1)
        map.put(2, 1)
        map.put(3, 1)

        map.contains(1) shouldBe true
        map.contains(2) shouldBe true
        map.contains(3) shouldBe true
    }

    test("get put value into map") {
        map.put(1, 1)

        map.get(1) shouldBe Some(1)
        map.get(3) shouldBe None
    }
}
