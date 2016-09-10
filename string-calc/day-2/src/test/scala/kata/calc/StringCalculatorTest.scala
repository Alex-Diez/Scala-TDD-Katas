package kata.calc

import kata.calc.Calculator.evaluate
import org.scalatest.{FlatSpec, Matchers}

class StringCalculatorTest extends FlatSpec with Matchers {

    it should " evaluate integer number " in {
        evaluate("123") shouldBe 123
    }

    it should " evaluate float number" in {
        evaluate("123.123") shouldBe 123.123
    }

    it should " evaluate addition " in {
        evaluate("23.4+12.6") shouldBe 36
    }

    it should " evaluate subtraction " in {
        evaluate("2365.234-213.657") shouldBe 2151.577 +- 0.001
    }

    it should " evaluate multiplication " in {
        evaluate("3243×14") shouldBe 45402
    }

    it should " evaluate division " in {
        evaluate("435÷5") shouldBe 87
    }
}
