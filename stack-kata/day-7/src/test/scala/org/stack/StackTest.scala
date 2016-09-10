package org.stack

import org.scalatest.{BeforeAndAfter, Matchers, FlatSpec}

class StackTest extends FlatSpec with Matchers with BeforeAndAfter {

    var stack = new Stack[Int](20)

    before {
        stack = new Stack[Int](20)
    }

    it should "be a new empty stack" in {
        stack.size shouldBe 0
        stack.isEmpty shouldBe true
    }

    it should "pop pushed value" in {
        stack.push(10)

        stack.pop shouldBe Some(10)
    }

    it should "increase size of stack when push into it" in {
        val oldSize = stack.size
        stack.push(2)
        stack.push(4)
        stack.push(3)

        stack.size should be > oldSize
    }

    it should "decrease size of stack when pop from it" in {
        stack.push(2)
        stack.push(4)
        stack.push(3)
        val oldSize = stack.size

        stack.pop
        stack.pop

        stack.size should be < oldSize
    }

    it should "pushed first pop last" in {
        stack.push(20)
        stack.push(30)
        stack.push(50)

        stack.pop shouldBe Some(50)
        stack.pop shouldBe Some(30)
        stack.pop shouldBe Some(20)
    }

    it should "pop None from an empty stack" in {
        stack.pop shouldBe None
    }

    it should "not push value into a 0-max size stack" in {
        val stack = new Stack[Int](0)
        stack.push(20) shouldBe false
    }
}
