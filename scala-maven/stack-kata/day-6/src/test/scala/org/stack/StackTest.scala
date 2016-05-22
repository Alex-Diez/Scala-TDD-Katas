package org.stack

import org.scalatest.{BeforeAndAfter, FunSuite, Matchers}

class StackTest extends FunSuite with Matchers with BeforeAndAfter {

    var stack = new Stack[Int](0)

    before {
        stack = new Stack[Int](20)
    }

    test("new stack should be empty") {
        stack.size shouldBe 0
        stack.isEmpty shouldBe true
    }

    test("push into stack should incise its size") {
        stack.push(1)

        stack.size shouldBe 1
        stack.isEmpty shouldBe false
    }

    test("pushed value should be pop") {
        stack.push(20)
        stack.pop shouldBe Some(20)

        stack.push(30)
        stack.pop shouldBe Some(30)
    }

    test("push first should be pop last") {
        stack.push(30)
        stack.push(40)
        stack.push(50)

        stack.pop shouldBe Some(50)
        stack.pop shouldBe Some(40)
        stack.pop shouldBe Some(30)
    }

    test("push into a 0-max size stack") {
        val stack = new Stack[Int](0)
        stack.push(20) shouldBe false
    }
}
