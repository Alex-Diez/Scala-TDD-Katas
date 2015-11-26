package org.calc

import org.scalatest.{BeforeAndAfter, FunSuite}

class CalculatorTest extends FunSuite with BeforeAndAfter {

    var calc = new Calculator

    before {
        calc = new Calculator
    }

    test("evaluate simple num") {
        assert(calc.evaluate("1") == 1)
    }

    test("evaluate four digit num") {
        assert(calc.evaluate("1245") == 1245)
    }

    test("evaluate real num") {
        assert(calc.evaluate("15.265") == 15.265)
    }

    test("evaluate add") {
        assert(calc.evaluate("5+6") == 11)
    }

    test("evaluate sub") {
        assert(calc.evaluate("5-3") == 2)
    }

    test("evaluate a few operation") {
        assert(calc.evaluate("5+8-3+4-9") == 5)
    }

    test("evaluate mul") {
        assert(calc.evaluate("5*2") == 10)
    }

    test("evaluate div") {
        assert(calc.evaluate("15/3") == 5)
    }

    test("evaluate operation with different priority") {
        assert(calc.evaluate("5+6*2-10/5-3") == 12)
    }

    test("evaluate expressions with parentheses") {
        assert(calc.evaluate("5+(10-2*3)-4+(20-10/2)") == 20)
    }

    test("evaluate expressions with two level parentheses") {
        assert(calc.evaluate("5+(10-(1+3)*3)-4+(20-(10-2)/2)") == 15)
    }
}
