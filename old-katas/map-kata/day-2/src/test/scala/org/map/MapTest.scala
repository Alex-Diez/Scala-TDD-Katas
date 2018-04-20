package org.map

import org.scalatest.{FunSuite, Matchers}

class MapTest extends FunSuite with Matchers {

    test("it should create a new empty map") {
        val map = new Map

        map.size shouldBe 0
        map.isEmpty shouldBe true
    }

    test("it should increase size of the map if put into it") {
        val map = new Map
        val oldSize = map.size()
        map.put(1, 1)

        map.size shouldBe oldSize + 1
        map.isEmpty shouldBe false
    }

    test("it should decrease size of the map if remove from it") {
        val map = new Map
        map put(1, 1)
        val oldSize = map.size()
        map.remove(1)

        map.size shouldBe oldSize - 1
    }

    test("it should not increase size of the map if put the same key into map") {
        val map = new Map
        map.put(1, 1)
        val oldSize = map.size()
        map.put(1, 2)

        map.size() shouldBe oldSize
    }
}
