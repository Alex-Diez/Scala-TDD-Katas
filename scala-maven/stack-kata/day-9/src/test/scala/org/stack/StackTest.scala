package org.stack

import org.scalatest.{BeforeAndAfter, Matchers, FlatSpec}

class StackTest extends FlatSpec with Matchers with BeforeAndAfter {

    var stack: Stack[Int] = Nil

    before {
        stack = new Stack[Int]
    }

    it should "create a new empty stack" in {
        stack.isEmpty shouldBe true
        stack.size shouldBe 0
    }

    it should "increase of the stack size when push into it" in {
        val oldSize = stack.size
        stack.push(1)

        stack.isEmpty shouldBe false
        stack.size shouldBe oldSize + 1
    }

    it should "decrease of the stack size when pop from it" in {
        stack.push(1)
        val oldSize = stack.size
        stack.pop

        stack.isEmpty shouldBe true
        stack.size shouldBe oldSize - 1
    }

    it should "pop pushed into stack value" in {
        stack.push(1)

        stack.pop shouldBe Some(1)

        stack.push(10)

        stack.pop shouldBe Some(10)
    }

    it should "pop first pushed last" in {
        stack.push(10)
        stack.push(20)
        stack.push(30)
        stack.push(40)

        stack.pop shouldBe Some(40)
        stack.pop shouldBe Some(30)
        stack.pop shouldBe Some(20)
        stack.pop shouldBe Some(10)
    }
}
