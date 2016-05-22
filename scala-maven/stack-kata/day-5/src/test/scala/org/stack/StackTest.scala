package org.stack

import org.scalatest.{BeforeAndAfter, Matchers, FunSuite}

class StackTest extends FunSuite with Matchers with BeforeAndAfter {

    var stack = new Stack[Int]

    before {
        stack = new Stack[Int]
    }

    test("a created stack should be empty") {
        stack.len shouldBe 0
        stack.isEmpty shouldBe true
    }

    test("push into stack should change the stack size") {
        stack.push(1)
        stack.push(1)
        stack.push(1)
        stack.len shouldBe 3
        stack.isEmpty shouldBe false
    }

    test("pop from stack should change the stack size") {
        stack.push(1)
        stack.push(1)
        stack.push(1)
        stack.pop
        stack.pop

        stack.len shouldBe 1
    }

    test("pushed e should be pop") {
        stack.push(10)
        stack.pop shouldBe Some(10)

        stack.push(20)
        stack.pop shouldBe Some(20)
    }

    test("pushed first should pop last") {
        stack.push(10)
        stack.push(20)

        stack.pop shouldBe Some(20)
        stack.pop shouldBe Some(10)
    }

    test("pop from empty stack should be None") {
        stack.pop shouldBe None
    }
}
