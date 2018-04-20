package org.stack

import org.scalatest.{BeforeAndAfter, Matchers, FunSuite}

class StackTest extends FunSuite with Matchers with BeforeAndAfter {

    var s = new Stack(16)

    before {
        s = new Stack(16)
    }

    test("created stack is empty") {
        s.isEmpty shouldBe true
    }

    test("push value into the stack, should not be empty") {
        s.push(1)
        s.isEmpty shouldBe false
    }

    test("pushed value should be pop from the stack") {
        s.push(1)
        s.pop shouldBe Option.apply(1)

        s.push(2)
        s.pop shouldBe Option.apply(2)
    }

    test("pop from empty stack, should be optional empty") {
        s.pop shouldBe Option.empty
    }

    test("push into a filled stack, should be false") {
        val s = new Stack(0)
        s.push(1) shouldBe false
    }

    test("first pushed value should be last pop") {
        s.push(20)
        s.push(30)

        s.pop shouldBe Option.apply(30)
        s.pop shouldBe Option.apply(20)
    }
}
