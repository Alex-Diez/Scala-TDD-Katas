package org.stack

import org.scalatest.{BeforeAndAfter, FlatSpec, Matchers}

class StackTest extends FlatSpec with Matchers with BeforeAndAfter {

    var stack: Stack[Int] = Nil

    before {
        stack = new Stack[Int]
    }

    it should "create a new empty stack" in {
        pending
//        stack.size shouldBe 0
//        stack.isEmpty shouldBe true
    }

    it should "increase the stack size when push into it" in {
        pending
//        val oldSize = stack.size
//        stack.push(2)
//
//        oldSize should be < stack.size
    }

    it should "decrease the stack size when pop from it" in {
        pending
//        stack.push(1)
//        val oldSize = stack.size
//        stack.pop
//
//        oldSize should be > stack.size
    }

    it should "pop pushed value" in {
        pending
//        stack.push(2)
//        stack.pop shouldBe Some(2)
//
//        stack.push(5)
//        stack.pop shouldBe Some(5)
    }

    it should "pushed last pop first" in {
        pending
//        stack.push(20)
//        stack.push(30)
//        stack.push(10)
//        stack.push(50)
//
//        stack.pop shouldBe Some(50)
//        stack.pop shouldBe Some(10)
//        stack.pop shouldBe Some(30)
//        stack.pop shouldBe Some(20)
    }
}
