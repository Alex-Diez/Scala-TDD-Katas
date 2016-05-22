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

    test("evaluate three digit num") {
        assert(calc.evaluate("123") == 123)
    }

    test("evaluate real num") {
        assert(calc.evaluate("10.256") == 10.256)
    }

    test("evaluate add") {
        assert(calc.evaluate("1+2") == 3)
    }

    test("evaluate sub") {
        assert(calc.evaluate("2-1") == 1)
    }

    test("evaluate a few operation") {
        assert(calc.evaluate("2+3-1") == 4)
    }

    test("evaluate mul") {
        assert(calc.evaluate("2*5") == 10)
    }

    test("evaluate div") {
        assert(calc.evaluate("21/3") == 7)
    }

    test("evaluate a few operation with different priority") {
        assert(calc.evaluate("5+3*2-10/2") == 6)
    }

    test("evaluate expression with parenthesis") {
        assert(calc.evaluate("(5+3)*2-(10+4)/2") == 9)
    }

    test("evaluate expression with two level of parenthesis") {
        assert(calc.evaluate("(5+(3+6*2)-10)*2-(10+4)/2") == 13)
    }
}
