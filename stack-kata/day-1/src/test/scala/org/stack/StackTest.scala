package org.stack

import org.scalatest.{BeforeAndAfter, FunSuite}

class StackTest extends FunSuite with BeforeAndAfter {

    var stack = new Stack[Int](10)

    before {
        stack = new Stack(10)
    }

    test("pop from empty stack, should return NONE") {
        assert(stack.pop == Option.empty)
    }

    test("push element in filled stack, should return false") {
        val stack = new Stack[Int](0)
        assert(!stack.push(1))
    }

    test("pushed element should be pop") {
        stack.push(20)
        assert(stack.pop == Option.apply(20))
    }

    test("first pushed should be last pop") {
        stack.push(30)
        stack.push(50)
        assert(stack.pop == Option.apply(50))
        assert(stack.pop == Option.apply(30))
    }
}
