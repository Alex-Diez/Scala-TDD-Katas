package org.stack

import org.scalatest.{Matchers, FunSuite}

class StackTest extends FunSuite with Matchers {

    test("create a stack") {
        new Stack
    }

    test("created stack has to be empty") {
        (new Stack).isEmpty shouldBe true
    }

    test("pushed element should be pop") {
        val stack = new Stack[Int]
        stack.push(2)
        stack.pop shouldBe Some(2)

        stack.push(20)
        stack.pop shouldBe Some(20)
    }

    test("pushed first should be pop the last") {
        val stack = new Stack[Int]
        stack.push(3)
        stack.push(10)

        stack.pop shouldBe Some(10)
        stack.pop shouldBe Some(3)
    }
}
