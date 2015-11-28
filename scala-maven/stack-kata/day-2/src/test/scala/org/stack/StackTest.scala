package org.stack

import org.scalatest.{BeforeAndAfter, FunSuite}

class StackTest extends FunSuite with BeforeAndAfter {

    var stack = new Stack(16)

    before {
        stack = new Stack(16)
    }

    test("pop from empty stack, should be empty Option") {
        assert(stack.pop == Option.empty)
    }

    test("push into full stack, should be false") {
        val stack = new Stack(0)
        assert(!stack.push(1))
    }

    test("pop pushed value") {
        stack.push(20)
        assert(stack.pop == Option.apply(20))
    }

    test("first pushed last pop") {
        stack.push(10)
        stack.push(30)
        assert(stack.pop == Option.apply(30))
        assert(stack.pop == Option.apply(10))
    }
}
