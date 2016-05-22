package kata.calc

import kata.calc.Calculator
import org.scalatest.{FlatSpec, Matchers}

class StringCalculatorTest extends FlatSpec with Matchers {

    it should " evaluate integer " in {
        Calculator.evaluate("100") shouldBe 100
    }

    it should " evaluate float number " in {
        Calculator.evaluate("100.21") shouldEqual (100.21 +- 0.01)
    }

    it should "evaluate addition" in {
        Calculator.evaluate("10+23") shouldBe 33
    }

    it should "evaluate subtraction" in {
        Calculator.evaluate("43-12") shouldBe 31
    }

    it should "evaluate multiplication" in {
        Calculator.evaluate("43.25×5") shouldBe 216.25
    }

    it should "evaluate division" in {
        Calculator.evaluate("54÷2") shouldBe 27
    }

    it should " evaluate number of different operations" in {
        Calculator.evaluate("453+43242-31.15+34×15-1521÷15") shouldBe 44072.45
    }
}
